package net.notridani.apito.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
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
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModBlocks.CHALK.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.FOSSILIZED_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSELITA, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_GOLBO_LEG, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLBO_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.WHISTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHISTLE2, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHISTLE3, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHISTLE4, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHISTLE5, Models.GENERATED);

        itemModelGenerator.register(ModItems.ENDLESS_EMBRACE_MUSIC_DISC, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MECHA_AZAZETH_CROWN));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MECHA_AZAZETH_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MECHA_AZAZETH_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MECHA_AZAZETH_BOOTS));

        itemModelGenerator.register(ModItems.MININORU_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
    }
}
