package tannyjung.tanscomplexmagic.client.gui;

import tannyjung.tanscomplexmagic.world.inventory.MenuGUIMenu;
import tannyjung.tanscomplexmagic.procedures.GUIreturnPageRightProcedure;
import tannyjung.tanscomplexmagic.procedures.GUIreturnPageLeftProcedure;
import tannyjung.tanscomplexmagic.procedures.GUIreturnManaProcedure;
import tannyjung.tanscomplexmagic.network.MenuGUIButtonMessage;
import tannyjung.tanscomplexmagic.init.TanscomplexmagicModScreens;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import com.mojang.blaze3d.systems.RenderSystem;

public class MenuGUIScreen extends AbstractContainerScreen<MenuGUIMenu> implements TanscomplexmagicModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_symbol_exit;
	private ImageButton imagebutton_symbol_next;
	private ImageButton imagebutton_symbol_previous;
	private ImageButton imagebutton_background_text_dark_gray;

	public MenuGUIScreen(MenuGUIMenu container, Inventory inventory, Component text) {
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
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("tanscomplexmagic:textures/screens/menu_gui.png");

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
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_book.png"), this.leftPos + -160, this.topPos + -104, 0, 0, 400, 240, 400, 240);
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
		guiGraphics.drawString(this.font, GUIreturnManaProcedure.execute(entity), -160, -116, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_book_index"), -92, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_about_this_mod"), -120, -52, -12698050, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_04"), -144, -52, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_5"), -144, 4, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_ally_list"), -120, 48, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_06"), -144, -40, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_alternative_keyboard"), -120, 36, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_10"), -144, -8, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_settings_and_upgrades"), -120, -8, -12698050, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_spell_control_panel"), 32, -88, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_00"), -144, 36, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_history"), -120, -40, -12698050, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_15"), -144, 48, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_from_creator"), -120, 4, -12698050, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_151"), -144, 60, -6710887, false);
		guiGraphics.drawString(this.font, GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font, GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_mana_regeneration"), -120, 60, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_035"), 8, -88, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_personal_skill"), 32, -76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_037"), 8, -76, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_043"), 8, -44, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_advance_spells"), 32, -44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_045"), 8, -32, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_information"), -144, -68, -6750208, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_agreements"), -144, -24, -6750208, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_hncgnc"), -144, 20, -6750208, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_spell_control_panel1"), 8, -60, -6750208, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.menu_gui.label_autumn_of_loss"), 32, -32, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png")), e -> {
					int x = MenuGUIScreen.this.x;
					int y = MenuGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new MenuGUIButtonMessage(0, x, y, z));
						MenuGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_next.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_next.png")), e -> {
					int x = MenuGUIScreen.this.x;
					int y = MenuGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new MenuGUIButtonMessage(1, x, y, z));
						MenuGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_previous.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_previous.png")), e -> {
					int x = MenuGUIScreen.this.x;
					int y = MenuGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new MenuGUIButtonMessage(2, x, y, z));
						MenuGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_background_text_dark_gray = new ImageButton(this.leftPos + -144, this.topPos + -92, 184, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_dark_gray.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_dark_gray.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_dark_gray);
	}
}