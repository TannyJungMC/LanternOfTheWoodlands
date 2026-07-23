package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.entity.Entity;

public class AllyListGUIreturnChatSettingProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting;
	}
}