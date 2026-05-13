/*
* MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.quantumdimensions.init;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.quantumdimensions.network.KeyPocketQuantumMachineMessage;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class QuantumDimensionsModKeyMappings {
	public static final KeyMapping KEY_POCKET_QUANTUM_MACHINE = new KeyMapping("key.quantum_dimensions.key_pocket_quantum_machine", GLFW.GLFW_KEY_X, "key.categories.quantum_dimensions") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPlayNetworking.send(new KeyPocketQuantumMachineMessage(0, 0));
				KeyPocketQuantumMachineMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	public static void clientLoad() {
		KeyBindingHelper.registerKeyBinding(KEY_POCKET_QUANTUM_MACHINE);
		ClientTickEvents.END_CLIENT_TICK.register((client) -> {
			if (client.screen == null) {
				KEY_POCKET_QUANTUM_MACHINE.consumeClick();
			}
		});
	}
}