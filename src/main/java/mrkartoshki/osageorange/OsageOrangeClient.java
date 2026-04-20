package mrkartoshki.osageorange;

import mrkartoshki.osageorange.block.ModBlocks;
import mrkartoshki.osageorange.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.level.FoliageColor;

public class OsageOrangeClient implements ClientModInitializer {
	private static final ModelLayerLocation OSAGE_ORANGE_BOAT_LAYER = new ModelLayerLocation(OsageOrange.id("boat/osage_orange"), "main");
	private static final ModelLayerLocation OSAGE_ORANGE_CHEST_BOAT_LAYER = new ModelLayerLocation(OsageOrange.id("chest_boat/osage_orange"), "main");

	@Override
	public void onInitializeClient() {
		EntityModelLayerRegistry.registerModelLayer(OSAGE_ORANGE_BOAT_LAYER, BoatModel::createBoatModel);
		EntityModelLayerRegistry.registerModelLayer(OSAGE_ORANGE_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);

		EntityRendererRegistry.register(ModEntities.HEDGE_APPLE_PROJECTILE, ThrownItemRenderer::new);
		EntityRendererRegistry.register(ModEntities.OSAGE_ORANGE_BOAT, context -> new BoatRenderer(context, OSAGE_ORANGE_BOAT_LAYER));
		EntityRendererRegistry.register(ModEntities.OSAGE_ORANGE_CHEST_BOAT, context -> new BoatRenderer(context, OSAGE_ORANGE_CHEST_BOAT_LAYER));

		ColorProviderRegistry.BLOCK.register(
			(state, world, pos, tintIndex) -> world != null && pos != null
				? BiomeColors.getAverageFoliageColor(world, pos)
				: FoliageColor.FOLIAGE_DEFAULT,
			ModBlocks.OSAGE_ORANGE_LEAVES
		);

		BlockRenderLayerMap.putBlocks(
			ChunkSectionLayer.CUTOUT,
			ModBlocks.OSAGE_ORANGE_LEAVES,
			ModBlocks.OSAGE_ORANGE_SAPLING,
			ModBlocks.POTTED_OSAGE_ORANGE_SAPLING,
			ModBlocks.OSAGE_ORANGE_DOOR,
			ModBlocks.OSAGE_ORANGE_TRAPDOOR
		);
	}
}
