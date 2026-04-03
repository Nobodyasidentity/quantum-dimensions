package net.mcreator.quantumdimensions.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class BigAssHammerRightclickedProcedure {
	public static boolean eventResult = true;

	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			_player.getCooldowns().addCooldown(itemstack, 200);
		}
		{
			Entity _shootFrom = entity;
			Level projectileLevel = _shootFrom.level();
			if (!projectileLevel.isClientSide()) {
				Projectile _entityToSpawn_9 = initProjectileProperties(new LargeFireball(EntityType.FIREBALL, projectileLevel), null, new Vec3(((entity.getLookAngle()).z()), ((entity.getLookAngle()).x()), ((entity.getLookAngle()).y())));
				_entityToSpawn_9.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
				_entityToSpawn_9.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
				projectileLevel.addFreshEntity(_entityToSpawn_9);
			}
		}
		if (world instanceof ServerLevel _level) {
			itemstack.hurtAndBreak(10, _level, null, _stkprov -> {
			});
		}
	}

	private static Projectile initProjectileProperties(Projectile entityToSpawn, Entity shooter, Vec3 acceleration) {
		entityToSpawn.setOwner(shooter);
		if (!Vec3.ZERO.equals(acceleration)) {
			entityToSpawn.setDeltaMovement(acceleration);
			entityToSpawn.hasImpulse = true;
		}
		return entityToSpawn;
	}
}