package tannyjung.tanscomplexmagic.client.gui;

import tannyjung.tanscomplexmagic.world.inventory.FromCreatorGUIMenu;
import tannyjung.tanscomplexmagic.procedures.GUIreturnPageRightProcedure;
import tannyjung.tanscomplexmagic.procedures.GUIreturnPageLeftProcedure;
import tannyjung.tanscomplexmagic.procedures.GUIreturnManaProcedure;
import tannyjung.tanscomplexmagic.network.FromCreatorGUIButtonMessage;
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

public class FromCreatorGUIScreen extends AbstractContainerScreen<FromCreatorGUIMenu> implements TanscomplexmagicModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_symbol_exit;
	private ImageButton imagebutton_symbol_next;
	private ImageButton imagebutton_icon_social_links;
	private ImageButton imagebutton_image_tape_3s;
	private ImageButton imagebutton_image_tape_4s;

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

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("tanscomplexmagic:textures/screens/from_creator_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + -104 && mouseX < leftPos + -48 && mouseY > topPos + 60 && mouseY < topPos + 68) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.from_creator_gui.tooltip_website_links_will_send_to_your"), mouseX, mouseY);
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
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/image_name.png"), this.leftPos + -144, this.topPos + -88, 0, 0, 136, 28, 136, 28);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/image_from_creator.png"), this.leftPos + 16, this.topPos + -80, 0, 0, 120, 144, 120, 144);
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
		guiGraphics.drawString(this.font, GUIreturnManaProcedure.execute(entity), -160, -116, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.from_creator_gui.label_thank_you_for_download"), -136, -52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.from_creator_gui.label_and_playing_my_mods"), -144, -40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.from_creator_gui.label_can_followsupport_me"), -144, -28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.from_creator_gui.label_the_website_link_below"), -144, -16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.from_creator_gui.label_subscribe_me_in_patreon"), -144, -4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.from_creator_gui.label_i_do_artworks_too_if"), -136, 12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.from_creator_gui.label_you_want_to_see_theyre_in"), -144, 24, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.from_creator_gui.label_my_twitter_and_pinterest"), -144, 36, -12829636, false);
		guiGraphics.drawString(this.font, GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font, GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png")), e -> {
					int x = FromCreatorGUIScreen.this.x;
					int y = FromCreatorGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new FromCreatorGUIButtonMessage(0, x, y, z));
						FromCreatorGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_next.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_next.png")), e -> {
					int x = FromCreatorGUIScreen.this.x;
					int y = FromCreatorGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new FromCreatorGUIButtonMessage(1, x, y, z));
						FromCreatorGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_icon_social_links = new ImageButton(this.leftPos + -108, this.topPos + 60, 64, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_social_links.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_social_links.png")), e -> {
					int x = FromCreatorGUIScreen.this.x;
					int y = FromCreatorGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new FromCreatorGUIButtonMessage(2, x, y, z));
						FromCreatorGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_social_links);
		imagebutton_image_tape_3s = new ImageButton(this.leftPos + 120, this.topPos + -88, 24, 24,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/image_tape_3s.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/image_tape_3s.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_image_tape_3s);
		imagebutton_image_tape_4s = new ImageButton(this.leftPos + 8, this.topPos + 48, 24, 24,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/image_tape_4s.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/image_tape_4s.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_image_tape_4s);
	}
}