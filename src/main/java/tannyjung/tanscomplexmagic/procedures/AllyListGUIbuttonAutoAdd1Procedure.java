package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class AllyListGUIbuttonAutoAdd1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("")) {
			if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_auto1).equals("")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.ally_list_auto1 = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).alternative_keyboard;
					_vars.markSyncDirty();
				}
			}
		}
	}
}