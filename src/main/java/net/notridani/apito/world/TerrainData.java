package net.notridani.apito.world;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.notridani.apito.world.biome.ApitoBiomeData;

public class TerrainData {

    public final RegistryEntry<Biome> biome;
    public final ApitoBiomeData biomeData;
    public final int altura;

    public TerrainData(
            RegistryEntry<Biome> biome,
            ApitoBiomeData biomeData,
            int altura
    ) {

        this.biome = biome;
        this.biomeData = biomeData;
        this.altura = altura;
    }
}