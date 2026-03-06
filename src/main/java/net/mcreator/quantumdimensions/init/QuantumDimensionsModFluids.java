/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.quantumdimensions.init;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.mcreator.quantumdimensions.fluid.BeanSoupFluid;
import net.mcreator.quantumdimensions.QuantumDimensionsMod;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.function.Supplier;

public class QuantumDimensionsModFluids {
	public static FlowingFluid BEAN_SOUP;
	public static FlowingFluid FLOWING_BEAN_SOUP;

	public static void load() {
		BEAN_SOUP = register("bean_soup", BeanSoupFluid.Source::new);
		FLOWING_BEAN_SOUP = register("flowing_bean_soup", BeanSoupFluid.Flowing::new);
	}

	@Environment(EnvType.CLIENT)
	public static void clientLoad() {
		BeanSoupFluid.clientLoad();
	}

	private static <F extends Fluid> F register(String registryname, Supplier<F> element) {
		return (F) Registry.register(BuiltInRegistries.FLUID, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, registryname), element.get());
	}
}