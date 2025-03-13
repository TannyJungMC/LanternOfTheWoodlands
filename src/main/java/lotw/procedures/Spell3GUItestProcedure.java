package lotw.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.client.gui.widget.button.CheckboxButton;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;
import java.util.HashMap;

public class Spell3GUItestProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell3GUItest!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				LotwMod.LOGGER.warn("Failed to load dependency guistate for procedure Spell3GUItest!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		LotwModVariables.MapVariables.get(world).spell3_time_minute = Math.floor(LotwModVariables.MapVariables.get(world).spell3_time / 60);
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_time_second = (LotwModVariables.MapVariables.get(world).spell3_time
				- Math.floor(LotwModVariables.MapVariables.get(world).spell3_time / 60) * 60);
		LotwModVariables.MapVariables.get(world).syncData(world);
		if (LotwModVariables.MapVariables.get(world).spell3_gen == true) {
			if (LotwModVariables.MapVariables.get(world).spell3_time > 0) {
				LotwModVariables.MapVariables.get(world).spell3_show_percent_status = "Creating";
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell3_show_percent = ((new java.text.DecimalFormat("##.#").format(Math.round(
						((LotwModVariables.MapVariables.get(world).spell3_time * 100) / LotwModVariables.MapVariables.get(world).spell3_percent_full)
								* (-1) + 100)))
						.replace(".0", ""));
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).spell3_show_percent = "100";
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell3_show_percent_status = "Repairing";
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			if (LotwModVariables.MapVariables.get(world).spell3_time > 0) {
				if (LotwModVariables.MapVariables.get(world).spell3_start == true) {
					if ((LotwModVariables.MapVariables.get(world).spell3_show_percent).equals("0")) {
						LotwModVariables.MapVariables.get(world).spell3_show_percent_status = "Waiting";
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else {
						LotwModVariables.MapVariables.get(world).spell3_show_percent_status = "Removing";
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LotwModVariables.MapVariables.get(world).spell3_start == false) {
					LotwModVariables.MapVariables.get(world).spell3_show_percent_status = "Nothing";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (0 <= ((LotwModVariables.MapVariables.get(world).spell3_time * 100) / LotwModVariables.MapVariables.get(world).spell3_percent_full)
						* (-1) + 100) {
					LotwModVariables.MapVariables.get(world).spell3_show_percent = ((new java.text.DecimalFormat("##")
							.format(((LotwModVariables.MapVariables.get(world).spell3_time * 100)
									/ LotwModVariables.MapVariables.get(world).spell3_percent_full) * (-1) + 100))
							.replace(".0", ""));
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (0 > ((LotwModVariables.MapVariables.get(world).spell3_time * 100) / LotwModVariables.MapVariables.get(world).spell3_percent_full)
						* (-1) + 100) {
					LotwModVariables.MapVariables.get(world).spell3_show_percent = "0";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			} else {
				LotwModVariables.MapVariables.get(world).spell3_show_percent_status = "Nothing";
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell3_show_percent = "100";
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		}
		if (LotwModVariables.MapVariables.get(world).spell3_time > 0) {
			if (Math.round(LotwModVariables.MapVariables.get(world).spell3_time_second) >= 10) {
				LotwModVariables.MapVariables.get(world).spell3_show_time = ((new java.text.DecimalFormat("##.#")
						.format(Math.round(LotwModVariables.MapVariables.get(world).spell3_time_minute))).replace(".0", "") + ":"
						+ (new java.text.DecimalFormat("##.#").format(Math.round(LotwModVariables.MapVariables.get(world).spell3_time_second)))
								.replace(".0", ""));
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).spell3_show_time = ((new java.text.DecimalFormat("##.#")
						.format(Math.round(LotwModVariables.MapVariables.get(world).spell3_time_minute))).replace(".0", "") + ":0"
						+ (new java.text.DecimalFormat("##.#").format(Math.round(LotwModVariables.MapVariables.get(world).spell3_time_second)))
								.replace(".0", ""));
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			LotwModVariables.MapVariables.get(world).spell3_show_time = "0:00";
			LotwModVariables.MapVariables.get(world).syncData(world);
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
			LotwModVariables.MapVariables.get(world).spell3_no_block = (true);
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			LotwModVariables.MapVariables.get(world).spell3_no_block = (false);
			LotwModVariables.MapVariables.get(world).syncData(world);
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
			LotwModVariables.MapVariables.get(world).spell3_particle = (true);
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			LotwModVariables.MapVariables.get(world).spell3_particle = (false);
			LotwModVariables.MapVariables.get(world).syncData(world);
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
			LotwModVariables.MapVariables.get(world).spell3_walk = (true);
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			LotwModVariables.MapVariables.get(world).spell3_walk = (false);
			LotwModVariables.MapVariables.get(world).syncData(world);
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
			LotwModVariables.MapVariables.get(world).spell3_invisible_dome = (true);
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			LotwModVariables.MapVariables.get(world).spell3_invisible_dome = (false);
			LotwModVariables.MapVariables.get(world).syncData(world);
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
			LotwModVariables.MapVariables.get(world).spell3_dome_particle = (true);
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			LotwModVariables.MapVariables.get(world).spell3_dome_particle = (false);
			LotwModVariables.MapVariables.get(world).syncData(world);
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
			LotwModVariables.MapVariables.get(world).spell3_block_arrow = (true);
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			LotwModVariables.MapVariables.get(world).spell3_block_arrow = (false);
			LotwModVariables.MapVariables.get(world).syncData(world);
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
			LotwModVariables.MapVariables.get(world).spell3_block_damage = (true);
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			LotwModVariables.MapVariables.get(world).spell3_block_damage = (false);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
