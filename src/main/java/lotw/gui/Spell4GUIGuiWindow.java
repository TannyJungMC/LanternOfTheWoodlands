
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

import lotw.procedures.Spell4returnShowKeyTRUEProcedure;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Spell4GUIGuiWindow extends ContainerScreen<Spell4GUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Spell4GUIGui.guistate;

	public Spell4GUIGuiWindow(Spell4GUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell1.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell4_image.png"));
		this.blit(ms, this.guiLeft + -59, this.guiTop + -12, 0, 0, 112, 48, 112, 48);

		if (Spell4returnShowKeyTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
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
		this.font.drawString(ms, "", 64, -88, -6750208);
		this.font.drawString(ms, "WEAPON MANIPULATION", -43, -92, -16777216);
		this.font.drawString(ms, "The spell of weapon", -55, -76, -10079488);
		this.font.drawString(ms, "and objects controlling,", -63, -64, -10079488);
		this.font.drawString(ms, "use your magic to move", -63, -52, -10079488);
		this.font.drawString(ms, "Set Weapon", -63, 44, -10092544);
		this.font.drawString(ms, "- Bow", 72, -16, -6737152);
		if (Spell4returnShowKeyTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Default Key", -175, -92, -10092544);
		if (Spell4returnShowKeyTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "2 = Mode", -187, 4, -6737152);
		if (Spell4returnShowKeyTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "1 = Weapon", -187, -8, -6737152);
		if (Spell4returnShowKeyTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Tab = Reset", -187, -68, -6737152);
		if (Spell4returnShowKeyTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Shift = Shoot", -187, -56, -6737152);
		if (Spell4returnShowKeyTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "5 = Skill", -187, 40, -6737152);
		this.font.drawString(ms, "Active Weapons", 72, -96, -10092544);
		this.font.drawString(ms, "" + (int) (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type1) + "", 176, -76, -6724096);
		this.font.drawString(ms, "" + (int) (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type4) + "", 176, -16, -6724096);
		if (Spell4returnShowKeyTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "4 = Distance (+)", -187, 28, -6737152);
		if (Spell4returnShowKeyTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "3 = Distance (-)", -187, 16, -6737152);
		if (Spell4returnShowKeyTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Ctrl = Reverse", -187, -44, -6737152);
		this.font.drawString(ms, "- Sword", 72, -76, -6737152);
		this.font.drawString(ms, "" + (int) (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type5) + "", 176, 4, -6724096);
		this.font.drawString(ms, "- Lantern", 72, -36, -6737152);
		this.font.drawString(ms, "- Beehive", 72, 4, -6737152);
		this.font.drawString(ms, "- Shield", 72, -56, -6737152);
		this.font.drawString(ms, "" + (int) (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type2) + "", 176, -56, -6724096);
		this.font.drawString(ms, "objects like telekinesis", -63, -40, -10079488);
		this.font.drawString(ms, "and use their skills.", -63, -28, -10079488);
		if (Spell4returnShowKeyTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Z = Lock Target", -187, -32, -6737152);
		this.font.drawString(ms, "" + (int) (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type3) + "", 176, -36, -6724096);
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
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(0, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + 72, 88, 20, new StringTextComponent("Cancel Spell"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(1, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 0, this.guiTop + 40, 56, 20, new StringTextComponent("20 mana"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(2, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + -80, 8, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(3, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + -40, 8, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(4, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 136, this.guiTop + 40, 56, 20, new StringTextComponent("Clear All"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(5, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + -20, 8, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(6, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + 0, 8, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(7, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + -60, 8, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(8, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + -104, 8, 20, new StringTextComponent("?"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(9, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -32, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(10, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
	}
}
