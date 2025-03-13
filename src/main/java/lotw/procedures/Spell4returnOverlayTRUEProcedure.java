package lotw.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell4returnOverlayTRUEProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4returnOverlayTRUE!");
			return false;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell4returnOverlayTRUE!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		return ((entity.getCapability(LotwModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LotwModVariables.PlayerVariables())).spell4_overlay).equals("On")
				&& !(LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Off");
	}
}
