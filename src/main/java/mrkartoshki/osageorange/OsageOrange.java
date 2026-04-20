package mrkartoshki.osageorange;

import mrkartoshki.osageorange.block.ModBlocks;
import mrkartoshki.osageorange.entity.ModEntities;
import mrkartoshki.osageorange.item.ModItems;
import mrkartoshki.osageorange.world.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OsageOrange implements ModInitializer {
	public static final String MOD_ID = "osage-orange";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ModEntities.initialize();
		ModItems.initialize();
		ModWorldGen.initialize();
	}
}
