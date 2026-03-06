/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.quantumdimensions.init;

import net.mcreator.quantumdimensions.fluid.BeanSoupFluid;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class QuantumDimensionsModBlocksRenderers {
	public static void clientLoad() {
		BeanSoupFluid.registerRenderLayer();
	}
	// Start of user code block custom block renderers
	// End of user code block custom block renderers
}