package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalWeaponGUIreturnPoseYProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (new java.text.DecimalFormat("##.##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pose_y)).replace(".0", "");
	}
}