package net.notridani.apito.world.processor;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.PlacedFeature;

public class Florear extends StructureProcessor {

    public static final Florear INSTANCE = new Florear();

    public static final MapCodec<Florear> CODEC =
            MapCodec.unit(INSTANCE);

    @Override
    public StructureTemplate.StructureBlockInfo process(
            WorldView world,
            BlockPos pos,
            BlockPos pivot,
            StructureTemplate.StructureBlockInfo originalBlockInfo,
            StructureTemplate.StructureBlockInfo currentBlockInfo,
            StructurePlacementData data
    ) {


        if (!currentBlockInfo.state().isOf(Blocks.SEA_LANTERN)) {
            return currentBlockInfo;
        }


        if (world instanceof StructureWorldAccess structureWorld) {

            RegistryEntry<PlacedFeature> feature =
                    structureWorld.getRegistryManager()
                            .get(RegistryKeys.PLACED_FEATURE)
                            .getEntry(
                                    Identifier.of("minecraft", "flower_plain")
                            )
                            .orElseThrow();

            feature.value().generateUnregistered(
                    structureWorld,
                    structureWorld.toServerWorld()
                            .getChunkManager()
                            .getChunkGenerator(),
                    structureWorld.getRandom(),
                    currentBlockInfo.pos()
            );
        }

        return new StructureTemplate.StructureBlockInfo(
                currentBlockInfo.pos(),
                Blocks.AIR.getDefaultState(),
                null
        );
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return ApitoProcessors.FLOREAR;
    }
}