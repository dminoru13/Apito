package net.notridani.apito;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.block.entity.ModBlockEntities;
import net.notridani.apito.block.entity.renderer.ForgeInputEntityRenderer;
import net.notridani.apito.block.entity.renderer.WhistleForgeEntityRenderer;
import net.notridani.apito.client.models.WhistleBakedModel;
import net.notridani.apito.entity.ModEntities;
import net.notridani.apito.entity.client.GolboModel;
import net.notridani.apito.entity.client.GolboRender;
import net.notridani.apito.entity.client.MininoruModel;
import net.notridani.apito.entity.client.MininoruRender;
import net.notridani.apito.screen.ModScreenHandler;
import net.notridani.apito.screen.custom.CarvingBenchScreen;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;

public class ApitoClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHALK, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SNAIL_BERRY_BUSH_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VAMPIRIC_BERRY_BUSH_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PETRIFIED_TREE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHISTLE_FORGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FORGE_INPUT, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(MininoruModel.MININORU, MininoruModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MININORU, MininoruRender::new);

        EntityModelLayerRegistry.registerModelLayer(GolboModel.GOLBO, GolboModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GOLBO, GolboRender::new);

        BlockEntityRendererFactories.register(ModBlockEntities.WHISTLE_FORGE_BE, WhistleForgeEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.FORGE_INPUT_BE, ForgeInputEntityRenderer::new);

        HandledScreens.register(ModScreenHandler.CARVING_BENCH_SCREEN_HANDLER, CarvingBenchScreen::new);


        ModelLoadingPlugin.register(pluginContext -> {
            pluginContext.modifyModelAfterBake().register((model, context) -> {
                if (context.topLevelId() != null && context.topLevelId().equals(
                                ModelIdentifier.ofInventoryVariant(
                                        Identifier.of(Apito.MOD_ID, "whistle")
                                )
                        )) {

                    System.out.println("AAAAAAAAAAAAAAAAA");

                    System.out.println(context.topLevelId());
                    return new WhistleBakedModel(model);
                }

                return model;
            });
        });
    }
}