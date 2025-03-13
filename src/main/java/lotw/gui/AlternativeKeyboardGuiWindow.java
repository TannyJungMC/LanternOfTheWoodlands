
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

import lotw.procedures.ReturnLanternGoundTRUEProcedure;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class AlternativeKeyboardGuiWindow extends ContainerScreen<AlternativeKeyboardGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = AlternativeKeyboardGui.guistate;

	public AlternativeKeyboardGuiWindow(AlternativeKeyboardGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 0;
		this.ySize = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lotw:textures/screens/alternative_keyboard.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/tph_book.png"));
		this.blit(ms, this.guiLeft + -79, this.guiTop + -112, 0, 0, 288, 186, 288, 186);

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
		this.font.drawString(ms, "ALTERNATIVE KEYBOARD", -59, -96, -16777216);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).aternative_keyboard) + "", 72, -76, -6737152);
		this.font.drawString(ms, "Saves", -63, -32, -10092544);
		this.font.drawString(ms, "The keyboard for write", -55, -80, -10079488);
		this.font.drawString(ms, "custom text to use in", -63, -68, -10079488);
		this.font.drawString(ms, "some spells.", -63, -56, -10079488);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).aternative_keyboard_save1) + "", -51, -16, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).aternative_keyboard_save2) + "", -51, 4, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).aternative_keyboard_save3) + "", -51, 24, -6724096);
		this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).aternative_keyboard_save4) + "", -51, 44, -6724096);
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
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(0, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -32, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(1, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 112, this.guiTop + 72, 48, 20, new StringTextComponent("Back"), e -> {
			if (ReturnLanternGoundTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(2, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (ReturnLanternGoundTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + -24, 12, 20, new StringTextComponent("a"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(3, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 84, this.guiTop + -24, 12, 20, new StringTextComponent("b"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(4, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + -24, 12, 20, new StringTextComponent("c"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(5, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 108, this.guiTop + -24, 12, 20, new StringTextComponent("d"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(6, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 120, this.guiTop + -24, 12, 20, new StringTextComponent("e"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(7, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 132, this.guiTop + -24, 12, 20, new StringTextComponent("f"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(8, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 144, this.guiTop + -24, 12, 20, new StringTextComponent("g"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(9, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 156, this.guiTop + -24, 12, 20, new StringTextComponent("h"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(10, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 168, this.guiTop + -24, 12, 20, new StringTextComponent("i"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(11, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 180, this.guiTop + -24, 12, 20, new StringTextComponent("j"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(12, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 12, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + -4, 12, 20, new StringTextComponent("k"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(13, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 13, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 84, this.guiTop + -4, 12, 20, new StringTextComponent("l"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(14, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 14, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + -4, 12, 20, new StringTextComponent("m"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(15, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 15, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 108, this.guiTop + -4, 12, 20, new StringTextComponent("n"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(16, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 16, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 120, this.guiTop + -4, 12, 20, new StringTextComponent("o"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(17, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 17, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 132, this.guiTop + -4, 12, 20, new StringTextComponent("p"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(18, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 18, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 144, this.guiTop + -4, 12, 20, new StringTextComponent("q"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(19, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 19, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 156, this.guiTop + -4, 12, 20, new StringTextComponent("r"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(20, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 20, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 168, this.guiTop + -4, 12, 20, new StringTextComponent("s"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(21, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 21, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 180, this.guiTop + -4, 12, 20, new StringTextComponent("t"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(22, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 22, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + 16, 12, 20, new StringTextComponent("u"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(23, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 23, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 108, this.guiTop + 16, 12, 20, new StringTextComponent("v"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(24, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 24, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 120, this.guiTop + 16, 12, 20, new StringTextComponent("w"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(25, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 25, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 132, this.guiTop + 16, 12, 20, new StringTextComponent("x"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(26, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 26, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 144, this.guiTop + 16, 12, 20, new StringTextComponent("y"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(27, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 27, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 156, this.guiTop + 16, 12, 20, new StringTextComponent("z"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(28, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 28, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + -48, 12, 20, new StringTextComponent("_"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(29, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 29, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 180, this.guiTop + -48, 12, 20, new StringTextComponent("<"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(30, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 30, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + -20, 8, 20, new StringTextComponent("+"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(31, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 31, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -104, 8, 20, new StringTextComponent("R"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(32, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 32, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + 40, 12, 20, new StringTextComponent("0"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(33, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 33, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 84, this.guiTop + 40, 12, 20, new StringTextComponent("1"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(34, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 34, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + 40, 12, 20, new StringTextComponent("2"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(35, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 35, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 108, this.guiTop + 40, 12, 20, new StringTextComponent("3"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(36, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 36, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 120, this.guiTop + 40, 12, 20, new StringTextComponent("4"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(37, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 37, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 132, this.guiTop + 40, 12, 20, new StringTextComponent("5"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(38, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 38, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 144, this.guiTop + 40, 12, 20, new StringTextComponent("6"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(39, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 39, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 156, this.guiTop + 40, 12, 20, new StringTextComponent("7"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(40, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 40, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 168, this.guiTop + 40, 12, 20, new StringTextComponent("8"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(41, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 41, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 180, this.guiTop + 40, 12, 20, new StringTextComponent("9"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(42, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 42, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + 0, 8, 20, new StringTextComponent("+"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(43, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 43, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + 20, 8, 20, new StringTextComponent("+"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(44, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 44, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + 40, 8, 20, new StringTextComponent("+"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(45, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 45, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + -32, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(46, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 46, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + -48, 12, 20, new StringTextComponent(","), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(47, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 47, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 120, this.guiTop + -48, 12, 20, new StringTextComponent("="), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(48, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 48, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 84, this.guiTop + -48, 12, 20, new StringTextComponent("."), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(49, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 49, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 132, this.guiTop + -48, 12, 20, new StringTextComponent("!"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(50, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 50, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 108, this.guiTop + -48, 12, 20, new StringTextComponent(":"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new AlternativeKeyboardGui.ButtonPressedMessage(51, x, y, z));
				AlternativeKeyboardGui.handleButtonAction(entity, 51, x, y, z);
			}
		}));
	}
}
