package lotw.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell7keyModeRunProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7keyModeRun!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell7keyModeRun!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");

		UserOnlyTestProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		if (LotwModVariables.MapVariables.get(world).user_only == true && LotwModVariables.MapVariables.get(world).spell7_start == true) {
			if (LotwModVariables.MapVariables.get(world).spell7_book_number != 0) {
				if (LotwModVariables.MapVariables.get(world).spell7_mode == 1) {
					LotwModVariables.MapVariables.get(world).spell7_mode = 2;
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else if (LotwModVariables.MapVariables.get(world).spell7_mode == 2) {
					LotwModVariables.MapVariables.get(world).spell7_mode = 3;
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else if (LotwModVariables.MapVariables.get(world).spell7_mode == 3) {
					LotwModVariables.MapVariables.get(world).spell7_mode = 1;
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else {
					LotwModVariables.MapVariables.get(world).spell7_mode = 1;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			}
		}
	}
}
