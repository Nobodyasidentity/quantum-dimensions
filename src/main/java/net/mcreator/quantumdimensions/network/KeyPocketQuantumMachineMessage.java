package net.mcreator.quantumdimensions.network;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.quantumdimensions.procedures.TriggerPocketQuantumMachineProcedure;
import net.mcreator.quantumdimensions.QuantumDimensionsMod;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public record KeyPocketQuantumMachineMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<KeyPocketQuantumMachineMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, "key_key_pocket_quantum_machine"));
	public static final StreamCodec<RegistryFriendlyByteBuf, KeyPocketQuantumMachineMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, KeyPocketQuantumMachineMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new KeyPocketQuantumMachineMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<KeyPocketQuantumMachineMessage> type() {
		return TYPE;
	}

	public static void handleData(final KeyPocketQuantumMachineMessage message, final ServerPlayNetworking.Context context) {
		context.server().execute(() -> {
			pressAction(context.player(), message.eventType, message.pressedms);
		});
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (type == 0) {

			TriggerPocketQuantumMachineProcedure.execute(world, x, y, z, entity);
		}
	}
}