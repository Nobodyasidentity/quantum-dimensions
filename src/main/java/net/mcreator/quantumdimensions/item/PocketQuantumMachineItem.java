package net.mcreator.quantumdimensions.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.component.DataComponents;

import net.mcreator.quantumdimensions.world.inventory.QuantumMachineGUIMenu;

import io.netty.buffer.Unpooled;

import com.mojang.serialization.DataResult;

public class PocketQuantumMachineItem extends Item {
	public PocketQuantumMachineItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).stacksTo(1).fireResistant());
	}

	private MenuProvider createMenuProvider(ItemStack stack, Player entity, InteractionHand hand) {
		return new MenuProvider() {
			@Override
			public Component getDisplayName() {
				return Component.literal("Pocket Quantum Machine");
			}

			@Override
			public AbstractContainerMenu createMenu(int id, Inventory invIgnored, Player player) {
				FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
				packetBuffer.writeBlockPos(entity.blockPosition());
				packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
				SimpleContainer inventory = new SimpleContainer(1) {
				};
				CustomData nbtComponent = stack.get(DataComponents.CUSTOM_DATA);
				if (nbtComponent != null) {
					CompoundTag rootTag = nbtComponent.copyTag();
					rootTag.getList("inventory_pocket_quantum_machine").ifPresent(itemsTag -> {
						for (int i = 0; i < Math.min(itemsTag.size(), 1); i++) {
							Tag itemTag = itemsTag.get(i);
							if (itemTag instanceof CompoundTag compound) {
								final int slot = i;
								ItemStack.CODEC.parse(NbtOps.INSTANCE, compound).result().ifPresent(itemStack -> inventory.setItem(slot, itemStack));
							}
						}
					});
				}
				inventory.addListener(inv -> {
					ListTag itemsTag = new ListTag();
					for (ItemStack itemStack : inventory) {
						if (!itemStack.isEmpty()) {
							DataResult<Tag> result = ItemStack.CODEC.encodeStart(NbtOps.INSTANCE, itemStack);
							result.result().ifPresent(itemsTag::add);
						} else {
							itemsTag.add(new CompoundTag());
						}
					}
					CompoundTag rootTag = new CompoundTag();
					rootTag.put("inventory_pocket_quantum_machine", itemsTag);
					stack.set(DataComponents.CUSTOM_DATA, CustomData.of(rootTag));
				});
				return new QuantumMachineGUIMenu(id, invIgnored, inventory, packetBuffer);
			}
		};
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.BLOCK;
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		if (entity instanceof ServerPlayer serverPlayer) {
			serverPlayer.openMenu(createMenuProvider(serverPlayer.getItemInHand(hand), entity, hand));
		}
		return ar;
	}
}