package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalSkillGUIreturnSkillTheMissingPersonProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_skill).equals("The Missing Person");
	}
}
