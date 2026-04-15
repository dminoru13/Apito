package net.notridani.apito.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FelpsLamp extends Block {
    public static  final IntProperty CARA = IntProperty.of("cara", 0, 5);

    public FelpsLamp(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(CARA, 0));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        int cara_atual = state.get(CARA);
        int nova_cara = 0;

        if( cara_atual != 5) {
            nova_cara = cara_atual + 1;
        }

        else {
            nova_cara = 0;
        }

        if(!world.isClient()) {
            world.setBlockState(pos, state.with(CARA, nova_cara));
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CARA);
    }
}
