package net.mcreator.quantumdimensions.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.quantumdimensions.QuantumDimensionsMod;

public class CassetteOnlyYouItem extends Item {
	public CassetteOnlyYouItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).stacksTo(1).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, "cassette_only_you"))));
	}
}