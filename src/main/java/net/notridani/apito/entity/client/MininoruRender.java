package net.notridani.apito.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.entity.custom.MininoruEntity;

public class MininoruRender extends MobEntityRenderer<MininoruEntity, MininoruModel<MininoruEntity>> {

    public MininoruRender(EntityRendererFactory.Context context) {
        super(context, new MininoruModel<>(context.getPart(MininoruModel.MININORU)), 0.3f);
    }

    @Override
    public Identifier getTexture(MininoruEntity entity) {
        return Identifier.of(Apito.MOD_ID, "textures/entity/mininoru/mininoru.png");
    }

    @Override
    public void render(MininoruEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f,0.5f,0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);

    }
}
