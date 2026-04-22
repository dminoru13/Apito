package net.notridani.apito.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.block.ModBlocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.Items;

public class ModItemGroups {
    public static final ItemGroup APITO_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Apito.MOD_ID, "apito_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.WHISTLE))
                    .displayName(Text.translatable("itemgroup.apito.apito_group"))
                    .entries((displayContext, entries) -> {
                        //blocos
                        entries.add(ModBlocks.PETRIFIED_TREE_SAPLING);
                        entries.add(ModBlocks.CHALK);
                        entries.add(ModBlocks.ROSELITA_BLOCK);
                        entries.add(ModBlocks.SCRAP_ORE);
                        entries.add(ModBlocks.FELPS_LAMP);

                        //pintura

                        ItemStack paintingStack = new ItemStack(Items.PAINTING);

                        NbtCompound entityData = new NbtCompound();
                        entityData.putString("id", "minecraft:painting");
                        entityData.putString("variant", "apito:galinha_galinha");

                        paintingStack.set(DataComponentTypes.ENTITY_DATA, NbtComponent.of(entityData));

                        entries.add(paintingStack);

                        //ingredientes
                        entries.add(ModItems.FOSSILIZED_SCRAP);
                        entries.add(ModItems.ROSELITA);

                        //comidas
                        entries.add(ModItems.RAW_GOLBO_LEG);
                        entries.add(ModItems.GOLBO_NUGGET);
                        entries.add(ModItems.SNAIL_BERRY);
                        entries.add(ModItems.VAMPIRIC_BERRY);

                        //ferramentas

                        //apitos
                        entries.add(ModItems.WHISTLE);

                        //discos de musica
                        entries.add(ModItems.ENDLESS_EMBRACE_MUSIC_DISC);

                        //armaduras
                        entries.add(ModItems.MECHA_AZAZETH_CROWN);

                        //spawneggs

                        entries.add(ModItems.MININORU_SPAWN_EGG);
                        entries.add(ModItems.GOLBO_SPAWN_EGG);


                    }).build());



    public static void registerItemGroup() {
        Apito.LOGGER.info("Registering Item Groups for " + Apito.MOD_ID);
    }
}
