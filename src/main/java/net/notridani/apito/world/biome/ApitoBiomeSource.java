package net.notridani.apito.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryCodecs;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeCoords;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.notridani.apito.world.Noises;

import java.util.HashMap;
import java.util.Map;
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
    private final RegistryEntry<Biome> arboredo;
    private final RegistryEntry<Biome> labirinto;

    public boolean isInitialized() {
        return initialized;
    }

    private final DoublePerlinNoiseSampler DoublePerlinNoise;


    public synchronized void init(long seed) {

        if (initialized) return;

        this.seed = seed;

        initialized = true;


    }

    public final Map<RegistryEntry<Biome>, ApitoBiomeData> apitoBiomeDataMap = new HashMap<>();



    public ApitoBiomeSource(RegistryEntryList<Biome> biomes) {

        this.DoublePerlinNoise = Noises.createPerlinNoise(
                3,
                23,
                -7,
                1.0, 0.5, 0.25
        );

        this.biomes = biomes;

        this.nuloBiome = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of("apito", "nulo")))
                .findFirst()
                .orElseThrow();

        this.bordaBiome = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of("apito", "borda")))
                .findFirst()
                .orElseThrow();

        this.fendaBiome = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of("apito", "fenda")))
                .findFirst()
                .orElseThrow();

        this.arboredo = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of("apito", "arboredo")))
                .findFirst()
                .orElseThrow();

        this.labirinto = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of("apito", "labirinto")))
                .findFirst()
                .orElseThrow();

        //DADOS DOS BIOMAS

        apitoBiomeDataMap.put(
                nuloBiome,
                new ApitoBiomeData(
                        nuloBiome,
                        224,
                        Blocks.GRAVEL,
                        Blocks.TUFF,
                        Blocks.TUFF,
                        (float) 4,
                        (float) 3.0
                )
        );

        apitoBiomeDataMap.put(
                bordaBiome,
                new ApitoBiomeData(
                        bordaBiome,
                        224,
                        Blocks.BASALT,
                        Blocks.BASALT,
                        Blocks.BASALT,
                        (float)10.0,
                        (float) 10.0
                )
        );

        apitoBiomeDataMap.put(
                fendaBiome,
                new ApitoBiomeData(
                        fendaBiome,
                        160,
                        Blocks.STONE,
                        Blocks.STONE,
                        Blocks.STONE,
                        (float) 0.0,
                        (float) 0.0
                )
        );

        apitoBiomeDataMap.put(
                arboredo,
                new ApitoBiomeData(
                        arboredo,
                        200,
                        Blocks.GRASS_BLOCK,
                        Blocks.DIRT,
                        Blocks.STONE,
                        (float)4,
                        (float) 3
                )
        );

        apitoBiomeDataMap.put(
                labirinto,
                new ApitoBiomeData(
                        labirinto,
                        224,
                        Blocks.CHISELED_POLISHED_BLACKSTONE,
                        Blocks.CHISELED_POLISHED_BLACKSTONE,
                        Blocks.BLACKSTONE,
                        (float)0,
                        (float) 0
                )
        );

    }

    public ApitoBiomeData getBiomeData(RegistryEntry<Biome> biome) {
        return apitoBiomeDataMap.get(biome);
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

        double n = Noises.DoublePerlinSample(DoublePerlinNoise, blockX, 0, blockZ, 0.1);




        if (n > 0.1) {

            return labirinto;



        }

        if (n < 0.1 && n > 0.01) {

            return bordaBiome;
        }

        if (n < 0.01 && n > 0) {

            return arboredo;
        }

        if(n < 0 && n > -0.35) {

            return fendaBiome;
        }

        return arboredo;
    }

    @Override
    protected MapCodec<? extends BiomeSource> getCodec() {
        return CODEC;
    }
}