package net.notridani.apito.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.notridani.apito.world.ApitoPlacedFeatures;
import net.notridani.apito.world.biome.ApitoBiomeSource;
import net.notridani.apito.world.biome.ApitoBiomes;

public class ApitoFlores {

    public static void generateFlowers() {

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        ApitoBiomes.GRIME_GARDEN),

                GenerationStep.Feature.VEGETAL_DECORATION,

                ApitoPlacedFeatures.FLOWER_PATCH_PLACED
        );
    }
}