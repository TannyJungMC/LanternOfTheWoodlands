package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIreturnAbilityDurationTrueProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_duration >= 0 && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_cooldown >= 0;
	}
}