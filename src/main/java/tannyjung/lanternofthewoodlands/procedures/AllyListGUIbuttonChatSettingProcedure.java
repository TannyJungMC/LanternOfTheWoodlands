package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class AllyListGUIbuttonChatSettingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS).equals("")) {
			if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).ally_list_chat_setting).equals("User, Chosen and Ally")) {
				{
					String _setval = "Off";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ally_list_chat_setting = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).ally_list_chat_setting).equals("Off")) {
				{
					String _setval = "User";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ally_list_chat_setting = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).ally_list_chat_setting).equals("User")) {
				{
					String _setval = "User and Chosen";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ally_list_chat_setting = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).ally_list_chat_setting).equals("User and Chosen")) {
				{
					String _setval = "User and Ally";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ally_list_chat_setting = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).ally_list_chat_setting).equals("User and Ally")) {
				{
					String _setval = "Chosen";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ally_list_chat_setting = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).ally_list_chat_setting).equals("Chosen")) {
				{
					String _setval = "Chosen and Ally";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ally_list_chat_setting = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).ally_list_chat_setting).equals("Chosen and Ally")) {
				{
					String _setval = "Ally";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ally_list_chat_setting = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					String _setval = "User, Chosen and Ally";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ally_list_chat_setting = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
