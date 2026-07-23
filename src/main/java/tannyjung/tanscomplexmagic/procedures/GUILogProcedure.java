package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class GUILogProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String variable_text = "";
		if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_type).equals("mana")) {
			variable_text = "MANA " + new java.text.DecimalFormat("##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana) + " CHARGE "
					+ new java.text.DecimalFormat("##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana_charge);
		} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_type).equals("info")) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_display_info_duration <= 60) {
				variable_text = new java.text.DecimalFormat("##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_display_info_duration) + " > "
						+ entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_display_info;
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_display_info_duration <= 9) {
					variable_text = "0" + variable_text;
				}
			}
		} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_type).equals("notification")) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_display_notification_duration <= 60) {
				variable_text = new java.text.DecimalFormat("##").format(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_display_notification_duration) + " > "
						+ entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_display_notification;
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_display_notification_duration <= 9) {
					variable_text = "0" + variable_text;
				}
			}
		}
		return FontConvertThinProcedure.execute(variable_text);
	}
}