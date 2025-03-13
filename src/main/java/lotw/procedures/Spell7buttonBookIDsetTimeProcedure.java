package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell7buttonBookIDsetTimeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7buttonBookIDsetTime!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Generate Spell Book")) {
			if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 1) {
				LotwModVariables.MapVariables.get(world).spell7_book_time = 121;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_book_time_text = "2m";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 2) {
				LotwModVariables.MapVariables.get(world).spell7_book_time = 241;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_book_time_text = "4m";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 3) {
				LotwModVariables.MapVariables.get(world).spell7_book_time = 361;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_book_time_text = "6m";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 5) {
				LotwModVariables.MapVariables.get(world).spell7_book_time = 601;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_book_time_text = "10m";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 10) {
				LotwModVariables.MapVariables.get(world).spell7_book_time = 1201;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_book_time_text = "20m";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 15) {
				LotwModVariables.MapVariables.get(world).spell7_book_time = 1801;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_book_time_text = "30m";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).spell7_book_time = 3601;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_book_time_text = "1h";
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		}
		if (true) {
			if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Generate Enchanted Book")) {
				if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 10) {
					LotwModVariables.MapVariables.get(world).spell7_book_time = 1801;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_time_text = "30m";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 20) {
					LotwModVariables.MapVariables.get(world).spell7_book_time = 3601;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_time_text = "1h";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else {
					LotwModVariables.MapVariables.get(world).spell7_book_time = 5401;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_time_text = "1h 30m";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Separation Enchantment")) {
				if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 10) {
					LotwModVariables.MapVariables.get(world).spell7_book_time = 1201;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_time_text = "20m";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 20) {
					LotwModVariables.MapVariables.get(world).spell7_book_time = 2401;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_time_text = "40m";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else {
					LotwModVariables.MapVariables.get(world).spell7_book_time = 3601;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_time_text = "1h";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Elevation Enchantment")) {
				if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 10) {
					LotwModVariables.MapVariables.get(world).spell7_book_time = 3601;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_time_text = "1h";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 20) {
					LotwModVariables.MapVariables.get(world).spell7_book_time = 7201;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_time_text = "2h";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else {
					LotwModVariables.MapVariables.get(world).spell7_book_time = 10801;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_time_text = "3h";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Demotion Enchantment")) {
				if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 10) {
					LotwModVariables.MapVariables.get(world).spell7_book_time = 601;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_time_text = "10m";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else if (LotwModVariables.MapVariables.get(world).spell7_book_cost == 20) {
					LotwModVariables.MapVariables.get(world).spell7_book_time = 1201;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_time_text = "20m";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else {
					LotwModVariables.MapVariables.get(world).spell7_book_time = 1801;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_time_text = "30m";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Cheapening")) {
				LotwModVariables.MapVariables.get(world).spell7_book_cost = 30;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_book_time = 10801;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_book_time_text = "3h";
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Disenchantment")) {
				LotwModVariables.MapVariables.get(world).spell7_book_cost = 30;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_book_time = 10801;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_book_time_text = "3h";
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
