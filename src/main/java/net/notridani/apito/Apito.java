package net.notridani.apito;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.block.entity.ModBlockEntities;
import net.notridani.apito.component.ModDataComponentTypes;
import net.notridani.apito.effect.ModEffects;
import net.notridani.apito.enchantment.ModEnchantments;
import net.notridani.apito.entity.ModEntities;
import net.notridani.apito.entity.custom.GolboEntity;
import net.notridani.apito.entity.custom.MininoruEntity;
import net.notridani.apito.event.ModEvents;
import net.notridani.apito.item.ModItemGroups;
import net.notridani.apito.item.ModItems;
import net.notridani.apito.potion.ModPotions;
import net.notridani.apito.sound.ModSounds;
import net.notridani.apito.world.gen.ModWorldGenneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Apito implements ModInitializer {
	public static final String MOD_ID = "apito";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroup();
		ModItems.registerModItems();

		ModPotions.registerPotion();
		ModEffects.registerEffects();

		ModWorldGenneration.generateModWorldGen();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();

		ModEntities.registerModEntities();
		FabricDefaultAttributeRegistry.register(ModEntities.MININORU, MininoruEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.GOLBO, GolboEntity.createAttributes());

		ModEnchantments.registerEnchantmentEffects();

		ModEvents.registerEvents();

		ModDataComponentTypes.registerDataComponentTypes();

		ModSounds.registerSounds();
	}
}