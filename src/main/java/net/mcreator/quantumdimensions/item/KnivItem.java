package net.mcreator.quantumdimensions.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.DeathProtection;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

public class KnivItem extends Item {

    private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(
        BlockTags.INCORRECT_FOR_WOODEN_TOOL, 100, 4f, 0, 2,
        TagKey.create(Registries.ITEM, ResourceLocation.parse("quantum_dimensions:kniv_repair_items"))
    );

    public KnivItem(Item.Properties properties) {
        super(properties
            .sword(TOOL_MATERIAL, 7f, -2.6f)
            .component(DataComponents.DEATH_PROTECTION, new DeathProtection(
                List.of(new ApplyStatusEffectsConsumeEffect(
                    List.of(new MobEffectInstance(
                        MobEffects.INSTANT_HEALTH,
                        1,
                        4,
                        false,
                        false,
                        false
                    )),
                    1.0f
                ))
            ))
        );
    }
}