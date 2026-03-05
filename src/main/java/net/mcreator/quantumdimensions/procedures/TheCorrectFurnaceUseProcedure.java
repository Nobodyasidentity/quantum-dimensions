package net.mcreator.quantumdimensions.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.quantumdimensions.init.QuantumDimensionsModItems;

public class TheCorrectFurnaceUseProcedure {
	public static boolean eventResult = true;

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		if (world instanceof Level _level && !_level.isClientSide()) {
			_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.BLOCK);
		}
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn_2 = new ItemEntity(_level, x, y, z, new ItemStack(QuantumDimensionsModItems.TESSERACT));
			entityToSpawn_2.setPickUpDelay(10);
			entityToSpawn_2.setUnlimitedLifetime();
			_level.addFreshEntity(entityToSpawn_2);
		}
		if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
			AdvancementHolder _adv3 = _level.getServer().getAdvancements().get(ResourceLocation.parse("quantum_dimensions:get_the_correct_furnace"));
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