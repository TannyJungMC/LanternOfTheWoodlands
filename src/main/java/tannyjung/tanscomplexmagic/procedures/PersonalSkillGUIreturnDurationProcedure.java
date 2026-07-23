package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalSkillGUIreturnDurationProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String variable_text = "";
		if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_upgrade).equals("Duration")) {
			variable_text = (new java.text.DecimalFormat("##.##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_duration * entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_level))
					.replace(".0", "") + "s" + " > "
					+ (new java.text.DecimalFormat("##.##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_duration * (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_level + 1)))
							.replace(".0", "")
					+ "s";
		} else {
			variable_text = (new java.text.DecimalFormat("##.##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_duration)).replace(".0", "") + "s";
		}
		return variable_text;
	}
}