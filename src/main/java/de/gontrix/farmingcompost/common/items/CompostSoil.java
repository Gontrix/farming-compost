package de.gontrix.farmingcompost.common.items;

import de.gontrix.farmingcompost.FarmingCompost;
import de.gontrix.farmingcompost.common.FarmingCompostItemGroup;
import net.minecraft.item.Item;

public class CompostSoil extends Item {
    public static final int MAXIMUM_STACK_SIZE = 64;
    public static final String NAME = "compost_soil";

    public CompostSoil() {
        super(new Item.Properties().maxStackSize(MAXIMUM_STACK_SIZE).group(FarmingCompostItemGroup.farmingCompost));
    }

    public static CompostSoil getCompostSoil() {
        Items.compostSoil = new CompostSoil();
        Items.compostSoil.setRegistryName(FarmingCompost.MODID, NAME);

        return Items.compostSoil;
    }
}
