package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class AllyListButtonAuto5Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure AllyListButtonAuto5!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).ally_list_auto5).equals("")) {
			LotwModVariables.MapVariables.get(world).ally_list_auto5 = LotwModVariables.MapVariables.get(world).aternative_keyboard;
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
