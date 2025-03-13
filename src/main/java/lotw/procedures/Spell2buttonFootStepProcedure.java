package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell2buttonFootStepProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell2buttonFootStep!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell2_footstep).equals("")) {
			LotwModVariables.MapVariables.get(world).spell2_footstep = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_footstep).equals("Off")) {
			LotwModVariables.MapVariables.get(world).spell2_footstep = "All";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_footstep).equals("All")) {
			LotwModVariables.MapVariables.get(world).spell2_footstep = "Player";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_footstep).equals("Player")) {
			LotwModVariables.MapVariables.get(world).spell2_footstep = "Entity";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_footstep).equals("Entity")) {
			LotwModVariables.MapVariables.get(world).spell2_footstep = "Tracker";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			Spell2buttonFootstepResetProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
