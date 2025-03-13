package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell2buttonEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell2buttonEntity!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell2_show_entity).equals("")) {
			LotwModVariables.MapVariables.get(world).spell2_show_entity = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_show_entity).equals("Off")) {
			LotwModVariables.MapVariables.get(world).spell2_show_entity = "On";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_show_entity).equals("On")) {
			LotwModVariables.MapVariables.get(world).spell2_show_entity = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
