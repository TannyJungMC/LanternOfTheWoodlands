
package lantern_of_the_woodlands.gui;

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

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Spell4GUIpage2GuiWindow extends ContainerScreen<Spell4GUIpage2Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Spell4GUIpage2Gui.guistate;

	public Spell4GUIpage2GuiWindow(Spell4GUIpage2Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/tph_book.png"));
		this.blit(ms, this.guiLeft + -79, this.guiTop + -112, 0, 0, 288, 186, 288, 186);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -72, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -48, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -24, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + 72, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + 0, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + 24, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + 72, this.guiTop + -72, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + 72, this.guiTop + -48, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell4_knight_sword.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + 0, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell4_magic_mirror.png"));
		this.blit(ms, this.guiLeft + 72, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell4_arrow_of_teleportation.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -72, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell4_anchor.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell4_explode.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -48, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell4_glowing_staff.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -24, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell4_leaf.png"));
		this.blit(ms, this.guiLeft + -59, this.guiTop + 20, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell4_forest_staff.png"));
		this.blit(ms, this.guiLeft + 72, this.guiTop + -72, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell4_through.png"));
		this.blit(ms, this.guiLeft + 72, this.guiTop + -48, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + 72, this.guiTop + -24, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + 72, this.guiTop + 0, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell4_dual_scythes.png"));
		this.blit(ms, this.guiLeft + 72, this.guiTop + -24, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell4_stone_sword.png"));
		this.blit(ms, this.guiLeft + 72, this.guiTop + 0, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/slot.png"));
		this.blit(ms, this.guiLeft + 72, this.guiTop + 24, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell4_card.png"));
		this.blit(ms, this.guiLeft + 76, this.guiTop + 20, 0, 0, 16, 16, 16, 16);

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
		this.font.drawString(ms, "Mana : [ " + (LanternOfTheWoodlandsModVariables.MapVariables.get(world).mana) + " /15.0]", 96, 76, -6710887);
		this.font.drawString(ms, "", 64, -88, -6750208);
		this.font.drawString(ms, "All items needed 15 mana", -63, 76, -39322);
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
		this.addButton(new Button(this.guiLeft + 152, this.guiTop + 95, 48, 20, new StringTextComponent("Close"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(0, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -81, this.guiTop + -31, 9, 20, new StringTextComponent("<"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(1, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + -96, 96, 20, new StringTextComponent("Man In The Mirror"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(2, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -39, this.guiTop + 0, 96, 20, new StringTextComponent("Knight's Sword"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(3, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -39, this.guiTop + -72, 96, 20, new StringTextComponent("Endarow"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(4, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -39, this.guiTop + -96, 96, 20, new StringTextComponent("Sea Anchor"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(5, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -39, this.guiTop + -48, 96, 20, new StringTextComponent("Paper Bomb Kunai"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(6, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -39, this.guiTop + -24, 96, 20, new StringTextComponent("Paraniya Staff"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(7, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -39, this.guiTop + 24, 96, 20, new StringTextComponent("Whirlwind"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(8, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + -72, 96, 20, new StringTextComponent("Forest Staff"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(9, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + -48, 96, 20, new StringTextComponent("Hell Innovation"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(10, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + -24, 96, 20, new StringTextComponent("Dual Scythes"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(11, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + 0, 96, 20, new StringTextComponent("Forgotten Sword"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(12, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 12, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + 24, 96, 20, new StringTextComponent("Adventure Cards"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell4GUIpage2Gui.ButtonPressedMessage(13, x, y, z));
				Spell4GUIpage2Gui.handleButtonAction(entity, 13, x, y, z);
			}
		}));
	}
}
