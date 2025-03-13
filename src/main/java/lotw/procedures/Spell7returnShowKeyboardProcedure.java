package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell7returnShowKeyboardProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7returnShowKeyboard!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return (LotwModVariables.MapVariables.get(world).spell7_type).equals("Generate Enchanted Book")
				&& LotwModVariables.MapVariables.get(world).spell7_book_id_number == 1;
	}
}
