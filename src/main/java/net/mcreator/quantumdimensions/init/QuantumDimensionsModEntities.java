/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.quantumdimensions.init;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.mcreator.quantumdimensions.entity.ZombiePigmanEntity;
import net.mcreator.quantumdimensions.QuantumDimensionsMod;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class QuantumDimensionsModEntities {
	public static EntityType<ZombiePigmanEntity> ZOMBIE_PIGMAN;

	public static void load() {
		ZOMBIE_PIGMAN = register("zombie_pigman", EntityType.Builder.<ZombiePigmanEntity>of(ZombiePigmanEntity::new, MobCategory.MONSTER).clientTrackingRange(64).updateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.6f, 1.8f));
		init();
		registerAttributes();
	}

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> EntityType<T> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, registryname),
				(EntityType<T>) entityTypeBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, registryname))));
	}

	public static void init() {
		ZombiePigmanEntity.init();
	}

	public static void registerAttributes() {
		FabricDefaultAttributeRegistry.register(ZOMBIE_PIGMAN, ZombiePigmanEntity.createAttributes());
	}
}