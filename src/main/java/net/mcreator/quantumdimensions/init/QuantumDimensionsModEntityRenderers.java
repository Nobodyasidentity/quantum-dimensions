/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.quantumdimensions.init;

import net.mcreator.quantumdimensions.client.renderer.ZombiePigmanRenderer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class QuantumDimensionsModEntityRenderers {
	public static void clientLoad() {
		EntityRendererRegistry.register(QuantumDimensionsModEntities.ZOMBIE_PIGMAN, ZombiePigmanRenderer::new);
	}
}