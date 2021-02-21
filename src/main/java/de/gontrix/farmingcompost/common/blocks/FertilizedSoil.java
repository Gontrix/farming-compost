package de.gontrix.farmingcompost.common.blocks;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FertilizedSoil extends Block {
    public FertilizedSoil() {
        super(AbstractBlock.Properties.create(Material.EARTH));
    }

    public static FertilizedSoil getFertilizedSoil() {
        Blocks.fertilizedSoil = new FertilizedSoil();
        Blocks.fertilizedSoil.setRegistryName(FarmingCompost.MODID, de.gontrix.farmingcompost.common.items.FertilizedSoil.NAME);

        return Blocks.fertilizedSoil;
    }
}
