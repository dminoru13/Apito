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
    private final RegistryEntry<Biome> labirinto_de_flores;
    private final RegistryEntry<Biome> reservatorio_profundo;
    private final RegistryEntry<Biome> promontorio;

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
                seed,
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

        this.labirinto_de_flores = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of("apito", "labirinto_de_flores")))
                .findFirst()
                .orElseThrow();

        this.reservatorio_profundo = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of("apito", "reservatorio_profundo")))
                .findFirst()
                .orElseThrow();

        this.promontorio = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of("apito", "promontorio")))
                .findFirst()
                .orElseThrow();

        //DADOS DOS BIOMAS

        apitoBiomeDataMap.put(
                nuloBiome,
                new ApitoBiomeData(
                        nuloBiome,
                        319,
                        Blocks.AIR,
                        Blocks.AIR,
                        Blocks.AIR,
                        (float) 0,
                        (float) 0.0,
                        null
                )
        );

        apitoBiomeDataMap.put(
                bordaBiome,
                new ApitoBiomeData(
                        bordaBiome,
                        240,
                        Blocks.BASALT,
                        Blocks.BASALT,
                        Blocks.BASALT,
                        (float)10.0,
                        (float) 10.0,
                        null
                )
        );

        apitoBiomeDataMap.put(
                fendaBiome,
                new ApitoBiomeData(
                        fendaBiome,
                        240,
                        Blocks.STONE_BRICKS,
                        Blocks.TUFF_BRICKS,
                        Blocks.STONE,
                        (float) 0.0,
                        (float) 0.0,
                        null
                )
        );

        apitoBiomeDataMap.put(
                arboredo,
                new ApitoBiomeData(
                        arboredo,
                        96,
                        Blocks.GRASS_BLOCK,
                        Blocks.DIRT,
                        Blocks.PACKED_MUD,
                        (float)4,
                        (float) 3,
                        null
                )
        );

        apitoBiomeDataMap.put(
                labirinto_de_flores,
                new ApitoBiomeData(
                        labirinto_de_flores,
                        80,
                        Blocks.PACKED_MUD,
                        Blocks.GRANITE,
                        Blocks.TUFF,
                        (float)1,
                        (float) 2,
                        null
                )
        );

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
                        null
                )
        );

        apitoBiomeDataMap.put(
                reservatorio_profundo,
                new ApitoBiomeData(
                        reservatorio_profundo,
                        -64,
                        Blocks.BLACKSTONE,
                        Blocks.BLACKSTONE,
                        Blocks.TUFF,
                        (float)1,
                        (float) 1,
                        240
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

        double celular1 = Noises.cellularSample(seed, blockX, blockZ, 5000);
        double celular2 = Noises.cellularSample(seed, blockX, blockZ, 1000);
        double n = Noises.doublePerlinSample(DoublePerlinNoise, blockX, 0, blockZ, 0.15);


        float areaCidades = 0f;
        double areaReservatorio = 0.1;

        switch (descobrirCamada(blockY)) {
            case Camada.SUPERFICIE:
                if(celular1 > areaReservatorio) {
                    if (n < areaCidades) {

                        return fendaBiome;
                    }

                    if(n < areaCidades+0.01 && n > areaCidades) {

                        return bordaBiome;
                    }

                    if(n > areaCidades+0.01) {
                        return nuloBiome;
                    }
                }

                if(celular1 < areaReservatorio && celular1 > areaReservatorio*0.95) {
                    return promontorio;
                }

                if(celular1 < areaReservatorio*0.95) {
                    return reservatorio_profundo;
                }

            case Camada.SUBTERRANEO:
                if(celular1 > areaReservatorio) {
                    if (n < areaCidades) {

                        return fendaBiome;
                    }

                    if(n < areaCidades+0.01 && n > areaCidades) {

                        return bordaBiome;
                    }

                    if(n > areaCidades+0.01) {
                        if(celular2 > 0.1) {
                            return labirinto_de_flores;
                        } else {
                            return arboredo;
                        }
                    }
                }

                if(celular1 < areaReservatorio && celular1 > areaReservatorio*0.95) {
                    return promontorio;
                }

                if(celular1 <areaReservatorio - areaReservatorio*0.95) {
                    return reservatorio_profundo;
                }
        }


        return nuloBiome;
    }

    public enum Camada {
        SUPERFICIE,
        SUBTERRANEO,
        BEQUINHOS,
        MAR_DE_CADAVERES,
        DEU_RUIM
    }

    public static int superficie = 224;
    public static int subterraneo = 64;
    public static int bequinhos = 0;
    public static int mar_de_cadaveres = -64;

    public Camada descobrirCamada(int y) {
        if (y > superficie) {
            return Camada.SUPERFICIE;
        }

        if (y > subterraneo) {
            return Camada.SUBTERRANEO;
        }

        if (y > bequinhos) {
            return Camada.BEQUINHOS;
        }

        if (y > mar_de_cadaveres) {
            return Camada.MAR_DE_CADAVERES;
        }

        return Camada.DEU_RUIM;
    }


    @Override
    protected MapCodec<? extends BiomeSource> getCodec() {
        return CODEC;
    }
}