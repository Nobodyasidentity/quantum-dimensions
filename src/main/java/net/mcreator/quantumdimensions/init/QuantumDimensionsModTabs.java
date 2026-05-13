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

public class QuantumDimensionsModTabs {
	public static ResourceKey<CreativeModeTab> TAB_QUANTUM_DIMENSIONS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, "quantum_dimensions"));

	public static void load() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAB_QUANTUM_DIMENSIONS, CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).title(Component.translatable("item_group.quantum_dimensions.quantum_dimensions"))
				.icon(() -> new ItemStack(QuantumDimensionsModItems.TESSERACT)).displayItems((parameters, tabData) -> {
					tabData.accept(QuantumDimensionsModBlocks.QUANTUM_MACHINE.asItem());
					tabData.accept(QuantumDimensionsModItems.MUSIC_DISC_BLACKBOXWARRIOR);
					tabData.accept(QuantumDimensionsModItems.MUSIC_DISC_SLASH_INFERNO);
					tabData.accept(QuantumDimensionsModItems.MUSIC_DISC_LABYRINTH);
					tabData.accept(QuantumDimensionsModItems.MUSIC_DISC_RUNNING_IN_THE_90S);
					tabData.accept(QuantumDimensionsModItems.MUSIC_DISC_LOVE_ME_NORMALLY);
					tabData.accept(QuantumDimensionsModItems.MUSIC_DISC_OUTLIARS_AND_HYPPOCRATES);
					tabData.accept(QuantumDimensionsModItems.MUSIC_DISC_DREAM_SWEET_IN_SEA_MAJOR);
					tabData.accept(QuantumDimensionsModItems.MUSIC_DISC_HIGHSCORE);
					tabData.accept(QuantumDimensionsModItems.TESSERACT);
					tabData.accept(QuantumDimensionsModItems.REBREATHER);
					tabData.accept(QuantumDimensionsModItems.QUANTUM_ERASER);
					tabData.accept(QuantumDimensionsModItems.BIG_ASS_HAMMER);
					tabData.accept(QuantumDimensionsModItems.ZOMBIE_PIGMAN_SPAWN_EGG);
					tabData.accept(QuantumDimensionsModItems.BEAN_SOUP_BUCKET);
					tabData.accept(QuantumDimensionsModBlocks.HELLRACK.asItem());
					tabData.accept(QuantumDimensionsModBlocks.HELL_GOLD.asItem());
					tabData.accept(QuantumDimensionsModBlocks.HELL_QUARTZ_ORE.asItem());
					tabData.accept(QuantumDimensionsModBlocks.THE_CORRECT_FURNACE.asItem());
					tabData.accept(QuantumDimensionsModBlocks.NOT_QUITE_WATER.asItem());
					tabData.accept(QuantumDimensionsModItems.POCKET_QUANTUM_MACHINE);
				}).build());
	}
}