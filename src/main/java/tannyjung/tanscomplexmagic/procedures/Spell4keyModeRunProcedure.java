package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4keyModeRunProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("") && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell == 4) {
			if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Off")) {
				if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_mode).equals("Multiple Shot")) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.spell4_mode = "Single Shot";
						_vars.markSyncDirty();
					}
				} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_mode).equals("Single Shot")) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.spell4_mode = "Auto Single Shot";
						_vars.markSyncDirty();
					}
				} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_mode).equals("Auto Single Shot")) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.spell4_mode = "Auto Shot";
						_vars.markSyncDirty();
					}
				} else {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.spell4_mode = "Multiple Shot";
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}