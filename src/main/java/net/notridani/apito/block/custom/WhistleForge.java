package net.notridani.apito.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.notridani.apito.block.entity.custom.WhistleForgeEntity;
import org.jetbrains.annotations.Nullable;

public class WhistleForge extends HorizontalFacingBlock implements BlockEntityProvider {
    private static VoxelShape SHAPE =
            BlockWithEntity.createCuboidShape(0,0,0,16,16,16);
    public static final MapCodec<WhistleForge> CODEC = createCodec(WhistleForge::new);

    public WhistleForge(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }


    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WhistleForgeEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);

            if (blockEntity instanceof WhistleForgeEntity) {
                ItemScatterer.spawn(world,pos,((WhistleForgeEntity) blockEntity));
                world.updateComparators(pos,this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }


    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if (world.getBlockEntity(pos) instanceof WhistleForgeEntity whistleForgeEntity) {
            if(whistleForgeEntity.isEmpty() && !stack.isEmpty() && !player.isSneaking()) {
                whistleForgeEntity.setStack(0,stack.copyWithCount(1));
                world.playSound(player,pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f,2f);
                stack.decrement(1);

                whistleForgeEntity.markDirty();
                world.updateListeners(pos, state, state, 0);

            } else if(stack.isEmpty() && !whistleForgeEntity.isEmpty() && !player.isSneaking()) {
                ItemStack stackOnForge = whistleForgeEntity.getStack(0);
                player.setStackInHand(Hand.MAIN_HAND, stackOnForge);
                world.playSound(player,pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f,2f);
                whistleForgeEntity.clear();


                whistleForgeEntity.markDirty();
                world.updateListeners(pos, state, state, 0);
            }
        }


        return ItemActionResult.SUCCESS;
    }
}
