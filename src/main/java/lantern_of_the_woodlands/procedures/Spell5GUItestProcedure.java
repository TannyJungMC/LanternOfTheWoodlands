package lantern_of_the_woodlands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.client.gui.widget.button.CheckboxButton;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;
import java.util.HashMap;

public class Spell5GUItestProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell5GUItest!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency guistate for procedure Spell5GUItest!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if ((new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell5_always_gen");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) == true) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_always_gen = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_always_gen = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if ((new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell5_show_trap");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) == true) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_show_trap = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_show_trap = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
