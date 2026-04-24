package net.notridani.apito.screen.custom;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.notridani.apito.block.entity.custom.CarvingBenchEntity;
import net.notridani.apito.item.ModItems;
import net.notridani.apito.screen.ModScreenHandler;

public class CarvingBenchScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final CarvingBenchEntity blockEntity;

    public CarvingBenchScreenHandler(int syncId, PlayerInventory inventory, BlockPos pos) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(pos), new ArrayPropertyDelegate(3));
    }

    public CarvingBenchScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {

        super(ModScreenHandler.CARVING_BENCH_SCREEN_HANDLER, syncId);
        checkSize((Inventory) blockEntity, 1);
        this.inventory = (Inventory) blockEntity;
        this.blockEntity = ((CarvingBenchEntity) blockEntity);
        this.propertyDelegate = arrayPropertyDelegate;


        this.addSlot(new Slot(inventory, 0, 1, 1){
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isOf(ModItems.ANCIENT_HEART);
            }

            @Override
            public int getMaxItemCount() {
                return 1;
            }

            @Override
            public void setStack(ItemStack stack) {
                super.setStack(stack);
                playSound();
            }

            @Override
            public ItemStack takeStack(int amount) {
                ItemStack result = super.takeStack(amount);
                playSound();
                return result;
            }

            private void playSound() {
                if(!playerInventory.player.getWorld().isClient) {
                    playerInventory.player.getWorld().playSound(
                            null,
                            blockEntity.getPos(),
                            SoundEvents.BLOCK_STONE_PLACE,
                            SoundCategory.BLOCKS,
                            1.0f,
                            1.0f
                    );
                }
            }
        });

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(arrayPropertyDelegate);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }


    @Override
    public boolean canUse(PlayerEntity player) {
        return inventory.canPlayerUse(player);
    }


    private void addPlayerInventory(PlayerInventory playerInventory) {
        int startX = 6;
        int startY = 114;

        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory,
                        col + row * 9 + 9,
                        startX + col * 18,
                        startY + row * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        int startX = 6;
        int startY = 172;

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i,
                    startX + i * 18,
                    startY));
        }
    }


    public boolean tem_pedra(){
        return propertyDelegate.get(2) == 1;
    }

}



