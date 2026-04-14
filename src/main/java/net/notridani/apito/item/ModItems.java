package net.notridani.apito.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.item.custom.WhistleItem;

public class ModItems {
    public static final Item FOSSILIZED_SCRAP = registerItem("fossilized_scrap", new Item(new Item.Settings()));
    public static final Item ROSELITA = registerItem("roselita", new Item(new Item.Settings()));

    public static final Item WHISTLE = registerItem("whistle", new WhistleItem(new Item.Settings().maxDamage(32)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Apito.MOD_ID, name), item);
    }


    public static void registerModItems() {

        Apito.LOGGER.info("Registering Mod Items for " + Apito.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(FOSSILIZED_SCRAP);
            entries.add(ROSELITA);
        });
    }
}
