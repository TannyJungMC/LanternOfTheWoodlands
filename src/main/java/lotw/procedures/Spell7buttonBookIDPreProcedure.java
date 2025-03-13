package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell7buttonBookIDPreProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7buttonBookIDPre!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Generate Spell Book")) {
			if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell > 1) {
				LotwModVariables.MapVariables
						.get(world).spell7_book_id_number_spell = (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell - 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell = 24;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			if (LotwModVariables.MapVariables.get(world).spell7_book_id_number > 1) {
				LotwModVariables.MapVariables.get(world).spell7_book_id_number = (LotwModVariables.MapVariables.get(world).spell7_book_id_number - 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).spell7_book_id_number = 40;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		}
		Spell7buttonBookIDProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
	}
}
