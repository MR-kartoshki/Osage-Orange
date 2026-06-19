package mrkartoshki.osageorange.sound;

import mrkartoshki.osageorange.OsageOrange;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public final class ModSounds {
	public static final SoundEvent CRAB_APPLE_THROW = register("crab_apple_throw");

	private ModSounds() {
	}

	public static void initialize() {
	}

	private static SoundEvent register(String name) {
		Identifier id = OsageOrange.id(name);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
	}
}
