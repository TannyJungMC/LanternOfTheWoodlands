package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalSkillGUIbuttonSkillTheMissingPersonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("")) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_skill_the_missing_person == false) {
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana >= 60) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.mana = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana - 60;
						_vars.personal_skill_skill_the_missing_person = true;
						_vars.markSyncDirty();
					}
				}
			} else {
				if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill).equals("The Missing Person")) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.personal_skill_level = 1;
						_vars.personal_skill = "The Missing Person";
						_vars.personal_skill_cooldown = 10;
						_vars.personal_skill_duration = 10;
						_vars.personal_skill_radius = 0;
						_vars.personal_skill_custom = "";
						_vars.personal_skill_custom_value = "";
						_vars.personal_skill_upgrade = "Duration";
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}