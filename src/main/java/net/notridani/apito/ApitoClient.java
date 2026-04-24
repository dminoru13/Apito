package net.notridani.apito;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.block.entity.ModBlockEntities;
import net.notridani.apito.block.entity.renderer.ForgeInputEntityRenderer;
import net.notridani.apito.block.entity.renderer.WhistleForgeEntityRenderer;
import net.notridani.apito.component.ModDataComponentTypes;
import net.notridani.apito.entity.ModEntities;
import net.notridani.apito.entity.client.GolboModel;
import net.notridani.apito.entity.client.GolboRender;
import net.notridani.apito.entity.client.MininoruModel;
import net.notridani.apito.entity.client.MininoruRender;
import net.notridani.apito.item.ModItems;
import net.notridani.apito.screen.ModScreenHandler;
import net.notridani.apito.screen.custom.CarvingBenchScreen;
import net.notridani.apito.util.ModModelPredicates;

public class ApitoClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHALK, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SNAIL_BERRY_BUSH_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VAMPIRIC_BERRY_BUSH_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PETRIFIED_TREE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHISTLE_FORGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FORGE_INPUT, RenderLayer.getCutout());

        ModModelPredicates.registerModelPredicates();

        EntityModelLayerRegistry.registerModelLayer(MininoruModel.MININORU, MininoruModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MININORU, MininoruRender::new);

        EntityModelLayerRegistry.registerModelLayer(GolboModel.GOLBO, GolboModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GOLBO, GolboRender::new);

        BlockEntityRendererFactories.register(ModBlockEntities.WHISTLE_FORGE_BE, WhistleForgeEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.FORGE_INPUT_BE, ForgeInputEntityRenderer::new);

        HandledScreens.register(ModScreenHandler.CARVING_BENCH_SCREEN_HANDLER, CarvingBenchScreen::new);
    }
}