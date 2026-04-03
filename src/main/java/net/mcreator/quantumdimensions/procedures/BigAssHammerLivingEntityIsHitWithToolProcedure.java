package net.mcreator.quantumdimensions.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class BigAssHammerLivingEntityIsHitWithToolProcedure {
	public static boolean eventResult = true;

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level) {
			LightningBolt entityToSpawn_0 = EntityType.LIGHTNING_BOLT.create(_level, EntitySpawnReason.TRIGGERED);
			entityToSpawn_0.snapTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
			entityToSpawn_0.setVisualOnly(true);
			_level.addFreshEntity(entityToSpawn_0);
		}
		{
			Entity _ent = entity;
			_ent.teleportTo(x, (y - 1), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (y - 1), z, _ent.getYRot(), _ent.getXRot());
		}
	}
}