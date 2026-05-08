package net.notridani.apito;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.Identifier;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.block.entity.ModBlockEntities;
import net.notridani.apito.block.entity.renderer.ForgeInputEntityRenderer;
import net.notridani.apito.block.entity.renderer.WhistleForgeEntityRenderer;
import net.notridani.apito.client.ApitoDimensionEffects;
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

            var data = stack.get(ModDataComponentTypes.WHISTLE_DATA);
            if (data == null) return -1;

            return switch (tintIndex) {
                case 0 -> getTierColor(data.tier()); // base
                case 1 -> getDetailColor(data.tier());      // overlay
                default -> -1;
            };

        }, ModItems.WHISTLE);


        try {
            var field = DimensionEffects.class.getDeclaredField("BY_IDENTIFIER");
            field.setAccessible(true);

            @SuppressWarnings("unchecked")
            var map = (java.util.Map<Identifier, DimensionEffects>) field.get(null);

            map.put(
                    Identifier.of("apito", "estrutura"),
                    new ApitoDimensionEffects()
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int getTierColor(int tier) {
        return switch (tier) {
            case 0 -> 0xFF18161f;
            case 1 -> 0xFF723201;
            case 2 -> 0xFF323232;
            case 3 -> 0xFF8f8807;
            case 4 -> 0xFFcacaca;
            default -> 0xFFFFFFFF;
        };
    }

    private static int getDetailColor(int tier) {
        return switch (tier) {
            case 0 -> 0xFF4f447b;
            case 1 -> 0xFFda5f02;
            case 2 -> 0xFFb1b1b1;
            case 3 -> 0xFF8f8807;
            case 4 -> 0xFFfffFFd;
            default -> 0xFFFFFFFF;
        };
    }


}