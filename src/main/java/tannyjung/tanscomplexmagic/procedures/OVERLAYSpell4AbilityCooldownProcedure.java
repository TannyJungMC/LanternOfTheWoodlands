package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class OVERLAYSpell4AbilityCooldownProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return Math.ceil((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_cooldown / entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_cooldown_max) * 18);
	}
}