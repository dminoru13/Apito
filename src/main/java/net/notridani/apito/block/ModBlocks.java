package net.notridani.apito.block;

import io.wispforest.owo.registration.reflect.BlockRegistryContainer;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.notridani.apito.block.custom.*;
import net.notridani.apito.world.tree.ModSaplingGenerators;

public class ModBlocks implements BlockRegistryContainer {

    public static final Block PETRIFIED_TREE_SAPLING =
            new PetrifiedSaplingBlock(ModSaplingGenerators.PETRIFIED_TREE,
                    AbstractBlock.Settings.copy(Blocks.OAK_SAPLING));

    public static final Block SNAIL_BERRY_BUSH_BLOCK =
            new SnailBerryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH));

    public static final Block VAMPIRIC_BERRY_BUSH_BLOCK =
            new VampiricBerryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH));

    public static final Block SCRAP_ORE =
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .strength(3f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.STONE)
                            .luminance(state -> 3)
            );

    public static final Block ROSELITA_BLOCK =
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
                    .luminance(state -> 10));

    public static final Block CARVING_BENCH =
            new CarvingBench(AbstractBlock.Settings.create()
                    .strength(0.7f)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
                    .nonOpaque());

    public static final Block WHISTLE_FORGE =
            new WhistleForge(AbstractBlock.Settings.create()
                    .strength(-1.0F, 3600000.0F)
                    .sounds(BlockSoundGroup.STONE)
                    .nonOpaque());


    public static final Block FORGE_INPUT =
            new ForgeInput(AbstractBlock.Settings.create()
                    .strength(-1.0F, 3600000.0F)
                    .sounds(BlockSoundGroup.STONE)
                    .nonOpaque());

    public static final Block FELPS_LAMP =
            new FelpsLamp(AbstractBlock.Settings.create()
                    .strength(0.3f)
                    .luminance(state -> state.get(FelpsLamp.CARA) * 3));

    public static final Block CHALK =
            new Chalk(AbstractBlock.Settings.create()
                    .strength(0.1f)
                    .nonOpaque()
                    .noCollision());

    public static final Block POCKET_PORTAL =
            new PocketPortal(AbstractBlock.Settings.create()
                    .strength(0.1f)
                    .nonOpaque()
                    .noCollision()
                    .luminance(state -> 10));

    // 🔥 controle do BlockItem
    @Override
    public BlockItem createBlockItem(Block block, String identifier) {
        return new BlockItem(block, new Item.Settings());
    }
}