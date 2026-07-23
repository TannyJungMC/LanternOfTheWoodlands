package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class GUICompassCustomProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double variable_number = 0;
		double posX = 0;
		double posZ = 0;
		double current_direction = 0;
		posX = entity.getX() - entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_compass_custom_posX;
		posZ = entity.getZ() - entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_compass_custom_posZ;
		variable_number = Math.floor((Math.toDegrees(Math.atan2(posZ, posX)) + 360) % 360) + 90;
		if (true) {
			current_direction = entity.getYRot() * (-1);
			current_direction = Math.floor(((current_direction % 360) + 360) % 360);
			variable_number = variable_number + current_direction;
		}
		while (variable_number > 360) {
			variable_number = variable_number - 360;
		}
		variable_number = Math.round(variable_number / 45);
		if (variable_number == 8) {
			variable_number = 0;
		}
		return variable_number;
	}
}