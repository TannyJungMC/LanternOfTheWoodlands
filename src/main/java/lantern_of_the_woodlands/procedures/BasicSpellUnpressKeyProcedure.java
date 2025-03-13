package lantern_of_the_woodlands.procedures;

import net.minecraft.world.IWorld;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;

public class BasicSpellUnpressKeyProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure BasicSpellUnpressKey!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).place_lantern_up = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
	}
}
