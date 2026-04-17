package net.notridani.apito.item;

import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.InstrumentTags;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.item.custom.ModArmorItem;
import net.notridani.apito.item.custom.WhistleItem;
import net.notridani.apito.sound.ModSounds;

public class ModItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Apito.MOD_ID, name), item);
    }


    public static void registerModItems() {

        Apito.LOGGER.info("Registering Mod Items for " + Apito.MOD_ID);
    }

    //NATURAIS
    public static final Item FOSSILIZED_SCRAP = registerItem("fossilized_scrap", new Item(new Item.Settings()));
    public static final Item ROSELITA = registerItem("roselita", new Item(new Item.Settings()));

    public static final Item SNAIL_BERRY = registerItem("snail_berry",
            new AliasedBlockItem(ModBlocks.SNAIL_BERRY_BUSH_BLOCK, new Item.Settings().food(ModFoodComponents.SNAIL_BERRY)));

    public static final Item VAMPIRIC_BERRY = registerItem("vampiric_berry",
            new AliasedBlockItem(ModBlocks.VAMPIRIC_BERRY_BUSH_BLOCK, new Item.Settings().food(ModFoodComponents.VAMPIRIC_BERRY)));

    //COMIDAS
    public static  final Item RAW_GOLBO_LEG = registerItem("raw_golbo_leg", new Item(new Item.Settings().food(ModFoodComponents.RAW_GOLBO_LEG)));
    public static  final Item GOLBO_NUGGET = registerItem("golbo_nugget", new Item(new Item.Settings().food(ModFoodComponents.GOLBO_NUGGET)));

    //APITOS
    public static final Item WHISTLE = registerItem("whistle", new WhistleItem(new Item.Settings().maxCount(1).maxDamage(32), InstrumentTags.GOAT_HORNS, "palido", 4));
    public static final Item WHISTLE2 = registerItem("whistle2", new WhistleItem(new Item.Settings().maxCount(1).maxDamage(32), InstrumentTags.GOAT_HORNS, "cobre", 4));
    public static final Item WHISTLE3 = registerItem("whistle3", new WhistleItem(new Item.Settings().maxCount(1).maxDamage(32), InstrumentTags.GOAT_HORNS, "macabro", 4));
    public static final Item WHISTLE4 = registerItem("whistle4", new WhistleItem(new Item.Settings().maxCount(1).maxDamage(32), InstrumentTags.GOAT_HORNS, "assombrado", 4));
    public static final Item WHISTLE5 = registerItem("whistle5", new WhistleItem(new Item.Settings().maxCount(1).maxDamage(32), InstrumentTags.GOAT_HORNS, "fiu_fiu", 4));

    //DISCOS DE MUSICA
    public static final Item ENDLESS_EMBRACE_MUSIC_DISC = registerItem("endless_embrace_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.D_ENDLESS_EMBRACE_KEY).maxCount(1)));


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
