package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class GUIShortcutCustomProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
			_vars.book_page = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_shortcut_custom;
			_vars.markSyncDirty();
		}
		GUIOpenProcedure.execute(entity);
	}
}