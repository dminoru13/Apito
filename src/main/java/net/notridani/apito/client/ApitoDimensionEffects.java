package net.notridani.apito.client;

import net.minecraft.client.render.DimensionEffects;
import net.minecraft.util.math.Vec3d;

public class ApitoDimensionEffects extends DimensionEffects {
    public ApitoDimensionEffects() {
        super(
                100.0F, // altura das nuvens
                true,
                SkyType.NONE,
                false,
                false
        );
    }

    @Override
    public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
        return new Vec3d(
                1.0,
                1.0,
                1.0
        );
    }

    @Override
    public boolean useThickFog(int camX, int camY) {
        return false;
    }
}
