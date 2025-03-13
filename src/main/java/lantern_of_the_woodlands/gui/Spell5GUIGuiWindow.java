
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
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import lantern_of_the_woodlands.procedures.Spell5checkShowTrapProcedure;
import lantern_of_the_woodlands.procedures.Spell5checkPauseTrueProcedure;
import lantern_of_the_woodlands.procedures.Spell5checkPauseFALSEProcedure;
import lantern_of_the_woodlands.procedures.Spell5checkAlwayGenTRUEProcedure;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Spell5GUIGuiWindow extends ContainerScreen<Spell5GUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Spell5GUIGui.guistate;
	TextFieldWidget spell5_radius;
	TextFieldWidget spell5_circle;
	TextFieldWidget spell5_height;
	TextFieldWidget spell5_thickness;
	TextFieldWidget spell5_room;
	TextFieldWidget spell5_no_wall;
	TextFieldWidget spell5_trap;
	TextFieldWidget spell5_safe_zone;
	TextFieldWidget spell5_degree;
	TextFieldWidget spell5_down;
	CheckboxButton spell5_always_gen;
	CheckboxButton spell5_show_trap;

	public Spell5GUIGuiWindow(Spell5GUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		spell5_radius.render(ms, mouseX, mouseY, partialTicks);
		spell5_circle.render(ms, mouseX, mouseY, partialTicks);
		spell5_height.render(ms, mouseX, mouseY, partialTicks);
		spell5_thickness.render(ms, mouseX, mouseY, partialTicks);
		spell5_room.render(ms, mouseX, mouseY, partialTicks);
		spell5_no_wall.render(ms, mouseX, mouseY, partialTicks);
		spell5_trap.render(ms, mouseX, mouseY, partialTicks);
		spell5_safe_zone.render(ms, mouseX, mouseY, partialTicks);
		spell5_degree.render(ms, mouseX, mouseY, partialTicks);
		spell5_down.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/tph_book.png"));
		this.blit(ms, this.guiLeft + -79, this.guiTop + -112, 0, 0, 288, 186, 288, 186);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell2.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell5.png"));
		this.blit(ms, this.guiLeft + -83, this.guiTop + -108, 0, 0, 160, 160, 160, 160);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (spell5_radius.isFocused())
			return spell5_radius.keyPressed(key, b, c);
		if (spell5_circle.isFocused())
			return spell5_circle.keyPressed(key, b, c);
		if (spell5_height.isFocused())
			return spell5_height.keyPressed(key, b, c);
		if (spell5_thickness.isFocused())
			return spell5_thickness.keyPressed(key, b, c);
		if (spell5_room.isFocused())
			return spell5_room.keyPressed(key, b, c);
		if (spell5_no_wall.isFocused())
			return spell5_no_wall.keyPressed(key, b, c);
		if (spell5_trap.isFocused())
			return spell5_trap.keyPressed(key, b, c);
		if (spell5_safe_zone.isFocused())
			return spell5_safe_zone.keyPressed(key, b, c);
		if (spell5_degree.isFocused())
			return spell5_degree.keyPressed(key, b, c);
		if (spell5_down.isFocused())
			return spell5_down.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		spell5_radius.tick();
		spell5_circle.tick();
		spell5_height.tick();
		spell5_thickness.tick();
		spell5_room.tick();
		spell5_no_wall.tick();
		spell5_trap.tick();
		spell5_safe_zone.tick();
		spell5_degree.tick();
		spell5_down.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Mana : [ " + (LanternOfTheWoodlandsModVariables.MapVariables.get(world).mana) + " /15.0]", 16, 76, -6710887);
		this.font.drawString(ms, "", 64, -88, -6750208);
		this.font.drawString(ms, "Lost in Reality", -43, -92, -16777216);
		this.font.drawString(ms, "around lantern. Use it", -63, -52, -10079488);
		this.font.drawString(ms, "The spell of security,", -55, -76, -10079488);
		this.font.drawString(ms, "created the circle maze", -63, -64, -10079488);
		this.font.drawString(ms, "Radius/Safe Zone/Circle", 68, -96, -10092544);
		this.font.drawString(ms, "Degree/Down/Height", 68, -60, -10092544);
		this.font.drawString(ms, "Thickness/Room/No Wall", 68, -24, -10092544);
		this.font.drawString(ms, "Trap", 68, 12, -10092544);
		this.font.drawString(ms, "Presets", -207, -112, -26368);
		this.font.drawString(ms, "- Giant Wall", -195, 4, -1);
		this.font.drawString(ms, "- Maze Runner", -195, -16, -1);
		this.font.drawString(ms, "- Default", -195, -96, -1);
		this.font.drawString(ms, "- 2 Teams", -195, 24, -1);
		this.font.drawString(ms, "- Complex", -195, -36, -1);
		this.font.drawString(ms, "- Lite", -195, -76, -1);
		this.font.drawString(ms, "- Medium", -195, -56, -1);
		this.font.drawString(ms, "- Landmine", -195, 44, -1);
		this.font.drawString(ms, "carefully.", -63, -40, -10079488);
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
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(0, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + 72, 88, 20, new StringTextComponent("Cancel Spell"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(1, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		spell5_radius = new TextFieldWidget(this.font, this.guiLeft + 68, this.guiTop + -84, 52, 20, new StringTextComponent("1 - 300")) {
			{
				setSuggestion("1 - 300");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("1 - 300");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("1 - 300");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:spell5_radius", spell5_radius);
		spell5_radius.setMaxStringLength(32767);
		this.children.add(this.spell5_radius);
		spell5_circle = new TextFieldWidget(this.font, this.guiLeft + 156, this.guiTop + -84, 36, 20, new StringTextComponent("1+")) {
			{
				setSuggestion("1+");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("1+");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("1+");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:spell5_circle", spell5_circle);
		spell5_circle.setMaxStringLength(32767);
		this.children.add(this.spell5_circle);
		spell5_height = new TextFieldWidget(this.font, this.guiLeft + 156, this.guiTop + -48, 36, 20, new StringTextComponent(""));
		guistate.put("text:spell5_height", spell5_height);
		spell5_height.setMaxStringLength(32767);
		this.children.add(this.spell5_height);
		spell5_thickness = new TextFieldWidget(this.font, this.guiLeft + 68, this.guiTop + -12, 36, 20, new StringTextComponent(""));
		guistate.put("text:spell5_thickness", spell5_thickness);
		spell5_thickness.setMaxStringLength(32767);
		this.children.add(this.spell5_thickness);
		spell5_room = new TextFieldWidget(this.font, this.guiLeft + 104, this.guiTop + -12, 44, 20, new StringTextComponent("0 - 100")) {
			{
				setSuggestion("0 - 100");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("0 - 100");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("0 - 100");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:spell5_room", spell5_room);
		spell5_room.setMaxStringLength(32767);
		this.children.add(this.spell5_room);
		this.addButton(new Button(this.guiLeft + 124, this.guiTop + 24, 36, 20, new StringTextComponent("Save"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(2, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		spell5_no_wall = new TextFieldWidget(this.font, this.guiLeft + 148, this.guiTop + -12, 44, 20, new StringTextComponent("0 - 100")) {
			{
				setSuggestion("0 - 100");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("0 - 100");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("0 - 100");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:spell5_no_wall", spell5_no_wall);
		spell5_no_wall.setMaxStringLength(32767);
		this.children.add(this.spell5_no_wall);
		spell5_trap = new TextFieldWidget(this.font, this.guiLeft + 68, this.guiTop + 24, 52, 20, new StringTextComponent("0 - 100")) {
			{
				setSuggestion("0 - 100");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("0 - 100");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("0 - 100");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:spell5_trap", spell5_trap);
		spell5_trap.setMaxStringLength(32767);
		this.children.add(this.spell5_trap);
		spell5_safe_zone = new TextFieldWidget(this.font, this.guiLeft + 120, this.guiTop + -84, 36, 20, new StringTextComponent(""));
		guistate.put("text:spell5_safe_zone", spell5_safe_zone);
		spell5_safe_zone.setMaxStringLength(32767);
		this.children.add(this.spell5_safe_zone);
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + 36, 52, 20, new StringTextComponent("Start"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(3, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + 36, 52, 20, new StringTextComponent("Remove"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(4, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -107, this.guiTop + -20, 24, 20, new StringTextComponent("Use"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(5, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -107, this.guiTop + 0, 24, 20, new StringTextComponent("Use"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(6, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -107, this.guiTop + -100, 24, 20, new StringTextComponent("Use"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(7, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		spell5_degree = new TextFieldWidget(this.font, this.guiLeft + 68, this.guiTop + -48, 52, 20, new StringTextComponent("360/x")) {
			{
				setSuggestion("360/x");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("360/x");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("360/x");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:spell5_degree", spell5_degree);
		spell5_degree.setMaxStringLength(32767);
		this.children.add(this.spell5_degree);
		spell5_down = new TextFieldWidget(this.font, this.guiLeft + 120, this.guiTop + -48, 36, 20, new StringTextComponent(""));
		guistate.put("text:spell5_down", spell5_down);
		spell5_down.setMaxStringLength(32767);
		this.children.add(this.spell5_down);
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + 24, 32, 20, new StringTextComponent("Clear"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(8, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -107, this.guiTop + -40, 24, 20, new StringTextComponent("Use"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(9, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -107, this.guiTop + 20, 24, 20, new StringTextComponent("Use"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(10, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		spell5_always_gen = new CheckboxButton(this.guiLeft + -207, this.guiTop + 64, 20, 20, new StringTextComponent("Always Update"),

				Spell5checkAlwayGenTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell5GUIGui.guistate.put("checkbox:spell5_always_gen", spell5_always_gen);
		this.addButton(spell5_always_gen);
		this.addButton(new Button(this.guiLeft + -107, this.guiTop + -80, 24, 20, new StringTextComponent("Use"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(11, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -107, this.guiTop + -60, 24, 20, new StringTextComponent("Use"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(12, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 12, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -107, this.guiTop + 40, 24, 20, new StringTextComponent("Use"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(13, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 13, x, y, z);
			}
		}));
		spell5_show_trap = new CheckboxButton(this.guiLeft + -207, this.guiTop + 88, 20, 20, new StringTextComponent("Show Trap"),

				Spell5checkShowTrapProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell5GUIGui.guistate.put("checkbox:spell5_show_trap", spell5_show_trap);
		this.addButton(spell5_show_trap);
		this.addButton(new Button(this.guiLeft + 44, this.guiTop + 36, 8, 20, new StringTextComponent("="), e -> {
			if (Spell5checkPauseFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(14, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 14, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell5checkPauseFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 52, this.guiTop + 36, 8, 20, new StringTextComponent(">"), e -> {
			if (Spell5checkPauseTrueProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(15, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 15, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell5checkPauseTrueProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 44, this.guiTop + 36, 8, 20, new StringTextComponent(" "), e -> {
			if (Spell5checkPauseTrueProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(16, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 16, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell5checkPauseTrueProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 52, this.guiTop + 36, 8, 20, new StringTextComponent(" "), e -> {
			if (Spell5checkPauseFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell5GUIGui.ButtonPressedMessage(17, x, y, z));
				Spell5GUIGui.handleButtonAction(entity, 17, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell5checkPauseFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
