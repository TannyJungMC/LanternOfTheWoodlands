
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

import lotw.procedures.Spell2GUIreturnLevelNot3Procedure;
import lotw.procedures.Spell2GUIreturnLevel3Procedure;
import lotw.procedures.Spell2GUIreturnLevel2upProcedure;
import lotw.procedures.Spell2GUIreturnLevel1Procedure;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Spell2GUIpage2GuiWindow extends ContainerScreen<Spell2GUIpage2Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Spell2GUIpage2Gui.guistate;

	public Spell2GUIpage2GuiWindow(Spell2GUIpage2Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell_costs.png"));
		this.blit(ms, this.guiLeft + -231, this.guiTop + -108, 0, 0, 144, 181, 144, 181);

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
		this.font.drawString(ms, "Mana : [" + (int) (LotwModVariables.MapVariables.get(world).mana) + "/30]", -79, 76, -6710887);
		this.font.drawString(ms, "", 64, -88, -6750208);
		this.font.drawString(ms, "Entity Filter", 72, 24, -10092544);
		this.font.drawString(ms, "Buoy", -155, -12, -10092544);
		this.font.drawString(ms, "Tracker", -163, -64, -10092544);
		this.font.drawString(ms, "- Info", 72, -80, -6737152);
		this.font.drawString(ms, "- Entity", 72, -60, -6737152);
		this.font.drawString(ms, "- Player", 72, -40, -6737152);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell2_show_info) + "", 176, -80, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell2_show_entity) + "", 176, -60, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell2_show_player) + "", 176, -40, -6724096);
		if (Spell2GUIreturnLevel2upProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell2_findkey_list) + "", 92, 40, -6724096);
		this.font.drawString(ms, "Specify Positions", 72, -96, -10092544);
		this.font.drawString(ms, "- Tracker", 72, -20, -6737152);
		this.font.drawString(ms, "- Buoy", 72, 0, -6737152);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell2_show_tracker) + "", 176, -20, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell2_show_waypoint) + "", 176, 0, -6724096);
		if (Spell2GUIreturnLevel3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (int) (LotwModVariables.MapVariables.get(world).spell2_zoom) + "", -43, -80, -6724096);
		this.font.drawString(ms, "Scan Distance", -63, -96, -10092544);
		this.font.drawString(ms, "Radar Display Quarity", -63, -24, -10092544);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell2_scanner_quarity) + "", -43, -8, -6724096);
		this.font.drawString(ms, "Footstep", -63, 12, -10092544);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell2_footstep) + "", -43, 28, -6724096);
		this.font.drawString(ms, "Scan Speed and Details", -63, -60, -10092544);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell2_speed) + "", -43, -44, -6724096);
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
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + -32, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(0, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -175, this.guiTop + -44, 44, 20, new StringTextComponent("5 mana"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(1, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -175, this.guiTop + 8, 52, 20, new StringTextComponent("3 mana"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(2, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -123, this.guiTop + -44, 8, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(3, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -123, this.guiTop + 8, 8, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(4, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -131, this.guiTop + -44, 8, 20, new StringTextComponent("?"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(5, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + -84, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(6, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + -64, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(7, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + -44, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(8, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 92, this.guiTop + 36, 100, 20, new StringTextComponent("Unlock at Level 2"), e -> {
			if (Spell2GUIreturnLevel1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(9, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnLevel1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 80, this.guiTop + 36, 8, 20, new StringTextComponent("="), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(10, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + -24, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(11, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + -4, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(12, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 12, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + -84, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(13, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 13, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -55, this.guiTop + -84, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(14, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 14, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -43, this.guiTop + -84, 100, 20, new StringTextComponent("Unlock at Level 3"), e -> {
			if (Spell2GUIreturnLevelNot3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(15, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 15, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnLevelNot3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + -12, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(16, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 16, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -55, this.guiTop + -12, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(17, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 17, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + 24, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(18, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 18, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -55, this.guiTop + 24, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(19, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 19, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -43, this.guiTop + 24, 100, 20, new StringTextComponent("Unlock at Level 3"), e -> {
			if (Spell2GUIreturnLevelNot3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(20, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 20, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnLevelNot3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + -48, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(21, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 21, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -55, this.guiTop + -48, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(22, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 22, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + 36, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(23, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 23, x, y, z);
			}
		}));
	}
}
