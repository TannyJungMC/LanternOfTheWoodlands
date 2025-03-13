
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

import lotw.procedures.Spell6pauseTRUEProcedure;
import lotw.procedures.Spell6pauseFALSEProcedure;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Spell6GUIGuiWindow extends ContainerScreen<Spell6GUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Spell6GUIGui.guistate;

	public Spell6GUIGuiWindow(Spell6GUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell12.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/spell6image.png"));
		this.blit(ms, this.guiLeft + -83, this.guiTop + -124, 0, 0, 160, 160, 160, 160);

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
		this.font.drawString(ms, "MOON SHINES", -43, -92, -16777216);
		this.font.drawString(ms, "The spell of illusion.", -55, -76, -10079488);
		this.font.drawString(ms, "and unreal blocks to", -63, -52, -10079488);
		this.font.drawString(ms, "create unreal entities", -63, -64, -10079488);
		this.font.drawString(ms, "hiding or make a decoy.", -63, -40, -10079488);
		this.font.drawString(ms, "Oak Tree x1", 72, -92, -10092442);
		this.font.drawString(ms, "Grass x8", 73, -68, -10066432);
		this.font.drawString(ms, "Dirt x8", 72, -44, -10066432);
		this.font.drawString(ms, "Stone x8", 72, -20, -10066432);
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
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(0, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + 72, 88, 20, new StringTextComponent("Cancel Spell"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(1, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -63, this.guiTop + 36, 52, 20, new StringTextComponent("Show"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(2, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + 36, 52, 20, new StringTextComponent("Hide"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(3, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 52, this.guiTop + 36, 8, 20, new StringTextComponent(">"), e -> {
			if (Spell6pauseTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(4, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell6pauseTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 44, this.guiTop + 36, 8, 20, new StringTextComponent("="), e -> {
			if (Spell6pauseFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(5, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell6pauseFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 140, this.guiTop + -96, 44, 20, new StringTextComponent("1 mana"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(6, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 184, this.guiTop + -96, 8, 20, new StringTextComponent("X"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(7, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 44, this.guiTop + 36, 8, 20, new StringTextComponent(" "), e -> {
			if (Spell6pauseTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(8, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell6pauseTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 52, this.guiTop + 36, 8, 20, new StringTextComponent(" "), e -> {
			if (Spell6pauseFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(9, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell6pauseFALSEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 140, this.guiTop + -72, 44, 20, new StringTextComponent("1 mana"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(10, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 184, this.guiTop + -72, 8, 20, new StringTextComponent("X"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(11, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 140, this.guiTop + -48, 44, 20, new StringTextComponent("1 mana"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(12, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 12, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 184, this.guiTop + -48, 8, 20, new StringTextComponent("X"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(13, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 13, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 140, this.guiTop + -24, 44, 20, new StringTextComponent("1 mana"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(14, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 14, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 184, this.guiTop + -24, 8, 20, new StringTextComponent("X"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell6GUIGui.ButtonPressedMessage(15, x, y, z));
				Spell6GUIGui.handleButtonAction(entity, 15, x, y, z);
			}
		}));
	}
}
