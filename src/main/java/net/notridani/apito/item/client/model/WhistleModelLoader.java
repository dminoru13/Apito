package net.notridani.apito.item.client.model;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;

import java.util.List;

public class WhistleModelLoader implements ModelLoadingPlugin {

    @Override
    public void onInitializeModelLoader(Context pluginContext) {

        pluginContext.resolveModel().register(context -> {

            var id = context.id();

            System.out.println("Model requested: " + id);


            if (id.getNamespace().equals("apito")
                    && id.getPath().equals("item/whistle")) {

                System.out.println(">>> CUSTOM MODEL APPLIED <<<");


                return new WhistleUnbakedModel(List.of(
                        "base_0", "base_1", "base_2", "base_3", "base_4",
                        "entalhe_0", "entalhe_1", "entalhe_2", "entalhe_3", "entalhe_4"
                ));
            }

            return null;
        });
    }
}