package net.mcreator.quantumdimensions.client.renderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.quantumdimensions.entity.ZombiePigmanEntity;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class ZombiePigmanRenderer extends HumanoidMobRenderer<ZombiePigmanEntity, ZombiePigmanRenderer.ZombiePigmanRenderState, ZombiePigmanRenderer.ZombiePigmanModel> {
	private static final ResourceLocation TEXTURE = ResourceLocation.parse("quantum_dimensions:textures/entities/zombie_pigman.png");

	public ZombiePigmanRenderer(EntityRendererProvider.Context context) {
		super(context, new ZombiePigmanModel(context.bakeLayer(ModelLayers.ZOMBIE)), 0.5f);
		this.addLayer(new HumanoidArmorLayer<>(this,
			new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
			new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)),
			context.getEquipmentRenderer()));
	}

	@Override
	public ZombiePigmanRenderState createRenderState() {
		return new ZombiePigmanRenderState();
	}

	@Override
	public void extractRenderState(ZombiePigmanEntity entity, ZombiePigmanRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.isAggressive = entity.getTarget() != null;
	}

	@Override
	public ResourceLocation getTextureLocation(ZombiePigmanRenderState state) {
		return TEXTURE;
	}

	public static class ZombiePigmanRenderState extends HumanoidRenderState {
		public boolean isAggressive = false;
	}

	public static class ZombiePigmanModel extends HumanoidModel<ZombiePigmanRenderState> {
		public ZombiePigmanModel(ModelPart root) {
			super(root);
		}

		@Override
		public void setupAnim(ZombiePigmanRenderState state) {

			super.setupAnim(state);

			float pos   = state.walkAnimationPos;
			float speed = state.walkAnimationSpeed;

			float aggressiveExtra = state.isAggressive ? (float)(Math.PI / 12F) : 0.0F;

			float raise = (float)(Math.PI / 2F) + aggressiveExtra;

			this.rightArm.xRot = (float) Math.cos(pos * 0.6662F + Math.PI) * 2.0F * speed * 0.5F - raise;
			this.leftArm.xRot  = (float) Math.cos(pos * 0.6662F) * 2.0F * speed * 0.5F - raise;
			this.rightArm.zRot = 0.0F;
			this.leftArm.zRot  = 0.0F;
		}
	}
}