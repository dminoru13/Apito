package net.notridani.apito.world;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;

import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.Blender;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.notridani.apito.world.noises.Noises;
import net.notridani.apito.world.biome.ApitoBiomeData;
import net.notridani.apito.world.biome.ApitoBiomeSource;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.lang.Math.min;

public class CorredorChunkGenerator extends ChunkGenerator {


    // ===== métodos obrigatórios =====

    @Override
    public void carve(ChunkRegion region, long seed, NoiseConfig noiseConfig,
                      net.minecraft.world.biome.source.BiomeAccess biomeAccess,
                      StructureAccessor structureAccessor, Chunk chunk,
                      net.minecraft.world.gen.GenerationStep.Carver carverStep) {
    }

    @Override
    public void populateEntities(ChunkRegion region) {
    }

    @Override
    public int getWorldHeight() {
        return 384;
    }

    @Override
    public int getSeaLevel() {
        return -64;
    }

    @Override
    public int getMinimumY() {
        return -64;
    }

    @Override
    public int getHeight(int x, int z, Heightmap.Type heightmap, HeightLimitView world, NoiseConfig noiseConfig) {
        return 64;
    }

    @Override
    public VerticalBlockSample getColumnSample(int x, int z, HeightLimitView world, NoiseConfig noiseConfig) {
        return new VerticalBlockSample(0, new net.minecraft.block.BlockState[0]);
    }

    @Override
    public void getDebugHudText(List<String> text, NoiseConfig noiseConfig, BlockPos pos) {
    }



