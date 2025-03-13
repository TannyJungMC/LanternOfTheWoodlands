package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell2buttonInfoProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell2buttonInfo!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell2_show_info).equals("")) {
			LotwModVariables.MapVariables.get(world).spell2_show_info = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_show_info).equals("Off")) {
			LotwModVariables.MapVariables.get(world).spell2_show_info = "On";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_show_info).equals("On")) {
			LotwModVariables.MapVariables.get(world).spell2_show_info = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
