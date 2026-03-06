package net.mcreator.quantumdimensions.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class HellrackBlock extends Block {
	public HellrackBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.NETHERRACK).strength(1f, 0.4f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}