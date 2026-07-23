package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class GUIShortcutCustomSetProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
			_vars.book_shortcut_custom = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).book_page;
			_vars.markSyncDirty();
		}
		GUILogSetProcedure.execute(entity, "SET NEW BOOKMARK", "info");
	}
}