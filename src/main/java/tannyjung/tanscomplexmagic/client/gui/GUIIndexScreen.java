package tannyjung.tanscomplexmagic.client.gui;

import tannyjung.tanscomplexmagic.world.inventory.GUIIndexMenu;
import tannyjung.tanscomplexmagic.procedures.GUILogTypeProcedure;
import tannyjung.tanscomplexmagic.network.GUIIndexButtonMessage;
import tannyjung.tanscomplexmagic.init.TanscomplexmagicModScreens;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.gui.widget.ExtendedSlider;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import com.mojang.blaze3d.systems.RenderSystem;

public class GUIIndexScreen extends AbstractContainerScreen<GUIIndexMenu> implements TanscomplexmagicModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_hello;
	private ImageButton imagebutton_gui_component_shortcut_home;
	private ExtendedSlider slider;

	public GUIIndexScreen(GUIIndexMenu container, Inventory inventory, Component text) {
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
		if (elementType == 2 && elementState instanceof Number n) {
			if (name.equals("slider"))
				slider.setValue(n.doubleValue());
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_index.png");

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
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_log_type.png"), this.leftPos + 6, this.topPos + 110, Mth.clamp((int) GUILogTypeProcedure.execute(entity) * 7, 0, 21), 0, 7, 7, 28, 7);
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
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		return (this.getFocused() != null && this.isDragging() && button == 0) ? this.getFocused().mouseDragged(mouseX, mouseY, button, dragX, dragY) : super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		button_hello = new PlainTextButton(this.leftPos + -76, this.topPos + -32, 51, 20, Component.translatable("gui.tanscomplexmagic.gui_index.button_hello"), e -> {
		}, this.font);
		this.addRenderableWidget(button_hello);
		imagebutton_gui_component_shortcut_home = new ImageButton(this.leftPos + -212, this.topPos + -108, 21, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_home.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_home_hovered.png")), e -> {
					int x = GUIIndexScreen.this.x;
					int y = GUIIndexScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIIndexButtonMessage(1, x, y, z));
						GUIIndexButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_shortcut_home);
		slider = new ExtendedSlider(this.leftPos + -144, this.topPos + -104, 100, 20, Component.translatable("gui.tanscomplexmagic.gui_index.slider_prefix"), Component.translatable("gui.tanscomplexmagic.gui_index.slider_suffix"), 0, 10, 5, 1, 0,
				true) {
			@Override
			protected void applyValue() {
				if (!menuStateUpdateActive)
					menu.sendMenuStateUpdate(entity, 2, "slider", this.getValue(), false);
			}
		};
		this.addRenderableWidget(slider);
		if (!menuStateUpdateActive)
			menu.sendMenuStateUpdate(entity, 2, "slider", slider.getValue(), false);
	}
}