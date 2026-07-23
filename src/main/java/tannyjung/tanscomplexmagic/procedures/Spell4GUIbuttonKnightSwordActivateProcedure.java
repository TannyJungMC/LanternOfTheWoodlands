package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIbuttonKnightSwordActivateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("") && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell == 4) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana >= 60) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.mana = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana - 60;
					_vars.spell4_weapon_knight_sword_count_max = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_knight_sword_count_max + 1;
					_vars.markSyncDirty();
				}
			}
		}
	}
}