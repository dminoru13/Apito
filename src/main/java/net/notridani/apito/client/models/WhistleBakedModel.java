package net.notridani.apito.client.models;

import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

import net.notridani.apito.Apito;
import net.notridani.apito.item.custom.WhistleItem;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class WhistleBakedModel implements BakedModel, FabricBakedModel {

    private final BakedModel fallback;

    public WhistleBakedModel(BakedModel fallback) {
        this.fallback = fallback;
    }

    @Override
    public boolean isVanillaAdapter() {
        return false;
    }

    // 👇 É AQUI que vai o código que você mandou
    @Override
    public void emitItemQuads(ItemStack stack,
                              Supplier<Random> randomSupplier,
                              RenderContext context) {

        // 🔥 COLOCA AQUI
        if (!(stack.getItem() instanceof WhistleItem item)) {
            fallback.emitItemQuads(stack, randomSupplier, context);
            return;
        }

        var client = MinecraftClient.getInstance();
        var manager = client.getBakedModelManager();

        var data = item.getData(stack);

        // BASE
        BakedModel base = manager.getModel(
                ModelIdentifier.ofInventoryVariant(
                        Identifier.of(Apito.MOD_ID, "item/apito/base_" + data.base())
                )
        );

        if (base == MinecraftClient.getInstance().getBakedModelManager().getMissingModel()) {
            System.out.println("❌ MODEL NÃO ENCONTRADO: apito:item/apito/base_" + data.base());
        } else {
            System.out.println("✅ MODEL OK: apito:item/apito/base_" + data.base());
        }


        base.emitItemQuads(stack, randomSupplier, context);
        System.out.println("BASE MODEL: apito:item/apito/base_" + data.base());

    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, Random random) {
        return fallback.getQuads(state, face, random);
    }

    @Override
    public boolean useAmbientOcclusion() {
        return fallback.useAmbientOcclusion();
    }

    @Override
    public boolean hasDepth() {
        return fallback.hasDepth();
    }

    @Override
    public boolean isSideLit() {
        return fallback.isSideLit();
    }

    @Override
    public boolean isBuiltin() {
        return fallback.isBuiltin();
    }

    @Override
    public net.minecraft.client.texture.Sprite getParticleSprite() {
        return fallback.getParticleSprite();
    }

    @Override
    public net.minecraft.client.render.model.json.ModelTransformation getTransformation() {
        return fallback.getTransformation();
    }

    @Override
    public net.minecraft.client.render.model.json.ModelOverrideList getOverrides() {
        return fallback.getOverrides();
    }
}
