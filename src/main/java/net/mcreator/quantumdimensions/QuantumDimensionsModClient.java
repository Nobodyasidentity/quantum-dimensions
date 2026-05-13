package net.mcreator.quantumdimensions;

import net.mcreator.quantumdimensions.init.*;

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
		QuantumDimensionsModEntityRenderers.clientLoad();
		QuantumDimensionsModFluids.clientLoad();
		QuantumDimensionsModDimensionsEffects.clientLoad();
		QuantumDimensionsModScreens.clientLoad();
		QuantumDimensionsModMenus.clientLoad();
		QuantumDimensionsModKeyMappings.clientLoad();
		// Start of user code block mod init
		// End of user code block mod init
	}
	// Start of user code block mod methods
	// End of user code block mod methods
}