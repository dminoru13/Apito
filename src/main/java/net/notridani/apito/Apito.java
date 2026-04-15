package net.notridani.apito;

import net.fabricmc.api.ModInitializer;

import net.notridani.apito.block.ModBlocks;
import net.notridani.apito.component.ModDataComponentTypes;
import net.notridani.apito.item.ModItemGroups;
import net.notridani.apito.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Apito implements ModInitializer {
	public static final String MOD_ID = "apito";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroup();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModDataComponentTypes.registerDataComponentTypes();
	}
}