    public static final MapCodec<CorredorChunkGenerator> CODEC =
            RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                            BiomeSource.CODEC.fieldOf("biome_source")
                                    .forGetter(gen -> gen.biomeSource)
                    ).apply(instance, CorredorChunkGenerator::new)
            );

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    //variaveis


    private final DoublePerlinNoiseSampler doublePerlinNoise;



    //METODOS QUE EU TO USANDO

    public CorredorChunkGenerator(BiomeSource biomeSource) {
        super(biomeSource);

        this.doublePerlinNoise = Noises.createPerlinNoise(
                3,
                23,
                -7,
                1.0, 0.5, 0.25
        );
    }



    @Override
    protected MapCodec<? extends ChunkGenerator> getCodec() {
        return CODEC;
    }



    @Override
    public CompletableFuture<Chunk> populateNoise(
            Blender blender,
            NoiseConfig noiseConfig,
            StructureAccessor accessor,
            Chunk chunk
    ) {


        BlockPos.Mutable pos = new BlockPos.Mutable();

        ChunkPos chunkPos = chunk.getPos();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {

                int worldX = chunkPos.getStartX() + x;
                int worldZ = chunkPos.getStartZ() + z;


                for(int camada = 0; camada < ApitoBiomeSource.Camada.values().length - 1; camada++ ) {
                    int altura_superficie = ApitoBiomeSource.superficie;
                    int altura_subterraneo = ApitoBiomeSource.subterraneo;
                    int altura_bequinhos = ApitoBiomeSource.bequinhos;
                    int altura_mar_de_cadaveres = ApitoBiomeSource.mar_de_cadaveres;

                    if(camada == 0) {
                        TerrainData terrain = sampleTerrain(
                                worldX,
                                altura_superficie+20,
                                worldZ,
                                noiseConfig
                        );

                        if (terrain == null) {
                            return CompletableFuture.completedFuture(chunk);
                        }

                        int altura_maxima = terrain.altura;

                        Block bloco_base = terrain.biomeData.bloco_base;

                        for (int y = altura_superficie; y <= altura_maxima; y++) {
                            chunk.setBlockState(pos.set(x, y, z), bloco_base.getDefaultState(), false);
                        }
                    }

                    if(camada == 1) {
                        TerrainData terrain = sampleTerrain(
                                worldX,
                                altura_subterraneo+20,
                                worldZ,
                                noiseConfig
                        );

                        if (terrain == null) {
                            return CompletableFuture.completedFuture(chunk);
                        }

                        int altura_maxima = min(terrain.altura, altura_superficie);

                        Block bloco_base = terrain.biomeData.bloco_base;


                        for (int y = altura_subterraneo; y <= altura_maxima; y++) {
                            chunk.setBlockState(pos.set(x, y, z), bloco_base.getDefaultState(), false);
                        }
                    }

                    if(camada == 2) {
                        TerrainData terrain = sampleTerrain(
                                worldX,
                                altura_bequinhos+20,
                                worldZ,
                                noiseConfig
                        );

                        if (terrain == null) {
                            return CompletableFuture.completedFuture(chunk);
                        }

                        int altura_maxima = min(terrain.altura, altura_subterraneo);

                        Block bloco_base = terrain.biomeData.bloco_base;


                        for (int y = altura_bequinhos; y <= altura_maxima; y++) {
                            chunk.setBlockState(pos.set(x, y, z), bloco_base.getDefaultState(), false);
                        }
                    }

                    if(camada == 3) {
                        TerrainData terrain = sampleTerrain(
                                worldX,
                                altura_mar_de_cadaveres+20,
                                worldZ,
                                noiseConfig
                        );

                        if (terrain == null) {
                            return CompletableFuture.completedFuture(chunk);
                        }

                        int altura_maxima = min(terrain.altura, altura_bequinhos);

                        Block bloco_base = terrain.biomeData.bloco_base;


                        for (int y = altura_mar_de_cadaveres; y <= altura_maxima; y++) {
                            chunk.setBlockState(pos.set(x, y, z), bloco_base.getDefaultState(), false);
                        }
                    }
                }


            }
        }

        return CompletableFuture.completedFuture(chunk);
    }


    @Override
    public void buildSurface(ChunkRegion region, StructureAccessor structures, NoiseConfig noiseConfig, Chunk chunk) {

        if (this.biomeSource instanceof ApitoBiomeSource source) {

            if (!source.isInitialized()) {
                source.init(region.toServerWorld().getSeed());
            }
        }


        corredores(region, chunk);


        //surface rules
        if (!(this.biomeSource instanceof ApitoBiomeSource source)) {
            return;
        }

        BlockPos.Mutable pos = new BlockPos.Mutable();
        ChunkPos chunkPos = chunk.getPos();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {

                int worldX = chunkPos.getStartX() + x;
                int worldZ = chunkPos.getStartZ() + z;

                int altura_superficie = ApitoBiomeSource.superficie;
                int altura_subterraneo = ApitoBiomeSource.subterraneo;
                int altura_bequinhos = ApitoBiomeSource.bequinhos;
                int altura_mar_de_cadaveres = ApitoBiomeSource.mar_de_cadaveres;


                criar_camada(altura_superficie, x, z, worldX, worldZ, chunk,pos,noiseConfig);
                criar_camada(altura_subterraneo, x, z, worldX, worldZ, chunk,pos,noiseConfig);
                criar_camada(altura_bequinhos, x, z, worldX, worldZ, chunk,pos,noiseConfig);
                criar_camada(altura_mar_de_cadaveres, x, z, worldX, worldZ, chunk,pos,noiseConfig);

            }
        }
    }


    //METODOS HELPER

    //TERRENO

    void criar_camada( int camadaAtual,int x, int z, int worldX,  int worldZ, Chunk chunk, BlockPos.Mutable pos, NoiseConfig noiseConfig) {
        TerrainData terrain = sampleTerrain(
                worldX,
                camadaAtual+20,
                worldZ,
                noiseConfig
        );

        if (terrain == null) {
            return;
        }

        ApitoBiomeData data = terrain.biomeData;

        int altura_maxima = terrain.altura;

        encher_de_agua(x,z,data.nivel_da_agua,altura_maxima,chunk,pos);
        criar_terreno(x,z,altura_maxima, terrain.biomeData.bloco_superficie,terrain.biomeData.bloco_intermediario, chunk, pos);
    }

    void criar_terreno(int x, int z, int altura_maxima, Block bloco_superficie, Block bloco_intermediario, Chunk chunk, BlockPos.Mutable pos) {
        for(int profundidade = 0; profundidade < 5; profundidade++) {

            int y = altura_maxima - profundidade;

            Block bloco;

            if (profundidade == 0) {
                bloco = bloco_superficie;
            } else {
                bloco = bloco_intermediario;
            }

            chunk.setBlockState(
                    pos.set(x,y,z),
                    bloco.getDefaultState(),
                    false
            );
        }
    }

    //AGUA
    void encher_de_agua(int x, int z,Integer nivel_agua, int altura_maxima, Chunk chunk, BlockPos.Mutable pos) {
        if(nivel_agua != null) {

            if (altura_maxima < nivel_agua) {

                for(int agua_atual = altura_maxima + 1; agua_atual <= nivel_agua; agua_atual++){
                    chunk.setBlockState(

                            pos.set(x,agua_atual,z),
                            Blocks.WATER.getDefaultState(),
                            false
                    );
                }
            }
        }
    }

    private TerrainData sampleTerrain(
            int worldX,
            int worldY,
            int worldZ,
            NoiseConfig noiseConfig
    ) {

        RegistryEntry<Biome> biome =
                this.biomeSource.getBiome(
                        worldX >> 2,
                        worldY >> 2,
                        worldZ >> 2,
                        noiseConfig.getMultiNoiseSampler()
                );

        if (!(this.biomeSource instanceof ApitoBiomeSource source)) {

            return null;
        }

        ApitoBiomeData data = source.getBiomeData(biome);

        double terrainNoise = Noises.doublePerlinSample(
                doublePerlinNoise,
                worldX,
                0,
                worldZ,
                data.frequencia_noise
        );

        int altura = data.Altura +
                (int)(terrainNoise * data.amplitude_noise);

        return new TerrainData(
                biome,
                data,
                altura
        );
    }

    private void corredores(ChunkRegion region, Chunk chunk) {
        int spacingChunks = 300;

        int chunkX = chunk.getPos().x;
        int chunkZ = chunk.getPos().z;

        // gera apenas em grid de chunks
        if (chunkX % spacingChunks != 0) return;

        StructureTemplateManager manager = region.toServerWorld().getStructureTemplateManager();

        StructureTemplate corredor = manager
                .getTemplate(Identifier.of("apito", "corredor0"))
                .orElse(null);

        if (corredor == null) return;

        BlockPos pos = new BlockPos(chunkX * 16, 64, chunkZ * 16);

        corredor.place(
                region,
                pos,
                pos,
                new StructurePlacementData(),
                region.getRandom(),
                3
        );
    }
}