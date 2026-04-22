package net.notridani.apito.entity.client;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.entity.custom.GolboEntity;
import net.notridani.apito.entity.custom.MininoruEntity;

// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class GolboModel<T extends GolboEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer GOLBO = new EntityModelLayer(Identifier.of(Apito.MOD_ID, "golbo"), "main");

    private final ModelPart Control;
    private final ModelPart segmento1;
    private final ModelPart cabeca;
    private final ModelPart tromba;
    private final ModelPart tromba2;
    private final ModelPart olho;
    private final ModelPart PUPILA;
    private final ModelPart pernaEC;
    private final ModelPart bone;
    private final ModelPart pernaDC;
    private final ModelPart bone2;
    private final ModelPart segmento2;
    private final ModelPart pernaEB;
    private final ModelPart bone3;
    private final ModelPart pernaDB;
    private final ModelPart bone4;
    private final ModelPart cauda;
    private final ModelPart cauda2;
    private final ModelPart cauda3;
    private final ModelPart cauda4;
    public GolboModel(ModelPart root) {
        this.Control = root.getChild("Control");
        this.segmento1 = this.Control.getChild("segmento1");
        this.cabeca = this.segmento1.getChild("cabeca");
        this.tromba = this.cabeca.getChild("tromba");
        this.tromba2 = this.tromba.getChild("tromba2");
        this.olho = this.cabeca.getChild("olho");
        this.PUPILA = this.olho.getChild("PUPILA");
        this.pernaEC = this.segmento1.getChild("pernaEC");
        this.bone = this.pernaEC.getChild("bone");
        this.pernaDC = this.segmento1.getChild("pernaDC");
        this.bone2 = this.pernaDC.getChild("bone2");
        this.segmento2 = this.Control.getChild("segmento2");
        this.pernaEB = this.segmento2.getChild("pernaEB");
        this.bone3 = this.pernaEB.getChild("bone3");
        this.pernaDB = this.segmento2.getChild("pernaDB");
        this.bone4 = this.pernaDB.getChild("bone4");
        this.cauda = this.segmento2.getChild("cauda");
        this.cauda2 = this.cauda.getChild("cauda2");
        this.cauda3 = this.cauda2.getChild("cauda3");
        this.cauda4 = this.cauda3.getChild("cauda4");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Control = modelPartData.addChild("Control", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData segmento1 = Control.addChild("segmento1", ModelPartBuilder.create().uv(0, 7).cuboid(-4.0F, -1.0F, 0.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -1.0F, -1.0F));

        ModelPartData cabeca = segmento1.addChild("cabeca", ModelPartBuilder.create().uv(0, 19).cuboid(-3.0F, -1.0F, 0.0F, 3.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 4.0F));

        ModelPartData tromba = cabeca.addChild("tromba", ModelPartBuilder.create().uv(16, 13).cuboid(-3.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 3.0F));

        ModelPartData tromba2 = tromba.addChild("tromba2", ModelPartBuilder.create().uv(18, 0).cuboid(-3.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

        ModelPartData olho = cabeca.addChild("olho", ModelPartBuilder.create().uv(0, 13).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -1.0F, 1.0F));

        ModelPartData PUPILA = olho.addChild("PUPILA", ModelPartBuilder.create().uv(16, 7).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

        ModelPartData pernaEC = segmento1.addChild("pernaEC", ModelPartBuilder.create().uv(0, 24).cuboid(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -2.0F, 4.0F));

        ModelPartData bone = pernaEC.addChild("bone", ModelPartBuilder.create().uv(0, 26).cuboid(-2.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 0.0F, 0.0F));

        ModelPartData pernaDC = segmento1.addChild("pernaDC", ModelPartBuilder.create().uv(8, 24).cuboid(0.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, 0.0F, 2.0F));

        ModelPartData bone2 = pernaDC.addChild("bone2", ModelPartBuilder.create().uv(6, 26).cuboid(-2.0F, -2.0F, 0.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, -1.0F));

        ModelPartData segmento2 = Control.addChild("segmento2", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -1.0F, -5.0F, 4.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -1.0F, -1.0F));

        ModelPartData pernaEB = segmento2.addChild("pernaEB", ModelPartBuilder.create().uv(20, 25).cuboid(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -2.0F, -4.0F));

        ModelPartData bone3 = pernaEB.addChild("bone3", ModelPartBuilder.create().uv(12, 26).cuboid(-2.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 0.0F, 0.0F));

        ModelPartData pernaDB = segmento2.addChild("pernaDB", ModelPartBuilder.create().uv(24, 27).cuboid(-1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 0.0F, -2.0F));

        ModelPartData bone4 = pernaDB.addChild("bone4", ModelPartBuilder.create().uv(18, 27).cuboid(-2.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.0F, 0.0F));

        ModelPartData cauda = segmento2.addChild("cauda", ModelPartBuilder.create().uv(12, 19).cuboid(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 1.0F, -5.0F));

        ModelPartData cauda2 = cauda.addChild("cauda2", ModelPartBuilder.create().uv(20, 19).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -2.0F));

        ModelPartData cauda3 = cauda2.addChild("cauda3", ModelPartBuilder.create().uv(20, 22).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -2.0F));

        ModelPartData cauda4 = cauda3.addChild("cauda4", ModelPartBuilder.create().uv(12, 23).cuboid(-2.0F, -1.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 0.0F, -2.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(GolboEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);


        switch (entity.getState()) {

            case IDLE -> {
                this.updateAnimation(
                        entity.idleAnimationState,
                        GolboAnimations.idle,
                        ageInTicks,
                        1f
                );
            }

            case SEM_PERNA -> {
                this.updateAnimation(
                        entity.idleAnimationState,
                        GolboAnimations.idle_sem_perna,
                        ageInTicks,
                        1f
                );
            }

            case CRESCENDO -> {
                this.updateAnimation(
                        entity.idleAnimationState,
                        GolboAnimations.crescendo_perna,
                        ageInTicks,
                        0.1f
                );
            }
        }


    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        Control.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return this.Control;
    }
}