package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class OVERLAYSpell4AbilityDurationProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double variable_number = 0;
		return Math.ceil((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_duration / entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_duration_max) * 18);
	}
}