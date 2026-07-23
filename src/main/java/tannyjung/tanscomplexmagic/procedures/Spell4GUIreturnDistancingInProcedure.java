package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIreturnDistancingInProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return ("" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distancing_in).replace(".0", "");
	}
}