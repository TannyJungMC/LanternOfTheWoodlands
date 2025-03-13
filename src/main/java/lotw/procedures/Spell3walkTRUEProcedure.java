package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell3walkTRUEProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell3walkTRUE!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return LotwModVariables.MapVariables.get(world).spell3_walk == true;
	}
}
