package mrkartoshki.osageorange.entity;

import mrkartoshki.osageorange.OsageOrange;
import mrkartoshki.osageorange.entity.projectile.CrabAppleProjectileEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.Item;

public final class ModEntities {
	public static final EntityType<CrabAppleProjectileEntity> CRAB_APPLE_PROJECTILE = register(
		"crab_apple_projectile",
		EntityType.Builder.<CrabAppleProjectileEntity>of(CrabAppleProjectileEntity::new, MobCategory.MISC)
			.sized(0.25F, 0.25F)
			.clientTrackingRange(4)
			.updateInterval(10)
	);
	public static final EntityType<Boat> OSAGE_ORANGE_BOAT = register(
		"osage_orange_boat",
		EntityType.Builder.<Boat>of((entityType, level) ->
				new Boat(entityType, level, () -> itemById("osage_orange_boat")), MobCategory.MISC)
			.sized(1.375F, 0.5625F)
			.clientTrackingRange(10)
			.updateInterval(10)
	);
	public static final EntityType<ChestBoat> OSAGE_ORANGE_CHEST_BOAT = register(
		"osage_orange_chest_boat",
		EntityType.Builder.<ChestBoat>of((entityType, level) ->
				new ChestBoat(entityType, level, () -> itemById("osage_orange_chest_boat")), MobCategory.MISC)
			.sized(1.375F, 0.5625F)
			.clientTrackingRange(10)
			.updateInterval(10)
	);

	private ModEntities() {
	}

	public static void initialize() {
	}

	private static <T extends net.minecraft.world.entity.Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
		ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, OsageOrange.id(name));
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, OsageOrange.id(name), builder.build(key));
	}

	private static Item itemById(String path) {
		return BuiltInRegistries.ITEM.getValue(OsageOrange.id(path));
	}
}
