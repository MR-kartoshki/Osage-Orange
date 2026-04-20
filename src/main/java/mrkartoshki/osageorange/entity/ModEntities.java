package mrkartoshki.osageorange.entity;

import mrkartoshki.osageorange.OsageOrange;
import mrkartoshki.osageorange.entity.projectile.HedgeAppleProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.Item;

public final class ModEntities {
	public static final EntityType<HedgeAppleProjectileEntity> HEDGE_APPLE_PROJECTILE = register(
		"hedge_apple_projectile",
		FabricEntityTypeBuilder.<HedgeAppleProjectileEntity>create(MobCategory.MISC, HedgeAppleProjectileEntity::new)
			.dimensions(EntityDimensions.scalable(0.25F, 0.25F))
			.trackRangeBlocks(4)
			.trackedUpdateRate(10)
	);
	public static final EntityType<Boat> OSAGE_ORANGE_BOAT = register(
		"osage_orange_boat",
		FabricEntityTypeBuilder.<Boat>create(MobCategory.MISC, (entityType, level) ->
				new Boat(entityType, level, () -> itemById("osage_orange_boat")))
			.dimensions(EntityDimensions.scalable(1.375F, 0.5625F))
			.trackRangeBlocks(10)
			.trackedUpdateRate(10)
	);
	public static final EntityType<ChestBoat> OSAGE_ORANGE_CHEST_BOAT = register(
		"osage_orange_chest_boat",
		FabricEntityTypeBuilder.<ChestBoat>create(MobCategory.MISC, (entityType, level) ->
				new ChestBoat(entityType, level, () -> itemById("osage_orange_chest_boat")))
			.dimensions(EntityDimensions.scalable(1.375F, 0.5625F))
			.trackRangeBlocks(10)
			.trackedUpdateRate(10)
	);

	private ModEntities() {
	}

	public static void initialize() {
	}

	private static <T extends net.minecraft.world.entity.Entity> EntityType<T> register(String name, FabricEntityTypeBuilder<T> builder) {
		ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, OsageOrange.id(name));
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, OsageOrange.id(name), builder.build(key));
	}

	private static Item itemById(String path) {
		return BuiltInRegistries.ITEM.getValue(OsageOrange.id(path));
	}
}
