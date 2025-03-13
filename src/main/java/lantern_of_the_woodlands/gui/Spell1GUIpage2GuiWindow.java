
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

import lantern_of_the_woodlands.procedures.Spell1checkboxWaterProcedure;
import lantern_of_the_woodlands.procedures.Spell1checkboxProtectionProcedure;
import lantern_of_the_woodlands.procedures.Spell1checkboxOrientationProcedure;
import lantern_of_the_woodlands.procedures.Spell1checkboxNightVisionProcedure;
import lantern_of_the_woodlands.procedures.Spell1checkboxMinerProcedure;
import lantern_of_the_woodlands.procedures.Spell1checkboxHealingProcedure;
import lantern_of_the_woodlands.procedures.Spell1checkboxGoldenHeartProcedure;
import lantern_of_the_woodlands.procedures.Spell1checkboxDamageBoostProcedure;
import lantern_of_the_woodlands.procedures.Spell1checkboxClearEffectProcedure;
import lantern_of_the_woodlands.procedures.Spell1checkboxCamouflageProcedure;
import lantern_of_the_woodlands.procedures.Spell1checkboxBarrierProcedure;
import lantern_of_the_woodlands.procedures.Spell1checkboxAbilityProcedure;
import lantern_of_the_woodlands.procedures.Spell1areadyNotWaterProcedure;
import lantern_of_the_woodlands.procedures.Spell1areadyNotProtectionProcedure;
import lantern_of_the_woodlands.procedures.Spell1areadyNotOrientationProcedure;
import lantern_of_the_woodlands.procedures.Spell1areadyNotNightvisionProcedure;
import lantern_of_the_woodlands.procedures.Spell1areadyNotMinerProcedure;
import lantern_of_the_woodlands.procedures.Spell1areadyNotHealingProcedure;
import lantern_of_the_woodlands.procedures.Spell1areadyNotGoldenHeartProcedure;
import lantern_of_the_woodlands.procedures.Spell1areadyNotDamageBoostProcedure;
import lantern_of_the_woodlands.procedures.Spell1areadyNotClearEffectProcedure;
import lantern_of_the_woodlands.procedures.Spell1areadyNotCamouflageProcedure;
import lantern_of_the_woodlands.procedures.Spell1areadyNotBarrierProcedure;
import lantern_of_the_woodlands.procedures.Spell1areadyNotAbilityProcedure;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

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
	CheckboxButton spell1healing;
	CheckboxButton spell1damage_boost;
	CheckboxButton spell1protection;
	CheckboxButton spell1golden_heart;
	CheckboxButton spell1clear_effect;
	CheckboxButton spell1miner;
	CheckboxButton spell1barrier;
	CheckboxButton spell1camouflage;
	CheckboxButton spell1ability;
	CheckboxButton spell1orientation;
	CheckboxButton spell1water;
	CheckboxButton spell1night_vision;

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell1remover.png"));
		this.blit(ms, this.guiLeft + -81, this.guiTop + -80, 0, 0, 160, 160, 160, 160);

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
		this.font.drawString(ms, "Mana : [ " + (LanternOfTheWoodlandsModVariables.MapVariables.get(world).mana) + " /15.0]", -207, -116, -6710887);
		if (Spell1areadyNotDamageBoostProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "15 mana", 88, -64, -6684775);
		if (Spell1areadyNotProtectionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "15 mana", -19, 108, -6684775);
		if (Spell1areadyNotGoldenHeartProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "15 mana", 100, 52, -6684775);
		if (Spell1areadyNotClearEffectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "5 mana", 108, -32, -6684775);
		if (Spell1areadyNotHealingProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "15 mana", 88, 84, -6684775);
		if (Spell1areadyNotMinerProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "15 mana", -147, 8, -6684775);
		if (Spell1areadyNotBarrierProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "10 mana", 112, 8, -6684775);
		if (Spell1areadyNotCamouflageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "10 mana", -15, -92, -6684775);
		if (Spell1areadyNotAbilityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "15 mana", -139, 52, -6684775);
		if (Spell1areadyNotOrientationProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "10 mana", -123, 84, -6684775);
		if (Spell1areadyNotWaterProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "10 mana", -143, -32, -6684775);
		if (Spell1areadyNotNightvisionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "10 mana", -127, -64, -6684775);
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
		this.addButton(new Button(this.guiLeft + -207, this.guiTop + 96, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(0, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + 96, 48, 20, new StringTextComponent("Close"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(1, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 64, this.guiTop + -84, 80, 20, new StringTextComponent("Taurus"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(2, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 80, this.guiTop + 32, 80, 20, new StringTextComponent("Leo"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(3, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -39, this.guiTop + 88, 80, 20, new StringTextComponent("Libra"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(4, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 92, this.guiTop + -12, 80, 20, new StringTextComponent("Cancer"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(5, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		spell1healing = new CheckboxButton(this.guiLeft + 24, this.guiTop + 44, 20, 20, new StringTextComponent(" "),

				Spell1checkboxHealingProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIpage2Gui.guistate.put("checkbox:spell1healing", spell1healing);
		this.addButton(spell1healing);
		spell1damage_boost = new CheckboxButton(this.guiLeft + 24, this.guiTop + -64, 20, 20, new StringTextComponent(" "),

				Spell1checkboxDamageBoostProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIpage2Gui.guistate.put("checkbox:spell1damage_boost", spell1damage_boost);
		this.addButton(spell1damage_boost);
		spell1protection = new CheckboxButton(this.guiLeft + -11, this.guiTop + 52, 20, 20, new StringTextComponent(" "),

				Spell1checkboxProtectionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIpage2Gui.guistate.put("checkbox:spell1protection", spell1protection);
		this.addButton(spell1protection);
		spell1golden_heart = new CheckboxButton(this.guiLeft + 44, this.guiTop + 20, 20, 20, new StringTextComponent(" "),

				Spell1checkboxGoldenHeartProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIpage2Gui.guistate.put("checkbox:spell1golden_heart", spell1golden_heart);
		this.addButton(spell1golden_heart);
		this.addButton(new Button(this.guiLeft + 80, this.guiTop + -52, 80, 20, new StringTextComponent("Gemini"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(6, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		spell1clear_effect = new CheckboxButton(this.guiLeft + 44, this.guiTop + -40, 20, 20, new StringTextComponent(" "),

				Spell1checkboxClearEffectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIpage2Gui.guistate.put("checkbox:spell1clear_effect", spell1clear_effect);
		this.addButton(spell1clear_effect);
		this.addButton(new Button(this.guiLeft + 64, this.guiTop + 64, 80, 20, new StringTextComponent("Virgo"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(7, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 44, this.guiTop + -40, 20, 20, new StringTextComponent(" "), e -> {
			if (Spell1areadyNotClearEffectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(8, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1areadyNotClearEffectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 24, this.guiTop + 44, 20, 20, new StringTextComponent(" "), e -> {
			if (Spell1areadyNotHealingProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(9, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1areadyNotHealingProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 24, this.guiTop + -64, 20, 20, new StringTextComponent(" "), e -> {
			if (Spell1areadyNotDamageBoostProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(10, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 10, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1areadyNotDamageBoostProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + 52, 20, 20, new StringTextComponent(" "), e -> {
			if (Spell1areadyNotProtectionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(11, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 11, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1areadyNotProtectionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 44, this.guiTop + 20, 20, 20, new StringTextComponent(" "), e -> {
			if (Spell1areadyNotGoldenHeartProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(12, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 12, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1areadyNotGoldenHeartProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		spell1miner = new CheckboxButton(this.guiLeft + -79, this.guiTop + -12, 20, 20, new StringTextComponent(" "),

				Spell1checkboxMinerProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIpage2Gui.guistate.put("checkbox:spell1miner", spell1miner);
		this.addButton(spell1miner);
		spell1barrier = new CheckboxButton(this.guiLeft + 56, this.guiTop + -12, 20, 20, new StringTextComponent(" "),

				Spell1checkboxBarrierProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIpage2Gui.guistate.put("checkbox:spell1barrier", spell1barrier);
		this.addButton(spell1barrier);
		spell1camouflage = new CheckboxButton(this.guiLeft + -11, this.guiTop + -72, 20, 20, new StringTextComponent(" "),

				Spell1checkboxCamouflageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIpage2Gui.guistate.put("checkbox:spell1camouflage", spell1camouflage);
		this.addButton(spell1camouflage);
		this.addButton(new Button(this.guiLeft + -175, this.guiTop + -12, 80, 20, new StringTextComponent("Capricorn"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(13, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 13, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -39, this.guiTop + -112, 80, 20, new StringTextComponent("Aries"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(14, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 14, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -163, this.guiTop + 32, 80, 20, new StringTextComponent("Sagittarius"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(15, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 15, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -147, this.guiTop + 64, 80, 20, new StringTextComponent("Scorpio"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(16, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 16, x, y, z);
			}
		}));
		spell1ability = new CheckboxButton(this.guiLeft + -67, this.guiTop + 20, 20, 20, new StringTextComponent(" "),

				Spell1checkboxAbilityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIpage2Gui.guistate.put("checkbox:spell1ability", spell1ability);
		this.addButton(spell1ability);
		spell1orientation = new CheckboxButton(this.guiLeft + -47, this.guiTop + 44, 20, 20, new StringTextComponent(" "),

				Spell1checkboxOrientationProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIpage2Gui.guistate.put("checkbox:spell1orientation", spell1orientation);
		this.addButton(spell1orientation);
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + -12, 20, 20, new StringTextComponent(" "), e -> {
			if (Spell1areadyNotMinerProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(17, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 17, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1areadyNotMinerProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 56, this.guiTop + -12, 20, 20, new StringTextComponent(" "), e -> {
			if (Spell1areadyNotBarrierProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(18, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 18, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1areadyNotBarrierProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + -72, 20, 20, new StringTextComponent(" "), e -> {
			if (Spell1areadyNotCamouflageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(19, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 19, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1areadyNotCamouflageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -67, this.guiTop + 20, 20, 20, new StringTextComponent(" "), e -> {
			if (Spell1areadyNotAbilityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(20, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 20, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1areadyNotAbilityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -47, this.guiTop + 44, 20, 20, new StringTextComponent(" "), e -> {
			if (Spell1areadyNotOrientationProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(21, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 21, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1areadyNotOrientationProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		spell1water = new CheckboxButton(this.guiLeft + -67, this.guiTop + -40, 20, 20, new StringTextComponent(" "),

				Spell1checkboxWaterProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIpage2Gui.guistate.put("checkbox:spell1water", spell1water);
		this.addButton(spell1water);
		spell1night_vision = new CheckboxButton(this.guiLeft + -47, this.guiTop + -64, 20, 20, new StringTextComponent(" "),

				Spell1checkboxNightVisionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell1GUIpage2Gui.guistate.put("checkbox:spell1night_vision", spell1night_vision);
		this.addButton(spell1night_vision);
		this.addButton(new Button(this.guiLeft + -67, this.guiTop + -40, 20, 20, new StringTextComponent(" "), e -> {
			if (Spell1areadyNotWaterProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(22, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 22, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1areadyNotWaterProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -47, this.guiTop + -64, 20, 20, new StringTextComponent(" "), e -> {
			if (Spell1areadyNotNightvisionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(23, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 23, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1areadyNotNightvisionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -163, this.guiTop + -52, 80, 20, new StringTextComponent("Aquarius"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(24, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 24, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -147, this.guiTop + -84, 80, 20, new StringTextComponent("Pisces"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage2Gui.ButtonPressedMessage(25, x, y, z));
				Spell1GUIpage2Gui.handleButtonAction(entity, 25, x, y, z);
			}
		}));
	}
}
