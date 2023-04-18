package de.gontrix.farmingcompost.common.items;

import de.gontrix.farmingcompost.common.blocks.Blocks;
import net.minecraft.world.item.BlockItem;

public class FertilizedFieldItem extends BlockItem {
    public static final int MAXIMUM_STACK_SIZE = 64;

    public FertilizedFieldItem() {
        super(Blocks.FERTILIZED_FIELD.get(), new BlockItem.Properties().stacksTo(MAXIMUM_STACK_SIZE));
    }

}
