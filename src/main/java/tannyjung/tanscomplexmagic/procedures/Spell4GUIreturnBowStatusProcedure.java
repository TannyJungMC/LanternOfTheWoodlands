package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIreturnBowStatusProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return ("" + 5 * entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_bow_level).replace(".0", "") + "" + " > "
				+ ("" + 5 * (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_bow_level + 1)).replace(".0", "") + "";
	}
}