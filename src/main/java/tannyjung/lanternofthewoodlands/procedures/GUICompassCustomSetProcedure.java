package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class GUICompassCustomSetProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = Math.floor(entity.getX()) + 0.5;
			entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.book_compass_custom_posX = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = Math.floor(entity.getZ()) + 0.5;
			entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.book_compass_custom_posZ = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		GUILogSetProcedure.execute(entity, "SET NEW COMPASS POINT", "info");
	}
}
