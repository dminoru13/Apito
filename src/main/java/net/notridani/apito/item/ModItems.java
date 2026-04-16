package net.notridani.apito.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.InstrumentTags;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.item.custom.ModArmorItem;
import net.notridani.apito.item.custom.WhistleItem;

public class ModItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Apito.MOD_ID, name), item);
    }


    public static void registerModItems() {

        Apito.LOGGER.info("Registering Mod Items for " + Apito.MOD_ID);
    }


    public static final Item FOSSILIZED_SCRAP = registerItem("fossilized_scrap", new Item(new Item.Settings()));
    public static final Item ROSELITA = registerItem("roselita", new Item(new Item.Settings()));
    public static  final Item RAW_GOLBO_LEG = registerItem("raw_golbo_leg", new Item(new Item.Settings().food(ModFoodComponents.RAW_GOLBO_LEG)));
    public static  final Item GOLBO_NUGGET = registerItem("golbo_nugget", new Item(new Item.Settings().food(ModFoodComponents.GOLBO_NUGGET)));

    public static final Item WHISTLE = registerItem("whistle", new WhistleItem(new Item.Settings().maxCount(1).maxDamage(32), InstrumentTags.GOAT_HORNS, "palido", 4));

    //MECHA AZAZETH
    public static final Item MECHA_AZAZETH_CROWN = registerItem("mecha_azazeth_crown" ,
            new ModArmorItem(ModArmorMaterials.MECHA_AZAZETH_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(30))));

    public static final Item MECHA_AZAZETH_CHESTPLATE = registerItem("mecha_azazeth_chestplate" ,
            new ArmorItem(ModArmorMaterials.MECHA_AZAZETH_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(30))));

    public static final Item MECHA_AZAZETH_LEGGINGS = registerItem("mecha_azazeth_leggings" ,
            new ArmorItem(ModArmorMaterials.MECHA_AZAZETH_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(30))));

    public static final Item MECHA_AZAZETH_BOOTS = registerItem("mecha_azazeth_boots" ,
            new ArmorItem(ModArmorMaterials.MECHA_AZAZETH_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(30))));

}
