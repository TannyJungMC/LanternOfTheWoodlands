package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIbuttonBoundaryProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("") && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell == 4) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_pause_boundary == 2) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_pause_boundary = 3;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_pause_boundary == 3) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_pause_boundary = 5;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_pause_boundary == 5) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_pause_boundary = 10;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_pause_boundary == 10) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_pause_boundary = 20;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_pause_boundary == 20) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_pause_boundary = 50;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_pause_boundary == 50) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_pause_boundary = 100;
					_vars.markSyncDirty();
				}
			} else {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_pause_boundary = 2;
					_vars.markSyncDirty();
				}
			}
		}
	}
}