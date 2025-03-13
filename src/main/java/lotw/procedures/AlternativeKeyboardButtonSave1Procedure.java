package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class AlternativeKeyboardButtonSave1Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure AlternativeKeyboardButtonSave1!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		String save = "";
		save = LotwModVariables.MapVariables.get(world).aternative_keyboard;
		LotwModVariables.MapVariables.get(world).aternative_keyboard = LotwModVariables.MapVariables.get(world).aternative_keyboard_save1;
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).aternative_keyboard_save1 = save;
		LotwModVariables.MapVariables.get(world).syncData(world);
	}
}
