package net.notridani.apito.item.client.model;

import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.*;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.notridani.apito.component.ModDataComponentTypes;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Supplier;

public class WhistleBakedModel implements BakedModel, FabricBakedModel {

    private final Map<String, BakedModel> parts;

    public WhistleBakedModel(Map<String, BakedModel> parts) {
        this.parts = parts;
    }

    private void add(RenderContext context, String key, ItemStack stack, Random random) {

        System.out.println("Rendering part: " + key); // 👈 AQUI

        BakedModel model = parts.get(key);

        if (model == null) {
            System.out.println("❌ Missing model: " + key);
            return;
        }

        model.emitItemQuads(stack, () -> random, context);
    }

    @Override
    public void emitItemQuads(ItemStack stack, Supplier<Random> randomSupplier, RenderContext context) {

        var data = stack.get(ModDataComponentTypes.WHISTLE_DATA);

        if (data == null) {
            System.out.println("❌ Data null");
            return;
        }

        Random random = randomSupplier.get();

        add(context, "base_" + data.base(), stack, random);

        if (data.entalhe() != -1) {
            add(context, "entalhe_" + data.entalhe(), stack, random);
        }
    }

    @Override
    public boolean isVanillaAdapter() {
        return false;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, Random random) {
        return List.of();
    }

    @Override public boolean useAmbientOcclusion() { return true; }
    @Override public boolean hasDepth() { return true; }
    @Override public boolean isSideLit() { return true; }
    @Override public boolean isBuiltin() { return false; }

    @Override
    public Sprite getParticleSprite() {
        return parts.values().stream()
                .findFirst()
                .map(BakedModel::getParticleSprite)
                .orElseThrow(() -> new RuntimeException("No particle sprite available"));
    }

    @Override
    public ModelTransformation getTransformation() {
        return parts.values().iterator().next().getTransformation();
    }

    @Override
    public ModelOverrideList getOverrides() {
        return ModelOverrideList.EMPTY;
    }
}