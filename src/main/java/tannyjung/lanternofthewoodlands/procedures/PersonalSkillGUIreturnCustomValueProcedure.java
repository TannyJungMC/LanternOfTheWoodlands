package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.Entity;

public class PersonalSkillGUIreturnCustomValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String variable_text = "";
		if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_skill_upgrade).equals("Custom")) {
			variable_text = (new java.text.DecimalFormat("##.##").format(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_skill_custom_value)
					* (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_skill_level)).replace(".0", "") + " > "
					+ (new java.text.DecimalFormat("##.##").format(new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_skill_custom_value)
							* ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_skill_level + 1))).replace(".0", "");
		} else {
			if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_skill_custom).equals("")) {
				variable_text = "";
			} else {
				variable_text = (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_skill_custom_value;
			}
		}
		return variable_text;
	}
}
