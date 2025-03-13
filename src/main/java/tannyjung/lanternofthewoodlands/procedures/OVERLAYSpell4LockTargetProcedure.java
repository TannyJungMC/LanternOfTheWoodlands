package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class OVERLAYSpell4LockTargetProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double variable_number = 0;
		if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_lock_target == false) {
			variable_number = 0;
		} else {
			variable_number = 1;
		}
		return variable_number;
	}
}
