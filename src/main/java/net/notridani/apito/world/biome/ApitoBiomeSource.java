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
import net.notridani.apito.Apito;
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
    private final RegistryEntry<Biome> grime_garden;
    private final RegistryEntry<Biome> labirinto_de_flores;
    private final RegistryEntry<Biome> reservatorio_profundo;
    private final RegistryEntry<Biome> promontorio;

    //NOVOS
    private final RegistryEntry<Biome> limear1;
    private final RegistryEntry<Biome> pseudo_city;
    private final RegistryEntry<Biome> limear2;
    private final RegistryEntry<Biome> limear3;
    private final RegistryEntry<Biome> marDeCadaveres;

    public boolean isInitialized() {
        return initialized;
    }

    private final DoublePerlinNoiseSampler DoublePerlinNoise1;
    private final DoublePerlinNoiseSampler DoublePerlinNoise2;
    private final DoublePerlinNoiseSampler DoublePerlinNoise3;


    public synchronized void init(long seed) {

        if (initialized) return;

        this.seed = seed;

        initialized = true;


    }

    public final Map<RegistryEntry<Biome>, ApitoBiomeData> apitoBiomeDataMap = new HashMap<>();



    public ApitoBiomeSource(RegistryEntryList<Biome> biomes) {

        this.DoublePerlinNoise1 = Noises.createPerlinNoise(
                seed,
                23,
                -7,
                1.0, 0.5, 0.25
        );

        this.DoublePerlinNoise2 = Noises.createPerlinNoise(
                seed,
                88,
                -6,
                1.0, 0.5, 0.25
        );

        this.DoublePerlinNoise3 = Noises.createPerlinNoise(
                seed,
                53,
                -7,
                1.0, 0.5, 0.25
        );

        this.biomes = biomes;

        this.nuloBiome = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of("apito", "nulo")))
                .findFirst()
                .orElseThrow();

        this.grime_garden = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of("apito", "grime_garden")))
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

        //NOVOS

        this.limear1 = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of(Apito.MOD_ID, "limear1")))
                .findFirst()
                .orElseThrow();

        this.pseudo_city = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of(Apito.MOD_ID, "pseudo_city")))
                .findFirst()
                .orElseThrow();

        this.limear2 = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of(Apito.MOD_ID, "limear2")))
                .findFirst()
                .orElseThrow();

        this.limear3 = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of(Apito.MOD_ID, "limear3")))
                .findFirst()
                .orElseThrow();

        this.marDeCadaveres = biomes.stream()
                .filter(b -> b.matchesId(
                        net.minecraft.util.Identifier.of(Apito.MOD_ID, "mar_de_cadaveres")))
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
                grime_garden,
                new ApitoBiomeData(
                        grime_garden,
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
                        50,
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


        //NOVOS
        apitoBiomeDataMap.put(
                limear1,
                new ApitoBiomeData(
                        limear1,
                        256,
                        Blocks.BLACKSTONE,
                        Blocks.BLACKSTONE,
                        Blocks.TUFF,
                        (float)0,
                        (float) 0,
                        0
                )
        );

        apitoBiomeDataMap.put(
                pseudo_city,
                new ApitoBiomeData(
                        pseudo_city,
                        pseudo_cidades+3,
                        Blocks.STONE_BRICKS,
                        Blocks.STONE_BRICKS,
                        Blocks.TUFF,
                        (float)0,
                        (float) 0,
                        0
                )
        );


        apitoBiomeDataMap.put(
                limear2,
                new ApitoBiomeData(
                        limear2,
                        pseudo_cidades,
                        Blocks.BLACKSTONE,
                        Blocks.BLACKSTONE,
                        Blocks.TUFF,
                        (float)0,
                        (float) 0,
                        0
                )
        );

        apitoBiomeDataMap.put(
                limear3,
                new ApitoBiomeData(
                        limear3,
                        48                   ,
                        Blocks.BLACKSTONE,
                        Blocks.TUFF,
                        Blocks.TUFF,
                        (float)0,
                        (float) 0,
                        0
                )
        );

        apitoBiomeDataMap.put(
                marDeCadaveres,
                new ApitoBiomeData(
                        marDeCadaveres,
                        -60,
                        Blocks.BLACKSTONE,
                        Blocks.BLACKSTONE,
                        Blocks.TUFF,
                        (float)0,
                        (float) 0,
                        -32
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
        double perlin1 = Noises.doublePerlinSample(DoublePerlinNoise1, blockX, 0, blockZ, 0.3);
        double perlin2 = Noises.doublePerlinSample(DoublePerlinNoise2, blockX, 0, blockZ, 0.1);
        double perlin3 = Noises.doublePerlinSample(DoublePerlinNoise3, blockX, 0, blockZ, 0.3);


        float areaCidades = 0f;
        double areaReservatorio = 0.1;

        switch (descobrirCamada(blockY)) {

            case SUPERFICIE ->
            {

            }

            case LIMEAR_1 ->
            {
                if(perlin1 < 0) {
                    return limear1;
                }
            }

            case PSEUDO_CIDADES ->
            {
                if(perlin2 < 0) {
                    return pseudo_city;
                }
            }

            case LIMEAR_2 ->
            {
                if(perlin2 < 0) {
                    return limear2;
                }
            }

            case LABIRINTOS ->
            {
                if(perlin3 < 0) {
                    return labirinto_de_flores;
                }
            }

            case LIMEAR_3 ->
            {
                if(perlin3 < 0) {
                    return limear3;
                }
            }

            case MAR_DE_CADAVERES ->
            {

                return marDeCadaveres;
            }

        }


        return nuloBiome;
    }

    public enum Camada {
        SUPERFICIE,
        LIMEAR_1,
        PSEUDO_CIDADES,
        LIMEAR_2,
        LABIRINTOS,
        LIMEAR_3,
        MAR_DE_CADAVERES,
        DEU_RUIM
    }

    public static int superficie = 272;
    public static int limear_1 = 240;
    public static int pseudo_cidades = 144;
    public static int limear_2 = 112;
    public static int labirintos = 48;
    public static int limear_3 = 16;
    public static int mar_de_cadaveres = -64;

    public Camada descobrirCamada(int y) {

        if (y >= superficie) {
            return Camada.SUPERFICIE;
        }

        if (y >= limear_1) {
            return Camada.LIMEAR_1;
        }

        if (y >= pseudo_cidades) {
            return Camada.PSEUDO_CIDADES;
        }

        if (y >= limear_2) {
            return Camada.LIMEAR_2;
        }

        if (y >= labirintos) {
            return Camada.LABIRINTOS;
        }

        if (y >= limear_3) {
            return Camada.LIMEAR_3;
        }

        if (y >= mar_de_cadaveres) {
            return Camada.MAR_DE_CADAVERES;
        }

        System.out.println("DEU RUIM");
        return Camada.DEU_RUIM;
    }


    @Override
    protected MapCodec<? extends BiomeSource> getCodec() {
        return CODEC;
    }
}