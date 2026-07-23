package tannyjung.tanscomplexmagic.client.gui;

import tannyjung.tanscomplexmagic.world.inventory.Spell4GUIweaponLanternMenu;
import tannyjung.tanscomplexmagic.procedures.*;
import tannyjung.tanscomplexmagic.network.Spell4GUIweaponLanternButtonMessage;
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

public class Spell4GUIweaponLanternScreen extends AbstractContainerScreen<Spell4GUIweaponLanternMenu> implements TanscomplexmagicModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_symbol_exit;
	private ImageButton imagebutton_icon_home;
	private ImageButton imagebutton_symbol_previous;
	private ImageButton imagebutton_symbol_next;
	private ImageButton imagebutton_background_icon;
	private ImageButton imagebutton_symbol_add;
	private ImageButton imagebutton_symbol_remove;
	private ImageButton imagebutton_symbol_upgrade;
	private ImageButton imagebutton_symbol_line_2s1;
	private ImageButton imagebutton_symbol_upgrade2;
	private ImageButton imagebutton_symbol_line1;
	private ImageButton imagebutton_background_icon1;
	private ImageButton imagebutton_icon_spell_lantern_manipulation;
	private ImageButton imagebutton_icon_spell_lantern_light;
	private ImageButton imagebutton_background_text_blue_2s;
	private ImageButton imagebutton_background_text_red;
	private ImageButton imagebutton_symbol_line_5s;

	public Spell4GUIweaponLanternScreen(Spell4GUIweaponLanternMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("tanscomplexmagic:textures/screens/spell_4_gu_iweapon_lantern.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + -132 && mouseX < leftPos + -124 && mouseY > topPos + 52 && mouseY < topPos + 60) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.tooltip_activate_weapons_on_ground_near1"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -120 && mouseX < leftPos + -112 && mouseY > topPos + 52 && mouseY < topPos + 60) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.tooltip_remove_all_active_weapon_in_this"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -108 && mouseX < leftPos + -100 && mouseY > topPos + 52 && mouseY < topPos + 60) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.tooltip_1_count_max_10_mana"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -68 && mouseX < leftPos + -52 && mouseY > topPos + -48 && mouseY < topPos + -32) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.tooltip_hidden_objects_temporary_make"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 8 && mouseX < leftPos + 16 && mouseY > topPos + -56 && mouseY < topPos + -48) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.tooltip_1_level_30_mana"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_false_divination"), -96, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_the_spell_of_astrology"), -136, -16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_use_all_13_zodiac_cards"), -144, -4, -12829636, false);
		guiGraphics.drawString(this.font, GUIreturnManaProcedure.execute(entity), -160, -116, -10066330, false);
		guiGraphics.drawString(this.font, GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font, GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_support_to_all_vanilla_sword_typ"), -144, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_supported"), -144, 8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_manipulation"), -108, -76, -1, false);
		guiGraphics.drawString(this.font, Spell4GUIreturnLanternCountProcedure.execute(entity), -132, 64, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_level"), 20, -68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_upgrades"), 56, -88, -1, false);
		guiGraphics.drawString(this.font, Spell4GUIreturnLanternLevelProcedure.execute(entity), 20, -56, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_cooldown"), 8, -32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_duration"), 8, -8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_damage"), 8, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_10s"), 8, -20, -6710887, false);
		guiGraphics.drawString(this.font, Spell4GUIreturnLanternStatusProcedure.execute(entity), 8, 52, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_999"), 8, 4, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_radius"), 8, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_2"), 8, 28, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gu_iweapon_lantern.label_lantern"), -144, 32, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png")), e -> {
					int x = Spell4GUIweaponLanternScreen.this.x;
					int y = Spell4GUIweaponLanternScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIweaponLanternButtonMessage(0, x, y, z));
						Spell4GUIweaponLanternButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
					int x = Spell4GUIweaponLanternScreen.this.x;
					int y = Spell4GUIweaponLanternScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIweaponLanternButtonMessage(1, x, y, z));
						Spell4GUIweaponLanternButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_previous.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_previous.png")), e -> {
					int x = Spell4GUIweaponLanternScreen.this.x;
					int y = Spell4GUIweaponLanternScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIweaponLanternButtonMessage(2, x, y, z));
						Spell4GUIweaponLanternButtonMessage.handleButtonAction(entity, 2, x, y, z);
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
					int x = Spell4GUIweaponLanternScreen.this.x;
					int y = Spell4GUIweaponLanternScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIweaponLanternButtonMessage(3, x, y, z));
						Spell4GUIweaponLanternButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_background_icon = new ImageButton(this.leftPos + -104, this.topPos + -52, 24, 24,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_icon.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_icon.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_icon);
		imagebutton_symbol_add = new ImageButton(this.leftPos + -132, this.topPos + 52, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_add.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_add.png")), e -> {
					int x = Spell4GUIweaponLanternScreen.this.x;
					int y = Spell4GUIweaponLanternScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIweaponLanternButtonMessage(5, x, y, z));
						Spell4GUIweaponLanternButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_add);
		imagebutton_symbol_remove = new ImageButton(this.leftPos + -120, this.topPos + 52, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_remove.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_remove.png")), e -> {
					int x = Spell4GUIweaponLanternScreen.this.x;
					int y = Spell4GUIweaponLanternScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIweaponLanternButtonMessage(6, x, y, z));
						Spell4GUIweaponLanternButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_remove);
		imagebutton_symbol_upgrade = new ImageButton(this.leftPos + -108, this.topPos + 52, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_upgrade.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_upgrade.png")), e -> {
					int x = Spell4GUIweaponLanternScreen.this.x;
					int y = Spell4GUIweaponLanternScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIweaponLanternButtonMessage(7, x, y, z));
						Spell4GUIweaponLanternButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_upgrade);
		imagebutton_symbol_line_2s1 = new ImageButton(this.leftPos + 8, this.topPos + -68, 8, 12,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_line_2s1);
		imagebutton_symbol_upgrade2 = new ImageButton(this.leftPos + 8, this.topPos + -56, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_upgrade.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_upgrade.png")), e -> {
					int x = Spell4GUIweaponLanternScreen.this.x;
					int y = Spell4GUIweaponLanternScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUIweaponLanternButtonMessage(9, x, y, z));
						Spell4GUIweaponLanternButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_upgrade2);
		imagebutton_symbol_line1 = new ImageButton(this.leftPos + 8, this.topPos + -48, 168, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_line1);
		imagebutton_background_icon1 = new ImageButton(this.leftPos + -72, this.topPos + -52, 24, 24,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_icon.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_icon.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_icon1);
		imagebutton_icon_spell_lantern_manipulation = new ImageButton(this.leftPos + -100, this.topPos + -48, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_lantern_manipulation.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_lantern_manipulation.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_spell_lantern_manipulation);
		imagebutton_icon_spell_lantern_light = new ImageButton(this.leftPos + -68, this.topPos + -48, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_lantern_light.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_lantern_light.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_spell_lantern_light);
		imagebutton_background_text_blue_2s = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 28,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_blue_2s.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_blue_2s.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_blue_2s);
		imagebutton_background_text_red = new ImageButton(this.leftPos + 8, this.topPos + -92, 136, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_red.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_red.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_red);
		imagebutton_symbol_line_5s = new ImageButton(this.leftPos + -144, this.topPos + 52, 8, 20,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_5s.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_5s.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_line_5s);
	}
}