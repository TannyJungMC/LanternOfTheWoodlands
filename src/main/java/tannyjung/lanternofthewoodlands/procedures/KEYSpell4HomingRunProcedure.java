package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class KEYSpell4HomingRunProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user == true
				&& Math.floor((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell) == 4) {
			if (!((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Off")) {
				if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_homing == false) {
					{
						boolean _setval = true;
						entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.spell4_homing = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					{
						boolean _setval = false;
						entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.spell4_homing = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
