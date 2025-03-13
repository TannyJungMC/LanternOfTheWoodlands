package tannyjung.lanternofthewoodlands.client.gui;

import tannyjung.lanternofthewoodlands.world.inventory.Spell1GUIMenu;
import tannyjung.lanternofthewoodlands.init.LanternofthewoodlandsModScreens.WidgetScreen;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class Spell1GUIScreen extends AbstractContainerScreen<Spell1GUIMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = Spell1GUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	public static Checkbox kjn;
	Button button_empty;
	Button button_close;
	Button button_empty1;

	public Spell1GUIScreen(Spell1GUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lanternofthewoodlands:textures/screens/spell_1_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("lanternofthewoodlands:textures/screens/background_book.png"), this.leftPos + -112, this.topPos + -112, 0, 0, 400, 240, 400, 240);

		RenderSystem.disableBlend();
	}

	public HashMap<String, Object> getWidgets() {
		return guistate;
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
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_1_gui.label_pause"), -72, -92, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.lanternofthewoodlands.spell_1_gui.button_empty"), e -> {
		}).bounds(this.leftPos + -96, this.topPos + -76, 20, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_close = Button.builder(Component.translatable("gui.lanternofthewoodlands.spell_1_gui.button_close"), e -> {
		}).bounds(this.leftPos + 168, this.topPos + 88, 40, 20).build();
		guistate.put("button:button_close", button_close);
		this.addRenderableWidget(button_close);
		button_empty1 = Button.builder(Component.translatable("gui.lanternofthewoodlands.spell_1_gui.button_empty1"), e -> {
		}).bounds(this.leftPos + 200, this.topPos + -24, 8, 20).build();
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		kjn = new Checkbox(this.leftPos + -96, this.topPos + -100, 20, 20, Component.translatable("gui.lanternofthewoodlands.spell_1_gui.kjn"), false);
		guistate.put("checkbox:kjn", kjn);
		this.addRenderableWidget(kjn);
	}
}
