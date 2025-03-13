package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell3clickPAUSEProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell3clickPAUSE!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		LotwModVariables.MapVariables.get(world).spell3_pause = (true);
		LotwModVariables.MapVariables.get(world).syncData(world);
	}
}
