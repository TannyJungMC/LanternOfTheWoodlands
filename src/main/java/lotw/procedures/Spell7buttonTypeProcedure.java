package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell7buttonTypeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7buttonType!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("")) {
			LotwModVariables.MapVariables.get(world).spell7_type = "Generate Spell Book";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Generate Spell Book")) {
			LotwModVariables.MapVariables.get(world).spell7_type = "Generate Enchanted Book";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Generate Enchanted Book")) {
			LotwModVariables.MapVariables.get(world).spell7_type = "Separation Enchantment";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Separation Enchantment")) {
			LotwModVariables.MapVariables.get(world).spell7_type = "Elevation Enchantment";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Elevation Enchantment")) {
			LotwModVariables.MapVariables.get(world).spell7_type = "Demotion Enchantment";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Demotion Enchantment")) {
			LotwModVariables.MapVariables.get(world).spell7_type = "Cheapening";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Cheapening")) {
			LotwModVariables.MapVariables.get(world).spell7_type = "Disenchantment";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			LotwModVariables.MapVariables.get(world).spell7_type = "Generate Spell Book";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		Spell7buttonBookIDProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

		Spell7buttonBookIDsetTimeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
	}
}
