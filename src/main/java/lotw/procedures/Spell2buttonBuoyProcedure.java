package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell2buttonBuoyProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell2buttonBuoy!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell2_show_waypoint).equals("")) {
			LotwModVariables.MapVariables.get(world).spell2_show_waypoint = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_show_waypoint).equals("Off")) {
			LotwModVariables.MapVariables.get(world).spell2_show_waypoint = "On";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_show_waypoint).equals("On")) {
			LotwModVariables.MapVariables.get(world).spell2_show_waypoint = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
