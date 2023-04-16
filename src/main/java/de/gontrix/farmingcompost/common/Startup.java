package de.gontrix.farmingcompost.common;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class Startup {

    @SubscribeEvent
    public static void onCommonSetupEvent(FMLCommonSetupEvent event) {
        FarmingCompost.LOGGER.info("FarmingCompost onCommonSetupEvent");
    }
}
