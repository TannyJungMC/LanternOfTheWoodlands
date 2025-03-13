package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class AlternativeKeyboardButtonRemoveProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure AlternativeKeyboardButtonRemove!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		LotwModVariables.MapVariables.get(world).aternative_keyboard = (LotwModVariables.MapVariables.get(world).aternative_keyboard
				.substring((int) 0, (int) ((LotwModVariables.MapVariables.get(world).aternative_keyboard).length() - 1)));
		LotwModVariables.MapVariables.get(world).syncData(world);
	}
}
