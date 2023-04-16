package de.gontrix.farmingcompost.client;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class Startup {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        FarmingCompost.LOGGER.info("FarmingCompost onClientSetup");
//        RenderTypeLookup.setRenderLayer(Blocks.fertilizedSoil, RenderType.getSolid());
    }
}
