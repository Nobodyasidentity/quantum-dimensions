package net.mcreator.quantumdimensions.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

public class RebreatherAdvancementProcedure {
	public static boolean eventResult = true;

	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("quantum_dimensions:the_27th_dimension"))) {
			if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
				AdvancementHolder _adv3 = _level.getServer().getAdvancements().get(ResourceLocation.parse("quantum_dimensions:get_rebreather"));
				if (_adv3 != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv3);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv3, criteria);
					}
				}
			}
		}
	}
}