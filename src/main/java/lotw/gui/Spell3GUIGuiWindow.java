
package lotw.gui;

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

import lotw.procedures.Spell3walkTRUEProcedure;
import lotw.procedures.Spell3startTRUEProcedure;
import lotw.procedures.Spell3startPauseTRUEProcedure;
import lotw.procedures.Spell3startPauseFALSEProcedure;
import lotw.procedures.Spell3startFALSEProcedure;
import lotw.procedures.Spell3speedNot16Procedure;
import lotw.procedures.Spell3speed8Procedure;
import lotw.procedures.Spell3speed4Procedure;
import lotw.procedures.Spell3speed2Procedure;
import lotw.procedures.Spell3speed1Procedure;
import lotw.procedures.Spell3removeINStrueProcedure;
import lotw.procedures.Spell3removeINSfalseProcedure;
import lotw.procedures.Spell3noDomeTRUEProcedure;
import lotw.procedures.Spell3invisibleDomeTRUEProcedure;
import lotw.procedures.Spell3genTRUEProcedure;
import lotw.procedures.Spell3genFALSEProcedure;
import lotw.procedures.Spell3domeParticleTRUEProcedure;
import lotw.procedures.Spell3blockDamageTRUEProcedure;
import lotw.procedures.Spell3blockArrowTRUEProcedure;
import lotw.procedures.Spell3GUIcheckParticleProcedure;
import lotw.procedures.Spell3CancelFULLtextProcedure;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Spell3GUIGuiWindow extends ContainerScreen<Spell3GUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Spell3GUIGui.guistate;
	TextFieldWidget spell3_radius;
	CheckboxButton spell3_particle;
	CheckboxButton spell3_walk;
	CheckboxButton spell3_invisible_dome;
	CheckboxButton spell3_no_block;
	CheckboxButton spell3_particle_dome;
	CheckboxButton spell3_block_arrow;
	CheckboxButton spell3_block_damage;

	public Spell3GUIGuiWindow(Spell3GUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		spell3_radius.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/tph_book.png"));
		this.blit(ms, this.guiLeft + -79, this.guiTop + -112, 0, 0, 288, 186, 288, 186);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell3dome.png"));
		this.blit(ms, this.guiLeft + -83, this.guiTop + -92, 0, 0, 160, 160, 160, 160);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell3dome2.png"));
		this.blit(ms, this.guiLeft + 88, this.guiTop + -96, 0, 0, 80, 80, 80, 80);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell9.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (spell3_radius.isFocused())
			return spell3_radius.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		spell3_radius.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Mana : [" + (int) (LotwModVariables.MapVariables.get(world).mana) + "/30]", 16, 76, -6710887);
		this.font.drawString(ms, "", 64, -88, -6750208);
		this.font.drawString(ms, "BIOSPHERE", -43, -92, -16777216);
		this.font.drawString(ms, "that can repair itself", -63, -52, -10079488);
		this.font.drawString(ms, "The spell of barrier,", -55, -76, -10079488);
		this.font.drawString(ms, "create a glass bubble", -63, -64, -10079488);
		this.font.drawString(ms, "from explosive force", -63, -40, -10079488);
		this.font.drawString(ms, "and any damages.", -63, -28, -10079488);
		this.font.drawString(ms, "Radius (even number)", 80, -48, -10092544);
		if (Spell3removeINSfalseProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell3_show_percent_status) + " - "
					+ (LotwModVariables.MapVariables.get(world).spell3_show_percent) + "%", 72, 12, -6724096);
		if (Spell3removeINSfalseProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Time Left - " + (LotwModVariables.MapVariables.get(world).spell3_show_time) + "", 72, 24, -6724096);
		if (Spell3speed1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "x2 speed", 128, 44, -6724096);
		if (Spell3speed2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "x4 speed", 128, 44, -6724096);
		if (Spell3speed4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "x8 speed", 128, 44, -6724096);
		if (Spell3speed8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "x16 speed", 128, 44, -6724096);
		if (Spell3CancelFULLtextProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Instant Cancel Spell", -203, 68, -39322);
		if (Spell3CancelFULLtextProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "click again to confirm", -207, 80, -3355444);
		if (Spell3removeINStrueProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Stop Creating/Removing", 72, 12, -6724096);
		if (Spell3removeINStrueProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "click again to confirm", 76, 24, -6724096);
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
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(0, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + 72, 88, 20, new StringTextComponent("Cancel Spell"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(1, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		spell3_radius = new TextFieldWidget(this.font, this.guiLeft + 72, this.guiTop + -36, 76, 20, new StringTextComponent(""));
		guistate.put("text:spell3_radius", spell3_radius);
		spell3_radius.setMaxStringLength(32767);
		this.children.add(this.spell3_radius);
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + 40, 48, 20, new StringTextComponent("15 mana"), e -> {
			if (Spell3speedNot16Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(2, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell3speedNot16Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		spell3_particle = new CheckboxButton(this.guiLeft + -207, this.guiTop + -40, 20, 20, new StringTextComponent("Lantern Particle"),

				Spell3GUIcheckParticleProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell3GUIGui.guistate.put("checkbox:spell3_particle", spell3_particle);
		this.addButton(spell3_particle);
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + -12, 50, 20, new StringTextComponent("Create"), e -> {
			if (Spell3genFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(3, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell3genFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + -12, 50, 20, new StringTextComponent(" "), e -> {
			if (Spell3genTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(4, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell3genTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 122, this.guiTop + -12, 50, 20, new StringTextComponent("Remove"), e -> {
			if (Spell3genTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(5, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell3genTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 180, this.guiTop + -12, 8, 20, new StringTextComponent("!"), e -> {
			if (Spell3startTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(6, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell3startTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 122, this.guiTop + -12, 50, 20, new StringTextComponent(" "), e -> {
			if (Spell3genFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(7, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell3genFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 176, this.guiTop + -36, 8, 20, new StringTextComponent("="), e -> {
			if (Spell3startPauseFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(8, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell3startPauseFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 176, this.guiTop + -36, 8, 20, new StringTextComponent(" "), e -> {
			if (Spell3startPauseTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(9, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell3startPauseTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 184, this.guiTop + -36, 8, 20, new StringTextComponent(">"), e -> {
			if (Spell3startPauseTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(10, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 10, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell3startPauseTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 184, this.guiTop + -36, 8, 20, new StringTextComponent(" "), e -> {
			if (Spell3startPauseFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(11, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 11, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell3startPauseFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 148, this.guiTop + -36, 24, 20, new StringTextComponent("Use"), e -> {
			if (Spell3startFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(12, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 12, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell3startFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 148, this.guiTop + -36, 24, 20, new StringTextComponent(" "), e -> {
			if (Spell3startTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(13, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 13, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell3startTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -87, this.guiTop + 72, 8, 20, new StringTextComponent("!"), e -> {
			if (Spell3genTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell3GUIGui.ButtonPressedMessage(14, x, y, z));
				Spell3GUIGui.handleButtonAction(entity, 14, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell3genTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		spell3_walk = new CheckboxButton(this.guiLeft + -207, this.guiTop + -64, 20, 20, new StringTextComponent("Walk Through"),

				Spell3walkTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell3GUIGui.guistate.put("checkbox:spell3_walk", spell3_walk);
		this.addButton(spell3_walk);
		spell3_invisible_dome = new CheckboxButton(this.guiLeft + -207, this.guiTop + -88, 20, 20, new StringTextComponent("Invisible Dome"),

				Spell3invisibleDomeTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell3GUIGui.guistate.put("checkbox:spell3_invisible_dome", spell3_invisible_dome);
		this.addButton(spell3_invisible_dome);
		spell3_no_block = new CheckboxButton(this.guiLeft + -207, this.guiTop + -112, 20, 20, new StringTextComponent("No Dome"),

				Spell3noDomeTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell3GUIGui.guistate.put("checkbox:spell3_no_block", spell3_no_block);
		this.addButton(spell3_no_block);
		spell3_particle_dome = new CheckboxButton(this.guiLeft + -207, this.guiTop + -16, 20, 20, new StringTextComponent("Dome particle"),

				Spell3domeParticleTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell3GUIGui.guistate.put("checkbox:spell3_particle_dome", spell3_particle_dome);
		this.addButton(spell3_particle_dome);
		spell3_block_arrow = new CheckboxButton(this.guiLeft + -207, this.guiTop + 8, 20, 20, new StringTextComponent("Block Arrow"),

				Spell3blockArrowTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell3GUIGui.guistate.put("checkbox:spell3_block_arrow", spell3_block_arrow);
		this.addButton(spell3_block_arrow);
		spell3_block_damage = new CheckboxButton(this.guiLeft + -207, this.guiTop + 32, 20, 20, new StringTextComponent("Block Damage"),

				Spell3blockDamageTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell3GUIGui.guistate.put("checkbox:spell3_block_damage", spell3_block_damage);
		this.addButton(spell3_block_damage);
	}
}
