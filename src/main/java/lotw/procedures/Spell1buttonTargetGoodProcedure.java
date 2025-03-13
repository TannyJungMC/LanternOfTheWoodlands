package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell1buttonTargetGoodProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell1buttonTargetGood!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("")) {
			LotwModVariables.MapVariables.get(world).spell1_target_good = "No Target";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("No Target")) {
			LotwModVariables.MapVariables.get(world).spell1_target_good = "You";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("You")) {
			LotwModVariables.MapVariables.get(world).spell1_target_good = "Ally";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("Ally")) {
			LotwModVariables.MapVariables.get(world).spell1_target_good = "Enemy";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("Enemy")) {
			LotwModVariables.MapVariables.get(world).spell1_target_good = "You, Ally";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("You, Ally")) {
			LotwModVariables.MapVariables.get(world).spell1_target_good = "Ally, Enemy";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("Ally, Enemy")) {
			LotwModVariables.MapVariables.get(world).spell1_target_good = "All";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("All")) {
			LotwModVariables.MapVariables.get(world).spell1_target_good = "No Target";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
