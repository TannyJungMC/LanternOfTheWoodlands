package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class AlternativeKeyboardButtonNumber7Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure AlternativeKeyboardButtonNumber7!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		LotwModVariables.MapVariables.get(world).aternative_keyboard = (LotwModVariables.MapVariables.get(world).aternative_keyboard + "7");
		LotwModVariables.MapVariables.get(world).syncData(world);
	}
}
