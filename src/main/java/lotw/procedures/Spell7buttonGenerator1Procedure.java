package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell7buttonGenerator1Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7buttonGenerator1!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		LotwModVariables.MapVariables.get(world).spell7_generator1_id = "";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell7_generator1 = "";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell7_generator1_time = (-1);
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell7_generator1_pos = 0;
		LotwModVariables.MapVariables.get(world).syncData(world);
	}
}
