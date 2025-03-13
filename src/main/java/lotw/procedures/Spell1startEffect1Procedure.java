package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell1startEffect1Procedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell1startEffect1!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		String effect = "";
		effect = "1";
		return LotwModVariables.MapVariables.get(world).spell1_start_effect1 == true
				&& (LotwModVariables.MapVariables.get(world).spell1_effect_count < LotwModVariables.MapVariables.get(world).spell1_effect_count_max
						|| (LotwModVariables.MapVariables.get(world).spell1_door1).equals(effect)
						|| (LotwModVariables.MapVariables.get(world).spell1_door2).equals(effect)
						|| (LotwModVariables.MapVariables.get(world).spell1_door3).equals(effect)
						|| (LotwModVariables.MapVariables.get(world).spell1_door4).equals(effect));
	}
}
