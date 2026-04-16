package net.mcreator.quantumdimensions.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.quantumdimensions.QuantumDimensionsMod;

public class MusicDiscDreamSweetInSeaMajorItem extends Item {
	public MusicDiscDreamSweetInSeaMajorItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).stacksTo(1).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, "music_disc_dream_sweet_in_sea_major"))));
	}
}