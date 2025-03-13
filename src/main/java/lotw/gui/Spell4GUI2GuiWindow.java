
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

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Spell4GUI2GuiWindow extends ContainerScreen<Spell4GUI2Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Spell4GUI2Gui.guistate;

	public Spell4GUI2GuiWindow(Spell4GUI2Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell4_image_2.png"));
		this.blit(ms, this.guiLeft + 76, this.guiTop + -4, 0, 0, 112, 48, 112, 48);

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
		this.font.drawString(ms, "Mana : [" + (int) (LotwModVariables.MapVariables.get(world).mana) + "/30]", -79, 76, -6710887);
		this.font.drawString(ms, "", 64, -88, -6750208);
		this.font.drawString(ms, "Spell Active Setting", 72, -96, -10092544);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell4_switch_shoot) + "", 176, -76, -6724096);
		this.font.drawString(ms, "- Lock Shoot", 72, -76, -6737152);
		this.font.drawString(ms, "- Lock Reverse", 72, -56, -6737152);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell4_switch_reverse) + "", 176, -56, -6724096);
		this.font.drawString(ms, "- Follow Range", 72, -36, -6737152);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell4_follow_you) + "", 176, -36, -6724096);
		this.font.drawString(ms, "Display Setting", -63, -96, -10092544);
		this.font.drawString(ms, "- Overlay", -63, -76, -6737152);
		this.font.drawString(ms, "- Target Arrow", -63, -56, -6737152);
		this.font.drawString(ms, "" + ((entity.getCapability(LotwModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LotwModVariables.PlayerVariables())).spell4_overlay) + "", 40, -76, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell4_arrow) + "", 40, -56, -6724096);
		this.font.drawString(ms, "Spell Inactive Setting", -63, -36, -10092544);
		this.font.drawString(ms, "- At Lantern", -63, -16, -6737152);
		this.font.drawString(ms, "- Free Flying", -63, 4, -6737152);
		this.font.drawString(ms, "- Gravity", -63, 24, -6737152);
		this.font.drawString(ms, "- Boundary", -63, 44, -6737152);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell4_pause_around_lantern) + "", 40, -16, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell4_pause_free_flying) + "", 40, 4, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell4_pause_gravity) + "", 40, 24, -6724096);
		this.font.drawString(ms, "" + (int) (LotwModVariables.MapVariables.get(world).spell4_pause_size) + "", 40, 44, -6724096);
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
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + -80, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUI2Gui.ButtonPressedMessage(0, x, y, z));
				Spell4GUI2Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + -60, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUI2Gui.ButtonPressedMessage(1, x, y, z));
				Spell4GUI2Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 164, this.guiTop + -40, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUI2Gui.ButtonPressedMessage(2, x, y, z));
				Spell4GUI2Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + -32, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUI2Gui.ButtonPressedMessage(3, x, y, z));
				Spell4GUI2Gui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 28, this.guiTop + -80, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUI2Gui.ButtonPressedMessage(4, x, y, z));
				Spell4GUI2Gui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 28, this.guiTop + -60, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUI2Gui.ButtonPressedMessage(5, x, y, z));
				Spell4GUI2Gui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 28, this.guiTop + -20, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUI2Gui.ButtonPressedMessage(6, x, y, z));
				Spell4GUI2Gui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 28, this.guiTop + 0, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUI2Gui.ButtonPressedMessage(7, x, y, z));
				Spell4GUI2Gui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 28, this.guiTop + 20, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUI2Gui.ButtonPressedMessage(8, x, y, z));
				Spell4GUI2Gui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 28, this.guiTop + 40, 8, 20, new StringTextComponent("#"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell4GUI2Gui.ButtonPressedMessage(9, x, y, z));
				Spell4GUI2Gui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
	}
}
