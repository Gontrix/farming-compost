package de.gontrix.farmingcompost.common.items;

import net.minecraft.world.item.Item;

public class CompostSoilItem extends Item {
    public static final int MAXIMUM_STACK_SIZE = 64;
    public static final String NAME = "compost_soil";

    public CompostSoilItem() {
        super(new Item.Properties().stacksTo(MAXIMUM_STACK_SIZE));
    }

}
