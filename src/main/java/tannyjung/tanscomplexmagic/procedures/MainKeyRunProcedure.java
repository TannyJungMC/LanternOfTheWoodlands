package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class MainKeyRunProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
			_vars.main_key = true;
			_vars.markSyncDirty();
		}
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user == true) {
			if (entity.isShiftKeyDown() == false) {
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_place == true) {
					if (Math.abs((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_posX + 0.5) - entity.getX()) <= 3
							&& Math.abs((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_posY + 1.5) - entity.getY()) <= 3
							&& Math.abs((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_posZ + 0.5) - entity.getZ()) <= 3) {
						GUIOpenProcedure.execute(entity);
					}
				}
			} else {
				UserBookPickUpProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}