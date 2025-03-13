
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

import lantern_of_the_woodlands.procedures.Spell4aroundLanternTRUEProcedure;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

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
	CheckboxButton spell4_weapon_around_lantern;

	public Spell4GUIGuiWindow(Spell4GUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell_4_gui.png");

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
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell1.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 7, 0, 0, 16, 16, 16, 16);

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
		this.font.drawString(ms, "Mana : [ " + (LanternOfTheWoodlandsModVariables.MapVariables.get(world).mana) + " /15.0]", 38, 169, -6710887);
		this.font.drawString(ms, "", 152, -5, -6750208);
		this.font.drawString(ms, "Autumn of Loss", 27, 10, -16777216);
		this.font.drawString(ms, "The spell of cursed weapons,", 16, 31, -10079488);
		this.font.drawString(ms, "shoot tools with area effects", 8, 43, -10079488);
		this.font.drawString(ms, "please, insert/take item slowly", 9, -16, -3394816);
		this.font.drawString(ms, "(15 second)", 218, 7, -6710887);
		this.font.drawString(ms, "do not close this page", 177, 25, -6710887);
		this.font.drawString(ms, "while reset the spell", 177, 39, -6710887);
		this.font.drawString(ms, "Ctrl = swap weapon", -119, 139, -10027162);
		this.font.drawString(ms, "Shift = shoot", -119, 151, -10027162);
		this.font.drawString(ms, "Tab = reset", -119, 163, -10027162);
		this.font.drawString(ms, "Get autumn weapons", -119, 103, -13261);
		this.font.drawString(ms, "in basic spell page", -119, 115, -13261);
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
		this.addButton(new Button(this.guiLeft + 240, this.guiTop + 178, 48, 20, new StringTextComponent("Close"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(0, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -119, this.guiTop + 178, 88, 20, new StringTextComponent("Cancel Spell"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(1, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 177, this.guiTop + 3, 36, 20, new StringTextComponent("Reset"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIGui.ButtonPressedMessage(2, x, y, z));
				Spell4GUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		spell4_weapon_around_lantern = new CheckboxButton(this.guiLeft + -119, this.guiTop + 3, 20, 20, new StringTextComponent("Around Lantern"),

				Spell4aroundLanternTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell4GUIGui.guistate.put("checkbox:spell4_weapon_around_lantern", spell4_weapon_around_lantern);
		this.addButton(spell4_weapon_around_lantern);
	}
}
