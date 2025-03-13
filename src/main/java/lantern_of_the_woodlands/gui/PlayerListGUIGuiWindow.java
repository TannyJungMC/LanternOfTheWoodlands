
package lantern_of_the_woodlands.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PlayerListGUIGuiWindow extends ContainerScreen<PlayerListGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = PlayerListGUIGui.guistate;
	TextFieldWidget add_player_list;
	TextFieldWidget add_player_list2;
	TextFieldWidget add_player_list3;
	TextFieldWidget add_player_list4;

	public PlayerListGUIGuiWindow(PlayerListGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 0;
		this.ySize = 0;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		add_player_list.render(ms, mouseX, mouseY, partialTicks);
		add_player_list2.render(ms, mouseX, mouseY, partialTicks);
		add_player_list3.render(ms, mouseX, mouseY, partialTicks);
		add_player_list4.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/tph_book.png"));
		this.blit(ms, this.guiLeft + -79, this.guiTop + -112, 0, 0, 288, 186, 288, 186);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell2_1.png"));
		this.blit(ms, this.guiLeft + 64, this.guiTop + -8, 0, 0, 112, 48, 112, 48);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (add_player_list.isFocused())
			return add_player_list.keyPressed(key, b, c);
		if (add_player_list2.isFocused())
			return add_player_list2.keyPressed(key, b, c);
		if (add_player_list3.isFocused())
			return add_player_list3.keyPressed(key, b, c);
		if (add_player_list4.isFocused())
			return add_player_list4.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		add_player_list.tick();
		add_player_list2.tick();
		add_player_list3.tick();
		add_player_list4.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "ALLY LIST", -27, -96, -10079488);
		this.font.drawString(ms, "This list support target", 68, -96, -13421773);
		this.font.drawString(ms, "Ex : @a", 68, -64, -10092544);
		this.font.drawString(ms, "     @a[distance=..3]", 68, -52, -10092544);
		this.font.drawString(ms, "selector and player name", 68, -84, -13421773);
		this.font.drawString(ms, "     @e[type=villager]", 68, -28, -10092544);
		this.font.drawString(ms, "     TannyJung", 68, -16, -10092544);
		this.font.drawString(ms, "     @a[team=Red_Team]", 68, -40, -10092544);
		this.font.drawString(ms, "manually", -63, -84, -13421773);
		this.font.drawString(ms, "auto-set", -63, -48, -13421773);
		this.font.drawString(ms, "" + (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_remove) + "", -199, -100, -1);
		this.font.drawString(ms, "" + (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_water) + "", -207, -84, -1);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 40, this.guiTop + -72, 8, 20, new StringTextComponent("+"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(0, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		add_player_list = new TextFieldWidget(this.font, this.guiLeft + -63, this.guiTop + -72, 104, 20, new StringTextComponent(""));
		guistate.put("text:add_player_list", add_player_list);
		add_player_list.setMaxStringLength(32767);
		this.children.add(this.add_player_list);
		this.addButton(new Button(this.guiLeft + -35, this.guiTop + 36, 64, 20, new StringTextComponent("See List"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(1, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 48, this.guiTop + -72, 8, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(2, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + 72, 48, 20, new StringTextComponent("Back"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(3, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		add_player_list2 = new TextFieldWidget(this.font, this.guiLeft + -63, this.guiTop + -36, 120, 20, new StringTextComponent(""));
		guistate.put("text:add_player_list2", add_player_list2);
		add_player_list2.setMaxStringLength(32767);
		this.children.add(this.add_player_list2);
		add_player_list3 = new TextFieldWidget(this.font, this.guiLeft + -63, this.guiTop + -12, 120, 20, new StringTextComponent(""));
		guistate.put("text:add_player_list3", add_player_list3);
		add_player_list3.setMaxStringLength(32767);
		this.children.add(this.add_player_list3);
		add_player_list4 = new TextFieldWidget(this.font, this.guiLeft + -63, this.guiTop + 12, 120, 20, new StringTextComponent(""));
		guistate.put("text:add_player_list4", add_player_list4);
		add_player_list4.setMaxStringLength(32767);
		this.children.add(this.add_player_list4);
		this.addButton(new Button(this.guiLeft + 100, this.guiTop + 36, 64, 20, new StringTextComponent("Reset List"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(4, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}
