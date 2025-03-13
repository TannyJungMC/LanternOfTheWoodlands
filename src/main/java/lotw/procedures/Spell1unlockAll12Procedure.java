package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell1unlockAll12Procedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell1unlockAll12!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return LotwModVariables.MapVariables.get(world).spell1_start_effect1 == true
				&& LotwModVariables.MapVariables.get(world).spell1_start_effect2 == true
				&& LotwModVariables.MapVariables.get(world).spell1_start_effect3 == true
				&& LotwModVariables.MapVariables.get(world).spell1_start_effect4 == true
				&& LotwModVariables.MapVariables.get(world).spell1_start_effect5 == true
				&& LotwModVariables.MapVariables.get(world).spell1_start_effect6 == true
				&& LotwModVariables.MapVariables.get(world).spell1_start_effect7 == true
				&& LotwModVariables.MapVariables.get(world).spell1_start_effect8 == true
				&& LotwModVariables.MapVariables.get(world).spell1_start_effect9 == true
				&& LotwModVariables.MapVariables.get(world).spell1_start_effect10 == true
				&& LotwModVariables.MapVariables.get(world).spell1_start_effect11 == true
				&& LotwModVariables.MapVariables.get(world).spell1_start_effect12 == true;
	}
}
