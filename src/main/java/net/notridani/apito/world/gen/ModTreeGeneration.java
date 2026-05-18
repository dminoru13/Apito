package net.notridani.apito.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.notridani.apito.world.ApitoPlacedFeatures;
import net.notridani.apito.world.biome.ApitoBiomes;

public class ModTreeGeneration {

    public static void generateTrees() {

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(ApitoBiomes.GRIME_GARDEN),

                GenerationStep.Feature.VEGETAL_DECORATION,

                ApitoPlacedFeatures.PETRIFIED_TREE_KEY
        );
    }
}
