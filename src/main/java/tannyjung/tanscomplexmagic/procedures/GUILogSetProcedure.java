package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class GUILogSetProcedure {
	public static void execute(Entity entity, String text, String type) {
		if (entity == null || text == null || type == null)
			return;
		if ((type).equals("info")) {
			{
				TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
				_vars.book_log_display_info = text;
				_vars.book_log_display_info_duration = 0;
				_vars.markSyncDirty();
			}
		} else if ((type).equals("notification")) {
			{
				TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
				_vars.book_log_display_notification = text;
				_vars.book_log_display_notification_duration = 0;
				_vars.markSyncDirty();
			}
		}
	}
}