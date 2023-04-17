package de.gontrix.farmingcompost.common.blocks;

import de.gontrix.farmingcompost.FarmingCompost;
import de.gontrix.farmingcompost.common.items.FertilizedSoilItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class FertilizedSoilBlock extends Block {
    public static final String NAME = "fertilized_soil";

    public FertilizedSoilBlock() {
        super(Block.Properties.copy(net.minecraft.world.level.block.Blocks.DIRT));
        FarmingCompost.LOGGER.info("FarmingCompost FertilizedSoil");
//        super(AbstractBlock.Properties.create(Material.EARTH).sound(SoundType.ROOTED_DIRT).hardnessAndResistance(0.5f, 0.5f).harvestLevel(0).harvestTool(ToolType.SHOVEL));
    }

//    @Override
//    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
//        FarmingCompost.LOGGER.info("FarmingCompost InteractionResult");
//        ItemStack held = player.getItemInHand(hand);
//
//        if (!world.isClientSide() && held.canPerformAction(ToolActions.HOE_DIG)){
//            FarmingCompost.LOGGER.info("FarmingCompost canPerformAction");
////            world.explode(player, pos.getX(), pos.getY(), pos.getZ(), 4.0F, true, Explosion.Mode.DESTROY);
////            held.shrink(1);
//            return InteractionResult.SUCCESS;
//        }
//
//        return super.use(state, world, pos, player, hand, hit);
//    }

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
