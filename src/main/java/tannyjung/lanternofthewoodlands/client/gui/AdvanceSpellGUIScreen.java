package tannyjung.lanternofthewoodlands.client.gui;

import tannyjung.lanternofthewoodlands.world.inventory.AdvanceSpellGUIMenu;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageRightProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageLeftProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnManaProcedure;
import tannyjung.lanternofthewoodlands.network.AdvanceSpellGUIButtonMessage;
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

public class AdvanceSpellGUIScreen extends AbstractContainerScreen<AdvanceSpellGUIMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = AdvanceSpellGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_symbol_exit;
	ImageButton imagebutton_icon_home;
	ImageButton imagebutton_symbol_next;
	ImageButton imagebutton_symbol_previous;
	ImageButton imagebutton_background_icon;
	ImageButton imagebutton_icon_advance_spell;
	ImageButton imagebutton_symbol_line;
	ImageButton imagebutton_background_text_dark_gray;
	ImageButton imagebutton_background_text_purple;
	ImageButton imagebutton_icon_advance_spell1;
	ImageButton imagebutton_icon_advance_spell2;
	ImageButton imagebutton_icon_advance_spell3;
	ImageButton imagebutton_icon_advance_spell4;
	ImageButton imagebutton_icon_advance_spell5;
	ImageButton imagebutton_icon_advance_spell6;
	ImageButton imagebutton_icon_advance_spell7;

	public AdvanceSpellGUIScreen(AdvanceSpellGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lanternofthewoodlands:textures/screens/advance_spell_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_false_divination"), -116, -68, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_the_spell_of_astrology"), -144, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_use_all_13_zodiac_cards"), -144, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_goods_and_bad_effects"), -144, 28, -12829636, false);
		guiGraphics.drawString(this.font,

				GUIreturnManaProcedure.execute(entity), -160, -116, -10066330, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_skills"), -136, -8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_per_time_since_its_very_comple"), -144, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_complex_and_can_cause"), -144, 52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_1_false_divination"), 28, -88, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_pharos_of_the_sky"), 28, -68, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_biosphere"), 28, -48, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_autumn_of_loss"), 28, -28, -10053376, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_lost_in_reality"), 28, -8, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_moon_shines"), 28, 12, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_encantamentos"), 28, 32, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_lag_to_server"), -144, 64, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_green_updated"), 8, 64, -10053376, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.advance_spell_gui.label_spell_control_panel"), -132, -88, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_exit.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AdvanceSpellGUIButtonMessage(0, x, y, z, textstate));
				AdvanceSpellGUIButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_exit", imagebutton_symbol_exit);
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_icon_home = new ImageButton(this.leftPos + -172, this.topPos + -96, 22, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_home.png"), 22, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AdvanceSpellGUIButtonMessage(1, x, y, z, textstate));
				AdvanceSpellGUIButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_icon_home", imagebutton_icon_home);
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_next.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AdvanceSpellGUIButtonMessage(2, x, y, z, textstate));
				AdvanceSpellGUIButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_next", imagebutton_symbol_next);
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_previous.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AdvanceSpellGUIButtonMessage(3, x, y, z, textstate));
				AdvanceSpellGUIButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_previous", imagebutton_symbol_previous);
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_background_icon = new ImageButton(this.leftPos + -88, this.topPos + -44, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_icon.png"), 24, 48, e -> {
		});
		guistate.put("button:imagebutton_background_icon", imagebutton_background_icon);
		this.addRenderableWidget(imagebutton_background_icon);
		imagebutton_icon_advance_spell = new ImageButton(this.leftPos + -84, this.topPos + -40, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_advance_spell.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_advance_spell", imagebutton_icon_advance_spell);
		this.addRenderableWidget(imagebutton_icon_advance_spell);
		imagebutton_symbol_line = new ImageButton(this.leftPos + 8, this.topPos + 48, 168, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_line.png"), 168, 16, e -> {
		});
		guistate.put("button:imagebutton_symbol_line", imagebutton_symbol_line);
		this.addRenderableWidget(imagebutton_symbol_line);
		imagebutton_background_text_dark_gray = new ImageButton(this.leftPos + -144, this.topPos + -92, 184, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_dark_gray.png"), 184, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_dark_gray", imagebutton_background_text_dark_gray);
		this.addRenderableWidget(imagebutton_background_text_dark_gray);
		imagebutton_background_text_purple = new ImageButton(this.leftPos + -144, this.topPos + -72, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_purple.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_purple", imagebutton_background_text_purple);
		this.addRenderableWidget(imagebutton_background_text_purple);
		imagebutton_icon_advance_spell1 = new ImageButton(this.leftPos + 8, this.topPos + -92, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_advance_spell1.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_advance_spell1", imagebutton_icon_advance_spell1);
		this.addRenderableWidget(imagebutton_icon_advance_spell1);
		imagebutton_icon_advance_spell2 = new ImageButton(this.leftPos + 8, this.topPos + -72, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_advance_spell2.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_advance_spell2", imagebutton_icon_advance_spell2);
		this.addRenderableWidget(imagebutton_icon_advance_spell2);
		imagebutton_icon_advance_spell3 = new ImageButton(this.leftPos + 8, this.topPos + -52, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_advance_spell3.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_advance_spell3", imagebutton_icon_advance_spell3);
		this.addRenderableWidget(imagebutton_icon_advance_spell3);
		imagebutton_icon_advance_spell4 = new ImageButton(this.leftPos + 8, this.topPos + -32, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_advance_spell4.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_advance_spell4", imagebutton_icon_advance_spell4);
		this.addRenderableWidget(imagebutton_icon_advance_spell4);
		imagebutton_icon_advance_spell5 = new ImageButton(this.leftPos + 8, this.topPos + -12, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_advance_spell5.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_advance_spell5", imagebutton_icon_advance_spell5);
		this.addRenderableWidget(imagebutton_icon_advance_spell5);
		imagebutton_icon_advance_spell6 = new ImageButton(this.leftPos + 8, this.topPos + 8, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_advance_spell6.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_advance_spell6", imagebutton_icon_advance_spell6);
		this.addRenderableWidget(imagebutton_icon_advance_spell6);
		imagebutton_icon_advance_spell7 = new ImageButton(this.leftPos + 8, this.topPos + 28, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_advance_spell7.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_advance_spell7", imagebutton_icon_advance_spell7);
		this.addRenderableWidget(imagebutton_icon_advance_spell7);
	}
}
