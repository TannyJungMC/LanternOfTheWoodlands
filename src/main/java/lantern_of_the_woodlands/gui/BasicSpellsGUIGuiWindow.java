
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

import lantern_of_the_woodlands.procedures.Spell4ifSpell4TRUEProcedure;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class BasicSpellsGUIGuiWindow extends ContainerScreen<BasicSpellsGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = BasicSpellsGUIGui.guistate;

	public BasicSpellsGUIGuiWindow(BasicSpellsGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 0;
		this.ySize = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lantern_of_the_woodlands:textures/screens/basic_spells_gui.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/tph_book.png"));
		this.blit(ms, this.guiLeft + -79, this.guiTop + -112, 0, 0, 288, 186, 288, 186);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/basicspell1.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/basicspell2.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -72, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/basicspell3.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -48, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/basicspell4.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -24, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/basicspell5.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + 0, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/basicspell6.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + 24, 0, 0, 16, 16, 16, 16);

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
		this.font.drawString(ms, "Protector", -39, -92, -10079488);
		this.font.drawString(ms, "Charge : [ " + (LanternOfTheWoodlandsModVariables.MapVariables.get(world).mana_charge) + " /20.0]", -207, -92,
				-26317);
		this.font.drawString(ms, "Mana : [ " + (LanternOfTheWoodlandsModVariables.MapVariables.get(world).mana) + " /15.0]", -207, -104, -10027162);
		this.font.drawString(ms, "Lantern Light", -39, -68, -10079488);
		this.font.drawString(ms, "Winter Wind", -39, -44, -10079488);
		this.font.drawString(ms, "Wall of Vines", -39, -20, -10079488);
		this.font.drawString(ms, "Wanderer", -39, 4, -10079488);
		this.font.drawString(ms, "Pigeon Post", -39, 28, -10079488);
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
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + 72, 48, 20, new StringTextComponent("Close"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(0, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 104, this.guiTop + -96, 48, 20, new StringTextComponent("2 mana"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(1, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -23, this.guiTop + 72, 56, 20, new StringTextComponent("x All"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(2, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 40, this.guiTop + 72, 112, 20, new StringTextComponent("Affiliate List"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(3, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + -96, 16, 20, new StringTextComponent("x"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(4, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 104, this.guiTop + -72, 48, 20, new StringTextComponent("1 mana"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(5, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + -72, 16, 20, new StringTextComponent("x"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(6, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 104, this.guiTop + -48, 48, 20, new StringTextComponent("1 mana"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(7, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + -48, 16, 20, new StringTextComponent("x"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(8, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 104, this.guiTop + -24, 48, 20, new StringTextComponent("2 mana"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(9, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + -24, 16, 20, new StringTextComponent("x"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(10, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 104, this.guiTop + 0, 48, 20, new StringTextComponent("3 mana"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(11, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + 0, 32, 20, new StringTextComponent("x"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(12, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 12, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 104, this.guiTop + 24, 48, 20, new StringTextComponent("3 mana"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(13, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 13, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 160, this.guiTop + 24, 32, 20, new StringTextComponent("x"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(14, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 14, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -207, this.guiTop + -76, 120, 20, new StringTextComponent("Dark Autumn Weapons"), e -> {
			if (Spell4ifSpell4TRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(15, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 15, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell4ifSpell4TRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -28, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(16, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 16, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 176, this.guiTop + -96, 16, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(17, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 17, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + 72, 56, 20, new StringTextComponent("- All"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(18, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 18, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 176, this.guiTop + -72, 16, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(19, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 19, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 176, this.guiTop + -48, 16, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(20, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 20, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 176, this.guiTop + -24, 16, 20, new StringTextComponent("-"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new BasicSpellsGUIGui.ButtonPressedMessage(21, x, y, z));
				BasicSpellsGUIGui.handleButtonAction(entity, 21, x, y, z);
			}
		}));
	}
}
