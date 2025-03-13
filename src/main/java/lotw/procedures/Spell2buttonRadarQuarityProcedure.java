package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell2buttonRadarQuarityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell2buttonRadarQuarity!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell2_scanner_quarity).equals("")) {
			LotwModVariables.MapVariables.get(world).spell2_scanner_quarity = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_scanner_quarity).equals("Off")) {
			LotwModVariables.MapVariables.get(world).spell2_scanner_quarity = "Low";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_scanner_quarity).equals("Low")) {
			LotwModVariables.MapVariables.get(world).spell2_scanner_quarity = "Medium";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_scanner_quarity).equals("Medium")) {
			LotwModVariables.MapVariables.get(world).spell2_scanner_quarity = "High";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_scanner_quarity).equals("High")) {
			Spell2buttonRadarQuarityResetProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
