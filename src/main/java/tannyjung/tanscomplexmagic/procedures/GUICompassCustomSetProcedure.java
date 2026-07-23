package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class GUICompassCustomSetProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
			_vars.book_compass_custom_posX = Math.floor(entity.getX()) + 0.5;
			_vars.book_compass_custom_posZ = Math.floor(entity.getZ()) + 0.5;
			_vars.markSyncDirty();
		}
		GUILogSetProcedure.execute(entity, "SET NEW COMPASS POINT", "info");
	}
}