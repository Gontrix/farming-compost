package de.gontrix.farmingcompost.common.items;

import de.gontrix.farmingcompost.FarmingCompost;
import de.gontrix.farmingcompost.common.blocks.Blocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class FertilizedSoil extends BlockItem {
    public static final int MAXIMUM_STACK_SIZE = 64;
    public static final String NAME = "fertilized_soil";

    public FertilizedSoil() {
        super(Blocks.FERTILIZED_SOIL.get(), new BlockItem.Properties().stacksTo(MAXIMUM_STACK_SIZE));
        FarmingCompost.LOGGER.info("FarmingCompost FertilizedSoil");
    }

    public static RegistryObject<Item> getFertilizedSoil() {
        FarmingCompost.LOGGER.info("FarmingCompost getFertilizedSoil");
        return Items.ITEMS.register(NAME, FertilizedSoil::new);
    }
}
