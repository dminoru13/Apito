package net.notridani.apito.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCRAP_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROSELITA_BLOCK);
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
