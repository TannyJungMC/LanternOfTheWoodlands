package tannyjung.lanternofthewoodlands.client.gui;

import tannyjung.lanternofthewoodlands.world.inventory.ManaRegenerationGUIMenu;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageRightProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageLeftProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnManaProcedure;
import tannyjung.lanternofthewoodlands.network.ManaRegenerationGUIButtonMessage;
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

public class ManaRegenerationGUIScreen extends AbstractContainerScreen<ManaRegenerationGUIMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = ManaRegenerationGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_symbol_exit;
	ImageButton imagebutton_icon_home;
	ImageButton imagebutton_symbol_previous;
	ImageButton imagebutton_symbol_next;
	ImageButton imagebutton_symbol_line_2s2;
	ImageButton imagebutton_background_icon;
	ImageButton imagebutton_icon_mana_regeneration;
	ImageButton imagebutton_image_mana_regeneration;
	ImageButton imagebutton_background_text_red;
	ImageButton imagebutton_background_text_purple;

	public ManaRegenerationGUIScreen(ManaRegenerationGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lanternofthewoodlands:textures/screens/mana_regeneration_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_from_creator"), 56, 36, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_upgrades"), -124, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_mana_display_style"), 20, 56, -6737152, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_abc"), -136, -28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_power_that_permeates_the_univers"), -144, -16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_universe_i_use_this_mana_as_ene"), -144, -4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_as_energy_source_to_power_my_mag"), -144, 8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_my_magic_system1"), -144, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_but_in_general_mana_will_absorb"), -136, 36, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_absorbed_into_objects_slowly_tha"), -144, 48, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_than_living_creatures_so_i_crea"), -144, 60, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_i_created_a_small_system_to_abso"), 8, -88, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_to_absorb_the_mana_surrounding_a"), 8, -76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_surrounding_and_store_inside_the1"), 8, -64, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_the_book"), 8, -52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.mana_regeneration_gui.label_the_book1"), 8, -40, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_exit.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new ManaRegenerationGUIButtonMessage(0, x, y, z, textstate));
				ManaRegenerationGUIButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_exit", imagebutton_symbol_exit);
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_icon_home = new ImageButton(this.leftPos + -172, this.topPos + -96, 22, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_home.png"), 22, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new ManaRegenerationGUIButtonMessage(1, x, y, z, textstate));
				ManaRegenerationGUIButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_icon_home", imagebutton_icon_home);
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_previous.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new ManaRegenerationGUIButtonMessage(2, x, y, z, textstate));
				ManaRegenerationGUIButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_previous", imagebutton_symbol_previous);
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_next.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new ManaRegenerationGUIButtonMessage(3, x, y, z, textstate));
				ManaRegenerationGUIButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_next", imagebutton_symbol_next);
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_symbol_line_2s2 = new ImageButton(this.leftPos + 8, this.topPos + 56, 8, 12, 0, 0, 12, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_line_2s2.png"), 8, 24, e -> {
		});
		guistate.put("button:imagebutton_symbol_line_2s2", imagebutton_symbol_line_2s2);
		this.addRenderableWidget(imagebutton_symbol_line_2s2);
		imagebutton_background_icon = new ImageButton(this.leftPos + -88, this.topPos + -64, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_icon.png"), 24, 48, e -> {
		});
		guistate.put("button:imagebutton_background_icon", imagebutton_background_icon);
		this.addRenderableWidget(imagebutton_background_icon);
		imagebutton_icon_mana_regeneration = new ImageButton(this.leftPos + -84, this.topPos + -60, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_mana_regeneration.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_mana_regeneration", imagebutton_icon_mana_regeneration);
		this.addRenderableWidget(imagebutton_icon_mana_regeneration);
		imagebutton_image_mana_regeneration = new ImageButton(this.leftPos + 20, this.topPos + -26, 112, 48, 0, 0, 48, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_image_mana_regeneration.png"), 112, 96, e -> {
		});
		guistate.put("button:imagebutton_image_mana_regeneration", imagebutton_image_mana_regeneration);
		this.addRenderableWidget(imagebutton_image_mana_regeneration);
		imagebutton_background_text_red = new ImageButton(this.leftPos + 8, this.topPos + 32, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_red.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_red", imagebutton_background_text_red);
		this.addRenderableWidget(imagebutton_background_text_red);
		imagebutton_background_text_purple = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_purple.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_purple", imagebutton_background_text_purple);
		this.addRenderableWidget(imagebutton_background_text_purple);
	}
}
