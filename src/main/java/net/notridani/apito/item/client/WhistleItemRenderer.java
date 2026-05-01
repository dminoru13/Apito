package net.notridani.apito.item.client;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.notridani.apito.Apito;
import net.notridani.apito.component.ModDataComponentTypes;

public class WhistleItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {


    @Override
    public void render(ItemStack stack,
                       ModelTransformationMode mode,
                       MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers,
                       int light,
                       int overlay) {
        System.out.println("RENDER WHISTLE");

        var data = stack.get(ModDataComponentTypes.WHISTLE_DATA);
        if (data == null) return;

        matrices.push();

        // leve ajuste pra parecer item “flat bonito”
        matrices.scale(1.0f, 1.0f, 1.0f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));

        // =========================
        // BASE LAYER
        // =========================
        renderLayer(
                matrices,
                vertexConsumers,
                light,
                overlay,
                Identifier.of(Apito.MOD_ID,
                        "textures/item/apito/base_" + data.base() + ".png")
        );

        // =========================
        // ENTALHE LAYER
        // =========================
        if (data.entalhe() != -1) {
            renderLayer(
                    matrices,
                    vertexConsumers,
                    light,
                    overlay,
                    Identifier.of(Apito.MOD_ID,
                            "textures/item/apito/entalhe_" + data.entalhe() + "-" + data.tier() + ".png")
            );
        }

        // =========================
        // GEMA LAYER
        // =========================
        if (data.gema() != -1) {
            renderLayer(
                    matrices,
                    vertexConsumers,
                    light,
                    overlay,
                    Identifier.of(Apito.MOD_ID,
                            "textures/item/apito/gema_" + data.gema() + ".png")
            );
        }

        matrices.pop();
    }


    private void renderLayer(MatrixStack matrices,
                             VertexConsumerProvider vertexConsumers,
                             int light,
                             int overlay,
                             Identifier texture) {

        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(texture));

        MatrixStack.Entry entry = matrices.peek();
        var matrix = entry.getPositionMatrix();

        float min = -0.5f;
        float max = 0.5f;
        float z = 0.0625f;

        vc.vertex(matrix, min, min, z)
                .color(255, 255, 255, 255)
                .texture(0, 1)
                .overlay(overlay)
                .light(light)
                .normal(0f, 0f, 1f);

        vc.vertex(matrix, max, min, z)
                .color(255, 255, 255, 255)
                .texture(1, 1)
                .overlay(overlay)
                .light(light)
                .normal(0f, 0f, 1f);

        vc.vertex(matrix, max, max, z)
                .color(255, 255, 255, 255)
                .texture(1, 0)
                .overlay(overlay)
                .light(light)
                .normal(0f, 0f, 1f);

        vc.vertex(matrix, min, max, z)
                .color(255, 255, 255, 255)
                .texture(0, 0)
                .overlay(overlay)
                .light(light)
                .normal(0f, 0f, 1f);
    }
}