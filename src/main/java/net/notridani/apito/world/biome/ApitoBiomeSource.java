package net.notridani.apito.world.biome;

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
import net.notridani.apito.world.noises.Noises;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ApitoBiomeSource extends BiomeSource {
    public static final MapCodec<ApitoBiomeSource> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(RegistryCodecs.entryList(RegistryKeys.BIOME).fieldOf("biomes").forGetter(source -> source.biomes)).apply(instance, ApitoBiomeSource::new));
    private volatile boolean initialized = false;
    private long seed;
    private final RegistryEntryList<Biome> biomes;
    private final RegistryEntry<Biome> nuloBiome;
    private final RegistryEntry<Biome> fendaBiome;
    private final RegistryEntry<Biome> bordaBiome;
    private final RegistryEntry<Biome> arboredo;
    private final RegistryEntry<Biome> labirinto_de_flores;
    private final RegistryEntry<Biome> reservatorio_profundo;
    private final RegistryEntry<Biome> promontorio;
    private final RegistryEntry<Biome> marDeCadaveres;

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
        this.DoublePerlinNoise = Noises.createPerlinNoise(seed, 23, -7, 1.0, 0.5, 0.25);
        this.biomes = biomes;
        this.nuloBiome = biomes.stream().filter(b -> b.matchesId(net.minecraft.util.Identifier.of("apito", "nulo"))).findFirst().orElseThrow();
        this.bordaBiome = biomes.stream().filter(b -> b.matchesId(net.minecraft.util.Identifier.of("apito", "borda"))).findFirst().orElseThrow();
        this.fendaBiome = biomes.stream().filter(b -> b.matchesId(net.minecraft.util.Identifier.of("apito", "fenda"))).findFirst().orElseThrow();
        this.arboredo = biomes.stream().filter(b -> b.matchesId(net.minecraft.util.Identifier.of("apito", "arboredo"))).findFirst().orElseThrow();
        this.labirinto_de_flores = biomes.stream().filter(b -> b.matchesId(net.minecraft.util.Identifier.of("apito", "labirinto_de_flores"))).findFirst().orElseThrow();
        this.reservatorio_profundo = biomes.stream().filter(b -> b.matchesId(net.minecraft.util.Identifier.of("apito", "reservatorio_profundo"))).findFirst().orElseThrow();
        this.promontorio = biomes.stream().filter(b -> b.matchesId(net.minecraft.util.Identifier.of("apito", "promontorio"))).findFirst().orElseThrow();
        this.marDeCadaveres = biomes.stream().filter(b -> b.matchesId(net.minecraft.util.Identifier.of("apito", "mar_de_cadaveres"))).findFirst().orElseThrow();

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
                    (float) 3.0,
                    "não"));

        apitoBiomeDataMap.put(
                bordaBiome,
                new ApitoBiomeData(
                    bordaBiome,
                    245,
                    Blocks.BASALT,
                    Blocks.BASALT,
                    Blocks.BASALT,
                    (float) 10.0,
                    (float) 10.0,
                    "não"));


        apitoBiomeDataMap.put(
                fendaBiome,
                new ApitoBiomeData(
                        fendaBiome,
                        176,
                        Blocks.STONE_BRICKS,
                        Blocks.TUFF_BRICKS,
                        Blocks.STONE,
                        (float) 0.0,
                        (float) 0.0,
                        "não"));

        apitoBiomeDataMap.put
                (arboredo,
                        new ApitoBiomeData(
                                arboredo,
                                260,
                                Blocks.GRASS_BLOCK,
                                Blocks.DIRT,
                                Blocks.PACKED_MUD,
                                (float) 4,
                                (float) 3,
                                "não"));

        apitoBiomeDataMap.put(
                labirinto_de_flores,
                new ApitoBiomeData(
                        labirinto_de_flores,
                        240,
                        Blocks.PACKED_MUD,
                        Blocks.GRANITE,
                        Blocks.TUFF,
                        (float) 1,
                        (float) 2,
                        "não"));

        apitoBiomeDataMap.put(
                promontorio,
                new ApitoBiomeData(
                        promontorio,
                        242,
                        Blocks.GRAVEL,
                        Blocks.GRAVEL,
                        Blocks.TUFF_BRICKS,
                        (float) 4,
                        (float) 3.0,
                        "não"));

        apitoBiomeDataMap.put(
                reservatorio_profundo,
                new ApitoBiomeData(
                        reservatorio_profundo,
                        80,
                        Blocks.BLACKSTONE,
                        Blocks.BLACKSTONE,
                        Blocks.TUFF,
                        (float) 1,
                        (float) 1,
                        "240"));

        apitoBiomeDataMap.put(
                marDeCadaveres,
                new ApitoBiomeData(
                        marDeCadaveres,
                        48, Blocks.BLACKSTONE,
                        Blocks.BLACKSTONE, Blocks.
                        TUFF,
                        (float) 1,
                        (float) 1,
                        "80"));
    }

    public ApitoBiomeData getBiomeData(RegistryEntry<Biome> biome) {
        return apitoBiomeDataMap.get(biome);
    }

    @Override
    protected Stream<RegistryEntry<Biome>> biomeStream() {
        return biomes.stream();
    }

    @Override
    public RegistryEntry<Biome> getBiome(int x, int y, int z, MultiNoiseUtil.MultiNoiseSampler noise) {
        int blockX = BiomeCoords.toBlock(x);
        int blockZ = BiomeCoords.toBlock(z);
        int blockY = BiomeCoords.toBlock(y);
        double celular = Noises.cellularSample(seed, blockX, blockZ, 7000);
        double n = Noises.doublePerlinSample(DoublePerlinNoise, blockX, 0, blockZ, 0.15);
        if (celular > 0.05) {
            if (n > 0.3) {
                if (blockY > 224) {
                    return arboredo;
                }
            }
            if (n < 0.3 && n > 0.04) {
                if (blockY > 224) {
                    return labirinto_de_flores;
                }
            }
            if (n < 0.04 && n > 0) {
                if (blockY > 176) {
                    return bordaBiome;
                }
            }
            if (n < 0 && n > -2) {
                if (blockY > 176) {
                    return fendaBiome;
                }
            }
        }
        if (celular < 0.05 && celular > 0.04) {
            if (blockY > 112) {
                return promontorio;
            }
        }
        if (celular < 0.04) {
            if (blockY > 48) {
                return reservatorio_profundo;
            }
        }
        return nuloBiome;
    }

    @Override
    protected MapCodec<? extends BiomeSource> getCodec() {
        return CODEC;
    }
}