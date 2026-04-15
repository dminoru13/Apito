package net.notridani.apito.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.InstrumentTags;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.item.custom.WhistleItem;

public class ModItems {
    public static final Item FOSSILIZED_SCRAP = registerItem("fossilized_scrap", new Item(new Item.Settings()));
    public static final Item ROSELITA = registerItem("roselita", new Item(new Item.Settings()));
    public static  final Item RAW_GOLBO_LEG = registerItem("raw_golbo_leg", new Item(new Item.Settings().food(ModFoodComponents.RAW_GOLBO_LEG)));
    public static  final Item GOLBO_NUGGET = registerItem("golbo_nugget", new Item(new Item.Settings().food(ModFoodComponents.GOLBO_NUGGET)));

    public static final Item WHISTLE = registerItem("whistle", new WhistleItem(new Item.Settings().maxCount(1).maxDamage(32), InstrumentTags.GOAT_HORNS, "palido"));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Apito.MOD_ID, name), item);
    }


    public static void registerModItems() {

        Apito.LOGGER.info("Registering Mod Items for " + Apito.MOD_ID);
    }
}
