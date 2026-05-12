package net.notridani.apito.world.biome;

import net.minecraft.block.Block;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.biome.Biome;

public class ApitoBiomeData {

    public final RegistryEntry<Biome> Biome;

    public final int Altura;
    public final Block bloco_superficie;
    public final Block bloco_intermediario;
    public final Block bloco_base;
    public final float frequencia_noise;
    public final float amplitude_noise;
    public final String nivel_da_agua;

    public ApitoBiomeData(
            RegistryEntry<Biome> biome,
            int altura,
            Block blocoSuperficie,
            Block blocoIntermediario,
            Block blocoBase,
            float frequenciaNoise,
            float amplitudeNoise,
            String nivelDaAgua
            ) {

        Biome = biome;
        Altura = altura;
        this.bloco_superficie = blocoSuperficie;
        this.bloco_intermediario = blocoIntermediario;
        this.bloco_base = blocoBase;
        frequencia_noise = frequenciaNoise;
        amplitude_noise = amplitudeNoise;
        nivel_da_agua = nivelDaAgua;
    }
}
