package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIreturnSwordStatusProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return ("" + 5 * entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_sword_level).replace(".0", "") + "s" + " > "
				+ ("" + 5 * (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_sword_level + 1)).replace(".0", "") + "s";
	}
}