package de.gontrix.farmingcompost.common.blocks;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Blocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FarmingCompost.MODID);

    public static final RegistryObject<Block> FERTILIZED_SOIL = FertilizedSoil.getFertilizedSoil();
    public static final RegistryObject<Block> FERTILIZED_FIELD = FertilizedField.getFertilizedField();

    public Blocks() {
        FarmingCompost.LOGGER.info("FarmingCompost Blocks");
        BLOCKS.register(FarmingCompost.MOD_EVENT_BUS);
    }
//    public static FertilizedField fertilizedField;
//    public static FertilizedSoil fertilizedSoil;

//    @SubscribeEvent
//    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
//        blockRegisterEvent.getRegistry().register(FertilizedField.getFertilizedField());
//        blockRegisterEvent.getRegistry().register(FertilizedSoil.getFertilizedSoil());
//    }
}
