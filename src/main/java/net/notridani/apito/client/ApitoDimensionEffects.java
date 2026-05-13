package net.notridani.apito.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.biome.Biome;

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

        MinecraftClient client = MinecraftClient.getInstance();

        if (client.world == null || client.player == null) {
            return color;
        }

        BlockPos pos = client.player.getBlockPos();

        RegistryEntry<Biome> biome = client.world.getBiome(pos);

        int fogColor = biome.value().getFogColor();

        double r = ((fogColor >> 16) & 255) / 255.0;
        double g = ((fogColor >> 8) & 255) / 255.0;
        double b = (fogColor & 255) / 255.0;

        return new Vec3d(r, g, b);
    }

    @Override
    public boolean useThickFog(int camX, int camY) {
        return false;
    }
}
