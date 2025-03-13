package lantern_of_the_woodlands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.client.gui.widget.button.CheckboxButton;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;
import java.util.HashMap;

public class Spell2GUItestProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell2GUItest!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency guistate for procedure Spell2GUItest!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell2show_all");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_all = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_all = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell2show_entity");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_entity = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_entity = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell2show_player");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_player = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_player = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell2show_tracker");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_tracker = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_tracker = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell2show_waypoint");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_waypoint = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_waypoint = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell2_notification");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell2_notification_tracker");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification_tracker = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification_tracker = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell2_notification_other_team");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification_other_team = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification_other_team = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell2_notification_buoy");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification_buoy = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification_buoy = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
