package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class GUILogTypeProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double variable_number = 0;
		if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_type).equals("mana")) {
			variable_number = 1;
		} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_type).equals("info")) {
			variable_number = 2;
		} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_type).equals("notification")) {
			variable_number = 3;
		}
		return variable_number;
	}
}