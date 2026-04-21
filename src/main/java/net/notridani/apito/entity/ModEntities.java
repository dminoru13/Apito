package net.notridani.apito.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.entity.custom.MininoruEntity;

public class ModEntities {

    public static final EntityType<MininoruEntity> MININORU = Registry.register(Registries.ENTITY_TYPE, Identifier.of(Apito.MOD_ID, "mininoru"),
            EntityType.Builder.create(MininoruEntity::new, SpawnGroup.CREATURE).dimensions(1f,1f).build());

    public static void registerModEntities() {
        Apito.LOGGER.info("Registering mod entities for " + Apito.MOD_ID);
    }
}
