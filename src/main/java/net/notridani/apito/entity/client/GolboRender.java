package net.notridani.apito.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.entity.custom.GolboEntity;
import net.notridani.apito.entity.custom.MininoruEntity;

public class GolboRender extends MobEntityRenderer<GolboEntity, GolboModel<GolboEntity>> {
    public GolboRender(EntityRendererFactory.Context context) {
        super(context, new GolboModel<>(context.getPart(GolboModel.GOLBO)), 0.35f);
    }

    @Override
    public Identifier getTexture(GolboEntity entity) {
        return Identifier.of(Apito.MOD_ID, "textures/entity/golbo/golbo.png");
    }

    @Override
    public void render(GolboEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.9f,0.8f,0.9f);
        } else {
            matrixStack.scale(2f,2f,2f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);

    }
}
