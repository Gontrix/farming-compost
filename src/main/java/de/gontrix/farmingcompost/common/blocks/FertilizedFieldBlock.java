package de.gontrix.farmingcompost.common.blocks;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FertilizedFieldBlock extends Block {
    public static final String NAME = "fertilized_field";

    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);


    public FertilizedFieldBlock() {
        super(BlockBehaviour.Properties.of(Material.DIRT));
        FarmingCompost.LOGGER.info("FarmingCompost FertilizedField");
//        super(AbstractBlock.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(0.5f, 0.5f).harvestLevel(0).harvestTool(ToolType.SHOVEL));
    }


    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

//
//    @Override
//    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
//        if (!worldIn.isRemote) {
//            if (pos.up(1).getY() == fromPos.getY() && worldIn.getBlockState(fromPos).isSolid()) {
//                worldIn.setBlockState(pos, Blocks.fertilizedSoil.getDefaultState());
//            }
//        }
//
//        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
//    }

}
