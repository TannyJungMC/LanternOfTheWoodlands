package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class GUIpreviousProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
			_vars.book_page = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_page - 2;
			_vars.markSyncDirty();
		}
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_page < 1) {
			{
				TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
				_vars.book_page = 1;
				_vars.markSyncDirty();
			}
		}
		GUIOpenProcedure.execute(entity);
	}
}