package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell1buttonTargetBadProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell1buttonTargetBad!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("")) {
			LotwModVariables.MapVariables.get(world).spell1_target_bad = "No Target";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("No Target")) {
			LotwModVariables.MapVariables.get(world).spell1_target_bad = "Enemy";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("Enemy")) {
			LotwModVariables.MapVariables.get(world).spell1_target_bad = "Ally";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("Ally")) {
			LotwModVariables.MapVariables.get(world).spell1_target_bad = "You";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("You")) {
			LotwModVariables.MapVariables.get(world).spell1_target_bad = "You, Ally";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("You, Ally")) {
			LotwModVariables.MapVariables.get(world).spell1_target_bad = "Ally, Enemy";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("Ally, Enemy")) {
			LotwModVariables.MapVariables.get(world).spell1_target_bad = "All";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("All")) {
			LotwModVariables.MapVariables.get(world).spell1_target_bad = "No Target";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
