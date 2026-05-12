package net.notridani.apito.world.processor;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;


public class GrassToStoneProcessor extends StructureProcessor {

    public static final GrassToStoneProcessor INSTANCE =
            new GrassToStoneProcessor();

    public static final MapCodec<GrassToStoneProcessor> CODEC =
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

        if (!currentBlockInfo.state().isOf(Blocks.GRASS_BLOCK)) {
            return currentBlockInfo;
        }

        BlockPos blockPos = currentBlockInfo.pos();

        boolean exposed =
                isAir(world, blockPos.north()) ||
                        isAir(world, blockPos.south()) ||
                        isAir(world, blockPos.east())  ||
                        isAir(world, blockPos.west());

        // só cria borda em blocos expostos na superfície
        boolean topAir = isAir(world, blockPos.up());

        if (exposed && topAir) {

            return new StructureTemplate.StructureBlockInfo(
                    blockPos,
                    Blocks.STONE.getDefaultState(),
                    currentBlockInfo.nbt()
            );
        }

        return currentBlockInfo;
    }

    private boolean isAir(WorldView world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        return state.isAir();
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return ApitoProcessors.GRASS_TO_STONE;
    }
}