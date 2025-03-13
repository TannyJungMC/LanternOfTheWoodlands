package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIreturnAbilityDurationProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String variable_text = "";
		double variable_number = 0;
		variable_number = (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_ability_duration;
		if (variable_number <= 9) {
			variable_text = "0" + ("" + variable_number).replace(".0", "");
		} else if (variable_number >= 10 && variable_number <= 60) {
			variable_text = ("" + variable_number).replace(".0", "");
		} else if (variable_number >= 61 && variable_number <= 600) {
			variable_text = "0" + ("" + Math.floor(variable_number / 60)).replace(".0", "");
		} else if (variable_number >= 601 && variable_number <= 3600) {
			variable_text = ("" + Math.floor(variable_number / 60)).replace(".0", "");
		} else if (variable_number >= 3601) {
			variable_text = ("" + Math.floor(variable_number / 3600)).replace(".0", "") + "h";
		}
		return variable_text;
	}
}
