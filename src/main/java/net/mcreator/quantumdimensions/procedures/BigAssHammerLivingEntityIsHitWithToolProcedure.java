package net.mcreator.quantumdimensions.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class BigAssHammerLivingEntityIsHitWithToolProcedure {
	public static boolean eventResult = true;

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getEnchantments().getLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("quantum_dimensions:mjolner")))) != 0) {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn_2 = EntityType.LIGHTNING_BOLT.create(_level, EntitySpawnReason.TRIGGERED);
				entityToSpawn_2.snapTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
				_level.addFreshEntity(entityToSpawn_2);
			}
		} else {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn_3 = EntityType.LIGHTNING_BOLT.create(_level, EntitySpawnReason.TRIGGERED);
				entityToSpawn_3.snapTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
				entityToSpawn_3.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn_3);
			}
		}
		{
			Entity _ent = entity;
			_ent.teleportTo(x, (y - 1), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (y - 1), z, _ent.getYRot(), _ent.getXRot());
		}
	}
}