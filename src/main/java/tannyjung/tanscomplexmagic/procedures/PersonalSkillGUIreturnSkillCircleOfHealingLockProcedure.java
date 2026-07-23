package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalSkillGUIreturnSkillCircleOfHealingLockProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_skill_skill_circle_of_healing == false;
	}
}