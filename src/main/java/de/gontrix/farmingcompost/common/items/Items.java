package de.gontrix.farmingcompost.common.items;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
//    public static CompostSoil compostSoil;
//    public static FertilizedField fertilizedField;
//    public static FertilizedSoil fertilizedSoil;

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FarmingCompost.MODID);

    public static final RegistryObject<Item> COMPOST_SOIL = CompostSoil.getCompostSoil();
    public static final RegistryObject<Item> FERTILIZED_SOIL = FertilizedSoil.getFertilizedSoil();
    public static final RegistryObject<Item> FERTILIZED_FIELD = FertilizedField.getFertilizedField();

    public Items() {
        FarmingCompost.LOGGER.info("FarmingCompost Items");
        ITEMS.register(FarmingCompost.MOD_EVENT_BUS);
        FarmingCompost.MOD_EVENT_BUS.addListener(this::buildContents);
    }

    public void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(FarmingCompost.MODID, "example"), builder ->
                // Set name of tab to display
                builder.title(Component.translatable("item_group." + FarmingCompost.MODID + ".example"))
                        // Set icon of creative tab
                        .icon(() -> new ItemStack(COMPOST_SOIL.get()))
                        // Add default items to tab
                        .displayItems((params, output) -> {
                            output.accept(COMPOST_SOIL.get());
                            output.accept(FERTILIZED_SOIL.get());
                            output.accept(FERTILIZED_FIELD.get());
                        })
        );
    }

//    private void addCreative(CreativeModeTabEvent.BuildContents event) {
//        FarmingCompost.LOGGER.info("FarmingCompost addCreative");
//        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
//            event.accept(COMPOST_SOIL);
//            event.accept(FERTILIZED_SOIL);
//            event.accept(FERTILIZED_FIELD);
//        }
//    }
//    @SubscribeEvent
//    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {

//        FarmingCompostItemGroup.farmingCompost = FarmingCompostItemGroup.getFarmingCompostItemGroup();

//        itemRegisterEvent.getRegistry().register(CompostSoil.getCompostSoil());
//        itemRegisterEvent.getRegistry().register(FertilizedField.getFertilizedField());
//        itemRegisterEvent.getRegistry().register(FertilizedSoil.getFertilizedSoil());
//    }
}
