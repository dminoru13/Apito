package net.notridani.apito.world.biome;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;

import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;

import net.notridani.apito.Apito;
import net.notridani.apito.world.ApitoPlacedFeatures;

public class ApitoBiomes {

    public static final RegistryKey<Biome> GRIME_GARDEN =
            RegistryKey.of(
                    RegistryKeys.BIOME,
                    Identifier.of(Apito.MOD_ID, "grime_garden")
            );

    public static final RegistryKey<Biome> NULO =
            RegistryKey.of(
                    RegistryKeys.BIOME,
                    Identifier.of(Apito.MOD_ID, "nulo")
            );

    public static final RegistryKey<Biome> RESERVATORIO_PROFUNDO =
            RegistryKey.of(
                    RegistryKeys.BIOME,
                    Identifier.of(Apito.MOD_ID, "reservatorio_profundo")
            );

    public static final RegistryKey<Biome> PROMONTORIO =
            RegistryKey.of(
                    RegistryKeys.BIOME,
                    Identifier.of(Apito.MOD_ID, "promontorio")
            );

    public static final RegistryKey<Biome> MAR_DE_CADAVERES =
            RegistryKey.of(
                    RegistryKeys.BIOME,
                    Identifier.of(Apito.MOD_ID, "mar_de_cadaveres")
            );

    public static final RegistryKey<Biome> LIMEAR_1 =
            RegistryKey.of(
                    RegistryKeys.BIOME,
                    Identifier.of(Apito.MOD_ID, "limear1")
            );

    public static final RegistryKey<Biome> PSEUDO_CITY =
            RegistryKey.of(
                    RegistryKeys.BIOME,
                    Identifier.of(Apito.MOD_ID, "pseudo_city")
            );

    public static final RegistryKey<Biome> LIMEAR_2 =
            RegistryKey.of(
                    RegistryKeys.BIOME,
                    Identifier.of(Apito.MOD_ID, "limear2")
            );

    public static final RegistryKey<Biome> LIMEAR_3 =
            RegistryKey.of(
                    RegistryKeys.BIOME,
                    Identifier.of(Apito.MOD_ID, "limear2")
            );


    public static void bootstrap(Registerable<Biome> context) {


        context.register(
                NULO,
                createNulo(context)
        );

        context.register(
                RESERVATORIO_PROFUNDO,
                createReservatorio(context)
        );

        context.register(
                PROMONTORIO,
                createPromontorio(context)
        );

        context.register(
                LIMEAR_1,
                createMarDeCadaveres(context)
        );

        context.register(
                PSEUDO_CITY,
                createPseudoCity(context)
        );

        context.register(
                LIMEAR_2,
                createMarDeCadaveres(context)
        );

        context.register(
                GRIME_GARDEN,
                createGrimeGarden(context)
        );

        context.register(
                LIMEAR_3,
                createMarDeCadaveres(context)
        );

        context.register(
                MAR_DE_CADAVERES,
                createMarDeCadaveres(context)
        );
    }

