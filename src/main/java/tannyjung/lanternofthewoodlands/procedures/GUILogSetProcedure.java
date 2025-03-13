package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class GUILogSetProcedure {
	public static void execute(Entity entity, String text, String type) {
		if (entity == null || text == null || type == null)
			return;
		if ((type).equals("info")) {
			{
				String _setval = text;
				entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.book_log_display_info = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.book_log_display_info_duration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((type).equals("notification")) {
			{
				String _setval = text;
				entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.book_log_display_notification = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.book_log_display_notification_duration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
