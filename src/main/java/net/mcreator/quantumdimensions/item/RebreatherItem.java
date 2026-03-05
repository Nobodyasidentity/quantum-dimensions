package net.mcreator.quantumdimensions.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import net.mcreator.quantumdimensions.procedures.RebreatherAdvancementProcedure;
import net.mcreator.quantumdimensions.QuantumDimensionsMod;

public class RebreatherItem extends Item {
    public RebreatherItem(Item.Properties properties) {
        super(properties.stacksTo(1)
                .component(DataComponents.EQUIPPABLE,
                        Equippable.builder(EquipmentSlot.HEAD)
                                .setCameraOverlay(ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, "misc/rebreatherblur"))
                                .build()).attributes(ItemAttributeModifiers.builder().add(
                                Attributes.OXYGEN_BONUS,
                                new AttributeModifier(ResourceLocation.fromNamespaceAndPath(QuantumDimensionsMod.MODID, "rebreather_oxygen"), 20, AttributeModifier.Operation.ADD_VALUE),
                                EquipmentSlotGroup.HEAD
                        ).build()));
    }
	@Override
	public void onCraftedBy(ItemStack itemstack, Player entity) {
		super.onCraftedBy(itemstack, entity);
		RebreatherAdvancementProcedure.execute(entity);
	}
}