package de.gontrix.farmingcompost.common.items;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class CompostSoil extends Item {
    public static final int MAXIMUM_STACK_SIZE = 64;
    public static final String NAME = "compost_soil";

    public CompostSoil() {
        super(new Item.Properties().stacksTo(MAXIMUM_STACK_SIZE));
        FarmingCompost.LOGGER.info("FarmingCompost CompostSoil");
    }

    public static RegistryObject<Item> getCompostSoil() {
        FarmingCompost.LOGGER.info("FarmingCompost getCompostSoil");
        return Items.ITEMS.register(NAME, CompostSoil::new);
    }
}
