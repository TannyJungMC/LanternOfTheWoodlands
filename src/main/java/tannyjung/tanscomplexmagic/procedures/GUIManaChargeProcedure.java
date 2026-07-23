package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class GUIManaChargeProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana_charge;
	}
}