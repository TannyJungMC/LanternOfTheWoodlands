package lantern_of_the_woodlands.procedures;

import net.minecraft.world.IWorld;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;

public class Spell3startFALSEProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell3startFALSE!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_start == false
				&& LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_gen == false;
	}
}
