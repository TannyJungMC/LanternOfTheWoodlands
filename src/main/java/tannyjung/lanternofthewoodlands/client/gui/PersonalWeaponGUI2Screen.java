package tannyjung.lanternofthewoodlands.client.gui;

import tannyjung.lanternofthewoodlands.world.inventory.PersonalWeaponGUI2Menu;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIreturnShowCenterTrueProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIreturnRotationTrueProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIreturnReverseRotationTrueProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIreturnPoseZProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIreturnPoseYProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIreturnPoseXProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIreturnPosZProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIreturnPosYProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIreturnPosXProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIreturnNameProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIreturnIDProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIreturnFlyingProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageRightProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnPageLeftProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIreturnManaProcedure;
import tannyjung.lanternofthewoodlands.network.PersonalWeaponGUI2ButtonMessage;
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

public class PersonalWeaponGUI2Screen extends AbstractContainerScreen<PersonalWeaponGUI2Menu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = PersonalWeaponGUI2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_symbol_exit;
	ImageButton imagebutton_icon_home;
	ImageButton imagebutton_symbol_previous;
	ImageButton imagebutton_symbol_next;
	ImageButton imagebutton_symbol_add;
	ImageButton imagebutton_symbol_remove;
	ImageButton imagebutton_symbol_checkbox;
	ImageButton imagebutton_symbol_checkbox1;
	ImageButton imagebutton_symbol_checkbox2;
	ImageButton imagebutton_symbol_reset;
	ImageButton imagebutton_symbol_reset1;
	ImageButton imagebutton_symbol_increase;
	ImageButton imagebutton_symbol_increase1;
	ImageButton imagebutton_symbol_increase2;
	ImageButton imagebutton_symbol_increase3;
	ImageButton imagebutton_symbol_increase4;
	ImageButton imagebutton_symbol_increase5;
	ImageButton imagebutton_symbol_reduce;
	ImageButton imagebutton_symbol_reduce1;
	ImageButton imagebutton_symbol_reduce2;
	ImageButton imagebutton_symbol_reduce3;
	ImageButton imagebutton_symbol_reduce4;
	ImageButton imagebutton_symbol_reduce5;
	ImageButton imagebutton_symbol_true;
	ImageButton imagebutton_symbol_true1;
	ImageButton imagebutton_symbol_true2;
	ImageButton imagebutton_symbol_checkbox3;
	ImageButton imagebutton_symbol_true3;
	ImageButton imagebutton_background_text_red;
	ImageButton imagebutton_background_text_orange;
	ImageButton imagebutton_background_text_green;

	public PersonalWeaponGUI2Screen(PersonalWeaponGUI2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lanternofthewoodlands:textures/screens/personal_weapon_gui_2.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -88 && mouseX < leftPos + -80 && mouseY > topPos + 4 && mouseY < topPos + 12)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.tooltip_set_item_on_your_left_hand_as_pe"), mouseX, mouseY);
		if (mouseX > leftPos + -72 && mouseX < leftPos + -64 && mouseY > topPos + 4 && mouseY < topPos + 12)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.tooltip_reset_your_personal_weapon_to_no"), mouseX, mouseY);
		if (mouseX > leftPos + 8 && mouseX < leftPos + 16 && mouseY > topPos + 28 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.tooltip_reset_position_to_default_values"), mouseX, mouseY);
		if (mouseX > leftPos + 76 && mouseX < leftPos + 84 && mouseY > topPos + 28 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.tooltip_reset_pose_to_default_values"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_set_weapon"), -112, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_item_id"), -144, 28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_item_display_name"), -144, 52, -12829636, false);
		guiGraphics.drawString(this.font,

				PersonalWeaponGUIreturnIDProcedure.execute(entity), -144, 40, -6710887, false);
		guiGraphics.drawString(this.font,

				PersonalWeaponGUIreturnNameProcedure.execute(entity), -144, 64, -6710887, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageLeftProcedure.execute(entity), -84, 88, -3355444, false);
		guiGraphics.drawString(this.font,

				GUIreturnPageRightProcedure.execute(entity), 68, 88, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_set_your_personal_weapon"), -136, -68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_by_holding_your_weapon_on"), -144, -56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_left_hand_and_click_button_you"), -144, -44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_empty_left_hand_to_set_it_to"), -144, -32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_to_nothing"), -144, -20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_settings"), 52, -88, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_show_center"), 20, -68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_rotation"), 20, -56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_reverse_rotation"), 20, -44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_position_and_pose"), 32, 8, -1, false);
		guiGraphics.drawString(this.font,

				PersonalWeaponGUIreturnPosXProcedure.execute(entity), 28, 40, -6710887, false);
		guiGraphics.drawString(this.font,

				PersonalWeaponGUIreturnPosYProcedure.execute(entity), 28, 52, -6710887, false);
		guiGraphics.drawString(this.font,

				PersonalWeaponGUIreturnPosZProcedure.execute(entity), 28, 64, -6710887, false);
		guiGraphics.drawString(this.font,

				PersonalWeaponGUIreturnPoseXProcedure.execute(entity), 96, 40, -6710887, false);
		guiGraphics.drawString(this.font,

				PersonalWeaponGUIreturnPoseYProcedure.execute(entity), 96, 52, -6710887, false);
		guiGraphics.drawString(this.font,

				PersonalWeaponGUIreturnPoseZProcedure.execute(entity), 96, 64, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.lanternofthewoodlands.personal_weapon_gui_2.label_flying"), 20, -32, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_symbol_exit = new ImageButton(this.leftPos + 144, this.topPos + 88, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_exit.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(0, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_exit", imagebutton_symbol_exit);
		this.addRenderableWidget(imagebutton_symbol_exit);
		imagebutton_icon_home = new ImageButton(this.leftPos + -172, this.topPos + -96, 22, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_icon_home.png"), 22, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(1, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_icon_home", imagebutton_icon_home);
		this.addRenderableWidget(imagebutton_icon_home);
		imagebutton_symbol_previous = new ImageButton(this.leftPos + -160, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_previous.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(2, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_previous", imagebutton_symbol_previous);
		this.addRenderableWidget(imagebutton_symbol_previous);
		imagebutton_symbol_next = new ImageButton(this.leftPos + 152, this.topPos + -12, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_next.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(3, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_next", imagebutton_symbol_next);
		this.addRenderableWidget(imagebutton_symbol_next);
		imagebutton_symbol_add = new ImageButton(this.leftPos + -88, this.topPos + 4, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_add.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(4, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 4, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_add", imagebutton_symbol_add);
		this.addRenderableWidget(imagebutton_symbol_add);
		imagebutton_symbol_remove = new ImageButton(this.leftPos + -72, this.topPos + 4, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_remove.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(5, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 5, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_remove", imagebutton_symbol_remove);
		this.addRenderableWidget(imagebutton_symbol_remove);
		imagebutton_symbol_checkbox = new ImageButton(this.leftPos + 8, this.topPos + -68, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_checkbox.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(6, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 6, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_checkbox", imagebutton_symbol_checkbox);
		this.addRenderableWidget(imagebutton_symbol_checkbox);
		imagebutton_symbol_checkbox1 = new ImageButton(this.leftPos + 8, this.topPos + -56, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_checkbox1.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(7, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 7, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_checkbox1", imagebutton_symbol_checkbox1);
		this.addRenderableWidget(imagebutton_symbol_checkbox1);
		imagebutton_symbol_checkbox2 = new ImageButton(this.leftPos + 8, this.topPos + -44, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_checkbox2.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(8, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 8, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_checkbox2", imagebutton_symbol_checkbox2);
		this.addRenderableWidget(imagebutton_symbol_checkbox2);
		imagebutton_symbol_reset = new ImageButton(this.leftPos + 8, this.topPos + 28, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_reset.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(9, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 9, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_reset", imagebutton_symbol_reset);
		this.addRenderableWidget(imagebutton_symbol_reset);
		imagebutton_symbol_reset1 = new ImageButton(this.leftPos + 76, this.topPos + 28, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_reset1.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(10, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 10, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_reset1", imagebutton_symbol_reset1);
		this.addRenderableWidget(imagebutton_symbol_reset1);
		imagebutton_symbol_increase = new ImageButton(this.leftPos + 8, this.topPos + 40, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_increase.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(11, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 11, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_increase", imagebutton_symbol_increase);
		this.addRenderableWidget(imagebutton_symbol_increase);
		imagebutton_symbol_increase1 = new ImageButton(this.leftPos + 8, this.topPos + 52, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_increase1.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(12, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 12, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_increase1", imagebutton_symbol_increase1);
		this.addRenderableWidget(imagebutton_symbol_increase1);
		imagebutton_symbol_increase2 = new ImageButton(this.leftPos + 8, this.topPos + 64, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_increase2.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(13, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 13, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_increase2", imagebutton_symbol_increase2);
		this.addRenderableWidget(imagebutton_symbol_increase2);
		imagebutton_symbol_increase3 = new ImageButton(this.leftPos + 76, this.topPos + 40, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_increase3.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(14, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 14, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_increase3", imagebutton_symbol_increase3);
		this.addRenderableWidget(imagebutton_symbol_increase3);
		imagebutton_symbol_increase4 = new ImageButton(this.leftPos + 76, this.topPos + 52, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_increase4.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(15, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 15, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_increase4", imagebutton_symbol_increase4);
		this.addRenderableWidget(imagebutton_symbol_increase4);
		imagebutton_symbol_increase5 = new ImageButton(this.leftPos + 76, this.topPos + 64, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_increase5.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(16, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 16, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_increase5", imagebutton_symbol_increase5);
		this.addRenderableWidget(imagebutton_symbol_increase5);
		imagebutton_symbol_reduce = new ImageButton(this.leftPos + 16, this.topPos + 40, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_reduce.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(17, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 17, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_reduce", imagebutton_symbol_reduce);
		this.addRenderableWidget(imagebutton_symbol_reduce);
		imagebutton_symbol_reduce1 = new ImageButton(this.leftPos + 16, this.topPos + 52, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_reduce1.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(18, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 18, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_reduce1", imagebutton_symbol_reduce1);
		this.addRenderableWidget(imagebutton_symbol_reduce1);
		imagebutton_symbol_reduce2 = new ImageButton(this.leftPos + 16, this.topPos + 64, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_reduce2.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(19, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 19, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_reduce2", imagebutton_symbol_reduce2);
		this.addRenderableWidget(imagebutton_symbol_reduce2);
		imagebutton_symbol_reduce3 = new ImageButton(this.leftPos + 84, this.topPos + 40, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_reduce3.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(20, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 20, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_reduce3", imagebutton_symbol_reduce3);
		this.addRenderableWidget(imagebutton_symbol_reduce3);
		imagebutton_symbol_reduce4 = new ImageButton(this.leftPos + 84, this.topPos + 52, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_reduce4.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(21, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 21, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_reduce4", imagebutton_symbol_reduce4);
		this.addRenderableWidget(imagebutton_symbol_reduce4);
		imagebutton_symbol_reduce5 = new ImageButton(this.leftPos + 84, this.topPos + 64, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_reduce5.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(22, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 22, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_reduce5", imagebutton_symbol_reduce5);
		this.addRenderableWidget(imagebutton_symbol_reduce5);
		imagebutton_symbol_true = new ImageButton(this.leftPos + 8, this.topPos + -68, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_true.png"), 8, 16, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (PersonalWeaponGUIreturnShowCenterTrueProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_symbol_true", imagebutton_symbol_true);
		this.addRenderableWidget(imagebutton_symbol_true);
		imagebutton_symbol_true1 = new ImageButton(this.leftPos + 8, this.topPos + -56, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_true1.png"), 8, 16, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (PersonalWeaponGUIreturnRotationTrueProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_symbol_true1", imagebutton_symbol_true1);
		this.addRenderableWidget(imagebutton_symbol_true1);
		imagebutton_symbol_true2 = new ImageButton(this.leftPos + 8, this.topPos + -44, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_true2.png"), 8, 16, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (PersonalWeaponGUIreturnReverseRotationTrueProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_symbol_true2", imagebutton_symbol_true2);
		this.addRenderableWidget(imagebutton_symbol_true2);
		imagebutton_symbol_checkbox3 = new ImageButton(this.leftPos + 8, this.topPos + -32, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_checkbox3.png"), 8, 16, e -> {
			if (true) {
				LanternofthewoodlandsMod.PACKET_HANDLER.sendToServer(new PersonalWeaponGUI2ButtonMessage(26, x, y, z, textstate));
				PersonalWeaponGUI2ButtonMessage.handleButtonAction(entity, 26, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_symbol_checkbox3", imagebutton_symbol_checkbox3);
		this.addRenderableWidget(imagebutton_symbol_checkbox3);
		imagebutton_symbol_true3 = new ImageButton(this.leftPos + 8, this.topPos + -32, 8, 8, 0, 0, 8, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_symbol_true3.png"), 8, 16, e -> {
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (PersonalWeaponGUIreturnFlyingProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_symbol_true3", imagebutton_symbol_true3);
		this.addRenderableWidget(imagebutton_symbol_true3);
		imagebutton_background_text_red = new ImageButton(this.leftPos + 8, this.topPos + -92, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_red.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_red", imagebutton_background_text_red);
		this.addRenderableWidget(imagebutton_background_text_red);
		imagebutton_background_text_orange = new ImageButton(this.leftPos + 8, this.topPos + 4, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_orange.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_orange", imagebutton_background_text_orange);
		this.addRenderableWidget(imagebutton_background_text_orange);
		imagebutton_background_text_green = new ImageButton(this.leftPos + -144, this.topPos + -92, 136, 16, 0, 0, 16, new ResourceLocation("lanternofthewoodlands:textures/screens/atlas/imagebutton_background_text_green.png"), 136, 32, e -> {
		});
		guistate.put("button:imagebutton_background_text_green", imagebutton_background_text_green);
		this.addRenderableWidget(imagebutton_background_text_green);
	}
}
