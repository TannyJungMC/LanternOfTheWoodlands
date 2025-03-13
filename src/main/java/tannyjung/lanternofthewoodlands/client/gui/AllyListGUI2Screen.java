package tannyjung.lanternofthewoodlands.client.gui;

import tannyjung.lanternofthewoodlands.world.inventory.AllyListGUI2Menu;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageRightProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageLeftProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnManaProcedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIreturnManualProcedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIreturnChatSettingProcedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIreturnAuto3Procedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIreturnAuto2Procedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIreturnAuto1Procedure;
import tannyjung.lanternofthewoodlands.network.AllyListGUI2ButtonMessage;
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

public class AllyListGUI2Screen extends AbstractContainerScreen<AllyListGUI2Menu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = AllyListGUI2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_symbol_add;
	ImageButton imagebutton_symbol_alternative_keyboard;
	ImageButton imagebutton_symbol_alternative_keyboard1;
	ImageButton imagebutton_symbol_alternative_keyboard2;
	ImageButton imagebutton_symbol_alternative_keyboard3;
	ImageButton imagebutton_icon_home;
	ImageButton imagebutton_symbol_exit;
	ImageButton imagebutton_symbol_help2;
	ImageButton imagebutton_symbol_help_2s;
	ImageButton imagebutton_symbol_remove;
	ImageButton imagebutton_symbol_remove1;
	ImageButton imagebutton_symbol_remove_2s;
	ImageButton imagebutton_symbol_remove_2s1;
	ImageButton imagebutton_symbol_remove_2s2;
	ImageButton imagebutton_symbol_remove_2s3;
	ImageButton imagebutton_symbol_set_cycle;
	ImageButton imagebutton_symbol_next;
	ImageButton imagebutton_symbol_previous;
	ImageButton imagebutton_symbol_line_2s;
	ImageButton imagebutton_background_text_red;
	ImageButton imagebutton_background_text_green;
	ImageButton imagebutton_background_text_green1;

	public AllyListGUI2Screen(AllyListGUI2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lanternofthewoodlands:textures/screens/ally_list_gui_2.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -72 && mouseX < leftPos + -64 && mouseY > topPos + -24 && mouseY < topPos + -16)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.ally_list_gui_2.tooltip_reset_ally_list_to_empty"), mouseX, mouseY);
		if (mouseX > leftPos + 136 && mouseX < leftPos + 144 && mouseY > topPos + 52 && mouseY < topPos + 60)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.ally_list_gui_2.tooltip_send_chat_to_these_player_when_y"), mouseX, mouseY);
		if (mouseX > leftPos + 32 && mouseX < leftPos + 40 && mouseY > topPos + -24 && mouseY < topPos + -16)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.ally_list_gui_2.tooltip_manual_add_playerentity_to_ally"), mouseX, mouseY);
		if (mouseX > leftPos + 44 && mouseX < leftPos + 52 && mouseY > topPos + -24 && mouseY < topPos + -16)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.ally_list_gui_2.tooltip_manual_remove_playerentity_to_a"), mouseX, mouseY);
		if (mouseX > leftPos + -88 && mouseX < leftPos + -80 && mouseY > topPos + -24 && mouseY < topPos + -16)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.ally_list_gui_2.tooltip_send_a_list_of_your_allies_to_yo"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font,

				GUIreturnManaProcedure.execute(entity), -160, -116, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.ally_list_gui_2.label_and_custom"), -136, -68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.ally_list_gui_2.label_your_magic_maybe_in_some_case"), 16, -68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.ally_list_gui_2.label_auto_add"), -104, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.ally_list_gui_2.label_manual"), 48, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.ally_list_gui_2.label_chat_setting"), 20, 52, -12829636, false);
		guiGraphics.drawString(this.font,

				AllyListGUIreturnAuto1Procedure.execute(entity), -144, 16, -6710887, false);
		guiGraphics.drawString(this.font,

				AllyListGUIreturnAuto2Procedure.execute(entity), -144, 40, -6710887, false);
		guiGraphics.drawString(this.font,

				AllyListGUIreturnAuto3Procedure.execute(entity), -144, 64, -6710887, false);
		guiGraphics.drawString(this.font,

				AllyListGUIreturnManualProcedure.execute(entity), 8, -12, -6710887, false);
		guiGraphics.drawString(this.font,

				AllyListGUIreturnChatSettingProcedure.execute(entity), 20, 64, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.ally_list_gui_2.label_maybe_in_some_case"), 8, -56, -12829636, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.ally_list_gui_2.label_settings"), 56, 32, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.ally_list_gui_2.label_to_ally_list_every_minute"), -144, -56, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_add = new ImageButton(this.leftPos + 32, this.topPos + -24, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_add.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(0, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_add", imagebutton_symbol_add);
		this.addRenderableWidget(imagebutton_symbol_add);
		imagebutton_symbol_alternative_keyboard = new ImageButton(this.leftPos + 8, this.topPos + -24, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_alternative_keyboard.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(1, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_alternative_keyboard", imagebutton_symbol_alternative_keyboard);
		this.addRenderableWidget(imagebutton_symbol_alternative_keyboard);
		imagebutton_symbol_alternative_keyboard1 = new ImageButton(this.leftPos + -144, this.topPos + 4, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_alternative_keyboard1.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(2, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_alternative_keyboard1", imagebutton_symbol_alternative_keyboard1);
		this.addRenderableWidget(imagebutton_symbol_alternative_keyboard1);
		imagebutton_symbol_alternative_keyboard2 = new ImageButton(this.leftPos + -144, this.topPos + 28, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_alternative_keyboard2.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(3, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_alternative_keyboard2", imagebutton_symbol_alternative_keyboard2);
		this.addRenderableWidget(imagebutton_symbol_alternative_keyboard2);
		imagebutton_symbol_alternative_keyboard3 = new ImageButton(this.leftPos + -144, this.topPos + 52, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_alternative_keyboard3.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(4, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 4, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_alternative_keyboard3", imagebutton_symbol_alternative_keyboard3);
		this.addRenderableWidget(imagebutton_symbol_alternative_keyboard3);
		imagebutton_icon_home = new ImageButton(this.leftPos + -172, this.topPos + -96, 22, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_home.png"), 22, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(5, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 5, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_icon_home", imagebutton_icon_home);
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_exit.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(6, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 6, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_exit", imagebutton_symbol_exit);
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_symbol_help2 = new ImageButton(this.leftPos + 136, this.topPos + 52, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_help2.png"), 8, 16, e -> {
		});
		guistate.put("button:imagebutton_symbol_help2", imagebutton_symbol_help2);
		this.addRenderableWidget(imagebutton_symbol_help2);
		imagebutton_symbol_help_2s = new ImageButton(this.leftPos + -88, this.topPos + -24, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_help_2s.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(8, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 8, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_help_2s", imagebutton_symbol_help_2s);
		this.addRenderableWidget(imagebutton_symbol_help_2s);
		imagebutton_symbol_remove = new ImageButton(this.leftPos + 44, this.topPos + -24, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_remove.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(9, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 9, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_remove", imagebutton_symbol_remove);
		this.addRenderableWidget(imagebutton_symbol_remove);
		imagebutton_symbol_remove1 = new ImageButton(this.leftPos + -72, this.topPos + -24, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_remove1.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(10, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 10, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_remove1", imagebutton_symbol_remove1);
		this.addRenderableWidget(imagebutton_symbol_remove1);
		imagebutton_symbol_remove_2s = new ImageButton(this.leftPos + 20, this.topPos + -24, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_remove_2s.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(11, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 11, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_remove_2s", imagebutton_symbol_remove_2s);
		this.addRenderableWidget(imagebutton_symbol_remove_2s);
		imagebutton_symbol_remove_2s1 = new ImageButton(this.leftPos + -132, this.topPos + 4, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_remove_2s1.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(12, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 12, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_remove_2s1", imagebutton_symbol_remove_2s1);
		this.addRenderableWidget(imagebutton_symbol_remove_2s1);
		imagebutton_symbol_remove_2s2 = new ImageButton(this.leftPos + -132, this.topPos + 28, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_remove_2s2.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(13, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 13, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_remove_2s2", imagebutton_symbol_remove_2s2);
		this.addRenderableWidget(imagebutton_symbol_remove_2s2);
		imagebutton_symbol_remove_2s3 = new ImageButton(this.leftPos + -132, this.topPos + 52, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_remove_2s3.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(14, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 14, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_remove_2s3", imagebutton_symbol_remove_2s3);
		this.addRenderableWidget(imagebutton_symbol_remove_2s3);
		imagebutton_symbol_set_cycle = new ImageButton(this.leftPos + 8, this.topPos + 64, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_set_cycle.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(15, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 15, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_set_cycle", imagebutton_symbol_set_cycle);
		this.addRenderableWidget(imagebutton_symbol_set_cycle);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_next.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(16, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 16, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_next", imagebutton_symbol_next);
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_previous.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new AllyListGUI2ButtonMessage(17, x, y, z, textstate));
				AllyListGUI2ButtonMessage.handleButtonAction(entity, 17, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_previous", imagebutton_symbol_previous);
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_symbol_line_2s = new ImageButton(this.leftPos + 8, this.topPos + 52, 8, 12, 0, 0, 12, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_line_2s.png"), 8, 24, e -> {
		});
		guistate.put("button:imagebutton_symbol_line_2s", imagebutton_symbol_line_2s);
		this.addRenderableWidget(imagebutton_symbol_line_2s);
		imagebutton_background_text_red = new ImageButton(this.leftPos + 8, this.topPos + 28, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_red.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_red", imagebutton_background_text_red);
		this.addRenderableWidget(imagebutton_background_text_red);
		imagebutton_background_text_green = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_green.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_green", imagebutton_background_text_green);
		this.addRenderableWidget(imagebutton_background_text_green);
		imagebutton_background_text_green1 = new ImageButton(this.leftPos + 8, this.topPos + -92, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_green1.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_green1", imagebutton_background_text_green1);
		this.addRenderableWidget(imagebutton_background_text_green1);
	}
}
