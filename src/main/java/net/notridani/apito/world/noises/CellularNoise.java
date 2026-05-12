package net.notridani.apito.world.noises;

import net.minecraft.util.math.random.Random;

public class CellularNoise {

    public static double sample(long seed, int x, int z, int cellSize) {

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