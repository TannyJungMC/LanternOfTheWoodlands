
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

import lotw.procedures.Spell1unlockAll12Procedure;
import lotw.procedures.Spell1startEffectNot9Procedure;
import lotw.procedures.Spell1startEffectNot8Procedure;
import lotw.procedures.Spell1startEffectNot7Procedure;
import lotw.procedures.Spell1startEffectNot6Procedure;
import lotw.procedures.Spell1startEffectNot5Procedure;
import lotw.procedures.Spell1startEffectNot4Procedure;
import lotw.procedures.Spell1startEffectNot3Procedure;
import lotw.procedures.Spell1startEffectNot2Procedure;
import lotw.procedures.Spell1startEffectNot1Procedure;
import lotw.procedures.Spell1startEffectNot12Procedure;
import lotw.procedures.Spell1startEffectNot11Procedure;
import lotw.procedures.Spell1startEffectNot10Procedure;
import lotw.procedures.Spell1startEffect9Procedure;
import lotw.procedures.Spell1startEffect8Procedure;
import lotw.procedures.Spell1startEffect7Procedure;
import lotw.procedures.Spell1startEffect6Procedure;
import lotw.procedures.Spell1startEffect5Procedure;
import lotw.procedures.Spell1startEffect4Procedure;
import lotw.procedures.Spell1startEffect3Procedure;
import lotw.procedures.Spell1startEffect2Procedure;
import lotw.procedures.Spell1startEffect1Procedure;
import lotw.procedures.Spell1startEffect12Procedure;
import lotw.procedures.Spell1startEffect11Procedure;
import lotw.procedures.Spell1startEffect10Procedure;
import lotw.procedures.Spell1infoEffect9Procedure;
import lotw.procedures.Spell1infoEffect8Procedure;
import lotw.procedures.Spell1infoEffect7Procedure;
import lotw.procedures.Spell1infoEffect6Procedure;
import lotw.procedures.Spell1infoEffect5Procedure;
import lotw.procedures.Spell1infoEffect4Procedure;
import lotw.procedures.Spell1infoEffect3Procedure;
import lotw.procedures.Spell1infoEffect2Procedure;
import lotw.procedures.Spell1infoEffect1Procedure;
import lotw.procedures.Spell1infoEffect12Procedure;
import lotw.procedures.Spell1infoEffect11Procedure;
import lotw.procedures.Spell1infoEffect10Procedure;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Spell1GUIpage2GuiWindow extends ContainerScreen<Spell1GUIpage2Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Spell1GUIpage2Gui.guistate;

	public Spell1GUIpage2GuiWindow(Spell1GUIpage2Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_circle.png"));
		this.blit(ms, this.guiLeft + -50, this.guiTop + -49, 0, 0, 99, 99, 99, 99);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_door9.png"));
		this.blit(ms, this.guiLeft + 192, this.guiTop + -44, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_door8.png"));
		this.blit(ms, this.guiLeft + 192, this.guiTop + -80, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_door1.png"));
		this.blit(ms, this.guiLeft + -207, this.guiTop + -116, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_door2.png"));
		this.blit(ms, this.guiLeft + -207, this.guiTop + -80, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_door3.png"));
		this.blit(ms, this.guiLeft + -207, this.guiTop + -44, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_door4.png"));
		this.blit(ms, this.guiLeft + -207, this.guiTop + -8, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_door5.png"));
		this.blit(ms, this.guiLeft + -207, this.guiTop + 28, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_door6.png"));
		this.blit(ms, this.guiLeft + -207, this.guiTop + 64, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_door7.png"));
		this.blit(ms, this.guiLeft + 192, this.guiTop + -116, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_door10.png"));
		this.blit(ms, this.guiLeft + 192, this.guiTop + -8, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_door11.png"));
		this.blit(ms, this.guiLeft + 192, this.guiTop + 28, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_door12.png"));
		this.blit(ms, this.guiLeft + 192, this.guiTop + 64, 0, 0, 32, 32, 32, 32);

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
		this.font.drawString(ms, "Mana : [" + (int) (LotwModVariables.MapVariables.get(world).mana) + "/30]", -39, -104, -6710887);
		if (Spell1startEffect1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_effect1) + "", -7, -84, -10066330);
		if (Spell1startEffect2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_effect2) + "", 24, -80, -10066330);
		if (Spell1startEffect3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_effect3) + "", 52, -56, -10066330);
		if (Spell1startEffect4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_effect4) + "", 76, -8, -10066330);
		if (Spell1startEffect5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_effect5) + "", 52, 44, -10066330);
		if (Spell1startEffect6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_effect6) + "", 24, 72, -10066330);
		if (Spell1startEffect7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_effect7) + "", -7, 76, -10066330);
		if (Spell1startEffect8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_effect8) + "", -39, 72, -10066330);
		if (Spell1startEffect9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_effect9) + "", -67, 44, -10066330);
		if (Spell1startEffect10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_effect10) + "", -95, -8, -10066330);
		if (Spell1startEffect11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_effect11) + "", -67, -56, -10066330);
		if (Spell1startEffect12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_effect12) + "", -39, -80, -10066330);
		this.font.drawString(ms, "I | Aries", -187, -116, -1329017);
		this.font.drawString(ms, "II | Taurus", -187, -80, -2446);
		this.font.drawString(ms, "III | Gemini", -187, -44, -1);
		this.font.drawString(ms, "IV | Cancer", -187, -8, -11550592);
		this.font.drawString(ms, "V | Leo", -187, 28, -5593481);
		this.font.drawString(ms, "VI | Virgo", -187, 64, -36190);
		this.font.drawString(ms, "Libra | VII", 136, -116, -8856252);
		this.font.drawString(ms, "Scorpio | VIII", 124, -80, -1615553);
		this.font.drawString(ms, "Sagittarius | IX", 112, -44, -6516753);
		this.font.drawString(ms, "Capricorn | X", 120, -8, -2978790);
		this.font.drawString(ms, "Aquarius | XI", 120, 28, -8001564);
		this.font.drawString(ms, "Pisces | XII", 132, 64, -16741414);
		if (Spell1infoEffect1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Invisibility", -187, -104, -6710887);
		if (Spell1infoEffect2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "+6 Attack Damage", -187, -68, -6710887);
		if (Spell1infoEffect3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Remove All Effects", -187, -32, -6710887);
		if (Spell1infoEffect4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "5 Blocks Jump", -187, 4, -6710887);
		if (Spell1infoEffect5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Slow Falling", -187, 40, -6710887);
		if (Spell1infoEffect6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Heal +2/Time", -187, 76, -6710887);
		if (Spell1infoEffect7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "+255 Luck", 136, -104, -6710887);
		if (Spell1infoEffect8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Fire Resistance", 108, -68, -6710887);
		if (Spell1infoEffect9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "+60% Speed", 128, -32, -6710887);
		if (Spell1infoEffect10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "+200% Mining Speed", 88, 4, -6710887);
		if (Spell1infoEffect11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Atlantis Power", 112, 40, -6710887);
		if (Spell1infoEffect12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Night Vision", 128, 76, -6710887);
		if (Spell1infoEffect1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Glowing", -187, -92, -6710887);
		if (Spell1infoEffect2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "-6 Attack Damage", -187, -56, -6710887);
		if (Spell1infoEffect3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Hunger -1/Time", -187, -20, -6710887);
		if (Spell1infoEffect4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Fly Up 20 Blocks", -187, 16, -6710887);
		if (Spell1infoEffect5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Nausea", -187, 52, -6710887);
		if (Spell1infoEffect6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Instant Damage -3/Time", -187, 88, -6710887);
		if (Spell1infoEffect7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "-255 Luck", 136, -92, -6710887);
		if (Spell1infoEffect8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Damage -1/Time", 112, -56, -6710887);
		if (Spell1infoEffect9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "-60% Speed", 128, -20, -6710887);
		if (Spell1infoEffect10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "-70% Mining Speed", 96, 16, -6710887);
		if (Spell1infoEffect11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Nausea", 148, 52, -6710887);
		if (Spell1infoEffect12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Blindness", 140, 88, -6710887);
		this.font.drawString(ms, "Effect Limit : [" + (int) (LotwModVariables.MapVariables.get(world).spell1_effect_count) + "/"
				+ (int) (LotwModVariables.MapVariables.get(world).spell1_effect_count_max) + "]", -47, -116, -6710887);
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
		this.addButton(new Button(this.guiLeft + -207, this.guiTop + 100, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(0, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + -72, 20, 20, new StringTextComponent("I"), e -> {
			if (Spell1startEffect1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(1, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffect1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 20, this.guiTop + -68, 20, 20, new StringTextComponent("II"), e -> {
			if (Spell1startEffect2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(2, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffect2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 52, this.guiTop + -12, 20, 20, new StringTextComponent("IV"), e -> {
			if (Spell1startEffect4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(3, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffect4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 48, this.guiTop + -44, 20, 20, new StringTextComponent("III"), e -> {
			if (Spell1startEffect3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(4, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffect3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 48, this.guiTop + 20, 20, 20, new StringTextComponent("V"), e -> {
			if (Spell1startEffect5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(5, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffect5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 20, this.guiTop + 48, 20, 20, new StringTextComponent("VI"), e -> {
			if (Spell1startEffect6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(6, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffect6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + 52, 20, 20, new StringTextComponent("VII"), e -> {
			if (Spell1startEffect7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(7, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffect7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -43, this.guiTop + -68, 20, 20, new StringTextComponent("XII"), e -> {
			if (Spell1startEffect12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(8, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffect12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -75, this.guiTop + -12, 20, 20, new StringTextComponent("X"), e -> {
			if (Spell1startEffect10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(9, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffect10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -71, this.guiTop + -44, 20, 20, new StringTextComponent("XI"), e -> {
			if (Spell1startEffect11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(10, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 10, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffect11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -71, this.guiTop + 20, 20, 20, new StringTextComponent("IX"), e -> {
			if (Spell1startEffect9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(11, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 11, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffect9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -43, this.guiTop + 48, 20, 20, new StringTextComponent("VIII"), e -> {
			if (Spell1startEffect8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(12, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 12, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffect8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -187, this.guiTop + -104, 48, 20, new StringTextComponent("20 mana"), e -> {
			if (Spell1startEffectNot1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(13, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 13, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffectNot1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -187, this.guiTop + -68, 48, 20, new StringTextComponent("30 mana"), e -> {
			if (Spell1startEffectNot2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(14, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 14, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffectNot2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -187, this.guiTop + -32, 48, 20, new StringTextComponent("20 mana"), e -> {
			if (Spell1startEffectNot3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(15, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 15, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffectNot3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -187, this.guiTop + 4, 48, 20, new StringTextComponent("20 mana"), e -> {
			if (Spell1startEffectNot4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(16, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 16, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffectNot4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -187, this.guiTop + 40, 48, 20, new StringTextComponent("20 mana"), e -> {
			if (Spell1startEffectNot5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(17, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 17, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffectNot5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -187, this.guiTop + 76, 48, 20, new StringTextComponent("30 mana"), e -> {
			if (Spell1startEffectNot6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(18, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 18, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffectNot6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 140, this.guiTop + -104, 48, 20, new StringTextComponent("20 mana"), e -> {
			if (Spell1startEffectNot7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(19, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 19, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffectNot7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 140, this.guiTop + -68, 48, 20, new StringTextComponent("20 mana"), e -> {
			if (Spell1startEffectNot8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(20, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 20, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffectNot8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 140, this.guiTop + -32, 48, 20, new StringTextComponent("20 mana"), e -> {
			if (Spell1startEffectNot9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(21, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 21, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffectNot9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 140, this.guiTop + 4, 48, 20, new StringTextComponent("30 mana"), e -> {
			if (Spell1startEffectNot10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(22, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 22, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffectNot10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 140, this.guiTop + 40, 48, 20, new StringTextComponent("30 mana"), e -> {
			if (Spell1startEffectNot11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(23, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 23, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffectNot11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 140, this.guiTop + 76, 48, 20, new StringTextComponent("20 mana"), e -> {
			if (Spell1startEffectNot12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(24, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 24, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffectNot12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -199, this.guiTop + 100, 8, 20, new StringTextComponent("?"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(25, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 25, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + 100, 8, 20, new StringTextComponent(">"), e -> {
			if (Spell1unlockAll12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(26, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 26, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1unlockAll12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
