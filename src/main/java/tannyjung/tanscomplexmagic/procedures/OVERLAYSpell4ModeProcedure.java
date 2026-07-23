package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class OVERLAYSpell4ModeProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double variable_number = 0;
		if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_mode).equals("Multiple Shot")) {
			variable_number = 0;
		} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_mode).equals("Single Shot")) {
			variable_number = 1;
		} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_mode).equals("Auto Single Shot")) {
			variable_number = 2;
		} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_mode).equals("Auto Shot")) {
			variable_number = 3;
		}
		return variable_number;
	}
}