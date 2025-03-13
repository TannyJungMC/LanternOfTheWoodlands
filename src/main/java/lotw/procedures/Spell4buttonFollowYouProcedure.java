package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell4buttonFollowYouProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4buttonFollowYou!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell4_follow_you).equals("")) {
			LotwModVariables.MapVariables.get(world).spell4_follow_you = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell4_follow_you).equals("Off")) {
			LotwModVariables.MapVariables.get(world).spell4_follow_you = "5";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell4_follow_you).equals("5")) {
			LotwModVariables.MapVariables.get(world).spell4_follow_you = "10";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell4_follow_you).equals("10")) {
			LotwModVariables.MapVariables.get(world).spell4_follow_you = "20";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			LotwModVariables.MapVariables.get(world).spell4_follow_you = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
