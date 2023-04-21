package de.gontrix.farmingcompost.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.NotNull;

public class FertilizedFieldBlock extends Block {
    public static final String NAME = "fertilized_field";

    public static IntegerProperty MOISTURE = BlockStateProperties.MOISTURE;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);


    public FertilizedFieldBlock() {
        super(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT)
                .randomTicks()
                .strength(0.6F)
                .sound(SoundType.GRAVEL)
        );
        this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(MOISTURE);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return SHAPE;
    }

    public boolean isFertile(BlockState state, BlockGetter level, BlockPos pos) {
        return  true;
    }

    @Override
    public boolean canSustainPlant(BlockState blockState, @NotNull BlockGetter world, BlockPos pos, @NotNull Direction facing, net.minecraftforge.common.IPlantable plantable) {
        PlantType type = plantable.getPlantType(world, pos.relative(facing));
        int i = blockState.getValue(MOISTURE);

        if (PlantType.CROP.equals(type)) {
            return i > 0;
        }

        return false;
    }

    @Override
    public void randomTick(BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        int i = blockState.getValue(MOISTURE);

        if (!isNearWater(serverLevel, blockPos) && !serverLevel.isRainingAt(blockPos.above())) {
            if (i > 0) {
                serverLevel.setBlock(blockPos, blockState.setValue(MOISTURE, i - 1), 2);
            } else if (!isUnderCrops(serverLevel, blockPos)) {
                turnToSoil(blockState, serverLevel, blockPos);
            }

        } else if (i < 7) {
            serverLevel.setBlock(blockPos, blockState.setValue(MOISTURE, i + 1), 2);
        }

        growExtra(serverLevel, blockPos, randomSource);
    }

    private static void growExtra(ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        BlockPos cropPos = blockPos.offset(0, +1, 0);
        BlockState cropState = serverLevel.getBlockState(cropPos);

        if (cropState.getBlock() instanceof CropBlock cropBlock) {
            if (cropBlock.isRandomlyTicking(cropState)) {
                cropBlock.randomTick(cropState, serverLevel, cropPos, randomSource);
            }
        }
    }

    private static boolean isUnderCrops(BlockGetter blockGetter, BlockPos blockPos) {
        BlockState plant = blockGetter.getBlockState(blockPos.above());
        BlockState state = blockGetter.getBlockState(blockPos);

        return plant.getBlock() instanceof net.minecraftforge.common.IPlantable && state.canSustainPlant(blockGetter, blockPos, Direction.UP, (net.minecraftforge.common.IPlantable)plant.getBlock());
    }

    private static boolean isNearWater(LevelReader levelReader, BlockPos blockPos) {
        BlockState state = levelReader.getBlockState(blockPos);

        for(BlockPos blockpos : BlockPos.betweenClosed(
            blockPos.offset(-4, -1, -4),
            blockPos.offset(4, 1, 4)
        )) {
            if (state.canBeHydrated(levelReader, blockPos, levelReader.getFluidState(blockpos), blockpos)) {
                return true;
            }
        }

        return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(levelReader, blockPos);
    }

    public static void turnToSoil(BlockState blockState, Level level, BlockPos blockPos) {
        BlockState blockstate = pushEntitiesUp(blockState, Blocks.FERTILIZED_SOIL.get().defaultBlockState(), level, blockPos);

        level.setBlockAndUpdate(blockPos, blockstate);
        level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(null, blockstate));
    }

    @Override
    public boolean isPathfindable(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull PathComputationType pathComputationType) {
        return false;
    }
}
