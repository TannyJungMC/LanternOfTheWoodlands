
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
public class UserPackGUIGuiWindow extends ContainerScreen<UserPackGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = UserPackGUIGui.guistate;

	public UserPackGUIGuiWindow(UserPackGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 0;
		this.ySize = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("lotw:textures/screens/user_pack_gui.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/basicspell13.png"));
		this.blit(ms, this.guiLeft + 72, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/basicspell12.png"));
		this.blit(ms, this.guiLeft + 72, this.guiTop + -16, 0, 0, 16, 16, 16, 16);

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
		this.font.drawString(ms, "THE PLANT HUNTER'S", 92, -92, -16777216);
		this.font.drawString(ms, "BOTTLE OF MANA", 92, -12, -16777216);
		this.font.drawString(ms, "BAG", 92, -80, -16777216);
		this.font.drawString(ms, "Store 150 mana into", 80, 4, -10079488);
		this.font.drawString(ms, "the bottle.", 72, 16, -10079488);
		this.font.drawString(ms, "for use in spells.", 72, -52, -10079488);
		this.font.drawString(ms, "Store items and plant", 80, -64, -10079488);
		this.font.drawString(ms, "Mana : [" + (int) (LotwModVariables.MapVariables.get(world).mana) + "/30]", -79, 76, -6710887);
		this.font.drawString(ms, "USER", -11, -32, -16777216);
		this.font.drawString(ms, "PACK", -11, -20, -16777216);
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
				LotwMod.PACKET_HANDLER.sendToServer(new UserPackGUIGui.ButtonPressedMessage(0, x, y, z));
				UserPackGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + -40, 96, 20, new StringTextComponent("30 mana"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new UserPackGUIGui.ButtonPressedMessage(1, x, y, z));
				UserPackGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 72, this.guiTop + 40, 96, 20, new StringTextComponent("30 mana"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new UserPackGUIGui.ButtonPressedMessage(2, x, y, z));
				UserPackGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 176, this.guiTop + 40, 16, 20, new StringTextComponent("X"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new UserPackGUIGui.ButtonPressedMessage(3, x, y, z));
				UserPackGUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 176, this.guiTop + -40, 16, 20, new StringTextComponent("X"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new UserPackGUIGui.ButtonPressedMessage(4, x, y, z));
				UserPackGUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + -32, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new UserPackGUIGui.ButtonPressedMessage(5, x, y, z));
				UserPackGUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -32, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new UserPackGUIGui.ButtonPressedMessage(6, x, y, z));
				UserPackGUIGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + -104, 8, 20, new StringTextComponent("{"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new UserPackGUIGui.ButtonPressedMessage(7, x, y, z));
				UserPackGUIGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 112, this.guiTop + 72, 48, 20, new StringTextComponent("Back"), e -> {
			if (ReturnLanternGoundTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new UserPackGUIGui.ButtonPressedMessage(8, x, y, z));
				UserPackGUIGui.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (ReturnLanternGoundTRUEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
