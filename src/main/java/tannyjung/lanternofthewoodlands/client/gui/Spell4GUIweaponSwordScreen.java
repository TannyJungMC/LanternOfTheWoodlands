package tannyjung.lanternofthewoodlands.client.gui;

import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIweaponSwordMenu;
import tannyjung.lanternofthewoodlands.procedures.Spell4GUIreturnSwordStatusProcedure;
import tannyjung.lanternofthewoodlands.procedures.Spell4GUIreturnSwordLevelProcedure;
import tannyjung.lanternofthewoodlands.procedures.Spell4GUIreturnSwordCountProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageRightProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageLeftProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnManaProcedure;
import tannyjung.lanternofthewoodlands.network.Spell4GUIweaponSwordButtonMessage;
import tannyjung.lanternofthewoodlands.init.LanternofthewoodlandsModScreens.WidgetScreen;
import tannyjung.lanternofthewoodlands.LanternofthewoodlandsMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class Spell4GUIweaponSwordScreen extends AbstractContainerScreen<Spell4GUIweaponSwordMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = Spell4GUIweaponSwordMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_symbol_exit;
	ImageButton imagebutton_icon_home;
	ImageButton imagebutton_symbol_previous;
	ImageButton imagebutton_symbol_next;
	ImageButton imagebutton_icon_spell_sword_manipulation;
	ImageButton imagebutton_background_icon;
	ImageButton imagebutton_symbol_add;
	ImageButton imagebutton_symbol_remove;
	ImageButton imagebutton_symbol_upgrade;
	ImageButton imagebutton_symbol_line_2s1;
	ImageButton imagebutton_symbol_upgrade2;
	ImageButton imagebutton_symbol_line1;
	ImageButton imagebutton_background_icon1;
	ImageButton imagebutton_icon_spell_hidden_objects;
	ImageButton imagebutton_background_text_red;
	ImageButton imagebutton_background_text_blue_2s;
	ImageButton imagebutton_symbol_line_5s;

	public Spell4GUIweaponSwordScreen(Spell4GUIweaponSwordMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lanternofthewoodlands:textures/screens/spell_4_gu_iweapon_sword.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -132 && mouseX < leftPos + -124 && mouseY > topPos + 52 && mouseY < topPos + 60)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.tooltip_activate_weapons_on_ground_near1"), mouseX, mouseY);
		if (mouseX > leftPos + -120 && mouseX < leftPos + -112 && mouseY > topPos + 52 && mouseY < topPos + 60)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.tooltip_remove_all_active_weapon_in_this"), mouseX, mouseY);
		if (mouseX > leftPos + -108 && mouseX < leftPos + -100 && mouseY > topPos + 52 && mouseY < topPos + 60)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.tooltip_1_count_max_10_mana"), mouseX, mouseY);
		if (mouseX > leftPos + -68 && mouseX < leftPos + -52 && mouseY > topPos + -48 && mouseY < topPos + -32)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.tooltip_hidden_objects_temporary_make"), mouseX, mouseY);
		if (mouseX > leftPos + 8 && mouseX < leftPos + 16 && mouseY > topPos + -56 && mouseY < topPos + -48)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.tooltip_1_level_30_mana"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("lanternofthewoodlands:textures/screens/background_book.png"), this.leftPos + -160, this.topPos + -104, 0, 0, 400, 240, 400, 240);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_false_divination"), -92, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_the_spell_of_astrology"), -136, -16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_use_all_13_zodiac_cards"), -144, -4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_goods_and_bad_effects"), -144, 8, -12829636, false);
		guiGraphics.drawString(this.font,

				GUIreturnManaProcedure.execute(entity), -160, -116, -10066330, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_supported"), -144, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_manipulation"), -108, -76, -1, false);
		guiGraphics.drawString(this.font,

				Spell4GUIreturnSwordCountProcedure.execute(entity), -132, 64, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_level"), 20, -68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_upgrades"), 56, -88, -1, false);
		guiGraphics.drawString(this.font,

				Spell4GUIreturnSwordLevelProcedure.execute(entity), 20, -56, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_cooldown"), 8, -32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_duration"), 8, -8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_damage"), 8, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_10s"), 8, -20, -6710887, false);
		guiGraphics.drawString(this.font,

				Spell4GUIreturnSwordStatusProcedure.execute(entity), 8, 4, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_999"), 8, 52, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_vanilla_swords"), -144, 32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_radius"), 8, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_2"), 8, 28, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_sword.label_1_2_3_4_5_10"), 8, 64, -6710887, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_exit.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponSwordButtonMessage(0, x, y, z, textstate));
				Spell4GUIweaponSwordButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_exit", imagebutton_symbol_exit);
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_icon_home = new ImageButton(this.leftPos + -172, this.topPos + -96, 22, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_home.png"), 22, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponSwordButtonMessage(1, x, y, z, textstate));
				Spell4GUIweaponSwordButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_icon_home", imagebutton_icon_home);
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_previous.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponSwordButtonMessage(2, x, y, z, textstate));
				Spell4GUIweaponSwordButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_previous", imagebutton_symbol_previous);
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_next.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponSwordButtonMessage(3, x, y, z, textstate));
				Spell4GUIweaponSwordButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_next", imagebutton_symbol_next);
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_icon_spell_sword_manipulation = new ImageButton(this.leftPos + -100, this.topPos + -48, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_spell_sword_manipulation.png"), 16, 32,
				e -> {
				});
		guistate.put("button:imagebutton_icon_spell_sword_manipulation", imagebutton_icon_spell_sword_manipulation);
		this.addRenderableWidget(imagebutton_icon_spell_sword_manipulation);
		imagebutton_background_icon = new ImageButton(this.leftPos + -104, this.topPos + -52, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_icon.png"), 24, 48, e -> {
		});
		guistate.put("button:imagebutton_background_icon", imagebutton_background_icon);
		this.addRenderableWidget(imagebutton_background_icon);
		imagebutton_symbol_add = new ImageButton(this.leftPos + -132, this.topPos + 52, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_add.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponSwordButtonMessage(6, x, y, z, textstate));
				Spell4GUIweaponSwordButtonMessage.handleButtonAction(entity, 6, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_add", imagebutton_symbol_add);
		this.addRenderableWidget(imagebutton_symbol_add);
		imagebutton_symbol_remove = new ImageButton(this.leftPos + -120, this.topPos + 52, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_remove.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponSwordButtonMessage(7, x, y, z, textstate));
				Spell4GUIweaponSwordButtonMessage.handleButtonAction(entity, 7, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_remove", imagebutton_symbol_remove);
		this.addRenderableWidget(imagebutton_symbol_remove);
		imagebutton_symbol_upgrade = new ImageButton(this.leftPos + -108, this.topPos + 52, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_upgrade.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponSwordButtonMessage(8, x, y, z, textstate));
				Spell4GUIweaponSwordButtonMessage.handleButtonAction(entity, 8, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_upgrade", imagebutton_symbol_upgrade);
		this.addRenderableWidget(imagebutton_symbol_upgrade);
		imagebutton_symbol_line_2s1 = new ImageButton(this.leftPos + 8, this.topPos + -68, 8, 12, 0, 0, 12, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_line_2s1.png"), 8, 24, e -> {
		});
		guistate.put("button:imagebutton_symbol_line_2s1", imagebutton_symbol_line_2s1);
		this.addRenderableWidget(imagebutton_symbol_line_2s1);
		imagebutton_symbol_upgrade2 = new ImageButton(this.leftPos + 8, this.topPos + -56, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_upgrade2.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponSwordButtonMessage(10, x, y, z, textstate));
				Spell4GUIweaponSwordButtonMessage.handleButtonAction(entity, 10, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_upgrade2", imagebutton_symbol_upgrade2);
		this.addRenderableWidget(imagebutton_symbol_upgrade2);
		imagebutton_symbol_line1 = new ImageButton(this.leftPos + 8, this.topPos + -48, 168, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_line1.png"), 168, 16, e -> {
		});
		guistate.put("button:imagebutton_symbol_line1", imagebutton_symbol_line1);
		this.addRenderableWidget(imagebutton_symbol_line1);
		imagebutton_background_icon1 = new ImageButton(this.leftPos + -72, this.topPos + -52, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_icon1.png"), 24, 48, e -> {
		});
		guistate.put("button:imagebutton_background_icon1", imagebutton_background_icon1);
		this.addRenderableWidget(imagebutton_background_icon1);
		imagebutton_icon_spell_hidden_objects = new ImageButton(this.leftPos + -68, this.topPos + -48, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_spell_hidden_objects.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_spell_hidden_objects", imagebutton_icon_spell_hidden_objects);
		this.addRenderableWidget(imagebutton_icon_spell_hidden_objects);
		imagebutton_background_text_red = new ImageButton(this.leftPos + 8, this.topPos + -92, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_red.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_red", imagebutton_background_text_red);
		this.addRenderableWidget(imagebutton_background_text_red);
		imagebutton_background_text_blue_2s = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 28, 0, 0, 28, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_blue_2s.png"), 136, 56, e -> {
		});
		guistate.put("button:imagebutton_background_text_blue_2s", imagebutton_background_text_blue_2s);
		this.addRenderableWidget(imagebutton_background_text_blue_2s);
		imagebutton_symbol_line_5s = new ImageButton(this.leftPos + -144, this.topPos + 52, 8, 20, 0, 0, 20, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_line_5s.png"), 8, 40, e -> {
		});
		guistate.put("button:imagebutton_symbol_line_5s", imagebutton_symbol_line_5s);
		this.addRenderableWidget(imagebutton_symbol_line_5s);
	}
}
