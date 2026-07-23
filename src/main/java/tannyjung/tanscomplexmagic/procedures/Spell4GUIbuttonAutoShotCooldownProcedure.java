package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIbuttonAutoShotCooldownProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("") && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell == 4) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_auto_shot_cooldown == 1) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_auto_shot_cooldown = 2;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_auto_shot_cooldown == 2) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_auto_shot_cooldown = 0.1;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_auto_shot_cooldown == 0.1) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_auto_shot_cooldown = 0.25;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_auto_shot_cooldown == 0.25) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_auto_shot_cooldown = 0.5;
					_vars.markSyncDirty();
				}
			} else {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_auto_shot_cooldown = 1;
					_vars.markSyncDirty();
				}
			}
		}
	}
}