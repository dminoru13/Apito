package net.notridani.apito;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
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
import net.notridani.apito.item.client.model.WhistleModelLoader;
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

        ModelLoadingPlugin.register(new WhistleModelLoader());

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {

            if (tintIndex != 0) return -1;

            var data = stack.get(ModDataComponentTypes.WHISTLE_DATA);
            if (data == null) return -1;

            return getTierColor(data.tier());

        }, ModItems.WHISTLE);
    }

    private static int getTierColor(int tier) {
        return switch (tier) {
            case 0 -> 0xFFAAAAAA; // cinza
            case 1 -> 0xFF55FF55; // verde
            case 2 -> 0xFF5555FF; // azul
            case 3 -> 0xFFFFAA00; // laranja
            case 4 -> 0xFFFF5555; // vermelho
            default -> 0xFFFFFFFF; // branco fallback
        };
    }
}