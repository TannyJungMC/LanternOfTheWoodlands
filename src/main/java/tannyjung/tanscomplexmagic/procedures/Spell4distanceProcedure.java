package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4distanceProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distance_set == 1) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distance > 0) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_distance = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distance - 1;
					_vars.markSyncDirty();
				}
			}
		}
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distance_set == 2) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distance < 100) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_distance = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distance + 1;
					_vars.markSyncDirty();
				}
			}
		}
	}
}