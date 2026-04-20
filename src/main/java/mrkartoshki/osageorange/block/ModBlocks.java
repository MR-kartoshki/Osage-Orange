package mrkartoshki.osageorange.block;

import mrkartoshki.osageorange.OsageOrange;
import mrkartoshki.osageorange.world.ModWorldGen;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TintedParticleLeavesBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

public final class ModBlocks {
	public static final BlockSetType OSAGE_ORANGE_BLOCK_SET_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.OAK)
		.soundGroup(SoundType.CHERRY_WOOD)
		.register(OsageOrange.id("osage_orange"));
	public static final WoodType OSAGE_ORANGE_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.OAK)
		.soundGroup(SoundType.CHERRY_WOOD)
		.register(OsageOrange.id("osage_orange"), OSAGE_ORANGE_BLOCK_SET_TYPE);

	public static final Block OSAGE_ORANGE_LOG = register(
		"osage_orange_log",
		new RotatedPillarBlock(copyBlockProperties("osage_orange_log", Blocks.OAK_LOG).mapColor(state ->
			state.getValue(RotatedPillarBlock.AXIS).isVertical() ? MapColor.COLOR_YELLOW : MapColor.TERRACOTTA_YELLOW))
	);
	public static final Block STRIPPED_OSAGE_ORANGE_LOG = register(
		"stripped_osage_orange_log",
		new RotatedPillarBlock(copyBlockProperties("stripped_osage_orange_log", Blocks.STRIPPED_OAK_LOG).mapColor(state ->
			state.getValue(RotatedPillarBlock.AXIS).isVertical() ? MapColor.TERRACOTTA_YELLOW : MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_WOOD = register(
		"osage_orange_wood",
		new RotatedPillarBlock(copyBlockProperties("osage_orange_wood", Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_YELLOW))
	);
	public static final Block STRIPPED_OSAGE_ORANGE_WOOD = register(
		"stripped_osage_orange_wood",
		new RotatedPillarBlock(copyBlockProperties("stripped_osage_orange_wood", Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_PLANKS = register(
		"osage_orange_planks",
		new Block(copyBlockProperties("osage_orange_planks", Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_STAIRS = register(
		"osage_orange_stairs",
		new StairBlock(OSAGE_ORANGE_PLANKS.defaultBlockState(), copyBlockProperties("osage_orange_stairs", Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_SLAB = register(
		"osage_orange_slab",
		new SlabBlock(copyBlockProperties("osage_orange_slab", Blocks.OAK_SLAB).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_FENCE = register(
		"osage_orange_fence",
		new FenceBlock(copyBlockProperties("osage_orange_fence", Blocks.OAK_FENCE).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_FENCE_GATE = register(
		"osage_orange_fence_gate",
		new FenceGateBlock(OSAGE_ORANGE_WOOD_TYPE, copyBlockProperties("osage_orange_fence_gate", Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_DOOR = register(
		"osage_orange_door",
		new DoorBlock(OSAGE_ORANGE_BLOCK_SET_TYPE, copyBlockProperties("osage_orange_door", Blocks.OAK_DOOR).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_TRAPDOOR = register(
		"osage_orange_trapdoor",
		new TrapDoorBlock(OSAGE_ORANGE_BLOCK_SET_TYPE, copyBlockProperties("osage_orange_trapdoor", Blocks.OAK_TRAPDOOR).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_PRESSURE_PLATE = register(
		"osage_orange_pressure_plate",
		new PressurePlateBlock(OSAGE_ORANGE_BLOCK_SET_TYPE, copyBlockProperties("osage_orange_pressure_plate", Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_BUTTON = register(
		"osage_orange_button",
		new ButtonBlock(OSAGE_ORANGE_BLOCK_SET_TYPE, 30, copyBlockProperties("osage_orange_button", Blocks.OAK_BUTTON).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_SIGN = register(
		"osage_orange_sign",
		new StandingSignBlock(OSAGE_ORANGE_WOOD_TYPE, copyBlockProperties("osage_orange_sign", Blocks.OAK_SIGN).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_WALL_SIGN = register(
		"osage_orange_wall_sign",
		new WallSignBlock(OSAGE_ORANGE_WOOD_TYPE, copyBlockProperties("osage_orange_wall_sign", Blocks.OAK_WALL_SIGN).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_HANGING_SIGN = register(
		"osage_orange_hanging_sign",
		new CeilingHangingSignBlock(OSAGE_ORANGE_WOOD_TYPE, copyBlockProperties("osage_orange_hanging_sign", Blocks.OAK_HANGING_SIGN).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_WALL_HANGING_SIGN = register(
		"osage_orange_wall_hanging_sign",
		new WallHangingSignBlock(OSAGE_ORANGE_WOOD_TYPE, copyBlockProperties("osage_orange_wall_hanging_sign", Blocks.OAK_WALL_HANGING_SIGN).mapColor(MapColor.COLOR_YELLOW))
	);
	public static final Block OSAGE_ORANGE_LEAVES = register(
		"osage_orange_leaves",
		new TintedParticleLeavesBlock(0.01F, copyBlockProperties("osage_orange_leaves", Blocks.OAK_LEAVES).mapColor(MapColor.PLANT))
	);
	public static final Block OSAGE_ORANGE_SAPLING = register(
		"osage_orange_sapling",
		new SaplingBlock(ModWorldGen.OSAGE_ORANGE_TREE_GROWER, copyBlockProperties("osage_orange_sapling", Blocks.OAK_SAPLING))
	);
	public static final Block POTTED_OSAGE_ORANGE_SAPLING = register(
		"potted_osage_orange_sapling",
		new FlowerPotBlock(OSAGE_ORANGE_SAPLING, copyBlockProperties("potted_osage_orange_sapling", Blocks.POTTED_OAK_SAPLING))
	);

	private ModBlocks() {
	}

	public static void initialize() {
		StrippableBlockRegistry.register(OSAGE_ORANGE_LOG, STRIPPED_OSAGE_ORANGE_LOG);
		StrippableBlockRegistry.register(OSAGE_ORANGE_WOOD, STRIPPED_OSAGE_ORANGE_WOOD);
		((FabricBlockEntityType) BlockEntityType.SIGN).addSupportedBlock(OSAGE_ORANGE_SIGN);
		((FabricBlockEntityType) BlockEntityType.SIGN).addSupportedBlock(OSAGE_ORANGE_WALL_SIGN);
		((FabricBlockEntityType) BlockEntityType.HANGING_SIGN).addSupportedBlock(OSAGE_ORANGE_HANGING_SIGN);
		((FabricBlockEntityType) BlockEntityType.HANGING_SIGN).addSupportedBlock(OSAGE_ORANGE_WALL_HANGING_SIGN);

		FlammableBlockRegistry flammables = FlammableBlockRegistry.getDefaultInstance();
		flammables.add(OSAGE_ORANGE_LOG, 5, 5);
		flammables.add(STRIPPED_OSAGE_ORANGE_LOG, 5, 5);
		flammables.add(OSAGE_ORANGE_WOOD, 5, 5);
		flammables.add(STRIPPED_OSAGE_ORANGE_WOOD, 5, 5);
		flammables.add(OSAGE_ORANGE_PLANKS, 5, 20);
		flammables.add(OSAGE_ORANGE_STAIRS, 5, 20);
		flammables.add(OSAGE_ORANGE_SLAB, 5, 20);
		flammables.add(OSAGE_ORANGE_FENCE, 5, 20);
		flammables.add(OSAGE_ORANGE_FENCE_GATE, 5, 20);
		flammables.add(OSAGE_ORANGE_DOOR, 5, 20);
		flammables.add(OSAGE_ORANGE_TRAPDOOR, 5, 20);
		flammables.add(OSAGE_ORANGE_PRESSURE_PLATE, 5, 20);
		flammables.add(OSAGE_ORANGE_BUTTON, 5, 20);
		flammables.add(OSAGE_ORANGE_SIGN, 5, 20);
		flammables.add(OSAGE_ORANGE_WALL_SIGN, 5, 20);
		flammables.add(OSAGE_ORANGE_HANGING_SIGN, 5, 20);
		flammables.add(OSAGE_ORANGE_WALL_HANGING_SIGN, 5, 20);
		flammables.add(OSAGE_ORANGE_LEAVES, 30, 60);
	}

	private static Block register(String name, Block block) {
		return Registry.register(BuiltInRegistries.BLOCK, OsageOrange.id(name), block);
	}

	private static BlockBehaviour.Properties copyBlockProperties(String name, Block source) {
		return BlockBehaviour.Properties.ofFullCopy(source)
			.setId(ResourceKey.create(Registries.BLOCK, OsageOrange.id(name)));
	}
}
