
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

import lotw.procedures.Spell1startEffectNot13Procedure;
import lotw.procedures.Spell1startEffect13Procedure;
import lotw.procedures.Spell1infoEffect13Procedure;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Spell1GUIpage3GuiWindow extends ContainerScreen<Spell1GUIpage3Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Spell1GUIpage3Gui.guistate;

	public Spell1GUIpage3GuiWindow(Spell1GUIpage3Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_door13.png"));
		this.blit(ms, this.guiLeft + -207, this.guiTop + -116, 0, 0, 32, 32, 32, 32);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lotw:textures/screens/zodiac_circle.png"));
		this.blit(ms, this.guiLeft + -50, this.guiTop + -49, 0, 0, 99, 99, 99, 99);

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
		this.font.drawString(ms, "Mana : [" + (int) (LotwModVariables.MapVariables.get(world).mana) + "/30]", -39, -104, -6710887);
		if (Spell1startEffect13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + (LotwModVariables.MapVariables.get(world).spell1_effect13) + "", -7, -84, -10066330);
		this.font.drawString(ms, "XIII | Ophiuchus", -187, -116, -3355444);
		if (Spell1infoEffect13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "-80% Incoming Damage", -187, -104, -6710887);
		if (Spell1infoEffect13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "-4 Attack damage", -187, -92, -6710887);
		this.font.drawString(ms, "Effect Limit : [" + (int) (LotwModVariables.MapVariables.get(world).spell1_effect_count) + "/"
				+ (int) (LotwModVariables.MapVariables.get(world).spell1_effect_count_max) + "]", -47, -116, -6710887);
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
		this.addButton(new Button(this.guiLeft + -207, this.guiTop + 100, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage3Gui.ButtonPressedMessage(0, x, y, z));
				Spell1GUIpage3Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -187, this.guiTop + -104, 48, 20, new StringTextComponent("30 mana"), e -> {
			if (Spell1startEffectNot13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage3Gui.ButtonPressedMessage(1, x, y, z));
				Spell1GUIpage3Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffectNot13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + -72, 20, 20, new StringTextComponent("XIII"), e -> {
			if (Spell1startEffect13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage3Gui.ButtonPressedMessage(2, x, y, z));
				Spell1GUIpage3Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell1startEffect13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -199, this.guiTop + 100, 8, 20, new StringTextComponent("?"), e -> {
			if (true) {
				LotwMod.PACKET_HANDLER.sendToServer(new Spell1GUIpage3Gui.ButtonPressedMessage(3, x, y, z));
				Spell1GUIpage3Gui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
