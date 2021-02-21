package de.gontrix.farmingcompost.common.items;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class CompostSoil extends Item {
    public static final int MAXIMUM_STACK_SIZE = 64;
    public static final String NAME = "compost_soil";

    public CompostSoil() {
        super(new Item.Properties().maxStackSize(MAXIMUM_STACK_SIZE).group(ItemGroup.MATERIALS));
    }

    public static CompostSoil getCompostSoil() {
        Items.compostSoil = new CompostSoil();
        Items.compostSoil.setRegistryName(FarmingCompost.MODID, NAME);

        return Items.compostSoil;
    }
}
