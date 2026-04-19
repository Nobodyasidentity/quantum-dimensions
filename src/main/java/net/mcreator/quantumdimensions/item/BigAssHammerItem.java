package net.mcreator.quantumdimensions.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.quantumdimensions.procedures.BigAssHammerRightclickedProcedure;
import net.mcreator.quantumdimensions.procedures.BigAssHammerLivingEntityIsHitWithToolProcedure;

public class BigAssHammerItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 1337, 4f, 0, 5, TagKey.create(Registries.ITEM, ResourceLocation.parse("quantum_dimensions:big_ass_hammer_repair_items")));

	public BigAssHammerItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 9f, -2.9f).rarity(Rarity.RARE).fireResistant());
	}

	@Override
	public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		super.hurtEnemy(itemstack, entity, sourceentity);
		BigAssHammerLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		BigAssHammerRightclickedProcedure.execute(world, entity, entity.getItemInHand(hand));
		return ar;
	}
}