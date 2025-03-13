package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell1infoEffect11Procedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell1infoEffect11!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return LotwModVariables.MapVariables.get(world).spell1_start_effect11 == true
				|| LotwModVariables.MapVariables.get(world).spell1_effect_info == true;
	}
}
