
package lotw.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import lotw.procedures.ReturnLanternGoundTRUEProcedure;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PlayerListGUIGuiWindow extends ContainerScreen<PlayerListGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = PlayerListGUIGui.guistate;

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
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/tph_book.png"));
		this.blit(ms, this.guiLeft + -79, this.guiTop + -112, 0, 0, 288, 186, 288, 186);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/ally_list.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell2_1.png"));
		this.blit(ms, this.guiLeft + -67, this.guiTop + -20, 0, 0, 112, 48, 112, 48);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "SUPPORTER", -43, -92, -16777216);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).player_list_manual) + "", 92, 44, -6724096);
		this.font.drawString(ms, "Add player or entity", -55, -76, -10079488);
		this.font.drawString(ms, "to ally list. They can", -63, -64, -10079488);
		this.font.drawString(ms, "get support and will", -63, -52, -10079488);
		this.font.drawString(ms, "not get most bad effects", -63, -40, -10079488);
		this.font.drawString(ms, "Manually", 72, 28, -10092544);
		this.font.drawString(ms, "Auto List", 72, -96, -10092544);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).ally_list_auto1) + "", 92, -80, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).ally_list_auto2) + "", 92, -60, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).ally_list_auto3) + "", 92, -40, -6724096);
		this.font.drawString(ms, "Chat Setting", -63, 28, -10092544);
		this.font.drawString(ms, "from the magic.", -63, -28, -10079488);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).ally_list_chat) + "", -51, 44, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).ally_list_auto4) + "", 92, -20, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).ally_list_auto5) + "", 92, 0, -6724096);
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
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -104, 8, 20, new StringTextComponent("?"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(0, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + 44, 8, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(1, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + 72, 48, 20, new StringTextComponent("Close"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(2, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -84, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(3, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + -32, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(4, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -32, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(5, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + -104, 8, 20, new StringTextComponent("{"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(6, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 112, this.guiTop + 72, 48, 20, new StringTextComponent("Back"), e -> {
			if (ReturnLanternGoundTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(7, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (ReturnLanternGoundTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + 24, 8, 20, new StringTextComponent("+"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(8, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 80, this.guiTop + -84, 8, 20, new StringTextComponent("="), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(9, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 80, this.guiTop + -64, 8, 20, new StringTextComponent("="), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(10, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 80, this.guiTop + -44, 8, 20, new StringTextComponent("="), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(11, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + -84, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(12, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 12, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + -64, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(13, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 13, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + -44, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(14, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 14, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + 40, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(15, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 15, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + -24, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(16, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 16, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + -4, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(17, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 17, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 80, this.guiTop + -24, 8, 20, new StringTextComponent("="), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(18, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 18, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 80, this.guiTop + -4, 8, 20, new StringTextComponent("="), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(19, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 19, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 80, this.guiTop + 40, 8, 20, new StringTextComponent("="), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(20, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 20, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + 40, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new PlayerListGUIGui.ButtonPressedMessage(21, x, y, z));
				PlayerListGUIGui.handleButtonAction(entity, 21, x, y, z);
			}
		}));
	}
}
