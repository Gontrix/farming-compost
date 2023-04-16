package de.gontrix.farmingcompost.common.blocks;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class FertilizedSoil extends Block {
    public FertilizedSoil() {
        super(Block.Properties.copy(net.minecraft.world.level.block.Blocks.DIRT));
        FarmingCompost.LOGGER.info("FarmingCompost FertilizedSoil");
//        super(AbstractBlock.Properties.create(Material.EARTH).sound(SoundType.ROOTED_DIRT).hardnessAndResistance(0.5f, 0.5f).harvestLevel(0).harvestTool(ToolType.SHOVEL));
    }

    public static RegistryObject<Block> getFertilizedSoil() {
        FarmingCompost.LOGGER.info("FarmingCompost getFertilizedSoil");
        return Blocks.BLOCKS.register(de.gontrix.farmingcompost.common.items.FertilizedSoil.NAME, FertilizedSoil::new);
    }

//    @Override
//    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
//        if (!worldIn.isRemote) {
//            if (player.getHeldItem(handIn).getToolTypes().contains(ToolType.HOE)) {
//                if (!worldIn.getBlockState(pos.up(1)).isSolid()) {
//                    worldIn.setBlockState(pos, Blocks.fertilizedField.getDefaultState());
//
//                    return ActionResultType.SUCCESS;
//                }
//            }
//        }
//
//        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
//    }
}
