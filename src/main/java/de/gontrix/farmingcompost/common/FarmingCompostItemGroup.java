package de.gontrix.farmingcompost.common;

import de.gontrix.farmingcompost.common.items.Items;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class FarmingCompostItemGroup extends ItemGroup {
    public static final String NAME = "farming_compost";
    public static FarmingCompostItemGroup farmingCompost;

    public FarmingCompostItemGroup(String label) {
        super(label);
    }

    public static FarmingCompostItemGroup getFarmingCompostItemGroup() {
        return new FarmingCompostItemGroup(FarmingCompostItemGroup.NAME);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.compostSoil);
    }
}
