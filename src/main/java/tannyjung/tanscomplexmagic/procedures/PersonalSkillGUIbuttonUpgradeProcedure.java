package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalSkillGUIbuttonUpgradeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("")) {
			if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill).equals("Nothing")) {
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana >= 20) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.mana = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana - 20;
						_vars.personal_skill_level = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_level + 1;
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}