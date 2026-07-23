package tannyjung.tanscomplexmagic.client.gui;

import tannyjung.tanscomplexmagic.world.inventory.AdvanceSpellGUIMenu;
import tannyjung.tanscomplexmagic.procedures.GUIreturnPageRightProcedure;
import tannyjung.tanscomplexmagic.procedures.GUIreturnPageLeftProcedure;
import tannyjung.tanscomplexmagic.procedures.GUIreturnManaProcedure;
import tannyjung.tanscomplexmagic.network.AdvanceSpellGUIButtonMessage;
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

public class AdvanceSpellGUIScreen extends AbstractContainerScreen<AdvanceSpellGUIMenu> implements TanscomplexmagicModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_symbol_exit;
	private ImageButton imagebutton_icon_home;
	private ImageButton imagebutton_symbol_next;
	private ImageButton imagebutton_symbol_previous;
	private ImageButton imagebutton_background_icon;
	private ImageButton imagebutton_icon_advance_spell;
	private ImageButton imagebutton_symbol_line;
	private ImageButton imagebutton_background_text_dark_gray;
	private ImageButton imagebutton_background_text_purple;
	private ImageButton imagebutton_icon_advance_spell1;
	private ImageButton imagebutton_icon_advance_spell2;
	private ImageButton imagebutton_icon_advance_spell3;
	private ImageButton imagebutton_icon_advance_spell4;
	private ImageButton imagebutton_icon_advance_spell5;
	private ImageButton imagebutton_icon_advance_spell6;
	private ImageButton imagebutton_icon_advance_spell7;

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

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("tanscomplexmagic:textures/screens/advance_spell_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_false_divination"), -116, -68, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_the_spell_of_astrology"), -144, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_use_all_13_zodiac_cards"), -144, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_goods_and_bad_effects"), -144, 28, -12829636, false);
		guiGraphics.drawString(this.font, GUIreturnManaProcedure.execute(entity), -160, -116, -10066330, false);
		guiGraphics.drawString(this.font, GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font, GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_skills"), -136, -8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_per_time_since_its_very_comple"), -144, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_complex_and_can_cause"), -144, 52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_1_false_divination"), 28, -88, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_pharos_of_the_sky"), 28, -68, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_biosphere"), 28, -48, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_autumn_of_loss"), 28, -28, -10053376, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_lost_in_reality"), 28, -8, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_moon_shines"), 28, 12, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_encantamentos"), 28, 32, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_lag_to_server"), -144, 64, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_green_updated"), 8, 64, -10053376, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.advance_spell_gui.label_spell_control_panel"), -132, -88, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png")), e -> {
					int x = AdvanceSpellGUIScreen.this.x;
					int y = AdvanceSpellGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdvanceSpellGUIButtonMessage(0, x, y, z));
						AdvanceSpellGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
					int x = AdvanceSpellGUIScreen.this.x;
					int y = AdvanceSpellGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdvanceSpellGUIButtonMessage(1, x, y, z));
						AdvanceSpellGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
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
					int x = AdvanceSpellGUIScreen.this.x;
					int y = AdvanceSpellGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdvanceSpellGUIButtonMessage(2, x, y, z));
						AdvanceSpellGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
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
					int x = AdvanceSpellGUIScreen.this.x;
					int y = AdvanceSpellGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdvanceSpellGUIButtonMessage(3, x, y, z));
						AdvanceSpellGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_background_icon = new ImageButton(this.leftPos + -88, this.topPos + -44, 24, 24,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_icon.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_icon.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_icon);
		imagebutton_icon_advance_spell = new ImageButton(this.leftPos + -84, this.topPos + -40, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_advance_spell);
		imagebutton_symbol_line = new ImageButton(this.leftPos + 8, this.topPos + 48, 168, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_line);
		imagebutton_background_text_dark_gray = new ImageButton(this.leftPos + -144, this.topPos + -92, 184, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_dark_gray.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_dark_gray.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_dark_gray);
		imagebutton_background_text_purple = new ImageButton(this.leftPos + -144, this.topPos + -72, 136, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_purple.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_purple.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_purple);
		imagebutton_icon_advance_spell1 = new ImageButton(this.leftPos + 8, this.topPos + -92, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell1.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell1.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_advance_spell1);
		imagebutton_icon_advance_spell2 = new ImageButton(this.leftPos + 8, this.topPos + -72, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell2.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell2.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_advance_spell2);
		imagebutton_icon_advance_spell3 = new ImageButton(this.leftPos + 8, this.topPos + -52, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell3.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell3.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_advance_spell3);
		imagebutton_icon_advance_spell4 = new ImageButton(this.leftPos + 8, this.topPos + -32, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell4.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell4.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_advance_spell4);
		imagebutton_icon_advance_spell5 = new ImageButton(this.leftPos + 8, this.topPos + -12, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell5.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell5.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_advance_spell5);
		imagebutton_icon_advance_spell6 = new ImageButton(this.leftPos + 8, this.topPos + 8, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell6.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell6.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_advance_spell6);
		imagebutton_icon_advance_spell7 = new ImageButton(this.leftPos + 8, this.topPos + 28, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell7.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_advance_spell7.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_advance_spell7);
	}
}