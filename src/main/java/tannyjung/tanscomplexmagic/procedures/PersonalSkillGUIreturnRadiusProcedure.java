package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalSkillGUIreturnRadiusProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String variable_text = "";
		if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_upgrade).equals("Radius")) {
			variable_text = (new java.text.DecimalFormat("##.##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_radius * entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_level))
					.replace(".0", "") + " > "
					+ (new java.text.DecimalFormat("##.##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_radius * (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_level + 1)))
							.replace(".0", "");
		} else {
			variable_text = (new java.text.DecimalFormat("##.##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_radius)).replace(".0", "");
		}
		return variable_text;
	}
}