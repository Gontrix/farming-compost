package de.gontrix.farmingcompost.common.blocks;

import de.gontrix.farmingcompost.common.items.Items;
import de.gontrix.farmingcompost.common.menu.CompostMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompostBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(10) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 1024*8;
    private static final int compostSoilSlot = 9;
    private static final int maxInputSlot = 8;


    public CompostBlockEntity(BlockPos pos, BlockState state) {
        super(Blocks.COMPOST_ENTITY.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CompostBlockEntity.this.progress;
                    case 1 -> CompostBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> CompostBlockEntity.this.progress = value;
                    case 1 -> CompostBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("block.farmingcompost.compost");
    }

    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
        return new CompostMenu(id, inventory, this, this.data);
    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putInt("compost.progress", this.progress);

        super.saveAdditional(nbt);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("compost.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CompostBlockEntity pEntity) {
        if(level.isClientSide()) {
            return;
        }

        if(hasRecipe(pEntity)) {
            pEntity.progress += getProgress(pEntity);
            setChanged(level, pos, state);

            if(pEntity.progress >= pEntity.maxProgress) {
                craftItem(pEntity, state);
            }
        } else {
            pEntity.resetProgress();
            setChanged(level, pos, state);
        }

        updateBlockLevel(state, pEntity);
    }

    public static int getProgress(CompostBlockEntity entity) {
        float progress = 0.5f;

        for (int i = 0; i < maxInputSlot; i++) {
            if (isValidItem(entity.itemHandler.getStackInSlot(i))) {
                progress += 0.25f;
            }
        }

        if (isNearWater(entity.getBlockState(), entity.getBlockPos())) {
            progress += 1f;
        }

        return Math.round(progress);
    }

    private static boolean isNearWater(BlockState state, BlockPos blockPos) {
        for(BlockPos blockpos : BlockPos.betweenClosed(
                blockPos.offset(-4, -1, -4),
                blockPos.offset(4, 1, 4)
        )) {
            if (state.canBeHydrated(null, blockPos, state.getFluidState(), blockpos)) {
                return true;
            }
        }

        return false;
    }

    private static void updateBlockLevel(BlockState state, CompostBlockEntity pEntity) {
        int itemCount = 0;
        int itemMaxCount = 0;
        int level = 0;

        for (int i = 0; i < maxInputSlot; i++) {
            itemCount += pEntity.itemHandler.getStackInSlot(i).getCount();
            itemMaxCount += pEntity.itemHandler.getStackInSlot(i).getMaxStackSize();
        }

        if (itemCount > (itemMaxCount / 2)) {
            level = 2;
        } else if (itemCount > 0) {
            level = 1;
        }

        pEntity.getLevel().setBlock(pEntity.getBlockPos(),state.setValue(CompostBlock.FILL_LEVEL, level), 2);
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(CompostBlockEntity pEntity, BlockState state) {
        if(hasRecipe(pEntity)) {
            for (int i = 0; i < maxInputSlot; i++) {
                if (isValidItem(pEntity.itemHandler.getStackInSlot(i))) {
                    pEntity.itemHandler.extractItem(i, 1, false);
                    pEntity.itemHandler.setStackInSlot(compostSoilSlot, new ItemStack(Items.COMPOST_SOIL.get(), pEntity.itemHandler.getStackInSlot(compostSoilSlot).getCount() + 1));

                    pEntity.resetProgress();
                    updateBlockLevel(state, pEntity);
                    break;
                }
            }

        }
    }

    private static boolean hasRecipe(CompostBlockEntity entity) {
        boolean hasMaterial = false;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());

        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            ItemStack stack = entity.itemHandler.getStackInSlot(i);
            inventory.setItem(i, stack);

            if (isValidItem(stack)) {
                hasMaterial = true;
            }
        }

        return hasMaterial && canInsertItemIntoOutputSlot(inventory, new ItemStack(Items.COMPOST_SOIL.get(), 1)) && canInsertAmountIntoOutputSlot(inventory);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(compostSoilSlot).isEmpty() || inventory.getItem(compostSoilSlot).getItem() == stack.getItem();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(compostSoilSlot).getMaxStackSize() > inventory.getItem(compostSoilSlot).getCount();
    }

    private static boolean isValidItem(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem().isEdible();
    }
}
