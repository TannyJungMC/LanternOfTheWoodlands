package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class CustomPlantBagWaterProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure CustomPlantBagWater!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage == 0
				|| LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage == 10) {
			LotwModVariables.MapVariables
					.get(world).custom_planting_bag_1_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage + 1);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		if (LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage == 0
				|| LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage == 10) {
			LotwModVariables.MapVariables
					.get(world).custom_planting_bag_2_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage + 1);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		if (LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage == 0
				|| LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage == 10) {
			LotwModVariables.MapVariables
					.get(world).custom_planting_bag_3_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage + 1);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		if (LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage == 0
				|| LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage == 10) {
			LotwModVariables.MapVariables
					.get(world).custom_planting_bag_4_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage + 1);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		if (LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage == 0
				|| LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage == 10) {
			LotwModVariables.MapVariables
					.get(world).custom_planting_bag_5_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage + 1);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		if (LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage == 0
				|| LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage == 10) {
			LotwModVariables.MapVariables
					.get(world).custom_planting_bag_6_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage + 1);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
