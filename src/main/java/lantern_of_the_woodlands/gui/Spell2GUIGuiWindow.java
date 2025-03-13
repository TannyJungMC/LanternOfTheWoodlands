
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

import lantern_of_the_woodlands.procedures.Spell2checkboxshowallProcedure;
import lantern_of_the_woodlands.procedures.Spell2checkboxShowWaypointProcedure;
import lantern_of_the_woodlands.procedures.Spell2checkboxShowTrackerProcedure;
import lantern_of_the_woodlands.procedures.Spell2checkboxShowPlayerProcedure;
import lantern_of_the_woodlands.procedures.Spell2checkboxShowEntityProcedure;
import lantern_of_the_woodlands.procedures.Spell2checkboxNotifBUOYProcedure;
import lantern_of_the_woodlands.procedures.Spell2cheackboxNotifTrackerProcedure;
import lantern_of_the_woodlands.procedures.Spell2cheackboxNotifProcedure;
import lantern_of_the_woodlands.procedures.Spell2cheackboxNotifOtherTeamProcedure;
import lantern_of_the_woodlands.procedures.Spell2GUILevel4EnableProcedure;
import lantern_of_the_woodlands.procedures.Spell2GUILevel3not2Procedure;
import lantern_of_the_woodlands.procedures.Spell2GUILevel3NotEnableProcedure;
import lantern_of_the_woodlands.procedures.Spell2GUILevel2NotEnableProcedure;
import lantern_of_the_woodlands.procedures.Spell2GUILevel1NotEnableProcedure;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class Spell2GUIGuiWindow extends ContainerScreen<Spell2GUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Spell2GUIGui.guistate;
	CheckboxButton spell2show_all;
	CheckboxButton spell2show_tracker;
	CheckboxButton spell2show_player;
	CheckboxButton spell2show_entity;
	CheckboxButton spell2show_waypoint;
	CheckboxButton spell2_notification;
	CheckboxButton spell2_notification_tracker;
	CheckboxButton spell2_notification_other_team;
	CheckboxButton spell2_notification_buoy;

	public Spell2GUIGuiWindow(Spell2GUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell10.png"));
		this.blit(ms, this.guiLeft + -63, this.guiTop + -96, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/lantern_fire_orb.png"));
		this.blit(ms, this.guiLeft + -55, this.guiTop + -4, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/gold_fireball.png"));
		this.blit(ms, this.guiLeft + -55, this.guiTop + -28, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/green_fireball.png"));
		this.blit(ms, this.guiLeft + -55, this.guiTop + -16, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/blue_fireball.png"));
		this.blit(ms, this.guiLeft + -55, this.guiTop + 8, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/red_fireball.png"));
		this.blit(ms, this.guiLeft + -55, this.guiTop + 20, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/specifyfireball.png"));
		this.blit(ms, this.guiLeft + -55, this.guiTop + 44, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/purple_fireball.png"));
		this.blit(ms, this.guiLeft + -55, this.guiTop + 32, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell2zone.png"));
		this.blit(ms, this.guiLeft + 32, this.guiTop + -128, 0, 0, 160, 160, 160, 160);

		if (Spell2GUILevel4EnableProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("lantern_of_the_woodlands:textures/screens/spell2_2.png"));
			this.blit(ms, this.guiLeft + 48, this.guiTop + -72, 0, 0, 160, 160, 160, 160);
		}
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
		this.font.drawString(ms, "Mana : [ " + (LanternOfTheWoodlandsModVariables.MapVariables.get(world).mana) + " /15.0]", 16, 76, -6710887);
		this.font.drawString(ms, "Eye of The Sea", -43, -92, -16777216);
		this.font.drawString(ms, "", 64, -88, -6750208);
		this.font.drawString(ms, "Entity", -31, 0, -13421773);
		this.font.drawString(ms, "Tracker", -31, 48, -13421773);
		this.font.drawString(ms, "Lantern", -31, -24, -13421773);
		this.font.drawString(ms, "You", -31, -12, -13421773);
		this.font.drawString(ms, "Affiliate", -31, 12, -13421773);
		this.font.drawString(ms, "Other Team", -31, 24, -13421773);
		this.font.drawString(ms, "Buoy", -31, 36, -13421773);
		this.font.drawString(ms, "The spell of detection,", -55, -76, -10079488);
		this.font.drawString(ms, "searching and tracking.", -63, -64, -10079488);
		this.font.drawString(ms, "Detect entity and enemy", -63, -52, -10079488);
		if (Spell2GUILevel3NotEnableProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "501-1,000 blocks", 92, 40, -13421773);
		if (Spell2GUILevel2NotEnableProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "101-500 blocks", 96, 40, -13421773);
		if (Spell2GUILevel1NotEnableProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "10-100 blocks", 100, 40, -13421773);
		this.font.drawString(ms, "around the lantern.", -63, -40, -10079488);
		if (Spell2GUILevel3not2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Radius Upgrade", 96, 4, -10092544);
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
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(0, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -79, this.guiTop + 72, 88, 20, new StringTextComponent("Cancel Spell"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(1, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		spell2show_all = new CheckboxButton(this.guiLeft + -207, this.guiTop + -112, 20, 20, new StringTextComponent("Specify Position"),

				Spell2checkboxshowallProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell2GUIGui.guistate.put("checkbox:spell2show_all", spell2show_all);
		this.addButton(spell2show_all);
		spell2show_tracker = new CheckboxButton(this.guiLeft + -199, this.guiTop + -40, 20, 20, new StringTextComponent("Show Tracker"),

				Spell2checkboxShowTrackerProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell2GUIGui.guistate.put("checkbox:spell2show_tracker", spell2show_tracker);
		this.addButton(spell2show_tracker);
		spell2show_player = new CheckboxButton(this.guiLeft + -199, this.guiTop + -64, 20, 20, new StringTextComponent("Show Player"),

				Spell2checkboxShowPlayerProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell2GUIGui.guistate.put("checkbox:spell2show_player", spell2show_player);
		this.addButton(spell2show_player);
		spell2show_entity = new CheckboxButton(this.guiLeft + -199, this.guiTop + -88, 20, 20, new StringTextComponent("Show Entity"),

				Spell2checkboxShowEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell2GUIGui.guistate.put("checkbox:spell2show_entity", spell2show_entity);
		this.addButton(spell2show_entity);
		spell2show_waypoint = new CheckboxButton(this.guiLeft + -199, this.guiTop + -16, 20, 20, new StringTextComponent("Show Buoy"),

				Spell2checkboxShowWaypointProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell2GUIGui.guistate.put("checkbox:spell2show_waypoint", spell2show_waypoint);
		this.addButton(spell2show_waypoint);
		this.addButton(new Button(this.guiLeft + 200, this.guiTop + -32, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(2, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 80, this.guiTop + 16, 104, 20, new StringTextComponent("15 mana / upgrade"), e -> {
			if (Spell2GUILevel3not2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new Spell2GUIGui.ButtonPressedMessage(3, x, y, z));
				Spell2GUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Spell2GUILevel3not2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		spell2_notification = new CheckboxButton(this.guiLeft + -207, this.guiTop + 16, 20, 20, new StringTextComponent("Notification"),

				Spell2cheackboxNotifProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell2GUIGui.guistate.put("checkbox:spell2_notification", spell2_notification);
		this.addButton(spell2_notification);
		spell2_notification_tracker = new CheckboxButton(this.guiLeft + -199, this.guiTop + 40, 20, 20, new StringTextComponent("Tracker"),

				Spell2cheackboxNotifTrackerProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell2GUIGui.guistate.put("checkbox:spell2_notification_tracker", spell2_notification_tracker);
		this.addButton(spell2_notification_tracker);
		spell2_notification_other_team = new CheckboxButton(this.guiLeft + -199, this.guiTop + 64, 20, 20, new StringTextComponent("Other Team"),

				Spell2cheackboxNotifOtherTeamProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell2GUIGui.guistate.put("checkbox:spell2_notification_other_team", spell2_notification_other_team);
		this.addButton(spell2_notification_other_team);
		spell2_notification_buoy = new CheckboxButton(this.guiLeft + -199, this.guiTop + 88, 20, 20, new StringTextComponent("Buoy"),

				Spell2checkboxNotifBUOYProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)));
		Spell2GUIGui.guistate.put("checkbox:spell2_notification_buoy", spell2_notification_buoy);
		this.addButton(spell2_notification_buoy);
	}
}
