package net.notridani.apito.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.notridani.apito.Apito;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.block.custom.Chalk;
import net.notridani.apito.block.custom.FelpsLamp;
import net.notridani.apito.block.custom.PocketPortal;
import net.notridani.apito.block.custom.SnailBerryBushBlock;
import net.notridani.apito.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.PETRIFIED_TREE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCRAP_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROSELITA_BLOCK);

        Identifier FelpsLamp0 = TexturedModel.CUBE_ALL.upload(ModBlocks.FELPS_LAMP, blockStateModelGenerator.modelCollector);
        Identifier FelpsLamp1 = blockStateModelGenerator.createSubModel(ModBlocks.FELPS_LAMP, "1", Models.CUBE_ALL, TextureMap::all);
        Identifier FelpsLamp2 = blockStateModelGenerator.createSubModel(ModBlocks.FELPS_LAMP, "2", Models.CUBE_ALL, TextureMap::all);
        Identifier FelpsLamp3 = blockStateModelGenerator.createSubModel(ModBlocks.FELPS_LAMP, "3", Models.CUBE_ALL, TextureMap::all);
        Identifier FelpsLamp4 = blockStateModelGenerator.createSubModel(ModBlocks.FELPS_LAMP, "4", Models.CUBE_ALL, TextureMap::all);
        Identifier FelpsLamp5 = blockStateModelGenerator.createSubModel(ModBlocks.FELPS_LAMP, "5", Models.CUBE_ALL, TextureMap::all);

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.FELPS_LAMP)
                .coordinate(
                        BlockStateVariantMap.create(FelpsLamp.CARA)
                                .register(0, BlockStateVariant.create().put(VariantSettings.MODEL, FelpsLamp0))
                                .register(1, BlockStateVariant.create().put(VariantSettings.MODEL, FelpsLamp1))
                                .register(2, BlockStateVariant.create().put(VariantSettings.MODEL, FelpsLamp2))
                                .register(3, BlockStateVariant.create().put(VariantSettings.MODEL, FelpsLamp3))
                                .register(4, BlockStateVariant.create().put(VariantSettings.MODEL, FelpsLamp4))
                                .register(5, BlockStateVariant.create().put(VariantSettings.MODEL, FelpsLamp5))
                ));

        //GIZ
       Identifier chalkModel = Identifier.of("apito", "block/chalk");


        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.CHALK, BlockStateVariant.create().put(VariantSettings.MODEL, chalkModel))
                        .coordinate(
                                BlockStateVariantMap.create(Chalk.FACING)
                                        .register(Direction.NORTH, BlockStateVariant.create())
                                        .register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R270))
                                        .register(Direction.UP, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R270))
                                        .register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90))
                        )
        );

        Identifier pocketPortalModel = Identifier.of("apito", "block/pocket_portal");


        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.POCKET_PORTAL, BlockStateVariant.create().put(VariantSettings.MODEL, pocketPortalModel))
                        .coordinate(
                                BlockStateVariantMap.create(PocketPortal.FACING)
                                        .register(Direction.NORTH, BlockStateVariant.create())
                                        .register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R90))
                                        .register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R180))
                                        .register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R270))
                                        .register(Direction.UP, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R270))
                                        .register(Direction.DOWN, BlockStateVariant.create().put(VariantSettings.X, VariantSettings.Rotation.R90))
                        )
        );

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.SNAIL_BERRY_BUSH_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED,
                SnailBerryBushBlock.AGE, 0,1,2,3);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.VAMPIRIC_BERRY_BUSH_BLOCK, BlockStateModelGenerator.TintType.NOT_TINTED,
                SnailBerryBushBlock.AGE, 0,1,2,3);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.CARVING_BENCH);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModBlocks.CHALK.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.FOSSILIZED_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSELITA, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_GOLBO_LEG, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLBO_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.ENDLESS_EMBRACE_MUSIC_DISC, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MECHA_AZAZETH_CROWN));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MECHA_AZAZETH_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MECHA_AZAZETH_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MECHA_AZAZETH_BOOTS));

        itemModelGenerator.register(ModItems.MININORU_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.GOLBO_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        //APITOS

        gerarApito(itemModelGenerator, ModItems.WHISTLE);

    }

    private void gerarApito(ItemModelGenerator itemModelGenerator, Item item) {
        gerarModelosApito(itemModelGenerator);
        gerarOverridesApito(itemModelGenerator, item);
    }

    private void gerarModelosApito(ItemModelGenerator itemModelGenerator) {

        for (int tier = 0; tier < 5; tier++) {
            for (int b = 0; b < 4; b++) {
                for (int e = -1; e < 5; e++) {
                    for (int g = -1; g < 5; g++) {

                        int eIndex = e + 1;
                        int gIndex = g + 1;

                        String name = "apito_" + tier + "_" + b + "_" + eIndex + "_" + gIndex;

                        Identifier modelId = Identifier.of(Apito.MOD_ID, "item/apito/" + name);

                        TextureMap textures = new TextureMap();
                        textures.put(TextureKey.LAYER0,
                                Identifier.of(Apito.MOD_ID, "item/apito/base_" + b));

                        Model model;

                        if (e == -1 && g == -1) {
                            model = new Model(
                                    Optional.of(Identifier.of("item/generated")),
                                    Optional.empty(),
                                    TextureKey.LAYER0
                            );

                        } else if (g == -1) {
                            model = new Model(
                                    Optional.of(Identifier.of("item/generated")),
                                    Optional.empty(),
                                    TextureKey.LAYER0,
                                    TextureKey.LAYER1
                            );

                            textures.put(TextureKey.LAYER1,
                                    Identifier.of(Apito.MOD_ID, "item/apito/entalhe_" + e + "-" + tier));

                        } else if (e == -1) {
                            model = new Model(
                                    Optional.of(Identifier.of("item/generated")),
                                    Optional.empty(),
                                    TextureKey.LAYER0,
                                    TextureKey.LAYER1
                            );

                            textures.put(TextureKey.LAYER1,
                                    Identifier.of(Apito.MOD_ID, "item/apito/gema_" + g));

                        } else {
                            model = new Model(
                                    Optional.of(Identifier.of("item/generated")),
                                    Optional.empty(),
                                    TextureKey.LAYER0,
                                    TextureKey.LAYER1,
                                    TextureKey.LAYER2
                            );

                            textures.put(TextureKey.LAYER1,
                                    Identifier.of(Apito.MOD_ID, "item/apito/entalhe_" + e + "-" + tier));

                            textures.put(TextureKey.LAYER2,
                                    Identifier.of(Apito.MOD_ID, "item/apito/gema_" + g));
                        }

                        model.upload(modelId, textures, itemModelGenerator.writer);
                    }
                }
            }
        }
    }

    private void gerarOverridesApito(ItemModelGenerator itemModelGenerator, Item item) {

        JsonArray overrides = new JsonArray();

        int B = 4;
        int E = 6;
        int G = 6;

        for (int tier = 0; tier < 5; tier++) {
            for (int b = 0; b < B; b++) {
                for (int e = -1; e < 5; e++) {
                    for (int g = -1; g < 5; g++) {

                        int eIndex = e + 1;
                        int gIndex = g + 1;

                        int cmd =
                                tier * (B * E * G) +
                                        b * (E * G) +
                                        eIndex * G +
                                        gIndex + 1;

                        JsonObject obj = new JsonObject();
                        JsonObject predicate = new JsonObject();

                        predicate.addProperty("custom_model_data", cmd);
                        obj.add("predicate", predicate);

                        obj.addProperty("model",
                                Apito.MOD_ID + ":item/apito/apito_" + tier + "_" + b + "_" + eIndex + "_" + gIndex);

                        overrides.add(obj);
                    }
                }
            }
        }

        JsonObject root = new JsonObject();
        root.addProperty("parent", "minecraft:item/generated");

        JsonObject textures = new JsonObject();
        textures.addProperty("layer0", Apito.MOD_ID + ":item/apito/base_0");
        root.add("textures", textures);

        root.add("overrides", overrides);

        Identifier itemId = Registries.ITEM.getId(item);

        itemModelGenerator.writer.accept(
                Identifier.of(itemId.getNamespace(), "item/" + itemId.getPath()),
                () -> root
        );
    }
}
