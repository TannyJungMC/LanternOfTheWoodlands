package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class GUIreturnManaProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Charge "
				+ (new java.text.DecimalFormat("##.##").format((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).mana_charge)).replace("", "")
				+ "/" + "60" + " | Mana "
				+ (new java.text.DecimalFormat("##.##").format((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).mana)).replace("", "") + "/"
				+ (new java.text.DecimalFormat("##.##").format((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).mana_max)).replace("", "");
	}
}