    public static Biome createGrimeGarden(Registerable<Biome> context) {

        RegistryEntryLookup<PlacedFeature> placedFeatures =
                context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RegistryEntryLookup<ConfiguredCarver<?>> carvers =
                context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        // generation

        GenerationSettings.LookupBackedBuilder generation =
                new GenerationSettings.LookupBackedBuilder(
                        placedFeatures,
                        carvers
                );



        // spawn

        SpawnSettings.Builder spawn =
                new SpawnSettings.Builder();

        // biome

        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.7f)
                .downfall(0.8f)
                .effects(
                        new BiomeEffects.Builder()
                                .skyColor(0x77adff)
                                .fogColor(0xc0d8ff)
                                .waterColor(0x3f76e4)
                                .waterFogColor(0x050533)
                                .moodSound(BiomeMoodSound.CAVE)
                                .build()
                )
                .spawnSettings(spawn.build())
                .generationSettings(generation.build())
                .build();
    }

    public static Biome createNulo(Registerable<Biome> context) {

        RegistryEntryLookup<PlacedFeature> placedFeatures =
                context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RegistryEntryLookup<ConfiguredCarver<?>> carvers =
                context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        // generation

        GenerationSettings.LookupBackedBuilder generation =
                new GenerationSettings.LookupBackedBuilder(
                        placedFeatures,
                        carvers
                );

        generation.feature(
                GenerationStep.Feature.VEGETAL_DECORATION,
                ApitoPlacedFeatures.PETRIFIED_TREE_KEY
        );

        // spawn

        SpawnSettings.Builder spawn =
                new SpawnSettings.Builder();

        // biome

        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.7f)
                .downfall(0.8f)
                .effects(
                        new BiomeEffects.Builder()
                                .skyColor(0x77adff)
                                .fogColor(0xc0d8ff)
                                .waterColor(0x3f76e4)
                                .waterFogColor(0x050533)
                                .moodSound(BiomeMoodSound.CAVE)
                                .build()
                )
                .spawnSettings(spawn.build())
                .generationSettings(generation.build())
                .build();
    }

    public static Biome createPseudoCity(Registerable<Biome> context) {

        RegistryEntryLookup<PlacedFeature> placedFeatures =
                context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RegistryEntryLookup<ConfiguredCarver<?>> carvers =
                context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        // generation

        GenerationSettings.LookupBackedBuilder generation =
                new GenerationSettings.LookupBackedBuilder(
                        placedFeatures,
                        carvers
                );

        generation.feature(
                GenerationStep.Feature.VEGETAL_DECORATION,
                ApitoPlacedFeatures.PETRIFIED_TREE_KEY
        );

        // spawn

        SpawnSettings.Builder spawn =
                new SpawnSettings.Builder();

        // biome

        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.7f)
                .downfall(0.8f)
                .effects(
                        new BiomeEffects.Builder()
                                .skyColor(0x77adff)
                                .fogColor(0xc0d8ff)
                                .waterColor(0x3f76e4)
                                .waterFogColor(0x050533)
                                .moodSound(BiomeMoodSound.CAVE)
                                .build()
                )
                .spawnSettings(spawn.build())
                .generationSettings(generation.build())
                .build();
    }

    public static Biome createReservatorio(Registerable<Biome> context) {

        RegistryEntryLookup<PlacedFeature> placedFeatures =
                context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RegistryEntryLookup<ConfiguredCarver<?>> carvers =
                context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        // generation

        GenerationSettings.LookupBackedBuilder generation =
                new GenerationSettings.LookupBackedBuilder(
                        placedFeatures,
                        carvers
                );



        // spawn

        SpawnSettings.Builder spawn =
                new SpawnSettings.Builder();

        // biome

        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.7f)
                .downfall(0.8f)
                .effects(
                        new BiomeEffects.Builder()
                                .skyColor(0x77adff)
                                .fogColor(0xc0d8ff)
                                .waterColor(0x3f76e4)
                                .waterFogColor(0x050533)
                                .moodSound(BiomeMoodSound.CAVE)
                                .build()
                )
                .spawnSettings(spawn.build())
                .generationSettings(generation.build())
                .build();
    }

    public static Biome createPromontorio(Registerable<Biome> context) {

        RegistryEntryLookup<PlacedFeature> placedFeatures =
                context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RegistryEntryLookup<ConfiguredCarver<?>> carvers =
                context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        // generation

        GenerationSettings.LookupBackedBuilder generation =
                new GenerationSettings.LookupBackedBuilder(
                        placedFeatures,
                        carvers
                );



        // spawn

        SpawnSettings.Builder spawn =
                new SpawnSettings.Builder();

        // biome

        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.7f)
                .downfall(0.8f)
                .effects(
                        new BiomeEffects.Builder()
                                .skyColor(0x77adff)
                                .fogColor(0xc0d8ff)
                                .waterColor(0x3f76e4)
                                .waterFogColor(0x050533)
                                .moodSound(BiomeMoodSound.CAVE)
                                .build()
                )
                .spawnSettings(spawn.build())
                .generationSettings(generation.build())
                .build();
    }

    public static Biome createMarDeCadaveres(Registerable<Biome> context) {

        RegistryEntryLookup<PlacedFeature> placedFeatures =
                context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RegistryEntryLookup<ConfiguredCarver<?>> carvers =
                context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        // generation

        GenerationSettings.LookupBackedBuilder generation =
                new GenerationSettings.LookupBackedBuilder(
                        placedFeatures,
                        carvers
                );



        // spawn

        SpawnSettings.Builder spawn =
                new SpawnSettings.Builder();

        // biome

        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.7f)
                .downfall(0.8f)
                .effects(
                        new BiomeEffects.Builder()
                                .skyColor(0x77adff)
                                .fogColor(0xc0d8ff)
                                .waterColor(0x3f76e4)
                                .waterFogColor(0x050533)
                                .moodSound(BiomeMoodSound.CAVE)
                                .build()
                )
                .spawnSettings(spawn.build())
                .generationSettings(generation.build())
                .build();
    }


}