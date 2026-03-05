package net.mcreator.quantumdimensions.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.quantumdimensions.world.inventory.QuantumMachineGUIMenu;
import net.mcreator.quantumdimensions.network.QuantumMachineGUIButtonMessage;
import net.mcreator.quantumdimensions.init.QuantumDimensionsModScreens;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class QuantumMachineGUIScreen extends AbstractContainerScreen<QuantumMachineGUIMenu> implements QuantumDimensionsModScreens.FabricScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_teleport;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("quantum_dimensions:textures/screens/quantum_machine_gui.png");

	public QuantumMachineGUIScreen(QuantumMachineGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.quantum_dimensions.quantum_machine_gui.label_quantum_machine"), 51, 7, -1, true);
	}

	@Override
	public void init() {
		super.init();
		button_teleport = Button.builder(Component.translatable("gui.quantum_dimensions.quantum_machine_gui.button_teleport"), e -> {
			int x = QuantumMachineGUIScreen.this.x;
			int y = QuantumMachineGUIScreen.this.y;
			if (true) {
				ClientPlayNetworking.send(new QuantumMachineGUIButtonMessage(0, x, y, z));
				QuantumMachineGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 55, this.topPos + 53, 65, 20).build();
		this.addRenderableWidget(button_teleport);
	}
}