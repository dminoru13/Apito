package net.notridani.apito.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.notridani.apito.Apito;
import net.notridani.apito.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static RegistryKey<ConfiguredFeature<?,?>> SCRAP_ORE_KEY = registerKey("scrap_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context) {
        RuleTest stoneReplacebles = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacebles = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);



        List<OreFeatureConfig.Target> dimensionScrapOre =
                List.of(OreFeatureConfig.createTarget(stoneReplacebles, ModBlocks.SCRAP_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacebles, ModBlocks.SCRAP_ORE.getDefaultState()));



        //
        register(context, SCRAP_ORE_KEY, Feature.ORE, new OreFeatureConfig(dimensionScrapOre, 12));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Apito.MOD_ID, name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                  RegistryKey<ConfiguredFeature<?,?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
