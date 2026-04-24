package net.notridani.apito.block.entity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.block.entity.custom.CarvingBenchEntity;
import net.notridani.apito.block.entity.custom.ForgeInputEntity;
import net.notridani.apito.block.entity.custom.WhistleForgeEntity;

public class ModBlockEntities {

    public static final BlockEntityType<WhistleForgeEntity> WHISTLE_FORGE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Apito.MOD_ID, "whistle_forge_be"),
                    BlockEntityType.Builder.create(WhistleForgeEntity::new, ModBlocks.WHISTLE_FORGE).build(null));

    public static final BlockEntityType<ForgeInputEntity> FORGE_INPUT_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Apito.MOD_ID, "forge_input_be"),
                    BlockEntityType.Builder.create(ForgeInputEntity::new, ModBlocks.FORGE_INPUT).build(null));

    public static final BlockEntityType<CarvingBenchEntity> CARVING_BENCH_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Apito.MOD_ID, "carving_bench_be"),
                    BlockEntityType.Builder.create(CarvingBenchEntity::new, ModBlocks.CARVING_BENCH).build(null));

    public static void registerBlockEntities() {
        Apito.LOGGER.info("Registering block entities for " + Apito.MOD_ID);
    }
}
