package de.gontrix.farmingcompost.common.items;

import de.gontrix.farmingcompost.common.blocks.Blocks;
import net.minecraft.world.item.BlockItem;

public class CompostItem extends BlockItem {
    public static final int MAXIMUM_STACK_SIZE = 16;

    public CompostItem() {
        super(Blocks.COMPOST.get(), new BlockItem.Properties().stacksTo(MAXIMUM_STACK_SIZE));
    }
}
