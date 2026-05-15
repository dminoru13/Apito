package net.notridani.apito.block;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.notridani.apito.block.fluid.FogFluid;

public class ModFluids {

    public static final FlowableFluid STILL_FOG =
            Registry.register(
                    Registries.FLUID,
                    Identifier.of("apito", "fog"),
                    new FogFluid.Still()
            );

    public static final FlowableFluid FLOWING_FOG =
            Registry.register(
                    Registries.FLUID,
                    Identifier.of("apito", "flowing_fog"),
                    new FogFluid.Flowing()
            );

    public static void register() {

    }
}