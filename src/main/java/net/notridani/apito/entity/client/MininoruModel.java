package net.notridani.apito.entity.client;

// Made with Blockbench 5.1.3

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.notridani.apito.Apito;
import net.notridani.apito.entity.custom.MininoruEntity;

public class MininoruModel<T extends MininoruEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer MININORU = new EntityModelLayer(Identifier.of(Apito.MOD_ID, "mininoru"), "main");

    private final ModelPart Control;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart arrogue1;
    private final ModelPart headwear;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart left_leg;
    private final ModelPart right_leg;
    public MininoruModel(ModelPart root) {
        this.Control = root.getChild("Control");
        this.body = this.Control.getChild("body");
        this.head = this.body.getChild("head");
        this.arrogue1 = this.head.getChild("arrogue1");
        this.headwear = this.head.getChild("headwear");
        this.left_arm = this.body.getChild("left_arm");
        this.right_arm = this.body.getChild("right_arm");
        this.left_leg = this.Control.getChild("left_leg");
        this.right_leg = this.Control.getChild("right_leg");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Control = modelPartData.addChild("Control", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 18.0F, -1.0F));

        ModelPartData body = Control.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData body_r1 = body.addChild("body_r1", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, -4.0F, -2.0F, 6.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -4.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(28, 16).cuboid(-5.0F, -9.0F, -5.0F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.0F, -1.0F, 0.0F, 0.0F, 0.0436F));

        ModelPartData arrogue1 = head.addChild("arrogue1", ModelPartBuilder.create().uv(0, 5).cuboid(-0.7758F, -2.8164F, 0.0468F, 3.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -9.0F, -2.0F, -0.2618F, -0.3927F, 0.0F));

        ModelPartData headwear = head.addChild("headwear", ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 0.0F, 1.0F));

        ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -7.0F, 0.0F));

        ModelPartData left_arm_r1 = left_arm.addChild("left_arm_r1", ModelPartBuilder.create().uv(20, 16).cuboid(0.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -7.0F, 0.0F));

        ModelPartData right_arm_r1 = right_arm.addChild("right_arm_r1", ModelPartBuilder.create().uv(20, 25).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        ModelPartData left_leg = Control.addChild("left_leg", ModelPartBuilder.create().uv(0, 28).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

        ModelPartData right_leg = Control.addChild("right_leg", ModelPartBuilder.create().uv(8, 28).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 70, 79);
    }
    @Override
    public void setAngles(MininoruEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);
    }


    private void setHeadAngles(float headYawm, float headPitch) {
        headYawm = MathHelper.clamp(headYawm, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYawm * 0.1745329F;
        this.head.pitch = headPitch * 0.1745329F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        Control.render(matrices, vertexConsumer, light, overlay, color);
    }

    public ModelPart getPart() {
        return Control;
    }
}
