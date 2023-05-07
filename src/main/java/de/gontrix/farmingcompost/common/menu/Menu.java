package de.gontrix.farmingcompost.common.menu;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Menu {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, FarmingCompost.MODID);

    public static final RegistryObject<MenuType<CompostMenu>> COMPOST_MENU = MENUS.register("compost_menu", () -> IForgeMenuType.create(CompostMenu::new));


    public Menu() {
        MENUS.register(FarmingCompost.MOD_EVENT_BUS);
    }
}
