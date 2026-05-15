package net.notridani.apito.block.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.*;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.block.ModFluids;

public abstract class FogFluid extends FlowableFluid {

    @Override
    public Fluid getStill() {
        return ModFluids.STILL_FOG;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_FOG;
    }

    @Override
    public Item getBucketItem() {
        return null;
    }

    @Override
    protected void beforeBreakingBlock(
            net.minecraft.world.WorldAccess world,
            BlockPos pos,
            BlockState state
    ) {

    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }

    @Override
    public int getTickRate(WorldView world) {
        return Integer.MAX_VALUE;
    }

    @Override
    protected float getBlastResistance() {
        return 100f;
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == ModFluids.STILL_FOG ||
                fluid == ModFluids.FLOWING_FOG;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModBlocks.FOG_BLOCK
                .getDefaultState()
                .with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public boolean canBeReplacedWith(
            FluidState state,
            BlockView world,
            BlockPos pos,
            Fluid fluid,
            Direction direction
    ) {
        return false;
    }




    public static class Flowing extends FogFluid {

        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(Properties.LEVEL_1_8);
        }

        @Override
        protected boolean isInfinite(World world) {
            return false;
        }

        @Override
        protected int getMaxFlowDistance(WorldView world) {
            return 0;
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(Properties.LEVEL_1_8);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends FogFluid {

        @Override
        protected boolean isInfinite(World world) {
            return false;
        }

        @Override
        protected int getMaxFlowDistance(WorldView world) {
            return 0;
        }

        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}