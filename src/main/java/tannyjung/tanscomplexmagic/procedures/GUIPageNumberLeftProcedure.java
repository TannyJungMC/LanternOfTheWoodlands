package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class GUIPageNumberLeftProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String variable_text = "";
		variable_text = "000" + new java.text.DecimalFormat("##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_page + 0);
		variable_text = variable_text.substring((variable_text).length() - 3);
		return FontConvertSmallProcedure.execute(variable_text);
	}
}