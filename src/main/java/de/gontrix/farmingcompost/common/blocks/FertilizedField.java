package de.gontrix.farmingcompost.common.blocks;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

public class FertilizedField extends Block {
//    private static final Vector3d BASE_MIN_CORNER = new Vector3d(0.0, 0.0, 0.0);
//    private static final Vector3d BASE_MAX_CORNER = new Vector3d(16.0, 15.0, 16.0);
//
//    private static final VoxelShape SHAPE = Block.makeCuboidShape(
//            BASE_MIN_CORNER.getX(), BASE_MIN_CORNER.getY(), BASE_MIN_CORNER.getZ(),
//            BASE_MAX_CORNER.getX(), BASE_MAX_CORNER.getY(), BASE_MAX_CORNER.getZ()
//    );


    public FertilizedField() {
        super(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.DIRT));
        FarmingCompost.LOGGER.info("FarmingCompost FertilizedField");
//        super(AbstractBlock.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(0.5f, 0.5f).harvestLevel(0).harvestTool(ToolType.SHOVEL));
    }


    public static RegistryObject<Block> getFertilizedField() {
        FarmingCompost.LOGGER.info("FarmingCompost getFertilizedField");
        return Blocks.BLOCKS.register(de.gontrix.farmingcompost.common.items.FertilizedField.NAME, FertilizedField::new);
    }


//    @Override
//    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
//        return SHAPE;
//    }
//
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
