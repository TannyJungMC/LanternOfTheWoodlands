package tannyjung.lanternofthewoodlands.client.gui;

import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIweaponKnightSwordMenu;
import tannyjung.lanternofthewoodlands.procedures.Spell4GUIreturnKnightSwordCountProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageRightProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageLeftProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnManaProcedure;
import tannyjung.lanternofthewoodlands.network.Spell4GUIweaponKnightSwordButtonMessage;
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

public class Spell4GUIweaponKnightSwordScreen extends AbstractContainerScreen<Spell4GUIweaponKnightSwordMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = Spell4GUIweaponKnightSwordMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_symbol_exit;
	ImageButton imagebutton_icon_home;
	ImageButton imagebutton_symbol_previous;
	ImageButton imagebutton_symbol_next;
	ImageButton imagebutton_symbol_add;
	ImageButton imagebutton_symbol_remove;
	ImageButton imagebutton_symbol_line_2s1;
	ImageButton imagebutton_symbol_upgrade2;
	ImageButton imagebutton_symbol_line1;
	ImageButton imagebutton_background_text_red;
	ImageButton imagebutton_background_text_blue;
	ImageButton imagebutton_symbol_line_5s;
	ImageButton imagebutton_background_icon;
	ImageButton imagebutton_icon_spell_knight_sword;

	public Spell4GUIweaponKnightSwordScreen(Spell4GUIweaponKnightSwordMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lanternofthewoodlands:textures/screens/spell_4_gu_iweapon_knight_sword.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -132 && mouseX < leftPos + -124 && mouseY > topPos + 52 && mouseY < topPos + 60)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.tooltip_activate_weapons_on_ground_near1"), mouseX, mouseY);
		if (mouseX > leftPos + -120 && mouseX < leftPos + -112 && mouseY > topPos + 52 && mouseY < topPos + 60)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.tooltip_remove_all_active_weapon_in_this"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_false_divination"), -112, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_the_spell_of_astrology"), -136, -28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_use_all_13_zodiac_cards"), -144, -16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_goods_and_bad_effects"), -144, -4, -12829636, false);
		guiGraphics.drawString(this.font,

				GUIreturnManaProcedure.execute(entity), -160, -116, -10066330, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font,

				Spell4GUIreturnKnightSwordCountProcedure.execute(entity), -132, 64, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_level"), 20, -68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_upgrades"), 56, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_awdedae"), 20, -56, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_duration"), 8, -8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_damage"), 8, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_999"), 8, 4, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_radius"), 8, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_2"), 8, 28, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_cooldown"), 8, -32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_0s"), 8, -20, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_1"), 8, 52, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_5_when_constant_is_on"), 8, 64, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_and_dont_have_any_special"), -144, 8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_iweapon_knight_sword.label_ability"), -144, 20, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_exit.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponKnightSwordButtonMessage(0, x, y, z, textstate));
				Spell4GUIweaponKnightSwordButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_exit", imagebutton_symbol_exit);
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_icon_home = new ImageButton(this.leftPos + -172, this.topPos + -96, 22, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_home.png"), 22, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponKnightSwordButtonMessage(1, x, y, z, textstate));
				Spell4GUIweaponKnightSwordButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_icon_home", imagebutton_icon_home);
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_previous.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponKnightSwordButtonMessage(2, x, y, z, textstate));
				Spell4GUIweaponKnightSwordButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_previous", imagebutton_symbol_previous);
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_next.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponKnightSwordButtonMessage(3, x, y, z, textstate));
				Spell4GUIweaponKnightSwordButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_next", imagebutton_symbol_next);
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_symbol_add = new ImageButton(this.leftPos + -132, this.topPos + 52, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_add.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponKnightSwordButtonMessage(4, x, y, z, textstate));
				Spell4GUIweaponKnightSwordButtonMessage.handleButtonAction(entity, 4, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_add", imagebutton_symbol_add);
		this.addRenderableWidget(imagebutton_symbol_add);
		imagebutton_symbol_remove = new ImageButton(this.leftPos + -120, this.topPos + 52, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_remove.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIweaponKnightSwordButtonMessage(5, x, y, z, textstate));
				Spell4GUIweaponKnightSwordButtonMessage.handleButtonAction(entity, 5, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_remove", imagebutton_symbol_remove);
		this.addRenderableWidget(imagebutton_symbol_remove);
		imagebutton_symbol_line_2s1 = new ImageButton(this.leftPos + 8, this.topPos + -68, 8, 12, 0, 0, 12, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_line_2s1.png"), 8, 24, e -> {
		});
		guistate.put("button:imagebutton_symbol_line_2s1", imagebutton_symbol_line_2s1);
		this.addRenderableWidget(imagebutton_symbol_line_2s1);
		imagebutton_symbol_upgrade2 = new ImageButton(this.leftPos + 8, this.topPos + -56, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_upgrade2.png"), 8, 16, e -> {
		});
		guistate.put("button:imagebutton_symbol_upgrade2", imagebutton_symbol_upgrade2);
		this.addRenderableWidget(imagebutton_symbol_upgrade2);
		imagebutton_symbol_line1 = new ImageButton(this.leftPos + 8, this.topPos + -48, 168, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_line1.png"), 168, 16, e -> {
		});
		guistate.put("button:imagebutton_symbol_line1", imagebutton_symbol_line1);
		this.addRenderableWidget(imagebutton_symbol_line1);
		imagebutton_background_text_red = new ImageButton(this.leftPos + 8, this.topPos + -92, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_red.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_red", imagebutton_background_text_red);
		this.addRenderableWidget(imagebutton_background_text_red);
		imagebutton_background_text_blue = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_blue.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_blue", imagebutton_background_text_blue);
		this.addRenderableWidget(imagebutton_background_text_blue);
		imagebutton_symbol_line_5s = new ImageButton(this.leftPos + -144, this.topPos + 52, 8, 20, 0, 0, 20, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_line_5s.png"), 8, 40, e -> {
		});
		guistate.put("button:imagebutton_symbol_line_5s", imagebutton_symbol_line_5s);
		this.addRenderableWidget(imagebutton_symbol_line_5s);
		imagebutton_background_icon = new ImageButton(this.leftPos + -88, this.topPos + -64, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_icon.png"), 24, 48, e -> {
		});
		guistate.put("button:imagebutton_background_icon", imagebutton_background_icon);
		this.addRenderableWidget(imagebutton_background_icon);
		imagebutton_icon_spell_knight_sword = new ImageButton(this.leftPos + -84, this.topPos + -60, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_spell_knight_sword.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_spell_knight_sword", imagebutton_icon_spell_knight_sword);
		this.addRenderableWidget(imagebutton_icon_spell_knight_sword);
	}
}
