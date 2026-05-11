package net.notridani.apito.world;

import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.math.random.Xoroshiro128PlusPlusRandom;

public class Noises {

    //DOUBLE PERLIN NOISE
    public static DoublePerlinNoiseSampler createPerlinNoise(
            long seed,
            long salt,
            int firstOctave,
            double... amplitudes
    ) {

        var random = new Xoroshiro128PlusPlusRandom(seed + salt);

        return DoublePerlinNoiseSampler.create(
                random,
                firstOctave,
                amplitudes
        );

    }

    public static double DoublePerlinSample(
            DoublePerlinNoiseSampler noise,
            double x,
            double y,
            double z,
            double scale
            ) {

        return noise.sample(
                x * scale,
                y * scale,
                z * scale
        );
    }
}
