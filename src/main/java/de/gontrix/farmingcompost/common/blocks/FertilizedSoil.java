package de.gontrix.farmingcompost.common.blocks;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class FertilizedSoil extends Block {
    public FertilizedSoil() {
        super(AbstractBlock.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(0.5f, 0.5f).harvestLevel(0).harvestTool(ToolType.SHOVEL));
    }

    public static FertilizedSoil getFertilizedSoil() {
        Blocks.fertilizedSoil = new FertilizedSoil();
        Blocks.fertilizedSoil.setRegistryName(FarmingCompost.MODID, de.gontrix.farmingcompost.common.items.FertilizedSoil.NAME);

        return Blocks.fertilizedSoil;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            if (player.getHeldItem(handIn).getToolTypes().contains(ToolType.HOE)) {
                if (!worldIn.getBlockState(pos.up(1)).isSolid()) {
                    worldIn.setBlockState(pos, Blocks.fertilizedField.getDefaultState());

                    return ActionResultType.SUCCESS;
                }
            }
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
