package de.gontrix.farmingcompost;

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

    public FarmingCompost() {
        MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        registerCommonEvents();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> FarmingCompost::registerClientOnlyEvents);
    }


    public static void registerCommonEvents() {
        MOD_EVENT_BUS.register(de.gontrix.farmingcompost.common.items.Items.class);
        MOD_EVENT_BUS.register(de.gontrix.farmingcompost.common.blocks.Blocks.class);
    }

    public static void registerClientOnlyEvents() {
        MOD_EVENT_BUS.register(de.gontrix.farmingcompost.client.Startup.class);
    }

}
