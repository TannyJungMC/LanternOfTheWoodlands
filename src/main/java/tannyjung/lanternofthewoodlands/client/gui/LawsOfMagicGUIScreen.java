package tannyjung.lanternofthewoodlands.client.gui;

import tannyjung.lanternofthewoodlands.world.inventory.LawsOfMagicGUIMenu;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageRightProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageLeftProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnManaProcedure;
import tannyjung.lanternofthewoodlands.network.LawsOfMagicGUIButtonMessage;
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

public class LawsOfMagicGUIScreen extends AbstractContainerScreen<LawsOfMagicGUIMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = LawsOfMagicGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_symbol_next;
	ImageButton imagebutton_symbol_previous;
	ImageButton imagebutton_icon_home;
	ImageButton imagebutton_symbol_exit;
	ImageButton imagebutton_background_text_purple;

	public LawsOfMagicGUIScreen(LawsOfMagicGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lanternofthewoodlands:textures/screens/laws_of_magic_gui.png");

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
		guiGraphics.drawString(this.font,

				GUIreturnManaProcedure.execute(entity), -160, -116, -10066330, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_you_need_to_make_contract"), 16, -48, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_and_make_contract_between"), 8, -36, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_with_me_under_the"), -136, 32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_laws_of_magic_is"), -144, 56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_of_magic"), -144, 44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_rules_strictly"), 16, -20, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_the_rules_will_be_punished_accor"), 8, -8, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_according_to_law"), 8, 4, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_give_you_small_magic_to"), -112, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_store_saves_of_spell_settings"), -136, -68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_store_saves_of_spell_settings1"), -144, -56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_around_your_body"), -144, -44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_the_key"), -144, -32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_settings_from_lost_when"), -144, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_you_lost_your_book"), 8, 16, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_magic_department"), -144, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_anyone_who_violates_this_will_be"), -144, -20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_punished_according_to_law"), -144, -8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_here_is"), 16, -88, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_laws_you"), 8, -76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.laws_of_magic_gui.label_follow_them_strictly"), 8, -64, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_next.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new LawsOfMagicGUIButtonMessage(0, x, y, z, textstate));
				LawsOfMagicGUIButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_next", imagebutton_symbol_next);
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_previous.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new LawsOfMagicGUIButtonMessage(1, x, y, z, textstate));
				LawsOfMagicGUIButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_previous", imagebutton_symbol_previous);
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_icon_home = new ImageButton(this.leftPos + -172, this.topPos + -96, 22, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_home.png"), 22, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new LawsOfMagicGUIButtonMessage(2, x, y, z, textstate));
				LawsOfMagicGUIButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_icon_home", imagebutton_icon_home);
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_exit.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new LawsOfMagicGUIButtonMessage(3, x, y, z, textstate));
				LawsOfMagicGUIButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_exit", imagebutton_symbol_exit);
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_background_text_purple = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_purple.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_purple", imagebutton_background_text_purple);
		this.addRenderableWidget(imagebutton_background_text_purple);
	}
}
