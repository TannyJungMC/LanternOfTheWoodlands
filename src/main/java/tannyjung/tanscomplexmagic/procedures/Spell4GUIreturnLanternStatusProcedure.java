package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIreturnLanternStatusProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return ("" + 1 * entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_lantern_level).replace(".0", "") + "" + " > "
				+ ("" + 1 * (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_lantern_level + 1)).replace(".0", "") + "";
	}
}