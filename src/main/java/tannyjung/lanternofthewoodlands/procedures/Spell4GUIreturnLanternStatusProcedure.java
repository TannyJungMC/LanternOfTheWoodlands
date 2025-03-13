package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIreturnLanternStatusProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return ("" + 1 * (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_lantern_level).replace(".0", "") + "" + " > "
				+ ("" + 1 * ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_lantern_level + 1)).replace(".0", "") + "";
	}
}
