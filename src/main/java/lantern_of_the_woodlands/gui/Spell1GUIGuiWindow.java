
package lantern_of_the_woodlands.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import lantern_of_the_woodlands.procedures.Spell1checkboxspecifystationProcedure;
import lantern_of_the_woodlands.procedures.Spell1checkboxinvisiblestationProcedure;
import lantern_of_the_woodlands.procedures.Spell1checkboxLanternStationProcedure;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Spell1GUIGuiWindow extends ContainerScreen<Spell1GUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Spell1GUIGui.guistate;
	CheckboxButton spell1specify_position;
	CheckboxButton spell1invisible_station;
	CheckboxButton spell1latern_station;

	public Spell1GUIGuiWindow(Spell1GUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/tph_book.png"));
		this.blit(ms, this.guiLeft + -79, this.guiTop + -112, 0, 0, 288, 186, 288, 186);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell3.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell1station_image.png"));
		this.blit(ms, this.guiLeft + -55, this.guiTop + -32, 0, 0, 112, 48, 112, 48);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell1image.png"));
		this.blit(ms, this.guiLeft + 48, this.guiTop + -120, 0, 0, 160, 160, 160, 160);

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
		this.font.drawString(ms, "Mana : [ " + (LanternOfTheWoodlandsModVariables.MapVariables.get(world).mana) + " /15.0]", 16, 76, -6710887);
		this.font.drawString(ms, "Zodiacs", -43, -92, -16777216);
		this.font.drawString(ms, "1 mana", -59, 48, -10092544);
		this.font.drawString(ms, "7 mana", -19, 48, -10092544);
		this.font.drawString(ms, "15 mana", 16, 48, -10092544);
		this.font.drawString(ms, "The magic circle that", -55, -76, -10079488);
		this.font.drawString(ms, "give you and your team", -63, -64, -10079488);
		this.font.drawString(ms, "good effects.", -63, -52, -10079488);
		this.font.drawString(ms, "Active Count : " + (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_station_count) + "", 68, 48,
				-13421773);
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
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + 72, 48, 20, new StringTextComponent("Close"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(0, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + 72, 88, 20, new StringTextComponent("Cancel Spell"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(1, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + 24, 40, 20, new StringTextComponent("Small"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(2, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 68, this.guiTop + 24, 68, 20, new StringTextComponent("Remove All"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(3, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		spell1specify_position = new CheckboxButton(this.guiLeft + -207, this.guiTop + -64, 20, 20, new StringTextComponent("Specify Position"),

				Spell1checkboxspecifystationProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIGui.guistate.put("checkbox:spell1specify_position", spell1specify_position);
		this.addButton(spell1specify_position);
		spell1invisible_station = new CheckboxButton(this.guiLeft + -207, this.guiTop + -88, 20, 20, new StringTextComponent("Invisible Station"),

				Spell1checkboxinvisiblestationProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIGui.guistate.put("checkbox:spell1invisible_station", spell1invisible_station);
		this.addButton(spell1invisible_station);
		this.addButton(new Button(this.guiLeft + -23, this.guiTop + 24, 40, 20, new StringTextComponent("Medium"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(4, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 16, this.guiTop + 24, 40, 20, new StringTextComponent("Large"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(5, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		spell1latern_station = new CheckboxButton(this.guiLeft + -207, this.guiTop + -112, 20, 20, new StringTextComponent("Lantern Station"),

				Spell1checkboxLanternStationProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIGui.guistate.put("checkbox:spell1latern_station", spell1latern_station);
		this.addButton(spell1latern_station);
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -32, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(6, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
	}
}
