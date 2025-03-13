package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell2buttonNotificationBuoyProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell2buttonNotificationBuoy!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell2_notification_buoy).equals("")) {
			LotwModVariables.MapVariables.get(world).spell2_notification_buoy = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_notification_buoy).equals("Off")) {
			LotwModVariables.MapVariables.get(world).spell2_notification_buoy = "On";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if ((LotwModVariables.MapVariables.get(world).spell2_notification_buoy).equals("On")) {
			LotwModVariables.MapVariables.get(world).spell2_notification_buoy = "Off";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
