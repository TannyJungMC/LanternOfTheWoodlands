package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIreturnPauseRotationProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String variable_text = "";
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_pause_rotation == 0) {
			variable_text = "No Rotation";
		}
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_pause_rotation == 0.01) {
			variable_text = "Right";
		}
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_pause_rotation == -0.01) {
			variable_text = "Left";
		}
		return variable_text;
	}
}