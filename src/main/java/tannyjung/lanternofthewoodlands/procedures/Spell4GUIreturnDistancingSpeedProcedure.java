package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIreturnDistancingSpeedProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return ("" + (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_distancing_speed).replace(".0", "") + " / Tick";
	}
}
