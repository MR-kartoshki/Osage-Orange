package mrkartoshki.osageorange;

import mrkartoshki.osageorange.block.ModBlocks;
import mrkartoshki.osageorange.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.level.FoliageColor;

public class OsageOrangeClient implements ClientModInitializer {
	private static final ModelLayerLocation OSAGE_ORANGE_BOAT_LAYER = new ModelLayerLocation(OsageOrange.id("boat/osage_orange"), "main");
	private static final ModelLayerLocation OSAGE_ORANGE_CHEST_BOAT_LAYER = new ModelLayerLocation(OsageOrange.id("chest_boat/osage_orange"), "main");

	@Override
	public void onInitializeClient() {
		ModelLayerRegistry.registerModelLayer(OSAGE_ORANGE_BOAT_LAYER, BoatModel::createBoatModel);
		ModelLayerRegistry.registerModelLayer(OSAGE_ORANGE_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);

		EntityRenderers.register(ModEntities.CRAB_APPLE_PROJECTILE, ThrownItemRenderer::new);
		EntityRenderers.register(ModEntities.OSAGE_ORANGE_BOAT, context -> new BoatRenderer(context, OSAGE_ORANGE_BOAT_LAYER));
		EntityRenderers.register(ModEntities.OSAGE_ORANGE_CHEST_BOAT, context -> new BoatRenderer(context, OSAGE_ORANGE_CHEST_BOAT_LAYER));

		// Tint the leaves with the biome foliage color (tint index 0).
		BlockColorRegistry.register(
			(state, world, pos, tints) -> tints.add(world != null && pos != null
				? BiomeColors.getAverageFoliageColor(world, pos)
				: FoliageColor.FOLIAGE_DEFAULT),
			ModBlocks.OSAGE_ORANGE_LEAVES
		);

		// Render layers (cutout) are inherited from the vanilla parent models, so no
		// BlockRenderLayerMap registration is needed in Minecraft 26.x.
	}
}
