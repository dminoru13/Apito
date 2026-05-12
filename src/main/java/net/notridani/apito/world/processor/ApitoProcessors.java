package net.notridani.apito.world.processor;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;

public class ApitoProcessors {

    public static final StructureProcessorType<GrassToStoneProcessor>
            GRASS_TO_STONE = () -> GrassToStoneProcessor.CODEC;

    public static final StructureProcessorType<Florear>
            FLOREAR = () -> Florear.CODEC;

    public static void register() {

        Registry.register(
                Registries.STRUCTURE_PROCESSOR,
                Identifier.of(Apito.MOD_ID, "grass_to_stone"),
                GRASS_TO_STONE
        );

        Registry.register(
                Registries.STRUCTURE_PROCESSOR,
                Identifier.of(Apito.MOD_ID, "florear"),
                FLOREAR
        );
    }
}
