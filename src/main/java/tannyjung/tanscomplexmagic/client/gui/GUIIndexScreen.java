package tannyjung.tanscomplexmagic.client.gui;

import tannyjung.tanscomplexmagic.world.inventory.GUIIndexMenu;
import tannyjung.tanscomplexmagic.procedures.*;
import tannyjung.tanscomplexmagic.network.GUIIndexButtonMessage;
import tannyjung.tanscomplexmagic.init.TanscomplexmagicModScreens;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;

public class GUIIndexScreen extends AbstractContainerScreen<GUIIndexMenu> implements TanscomplexmagicModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox xxxddd;
	private Button button_set_role;
	private ImageButton imagebutton_gui_component_close;
	private ImageButton imagebutton_gui_component_page_previous;
	private ImageButton imagebutton_gui_component_page_next;
	private ImageButton imagebutton_gui_component_shortcut_home;
	private ImageButton imagebutton_gui_component_shortcut_custom;
	private ImageButton imagebutton_gui_component_shortcut_custom_set;
	private ImageButton imagebutton_gui_component_shortcut_ally_list;
	private ImageButton imagebutton_gui_component_shortcut_basic_spell;
	private ImageButton imagebutton_gui_component_shortcut_spell_contr;
	private ImageButton imagebutton_gui_component_log_type_set;
	private ImageButton imagebutton_gui_component_compass_custom_set;
	private ImageButton imagebutton_gui_component_line;
	private ImageButton imagebutton_gui_component_line2;
	private ImageButton imagebutton_gui_component_line21;
	private ImageButton imagebutton_gui_component_line23;

	public GUIIndexScreen(GUIIndexMenu container, Inventory inventory, Component text) {
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
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("xxxddd"))
				xxxddd.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_index.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		xxxddd.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_background.png"), this.leftPos + -200, this.topPos + -120, 0, 0, 400, 240, 400, 240);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_mana_bar.png"), this.leftPos + 195, this.topPos + -108, Mth.clamp((int) GUIManaProcedure.execute(entity) * 1, 0, 150), 0, 1, 150, 151, 150);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_mana_bar_charge.png"), this.leftPos + 195, this.topPos + 46, Mth.clamp((int) GUIManaChargeProcedure.execute(entity) * 1, 0, 60), 0, 1, 60, 61, 60);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_log_type.png"), this.leftPos + 6, this.topPos + 110, Mth.clamp((int) GUILogTypeProcedure.execute(entity) * 7, 0, 21), 0, 7, 7, 28, 7);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_clock.png"), this.leftPos + -189, this.topPos + 110, Mth.clamp((int) GUIClockProcedure.execute(world) * 7, 0, 161), 0, 7, 7, 168, 7);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_compass.png"), this.leftPos + -181, this.topPos + 110, Mth.clamp((int) GUICompassProcedure.execute(entity) * 7, 0, 49), 0, 7, 7, 56, 7);
		guiGraphics.blit(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_compass_custom.png"), this.leftPos + -173, this.topPos + 110, Mth.clamp((int) GUICompassCustomProcedure.execute(entity) * 7, 0, 49), 0, 7, 7, 56, 7);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (xxxddd.isFocused())
			return xxxddd.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String xxxdddValue = xxxddd.getValue();
		super.resize(minecraft, width, height);
		xxxddd.setValue(xxxdddValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, GUIPageNumberLeftProcedure.execute(entity), -170, 98, -4017518, false);
		guiGraphics.drawString(this.font, GUIPageNumberRightProcedure.execute(entity), 156, 98, -4017518, false);
		guiGraphics.drawString(this.font, GUILogProcedure.execute(entity), 16, 109, -3368704, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_index.label_index"), -180, -104, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_index.label_001"), -28, -68, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_index.label_003"), -28, -58, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_index.label_from_creator"), -168, -68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_index.label_registration"), -168, -58, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_index.label_ally_list"), -168, -48, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_index.label_005"), -28, -48, -6710887, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.tanscomplexmagic.gui_index.label_menu1"), -180, -84, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		xxxddd = new EditBox(this.font, this.leftPos + 41, this.topPos + -31, 118, 18, Component.translatable("gui.tanscomplexmagic.gui_index.xxxddd"));
		xxxddd.setMaxLength(8192);
		xxxddd.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "xxxddd", content, false);
		});
		this.addWidget(this.xxxddd);
		button_set_role = Button.builder(Component.translatable("gui.tanscomplexmagic.gui_index.button_set_role"), e -> {
			int x = GUIIndexScreen.this.x;
			int y = GUIIndexScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new GUIIndexButtonMessage(0, x, y, z));
				GUIIndexButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -128, this.topPos + 24, 66, 20).build();
		this.addRenderableWidget(button_set_role);
		imagebutton_gui_component_close = new ImageButton(this.leftPos + 204, this.topPos + 112, 8, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_close.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_close_hovered.png")), e -> {
					int x = GUIIndexScreen.this.x;
					int y = GUIIndexScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIIndexButtonMessage(1, x, y, z));
						GUIIndexButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_close);
		imagebutton_gui_component_page_previous = new ImageButton(this.leftPos + -188, this.topPos + 92, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_page_previous.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_page_previous_hovered.png")), e -> {
					int x = GUIIndexScreen.this.x;
					int y = GUIIndexScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIIndexButtonMessage(2, x, y, z));
						GUIIndexButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_page_previous);
		imagebutton_gui_component_page_next = new ImageButton(this.leftPos + 172, this.topPos + 92, 16, 16,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_page_next.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_page_next_hovered.png")), e -> {
					int x = GUIIndexScreen.this.x;
					int y = GUIIndexScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIIndexButtonMessage(3, x, y, z));
						GUIIndexButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_page_next);
		imagebutton_gui_component_shortcut_home = new ImageButton(this.leftPos + -212, this.topPos + -108, 21, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_home.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_home_hovered.png")), e -> {
					int x = GUIIndexScreen.this.x;
					int y = GUIIndexScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIIndexButtonMessage(4, x, y, z));
						GUIIndexButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_shortcut_home);
		imagebutton_gui_component_shortcut_custom = new ImageButton(this.leftPos + -212, this.topPos + -96, 21, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_custom.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_custom_hovered.png")), e -> {
					int x = GUIIndexScreen.this.x;
					int y = GUIIndexScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIIndexButtonMessage(5, x, y, z));
						GUIIndexButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_shortcut_custom);
		imagebutton_gui_component_shortcut_custom_set = new ImageButton(this.leftPos + -197, this.topPos + -87, 4, 4,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_custom_set.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_custom_set_hovered.png")), e -> {
					int x = GUIIndexScreen.this.x;
					int y = GUIIndexScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIIndexButtonMessage(6, x, y, z));
						GUIIndexButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_shortcut_custom_set);
		imagebutton_gui_component_shortcut_ally_list = new ImageButton(this.leftPos + -212, this.topPos + -72, 21, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_ally_list.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_ally_list_hovered.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_shortcut_ally_list);
		imagebutton_gui_component_shortcut_basic_spell = new ImageButton(this.leftPos + -212, this.topPos + -60, 21, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_basic_spells.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_basic_spells_hovered.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_shortcut_basic_spell);
		imagebutton_gui_component_shortcut_spell_contr = new ImageButton(this.leftPos + -212, this.topPos + -48, 21, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_spell_control.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_shortcut_spell_control_hovered.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_shortcut_spell_contr);
		imagebutton_gui_component_log_type_set = new ImageButton(this.leftPos + 6, this.topPos + 110, 7, 7,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_log_type_set.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_log_type_set_hovered.png")), e -> {
					int x = GUIIndexScreen.this.x;
					int y = GUIIndexScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIIndexButtonMessage(10, x, y, z));
						GUIIndexButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_log_type_set);
		imagebutton_gui_component_compass_custom_set = new ImageButton(this.leftPos + -164, this.topPos + 112, 3, 3,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_compass_custom_set.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_compass_custom_set_hovered.png")), e -> {
					int x = GUIIndexScreen.this.x;
					int y = GUIIndexScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GUIIndexButtonMessage(11, x, y, z));
						GUIIndexButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_compass_custom_set);
		imagebutton_gui_component_line = new ImageButton(this.leftPos + -180, this.topPos + -96, 168, 8,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_line.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_line.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_line);
		imagebutton_gui_component_line2 = new ImageButton(this.leftPos + -180, this.topPos + -72, 8, 10,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_line2.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_line2.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_line2);
		imagebutton_gui_component_line21 = new ImageButton(this.leftPos + -180, this.topPos + -62, 8, 10,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_line2.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_line2.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_line21);
		imagebutton_gui_component_line23 = new ImageButton(this.leftPos + -180, this.topPos + -52, 8, 10,
				new WidgetSprites(ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_line2.png"), ResourceLocation.parse("tanscomplexmagic:textures/screens/gui_component_line2.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_gui_component_line23);
	}
}