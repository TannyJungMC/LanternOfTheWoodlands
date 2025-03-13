package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell3removeINSfalseProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell3removeINSfalse!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return !LotwModVariables.MapVariables.get(world).spell3_remove_click_again;
	}
}
