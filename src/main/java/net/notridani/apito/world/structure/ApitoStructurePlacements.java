package net.notridani.apito.world.structure;


import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.chunk.placement.StructurePlacementType;
import net.notridani.apito.Apito;

public class ApitoStructurePlacements {

    public static final StructurePlacementType<EverywherePlacement> EVERYWHERE =
            () -> EverywherePlacement.CODEC;

    public static void register() {
        Registry.register(
                Registries.STRUCTURE_PLACEMENT,
                Identifier.of(Apito.MOD_ID, "everywhere"),
                EVERYWHERE
        );
    }
}