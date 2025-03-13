package lotw.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell7returnGenerator2workProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7returnGenerator2work!");
			return false;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell7returnGenerator2work!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		return ((entity.getCapability(LotwModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LotwModVariables.PlayerVariables())).spell7_overlay).equals("On")
				&& LotwModVariables.MapVariables.get(world).spell7_book_number != 0
				&& LotwModVariables.MapVariables.get(world).spell7_generator2_time >= 0;
	}
}
