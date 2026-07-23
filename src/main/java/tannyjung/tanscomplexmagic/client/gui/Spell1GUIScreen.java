package tannyjung.tanscomplexmagic.client.gui;

import tannyjung.tanscomplexmagic.world.inventory.Spell1GUIMenu;
import tannyjung.tanscomplexmagic.init.TanscomplexmagicModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import com.mojang.blaze3d.systems.RenderSystem;

public class Spell1GUIScreen extends AbstractContainerScreen<Spell1GUIMenu> implements TanscomplexmagicModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Checkbox kjn;
	private Button button_empty;
	private Button button_close;
	private Button button_empty1;

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

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("kjn")) {
				if (kjn.selected() != logicState)
					kjn.onPress();
			}
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("tanscomplexmagic:textures/screens/spell_1_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_book.png"), this.leftPos + -112, this.topPos + -112, 0, 0, 400, 240, 400, 240);
		RenderSystem.disableBlend();
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
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_1_gui.label_pause"), -72, -92, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.tanscomplexmagic.spell_1_gui.button_empty"), e -> {
		}).bounds(this.leftPos + -96, this.topPos + -76, 20, 20).build();
		this.addRenderableWidget(button_empty);
		button_close = Button.builder(Component.translatable("gui.tanscomplexmagic.spell_1_gui.button_close"), e -> {
		}).bounds(this.leftPos + 168, this.topPos + 88, 40, 20).build();
		this.addRenderableWidget(button_close);
		button_empty1 = Button.builder(Component.translatable("gui.tanscomplexmagic.spell_1_gui.button_empty1"), e -> {
		}).bounds(this.leftPos + 200, this.topPos + -24, 8, 20).build();
		this.addRenderableWidget(button_empty1);
		kjn = Checkbox.builder(Component.translatable("gui.tanscomplexmagic.spell_1_gui.kjn"), this.font).pos(this.leftPos + -96, this.topPos + -100).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "kjn", value, false);
		}).build();
		this.addRenderableWidget(kjn);
	}
}