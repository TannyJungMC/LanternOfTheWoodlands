package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class KEYSpell4ReverseRunProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user == true && Math.floor(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell) == 4) {
			if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Off")) {
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_lock_reverse == true) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_reverse == true) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_reverse = false;
							_vars.markSyncDirty();
						}
					} else {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_reverse = true;
							_vars.markSyncDirty();
						}
					}
				} else {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.spell4_reverse = true;
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}