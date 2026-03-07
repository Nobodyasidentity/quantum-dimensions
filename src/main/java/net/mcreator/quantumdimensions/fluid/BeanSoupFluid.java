package net.mcreator.quantumdimensions.fluid;

import org.apache.logging.log4j.core.util.Source;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.InsideBlockEffectType;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

import net.mcreator.quantumdimensions.init.QuantumDimensionsModItems;
import net.mcreator.quantumdimensions.init.QuantumDimensionsModFluids;
import net.mcreator.quantumdimensions.init.QuantumDimensionsModBlocks;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributes;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributeHandler;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.Optional;

public abstract class BeanSoupFluid extends FlowingFluid {
	@Environment(EnvType.CLIENT)
	public static final FluidVariantAttributeHandler fluidAttributes = new FluidVariantAttributeHandler() {
		@Override
		public Optional<SoundEvent> getFillSound(FluidVariant variant) {
			return Optional.of(SoundEvents.BUCKET_FILL);
		}

		@Override
		public Optional<SoundEvent> getEmptySound(FluidVariant variant) {
			return Optional.of(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.bucket.empty_lava")));
		}

		@Override
		public int getLuminance(FluidVariant variant) {
			return 15;
		}
	};

	@Override
	protected void entityInside(Level level, BlockPos blockPos, Entity entity, InsideBlockEffectApplier insideBlockEffectApplier) {
		insideBlockEffectApplier.apply(InsideBlockEffectType.LAVA_IGNITE);
		insideBlockEffectApplier.runAfter(InsideBlockEffectType.LAVA_IGNITE, Entity::lavaHurt);
	}

	private BeanSoupFluid() {
		super();
	}

	@Override
	protected boolean canConvertToSource(ServerLevel level) {
		return false;
	}

	@Override
	protected void beforeDestroyingBlock(LevelAccessor level, BlockPos pos, BlockState state) {
		BlockEntity blockEntity = state.hasBlockEntity() ? level.getBlockEntity(pos) : null;
		Block.dropResources(state, level, pos, blockEntity);
	}

	@Override
	protected boolean canBeReplacedWith(FluidState state, BlockGetter level, BlockPos pos, Fluid fluid, Direction direction) {
		return direction == Direction.DOWN && !isSame(fluid);
	}

	@Override
	public Fluid getFlowing() {
		return QuantumDimensionsModFluids.FLOWING_BEAN_SOUP;
	}

	@Override
	public Fluid getSource() {
		return QuantumDimensionsModFluids.BEAN_SOUP;
	}

	@Override
	public float getExplosionResistance() {
		return 100f;
	}

	@Override
	public int getTickDelay(LevelReader level) {
		return 5;
	}

	@Override
	protected int getDropOff(LevelReader level) {
		return 1;
	}

	@Override
	protected int getSlopeFindDistance(LevelReader level) {
		return 4;
	}

	@Override
	public Item getBucket() {
		return QuantumDimensionsModItems.BEAN_SOUP_BUCKET;
	}

	@Override
	protected BlockState createLegacyBlock(FluidState state) {
		if (QuantumDimensionsModBlocks.BEAN_SOUP != null)
			return ((LiquidBlock) QuantumDimensionsModBlocks.BEAN_SOUP).defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(state));
		return Blocks.AIR.defaultBlockState();
	}

	@Override
	public boolean isSame(Fluid fluid) {
		return fluid == getSource() || fluid == getFlowing();
	}

	@Override
	public Optional<SoundEvent> getPickupSound() {
		return Optional.ofNullable(SoundEvents.BUCKET_FILL);
	}

	public static class Source extends BeanSoupFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends BeanSoupFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}

	@Environment(EnvType.CLIENT)
	public static void clientLoad() {
		FluidVariantAttributes.register(QuantumDimensionsModFluids.BEAN_SOUP, fluidAttributes);
		FluidVariantAttributes.register(QuantumDimensionsModFluids.FLOWING_BEAN_SOUP, fluidAttributes);
		FluidRenderHandlerRegistry.INSTANCE.register(QuantumDimensionsModFluids.BEAN_SOUP, QuantumDimensionsModFluids.FLOWING_BEAN_SOUP,
				new SimpleFluidRenderHandler(ResourceLocation.parse("quantum_dimensions:block/bean_soup"), ResourceLocation.parse("quantum_dimensions:block/bean_soup_flow")));
	}

	@Environment(EnvType.CLIENT)
	public static void registerRenderLayer() {
		BlockRenderLayerMap.putFluids(ChunkSectionLayer.TRANSLUCENT, QuantumDimensionsModFluids.BEAN_SOUP, QuantumDimensionsModFluids.FLOWING_BEAN_SOUP);
	}
}