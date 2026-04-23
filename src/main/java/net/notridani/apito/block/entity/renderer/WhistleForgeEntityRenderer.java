package net.notridani.apito.block.entity.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.notridani.apito.block.custom.WhistleForge;
import net.notridani.apito.block.entity.custom.WhistleForgeEntity;

public class WhistleForgeEntityRenderer implements BlockEntityRenderer<WhistleForgeEntity> {
    public WhistleForgeEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(WhistleForgeEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = entity.getStack(0);

        Direction direction = entity.getCachedState().get(WhistleForge.FACING);

        matrices.push();

        // Move pro centro primeiro
        matrices.translate(0.5f, 0.5f, 0.5f);

        // Rotaciona baseado na direção
        switch (direction) {
            case NORTH -> {}
            case SOUTH -> matrices.multiply(net.minecraft.util.math.RotationAxis.POSITIVE_Y.rotationDegrees(180));
            case WEST  -> matrices.multiply(net.minecraft.util.math.RotationAxis.POSITIVE_Y.rotationDegrees(90));
            case EAST  -> matrices.multiply(net.minecraft.util.math.RotationAxis.POSITIVE_Y.rotationDegrees(-90));
        }

// Depois posiciona o item relativo à frente do bloco
        matrices.translate(0.0f, 0.0f, -0.36f);

// Escala
        matrices.scale(0.3f, 0.3f, 0.4f);
        itemRenderer.renderItem(stack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight,sLight);
    }

}
