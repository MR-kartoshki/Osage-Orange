package mrkartoshki.osageorange.world;

import mrkartoshki.osageorange.OsageOrange;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public final class ModWorldGen {
	public static final ResourceKey<ConfiguredFeature<?, ?>> OSAGE_ORANGE_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, OsageOrange.id("osage_orange"));
	public static final ResourceKey<PlacedFeature> OSAGE_ORANGE_TREE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, OsageOrange.id("osage_orange"));
	public static final TreeGrower OSAGE_ORANGE_TREE_GROWER = new TreeGrower(
		"osage_orange",
		Optional.empty(),
		Optional.of(OSAGE_ORANGE_TREE),
		Optional.empty()
	);

	private ModWorldGen() {
	}

	public static void initialize() {
		BiomeModifications.addFeature(
			BiomeSelectors.tag(BiomeTags.IS_FOREST),
			GenerationStep.Decoration.VEGETAL_DECORATION,
			OSAGE_ORANGE_TREE_PLACED
		);
	}
}
