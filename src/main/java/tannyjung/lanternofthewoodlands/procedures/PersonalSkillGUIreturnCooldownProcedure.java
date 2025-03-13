package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalSkillGUIreturnCooldownProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (new java.text.DecimalFormat("##.##").format((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_skill_cooldown))
				.replace(".0", "") + "s";
	}
}
