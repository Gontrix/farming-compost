package de.gontrix.farmingcompost.common.blocks;

import de.gontrix.farmingcompost.FarmingCompost;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class Blocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FarmingCompost.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FarmingCompost.MODID);

    public static final RegistryObject<Block> FERTILIZED_SOIL = BLOCKS.register(FertilizedSoilBlock.NAME, FertilizedSoilBlock::new);
    public static final RegistryObject<Block> FERTILIZED_FIELD = BLOCKS.register(FertilizedFieldBlock.NAME, FertilizedFieldBlock::new);
    public static final RegistryObject<Block> COMPOST = BLOCKS.register(CompostBlock.NAME, CompostBlock::new);


    public static final RegistryObject<BlockEntityType<CompostBlockEntity>> COMPOST_ENTITY = BLOCK_ENTITIES.register("compost", () -> BlockEntityType.Builder.of(CompostBlockEntity::new, COMPOST.get()).build(null));

    public Blocks() {
        BLOCKS.register(FarmingCompost.MOD_EVENT_BUS);
        BLOCK_ENTITIES.register(FarmingCompost.MOD_EVENT_BUS);
    }
}
