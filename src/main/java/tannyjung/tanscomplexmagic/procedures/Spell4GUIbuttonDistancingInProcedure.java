package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class Spell4GUIbuttonDistancingInProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("") && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell == 4) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distancing_in == 0) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_distancing_in = 5;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distancing_in == 5) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_distancing_in = 10;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distancing_in == 10) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_distancing_in = 20;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distancing_in == 20) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_distancing_in = 50;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distancing_in == 50) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_distancing_in = 100;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distancing_in == 100) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_distancing_in = 195;
					_vars.markSyncDirty();
				}
			} else {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_distancing_in = 0;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distancing_in >= entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distancing_out) {
				Spell4GUIbuttonDistancingOutProcedure.execute(world, entity);
			}
		}
	}
}