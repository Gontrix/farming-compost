package de.gontrix.farmingcompost;

import de.gontrix.farmingcompost.common.blocks.Blocks;
import de.gontrix.farmingcompost.common.items.Items;
import de.gontrix.farmingcompost.common.menu.Menu;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(FarmingCompost.MODID)
public class FarmingCompost {
    public static final String MODID = "farmingcompost";
    public static IEventBus MOD_EVENT_BUS;

//    public static final Logger LOGGER = LogUtils.getLogger();

    public FarmingCompost() {
//        FarmingCompost.LOGGER.info("FarmingCompost init");
        MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        registerCommonEvents();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FarmingCompost::registerClientOnlyEvents);
//        DistExecutor.safeRunWhenOn(Dist.DEDICATED_SERVER, () -> FarmingCompost::registerServerOnlyEvents);
    }


    public static void registerCommonEvents() {
        new Blocks();
        new Items();
        new Menu();
    }


    public static void registerClientOnlyEvents() {
        MOD_EVENT_BUS.register(de.gontrix.farmingcompost.client.Startup.class);
    }

//    public static void registerServerOnlyEvents() {
//        MOD_EVENT_BUS.register(de.gontrix.farmingcompost.client.Startup.class);
//    }

}
