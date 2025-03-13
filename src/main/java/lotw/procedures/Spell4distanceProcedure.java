package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell4distanceProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4distance!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (LotwModVariables.MapVariables.get(world).spell4_distance_set == 1) {
			if (LotwModVariables.MapVariables.get(world).spell4_distance < 100) {
				LotwModVariables.MapVariables.get(world).spell4_distance = (LotwModVariables.MapVariables.get(world).spell4_distance + 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		}
		if (LotwModVariables.MapVariables.get(world).spell4_distance_set == 2) {
			if (LotwModVariables.MapVariables.get(world).spell4_distance > 0) {
				LotwModVariables.MapVariables.get(world).spell4_distance = (LotwModVariables.MapVariables.get(world).spell4_distance - 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
