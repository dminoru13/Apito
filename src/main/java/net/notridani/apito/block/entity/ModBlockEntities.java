package net.notridani.apito.block.entity;

import io.wispforest.owo.registration.reflect.AutoRegistryContainer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.block.entity.custom.CarvingBenchEntity;
import net.notridani.apito.block.entity.custom.ForgeInputEntity;
import net.notridani.apito.block.entity.custom.WhistleForgeEntity;

public class ModBlockEntities implements AutoRegistryContainer<BlockEntityType<?>> {

    public static final BlockEntityType<WhistleForgeEntity> WHISTLE_FORGE_BE =
            FabricBlockEntityTypeBuilder.create(WhistleForgeEntity::new, ModBlocks.WHISTLE_FORGE).build();

    public static final BlockEntityType<ForgeInputEntity> FORGE_INPUT_BE =
            FabricBlockEntityTypeBuilder.create(ForgeInputEntity::new, ModBlocks.FORGE_INPUT).build();

    public static final BlockEntityType<CarvingBenchEntity> CARVING_BENCH_BE =
            FabricBlockEntityTypeBuilder.create(CarvingBenchEntity::new, ModBlocks.CARVING_BENCH).build();


    @Override
    public Registry<BlockEntityType<?>> getRegistry() {
        return Registries.BLOCK_ENTITY_TYPE;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<BlockEntityType<?>> getTargetFieldType() {
        return (Class<BlockEntityType<?>>) (Object) BlockEntityType.class;
    }
}
