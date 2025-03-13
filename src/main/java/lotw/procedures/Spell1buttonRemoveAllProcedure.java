package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell1buttonRemoveAllProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell1buttonRemoveAll!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell1buttonRemoveAll!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell1buttonRemoveAll!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell1buttonRemoveAll!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		String id = "";
		LotwModVariables.MapVariables.get(world).spell1_door1 = "";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_door2 = "";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_door3 = "";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_door4 = "";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect_count = 0;
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect1 = "Off";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect2 = "Off";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect3 = "Off";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect4 = "Off";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect5 = "Off";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect6 = "Off";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect7 = "Off";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect8 = "Off";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect9 = "Off";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect10 = "Off";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect11 = "Off";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect12 = "Off";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell1_effect13 = "Off";
		LotwModVariables.MapVariables.get(world).syncData(world);
		Spell1doorUpdateProcedure
				.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
	}
}
