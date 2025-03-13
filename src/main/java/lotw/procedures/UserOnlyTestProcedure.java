package lotw.procedures;

import net.minecraft.entity.Entity;

import lotw.LotwMod;

import java.util.Map;

public class UserOnlyTestProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure UserOnlyTest!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"execute if entity @e[tag=LOTW-user,distance=..0.1] run LOTW-user_only");
			}
		}
	}
}
