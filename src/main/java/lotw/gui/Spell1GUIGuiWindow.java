
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

import lotw.procedures.Spell1radiusGetTrueProcedure;
import lotw.procedures.Spell1radiusGetProcedure;

import lotw.LotwModVariables;

import lotw.LotwMod;

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/tph_book.png"));
		this.blit(ms, this.guiLeft + -79, this.guiTop + -112, 0, 0, 288, 186, 288, 186);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell3.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell1station_image.png"));
		this.blit(ms, this.guiLeft + -31, this.guiTop + -24, 0, 0, 56, 24, 56, 24);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/1_lily.png"));
		this.blit(ms, this.guiLeft + 124, this.guiTop + 40, 0, 0, 16, 16, 16, 16);

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
		this.font.drawString(ms, "FALSE DIVINATION", -43, -92, -16777216);
		this.font.drawString(ms, "The spell of astrology.", -55, -76, -10079488);
		this.font.drawString(ms, "Use all 13 zodiac cards,", -63, -64, -10079488);
		this.font.drawString(ms, "only work while lantern", -63, -52, -10079488);
		this.font.drawString(ms, "Effect Limit : [" + (int) (LotwModVariables.MapVariables.get(world).spell1_effect_count) + "/"
				+ (int) (LotwModVariables.MapVariables.get(world).spell1_effect_count_max) + "]", -51, 8, -6724096);
		if (Spell1radiusGetTrueProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Radius : " + (int) (LotwModVariables.MapVariables.get(world).spell1_distance) + "", -43, 44, -6724096);
		this.font.drawString(ms, "on a stick.", -63, -40, -10079488);
		this.font.drawString(ms, "Target For Good Effects", 72, -96, -10092544);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_target_good) + "", 92, -80, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_target_bad) + "", 92, -44, -6724096);
		this.font.drawString(ms, "Custom Radius", -63, 28, -10092544);
		this.font.drawString(ms, "- Zodiac Circle", 72, 0, -6737152);
		this.font.drawString(ms, "- Zodiac Cards", 72, 20, -6737152);
		this.font.drawString(ms, "Hide Objects", 72, -20, -10092544);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_invisible_card) + "", 176, 20, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_invisible_circle) + "", 176, 0, -6724096);
		this.font.drawString(ms, "Target For Bad Effects", 72, -60, -10092544);
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
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(0, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + 72, 88, 20, new StringTextComponent("Cancel Spell"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(1, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + 4, 8, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(2, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -32, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(3, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -55, this.guiTop + 40, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(4, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + 40, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(5, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -43, this.guiTop + 40, 104, 20, new StringTextComponent("30 mana"), e -> {
			if (Spell1radiusGetProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(6, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1radiusGetProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + -84, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(7, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 80, this.guiTop + -84, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(8, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + -48, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(9, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 80, this.guiTop + -48, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(10, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + 16, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(11, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + -4, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIGui.ButtonPressedMessage(12, x, y, z));
				Spell1GUIGui.handleButtonAction(entity, 12, x, y, z);
			}
		}));
	}
}
