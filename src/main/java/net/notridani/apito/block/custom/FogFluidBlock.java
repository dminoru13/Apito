package net.notridani.apito.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class FogFluidBlock extends FluidBlock {

    public FogFluidBlock(FlowableFluid fluid, Settings settings) {
        super(fluid, settings);
    }

    @Override
    protected float getAmbientOcclusionLightLevel(
            BlockState state,
            BlockView world,
            BlockPos pos
    ) {
        return 1.0f;
    }
}