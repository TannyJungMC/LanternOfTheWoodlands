package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class GUIreturnManaProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Charge " + (new java.text.DecimalFormat("##.##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana_charge)).replace("", "") + "/" + "60" + " | Mana "
				+ (new java.text.DecimalFormat("##.##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana)).replace("", "") + "/"
				+ (new java.text.DecimalFormat("##.##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana_max)).replace("", "");
	}
}