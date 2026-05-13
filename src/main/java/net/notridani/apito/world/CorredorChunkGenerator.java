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

public class CorredorChunkGenerator extends ChunkGenerator {
    // ===== métodos obrigatórios =====

    @Override
    public void carve(ChunkRegion region, long seed, NoiseConfig noiseConfig, net.minecraft.world.biome.source.BiomeAccess biomeAccess, StructureAccessor structureAccessor, Chunk chunk, net.minecraft.world.gen.GenerationStep.Carver carverStep) {
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

    public static final MapCodec<CorredorChunkGenerator> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(BiomeSource.CODEC.fieldOf("biome_source").forGetter(gen -> gen.biomeSource)).apply(instance, CorredorChunkGenerator::new));

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //variaveis

    private final DoublePerlinNoiseSampler DoublePerlinNoise;

    //METODOS QUE EU TO USANDO
    public CorredorChunkGenerator(BiomeSource biomeSource) {
        super(biomeSource);
        this.DoublePerlinNoise = Noises.createPerlinNoise(3, 23, -7, 1.0, 0.5, 0.25);
    }

    @Override
    protected MapCodec<? extends ChunkGenerator> getCodec() {
        return CODEC;
    }

    @Override
    public CompletableFuture<Chunk> populateNoise(Blender blender, NoiseConfig noiseConfig, StructureAccessor accessor, Chunk chunk) {
        BlockPos.Mutable pos = new BlockPos.Mutable();
        ChunkPos chunkPos = chunk.getPos();
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int worldX = chunkPos.getStartX() + x;
                int worldZ = chunkPos.getStartZ() + z;
                RegistryEntry<Biome> biome = this.biomeSource.getBiome(worldX >> 2, 0, worldZ >> 2, noiseConfig.getMultiNoiseSampler());
                if (!(this.biomeSource instanceof ApitoBiomeSource source)) {
                    return CompletableFuture.completedFuture(chunk);
                }
                ApitoBiomeData data = source.getBiomeData(biome);
                double terrainNoise = Noises.doublePerlinSample(DoublePerlinNoise, worldX, 0, worldZ, data.frequencia_noise);
                int altura_maxima = data.Altura + (int) (terrainNoise * data.amplitude_noise);
                Block bloco_bsae = data.bloco_base;
                for (int y = getMinimumY(); y <= altura_maxima; y++) {
                    chunk.setBlockState(pos.set(x, y, z), bloco_bsae.getDefaultState(), false);
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
                RegistryEntry<Biome> biome = this.biomeSource.getBiome(worldX >> 2, 0, worldZ >> 2, noiseConfig.getMultiNoiseSampler());
                ApitoBiomeData data = source.getBiomeData(biome);
                double terrainNoise = Noises.doublePerlinSample(DoublePerlinNoise, worldX, 0, worldZ, data.frequencia_noise);
                int altura_maxima = data.Altura + (int) (terrainNoise * data.amplitude_noise);

                //AGUA

                if (isInt(data.nivel_da_agua)) {
                    int nivel_agua = Integer.parseInt(data.nivel_da_agua);
                    if (altura_maxima < nivel_agua) {
                        for (int agua_atual = altura_maxima + 1; agua_atual <= nivel_agua; agua_atual++) {
                            chunk.setBlockState(pos.set(x, agua_atual, z), Blocks.WATER.getDefaultState(), false);
                        }
                    }
                }

                //TERRENO

                for (int profundidade = 0; profundidade < 5; profundidade++) {
                    int y = altura_maxima - profundidade;
                    Block bloco;
                    if (profundidade == 0) {
                        bloco = data.bloco_superficie;
                    } else if (profundidade < 4 + altura_maxima / 2) {
                        bloco = data.bloco_intermediario;
                    } else {
                        bloco = data.bloco_base;
                    }
                    chunk.setBlockState(pos.set(x, y, z), bloco.getDefaultState(), false);
                }

                //OCEANO

            }
        }
    }

//METODOS HELPER

    private void corredores(ChunkRegion region, Chunk chunk) {
        int spacingChunks = 300;
        int chunkX = chunk.getPos().x;
        int chunkZ = chunk.getPos().z;

        // gera apenas em grid de chunks

        if (chunkX % spacingChunks != 0) return;
        StructureTemplateManager manager = region.toServerWorld().getStructureTemplateManager();
        StructureTemplate corredor = manager.getTemplate(Identifier.of("apito", "corredor0")).orElse(null);
        if (corredor == null) return;
        BlockPos pos = new BlockPos(chunkX * 16, 64, chunkZ * 16);
        corredor.place(region, pos, pos, new StructurePlacementData(), region.getRandom(), 3);
    }
}