package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class Spell4GUIbuttonPauseAtMarkProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS).equals("")
				&& (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell == 4) {
			if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_pause_at_mark == false) {
				{
					boolean _setval = true;
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spell4_pause_at_mark = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					boolean _setval = false;
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spell4_pause_at_mark = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
