package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIreturnTypeNotOffProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell == 4
				&& !((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("") || (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Off"))
				&& entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_show_overlay == true;
	}
}