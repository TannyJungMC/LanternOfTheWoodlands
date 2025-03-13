package tannyjung.lanternofthewoodlands.procedures;

import net.minecraft.world.entity.Entity;

public class GUICompassProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double variable_number = 0;
		variable_number = entity.getYRot() * (-1);
		variable_number = Math.round(Math.floor(((variable_number % 360) + 360) % 360) / 45);
		if (variable_number == 8) {
			variable_number = 0;
		}
		return variable_number;
	}
}
