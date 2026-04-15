package net.notridani.apito.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.notridani.apito.Apito;
import net.notridani.apito.block.custom.Chalk;
import net.notridani.apito.block.custom.FelpsLamp;

public class ModBlocks {

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Apito.MOD_ID, name), block);
    }


    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Apito.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }


    public static void registerModBlocks() {
        Apito.LOGGER.info("Registering Mod Blocks for " + Apito.MOD_ID);

    }




    public static final Block ROSELITA_BLOCK = registerBlock("roselita_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
                    .luminance(state -> 10)
            )
    );



    public static final Block SCRAP_ORE = registerBlock("scrap_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .luminance(state -> 3)
            )
    );

    public static final Block FELPS_LAMP = registerBlock("felps_lamp",
            new FelpsLamp(AbstractBlock.Settings.create()
                    .strength(0.3f)
                    .luminance(state -> state.get(FelpsLamp.CARA)*3)));

    public static final Block CHALK = registerBlock("chalk",
            new Chalk(AbstractBlock.Settings.create()
                    .strength(0.1f)
                    .nonOpaque()
                    .noCollision()));
}
