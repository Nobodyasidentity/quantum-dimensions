package net.mcreator.quantumdimensions.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.quantumdimensions.init.QuantumDimensionsModItems;
import net.mcreator.quantumdimensions.init.QuantumDimensionsModBlocks;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;

public class FellOnNotQuiteWaterProcedure {
	public static boolean eventResult = true;

	public FellOnNotQuiteWaterProcedure() {
		ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, amount) -> {
			if (entity != null) {
				execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), damageSource, entity);
			}
			boolean result = eventResult;
			eventResult = true;
			return result;
		});
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == QuantumDimensionsModBlocks.NOT_QUITE_WATER) {
			if (damagesource.is(DamageTypes.FALL)) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn_3 = new ItemEntity(_level, x, y, z, new ItemStack(QuantumDimensionsModItems.MUSIC_DISC_DREAM_SWEET_IN_SEA_MAJOR));
					entityToSpawn_3.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn_3);
				}
				if (entity instanceof Player) {
					if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
						AdvancementHolder _adv5 = _level.getServer().getAdvancements().get(ResourceLocation.parse("quantum_dimensions:fell_on_not_quite_water_advancement"));
						if (_adv5 != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv5);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv5, criteria);
							}
						}
					}
				}
			}
		}
	}
}