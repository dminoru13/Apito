package net.notridani.apito.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.Property;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.notridani.apito.block.entity.ImplementedInventory;
import net.notridani.apito.block.entity.ModBlockEntities;
import net.notridani.apito.item.ModItems;
import net.notridani.apito.screen.custom.CarvingBenchScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Stack;

public class CarvingBenchEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);




    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 5;
    private int tem_pedra = 0;
    private int entalhe = 0;
    private int base = 0;



    public CarvingBenchEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CARVING_BENCH_BE, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CarvingBenchEntity.this.progress;
                    case 1 -> CarvingBenchEntity.this.maxProgress;
                    case 2 -> CarvingBenchEntity.this.tem_pedra;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: CarvingBenchEntity.this.progress = value;
                    case 1: CarvingBenchEntity.this.maxProgress = value;
                    case 2: CarvingBenchEntity.this.tem_pedra = value;
                }
            }

            @Override
            public int size() {
                return 3;
            }
        };
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
        return this.pos;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.apito.carving_bench");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CarvingBenchScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }



    //SALVAR E CARREGAR DADOS
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);

        Inventories.writeNbt(nbt, inventory,registryLookup);
        //nbt.putInt("carving_bench.progress", progress);

    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory,registryLookup);
        //progress = nbt.getInt("carving_bench.progress");
        super.readNbt(nbt, registryLookup);
    }


    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }




    //programa legal vem aqui

    private static final int INPUT_SLOT = 0;

    private boolean stone_placed(){
        return !this.getStack(INPUT_SLOT).isEmpty();
    }


    public void tick(World world, BlockPos pos, BlockState state) {

        if(stone_placed()){
            tem_pedra = 1;
        } else {
            tem_pedra = 0;
        }
    }









}
