package mrkartoshki.osageorange.item;

import mrkartoshki.osageorange.OsageOrange;
import mrkartoshki.osageorange.block.ModBlocks;
import mrkartoshki.osageorange.entity.ModEntities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;

public final class ModItems {
	public static final Item OSAGE_ORANGE_LOG = registerBlockItem("osage_orange_log", ModBlocks.OSAGE_ORANGE_LOG);
	public static final Item STRIPPED_OSAGE_ORANGE_LOG = registerBlockItem("stripped_osage_orange_log", ModBlocks.STRIPPED_OSAGE_ORANGE_LOG);
	public static final Item OSAGE_ORANGE_WOOD = registerBlockItem("osage_orange_wood", ModBlocks.OSAGE_ORANGE_WOOD);
	public static final Item STRIPPED_OSAGE_ORANGE_WOOD = registerBlockItem("stripped_osage_orange_wood", ModBlocks.STRIPPED_OSAGE_ORANGE_WOOD);
	public static final Item OSAGE_ORANGE_PLANKS = registerBlockItem("osage_orange_planks", ModBlocks.OSAGE_ORANGE_PLANKS);
	public static final Item OSAGE_ORANGE_STAIRS = registerBlockItem("osage_orange_stairs", ModBlocks.OSAGE_ORANGE_STAIRS);
	public static final Item OSAGE_ORANGE_SLAB = registerBlockItem("osage_orange_slab", ModBlocks.OSAGE_ORANGE_SLAB);
	public static final Item OSAGE_ORANGE_FENCE = registerBlockItem("osage_orange_fence", ModBlocks.OSAGE_ORANGE_FENCE);
	public static final Item OSAGE_ORANGE_FENCE_GATE = registerBlockItem("osage_orange_fence_gate", ModBlocks.OSAGE_ORANGE_FENCE_GATE);
	public static final Item OSAGE_ORANGE_DOOR = registerBlockItem("osage_orange_door", ModBlocks.OSAGE_ORANGE_DOOR);
	public static final Item OSAGE_ORANGE_TRAPDOOR = registerBlockItem("osage_orange_trapdoor", ModBlocks.OSAGE_ORANGE_TRAPDOOR);
	public static final Item OSAGE_ORANGE_PRESSURE_PLATE = registerBlockItem("osage_orange_pressure_plate", ModBlocks.OSAGE_ORANGE_PRESSURE_PLATE);
	public static final Item OSAGE_ORANGE_BUTTON = registerBlockItem("osage_orange_button", ModBlocks.OSAGE_ORANGE_BUTTON);
	public static final Item OSAGE_ORANGE_SIGN = register("osage_orange_sign", new SignItem(ModBlocks.OSAGE_ORANGE_SIGN, ModBlocks.OSAGE_ORANGE_WALL_SIGN, itemProperties("osage_orange_sign").stacksTo(16)));
	public static final Item OSAGE_ORANGE_HANGING_SIGN = register("osage_orange_hanging_sign", new HangingSignItem(ModBlocks.OSAGE_ORANGE_HANGING_SIGN, ModBlocks.OSAGE_ORANGE_WALL_HANGING_SIGN, itemProperties("osage_orange_hanging_sign").stacksTo(16)));
	public static final Item OSAGE_ORANGE_LEAVES = registerBlockItem("osage_orange_leaves", ModBlocks.OSAGE_ORANGE_LEAVES);
	public static final Item OSAGE_ORANGE_SAPLING = registerBlockItem("osage_orange_sapling", ModBlocks.OSAGE_ORANGE_SAPLING);

	public static final Item HEDGE_APPLE = register("hedge_apple", new HedgeAppleItem(itemProperties("hedge_apple").stacksTo(16).useCooldown(1.0F)));
	public static final Item OSAGE_ORANGE_BOAT = register("osage_orange_boat", new BoatItem(ModEntities.OSAGE_ORANGE_BOAT, itemProperties("osage_orange_boat").stacksTo(1)));
	public static final Item OSAGE_ORANGE_CHEST_BOAT = register("osage_orange_chest_boat", new BoatItem(ModEntities.OSAGE_ORANGE_CHEST_BOAT, itemProperties("osage_orange_chest_boat").stacksTo(1)));

	private ModItems() {
	}

	public static void initialize() {
		CompostingChanceRegistry.INSTANCE.add(HEDGE_APPLE, 0.3F);

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
			entries.accept(OSAGE_ORANGE_LOG);
			entries.accept(STRIPPED_OSAGE_ORANGE_LOG);
			entries.accept(OSAGE_ORANGE_WOOD);
			entries.accept(STRIPPED_OSAGE_ORANGE_WOOD);
			entries.accept(OSAGE_ORANGE_LEAVES);
			entries.accept(OSAGE_ORANGE_SAPLING);
			entries.accept(HEDGE_APPLE);
		});

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
			entries.accept(OSAGE_ORANGE_PLANKS);
			entries.accept(OSAGE_ORANGE_STAIRS);
			entries.accept(OSAGE_ORANGE_SLAB);
			entries.accept(OSAGE_ORANGE_FENCE);
			entries.accept(OSAGE_ORANGE_FENCE_GATE);
			entries.accept(OSAGE_ORANGE_DOOR);
			entries.accept(OSAGE_ORANGE_TRAPDOOR);
			entries.accept(OSAGE_ORANGE_PRESSURE_PLATE);
			entries.accept(OSAGE_ORANGE_BUTTON);
		});

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
			entries.accept(OSAGE_ORANGE_SIGN);
			entries.accept(OSAGE_ORANGE_HANGING_SIGN);
		});

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
			entries.accept(OSAGE_ORANGE_BOAT);
			entries.accept(OSAGE_ORANGE_CHEST_BOAT);
		});
	}

	private static Item registerBlockItem(String name, net.minecraft.world.level.block.Block block) {
		return register(name, new BlockItem(block, itemProperties(name)));
	}

	private static Item register(String name, Item item) {
		return Registry.register(BuiltInRegistries.ITEM, OsageOrange.id(name), item);
	}

	private static Item.Properties itemProperties(String name) {
		return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, OsageOrange.id(name)));
	}
}
