package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell4buttonSizeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4buttonSize!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (LotwModVariables.MapVariables.get(world).spell4_pause_size == 0) {
			LotwModVariables.MapVariables.get(world).spell4_pause_size = 2;
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if (LotwModVariables.MapVariables.get(world).spell4_pause_size == 2) {
			LotwModVariables.MapVariables.get(world).spell4_pause_size = 3;
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if (LotwModVariables.MapVariables.get(world).spell4_pause_size == 3) {
			LotwModVariables.MapVariables.get(world).spell4_pause_size = 5;
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if (LotwModVariables.MapVariables.get(world).spell4_pause_size == 5) {
			LotwModVariables.MapVariables.get(world).spell4_pause_size = 10;
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if (LotwModVariables.MapVariables.get(world).spell4_pause_size == 10) {
			LotwModVariables.MapVariables.get(world).spell4_pause_size = 20;
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if (LotwModVariables.MapVariables.get(world).spell4_pause_size == 20) {
			LotwModVariables.MapVariables.get(world).spell4_pause_size = 2;
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
