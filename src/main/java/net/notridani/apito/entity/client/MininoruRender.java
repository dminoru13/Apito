package net.notridani.apito.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.notridani.apito.Apito;
import net.notridani.apito.entity.custom.MininoruEntity;
import net.notridani.apito.entity.custom.MininoruVariant;

import java.util.Map;

public class MininoruRender extends MobEntityRenderer<MininoruEntity, MininoruModel<MininoruEntity>> {
    private static final Map<MininoruVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(MininoruVariant.class), map -> {
                map.put(MininoruVariant.DEFAULT,
                        Identifier.of(Apito.MOD_ID, "textures/entity/mininoru/mininoru.png"));
                map.put(MininoruVariant.AQUELE_CARA,
                        Identifier.of(Apito.MOD_ID, "textures/entity/mininoru/aquele_cara.png"));
            });

    public MininoruRender(EntityRendererFactory.Context context) {
        super(context, new MininoruModel<>(context.getPart(MininoruModel.MININORU)), 0.3f);
    }

    @Override
    public Identifier getTexture(MininoruEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(MininoruEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.9f,0.8f,0.9f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);

    }
}
