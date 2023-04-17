package de.gontrix.farmingcompost.common.items;

import de.gontrix.farmingcompost.FarmingCompost;
import de.gontrix.farmingcompost.common.blocks.Blocks;
import net.minecraft.world.item.BlockItem;

public class FertilizedSoilItem extends BlockItem {
    public static final int MAXIMUM_STACK_SIZE = 64;

    public FertilizedSoilItem() {
        super(Blocks.FERTILIZED_SOIL.get(), new BlockItem.Properties().stacksTo(MAXIMUM_STACK_SIZE));
        FarmingCompost.LOGGER.info("FarmingCompost FertilizedSoil");
    }
}
