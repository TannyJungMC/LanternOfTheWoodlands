package tannyjung.tanscomplexmagic.client.gui;

import tannyjung.tanscomplexmagic.world.inventory.PersonalWeaponGUIMenu;
import tannyjung.tanscomplexmagic.procedures.GUIreturnPageRightProcedure;
import tannyjung.tanscomplexmagic.procedures.GUIreturnPageLeftProcedure;
import tannyjung.tanscomplexmagic.procedures.GUIreturnManaProcedure;
import tannyjung.tanscomplexmagic.network.PersonalWeaponGUIButtonMessage;
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

public class PersonalWeaponGUIScreen extends AbstractContainerScreen<PersonalWeaponGUIMenu> implements TanscomplexmagicModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_symbol_exit;
	private ImageButton imagebutton_icon_home;
	private ImageButton imagebutton_symbol_previous;
	private ImageButton imagebutton_symbol_next;
	private ImageButton imagebutton_icon_personal_weapon;
	private ImageButton imagebutton_background_icon;
	private ImageButton imagebutton_image_personal_weapon;
	private ImageButton imagebutton_background_text_purple;

	public PersonalWeaponGUIScreen(PersonalWeaponGUIMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("tanscomplexmagic:textures/screens/personal_weapon_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_upgrades"), -120, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_set_your_primary_weapon_to_spell"), -136, -28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_to_spell_addon_get_special_effe"), -144, -16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_effects_while_holding_it"), -144, -4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_you_can_use_it_as_casting_device"), -136, 12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_device"), -144, 24, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_function"), -144, 36, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_that_have_mark_function"), -144, 60, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_with_spell"), -144, 48, -12829636, false);
		guiGraphics.drawString(this.font, GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font, GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_you_can_place_weapon_on"), 16, -88, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_ground_by_holding_it_on_left"), 8, -76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_hand_hold_opened_user"), 8, -64, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_book_on_right_hand_hold"), 8, -52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_the_main_key_and_right_click"), 8, -40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_on_ground"), 8, -28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_pick_up_by_empty_right"), 16, -12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_hand_hold_shift_and_hold"), 8, 0, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_weapon_gui.label_the_main_key"), 8, 12, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png")), e -> {
					int x = PersonalWeaponGUIScreen.this.x;
					int y = PersonalWeaponGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalWeaponGUIButtonMessage(0, x, y, z));
						PersonalWeaponGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
					int x = PersonalWeaponGUIScreen.this.x;
					int y = PersonalWeaponGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalWeaponGUIButtonMessage(1, x, y, z));
						PersonalWeaponGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_previous.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_previous.png")), e -> {
					int x = PersonalWeaponGUIScreen.this.x;
					int y = PersonalWeaponGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalWeaponGUIButtonMessage(2, x, y, z));
						PersonalWeaponGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_next.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_next.png")), e -> {
					int x = PersonalWeaponGUIScreen.this.x;
					int y = PersonalWeaponGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalWeaponGUIButtonMessage(3, x, y, z));
						PersonalWeaponGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_icon_personal_weapon = new ImageButton(this.leftPos + -84, this.topPos + -60, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_personal_weapon.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_personal_weapon.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_personal_weapon);
		imagebutton_background_icon = new ImageButton(this.leftPos + -88, this.topPos + -64, 24, 24,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_icon.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_icon.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_icon);
		imagebutton_image_personal_weapon = new ImageButton(this.leftPos + 20, this.topPos + 28, 112, 48,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/image_personal_weapon.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/image_personal_weapon.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_image_personal_weapon);
		imagebutton_background_text_purple = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_purple.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_purple.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_purple);
	}
}