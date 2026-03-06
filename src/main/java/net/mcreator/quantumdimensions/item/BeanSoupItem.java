package net.mcreator.quantumdimensions.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.quantumdimensions.init.QuantumDimensionsModFluids;

public class BeanSoupItem extends BucketItem {
	public BeanSoupItem(Item.Properties properties) {
		super(QuantumDimensionsModFluids.BEAN_SOUP, properties.craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}