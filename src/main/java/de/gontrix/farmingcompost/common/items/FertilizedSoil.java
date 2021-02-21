package de.gontrix.farmingcompost.common.items;

import de.gontrix.farmingcompost.common.blocks.Blocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class FertilizedSoil extends BlockItem {
    public static final int MAXIMUM_STACK_SIZE = 64;
    public static final String NAME = "fertilized_soil";

    public FertilizedSoil(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    public static FertilizedSoil getFertilizedSoil() {
        Items.fertilizedSoil = new FertilizedSoil(Blocks.fertilizedSoil, new Item.Properties().maxStackSize(MAXIMUM_STACK_SIZE).group(ItemGroup.BUILDING_BLOCKS));
        Items.fertilizedSoil.setRegistryName(Blocks.fertilizedSoil.getRegistryName());

        return Items.fertilizedSoil;
    }
}
