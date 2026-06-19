package mrkartoshki.osageorange;

import java.util.List;

import mrkartoshki.osageorange.block.ModBlocks;
import mrkartoshki.osageorange.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

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

		// Tint the leaves with the biome foliage color, exactly like vanilla leaves.
		// The foliage tint source drives block rendering, break particles
		// (BlockTintSource#colorAsTerrainParticle), and the falling-leaf particle color
		// (Level#getClientLeafTintColor) — a plain BlockTintsFactory only covers rendering.
		BlockColorRegistry.register(List.of(BlockTintSources.foliage()), ModBlocks.OSAGE_ORANGE_LEAVES);

		// Render layers (cutout) are inherited from the vanilla parent models, so no
		// BlockRenderLayerMap registration is needed in Minecraft 26.x.
	}
}
