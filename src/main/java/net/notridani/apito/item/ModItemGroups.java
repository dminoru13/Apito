package net.notridani.apito.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.notridani.apito.Apito;
import net.notridani.apito.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup APITO_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Apito.MOD_ID, "apito_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.WHISTLE))
                    .displayName(Text.translatable("itemgroup.apito.apito_group"))
                    .entries((displayContext, entries) -> {
                        //blocos
                        entries.add(ModBlocks.CHALK);
                        entries.add(ModBlocks.ROSELITA_BLOCK);
                        entries.add(ModBlocks.SCRAP_ORE);
                        entries.add(ModBlocks.FELPS_LAMP);

                        //ingredientes
                        entries.add(ModItems.FOSSILIZED_SCRAP);
                        entries.add(ModItems.ROSELITA);

                        //comidas
                        entries.add(ModItems.RAW_GOLBO_LEG);
                        entries.add(ModItems.GOLBO_NUGGET);

                        //ferramentas
                        entries.add(ModItems.WHISTLE);

                        //armaduras
                        entries.add(ModItems.MECHA_AZAZETH_CROWN);


                    }).build());



    public static void registerItemGroup() {
        Apito.LOGGER.info("Registering Item Groups for " + Apito.MOD_ID);
    }
}
