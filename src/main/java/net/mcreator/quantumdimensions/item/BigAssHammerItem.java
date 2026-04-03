package net.mcreator.quantumdimensions.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class BigAssHammerItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 100, 4f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("quantum_dimensions:big_ass_hammer_repair_items")));

	public BigAssHammerItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 8f, -3f).rarity(Rarity.RARE));
	}
}