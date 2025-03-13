package tannyjung.lanternofthewoodlands.client.gui;

import tannyjung.lanternofthewoodlands.world.inventory.FromCreatorGUIMenu;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageRightProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageLeftProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnManaProcedure;
import tannyjung.lanternofthewoodlands.network.FromCreatorGUIButtonMessage;
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

public class FromCreatorGUIScreen extends AbstractContainerScreen<FromCreatorGUIMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = FromCreatorGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_symbol_exit;
	ImageButton imagebutton_symbol_next;
	ImageButton imagebutton_icon_social_links;
	ImageButton imagebutton_image_tape_3s;
	ImageButton imagebutton_image_tape_4s;

	public FromCreatorGUIScreen(FromCreatorGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lanternofthewoodlands:textures/screens/from_creator_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -104 && mouseX < leftPos + -48 && mouseY > topPos + 60 && mouseY < topPos + 68)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.from_creator_gui.tooltip_website_links_will_send_to_your"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("lanternofthewoodlands:textures/screens/background_book.png"), this.leftPos + -160, this.topPos + -104, 0, 0, 400, 240, 400, 240);

		guiGraphics.blit(new ResourceLocation("lanternofthewoodlands:textures/screens/image_name.png"), this.leftPos + -144, this.topPos + -88, 0, 0, 136, 28, 136, 28);

		guiGraphics.blit(new ResourceLocation("lanternofthewoodlands:textures/screens/image_from_creator.png"), this.leftPos + 16, this.topPos + -80, 0, 0, 120, 144, 120, 144);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.from_creator_gui.label_thank_you_for_download"), -136, -52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.from_creator_gui.label_and_playing_my_mods"), -144, -40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.from_creator_gui.label_can_followsupport_me"), -144, -28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.from_creator_gui.label_the_website_link_below"), -144, -16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.from_creator_gui.label_subscribe_me_in_patreon"), -144, -4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.from_creator_gui.label_i_do_artworks_too_if"), -136, 12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.from_creator_gui.label_you_want_to_see_theyre_in"), -144, 24, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.from_creator_gui.label_my_twitter_and_pinterest"), -144, 36, -12829636, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_exit.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new FromCreatorGUIButtonMessage(0, x, y, z, textstate));
				FromCreatorGUIButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_exit", imagebutton_symbol_exit);
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_next.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new FromCreatorGUIButtonMessage(1, x, y, z, textstate));
				FromCreatorGUIButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_next", imagebutton_symbol_next);
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_icon_social_links = new ImageButton(this.leftPos + -108, this.topPos + 60, 64, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_social_links.png"), 64, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new FromCreatorGUIButtonMessage(2, x, y, z, textstate));
				FromCreatorGUIButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_icon_social_links", imagebutton_icon_social_links);
		this.addRenderableWidget(imagebutton_icon_social_links);
		imagebutton_image_tape_3s = new ImageButton(this.leftPos + 120, this.topPos + -88, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_image_tape_3s.png"), 24, 48, e -> {
		});
		guistate.put("button:imagebutton_image_tape_3s", imagebutton_image_tape_3s);
		this.addRenderableWidget(imagebutton_image_tape_3s);
		imagebutton_image_tape_4s = new ImageButton(this.leftPos + 8, this.topPos + 48, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_image_tape_4s.png"), 24, 48, e -> {
		});
		guistate.put("button:imagebutton_image_tape_4s", imagebutton_image_tape_4s);
		this.addRenderableWidget(imagebutton_image_tape_4s);
	}
}
