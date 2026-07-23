package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class GUILogTypeSetProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_type).equals("")) {
			{
				TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
				_vars.book_log_type = "mana";
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_type).equals("mana")) {
			{
				TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
				_vars.book_log_type = "info";
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_log_type).equals("info")) {
			{
				TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
				_vars.book_log_type = "notification";
				_vars.markSyncDirty();
			}
		} else {
			{
				TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
				_vars.book_log_type = "";
				_vars.markSyncDirty();
			}
		}
	}
}