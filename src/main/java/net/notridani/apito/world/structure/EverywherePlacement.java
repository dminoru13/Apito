package net.notridani.apito.world.structure;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.chunk.placement.StructurePlacement;
import net.minecraft.world.gen.chunk.placement.StructurePlacementCalculator;
import net.minecraft.world.gen.chunk.placement.StructurePlacementType;

import java.util.Optional;

public class EverywherePlacement extends StructurePlacement {

    public static final MapCodec<EverywherePlacement> CODEC =
            MapCodec.unit(new EverywherePlacement());

    public EverywherePlacement() {
        super(
                new Vec3i(0, 0, 0),
                StructurePlacement.FrequencyReductionMethod.DEFAULT,
                1.0f,
                1,
                Optional.empty()
        );
    }

    @Override
    protected boolean isStartChunk(StructurePlacementCalculator calculator, int chunkX, int chunkZ) {
        return true;
    }

    @Override
    public StructurePlacementType<?> getType() {
        return ApitoStructurePlacements.EVERYWHERE;
    }
}
