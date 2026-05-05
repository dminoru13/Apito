package net.notridani.apito.util;

import com.google.gson.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.Map;
import java.util.stream.Stream;

public class ModelOverlayGenerator {

    private static final float OFFSET = 0.001f;

    public static void main(String[] args) throws IOException {
        Path folder = Paths.get("src/main/resources/assets/apito/models/item/apito");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Stream<Path> files = Files.list(folder)) {
            files
                    .filter(path -> path.getFileName().toString().startsWith("entalhe_"))
                    .filter(path -> path.getFileName().toString().endsWith(".json"))
                    .forEach(path -> processFile(path, gson));
        }

        System.out.println("✔ Todos os entalhes processados!");
    }

    private static void processFile(Path path, Gson gson) {
        try {
            System.out.println("Processando: " + path.getFileName());

            JsonObject root = gson.fromJson(Files.readString(path), JsonObject.class);

            JsonArray elements = root.getAsJsonArray("elements");
            JsonArray newElements = new JsonArray();

            for (JsonElement el : elements) {
                JsonObject base = el.getAsJsonObject();

                // adiciona original
                newElements.add(base);

                // cria overlay
                JsonObject overlay = base.deepCopy();

                // 🔥 resolve z-fighting corretamente
                inflate(overlay, OFFSET);

                // troca textura + tint
                JsonObject faces = overlay.getAsJsonObject("faces");
                for (Map.Entry<String, JsonElement> entry : faces.entrySet()) {
                    JsonObject face = entry.getValue().getAsJsonObject();
                    face.addProperty("texture", "#1");
                    face.addProperty("tintindex", 1);
                }

                newElements.add(overlay);
            }

            root.add("elements", newElements);

            // garante textura #1
            JsonObject textures = root.getAsJsonObject("textures");
            textures.addProperty("1", "apito:item/apito/entalhe_detalhe1");

            Files.writeString(path, gson.toJson(root));

        } catch (Exception e) {
            System.out.println("❌ Erro em: " + path.getFileName());
            e.printStackTrace();
        }
    }

    /**
     * Expande o cubo levemente para fora (resolve z-fighting corretamente)
     */
    private static void inflate(JsonObject obj, float value) {
        JsonArray from = obj.getAsJsonArray("from");
        JsonArray to = obj.getAsJsonArray("to");

        // from diminui (vai pra fora)
        for (int i = 0; i < from.size(); i++) {
            float v = from.get(i).getAsFloat();
            from.set(i, new JsonPrimitive(v - value));
        }

        // to aumenta (vai pra fora)
        for (int i = 0; i < to.size(); i++) {
            float v = to.get(i).getAsFloat();
            to.set(i, new JsonPrimitive(v + value));
        }
    }
}