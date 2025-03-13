package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell2buttonSpeedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell2buttonSpeed!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell2_speed).equals("")) {
			LotwModVariables.MapVariables.get(world).spell2_speed = "5s (High)";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_speed).equals("5s (High)")) {
			LotwModVariables.MapVariables.get(world).spell2_speed = "1s (Very Low)";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_speed).equals("1s (Very Low)")) {
			LotwModVariables.MapVariables.get(world).spell2_speed = "2s (Low)";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_speed).equals("2s (Low)")) {
			LotwModVariables.MapVariables.get(world).spell2_speed = "3s (Medium)";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			Spell2buttonSpeedResetProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
