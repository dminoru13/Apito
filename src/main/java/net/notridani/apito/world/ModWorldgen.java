package net.notridani.apito.world;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.world.biome.ApitoBiomeSource;

public class ModWorldgen {

    public static final Identifier CORREDOR_ID =
            Identifier.of("apito", "corredor");

    public static void register() {
        Registry.register(
                Registries.CHUNK_GENERATOR,
                CORREDOR_ID,
                CorredorChunkGenerator.CODEC
        );

        Registry.register(
                Registries.BIOME_SOURCE,
                Identifier.of(Apito.MOD_ID, "apito_biome_source"),
                ApitoBiomeSource.CODEC
        );
    }
}