package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell7returnDoubleSpellProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7returnDoubleSpell!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return !(LotwModVariables.MapVariables.get(world).spell7_use_double).equals("");
	}
}
