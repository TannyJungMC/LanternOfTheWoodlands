package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalSkillGUIbuttonSkillCircleOfHealingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("")) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_skill_circle_of_healing == false) {
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana >= 60) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.mana = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana - 60;
						_vars.personal_skill_skill_circle_of_healing = true;
						_vars.markSyncDirty();
					}
				}
			} else {
				if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill).equals("Circle of Healing")) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.personal_skill_level = 1;
						_vars.personal_skill = "Circle of Healing";
						_vars.personal_skill_cooldown = 10;
						_vars.personal_skill_duration = 0;
						_vars.personal_skill_radius = 2.5;
						_vars.personal_skill_custom = "Health Recovery";
						_vars.personal_skill_custom_value = "4";
						_vars.personal_skill_upgrade = "Custom";
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}