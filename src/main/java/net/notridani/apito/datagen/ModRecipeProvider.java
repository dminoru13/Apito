package net.notridani.apito.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List< ItemConvertible> ROSELITA_SMELTABLES = List.of(ModItems.FOSSILIZED_SCRAP);

        //ROSELITA
        offerSmelting(exporter, ROSELITA_SMELTABLES, RecipeCategory.MISC, ModItems.ROSELITA, 0.25f, 200, "roselita");
        offerBlasting(exporter, ROSELITA_SMELTABLES, RecipeCategory.MISC, ModItems.ROSELITA, 0.25f, 100, "roselita");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ROSELITA, RecipeCategory.DECORATIONS, ModBlocks.ROSELITA_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROSELITA, 9)
                .input(ModBlocks.ROSELITA_BLOCK)
                .criterion(hasItem(ModBlocks.ROSELITA_BLOCK), conditionsFromItem(ModBlocks.ROSELITA_BLOCK))
                .offerTo(exporter, Identifier.of(Apito.MOD_ID, "roselita_from_roselita_block"));



        //basalto

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.BASALT.asItem(), 4)
                .input(Blocks.POLISHED_BASALT)
                .criterion(hasItem(Blocks.POLISHED_BASALT), conditionsFromItem(Blocks.POLISHED_BASALT))
                .offerTo(exporter, Identifier.of(Apito.MOD_ID, "basalto_from_polished_basalt"));


        //WHISTLE


        //GOLBO
        offerSmelting(exporter, List.of(ModItems.RAW_GOLBO_LEG), RecipeCategory.FOOD, ModItems.GOLBO_NUGGET, 0.5f, 150, "golbo");
        offerFoodCookingRecipe(exporter, "smoking", RecipeSerializer.SMOKING, SmokingRecipe::new, 75, ModItems.RAW_GOLBO_LEG, ModItems.GOLBO_NUGGET, 0.35f);
        offerFoodCookingRecipe(exporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 250, ModItems.RAW_GOLBO_LEG, ModItems.GOLBO_NUGGET, 0.35f);


    }
}
