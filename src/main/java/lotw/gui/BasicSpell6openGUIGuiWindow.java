
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
public class BasicSpell6openGUIGuiWindow extends ContainerScreen<BasicSpell6openGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = BasicSpell6openGUIGui.guistate;

	public BasicSpell6openGUIGuiWindow(BasicSpell6openGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 0;
		this.ySize = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lotw:textures/screens/basic_spell_6open_gui.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell_costs.png"));
		this.blit(ms, this.guiLeft + -85, this.guiTop + -103, 0, 0, 144, 181, 144, 181);

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
		this.font.drawString(ms, "Invitation", -27, -85, -16777216);
		this.font.drawString(ms, "Nature mage's", -40, -67, -10079488);
		this.font.drawString(ms, "invite you to", -36, -58, -10079488);
		this.font.drawString(ms, "Time Left : " + (LotwModVariables.MapVariables.get(world).basicspell6_time_left) + "", -36, 5, -6724096);
		this.font.drawString(ms, "Auto cancel when", -45, -31, -10079488);
		this.font.drawString(ms, "he cancel this", -40, -22, -10079488);
		this.font.drawString(ms, "spell or time out.", -45, -13, -10079488);
		this.font.drawString(ms, "teleport to him.", -40, -49, -10079488);
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
		this.addButton(new Button(this.guiLeft + -27, this.guiTop + 23, 54, 20, new StringTextComponent("Accept"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new BasicSpell6openGUIGui.ButtonPressedMessage(0, x, y, z));
				BasicSpell6openGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -27, this.guiTop + 46, 54, 20, new StringTextComponent("Refuse"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new BasicSpell6openGUIGui.ButtonPressedMessage(1, x, y, z));
				BasicSpell6openGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 40, this.guiTop + -96, 9, 20, new StringTextComponent("X"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new BasicSpell6openGUIGui.ButtonPressedMessage(2, x, y, z));
				BasicSpell6openGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
