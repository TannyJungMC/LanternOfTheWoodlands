package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class GetManaCreativeLoopProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
			_vars.mana_charge = 0;
			_vars.mana = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana_max;
			_vars.markSyncDirty();
		}
	}
}