package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class AllyButtonChatProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure AllyButtonChat!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User, Chosen and Ally")) {
			LotwModVariables.MapVariables.get(world).ally_list_chat = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).ally_list_chat).equals("Off")) {
			LotwModVariables.MapVariables.get(world).ally_list_chat = "User";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User")) {
			LotwModVariables.MapVariables.get(world).ally_list_chat = "User and Chosen";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User and Chosen")) {
			LotwModVariables.MapVariables.get(world).ally_list_chat = "User and Ally";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User and Ally")) {
			LotwModVariables.MapVariables.get(world).ally_list_chat = "Chosen";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).ally_list_chat).equals("Chosen")) {
			LotwModVariables.MapVariables.get(world).ally_list_chat = "Chosen and Ally";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).ally_list_chat).equals("Chosen and Ally")) {
			LotwModVariables.MapVariables.get(world).ally_list_chat = "Ally";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			LotwModVariables.MapVariables.get(world).ally_list_chat = "User, Chosen and Ally";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
