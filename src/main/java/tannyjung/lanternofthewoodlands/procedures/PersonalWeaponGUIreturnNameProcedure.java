package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalWeaponGUIreturnNameProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String variable_text = "";
		if ((((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_weapon).getDisplayName().getString()).equals("[Air]")) {
			variable_text = "No Required";
		} else {
			variable_text = (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_weapon).getDisplayName().getString()).substring(1,
					(int) ((((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_weapon).getDisplayName().getString()).length() - 1));
		}
		return variable_text;
	}
}
