package tannyjung.lanternofthewoodlands.client.gui;

import tannyjung.lanternofthewoodlands.world.inventory.PersonalSkillGUI2Menu;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnSkillTheMissingPersonProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnSkillTheMissingPersonLockProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnSkillRejuvenatingMushroomProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnSkillRejuvenatingMushroomLockProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnSkillNothingProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnSkillCircleOfHealingProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnSkillCircleOfHealingLockProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnSkillBlinkProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnSkillBlinkLockProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnRadiusProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnLevelProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnDurationProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnCustomValueProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnCustomProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalSkillGUIreturnCooldownProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageRightProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageLeftProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnManaProcedure;
import tannyjung.lanternofthewoodlands.network.PersonalSkillGUI2ButtonMessage;
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

public class PersonalSkillGUI2Screen extends AbstractContainerScreen<PersonalSkillGUI2Menu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = PersonalSkillGUI2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_symbol_exit;
	ImageButton imagebutton_icon_home;
	ImageButton imagebutton_symbol_previous;
	ImageButton imagebutton_symbol_next;
	ImageButton imagebutton_symbol_upgrade;
	ImageButton imagebutton_symbol_line_2s;
	ImageButton imagebutton_icon_spell_the_missing_person;
	ImageButton imagebutton_icon_lock;
	ImageButton imagebutton_icon_select;
	ImageButton imagebutton_icon_nothing;
	ImageButton imagebutton_icon_select1;
	ImageButton imagebutton_icon_spell_circle_of_healing;
	ImageButton imagebutton_icon_lock2;
	ImageButton imagebutton_icon_select3;
	ImageButton imagebutton_icon_spell_rejuvenating_mushroom;
	ImageButton imagebutton_icon_lock1;
	ImageButton imagebutton_icon_select2;
	ImageButton imagebutton_icon_spell_blink;
	ImageButton imagebutton_icon_lock3;
	ImageButton imagebutton_icon_select4;
	ImageButton imagebutton_symbol_line;
	ImageButton imagebutton_background_text_green;
	ImageButton imagebutton_background_text_red;
	ImageButton imagebutton_symbol_help;

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

	private static final ResourceLocation texture = new ResourceLocation("lanternofthewoodlands:textures/screens/personal_skill_gui_2.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -108 && mouseX < leftPos + -92 && mouseY > topPos + -68 && mouseY < topPos + -52)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.personal_skill_gui_2.tooltip_invisibility"), mouseX, mouseY);
		if (mouseX > leftPos + -132 && mouseX < leftPos + -116 && mouseY > topPos + -68 && mouseY < topPos + -52)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.personal_skill_gui_2.tooltip_no_skill1"), mouseX, mouseY);
		if (mouseX > leftPos + 8 && mouseX < leftPos + 16 && mouseY > topPos + -56 && mouseY < topPos + -48)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.personal_skill_gui_2.tooltip_1_skill_level_30_mana"), mouseX, mouseY);
		if (mouseX > leftPos + -84 && mouseX < leftPos + -68 && mouseY > topPos + -68 && mouseY < topPos + -52)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.personal_skill_gui_2.tooltip_healing_area_instant_heal_all"), mouseX, mouseY);
		if (mouseX > leftPos + -60 && mouseX < leftPos + -44 && mouseY > topPos + -68 && mouseY < topPos + -52)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.personal_skill_gui_2.tooltip_rejuvenating_mushroom_instant"), mouseX, mouseY);
		if (mouseX > leftPos + -36 && mouseX < leftPos + -20 && mouseY > topPos + -68 && mouseY < topPos + -52)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.personal_skill_gui_2.tooltip_blink_teleport_to_a_block_you"), mouseX, mouseY);
		if (mouseX > leftPos + -144 && mouseX < leftPos + -136 && mouseY > topPos + -64 && mouseY < topPos + -56)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.personal_skill_gui_2.tooltip_all_skill_price_is_60_mana"), mouseX, mouseY);
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

				PersonalSkillGUIreturnCustomProcedure.execute(entity), 8, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_skill_gui_2.label_skill_level"), 20, -68, -12829636, false);
		guiGraphics.drawString(this.font,

				PersonalSkillGUIreturnLevelProcedure.execute(entity), 20, -56, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_skill_gui_2.label_skill_cooldown"), 8, -32, -12829636, false);
		guiGraphics.drawString(this.font,

				PersonalSkillGUIreturnDurationProcedure.execute(entity), 8, 4, -6710887, false);
		guiGraphics.drawString(this.font,

				PersonalSkillGUIreturnCustomValueProcedure.execute(entity), 8, 52, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_skill_gui_2.label_skill_duration"), 8, -8, -12829636, false);
		guiGraphics.drawString(this.font,

				PersonalSkillGUIreturnCooldownProcedure.execute(entity), 8, -20, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_skill_gui_2.label_personal_weapon_skill"), -104, -88, -1, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_skill_gui_2.label_skill_upgrade"), 56, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_skill_gui_2.label_radius"), 8, 16, -12829636, false);
		guiGraphics.drawString(this.font,

				PersonalSkillGUIreturnRadiusProcedure.execute(entity), 8, 28, -6710887, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_exit.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalSkillGUI2ButtonMessage(0, x, y, z, textstate));
				PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_exit", imagebutton_symbol_exit);
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_icon_home = new ImageButton(this.leftPos + -172, this.topPos + -96, 22, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_home.png"), 22, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalSkillGUI2ButtonMessage(1, x, y, z, textstate));
				PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_icon_home", imagebutton_icon_home);
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_previous.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalSkillGUI2ButtonMessage(2, x, y, z, textstate));
				PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_previous", imagebutton_symbol_previous);
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_next.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalSkillGUI2ButtonMessage(3, x, y, z, textstate));
				PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_next", imagebutton_symbol_next);
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_symbol_upgrade = new ImageButton(this.leftPos + 8, this.topPos + -56, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_upgrade.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalSkillGUI2ButtonMessage(4, x, y, z, textstate));
				PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 4, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_upgrade", imagebutton_symbol_upgrade);
		this.addRenderableWidget(imagebutton_symbol_upgrade);
		imagebutton_symbol_line_2s = new ImageButton(this.leftPos + 8, this.topPos + -68, 8, 12, 0, 0, 12, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_line_2s.png"), 8, 24, e -> {
		});
		guistate.put("button:imagebutton_symbol_line_2s", imagebutton_symbol_line_2s);
		this.addRenderableWidget(imagebutton_symbol_line_2s);
		imagebutton_icon_spell_the_missing_person = new ImageButton(this.leftPos + -108, this.topPos + -68, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_spell_the_missing_person.png"), 16, 32,
				e -> {
					if (true) {
						LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalSkillGUI2ButtonMessage(6, x, y, z, textstate));
						PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 6, x, y, z, textstate);
					}
				});
		guistate.put("button:imagebutton_icon_spell_the_missing_person", imagebutton_icon_spell_the_missing_person);
		this.addRenderableWidget(imagebutton_icon_spell_the_missing_person);
		imagebutton_icon_lock = new ImageButton(this.leftPos + -108, this.topPos + -68, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_lock.png"), 16, 32, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (PersonalSkillGUIreturnSkillTheMissingPersonLockProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_icon_lock", imagebutton_icon_lock);
		this.addRenderableWidget(imagebutton_icon_lock);
		imagebutton_icon_select = new ImageButton(this.leftPos + -112, this.topPos + -72, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_select.png"), 24, 48, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (PersonalSkillGUIreturnSkillTheMissingPersonProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_icon_select", imagebutton_icon_select);
		this.addRenderableWidget(imagebutton_icon_select);
		imagebutton_icon_nothing = new ImageButton(this.leftPos + -132, this.topPos + -68, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_nothing.png"), 16, 32, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalSkillGUI2ButtonMessage(9, x, y, z, textstate));
				PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 9, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_icon_nothing", imagebutton_icon_nothing);
		this.addRenderableWidget(imagebutton_icon_nothing);
		imagebutton_icon_select1 = new ImageButton(this.leftPos + -136, this.topPos + -72, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_select1.png"), 24, 48, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (PersonalSkillGUIreturnSkillNothingProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_icon_select1", imagebutton_icon_select1);
		this.addRenderableWidget(imagebutton_icon_select1);
		imagebutton_icon_spell_circle_of_healing = new ImageButton(this.leftPos + -84, this.topPos + -68, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_spell_circle_of_healing.png"), 16, 32,
				e -> {
					if (true) {
						LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalSkillGUI2ButtonMessage(11, x, y, z, textstate));
						PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 11, x, y, z, textstate);
					}
				});
		guistate.put("button:imagebutton_icon_spell_circle_of_healing", imagebutton_icon_spell_circle_of_healing);
		this.addRenderableWidget(imagebutton_icon_spell_circle_of_healing);
		imagebutton_icon_lock2 = new ImageButton(this.leftPos + -84, this.topPos + -68, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_lock2.png"), 16, 32, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (PersonalSkillGUIreturnSkillCircleOfHealingLockProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_icon_lock2", imagebutton_icon_lock2);
		this.addRenderableWidget(imagebutton_icon_lock2);
		imagebutton_icon_select3 = new ImageButton(this.leftPos + -88, this.topPos + -72, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_select3.png"), 24, 48, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (PersonalSkillGUIreturnSkillCircleOfHealingProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_icon_select3", imagebutton_icon_select3);
		this.addRenderableWidget(imagebutton_icon_select3);
		imagebutton_icon_spell_rejuvenating_mushroom = new ImageButton(this.leftPos + -60, this.topPos + -68, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_spell_rejuvenating_mushroom.png"), 16,
				32, e -> {
					if (true) {
						LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalSkillGUI2ButtonMessage(14, x, y, z, textstate));
						PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 14, x, y, z, textstate);
					}
				});
		guistate.put("button:imagebutton_icon_spell_rejuvenating_mushroom", imagebutton_icon_spell_rejuvenating_mushroom);
		this.addRenderableWidget(imagebutton_icon_spell_rejuvenating_mushroom);
		imagebutton_icon_lock1 = new ImageButton(this.leftPos + -60, this.topPos + -68, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_lock1.png"), 16, 32, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (PersonalSkillGUIreturnSkillRejuvenatingMushroomLockProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_icon_lock1", imagebutton_icon_lock1);
		this.addRenderableWidget(imagebutton_icon_lock1);
		imagebutton_icon_select2 = new ImageButton(this.leftPos + -64, this.topPos + -72, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_select2.png"), 24, 48, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (PersonalSkillGUIreturnSkillRejuvenatingMushroomProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_icon_select2", imagebutton_icon_select2);
		this.addRenderableWidget(imagebutton_icon_select2);
		imagebutton_icon_spell_blink = new ImageButton(this.leftPos + -36, this.topPos + -68, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_spell_blink.png"), 16, 32, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalSkillGUI2ButtonMessage(17, x, y, z, textstate));
				PersonalSkillGUI2ButtonMessage.handleButtonAction(entity, 17, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_icon_spell_blink", imagebutton_icon_spell_blink);
		this.addRenderableWidget(imagebutton_icon_spell_blink);
		imagebutton_icon_lock3 = new ImageButton(this.leftPos + -36, this.topPos + -68, 16, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_lock3.png"), 16, 32, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (PersonalSkillGUIreturnSkillBlinkLockProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_icon_lock3", imagebutton_icon_lock3);
		this.addRenderableWidget(imagebutton_icon_lock3);
		imagebutton_icon_select4 = new ImageButton(this.leftPos + -40, this.topPos + -72, 24, 24, 0, 0, 24, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_select4.png"), 24, 48, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (PersonalSkillGUIreturnSkillBlinkProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_icon_select4", imagebutton_icon_select4);
		this.addRenderableWidget(imagebutton_icon_select4);
		imagebutton_symbol_line = new ImageButton(this.leftPos + 8, this.topPos + -48, 168, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_line.png"), 168, 16, e -> {
		});
		guistate.put("button:imagebutton_symbol_line", imagebutton_symbol_line);
		this.addRenderableWidget(imagebutton_symbol_line);
		imagebutton_background_text_green = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_green.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_green", imagebutton_background_text_green);
		this.addRenderableWidget(imagebutton_background_text_green);
		imagebutton_background_text_red = new ImageButton(this.leftPos + 8, this.topPos + -92, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_red.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_red", imagebutton_background_text_red);
		this.addRenderableWidget(imagebutton_background_text_red);
		imagebutton_symbol_help = new ImageButton(this.leftPos + -144, this.topPos + -64, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_help.png"), 8, 16, e -> {
		});
		guistate.put("button:imagebutton_symbol_help", imagebutton_symbol_help);
		this.addRenderableWidget(imagebutton_symbol_help);
	}
}
