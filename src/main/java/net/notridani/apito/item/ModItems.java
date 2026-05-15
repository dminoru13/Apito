package net.notridani.apito.item;

import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.entity.ModEntities;
import net.notridani.apito.item.custom.ModArmorItem;
import net.notridani.apito.item.custom.WhistleItem;
import net.notridani.apito.sound.ModSounds;

public class ModItems implements ItemRegistryContainer {

    // NATURAIS
    public static final Item FOSSILIZED_SCRAP = new Item(new Item.Settings());
    public static final Item ROSELITA = new Item(new Item.Settings());
    public static final Item ANCIENT_HEART = new Item(new Item.Settings());
    public static final Item RAW_WHISTLE = new Item(new Item.Settings());

    public static final Item SNAIL_BERRY = new AliasedBlockItem(ModBlocks.SNAIL_BERRY_BUSH_BLOCK, new Item.Settings().food(ModFoodComponents.SNAIL_BERRY));

    public static final Item VAMPIRIC_BERRY = new AliasedBlockItem(ModBlocks.VAMPIRIC_BERRY_BUSH_BLOCK, new Item.Settings().food(ModFoodComponents.VAMPIRIC_BERRY));

    // COMIDAS
    public static final Item RAW_GOLBO_LEG = new Item(new Item.Settings().food(ModFoodComponents.RAW_GOLBO_LEG));

    public static final Item GOLBO_NUGGET = new Item(new Item.Settings().food(ModFoodComponents.GOLBO_NUGGET));

    // APITO
    public static final Item WHISTLE = new WhistleItem(new Item.Settings().maxCount(1).maxDamage(32), 4, 0, 1, 1);

    // DISCOS
    public static final Item ENDLESS_EMBRACE_MUSIC_DISC = new Item(new Item.Settings()
                    .jukeboxPlayable(ModSounds.D_ENDLESS_EMBRACE_KEY)
                    .maxCount(1));

    // ARMADURA
    public static final Item MECHA_AZAZETH_CROWN = new ModArmorItem(ModArmorMaterials.MECHA_AZAZETH_MATERIAL,
                    ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(30)));


    // SPAWN EGGS
    public static final Item MININORU_SPAWN_EGG =
            new SpawnEggItem(ModEntities.MININORU, 0x4d1313, 0xad9d9d, new Item.Settings());

    public static final Item GOLBO_SPAWN_EGG =
            new SpawnEggItem(ModEntities.GOLBO, 0xe7e7e7, 0xf48686, new Item.Settings());
}