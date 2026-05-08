package net.notridani.apito.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.registry.RegistryCodecs;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeCoords;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

import java.util.stream.Stream;

public class ApitoBiomeSource extends BiomeSource {

    public static final MapCodec<ApitoBiomeSource> CODEC =
            RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                            RegistryCodecs.entryList(RegistryKeys.BIOME)
                                    .fieldOf("biomes")
                                    .forGetter(source -> source.biomes)
                    ).apply(instance, ApitoBiomeSource::new)
            );

    private volatile boolean initialized = false;
    private long seed;

    private final RegistryEntryList<Biome> biomes;

    private final RegistryEntry<Biome> nuloBiome;
    private final RegistryEntry<Biome> fendaBiome;
    private final RegistryEntry<Biome> bordaBiome;

    public boolean isInitialized() {
        return initialized;
    }


    public synchronized void init(long seed) {

        if (initialized) return;

        this.seed = seed;

        initialized = true;
    }


    public ApitoBiomeSource(RegistryEntryList<Biome> biomes) {

        this.biomes = biomes;

        this.nuloBiome = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of("apito", "nulo")))
                .findFirst()
                .orElseThrow();

        this.fendaBiome = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of("apito", "fenda")))
                .findFirst()
                .orElseThrow();

        this.bordaBiome = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of("apito", "borda")))
                .findFirst()
                .orElseThrow();
    }

    @Override
    protected Stream<RegistryEntry<Biome>> biomeStream() {
        return biomes.stream();
    }

    @Override
    public RegistryEntry<Biome> getBiome(
            int x,
            int y,
            int z,
            MultiNoiseUtil.MultiNoiseSampler noise
    ) {

        int blockX = BiomeCoords.toBlock(x);
        int blockZ = BiomeCoords.toBlock(z);
        int blockY = BiomeCoords.toBlock(y);

        double n = CellularNoise.sample(
                seed,
                blockX,
                blockZ,
                300
        );

        if (n > 0.5) {

            return nuloBiome;
        }

        if (n < 0.5 && n > 0.47) {

            return bordaBiome;
        }

        return fendaBiome;
    }

    @Override
    protected MapCodec<? extends BiomeSource> getCodec() {
        return CODEC;
    }
}