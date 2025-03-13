package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell2buttonFindKeyTypeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell2buttonFindKeyType!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (LotwModVariables.MapVariables.get(world).spell2_level >= 2) {
			LotwModVariables.MapVariables.get(world).spell2_findkey_list = LotwModVariables.MapVariables.get(world).aternative_keyboard;
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
