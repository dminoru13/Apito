package net.notridani.apito.world;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;

import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.structure.pool.alias.StructurePoolAliasLookup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;

import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;

import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.Blender;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.minecraft.world.gen.structure.DimensionPadding;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class CorredorChunkGenerator extends ChunkGenerator {

    // 🔥 CODEC correto (recebe biome_source do JSON)
    public static final MapCodec<CorredorChunkGenerator> CODEC =
            RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                            BiomeSource.CODEC.fieldOf("biome_source")
                                    .forGetter(gen -> gen.biomeSource)
                    ).apply(instance, CorredorChunkGenerator::new)
            );

    public CorredorChunkGenerator(BiomeSource biomeSource) {
        super(biomeSource);
    }

    @Override
    protected MapCodec<? extends ChunkGenerator> getCodec() {
        return CODEC;
    }



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
        return 0;
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


    //METODOS QUE EU TO USANDO


    @Override
    public CompletableFuture<Chunk> populateNoise(
            Blender blender,
            NoiseConfig noiseConfig,
            StructureAccessor accessor,
            Chunk chunk
    ) {
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = getMinimumY(); y < 208; y++) {
                    chunk.setBlockState(pos.set(x, y, z),
                            Blocks.STONE.getDefaultState(),
                            false);
                }
            }
        }

        return CompletableFuture.completedFuture(chunk);
    }


    @Override
    public void buildSurface(ChunkRegion region, StructureAccessor structures, NoiseConfig noiseConfig, Chunk chunk) {

        corredores(region, chunk);
    }


    //METODOS HELPER


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