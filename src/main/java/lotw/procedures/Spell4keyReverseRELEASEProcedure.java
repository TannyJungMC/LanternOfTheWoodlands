package lotw.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell4keyReverseRELEASEProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4keyReverseRELEASE!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell4keyReverseRELEASE!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");

		UserOnlyTestProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		if (LotwModVariables.MapVariables.get(world).user_only == true && LotwModVariables.MapVariables.get(world).spell4_start == true) {
			if ((LotwModVariables.MapVariables.get(world).spell4_switch_reverse).equals("Off")) {
				LotwModVariables.MapVariables.get(world).spell4_reverse = "Off";
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
