package net.mcreator.quantumdimensions.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TesseractItem extends Item {
	public TesseractItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).stacksTo(1).fireResistant());
	}
}