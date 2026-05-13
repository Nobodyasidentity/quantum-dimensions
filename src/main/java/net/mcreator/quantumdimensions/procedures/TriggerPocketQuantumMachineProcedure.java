package net.mcreator.quantumdimensions.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.client.player.LocalPlayer;

import net.mcreator.quantumdimensions.world.inventory.QuantumMachineGUIMenu;
import net.mcreator.quantumdimensions.init.QuantumDimensionsModMenus;
import net.mcreator.quantumdimensions.init.QuantumDimensionsModItems;

import io.netty.buffer.Unpooled;

public class TriggerPocketQuantumMachineProcedure {
	public static boolean eventResult = true;

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == QuantumDimensionsModItems.POCKET_QUANTUM_MACHINE) {
			if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos4 = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("QuantumMachineGUI");
						}

						@Override
						public boolean shouldCloseCurrentScreen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new QuantumMachineGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos4));
						}
					});
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof QuantumDimensionsModMenus.MenuAccessor _menu) {
					ItemStack _setstack6 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack6.setCount(1);
					_menu.getSlots().get(0).set(_setstack6);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack10 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack10.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack10);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				QuantumMachineProcedureProcedure.execute(world, x, y, z, entity);
				if (entity instanceof LocalPlayer _player) {
					_player.closeContainer();
				}
			}
		}
	}
}