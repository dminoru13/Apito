package net.notridani.apito.entity.client;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class MininoruAnimations {
    /**
     * Made with Blockbench 5.1.3
     * Exported for Minecraft version 1.19 or later with Yarn mappings
     * @author Author
     */
    public class mininoruAnimation {
        public static final Animation ANIM_MININORU_IDLE = Animation.Builder.create(1.5417F).looping()
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, -5.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("arrogue1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .build();

        public static final Animation ANIM_MININORU_WALK = Animation.Builder.create(1.0F).looping()
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -62.5F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -105.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-35.7589F, -4.8128F, -54.7578F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-90.1848F, 8.3563F, -36.465F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -62.5F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 67.5F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 67.5F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-73.5297F, 24.093F, 74.3818F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-68.1937F, -35.1003F, 54.4484F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 67.5F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.125F, AnimationHelper.createRotationalVector(-72.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(47.5F, 0.0F, -17.5F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-72.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(47.5F, 0.0F, -17.5F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.125F, AnimationHelper.createRotationalVector(47.5F, 0.0F, 22.5F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-85.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(47.5F, 0.0F, 22.5F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-85.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("Control", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 22.5F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 22.5F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("Control", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.125F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .build();
    }
}
