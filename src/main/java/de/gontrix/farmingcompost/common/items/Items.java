package de.gontrix.farmingcompost.common.items;

import de.gontrix.farmingcompost.common.FarmingCompostItemGroup;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class Items {
    public static CompostSoil compostSoil;
    public static FertilizedField fertilizedField;
    public static FertilizedSoil fertilizedSoil;

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
        FarmingCompostItemGroup.farmingCompost = FarmingCompostItemGroup.getFarmingCompostItemGroup();

        itemRegisterEvent.getRegistry().register(CompostSoil.getCompostSoil());
        itemRegisterEvent.getRegistry().register(FertilizedField.getFertilizedField());
        itemRegisterEvent.getRegistry().register(FertilizedSoil.getFertilizedSoil());
    }
}
