package tannyjung.tanscomplexmagic.client.gui;

import tannyjung.tanscomplexmagic.world.inventory.PersonalSkillGUI2Menu;
import tannyjung.tanscomplexmagic.procedures.*;
import tannyjung.tanscomplexmagic.network.PersonalSkillGUI2ButtonMessage;
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

public class PersonalSkillGUI2Screen extends AbstractContainerScreen<PersonalSkillGUI2Menu> implements TanscomplexmagicModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_symbol_exit;
	private ImageButton imagebutton_icon_home;
	private ImageButton imagebutton_symbol_previous;
	private ImageButton imagebutton_symbol_next;
	private ImageButton imagebutton_symbol_upgrade;
	private ImageButton imagebutton_symbol_line_2s;
	private ImageButton imagebutton_icon_spell_the_missing_person;
	private ImageButton imagebutton_icon_lock;
	private ImageButton imagebutton_icon_select;
	private ImageButton imagebutton_icon_nothing;
	private ImageButton imagebutton_icon_select1;
	private ImageButton imagebutton_icon_spell_circle_of_healing;
	private ImageButton imagebutton_icon_lock2;
	private ImageButton imagebutton_icon_select3;
	private ImageButton imagebutton_icon_spell_rejuvenating_mushroom;
	private ImageButton imagebutton_icon_lock1;
	private ImageButton imagebutton_icon_select2;
	private ImageButton imagebutton_icon_spell_blink;
	private ImageButton imagebutton_icon_lock3;
	private ImageButton imagebutton_icon_select4;
	private ImageButton imagebutton_symbol_line;
	private ImageButton imagebutton_background_text_green;
	private ImageButton imagebutton_background_text_red;
	private ImageButton imagebutton_symbol_help;

	public PersonalSkillGUI2Screen(PersonalSkillGUI2Menu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("tanscomplexmagic:textures/screens/personal_skill_gui_2.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + -108 && mouseX < leftPos + -92 && mouseY > topPos + -68 && mouseY < topPos + -52) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.personal_skill_gui_2.tooltip_invisibility"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -132 && mouseX < leftPos + -116 && mouseY > topPos + -68 && mouseY < topPos + -52) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.personal_skill_gui_2.tooltip_no_skill1"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 8 && mouseX < leftPos + 16 && mouseY > topPos + -56 && mouseY < topPos + -48) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.personal_skill_gui_2.tooltip_1_skill_level_30_mana"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -84 && mouseX < leftPos + -68 && mouseY > topPos + -68 && mouseY < topPos + -52) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.personal_skill_gui_2.tooltip_healing_area_instant_heal_all"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -60 && mouseX < leftPos + -44 && mouseY > topPos + -68 && mouseY < topPos + -52) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.personal_skill_gui_2.tooltip_rejuvenating_mushroom_instant"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -36 && mouseX < leftPos + -20 && mouseY > topPos + -68 && mouseY < topPos + -52) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.personal_skill_gui_2.tooltip_blink_teleport_to_a_block_you"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -144 && mouseX < leftPos + -136 && mouseY > topPos + -64 && mouseY < topPos + -56) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.tanscomplexmagic.personal_skill_gui_2.tooltip_all_skill_price_is_60_mana"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, PersonalSkillGUIreturnCustomProcedure.execute(entity), 8, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_skill_gui_2.label_skill_level"), 20, -68, -12829636, false);
		guiGraphics.drawString(this.font, PersonalSkillGUIreturnLevelProcedure.execute(entity), 20, -56, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_skill_gui_2.label_skill_cooldown"), 8, -32, -12829636, false);
		guiGraphics.drawString(this.font, PersonalSkillGUIreturnDurationProcedure.execute(entity), 8, 4, -6710887, false);
		guiGraphics.drawString(this.font, PersonalSkillGUIreturnCustomValueProcedure.execute(entity), 8, 52, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_skill_gui_2.label_skill_duration"), 8, -8, -12829636, false);
		guiGraphics.drawString(this.font, PersonalSkillGUIreturnCooldownProcedure.execute(entity), 8, -20, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_skill_gui_2.label_personal_weapon_skill"), -104, -88, -1, false);
		guiGraphics.drawString(this.font, GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font, GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_skill_gui_2.label_skill_upgrade"), 56, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.personal_skill_gui_2.label_radius"), 8, 16, -12829636, false);
		guiGraphics.drawString(this.font, PersonalSkillGUIreturnRadiusProcedure.execute(entity), 8, 28, -6710887, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_exit.png")), e -> {
					int x = PersonalSkillGUI2Screen.this.x;
					int y = PersonalSkillGUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalSkillGUI2ButtonMessage(0, x, y, z));
						PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
					int x = PersonalSkillGUI2Screen.this.x;
					int y = PersonalSkillGUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalSkillGUI2ButtonMessage(1, x, y, z));
						PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
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
					int x = PersonalSkillGUI2Screen.this.x;
					int y = PersonalSkillGUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalSkillGUI2ButtonMessage(2, x, y, z));
						PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
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
					int x = PersonalSkillGUI2Screen.this.x;
					int y = PersonalSkillGUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalSkillGUI2ButtonMessage(3, x, y, z));
						PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_symbol_upgrade = new ImageButton(this.leftPos + 8, this.topPos + -56, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_upgrade.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_upgrade.png")), e -> {
					int x = PersonalSkillGUI2Screen.this.x;
					int y = PersonalSkillGUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalSkillGUI2ButtonMessage(4, x, y, z));
						PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_upgrade);
		imagebutton_symbol_line_2s = new ImageButton(this.leftPos + 8, this.topPos + -68, 8, 12,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line_2s.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_line_2s);
		imagebutton_icon_spell_the_missing_person = new ImageButton(this.leftPos + -108, this.topPos + -68, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_the_missing_person.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_the_missing_person.png")), e -> {
					int x = PersonalSkillGUI2Screen.this.x;
					int y = PersonalSkillGUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalSkillGUI2ButtonMessage(6, x, y, z));
						PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_spell_the_missing_person);
		imagebutton_icon_lock = new ImageButton(this.leftPos + -108, this.topPos + -68, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_lock.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_lock.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PersonalSkillGUI2Screen.this.x;
				int y = PersonalSkillGUI2Screen.this.y;
				if (PersonalSkillGUIreturnSkillTheMissingPersonLockProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_lock);
		imagebutton_icon_select = new ImageButton(this.leftPos + -112, this.topPos + -72, 24, 24,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_select.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_select.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PersonalSkillGUI2Screen.this.x;
				int y = PersonalSkillGUI2Screen.this.y;
				if (PersonalSkillGUIreturnSkillTheMissingPersonProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_select);
		imagebutton_icon_nothing = new ImageButton(this.leftPos + -132, this.topPos + -68, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_nothing.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_nothing.png")), e -> {
					int x = PersonalSkillGUI2Screen.this.x;
					int y = PersonalSkillGUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalSkillGUI2ButtonMessage(9, x, y, z));
						PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_nothing);
		imagebutton_icon_select1 = new ImageButton(this.leftPos + -136, this.topPos + -72, 24, 24,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_select.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_select.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PersonalSkillGUI2Screen.this.x;
				int y = PersonalSkillGUI2Screen.this.y;
				if (PersonalSkillGUIreturnSkillNothingProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_select1);
		imagebutton_icon_spell_circle_of_healing = new ImageButton(this.leftPos + -84, this.topPos + -68, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_circle_of_healing.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_circle_of_healing.png")), e -> {
					int x = PersonalSkillGUI2Screen.this.x;
					int y = PersonalSkillGUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalSkillGUI2ButtonMessage(11, x, y, z));
						PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_spell_circle_of_healing);
		imagebutton_icon_lock2 = new ImageButton(this.leftPos + -84, this.topPos + -68, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_lock.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_lock.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PersonalSkillGUI2Screen.this.x;
				int y = PersonalSkillGUI2Screen.this.y;
				if (PersonalSkillGUIreturnSkillCircleOfHealingLockProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_lock2);
		imagebutton_icon_select3 = new ImageButton(this.leftPos + -88, this.topPos + -72, 24, 24,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_select.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_select.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PersonalSkillGUI2Screen.this.x;
				int y = PersonalSkillGUI2Screen.this.y;
				if (PersonalSkillGUIreturnSkillCircleOfHealingProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_select3);
		imagebutton_icon_spell_rejuvenating_mushroom = new ImageButton(this.leftPos + -60, this.topPos + -68, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_rejuvenating_mushroom.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_rejuvenating_mushroom.png")), e -> {
					int x = PersonalSkillGUI2Screen.this.x;
					int y = PersonalSkillGUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalSkillGUI2ButtonMessage(14, x, y, z));
						PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 14, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_spell_rejuvenating_mushroom);
		imagebutton_icon_lock1 = new ImageButton(this.leftPos + -60, this.topPos + -68, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_lock.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_lock.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PersonalSkillGUI2Screen.this.x;
				int y = PersonalSkillGUI2Screen.this.y;
				if (PersonalSkillGUIreturnSkillRejuvenatingMushroomLockProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_lock1);
		imagebutton_icon_select2 = new ImageButton(this.leftPos + -64, this.topPos + -72, 24, 24,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_select.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_select.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PersonalSkillGUI2Screen.this.x;
				int y = PersonalSkillGUI2Screen.this.y;
				if (PersonalSkillGUIreturnSkillRejuvenatingMushroomProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_select2);
		imagebutton_icon_spell_blink = new ImageButton(this.leftPos + -36, this.topPos + -68, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_blink.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_spell_blink.png")), e -> {
					int x = PersonalSkillGUI2Screen.this.x;
					int y = PersonalSkillGUI2Screen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PersonalSkillGUI2ButtonMessage(17, x, y, z));
						PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 17, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_spell_blink);
		imagebutton_icon_lock3 = new ImageButton(this.leftPos + -36, this.topPos + -68, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_lock.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_lock.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PersonalSkillGUI2Screen.this.x;
				int y = PersonalSkillGUI2Screen.this.y;
				if (PersonalSkillGUIreturnSkillBlinkLockProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_lock3);
		imagebutton_icon_select4 = new ImageButton(this.leftPos + -40, this.topPos + -72, 24, 24,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_select.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/icon_select.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PersonalSkillGUI2Screen.this.x;
				int y = PersonalSkillGUI2Screen.this.y;
				if (PersonalSkillGUIreturnSkillBlinkProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_icon_select4);
		imagebutton_symbol_line = new ImageButton(this.leftPos + 8, this.topPos + -48, 168, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_line.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_line);
		imagebutton_background_text_green = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_green.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_green.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_green);
		imagebutton_background_text_red = new ImageButton(this.leftPos + 8, this.topPos + -92, 136, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_red.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/background_text_red.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_background_text_red);
		imagebutton_symbol_help = new ImageButton(this.leftPos + -144, this.topPos + -64, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/symbol_help.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_symbol_help);
	}
}