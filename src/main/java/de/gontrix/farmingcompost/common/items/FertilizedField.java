package de.gontrix.farmingcompost.common.items;

import de.gontrix.farmingcompost.common.FarmingCompostItemGroup;
import de.gontrix.farmingcompost.common.blocks.Blocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class FertilizedField extends BlockItem {
    public static final int MAXIMUM_STACK_SIZE = 64;
    public static final String NAME = "fertilized_field";

    public FertilizedField(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    public static FertilizedField getFertilizedField() {
        Items.fertilizedField = new FertilizedField(Blocks.fertilizedField, new Item.Properties().maxStackSize(MAXIMUM_STACK_SIZE).group(FarmingCompostItemGroup.farmingCompost));
        Items.fertilizedField.setRegistryName(Blocks.fertilizedField.getRegistryName());

        return Items.fertilizedField;
    }
}
