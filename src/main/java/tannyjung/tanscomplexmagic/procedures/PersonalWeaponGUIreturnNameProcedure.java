package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalWeaponGUIreturnNameProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String variable_text = "";
		if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon.getDisplayName().getString()).equals("[Air]")) {
			variable_text = "No Required";
		} else {
			variable_text = (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon.getDisplayName().getString()).substring(1,
					(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon.getDisplayName().getString()).length() - 1);
		}
		return variable_text;
	}
}