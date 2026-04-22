package net.notridani.apito.entity.client;

// Save this class in your mod and generate all required imports

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

/**
 * Made with Blockbench 5.1.3
 * Exported for Minecraft version 1.19 or later with Yarn mappings
 * @author Author
 */
public class GolboAnimations {
    public static final Animation idle = Animation.Builder.create(4.0F).looping()
            .addBoneAnimation("segmento1", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("segmento1", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.1F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("segmento1", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.0F, AnimationHelper.createScalingVector(1.0F, 1.16F, 1.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.0F, AnimationHelper.createScalingVector(1.0F, 1.16F, 1.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.9583F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("pernaEC", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("pernaEC", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.9F, -0.1F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("pernaEC", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 0.86F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 32.5F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.3F, -0.2F, -0.1F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 0.87F, 0.86F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("pernaEB", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -30.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("pernaEB", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.1F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("pernaEB", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.03F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone3", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 37.5F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone3", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.3F, -0.2F, -0.1F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone3", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 0.82F, 0.83F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone4", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -10.0F, -5.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cabeca", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cabeca", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-0.1F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cabeca", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.77F, 0.96F, 0.88F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("tromba", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("tromba", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.68F, 0.54F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("tromba2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("tromba2", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.93F, 0.9F, 0.58F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 0.7F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda2", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.02F, 2.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda3", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda3", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.83F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda4", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda4", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.89F, 0.9F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("olho", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(1.5475F, -0.7801F, -7.1297F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("olho", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.6F, -0.2F, 0.6F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("olho", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.55F, 0.41F, 0.47F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("segmento2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("segmento2", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 0.9F, 1.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(2.0417F, AnimationHelper.createScalingVector(1.0F, 1.03F, 1.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(4.0F, AnimationHelper.createScalingVector(1.0F, 0.9F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("PUPILA", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.9F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("PUPILA", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.78F, 1.74F, 0.84F), Transformation.Interpolations.LINEAR)
            ))
            .build();

    public static final Animation idle_sem_perna = Animation.Builder.create(1.0F).looping()
            .addBoneAnimation("segmento1", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("segmento1", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.1F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("segmento1", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.2083F, AnimationHelper.createScalingVector(1.0F, 1.16F, 1.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.4583F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.75F, AnimationHelper.createScalingVector(1.0F, 1.16F, 1.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.9583F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("pernaEC", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("pernaEC", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.9F, -0.1F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("pernaEC", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 0.86F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.3F, -0.2F, -0.1F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.0F, 0.87F, 0.86F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone2", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(-0.1F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("pernaEB", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -30.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("pernaEB", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.1F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("pernaEB", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.03F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone3", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone3", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.3F, -0.2F, -0.1F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone3", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(-0.2F, 0.82F, 0.83F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone4", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -10.0F, -5.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("bone4", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(-0.1F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cabeca", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cabeca", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-0.1F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cabeca", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.77F, 0.96F, 0.88F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("tromba", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("tromba", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.68F, 0.54F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("tromba2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("tromba2", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.93F, 0.9F, 0.58F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda2", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 4.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda2", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.32F, 0.8F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda3", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda3", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 2.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda3", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.83F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda4", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda4", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-2.0F, 0.0F, 2.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("cauda4", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.89F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("olho", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(1.5475F, -0.7801F, -7.1297F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("olho", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.6F, -0.2F, 0.6F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("olho", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.55F, 0.41F, 0.47F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("segmento2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("segmento2", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 0.9F, 1.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.5F, AnimationHelper.createScalingVector(1.0F, 1.03F, 1.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.0F, AnimationHelper.createScalingVector(1.0F, 0.9F, 1.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("PUPILA", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.9F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("PUPILA", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(0.78F, 1.74F, 0.84F), Transformation.Interpolations.LINEAR)
            ))
            .build();

        public static final Animation crescendo_perna = Animation.Builder.create(6.0F)
                .addBoneAnimation("segmento1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("segmento1", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.1F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("segmento1", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("pernaEC", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.LINEAR),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("pernaEC", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.9F, -0.1F), Transformation.Interpolations.LINEAR),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, -0.9F, -0.1F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("pernaEC", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 0.86F), Transformation.Interpolations.LINEAR),
                        new Keyframe(3.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 0.86F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("bone", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("bone", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.3F, -0.2F, -0.1F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("bone", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.3F, 0.87F, 0.86F), Transformation.Interpolations.LINEAR),
                        new Keyframe(6.0F, AnimationHelper.createScalingVector(0.9F, 0.87F, 0.86F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("pernaDC", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("pernaDC", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("pernaDC", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(3.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("bone2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("bone2", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.2F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(6.0F, AnimationHelper.createScalingVector(0.9F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("pernaEB", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -30.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -30.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("pernaEB", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.1F), Transformation.Interpolations.LINEAR),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.1F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("pernaEB", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.03F), Transformation.Interpolations.LINEAR),
                        new Keyframe(3.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.03F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("bone3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("bone3", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.3F, -0.2F, -0.1F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("bone3", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.3F, 0.82F, 0.83F), Transformation.Interpolations.LINEAR),
                        new Keyframe(6.0F, AnimationHelper.createScalingVector(1.0F, 0.82F, 0.83F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("pernaDB", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("pernaDB", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("pernaDB", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(3.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("bone4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -10.0F, -5.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("bone4", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.3F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(6.0F, AnimationHelper.createScalingVector(1.1F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("cabeca", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("cabeca", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-0.1F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("cabeca", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.77F, 0.96F, 0.88F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("tromba", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("tromba", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.68F, 0.54F, 1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("tromba2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("tromba2", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.93F, 0.9F, 0.58F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("cauda2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("cauda2", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(6.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("cauda2", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.32F, 1.6F, 1.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(6.0F, AnimationHelper.createScalingVector(1.02F, 2.0F, 1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("cauda3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("cauda3", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 2.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(6.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("cauda3", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.83F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(6.0F, AnimationHelper.createScalingVector(0.83F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("cauda4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("cauda4", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-2.0F, 0.0F, 2.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(6.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("cauda4", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.89F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(6.0F, AnimationHelper.createScalingVector(0.89F, 0.9F, 1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("olho", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(1.5475F, -0.7801F, -7.1297F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("olho", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.6F, -0.2F, 0.6F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("olho", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.55F, 0.41F, 0.47F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("segmento2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("segmento2", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 0.9F, 1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("PUPILA", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.9F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("PUPILA", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.78F, 1.74F, 0.84F), Transformation.Interpolations.LINEAR)
                ))
                .build();
}
