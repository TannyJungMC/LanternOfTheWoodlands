package lantern_of_the_woodlands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.client.gui.widget.button.CheckboxButton;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;
import java.util.HashMap;

public class Spell3GUItestProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell3GUItest!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency guistate for procedure Spell3GUItest!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time_minute = Math
				.floor(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time / 60);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables
				.get(world).spell3_time_second = (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time
						- Math.floor(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time / 60) * 60);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_gen == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time > 0) {
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_show_percent_status = "Creating";
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_show_percent = ((new java.text.DecimalFormat("##.#")
						.format(Math.round(((LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time * 100)
								/ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_percent_full) * (-1) + 100)))
						.replace(".0", ""));
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			} else {
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_show_percent = "100";
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_show_percent_status = "Repairing";
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time > 0) {
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_start == true) {
					if ((LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_show_percent).equals("0")) {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_show_percent_status = "Waiting";
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
					} else {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_show_percent_status = "Removing";
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_start == false) {
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_show_percent_status = "Nothing";
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				}
				if (0 <= ((LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time * 100)
						/ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_percent_full) * (-1) + 100) {
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_show_percent = ((new java.text.DecimalFormat("##")
							.format(((LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time * 100)
									/ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_percent_full) * (-1) + 100))
							.replace(".0", ""));
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				}
				if (0 > ((LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time * 100)
						/ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_percent_full) * (-1) + 100) {
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_show_percent = "0";
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				}
			} else {
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_show_percent_status = "Nothing";
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_show_percent = "100";
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time > 0) {
			if (Math.round(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time_second) >= 10) {
				LanternOfTheWoodlandsModVariables.MapVariables
						.get(world).spell3_show_time = ((new java.text.DecimalFormat("##.#")
								.format(Math.round(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time_minute))).replace(".0", "")
								+ ":"
								+ (new java.text.DecimalFormat("##.#")
										.format(Math.round(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time_second)))
										.replace(".0", ""));
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			} else {
				LanternOfTheWoodlandsModVariables.MapVariables
						.get(world).spell3_show_time = ((new java.text.DecimalFormat("##.#")
								.format(Math.round(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time_minute))).replace(".0", "")
								+ ":0"
								+ (new java.text.DecimalFormat("##.#")
										.format(Math.round(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time_second)))
										.replace(".0", ""));
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_show_time = "0:00";
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell3_no_block");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_no_block = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_no_block = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell3_particle");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_particle = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_particle = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell3_walk");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_walk = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_walk = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell3_invisible_dome");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_invisible_dome = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_invisible_dome = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell3_particle_dome");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_dome_particle = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_dome_particle = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell3_block_arrow");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_block_arrow = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_block_arrow = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:spell3_block_damage");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue()) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_block_damage = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_block_damage = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
