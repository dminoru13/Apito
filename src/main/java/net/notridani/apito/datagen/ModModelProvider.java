package net.notridani.apito.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.block.custom.FelpsLamp;
import net.notridani.apito.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCRAP_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROSELITA_BLOCK);

        Identifier FelpsLamp0 = TexturedModel.CUBE_ALL.upload(ModBlocks.FELPS_LAMP, blockStateModelGenerator.modelCollector);
        Identifier FelpsLamp1 = blockStateModelGenerator.createSubModel(ModBlocks.FELPS_LAMP, "1", Models.CUBE_ALL, TextureMap::all);
        Identifier FelpsLamp2 = blockStateModelGenerator.createSubModel(ModBlocks.FELPS_LAMP, "2", Models.CUBE_ALL, TextureMap::all);
        Identifier FelpsLamp3 = blockStateModelGenerator.createSubModel(ModBlocks.FELPS_LAMP, "3", Models.CUBE_ALL, TextureMap::all);
        Identifier FelpsLamp4 = blockStateModelGenerator.createSubModel(ModBlocks.FELPS_LAMP, "4", Models.CUBE_ALL, TextureMap::all);
        Identifier FelpsLamp5 = blockStateModelGenerator.createSubModel(ModBlocks.FELPS_LAMP, "5", Models.CUBE_ALL, TextureMap::all);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.FELPS_LAMP)
                .coordinate(
                        BlockStateVariantMap.create(FelpsLamp.CARA)
                                .register(0, BlockStateVariant.create().put(VariantSettings.MODEL, FelpsLamp0))
                                .register(1, BlockStateVariant.create().put(VariantSettings.MODEL, FelpsLamp1))
                                .register(2, BlockStateVariant.create().put(VariantSettings.MODEL, FelpsLamp2))
                                .register(3, BlockStateVariant.create().put(VariantSettings.MODEL, FelpsLamp3))
                                .register(4, BlockStateVariant.create().put(VariantSettings.MODEL, FelpsLamp4))
                                .register(5, BlockStateVariant.create().put(VariantSettings.MODEL, FelpsLamp5))
                ));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.WHISTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOSSILIZED_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_GOLBO_LEG, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLBO_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSELITA, Models.GENERATED);
    }
}
