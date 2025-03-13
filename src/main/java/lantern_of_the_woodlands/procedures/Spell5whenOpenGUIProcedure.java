package lantern_of_the_woodlands.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.client.gui.widget.TextFieldWidget;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;
import java.util.HashMap;

public class Spell5whenOpenGUIProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell5whenOpenGUI!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency guistate for procedure Spell5whenOpenGUI!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;

			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_radius");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius);
					}
				}
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_safe_zone");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone);
					}
				}
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_circle");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency);
					}
				}
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_degree");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_degree_frequency);
					}
				}
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_down");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_down);
					}
				}
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_height");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_height);
					}
				}
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_thickness");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_thickness);
					}
				}
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_room");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_room);
					}
				}
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_no_wall");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_no_wall);
					}
				}
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_trap");
					if (_tf != null) {
						_tf.setText(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_trap);
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 20);
	}
}
