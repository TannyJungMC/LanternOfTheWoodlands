package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class KEYSpell4AbilityRunProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user == true && Math.floor(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell) == 4) {
			if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Off")) {
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_cooldown == -1) {
					Spell4AbilityRunProcedure.execute(entity);
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.spell4_ability_duration = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_duration * 20;
						_vars.spell4_ability_cooldown = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_cooldown * 20;
						_vars.spell4_ability_duration_max = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_duration;
						_vars.spell4_ability_cooldown_max = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_cooldown;
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}