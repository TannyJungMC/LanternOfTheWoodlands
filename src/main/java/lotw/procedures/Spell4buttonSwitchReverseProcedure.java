package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell4buttonSwitchReverseProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4buttonSwitchReverse!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell4_switch_reverse).equals("")) {
			LotwModVariables.MapVariables.get(world).spell4_switch_reverse = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell4_switch_reverse).equals("Off")) {
			LotwModVariables.MapVariables.get(world).spell4_switch_reverse = "On";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell4_switch_reverse).equals("On")) {
			LotwModVariables.MapVariables.get(world).spell4_switch_reverse = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
