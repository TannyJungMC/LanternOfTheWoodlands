package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell7buttonShowKeyProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7buttonShowKey!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (LotwModVariables.MapVariables.get(world).spell7_show_key == false) {
			LotwModVariables.MapVariables.get(world).spell7_show_key = (true);
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			LotwModVariables.MapVariables.get(world).spell7_show_key = (false);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
