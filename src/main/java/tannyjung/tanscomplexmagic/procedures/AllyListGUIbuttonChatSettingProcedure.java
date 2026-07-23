package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class AllyListGUIbuttonChatSettingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("")) {
			if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("User, Chosen and Ally")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.ally_list_chat_setting = "Off";
					_vars.markSyncDirty();
				}
			} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("Off")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.ally_list_chat_setting = "User";
					_vars.markSyncDirty();
				}
			} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("User")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.ally_list_chat_setting = "User and Chosen";
					_vars.markSyncDirty();
				}
			} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("User and Chosen")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.ally_list_chat_setting = "User and Ally";
					_vars.markSyncDirty();
				}
			} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("User and Ally")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.ally_list_chat_setting = "Chosen";
					_vars.markSyncDirty();
				}
			} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("Chosen")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.ally_list_chat_setting = "Chosen and Ally";
					_vars.markSyncDirty();
				}
			} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("Chosen and Ally")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.ally_list_chat_setting = "Ally";
					_vars.markSyncDirty();
				}
			} else {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.ally_list_chat_setting = "User, Chosen and Ally";
					_vars.markSyncDirty();
				}
			}
		}
	}
}