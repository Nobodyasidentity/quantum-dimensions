/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.quantumdimensions.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.mcreator.quantumdimensions.QuantumDimensionsMod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

public class QuantumDimensionsModTabs {
	public static ResourceKey<CreativeModeTab> TAB_QUANTUM_DIMENSIONS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, "quantum_dimensions"));

	public static void load() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAB_QUANTUM_DIMENSIONS,
				FabricItemGroup.builder().title(Component.translatable("item_group.quantum_dimensions.quantum_dimensions")).icon(() -> new ItemStack(QuantumDimensionsModItems.TESSERACT)).displayItems((parameters, tabData) -> {
					tabData.accept(QuantumDimensionsModBlocks.COMPACT_DIAMOND_BLOCK.asItem());
					tabData.accept(QuantumDimensionsModItems.TESSERACT);
					tabData.accept(QuantumDimensionsModBlocks.QUANTUM_MACHINE.asItem());
					tabData.accept(QuantumDimensionsModItems.REBREATHER);
					tabData.accept(QuantumDimensionsModBlocks.THE_CORRECT_FURNACE.asItem());
					tabData.accept(QuantumDimensionsModItems.QUANTUM_ERASER);
					tabData.accept(QuantumDimensionsModBlocks.HELLRACK.asItem());
					tabData.accept(QuantumDimensionsModItems.BEAN_SOUP_BUCKET);
				}).build());
	}
}