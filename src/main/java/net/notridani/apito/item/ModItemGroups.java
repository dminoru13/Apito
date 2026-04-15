package net.notridani.apito.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
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
                        entries.add(ModItems.FOSSILIZED_SCRAP);
                        entries.add(ModItems.ROSELITA);
                        entries.add(ModItems.WHISTLE);
                        entries.add(ModItems.RAW_GOLBO_LEG);
                        entries.add(ModItems.GOLBO_NUGGET);
                        entries.add(ModBlocks.ROSELITA_BLOCK);
                        entries.add(ModBlocks.SCRAP_ORE);


                    }).build());



    public static void registerItemGroup() {
        Apito.LOGGER.info("Registering Item Groups for " + Apito.MOD_ID);
    }
}
