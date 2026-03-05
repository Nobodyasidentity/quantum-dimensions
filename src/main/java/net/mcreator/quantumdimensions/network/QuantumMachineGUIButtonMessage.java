package net.mcreator.quantumdimensions.network;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.quantumdimensions.procedures.QuantumMachineProcedureProcedure;
import net.mcreator.quantumdimensions.QuantumDimensionsMod;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public record QuantumMachineGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<QuantumMachineGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, "quantum_machine_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, QuantumMachineGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, QuantumMachineGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new QuantumMachineGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<QuantumMachineGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final QuantumMachineGUIButtonMessage message, final ServerPlayNetworking.Context context) {
		context.server().execute(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z));
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			QuantumMachineProcedureProcedure.execute(world, x, y, z, entity);
		}
	}
}