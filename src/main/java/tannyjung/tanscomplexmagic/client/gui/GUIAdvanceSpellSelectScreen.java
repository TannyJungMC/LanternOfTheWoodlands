package tannyjung.tanscomplexmagic.client.gui;

import tannyjung.tanscomplexmagic.world.inventory.GUIAdvanceSpellSelectMenu;
import tannyjung.tanscomplexmagic.procedures.*;
import tannyjung.tanscomplexmagic.network.GUIAdvanceSpellSelectButtonMessage;
import tannyjung.tanscomplexmagic.init.TanscomplexmagicModScreens;

import net.neoforged.neoforge.network.PacketDistributor;

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

public class GUIAdvanceSpellSelectScreen extends AbstractContainerScreen<GUIAdvanceSpellSelectMenu> implements TanscomplexmagicModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_select;
	private Button button_empty1;
	private Button button_empty2;
	private ImageButton imagebutton_gui_component_close;
	private ImageButton imagebutton_gui_component_page_previous;
	private ImageButton imagebutton_gui_component_page_next;
	private ImageButton imagebutton_gui_component_shortcut_home;
	private ImageButton imagebutton_gui_component_shortcut_custom;
	private ImageButton imagebutton_gui_component_shortcut_custom_set;
	private ImageButton imagebutton_gui_component_shortcut_ally_list;
	private ImageButton imagebutton_gui_component_shortcut_basic_spell;
	private ImageButton imagebutton_gui_component_shortcut_spell_contr;
	private ImageButton imagebutton_gui_component_log_type_set;
	private ImageButton imagebutton_gui_component_compass_custom_set;
	private ImageButton imagebutton_icon_spell_sword_manipulation;
	private ImageButton imagebutton_icon_advance_spell4;
	private ImageButton imagebutton_gui_component_line;

	public GUIAdvanceSpellSelectScreen(GUIAdvanceSpellSelectMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_advance_spell_select.png");

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
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_background.png"), this.leftPos + -200, this.topPos + -120, 0, 0, 400, 240, 400, 240);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/z.png"), this.leftPos + 20, this.topPos + -96, 0, 0, 152, 180, 152, 180);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_mana_bar.png"), this.leftPos + 195, this.topPos + -108, Mth.clamp((int) GUIManaProcedure.execute(entity) * 1, 0, 150), 0, 1, 150, 151, 150);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_mana_bar_charge.png"), this.leftPos + 195, this.topPos + 46, Mth.clamp((int) GUIManaChargeProcedure.execute(entity) * 1, 0, 60), 0, 1, 60, 61, 60);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_log_type.png"), this.leftPos + 6, this.topPos + 110, Mth.clamp((int) GUILogTypeProcedure.execute(entity) * 7, 0, 21), 0, 7, 7, 28, 7);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_clock.png"), this.leftPos + -189, this.topPos + 110, Mth.clamp((int) GUIClockProcedure.execute(world) * 7, 0, 161), 0, 7, 7, 168, 7);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_compass.png"), this.leftPos + -181, this.topPos + 110, Mth.clamp((int) GUICompassProcedure.execute(entity) * 7, 0, 49), 0, 7, 7, 56, 7);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_compass_custom.png"), this.leftPos + -173, this.topPos + 110, Mth.clamp((int) GUICompassCustomProcedure.execute(entity) * 7, 0, 49), 0, 7, 7, 56, 7);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_chart.png"), this.leftPos + -68, this.topPos + -44, 270, 0, 54, 3, 324, 3);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_chart.png"), this.leftPos + -68, this.topPos + -32, 0, 0, 54, 3, 324, 3);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_chart.png"), this.leftPos + -68, this.topPos + -20, 162, 0, 54, 3, 324, 3);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_chart.png"), this.leftPos + -68, this.topPos + -8, 0, 0, 54, 3, 324, 3);
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
		guiGraphics.drawString(this.font, GUIPageNumberLeftProcedure.execute(entity), -170, 98, -4017518, false);
		guiGraphics.drawString(this.font, GUIPageNumberRightProcedure.execute(entity), 156, 98, -4017518, false);
		guiGraphics.drawString(this.font, GUILogProcedure.execute(entity), 16, 109, -3368704, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_advance_spell_select.label_sword_manipulation"), -160, -80, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_advance_spell_select.label_autumn_of_loss1"), -160, -100, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_advance_spell_select.label_damage"), -180, -12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_advance_spell_select.label_defense"), -180, 0, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_advance_spell_select.label_accuracy"), -180, 12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_advance_spell_select.label_adaptability"), -180, 24, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_advance_spell_select.label_performance_impact"), -180, 48, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_advance_spell_select.label_difficulty"), -180, 36, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_advance_spell_select.label_spell_of_sword_control"), -172, -56, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + 16, this.topPos + 28, 12, 20, Component.translatable("gui.tanscomplexmagic.gui_advance_spell_select.button_empty"), e -> {
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_select = Button.builder(Component.translatable("gui.tanscomplexmagic.gui_advance_spell_select.button_select"), e -> {
		}).bounds(this.leftPos + -120, this.topPos + 64, 48, 20).build();
		this.addRenderableWidget(button_select);
		button_empty1 = Button.builder(Component.translatable("gui.tanscomplexmagic.gui_advance_spell_select.button_empty1"), e -> {
		}).bounds(this.leftPos + -132, this.topPos + 64, 8, 20).build();
		this.addRenderableWidget(button_empty1);
		button_empty2 = Button.builder(Component.translatable("gui.tanscomplexmagic.gui_advance_spell_select.button_empty2"), e -> {
		}).bounds(this.leftPos + -68, this.topPos + 64, 8, 20).build();
		this.addRenderableWidget(button_empty2);
		imagebutton_gui_component_close = new ImageButton(this.leftPos + 204, this.topPos + 112, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_close.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_close_hovered.png")), e -> {
					int x = GUIAdvanceSpellSelectScreen.this.x;
					int y = GUIAdvanceSpellSelectScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIAdvanceSpellSelectButtonMessage(4, x, y, z));
						GUIAdvanceSpellSelectButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_close);
		imagebutton_gui_component_page_previous = new ImageButton(this.leftPos + -188, this.topPos + 92, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_page_previous.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_page_previous_hovered.png")), e -> {
					int x = GUIAdvanceSpellSelectScreen.this.x;
					int y = GUIAdvanceSpellSelectScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIAdvanceSpellSelectButtonMessage(5, x, y, z));
						GUIAdvanceSpellSelectButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_page_previous);
		imagebutton_gui_component_page_next = new ImageButton(this.leftPos + 172, this.topPos + 92, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_page_next.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_page_next_hovered.png")), e -> {
					int x = GUIAdvanceSpellSelectScreen.this.x;
					int y = GUIAdvanceSpellSelectScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIAdvanceSpellSelectButtonMessage(6, x, y, z));
						GUIAdvanceSpellSelectButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_page_next);
		imagebutton_gui_component_shortcut_home = new ImageButton(this.leftPos + -212, this.topPos + -108, 21, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_home.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_home_hovered.png")), e -> {
					int x = GUIAdvanceSpellSelectScreen.this.x;
					int y = GUIAdvanceSpellSelectScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIAdvanceSpellSelectButtonMessage(7, x, y, z));
						GUIAdvanceSpellSelectButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_shortcut_home);
		imagebutton_gui_component_shortcut_custom = new ImageButton(this.leftPos + -212, this.topPos + -96, 21, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_custom.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_custom_hovered.png")), e -> {
					int x = GUIAdvanceSpellSelectScreen.this.x;
					int y = GUIAdvanceSpellSelectScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIAdvanceSpellSelectButtonMessage(8, x, y, z));
						GUIAdvanceSpellSelectButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_shortcut_custom);
		imagebutton_gui_component_shortcut_custom_set = new ImageButton(this.leftPos + -197, this.topPos + -87, 4, 4,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_custom_set.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_custom_set_hovered.png")), e -> {
					int x = GUIAdvanceSpellSelectScreen.this.x;
					int y = GUIAdvanceSpellSelectScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIAdvanceSpellSelectButtonMessage(9, x, y, z));
						GUIAdvanceSpellSelectButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_shortcut_custom_set);
		imagebutton_gui_component_shortcut_ally_list = new ImageButton(this.leftPos + -212, this.topPos + -72, 21, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_ally_list.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_ally_list_hovered.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_shortcut_ally_list);
		imagebutton_gui_component_shortcut_basic_spell = new ImageButton(this.leftPos + -212, this.topPos + -60, 21, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_basic_spells.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_basic_spells_hovered.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_shortcut_basic_spell);
		imagebutton_gui_component_shortcut_spell_contr = new ImageButton(this.leftPos + -212, this.topPos + -48, 21, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_spell_control.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_spell_control_hovered.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_shortcut_spell_contr);
		imagebutton_gui_component_log_type_set = new ImageButton(this.leftPos + 6, this.topPos + 110, 7, 7,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_log_type_set.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_log_type_set_hovered.png")), e -> {
					int x = GUIAdvanceSpellSelectScreen.this.x;
					int y = GUIAdvanceSpellSelectScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIAdvanceSpellSelectButtonMessage(13, x, y, z));
						GUIAdvanceSpellSelectButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_log_type_set);
		imagebutton_gui_component_compass_custom_set = new ImageButton(this.leftPos + -164, this.topPos + 112, 3, 3,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_compass_custom_set.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_compass_custom_set_hovered.png")), e -> {
					int x = GUIAdvanceSpellSelectScreen.this.x;
					int y = GUIAdvanceSpellSelectScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIAdvanceSpellSelectButtonMessage(14, x, y, z));
						GUIAdvanceSpellSelectButtonMessage.handleButtonAction(entity, 14, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_compass_custom_set);
		imagebutton_icon_spell_sword_manipulation = new ImageButton(this.leftPos + -180, this.topPos + -84, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_sword_manipulation.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_sword_manipulation.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_spell_sword_manipulation);
		imagebutton_icon_advance_spell4 = new ImageButton(this.leftPos + -180, this.topPos + -104, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell4.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell4.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_advance_spell4);
		imagebutton_gui_component_line = new ImageButton(this.leftPos + -180, this.topPos + -68, 168, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_line.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_line.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_line);
	}
}