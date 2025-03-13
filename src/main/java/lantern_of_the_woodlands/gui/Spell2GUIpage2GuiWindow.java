
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

import lantern_of_the_woodlands.procedures.Spell2GUIfindKeyRepeatONProcedure;
import lantern_of_the_woodlands.procedures.Spell2GUIdisplayUnlockProcedure;
import lantern_of_the_woodlands.procedures.Spell2GUIdisplayNotUnlockProcedure;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

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
	TextFieldWidget spell2_find_key;

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
		spell2_find_key.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/tph_book.png"));
		this.blit(ms, this.guiLeft + -79, this.guiTop + -112, 0, 0, 288, 186, 288, 186);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell2_1.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -36, 0, 0, 112, 48, 112, 48);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/1_sunflower.png"));
		this.blit(ms, this.guiLeft + 88, this.guiTop + 40, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (spell2_find_key.isFocused())
			return spell2_find_key.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		spell2_find_key.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Mana : [ " + (LanternOfTheWoodlandsModVariables.MapVariables.get(world).mana) + " /15.0]", 16, 76, -6710887);
		this.font.drawString(ms, "", 64, -88, -6750208);
		this.font.drawString(ms, "Filter", -63, -92, -6737152);
		this.font.drawString(ms, "(id + selector)", -31, -92, -13421773);
		this.font.drawString(ms, "3", 128, -84, -13421773);
		this.font.drawString(ms, "mana", 120, -72, -13421773);
		if (Spell2GUIdisplayNotUnlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "15 mana", 16, -52, -13421773);
		this.font.drawString(ms, "Ex : iron_golem", -63, 12, -10092544);
		this.font.drawString(ms, "bee,limit=1,sort=nearest", -63, 48, -10092544);
		this.font.drawString(ms, "You can add selector", -55, 24, -13421773);
		this.font.drawString(ms, "after the id like this", -55, 36, -13421773);
		this.font.drawString(ms, "Buoy", 160, -96, -13421824);
		this.font.drawString(ms, "Tracker", 72, -96, -13421824);
		this.font.drawString(ms, "N", 160, -12, -6750208);
		this.font.drawString(ms, "Display", 80, 16, -10079488);
		this.font.drawString(ms, "Position", 76, 28, -10079488);
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
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(0, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + 72, 88, 20, new StringTextComponent("Cancel Spell"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(1, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + -32, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(2, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 68, this.guiTop + -84, 44, 20, new StringTextComponent("Get"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(3, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 148, this.guiTop + -84, 44, 20, new StringTextComponent("Get"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(4, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 68, this.guiTop + -60, 44, 20, new StringTextComponent("Remove"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(5, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 148, this.guiTop + -60, 44, 20, new StringTextComponent("Remove"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(6, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		spell2_find_key = new TextFieldWidget(this.font, this.guiLeft + -63, this.guiTop + -80, 120, 20, new StringTextComponent(""));
		guistate.put("text:spell2_find_key", spell2_find_key);
		spell2_find_key.setMaxStringLength(32767);
		this.children.add(this.spell2_find_key);
		this.addButton(new Button(this.guiLeft + 44, this.guiTop + -56, 12, 20, new StringTextComponent("-"), e -> {
			if (Spell2GUIfindKeyRepeatONProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(7, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIfindKeyRepeatONProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 32, this.guiTop + -56, 12, 20, new StringTextComponent("+"), e -> {
			if (Spell2GUIdisplayUnlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(8, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIdisplayUnlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + -56, 72, 20, new StringTextComponent("Unlock"), e -> {
			if (Spell2GUIdisplayNotUnlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(9, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIdisplayNotUnlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 68, this.guiTop + -36, 44, 20, new StringTextComponent("List"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(10, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 32, this.guiTop + -56, 12, 20, new StringTextComponent(" "), e -> {
			if (Spell2GUIfindKeyRepeatONProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(11, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 11, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIfindKeyRepeatONProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 44, this.guiTop + -56, 12, 20, new StringTextComponent(" "), e -> {
			if (Spell2GUIdisplayUnlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(12, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 12, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIdisplayUnlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 152, this.guiTop + 0, 20, 20, new StringTextComponent("^"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(13, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 13, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 132, this.guiTop + 20, 20, 20, new StringTextComponent("<"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(14, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 14, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 172, this.guiTop + 20, 20, 20, new StringTextComponent(">"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(15, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 15, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 152, this.guiTop + 40, 20, 20, new StringTextComponent("v"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(16, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 16, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 152, this.guiTop + 20, 20, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(17, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 17, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 132, this.guiTop + 40, 20, 20, new StringTextComponent("+"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(18, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 18, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 172, this.guiTop + 40, 20, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIpage2Gui.ButtonPressedMessage(19, x, y, z));
				Spell2GUIpage2Gui.handleButtonAction(entity, 19, x, y, z);
			}
		}));
	}
}
