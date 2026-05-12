package net.notridani.apito.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.notridani.apito.Apito;
import net.notridani.apito.block.ModBlocks;

import java.util.List;

public class ApitoPlacedFeatures {
    public static final RegistryKey<PlacedFeature> SCRAP_ORE_PLACED_KEY = registerKey("scrap_ore_placed");

    public static final RegistryKey<PlacedFeature> PETRIFIED_TREE_KEY = registerKey("petrified_tree");

    public static final RegistryKey<PlacedFeature> FLOWER_PATCH_PLACED = registerKey("flower_patch_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SCRAP_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ApitoConfiguredFeatures.SCRAP_ORE_KEY),
                ApitoOrePlacement.modifiersWhithCount(14,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, PETRIFIED_TREE_KEY, configuredFeatures.getOrThrow(ApitoConfiguredFeatures.PETRIFIED_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1,0.1f, 1), ModBlocks.PETRIFIED_TREE_SAPLING));


        register(
                context,
                FLOWER_PATCH_PLACED,
                configuredFeatures.getOrThrow(ApitoConfiguredFeatures.FLOWER_PATCH),
                CountPlacementModifier.of(16),

                RarityFilterPlacementModifier.of(5),

                SquarePlacementModifier.of(),

                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,

                BiomePlacementModifier.of()
        );
    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Apito.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?,?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key,new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                    RegistryEntry<ConfiguredFeature<?,?>> configuration,
                                                                                    PlacementModifier...modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
