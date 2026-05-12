package net.notridani.apito.world.noises;

import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.math.random.Xoroshiro128PlusPlusRandom;

public class Noises {

    // DOUBLE PERLIN NOISE
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

    public static double doublePerlinSample(
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

    // CELLULAR / WORLEY NOISE
    public static double cellularSample(
            long seed,
            int x,
            int z,
            int cellSize
    ) {

        int cellX = Math.floorDiv(x, cellSize);
        int cellZ = Math.floorDiv(z, cellSize);

        double nearest = Double.MAX_VALUE;

        for (int offsetX = -1; offsetX <= 1; offsetX++) {
            for (int offsetZ = -1; offsetZ <= 1; offsetZ++) {

                int currentCellX = cellX + offsetX;
                int currentCellZ = cellZ + offsetZ;

                long hash = hash(seed, currentCellX, currentCellZ);

                Random random = Random.create(hash);

                double pointX =
                        (currentCellX * cellSize)
                                + random.nextDouble() * cellSize;

                double pointZ =
                        (currentCellZ * cellSize)
                                + random.nextDouble() * cellSize;

                double dx = pointX - x;
                double dz = pointZ - z;

                double distance = Math.sqrt(dx * dx + dz * dz);

                nearest = Math.min(nearest, distance);
            }
        }

        return nearest / cellSize;
    }

    private static long hash(long seed, int x, int z) {

        long h = seed;

        h ^= x * 341873128712L;
        h ^= z * 132897987541L;

        return h;
    }
}