/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.quantumdimensions.init;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.quantumdimensions.block.TheCorrectFurnaceBlock;
import net.mcreator.quantumdimensions.block.QuantumMachineBlock;
import net.mcreator.quantumdimensions.block.HellrackBlock;
import net.mcreator.quantumdimensions.block.CompactDiamondBlockBlock;
import net.mcreator.quantumdimensions.block.BeanSoupBlock;
import net.mcreator.quantumdimensions.QuantumDimensionsMod;

import java.util.function.Function;

public class QuantumDimensionsModBlocks {
	public static Block COMPACT_DIAMOND_BLOCK;
	public static Block QUANTUM_MACHINE;
	public static Block THE_CORRECT_FURNACE;
	public static Block HELLRACK;
	public static Block BEAN_SOUP;

	public static void load() {
		COMPACT_DIAMOND_BLOCK = register("compact_diamond_block", CompactDiamondBlockBlock::new);
		QUANTUM_MACHINE = register("quantum_machine", QuantumMachineBlock::new);
		THE_CORRECT_FURNACE = register("the_correct_furnace", TheCorrectFurnaceBlock::new);
		HELLRACK = register("hellrack", HellrackBlock::new);
		BEAN_SOUP = register("bean_soup", BeanSoupBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> B register(String name, Function<BlockBehaviour.Properties, B> supplier) {
		return (B) Blocks.register(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, name)), (Function<BlockBehaviour.Properties, Block>) supplier, BlockBehaviour.Properties.of());
	}
}