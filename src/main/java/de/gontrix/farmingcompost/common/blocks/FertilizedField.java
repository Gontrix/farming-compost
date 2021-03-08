package de.gontrix.farmingcompost.common.blocks;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class FertilizedField extends Block {
    private static final Vector3d BASE_MIN_CORNER = new Vector3d(0.0, 0.0, 0.0);
    private static final Vector3d BASE_MAX_CORNER = new Vector3d(16.0, 15.0, 16.0);

    private static final VoxelShape SHAPE = Block.makeCuboidShape(
            BASE_MIN_CORNER.getX(), BASE_MIN_CORNER.getY(), BASE_MIN_CORNER.getZ(),
            BASE_MAX_CORNER.getX(), BASE_MAX_CORNER.getY(), BASE_MAX_CORNER.getZ()
    );


    public FertilizedField() {
        super(AbstractBlock.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(0.5f, 0.5f).harvestLevel(0).harvestTool(ToolType.SHOVEL));
    }


    public static FertilizedField getFertilizedField() {
        Blocks.fertilizedField = new FertilizedField();
        Blocks.fertilizedField.setRegistryName(FarmingCompost.MODID, de.gontrix.farmingcompost.common.items.FertilizedField.NAME);

        return Blocks.fertilizedField;
    }


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }


    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isRemote) {
            if (pos.up(1).getY() == fromPos.getY() && worldIn.getBlockState(fromPos).isSolid()) {
                worldIn.setBlockState(pos, Blocks.fertilizedSoil.getDefaultState());
            }
        }

        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
    }

}
