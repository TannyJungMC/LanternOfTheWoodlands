package lotw.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class BagButtonWhoChatBubbleProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure BagButtonWhoChatBubble!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure BagButtonWhoChatBubble!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");

		UserOnlyTestProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		if (LotwModVariables.MapVariables.get(world).user_only == true) {
			if ((LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble).equals("User")) {
				LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble = "User and Ally";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if ((LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble).equals("User and Ally")) {
				LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble = "Ally";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if ((LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble).equals("Ally")) {
				LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble = "All Player";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if ((LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble).equals("All Player")) {
				LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble = "No One";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble = "User";
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
