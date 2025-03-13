package tannyjung.lanternofthewoodlands.client.gui;

import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIsettings2Menu;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageRightProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageLeftProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnManaProcedure;
import tannyjung.lanternofthewoodlands.network.Spell4GUIsettings2ButtonMessage;
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

public class Spell4GUIsettings2Screen extends AbstractContainerScreen<Spell4GUIsettings2Menu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = Spell4GUIsettings2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_symbol_next;
	ImageButton imagebutton_icon_home;
	ImageButton imagebutton_symbol_previous;
	ImageButton imagebutton_symbol_checkbox;
	ImageButton imagebutton_symbol_line_2s;
	ImageButton imagebutton_symbol_set_cycle;
	ImageButton imagebutton_image_spell4_settings;

	public Spell4GUIsettings2Screen(Spell4GUIsettings2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lanternofthewoodlands:textures/screens/spell_4_gu_isettings_2.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_isettings_2.label_balance"), -132, -88, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.spell_4_gu_isettings_2.label_height"), -132, -76, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_next.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIsettings2ButtonMessage(0, x, y, z, textstate));
				Spell4GUIsettings2ButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_next", imagebutton_symbol_next);
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_icon_home = new ImageButton(this.leftPos + -172, this.topPos + -96, 22, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_home.png"), 22, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIsettings2ButtonMessage(1, x, y, z, textstate));
				Spell4GUIsettings2ButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_icon_home", imagebutton_icon_home);
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_previous.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIsettings2ButtonMessage(2, x, y, z, textstate));
				Spell4GUIsettings2ButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_previous", imagebutton_symbol_previous);
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_symbol_checkbox = new ImageButton(this.leftPos + -144, this.topPos + -88, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_checkbox.png"), 8, 16, e -> {
		});
		guistate.put("button:imagebutton_symbol_checkbox", imagebutton_symbol_checkbox);
		this.addRenderableWidget(imagebutton_symbol_checkbox);
		imagebutton_symbol_line_2s = new ImageButton(this.leftPos + -144, this.topPos + -76, 8, 12, 0, 0, 12, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_line_2s.png"), 8, 24, e -> {
		});
		guistate.put("button:imagebutton_symbol_line_2s", imagebutton_symbol_line_2s);
		this.addRenderableWidget(imagebutton_symbol_line_2s);
		imagebutton_symbol_set_cycle = new ImageButton(this.leftPos + -144, this.topPos + -64, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_set_cycle.png"), 8, 16, e -> {
		});
		guistate.put("button:imagebutton_symbol_set_cycle", imagebutton_symbol_set_cycle);
		this.addRenderableWidget(imagebutton_symbol_set_cycle);
		imagebutton_image_spell4_settings = new ImageButton(this.leftPos + -132, this.topPos + -48, 112, 48, 0, 0, 48, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_image_spell4_settings.png"), 112, 96, e -> {
		});
		guistate.put("button:imagebutton_image_spell4_settings", imagebutton_image_spell4_settings);
		this.addRenderableWidget(imagebutton_image_spell4_settings);
	}
}
