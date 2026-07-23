package tannyjung.tanscomplexmagic.client.gui;

import tannyjung.tanscomplexmagic.world.inventory.Spell4GUIdetailsMenu;
import tannyjung.tanscomplexmagic.procedures.GUIreturnPageRightProcedure;
import tannyjung.tanscomplexmagic.procedures.GUIreturnPageLeftProcedure;
import tannyjung.tanscomplexmagic.procedures.GUIreturnManaProcedure;
import tannyjung.tanscomplexmagic.network.Spell4GUIdetailsButtonMessage;
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

public class Spell4GUIdetailsScreen extends AbstractContainerScreen<Spell4GUIdetailsMenu> implements TanscomplexmagicModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_symbol_exit;
	private ImageButton imagebutton_icon_home;
	private ImageButton imagebutton_symbol_next;
	private ImageButton imagebutton_symbol_previous;
	private ImageButton imagebutton_symbol_tip;
	private ImageButton imagebutton_symbol_tip1;
	private ImageButton imagebutton_symbol_line1;
	private ImageButton imagebutton_symbol_help;
	private ImageButton imagebutton_background_text_green;
	private ImageButton imagebutton_background_text_green1;

	public Spell4GUIdetailsScreen(Spell4GUIdetailsMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("tanscomplexmagic:textures/screens/spell_4_gu_idetails.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 136 && mouseX < leftPos + 144 && mouseY > topPos + -56 && mouseY < topPos + -48) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.tooltip_you_can_change_to_left_click_i"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 136 && mouseX < leftPos + 144 && mouseY > topPos + -44 && mouseY < topPos + -36) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.tooltip_you_can_change_to_right_click"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -16 && mouseX < leftPos + -8 && mouseY > topPos + 40 && mouseY < topPos + 48) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.tooltip_soe_spell_cant_work_well_when_t"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_index"), 32, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_00"), 8, -68, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_setting"), 48, -68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_001"), 8, -56, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_weapon_manipulation"), 48, -32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_shield_manipulation"), 48, -20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_lantern_manupulation"), 48, -8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_bow_manipulation"), 48, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_002"), 8, -44, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_003"), 8, -32, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_004"), 8, -20, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_skill"), 48, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_lock_target"), 48, 28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_constant"), 48, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_homing"), 48, 52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_shoot"), 48, -56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_reverse"), 48, -44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_a"), 8, -8, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_a1"), 8, 4, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_a2"), 8, 16, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_a3"), 8, 28, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_a4"), 8, 40, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_a5"), 8, 52, -6710887, false);
		guiGraphics.drawString(this.font, GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font, GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_details"), -96, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_complexity"), -144, -20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_difficulty"), -144, -44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_fast_travel"), -144, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_high"), -144, -8, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_hard"), -144, -32, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_not_support"), -144, 16, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_teleport"), -144, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_not_support1"), -144, 52, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_main_type"), -144, -68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_idetails.label_combat"), -144, -56, -6710887, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png")), e -> {
					int x = Spell4GUIdetailsScreen.this.x;
					int y = Spell4GUIdetailsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIdetailsButtonMessage(0, x, y, z));
						Spell4GUIdetailsButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_icon_home = new ImageButton(this.leftPos + -172, this.topPos + -96, 22, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_home.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_home_2s.png")), e -> {
					int x = Spell4GUIdetailsScreen.this.x;
					int y = Spell4GUIdetailsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIdetailsButtonMessage(1, x, y, z));
						Spell4GUIdetailsButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_next.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_next.png")), e -> {
					int x = Spell4GUIdetailsScreen.this.x;
					int y = Spell4GUIdetailsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIdetailsButtonMessage(2, x, y, z));
						Spell4GUIdetailsButtonMessage.handleButtonAction(entity, 2, x, y, z);
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
					int x = Spell4GUIdetailsScreen.this.x;
					int y = Spell4GUIdetailsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIdetailsButtonMessage(3, x, y, z));
						Spell4GUIdetailsButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_symbol_tip = new ImageButton(this.leftPos + 136, this.topPos + -56, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_tip.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_tip.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_tip);
		imagebutton_symbol_tip1 = new ImageButton(this.leftPos + 136, this.topPos + -44, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_tip.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_tip.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_tip1);
		imagebutton_symbol_line1 = new ImageButton(this.leftPos + -144, this.topPos + 24, 168, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_line1);
		imagebutton_symbol_help = new ImageButton(this.leftPos + -16, this.topPos + 40, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help);
		imagebutton_background_text_green = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_green.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_green.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_green);
		imagebutton_background_text_green1 = new ImageButton(this.leftPos + 8, this.topPos + -92, 136, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_green.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_green.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_green1);
	}
}