package de.gontrix.farmingcompost;

import com.mojang.logging.LogUtils;
import de.gontrix.farmingcompost.common.blocks.Blocks;
import de.gontrix.farmingcompost.common.items.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(FarmingCompost.MODID)
public class FarmingCompost {
    public static final String MODID = "farmingcompost";
    public static IEventBus MOD_EVENT_BUS;

    public static final Logger LOGGER = LogUtils.getLogger();

    public FarmingCompost() {
        FarmingCompost.LOGGER.info("FarmingCompost init");
        MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        registerCommonEvents();
//        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FarmingCompost::registerClientOnlyEvents);
//        DistExecutor.safeRunWhenOn(Dist.DEDICATED_SERVER, () -> FarmingCompost::registerServerOnlyEvents);
    }


    public static void registerCommonEvents() {
        Blocks BLOCKS = new Blocks();
        Items ITEMS = new Items();
    }


//    public static void registerClientOnlyEvents() {
//        MOD_EVENT_BUS.register(de.gontrix.farmingcompost.client.Startup.class);
//    }
//
//    public static void registerServerOnlyEvents() {
//        MOD_EVENT_BUS.register(de.gontrix.farmingcompost.client.Startup.class);
//    }

}
