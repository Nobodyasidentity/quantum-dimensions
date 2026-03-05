package net.mcreator.quantumdimensions.world.dimension;

import net.minecraft.world.phys.Vec3;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.DimensionSpecialEffects;

import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;

public class The27thDimensionDimension {
	public static void load() {
		DimensionSpecialEffects customEffect = new DimensionSpecialEffects(DimensionSpecialEffects.SkyType.OVERWORLD, false, false) {
			@Override
			public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
				return color.multiply(sunHeight * 0.94 + 0.06, sunHeight * 0.94 + 0.06, sunHeight * 0.91 + 0.09);
			}

			@Override
			public boolean isFoggyAt(int x, int y) {
				return false;
			}
		};
		DimensionRenderingRegistry.registerDimensionEffects(ResourceLocation.parse("quantum_dimensions:the_27th_dimension"), customEffect);
	}
}