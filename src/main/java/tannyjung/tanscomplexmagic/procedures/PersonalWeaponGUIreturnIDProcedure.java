package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;

public class PersonalWeaponGUIreturnIDProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String variable_text = "";
		if ((BuiltInRegistries.ITEM.getKey(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon.getItem()).toString()).equals("minecraft:air")) {
			variable_text = "No Required";
		} else {
			variable_text = BuiltInRegistries.ITEM.getKey(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon.getItem()).toString();
		}
		return variable_text;
	}
}