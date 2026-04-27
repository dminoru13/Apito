package net.notridani.apito.screen.custom;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.notridani.apito.block.entity.custom.CarvingBenchEntity;
import net.notridani.apito.item.ModItems;
import net.notridani.apito.screen.ModScreenHandler;
import org.jetbrains.annotations.Nullable;

public class CarvingBenchScreenHandler extends ScreenHandler {

    private final Inventory inventory;



    public CarvingBenchScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        super(ModScreenHandler.CARVING_BENCH_SCREEN_HANDLER, syncId);

        var world = playerInventory.player.getWorld();
        var blockEntity = world.getBlockEntity(pos);

        if (blockEntity instanceof CarvingBenchEntity bench) {
            this.inventory = bench;
        } else {
            throw new IllegalStateException("Expected CarvingBenchEntity");
        }

        this.addSlot(new Slot(this.inventory, 0, 80, 35));
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}



