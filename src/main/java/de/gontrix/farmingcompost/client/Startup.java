package de.gontrix.farmingcompost.client;

import de.gontrix.farmingcompost.client.screen.CompostScreen;
import de.gontrix.farmingcompost.common.menu.Menu;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class Startup {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(Menu.COMPOST_MENU.get(), CompostScreen::new);
    }
}
