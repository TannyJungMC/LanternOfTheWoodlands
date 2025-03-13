package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell1buttonEffectInfoProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell1buttonEffectInfo!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (LotwModVariables.MapVariables.get(world).spell1_effect_info == false) {
			LotwModVariables.MapVariables.get(world).spell1_effect_info = (true);
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if (LotwModVariables.MapVariables.get(world).spell1_effect_info == true) {
			LotwModVariables.MapVariables.get(world).spell1_effect_info = (false);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
