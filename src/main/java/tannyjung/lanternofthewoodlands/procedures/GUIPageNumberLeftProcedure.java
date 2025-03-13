package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class GUIPageNumberLeftProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String variable_text = "";
		variable_text = "000" + new java.text.DecimalFormat("##").format((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).book_page + 0);
		variable_text = variable_text.substring((int) ((variable_text).length() - 3));
		return FontConvertSmallProcedure.execute(variable_text);
	}
}
