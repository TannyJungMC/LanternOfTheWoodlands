package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIreturnSwordCountProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return ("" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_sword_count).replace(".0", "") + "/"
				+ ("" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_sword_count_max).replace(".0", "");
	}
}