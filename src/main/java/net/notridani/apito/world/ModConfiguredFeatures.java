package net.notridani.apito.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.MegaJungleTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.notridani.apito.Apito;
import net.notridani.apito.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static RegistryKey<ConfiguredFeature<?,?>> SCRAP_ORE_KEY = registerKey("scrap_ore");
    public static RegistryKey<ConfiguredFeature<?,?>> PETRIFIED_TREE_KEY = registerKey("petrified_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context) {
        RuleTest stoneReplacebles = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacebles = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);



        List<OreFeatureConfig.Target> dimensionScrapOre =
                List.of(OreFeatureConfig.createTarget(stoneReplacebles, ModBlocks.SCRAP_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacebles, ModBlocks.SCRAP_ORE.getDefaultState()));



        //
        register(context, SCRAP_ORE_KEY, Feature.ORE, new OreFeatureConfig(dimensionScrapOre, 12));

        register(context, PETRIFIED_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.POLISHED_BASALT),
                new MegaJungleTrunkPlacer(4,20,20),

                BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),

                new TwoLayersFeatureSize(1,0,2))
                .dirtProvider(BlockStateProvider.of(Blocks.GRAVEL))
                .forceDirt()
                .decorators(List.of(
                        new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.TUFF))
                ))
                .build());

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Apito.MOD_ID, name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                  RegistryKey<ConfiguredFeature<?,?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
