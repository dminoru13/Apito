package net.notridani.apito.item.client.model;

import net.minecraft.client.render.model.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

import java.util.*;
import java.util.function.Function;

public class WhistleUnbakedModel implements UnbakedModel {

    private final List<String> parts;

    public WhistleUnbakedModel(List<String> parts) {
        this.parts = parts;
    }

    @Override
    public Collection<Identifier> getModelDependencies() {
        List<Identifier> deps = new ArrayList<>();

        for (String part : parts) {
            deps.add(Identifier.of("apito", "item/apito/" + part));
        }

        return deps;
    }

    @Override
    public void setParents(Function<Identifier, UnbakedModel> loader) {}

    @Override
    public BakedModel bake(
            Baker baker,
            Function<SpriteIdentifier, Sprite> textureGetter,
            ModelBakeSettings rotationContainer
    ) {
        Map<String, BakedModel> bakedParts = new HashMap<>();

        for (String part : parts) {
            Identifier id = Identifier.of("apito", "item/apito/" + part);

            System.out.println("Baking part: " + part);

            bakedParts.put(part, baker.bake(id, rotationContainer));
        }

        return new WhistleBakedModel(bakedParts);
    }
}