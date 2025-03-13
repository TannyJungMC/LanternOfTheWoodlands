package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell2buttonShowCustomProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell2buttonShowCustom!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell2_custom).equals("")) {
			LotwModVariables.MapVariables.get(world).spell2_custom = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_custom).equals("Off")) {
			LotwModVariables.MapVariables.get(world).spell2_custom = "On";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_custom).equals("On")) {
			LotwModVariables.MapVariables.get(world).spell2_custom = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
