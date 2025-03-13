package lotw.procedures;

import net.minecraft.entity.Entity;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell4buttonOverlayProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell4buttonOverlay!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getCapability(LotwModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LotwModVariables.PlayerVariables())).spell4_overlay)
				.equals("")) {
			{
				String _setval = "Off";
				entity.getCapability(LotwModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.spell4_overlay = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(LotwModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LotwModVariables.PlayerVariables())).spell4_overlay).equals("Off")) {
			{
				String _setval = "On";
				entity.getCapability(LotwModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.spell4_overlay = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(LotwModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LotwModVariables.PlayerVariables())).spell4_overlay).equals("On")) {
			{
				String _setval = "Off";
				entity.getCapability(LotwModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.spell4_overlay = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
