package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class CustomPlantBagMatureProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure CustomPlantBagMature!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage >= 31) {
			LotwModVariables.MapVariables.get(world).custom_planting_bag_1_plant = "";
			LotwModVariables.MapVariables.get(world).syncData(world);
			LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage = (-5);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		if (LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage >= 31) {
			LotwModVariables.MapVariables.get(world).custom_planting_bag_2_plant = "";
			LotwModVariables.MapVariables.get(world).syncData(world);
			LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage = (-5);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		if (LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage >= 31) {
			LotwModVariables.MapVariables.get(world).custom_planting_bag_3_plant = "";
			LotwModVariables.MapVariables.get(world).syncData(world);
			LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage = (-5);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		if (LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage >= 31) {
			LotwModVariables.MapVariables.get(world).custom_planting_bag_4_plant = "";
			LotwModVariables.MapVariables.get(world).syncData(world);
			LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage = (-5);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		if (LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage >= 31) {
			LotwModVariables.MapVariables.get(world).custom_planting_bag_5_plant = "";
			LotwModVariables.MapVariables.get(world).syncData(world);
			LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage = (-5);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		if (LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage >= 31) {
			LotwModVariables.MapVariables.get(world).custom_planting_bag_6_plant = "";
			LotwModVariables.MapVariables.get(world).syncData(world);
			LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage = (-5);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
