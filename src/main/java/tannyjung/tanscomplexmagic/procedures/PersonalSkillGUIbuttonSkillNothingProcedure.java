package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalSkillGUIbuttonSkillNothingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("")) {
			{
				TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
				_vars.personal_skill_level = 0;
				_vars.personal_skill = "Nothing";
				_vars.personal_skill_cooldown = 0;
				_vars.personal_skill_duration = 0;
				_vars.personal_skill_radius = 0;
				_vars.personal_skill_custom = "";
				_vars.personal_skill_custom_value = "";
				_vars.personal_skill_upgrade = "";
				_vars.markSyncDirty();
			}
		}
	}
}