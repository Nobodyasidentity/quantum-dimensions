package net.mcreator.quantumdimensions.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DeadTesseractItem extends Item {
	public DeadTesseractItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).stacksTo(16));
	}
}