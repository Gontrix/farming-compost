package de.gontrix.farmingcompost.common.items;

import de.gontrix.farmingcompost.FarmingCompost;
import de.gontrix.farmingcompost.common.blocks.Blocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class FertilizedField extends BlockItem {
    public static final int MAXIMUM_STACK_SIZE = 64;
    public static final String NAME = "fertilized_field";

    public FertilizedField() {
        super(Blocks.FERTILIZED_FIELD.get(), new BlockItem.Properties().stacksTo(MAXIMUM_STACK_SIZE));
        FarmingCompost.LOGGER.info("FarmingCompost FertilizedField");
    }

    public static RegistryObject<Item> getFertilizedField() {
        FarmingCompost.LOGGER.info("FarmingCompost getFertilizedField");
        return Items.ITEMS.register(NAME, FertilizedField::new);
    }
}
