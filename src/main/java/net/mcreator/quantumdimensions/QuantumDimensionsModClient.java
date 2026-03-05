package net.mcreator.quantumdimensions;

import net.mcreator.quantumdimensions.init.QuantumDimensionsModScreens;
import net.mcreator.quantumdimensions.init.QuantumDimensionsModMenus;
import net.mcreator.quantumdimensions.init.QuantumDimensionsModBlocksRenderers;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ClientModInitializer;

@Environment(EnvType.CLIENT)
public class QuantumDimensionsModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		QuantumDimensionsModBlocksRenderers.clientLoad();
		QuantumDimensionsModScreens.clientLoad();
		QuantumDimensionsModMenus.clientLoad();
		// Start of user code block mod init
		// End of user code block mod init
	}
	// Start of user code block mod methods
	// End of user code block mod methods
}