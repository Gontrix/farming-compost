package de.gontrix.farmingcompost.common.items;

import de.gontrix.farmingcompost.FarmingCompost;
import de.gontrix.farmingcompost.common.blocks.FertilizedFieldBlock;
import de.gontrix.farmingcompost.common.blocks.FertilizedSoilBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FarmingCompost.MODID);

    public static final RegistryObject<Item> COMPOST_SOIL = ITEMS.register(CompostSoilItem.NAME, CompostSoilItem::new);
    public static final RegistryObject<Item> FERTILIZED_SOIL = ITEMS.register(FertilizedSoilBlock.NAME, FertilizedSoilItem::new);
    public static final RegistryObject<Item> FERTILIZED_FIELD = ITEMS.register(FertilizedFieldBlock.NAME, FertilizedFieldItem::new);

    public Items() {
        ITEMS.register(FarmingCompost.MOD_EVENT_BUS);
        FarmingCompost.MOD_EVENT_BUS.addListener(this::buildContents);
    }

    public void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(FarmingCompost.MODID, "example"), builder ->
                builder.title(Component.translatable("item_group." + FarmingCompost.MODID + ".tab"))
                        .icon(() -> new ItemStack(COMPOST_SOIL.get()))
                        .displayItems((params, output) -> {
                            output.accept(COMPOST_SOIL.get());
                            output.accept(FERTILIZED_SOIL.get());
                            output.accept(FERTILIZED_FIELD.get());
                        })
        );
    }
}
