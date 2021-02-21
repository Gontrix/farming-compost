package de.gontrix.farmingcompost.common.blocks;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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
}
