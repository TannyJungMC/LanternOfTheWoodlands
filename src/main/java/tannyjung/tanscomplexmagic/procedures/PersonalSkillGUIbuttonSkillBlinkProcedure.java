package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalSkillGUIbuttonSkillBlinkProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("")) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_skill_blink == false) {
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana >= 60) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.mana = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana - 60;
						_vars.personal_skill_skill_blink = true;
						_vars.markSyncDirty();
					}
				}
			} else {
				if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill).equals("Blink")) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.personal_skill_level = 1;
						_vars.personal_skill = "Blink";
						_vars.personal_skill_cooldown = 5;
						_vars.personal_skill_duration = 0;
						_vars.personal_skill_radius = 0;
						_vars.personal_skill_custom = "Distance";
						_vars.personal_skill_custom_value = "5";
						_vars.personal_skill_upgrade = "Components";
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}