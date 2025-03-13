
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

import lotw.procedures.Spell7returnShowPosProcedure;
import lotw.procedures.Spell7returnShowOptionProcedure;
import lotw.procedures.Spell7returnShowKeyboardProcedure;
import lotw.procedures.Spell7returnShowKeyProcedure;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Spell7GUIGuiWindow extends ContainerScreen<Spell7GUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Spell7GUIGui.guistate;

	public Spell7GUIGuiWindow(Spell7GUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/paper_left.png"));
		this.blit(ms, this.guiLeft + -139, this.guiTop + -120, 0, 0, 288, 186, 288, 186);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/advance_spell7.png"));
		this.blit(ms, this.guiLeft + -123, this.guiTop + -108, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell7_image.png"));
		this.blit(ms, this.guiLeft + -119, this.guiTop + -16, 0, 0, 112, 48, 112, 48);

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
		this.font.drawString(ms, "Mana : [" + (int) (LotwModVariables.MapVariables.get(world).mana) + "/30]", 16, 76, -6710887);
		this.font.drawString(ms, "ENCANTAMIENTOS", -103, -104, -16777216);
		this.font.drawString(ms, "The spell of books.", -115, -88, -10079488);
		this.font.drawString(ms, "Generate an enchanted", -123, -76, -10079488);
		this.font.drawString(ms, "books, spell books and", -123, -64, -10079488);
		this.font.drawString(ms, "Cost : " + (int) (LotwModVariables.MapVariables.get(world).spell7_book_cost) + " mana", 8, -100, -6710887);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell7_type) + "", 8, -112, -3381505);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell7_generator1_id) + "", 20, -20, -3381760);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell7_generator1) + "", 20, -8, -3368704);
		this.font.drawString(ms, "Time Needed : " + (LotwModVariables.MapVariables.get(world).spell7_book_time_text) + "", 8, -88, -6710887);
		if (Spell7returnShowPosProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Pos" + (int) (LotwModVariables.MapVariables.get(world).spell7_book_number) + "", 96, -44, -6710887);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell7_generator2_id) + "", 20, 8, -3381760);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell7_generator3_id) + "", 20, 36, -3381760);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell7_generator2) + "", 20, 20, -3368704);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell7_generator3) + "", 20, 48, -3368704);
		this.font.drawString(ms, "manage enchantments", -123, -52, -10079488);
		this.font.drawString(ms, "in any items.", -123, -40, -10079488);
		if (Spell7returnShowOptionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell7_book_id) + "", 36, -68, -10053376);
		this.font.drawString(ms, "Overlay", -207, -88, -6710887);
		this.font.drawString(ms, "" + ((entity.getCapability(LotwModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LotwModVariables.PlayerVariables())).spell7_overlay) + "", -151, -88, -6724096);
		if (Spell7returnShowKeyProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Tab = Reset", -207, -40, -103);
		if (Spell7returnShowKeyProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "1 = Previous", -207, -28, -103);
		if (Spell7returnShowKeyProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "2 = Next", -207, -16, -103);
		if (Spell7returnShowKeyProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "3 = Select", -207, -4, -103);
		if (Spell7returnShowKeyProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "4 = Take", -207, 8, -103);
		if (Spell7returnShowKeyProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "5 = Use", -207, 20, -103);
		if (Spell7returnShowKeyProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "6 = Mode", -207, 32, -103);
		if (Spell7returnShowKeyProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Default Keys", -207, -56, -13210);
		if (Spell7returnShowKeyProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Z = Warp", -207, 44, -103);
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
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + 72, 48, 20, new StringTextComponent("Back"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(0, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + 72, 88, 20, new StringTextComponent("Cancel Spell"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(1, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 84, this.guiTop + -48, 8, 20, new StringTextComponent(">"), e -> {
			if (Spell7returnShowPosProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(2, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell7returnShowPosProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 8, this.guiTop + 36, 8, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(3, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 8, this.guiTop + 8, 8, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(4, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 8, this.guiTop + -20, 8, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(5, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 8, this.guiTop + -48, 56, 20, new StringTextComponent("Start"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(6, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 16, this.guiTop + -72, 8, 20, new StringTextComponent("R"), e -> {
			if (Spell7returnShowOptionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(7, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell7returnShowOptionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -163, this.guiTop + -92, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(8, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -116, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(9, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 68, this.guiTop + -48, 8, 20, new StringTextComponent("<"), e -> {
			if (Spell7returnShowPosProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(10, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 10, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell7returnShowPosProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -207, this.guiTop + -116, 76, 20, new StringTextComponent("Select Item"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(11, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 8, this.guiTop + -72, 8, 20, new StringTextComponent("<"), e -> {
			if (Spell7returnShowOptionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(12, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 12, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell7returnShowOptionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 24, this.guiTop + -72, 8, 20, new StringTextComponent(">"), e -> {
			if (Spell7returnShowOptionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(13, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 13, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell7returnShowOptionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -127, this.guiTop + 36, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(14, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 14, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 76, this.guiTop + -48, 8, 20, new StringTextComponent("#"), e -> {
			if (Spell7returnShowPosProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(15, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 15, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell7returnShowPosProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -72, 8, 20, new StringTextComponent("="), e -> {
			if (Spell7returnShowKeyboardProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(16, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 16, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell7returnShowKeyboardProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -127, this.guiTop + 16, 8, 20, new StringTextComponent("?"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell7GUIGui.ButtonPressedMessage(17, x, y, z));
				Spell7GUIGui.handleButtonAction(entity, 17, x, y, z);
			}
		}));
	}
}
