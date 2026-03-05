package net.mcreator.quantumdimensions.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class QuantumEraserLivingEntityIsHitWithItemProcedure {
	public static boolean eventResult = true;

	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
			_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 12000, 1));
			_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 12000, 1));
			_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 12000, 1));
		}
	}
}