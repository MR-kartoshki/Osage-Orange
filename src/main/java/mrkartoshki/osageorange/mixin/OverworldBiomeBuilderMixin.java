package mrkartoshki.osageorange.mixin;

import mrkartoshki.osageorange.world.ModBiomes;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.resources.ResourceKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Injects Black Mesa into the overworld climate map. Vanilla picks a badlands-family biome from
 * {@code pickBadlandsBiome} for the hot temperature band; we carve out the driest, non-eroded slice
 * (humidity index 0, weirdness &lt; 0) for Black Mesa. Normal Badlands still generates for the other
 * humidity/weirdness slices, so the two coexist in the same mesa region.
 */
@Mixin(OverworldBiomeBuilder.class)
public class OverworldBiomeBuilderMixin {
	@Inject(method = "pickBadlandsBiome", at = @At("HEAD"), cancellable = true)
	private void osageorange$blackMesa(int humidityIndex, Climate.Parameter weirdness, CallbackInfoReturnable<ResourceKey<Biome>> cir) {
		if (humidityIndex == 0 && weirdness.max() < 0L) {
			cir.setReturnValue(ModBiomes.BLACK_MESA);
		}
	}
}
