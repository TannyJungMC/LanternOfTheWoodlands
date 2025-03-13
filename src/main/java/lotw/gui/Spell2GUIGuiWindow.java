
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
import lotw.procedures.Spell2GUIreturnLevel2Procedure;
import lotw.procedures.Spell2GUIreturnLevel1Procedure;
import lotw.procedures.Spell2GUIreturnCustomOnProcedure;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Spell2GUIGuiWindow extends ContainerScreen<Spell2GUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Spell2GUIGui.guistate;

	public Spell2GUIGuiWindow(Spell2GUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell10.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/fireball_gold.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -28, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/fireball_green.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -16, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/fireball_white.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -4, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/fireball_blue.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + 8, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/fireball_red.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + 20, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/fireball_purple.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + 32, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/ring_white.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + 44, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell2zone.png"));
		this.blit(ms, this.guiLeft + 32, this.guiTop + -128, 0, 0, 160, 160, 160, 160);

		if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell_costs.png"));
			this.blit(ms, this.guiLeft + -231, this.guiTop + -108, 0, 0, 144, 181, 144, 181);
		}
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
		this.font.drawString(ms, "PHAROS OF THE SKY", -43, -92, -16777216);
		this.font.drawString(ms, "", 64, -88, -6750208);
		this.font.drawString(ms, "Entity", -43, 0, -6737152);
		this.font.drawString(ms, "Tracker", -43, 48, -6737152);
		this.font.drawString(ms, "Lantern", -43, -24, -6737152);
		this.font.drawString(ms, "You", -43, -12, -6737152);
		this.font.drawString(ms, "Ally", -43, 12, -6737152);
		this.font.drawString(ms, "Enemy", -43, 24, -6737152);
		this.font.drawString(ms, "Buoy", -43, 36, -6737152);
		this.font.drawString(ms, "The spell of detection.", -55, -76, -10079488);
		this.font.drawString(ms, "Create a hologram map of", -63, -64, -10079488);
		this.font.drawString(ms, "in the nebula.", -63, -40, -10079488);
		if (Spell2GUIreturnLevel1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Level 1/3", 4, 36, -6724096);
		if (Spell2GUIreturnLevel2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Level 2/3", 4, 36, -6724096);
		if (Spell2GUIreturnLevelNot3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Upgrade", 12, 0, -10092544);
		if (Spell2GUIreturnLevelNot3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Level", 16, -12, -10092544);
		this.font.drawString(ms, "Notifications", 72, -16, -10092544);
		this.font.drawString(ms, "- Tracker", 72, 4, -6737152);
		this.font.drawString(ms, "- Enemy", 72, 24, -6737152);
		this.font.drawString(ms, "- Buoy", 72, 44, -6737152);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell2_notification_tracker) + "", 176, 4, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell2_notification_other_team) + "", 176, 24, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell2_notification_buoy) + "", 176, 44, -6724096);
		this.font.drawString(ms, "entities like the stars", -63, -52, -10079488);
		if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Display", -163, -96, -10092544);
		if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Position", -167, -84, -10092544);
		if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Display Size", -183, 24, -10092544);
		if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell2_size) + "", -163, 40, -6724096);
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
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(0, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + 72, 88, 20, new StringTextComponent("Cancel Spell"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(1, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -32, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(2, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 4, this.guiTop + 12, 48, 20, new StringTextComponent("20 mana"), e -> {
			if (Spell2GUIreturnLevelNot3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(3, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnLevelNot3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + 40, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(4, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + 20, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(5, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + 0, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(6, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -155, this.guiTop + -60, 20, 20, new StringTextComponent("N"), e -> {
			if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(7, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -179, this.guiTop + -36, 20, 20, new StringTextComponent("W"), e -> {
			if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(8, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -131, this.guiTop + -36, 20, 20, new StringTextComponent("E"), e -> {
			if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(9, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -155, this.guiTop + -12, 20, 20, new StringTextComponent("S"), e -> {
			if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(10, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 10, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -167, this.guiTop + -12, 8, 20, new StringTextComponent("U"), e -> {
			if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(11, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 11, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -131, this.guiTop + -12, 8, 20, new StringTextComponent("D"), e -> {
			if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(12, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 12, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -155, this.guiTop + -36, 20, 20, new StringTextComponent("R"), e -> {
			if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(13, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 13, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + -104, 8, 20, new StringTextComponent("+"), e -> {
			if (Spell2GUIreturnLevel3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(14, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 14, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnLevel3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -183, this.guiTop + 36, 8, 20, new StringTextComponent("R"), e -> {
			if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(15, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 15, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -175, this.guiTop + 36, 8, 20, new StringTextComponent("#"), e -> {
			if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(16, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 16, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUIreturnCustomOnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
