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
import net.minecraft.util.math.BlockPos;
import net.notridani.apito.block.entity.custom.CarvingBenchEntity;
import net.notridani.apito.screen.ModScreenHandler;

public class CarvingBenchScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final CarvingBenchEntity blockEntity;

    public CarvingBenchScreenHandler(int syncId, PlayerInventory inventory, BlockPos pos) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(pos), new ArrayPropertyDelegate(2));
    }

    public CarvingBenchScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {

        super(ModScreenHandler.CARVING_BENCH_SCREEN_HANDLER, syncId);
        checkSize((Inventory) blockEntity, 1);
        this.inventory = (Inventory) blockEntity;
        this.blockEntity = ((CarvingBenchEntity) blockEntity);
        this.propertyDelegate = arrayPropertyDelegate;


        this.addSlot(new Slot(inventory, 0, 1, 1));

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

    int pos_x = 27 -21;
    int pos_y = 138 -26;

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
}
