package tannyjung.lanternofthewoodlands.client.gui;

import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIMenu;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageRightProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageLeftProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnManaProcedure;
import tannyjung.lanternofthewoodlands.network.Spell4GUIButtonMessage;
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

public class Spell4GUIScreen extends AbstractContainerScreen<Spell4GUIMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = Spell4GUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_symbol_exit;
	ImageButton imagebutton_icon_home;
	ImageButton imagebutton_symbol_next;
	ImageButton imagebutton_symbol_previous;
	ImageButton imagebutton_background_icon;
	ImageButton imagebutton_image_tape;
	ImageButton imagebutton_image_tape_2s;
	ImageButton imagebutton_icon_advance_spell4;
	ImageButton imagebutton_background_text_purple;

	public Spell4GUIScreen(Spell4GUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lanternofthewoodlands:textures/screens/spell_4_gui.png");

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

		guiGraphics.blit(new ResourceLocation("lanternofthewoodlands:textures/screens/background_book.png"), this.leftPos + -160, this.topPos + -104, 0, 0, 400, 240, 400, 240);

		guiGraphics.blit(new ResourceLocation("lanternofthewoodlands:textures/screens/image_spell4.png"), this.leftPos + 16, this.topPos + -80, 0, 0, 120, 144, 120, 144);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gui.label_the_spell_of_astrology"), -136, -28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gui.label_use_all_13_zodiac_cards"), -144, -16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gui.label_goods_and_bad_effects"), -144, -4, -12829636, false);
		guiGraphics.drawString(this.font,

				GUIreturnManaProcedure.execute(entity), -160, -116, -10066330, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gui.label_skills"), -144, 8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gui.label_autumn_of_loss"), -116, -88, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_exit.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIButtonMessage(0, x, y, z, textstate));
				Spell4GUIButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_exit", imagebutton_symbol_exit);
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_icon_home = new ImageButton(this.leftPos + -172, this.topPos + -96, 22, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_home.png"), 22, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIButtonMessage(1, x, y, z, textstate));
				Spell4GUIButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_icon_home", imagebutton_icon_home);
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_next.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIButtonMessage(2, x, y, z, textstate));
				Spell4GUIButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_next", imagebutton_symbol_next);
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_previous.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIButtonMessage(3, x, y, z, textstate));
				Spell4GUIButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_previous", imagebutton_symbol_previous);
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_background_icon = new ImageButton(this.leftPos + -88, this.topPos + -64, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_icon.png"), 24, 48, e -> {
		});
		guistate.put("button:imagebutton_background_icon", imagebutton_background_icon);
		this.addRenderableWidget(imagebutton_background_icon);
		imagebutton_image_tape = new ImageButton(this.leftPos + 8, this.topPos + -88, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_image_tape.png"), 24, 48, e -> {
		});
		guistate.put("button:imagebutton_image_tape", imagebutton_image_tape);
		this.addRenderableWidget(imagebutton_image_tape);
		imagebutton_image_tape_2s = new ImageButton(this.leftPos + 120, this.topPos + 48, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_image_tape_2s.png"), 24, 48, e -> {
		});
		guistate.put("button:imagebutton_image_tape_2s", imagebutton_image_tape_2s);
		this.addRenderableWidget(imagebutton_image_tape_2s);
		imagebutton_icon_advance_spell4 = new ImageButton(this.leftPos + -84, this.topPos + -60, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_advance_spell4.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_advance_spell4", imagebutton_icon_advance_spell4);
		this.addRenderableWidget(imagebutton_icon_advance_spell4);
		imagebutton_background_text_purple = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_purple.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_purple", imagebutton_background_text_purple);
		this.addRenderableWidget(imagebutton_background_text_purple);
	}
}
