/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.quantumdimensions.init;

import net.mcreator.quantumdimensions.network.KeyPocketQuantumMachineMessage;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class QuantumDimensionsModKeyMappingsServer {
	public static void serverLoad() {
		PayloadTypeRegistry.playC2S().register(KeyPocketQuantumMachineMessage.TYPE, KeyPocketQuantumMachineMessage.STREAM_CODEC);
		ServerPlayNetworking.registerGlobalReceiver(KeyPocketQuantumMachineMessage.TYPE, KeyPocketQuantumMachineMessage::handleData);
	}
}