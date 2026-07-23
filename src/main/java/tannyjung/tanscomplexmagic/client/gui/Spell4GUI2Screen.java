package tannyjung.tanscomplexmagic.client.gui;

import tannyjung.tanscomplexmagic.world.inventory.Spell4GUI2Menu;
import tannyjung.tanscomplexmagic.procedures.GUIreturnPageRightProcedure;
import tannyjung.tanscomplexmagic.procedures.GUIreturnPageLeftProcedure;
import tannyjung.tanscomplexmagic.procedures.GUIreturnManaProcedure;
import tannyjung.tanscomplexmagic.network.Spell4GUI2ButtonMessage;
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

public class Spell4GUI2Screen extends AbstractContainerScreen<Spell4GUI2Menu> implements TanscomplexmagicModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_symbol_exit;
	private ImageButton imagebutton_icon_home;
	private ImageButton imagebutton_symbol_next;
	private ImageButton imagebutton_symbol_previous;
	private ImageButton imagebutton_background_text_green;
	private ImageButton imagebutton_image_spell4_story;

	public Spell4GUI2Screen(Spell4GUI2Menu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("tanscomplexmagic:textures/screens/spell_4_gui_2.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_book.png"), this.leftPos + -160, this.topPos + -104, 0, 0, 400, 240, 400, 240);
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
		guiGraphics.drawString(this.font, GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font, GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_for_every_warriors_who_died_in_t"), -136, -68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_died_in_the_war_i_will_remember"), -144, -56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_remember_you_your_fight_your_c"), -144, -44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_your_courage_i_want_to_say_than"), -144, -32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_say_thank_you_for_protect_us"), -144, -20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_in_this_time_i_would_like_to_us"), -144, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_victory_and_freedom_back"), 16, -88, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_us"), -144, -8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_like_to_use_your_weapons_to_fig"), 8, -76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_to_fight_the_darkness_youre_th"), 8, -64, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_our_lights_in_the_dark"), 8, -52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_darkness"), -144, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_me_strength"), 8, -40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.spell_4_gui_2.label_story"), -92, -88, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png")), e -> {
					int x = Spell4GUI2Screen.this.x;
					int y = Spell4GUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUI2ButtonMessage(0, x, y, z));
						Spell4GUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_icon_home = new ImageButton(this.leftPos + -172, this.topPos + -96, 22, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_home.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_home_2s.png")), e -> {
					int x = Spell4GUI2Screen.this.x;
					int y = Spell4GUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUI2ButtonMessage(1, x, y, z));
						Spell4GUI2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_next.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_next.png")), e -> {
					int x = Spell4GUI2Screen.this.x;
					int y = Spell4GUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUI2ButtonMessage(2, x, y, z));
						Spell4GUI2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_previous.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_previous.png")), e -> {
					int x = Spell4GUI2Screen.this.x;
					int y = Spell4GUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new Spell4GUI2ButtonMessage(3, x, y, z));
						Spell4GUI2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_background_text_green = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_green.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_green.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_green);
		imagebutton_image_spell4_story = new ImageButton(this.leftPos + -132, this.topPos + 28, 112, 48,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/image_spell4_story.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/image_spell4_story.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_image_spell4_story);
	}
}