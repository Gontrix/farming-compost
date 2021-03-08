package de.gontrix.farmingcompost.common.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Blocks {
    public static FertilizedField fertilizedField;
    public static FertilizedSoil fertilizedSoil;

    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
        blockRegisterEvent.getRegistry().register(FertilizedField.getFertilizedField());
        blockRegisterEvent.getRegistry().register(FertilizedSoil.getFertilizedSoil());
    }
}
