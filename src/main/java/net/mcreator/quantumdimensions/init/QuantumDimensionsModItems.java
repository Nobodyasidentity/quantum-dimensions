/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.quantumdimensions.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.quantumdimensions.item.TesseractItem;
import net.mcreator.quantumdimensions.item.RebreatherItem;
import net.mcreator.quantumdimensions.item.QuantumEraserItem;
import net.mcreator.quantumdimensions.QuantumDimensionsMod;

import java.util.function.Function;

public class QuantumDimensionsModItems {
	public static Item COMPACT_DIAMOND_BLOCK;
	public static Item TESSERACT;
	public static Item QUANTUM_MACHINE;
	public static Item REBREATHER;
	public static Item THE_CORRECT_FURNACE;
	public static Item QUANTUM_ERASER;

	public static void load() {
		COMPACT_DIAMOND_BLOCK = block(QuantumDimensionsModBlocks.COMPACT_DIAMOND_BLOCK, "compact_diamond_block", new Item.Properties().rarity(Rarity.EPIC).fireResistant());
		TESSERACT = register("tesseract", TesseractItem::new);
		QUANTUM_MACHINE = block(QuantumDimensionsModBlocks.QUANTUM_MACHINE, "quantum_machine", new Item.Properties().rarity(Rarity.EPIC).fireResistant());
		REBREATHER = register("rebreather", RebreatherItem::new);
		THE_CORRECT_FURNACE = block(QuantumDimensionsModBlocks.THE_CORRECT_FURNACE, "the_correct_furnace");
		QUANTUM_ERASER = register("quantum_eraser", QuantumEraserItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> I register(String name, Function<Item.Properties, ? extends I> supplier) {
		return (I) Items.registerItem(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, name)), (Function<Item.Properties, Item>) supplier);
	}

	private static Item block(Block block, String name) {
		return block(block, name, new Item.Properties());
	}

	private static Item block(Block block, String name, Item.Properties properties) {
		return Items.registerItem(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, name)), prop -> new BlockItem(block, prop), properties);
	}
}