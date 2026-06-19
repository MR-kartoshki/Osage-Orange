package mrkartoshki.osageorange.item;

import mrkartoshki.osageorange.OsageOrange;
import mrkartoshki.osageorange.block.ModBlocks;
import mrkartoshki.osageorange.entity.ModEntities;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.DispenserBlock;

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
	public static final Item OSAGE_ORANGE_SHELF = registerBlockItem("osage_orange_shelf", ModBlocks.OSAGE_ORANGE_SHELF);

	public static final Item CRAB_APPLE = register("crab_apple", new CrabAppleItem(itemProperties("crab_apple").stacksTo(16).useCooldown(1.0F)));
	public static final Item OSAGE_ORANGE_BOAT = register("osage_orange_boat", new BoatItem(ModEntities.OSAGE_ORANGE_BOAT, itemProperties("osage_orange_boat").stacksTo(1)));
	public static final Item OSAGE_ORANGE_CHEST_BOAT = register("osage_orange_chest_boat", new BoatItem(ModEntities.OSAGE_ORANGE_CHEST_BOAT, itemProperties("osage_orange_chest_boat").stacksTo(1)));

	private ModItems() {
	}

	public static void initialize() {
		CompostableRegistry.INSTANCE.add(CRAB_APPLE, 0.3F);
		DispenserBlock.registerProjectileBehavior(CRAB_APPLE);

		// Slot each group in right after the pale oak equivalents so the items read as
		// "the next wood type" instead of being dumped at the bottom of each tab.
		CreativeModeTabEvents.modifyOutputEvent(vanillaTab("building_blocks")).register(output -> {
			output.insertAfter(Items.PALE_OAK_BUTTON,
				OSAGE_ORANGE_LOG, OSAGE_ORANGE_WOOD, STRIPPED_OSAGE_ORANGE_LOG, STRIPPED_OSAGE_ORANGE_WOOD,
				OSAGE_ORANGE_PLANKS, OSAGE_ORANGE_STAIRS, OSAGE_ORANGE_SLAB,
				OSAGE_ORANGE_FENCE, OSAGE_ORANGE_FENCE_GATE, OSAGE_ORANGE_DOOR, OSAGE_ORANGE_TRAPDOOR,
				OSAGE_ORANGE_PRESSURE_PLATE, OSAGE_ORANGE_BUTTON);
		});

		CreativeModeTabEvents.modifyOutputEvent(vanillaTab("natural_blocks")).register(output -> {
			output.insertAfter(Items.PALE_OAK_LOG, OSAGE_ORANGE_LOG);
			output.insertAfter(Items.PALE_OAK_LEAVES, OSAGE_ORANGE_LEAVES);
			output.insertAfter(Items.PALE_OAK_SAPLING, OSAGE_ORANGE_SAPLING, CRAB_APPLE);
		});

		CreativeModeTabEvents.modifyOutputEvent(vanillaTab("functional_blocks")).register(output -> {
			output.insertAfter(Items.PALE_OAK_SHELF, OSAGE_ORANGE_SHELF);
			output.insertAfter(Items.PALE_OAK_HANGING_SIGN, OSAGE_ORANGE_SIGN, OSAGE_ORANGE_HANGING_SIGN);
		});

		CreativeModeTabEvents.modifyOutputEvent(vanillaTab("tools_and_utilities")).register(output -> {
			output.insertAfter(Items.PALE_OAK_CHEST_BOAT, OSAGE_ORANGE_BOAT, OSAGE_ORANGE_CHEST_BOAT);
		});
	}

	private static ResourceKey<CreativeModeTab> vanillaTab(String name) {
		return ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath("minecraft", name));
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
