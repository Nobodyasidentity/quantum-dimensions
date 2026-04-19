package net.mcreator.quantumdimensions.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.quantumdimensions.QuantumDimensionsMod;

public class MusicDiscSlashInfernoItem extends Item {
	public MusicDiscSlashInfernoItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).stacksTo(1).fireResistant().jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, "music_disc_slash_inferno"))));
	}
}