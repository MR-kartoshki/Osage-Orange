package mrkartoshki.osageorange.world;

import com.mojang.serialization.MapCodec;
import mrkartoshki.osageorange.OsageOrange;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import net.minecraft.world.item.DyeColor;

/**
 * A copy of vanilla's {@code minecraft:bandlands} surface rule, adjusted so that only the plain and
 * red terracotta bands are turned into black terracotta — every other band colour (orange, yellow,
 * brown, white, light gray) is left exactly as a normal mesa.
 *
 * <p>Like {@link SurfaceRules.RuleSource} {@code Bandlands}, this defers to the world's per-seed clay
 * band array via {@link SurfaceSystem#getBand}; it just remaps the result. It is referenced only from
 * the Black Mesa branch of the overworld surface rules (which is already biome-gated), so it never
 * affects vanilla badlands.
 */
public enum BlackBandlandsRuleSource implements SurfaceRules.RuleSource {
	INSTANCE;

	public static final MapCodec<BlackBandlandsRuleSource> CODEC = MapCodec.unit(INSTANCE);

	private static final BlockState BLACK_TERRACOTTA = Blocks.DYED_TERRACOTTA.pick(DyeColor.BLACK).defaultBlockState();
	private static final net.minecraft.world.level.block.Block RED_TERRACOTTA = Blocks.DYED_TERRACOTTA.pick(DyeColor.RED);

	public static void register() {
		Registry.register(BuiltInRegistries.MATERIAL_RULE, OsageOrange.id("black_bandlands"), CODEC);
	}

	@Override
	public MapCodec<? extends SurfaceRules.RuleSource> codec() {
		return CODEC;
	}

	@Override
	public SurfaceRules.SurfaceRule apply(final SurfaceRules.Context context) {
		final SurfaceSystem system = context.system;
		return (x, y, z) -> {
			BlockState state = system.getBand(x, y, z);
			if (state.is(Blocks.TERRACOTTA) || state.is(RED_TERRACOTTA)) {
				return BLACK_TERRACOTTA;
			}
			return state;
		};
	}
}
