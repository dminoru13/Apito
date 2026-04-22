package net.notridani.apito.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.entity.custom.GolboEntity;
import net.notridani.apito.entity.custom.MininoruEntity;

public class ModEntities {

    public static final EntityType<MininoruEntity> MININORU = Registry.register(Registries.ENTITY_TYPE, Identifier.of(Apito.MOD_ID, "mininoru"),
            EntityType.Builder.create(MininoruEntity::new, SpawnGroup.CREATURE).dimensions(0.4f,1.3f).build());

    public static final EntityType<GolboEntity> GOLBO = Registry.register(Registries.ENTITY_TYPE, Identifier.of(Apito.MOD_ID, "golbo"),
            EntityType.Builder.create(GolboEntity::new, SpawnGroup.CREATURE).dimensions(1.4f,0.4f).build());

    public static void registerModEntities() {
        Apito.LOGGER.info("Registering mod entities for " + Apito.MOD_ID);
    }
}
