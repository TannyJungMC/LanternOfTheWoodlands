package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell7buttonBookIDProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7buttonBookID!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double test = 0;
		if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Generate Spell Book")) {
			if (true) {
				test = 1;
				if (!("Weather").equals("")) {
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "The Peaceful Day";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 15;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Heavy Rain";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 15;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Thunder Storm";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 15;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Snowstorm";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 15;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Strong Wind";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 10;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Cloud Manipulation";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 5;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Lightning Bolt";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 3;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
				}
				if (!("Fire").equals("")) {
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Fireball";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 1;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Multiple Fireballs";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 5;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
				}
				if (!("Healing").equals("")) {
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Heal";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 2;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Healing Area";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 3;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
				}
				if (!("Ice").equals("")) {
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Cold Zone";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 1;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
				}
				if (!("Dark").equals("")) {
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Cursing";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 2;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
				}
				if (!("Holy").equals("")) {
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Antidote";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 2;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Cleanse";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 5;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
				}
				if (!("Light").equals("")) {
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Uncovering";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 3;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Midnight Friend";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 1;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Fireflies Dance";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 5;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
				}
				if (!("Adaptive").equals("")) {
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Firework";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 1;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Multiple Fireworks";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 5;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
				}
				if (!("Wind").equals("")) {
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Wind Knockback";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 2;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Wind Cutter";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 3;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
				}
				if (!("Teleportation").equals("")) {
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Return";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 2;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
					if (true) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_id_number_spell == test) {
							LotwModVariables.MapVariables.get(world).spell7_book_id = "Time Travelling";
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_book_cost = 15;
							LotwModVariables.MapVariables.get(world).syncData(world);
						}
						test = (test + 1);
					}
				}
			}
		} else {
			if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 1) {
				LotwModVariables.MapVariables.get(world).spell7_book_id = LotwModVariables.MapVariables.get(world).spell7_book_id_custom;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_book_cost = 30;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if (true) {
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 2) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:aqua_affinity";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 10;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 3) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:bane_of_arthropods";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 10;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 4) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:blast_protection";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 5) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:channeling";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 30;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 6) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:binding_curse";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 10;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 7) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:vanishing_curse";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 10;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 8) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:depth_strider";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 9) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:efficiency";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 10) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:feather_falling";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 11) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:fire_aspect";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 30;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 12) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:fire_protection";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 13) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:flame";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 30;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 14) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:fortune";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 15) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:frost_walker";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 30;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 16) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:impaling";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 17) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:infinity";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 30;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 18) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:knockback";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 19) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:looting";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 20) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:loyalty";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 30;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 21) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:luck_of_the_sea";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 10;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 22) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:lure";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 10;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 23) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:mending";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 30;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 24) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:multishot";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 30;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 25) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:piercing";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 26) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:power";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 27) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:projectile_protection";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 28) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:protection";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 29) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:punch";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 30) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:quick_charge";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 31) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:respiration";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 32) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:riptide";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 30;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 33) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:sharpness";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 34) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:silk_touch";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 30;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 35) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:smite";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 36) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:soul_speed";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 10;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 37) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:sweeping";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 38) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:swift_sneak";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 10;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 39) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:thorns";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_id_number == 40) {
					LotwModVariables.MapVariables.get(world).spell7_book_id = "minecraft:unbreaking";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_book_cost = 20;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			}
		}
		Spell7buttonBookIDsetTimeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
	}
}
