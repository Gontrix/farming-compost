package de.gontrix.farmingcompost.common.items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class Items {
    public static FertilizedSoil fertilizedSoil;
    public static CompostSoil compostSoil;

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
        itemRegisterEvent.getRegistry().register(FertilizedSoil.getFertilizedSoil());
        itemRegisterEvent.getRegistry().register(CompostSoil.getCompostSoil());
    }

    @SubscribeEvent
    public static void onCommonSetupEvent(FMLCommonSetupEvent event) {
        // not actually required for this example....
    }
}
