package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalSkillGUIbuttonSkillRejuvenatingMushroomProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("")) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_skill_rejuvenating_mushroom == false) {
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana >= 60) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.mana = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana - 60;
						_vars.personal_skill_skill_rejuvenating_mushroom = true;
						_vars.markSyncDirty();
					}
				}
			} else {
				if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill).equals("Rejuvenating Mushroom")) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.personal_skill_level = 1;
						_vars.personal_skill = "Rejuvenating Mushroom";
						_vars.personal_skill_cooldown = 5;
						_vars.personal_skill_duration = 2;
						_vars.personal_skill_radius = 1.5;
						_vars.personal_skill_custom = "Health Recovery";
						_vars.personal_skill_custom_value = "20";
						_vars.personal_skill_upgrade = "Duration";
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}