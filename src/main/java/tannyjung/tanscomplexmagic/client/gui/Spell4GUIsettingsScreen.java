package tannyjung.tanscomplexmagic.client.gui;

import tannyjung.tanscomplexmagic.world.inventory.Spell4GUIsettingsMenu;
import tannyjung.tanscomplexmagic.procedures.*;
import tannyjung.tanscomplexmagic.network.Spell4GUIsettingsButtonMessage;
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

public class Spell4GUIsettingsScreen extends AbstractContainerScreen<Spell4GUIsettingsMenu> implements TanscomplexmagicModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_symbol_checkbox;
	private ImageButton imagebutton_symbol_checkbox1;
	private ImageButton imagebutton_symbol_checkbox2;
	private ImageButton imagebutton_symbol_checkbox3;
	private ImageButton imagebutton_symbol_checkbox4;
	private ImageButton imagebutton_symbol_checkbox5;
	private ImageButton imagebutton_symbol_checkbox6;
	private ImageButton imagebutton_symbol_true;
	private ImageButton imagebutton_symbol_true1;
	private ImageButton imagebutton_symbol_true2;
	private ImageButton imagebutton_symbol_true3;
	private ImageButton imagebutton_symbol_true4;
	private ImageButton imagebutton_symbol_true5;
	private ImageButton imagebutton_symbol_true6;
	private ImageButton imagebutton_symbol_exit;
	private ImageButton imagebutton_symbol_help;
	private ImageButton imagebutton_symbol_help1;
	private ImageButton imagebutton_symbol_help2;
	private ImageButton imagebutton_symbol_help3;
	private ImageButton imagebutton_symbol_help4;
	private ImageButton imagebutton_symbol_help5;
	private ImageButton imagebutton_symbol_help6;
	private ImageButton imagebutton_symbol_help7;
	private ImageButton imagebutton_symbol_help8;
	private ImageButton imagebutton_symbol_help9;
	private ImageButton imagebutton_symbol_help11;
	private ImageButton imagebutton_symbol_help12;
	private ImageButton imagebutton_icon_home;
	private ImageButton imagebutton_symbol_line_2s;
	private ImageButton imagebutton_symbol_line_2s1;
	private ImageButton imagebutton_symbol_line_2s2;
	private ImageButton imagebutton_symbol_line_2s3;
	private ImageButton imagebutton_symbol_line_2s4;
	private ImageButton imagebutton_symbol_previous;
	private ImageButton imagebutton_symbol_next;
	private ImageButton imagebutton_symbol_set_cycle;
	private ImageButton imagebutton_symbol_set_cycle1;
	private ImageButton imagebutton_symbol_set_cycle2;
	private ImageButton imagebutton_symbol_set_cycle3;
	private ImageButton imagebutton_symbol_set_cycle4;
	private ImageButton imagebutton_symbol_set_cycle5;
	private ImageButton imagebutton_background_text_red;
	private ImageButton imagebutton_background_text_orange;
	private ImageButton imagebutton_background_text_orange1;
	private ImageButton imagebutton_symbol_line_2s5;
	private ImageButton imagebutton_symbol_set_cycle6;
	private ImageButton imagebutton_symbol_help10;
	private ImageButton imagebutton_symbol_checkbox7;
	private ImageButton imagebutton_symbol_true7;
	private ImageButton imagebutton_symbol_help13;

	public Spell4GUIsettingsScreen(Spell4GUIsettingsMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("tanscomplexmagic:textures/screens/spell_4_gu_isettings.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + -16 && mouseX < leftPos + -8 && mouseY > topPos + -68 && mouseY < topPos + -60) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_click_one_time_to_shoot_and_clic"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -16 && mouseX < leftPos + -8 && mouseY > topPos + -56 && mouseY < topPos + -48) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_click_one_time_to_reverse_and_cl"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -16 && mouseX < leftPos + -8 && mouseY > topPos + -44 && mouseY < topPos + -36) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_make_weapons_follow_you"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -16 && mouseX < leftPos + -8 && mouseY > topPos + 4 && mouseY < topPos + 12) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_distance_from_target_that_weapon"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -16 && mouseX < leftPos + -8 && mouseY > topPos + 28 && mouseY < topPos + 36) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_distance_from_target_that_weapon1"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -16 && mouseX < leftPos + -8 && mouseY > topPos + 52 && mouseY < topPos + 60) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_speed_of_weapons_in_distancing_e"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -16 && mouseX < leftPos + -8 && mouseY > topPos + -20 && mouseY < topPos + -12) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_set_how_fast_of_auto_shot_mode"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 136 && mouseX < leftPos + 144 && mouseY > topPos + -68 && mouseY < topPos + -60) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_show_overlay_when_the_spell_is_a"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 136 && mouseX < leftPos + 144 && mouseY > topPos + -56 && mouseY < topPos + -48) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_enable_target_arrow_that_make_ai"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 136 && mouseX < leftPos + 144 && mouseY > topPos + -16 && mouseY < topPos + -8) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_weapon_will_flying_around_the_ma"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 136 && mouseX < leftPos + 144 && mouseY > topPos + 56 && mouseY < topPos + 64) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_make_weapons_fly_down_slowly_whe"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 136 && mouseX < leftPos + 144 && mouseY > topPos + -4 && mouseY < topPos + 4) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_the_radius_of_weapon_circle_when"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 136 && mouseX < leftPos + 144 && mouseY > topPos + 20 && mouseY < topPos + 28) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_make_weapon_flying_with_rotation"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 136 && mouseX < leftPos + 144 && mouseY > topPos + 44 && mouseY < topPos + 52) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.tooltip_make_weapons_flying_with_balance"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (!customTooltipShown)
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
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_lock_shoot"), -132, -68, -12698050, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_lock_reverse"), -132, -56, -12698050, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_follow"), -132, -44, -12698050, false);
		guiGraphics.drawString(this.font, Spell4GUIreturnGuardPoseProcedure.execute(entity), -132, -32, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_distancing"), -132, 4, -12698050, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_distancing_out"), -132, 28, -12698050, false);
		guiGraphics.drawString(this.font, Spell4GUIreturnDistancingInProcedure.execute(entity), -132, 16, -6710887, false);
		guiGraphics.drawString(this.font, Spell4GUIreturnDistancingOutProcedure.execute(entity), -132, 40, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_distancing_speed"), -132, 52, -12698050, false);
		guiGraphics.drawString(this.font, Spell4GUIreturnDistancingSpeedProcedure.execute(entity), -132, 64, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_auto_shot_cooldown"), -132, -20, -12698050, false);
		guiGraphics.drawString(this.font, Spell4GUIreturnAutoShotCooldownProcedure.execute(entity), -132, -8, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_display_setting"), 60, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_overlay"), 20, -68, -12698050, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_target_arrow"), 20, -56, -12698050, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_spell_inactive_setting"), 40, -36, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_at_mark"), 20, -16, -12698050, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_gravity"), 20, 56, -12698050, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_boundary"), 20, -4, -12698050, false);
		guiGraphics.drawString(this.font, Spell4GUIreturnBoundaryProcedure.execute(entity), 20, 8, -6710887, false);
		guiGraphics.drawString(this.font, GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font, GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_setting"), -100, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_rotation"), 20, 20, -12829636, false);
		guiGraphics.drawString(this.font, Spell4GUIreturnPauseRotationProcedure.execute(entity), 20, 32, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_isettings.label_balance"), 20, 44, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_checkbox = new ImageButton(this.leftPos + 8, this.topPos + -68, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(0, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_checkbox);
		imagebutton_symbol_checkbox1 = new ImageButton(this.leftPos + 8, this.topPos + -56, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(1, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_checkbox1);
		imagebutton_symbol_checkbox2 = new ImageButton(this.leftPos + 8, this.topPos + -16, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(2, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_checkbox2);
		imagebutton_symbol_checkbox3 = new ImageButton(this.leftPos + 8, this.topPos + 56, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(3, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_checkbox3);
		imagebutton_symbol_checkbox4 = new ImageButton(this.leftPos + -144, this.topPos + -68, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(4, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_checkbox4);
		imagebutton_symbol_checkbox5 = new ImageButton(this.leftPos + -144, this.topPos + -56, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(5, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_checkbox5);
		imagebutton_symbol_checkbox6 = new ImageButton(this.leftPos + -144, this.topPos + -44, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(6, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_checkbox6);
		imagebutton_symbol_true = new ImageButton(this.leftPos + 8, this.topPos + -68, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = Spell4GUIsettingsScreen.this.x;
				int y = Spell4GUIsettingsScreen.this.y;
				if (Spell4GUIreturnShowOverlayTrueProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_true);
		imagebutton_symbol_true1 = new ImageButton(this.leftPos + 8, this.topPos + -56, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = Spell4GUIsettingsScreen.this.x;
				int y = Spell4GUIsettingsScreen.this.y;
				if (Spell4GUIreturnShowTargetArrowTrueProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_true1);
		imagebutton_symbol_true2 = new ImageButton(this.leftPos + 8, this.topPos + -16, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = Spell4GUIsettingsScreen.this.x;
				int y = Spell4GUIsettingsScreen.this.y;
				if (Spell4GUIreturnPauseAtMarkTrueProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_true2);
		imagebutton_symbol_true3 = new ImageButton(this.leftPos + 8, this.topPos + 56, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = Spell4GUIsettingsScreen.this.x;
				int y = Spell4GUIsettingsScreen.this.y;
				if (Spell4GUIreturnPauseGravityTrueProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_true3);
		imagebutton_symbol_true4 = new ImageButton(this.leftPos + -144, this.topPos + -68, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = Spell4GUIsettingsScreen.this.x;
				int y = Spell4GUIsettingsScreen.this.y;
				if (Spell4GUIreturnLockShootTrueProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_true4);
		imagebutton_symbol_true5 = new ImageButton(this.leftPos + -144, this.topPos + -56, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = Spell4GUIsettingsScreen.this.x;
				int y = Spell4GUIsettingsScreen.this.y;
				if (Spell4GUIreturnLockReverseTrueProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_true5);
		imagebutton_symbol_true6 = new ImageButton(this.leftPos + -144, this.topPos + -44, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = Spell4GUIsettingsScreen.this.x;
				int y = Spell4GUIsettingsScreen.this.y;
				if (Spell4GUIreturnGuardPoseTrueProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_true6);
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(14, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 14, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_symbol_help = new ImageButton(this.leftPos + 136, this.topPos + -68, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help);
		imagebutton_symbol_help1 = new ImageButton(this.leftPos + 136, this.topPos + -56, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help1);
		imagebutton_symbol_help2 = new ImageButton(this.leftPos + 136, this.topPos + -16, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help2);
		imagebutton_symbol_help3 = new ImageButton(this.leftPos + 136, this.topPos + 56, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help3);
		imagebutton_symbol_help4 = new ImageButton(this.leftPos + 136, this.topPos + -4, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help4);
		imagebutton_symbol_help5 = new ImageButton(this.leftPos + -16, this.topPos + -44, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help5);
		imagebutton_symbol_help6 = new ImageButton(this.leftPos + -16, this.topPos + -20, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help6);
		imagebutton_symbol_help7 = new ImageButton(this.leftPos + -16, this.topPos + -68, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help7);
		imagebutton_symbol_help8 = new ImageButton(this.leftPos + -16, this.topPos + -56, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help8);
		imagebutton_symbol_help9 = new ImageButton(this.leftPos + -16, this.topPos + 52, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help9);
		imagebutton_symbol_help11 = new ImageButton(this.leftPos + -16, this.topPos + 28, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help11);
		imagebutton_symbol_help12 = new ImageButton(this.leftPos + -16, this.topPos + 4, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help12);
		imagebutton_icon_home = new ImageButton(this.leftPos + -172, this.topPos + -96, 22, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_home.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_home_2s.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(27, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 27, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_line_2s = new ImageButton(this.leftPos + 8, this.topPos + -4, 8, 12,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_line_2s);
		imagebutton_symbol_line_2s1 = new ImageButton(this.leftPos + -144, this.topPos + -20, 8, 12,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_line_2s1);
		imagebutton_symbol_line_2s2 = new ImageButton(this.leftPos + -144, this.topPos + 4, 8, 12,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_line_2s2);
		imagebutton_symbol_line_2s3 = new ImageButton(this.leftPos + -144, this.topPos + 28, 8, 12,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_line_2s3);
		imagebutton_symbol_line_2s4 = new ImageButton(this.leftPos + -144, this.topPos + 52, 8, 12,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_line_2s4);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_previous.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_previous.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(33, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 33, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_next.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_next.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(34, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 34, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_symbol_set_cycle = new ImageButton(this.leftPos + 8, this.topPos + 8, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(35, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 35, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_set_cycle);
		imagebutton_symbol_set_cycle1 = new ImageButton(this.leftPos + -144, this.topPos + -32, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(36, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 36, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_set_cycle1);
		imagebutton_symbol_set_cycle2 = new ImageButton(this.leftPos + -144, this.topPos + -8, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(37, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 37, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_set_cycle2);
		imagebutton_symbol_set_cycle3 = new ImageButton(this.leftPos + -144, this.topPos + 16, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(38, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 38, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_set_cycle3);
		imagebutton_symbol_set_cycle4 = new ImageButton(this.leftPos + -144, this.topPos + 40, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(39, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 39, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_set_cycle4);
		imagebutton_symbol_set_cycle5 = new ImageButton(this.leftPos + -144, this.topPos + 64, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(40, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 40, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_set_cycle5);
		imagebutton_background_text_red = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_red.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_red.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_red);
		imagebutton_background_text_orange = new ImageButton(this.leftPos + 8, this.topPos + -92, 136, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_orange.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_orange.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_orange);
		imagebutton_background_text_orange1 = new ImageButton(this.leftPos + 8, this.topPos + -40, 136, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_orange.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_orange.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_orange1);
		imagebutton_symbol_line_2s5 = new ImageButton(this.leftPos + 8, this.topPos + 20, 8, 12,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_line_2s5);
		imagebutton_symbol_set_cycle6 = new ImageButton(this.leftPos + 8, this.topPos + 32, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_set_cycle.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(45, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 45, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_set_cycle6);
		imagebutton_symbol_help10 = new ImageButton(this.leftPos + 136, this.topPos + 20, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help10);
		imagebutton_symbol_checkbox7 = new ImageButton(this.leftPos + 8, this.topPos + 44, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_checkbox.png")), e -> {
					int x = Spell4GUIsettingsScreen.this.x;
					int y = Spell4GUIsettingsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIsettingsButtonMessage(47, x, y, z));
						Spell4GUIsettingsButtonMessage.handleButtonAction(entity, 47, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_checkbox7);
		imagebutton_symbol_true7 = new ImageButton(this.leftPos + 8, this.topPos + 44, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_true.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = Spell4GUIsettingsScreen.this.x;
				int y = Spell4GUIsettingsScreen.this.y;
				if (Spell4GUIreturnPauseBalancingTrueProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_true7);
		imagebutton_symbol_help13 = new ImageButton(this.leftPos + 136, this.topPos + 44, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help13);
	}
}