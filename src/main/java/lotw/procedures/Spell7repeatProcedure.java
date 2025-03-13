package lotw.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell7repeatProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7repeat!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell7repeat!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell7repeat!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell7repeat!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double time_get = 0;
		double pos = 0;
		double repeat = 0;
		String time = "";
		String time_minute = "";
		String time_second = "";
		String second = "";
		String minute = "";
		String type = "";
		String set_text = "";
		String hour = "";
		boolean time_out = false;
		if (LotwModVariables.MapVariables.get(world).spell7_start == true) {
			repeat = 1;
			time_out = (false);
			for (int index0 = 0; index0 < (int) (3); index0++) {
				pos = 0;
				time_get = 0;
				set_text = "";
				type = "";
				if (repeat == 1) {
					time_get = LotwModVariables.MapVariables.get(world).spell7_generator1_time;
					if (time_get > 0) {
						type = LotwModVariables.MapVariables.get(world).spell7_generator1_id;
						set_text = LotwModVariables.MapVariables.get(world).spell7_generator1;
						pos = LotwModVariables.MapVariables.get(world).spell7_generator1_pos;
					} else if (time_get == 0) {
						time_out = (true);
					}
				} else if (repeat == 2) {
					if (LotwModVariables.MapVariables.get(world).spell7_generator1_time < 0
							&& LotwModVariables.MapVariables.get(world).spell7_generator2_time >= 0) {
						if (true) {
							LotwModVariables.MapVariables.get(world).spell7_generator1_time = LotwModVariables.MapVariables
									.get(world).spell7_generator2_time;
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_generator1_id = LotwModVariables.MapVariables
									.get(world).spell7_generator2_id;
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_generator1 = LotwModVariables.MapVariables.get(world).spell7_generator2;
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_generator1_pos = LotwModVariables.MapVariables
									.get(world).spell7_generator2_pos;
							LotwModVariables.MapVariables.get(world).syncData(world);
							if (true) {
								LotwModVariables.MapVariables.get(world).spell7_generator2_time = (-1);
								LotwModVariables.MapVariables.get(world).syncData(world);
								LotwModVariables.MapVariables.get(world).spell7_generator2_id = "";
								LotwModVariables.MapVariables.get(world).syncData(world);
								LotwModVariables.MapVariables.get(world).spell7_generator2 = "";
								LotwModVariables.MapVariables.get(world).syncData(world);
								LotwModVariables.MapVariables.get(world).spell7_generator2_pos = 0;
								LotwModVariables.MapVariables.get(world).syncData(world);
							}
						}
					} else {
						time_get = LotwModVariables.MapVariables.get(world).spell7_generator2_time;
						if (time_get > 0) {
							type = LotwModVariables.MapVariables.get(world).spell7_generator2_id;
							set_text = LotwModVariables.MapVariables.get(world).spell7_generator2;
							pos = LotwModVariables.MapVariables.get(world).spell7_generator2_pos;
						} else if (time_get == 0) {
							time_out = (true);
						}
					}
				} else if (repeat == 3) {
					if (LotwModVariables.MapVariables.get(world).spell7_generator2_time < 0
							&& LotwModVariables.MapVariables.get(world).spell7_generator3_time >= 0) {
						if (true) {
							LotwModVariables.MapVariables.get(world).spell7_generator2_time = LotwModVariables.MapVariables
									.get(world).spell7_generator3_time;
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_generator2_id = LotwModVariables.MapVariables
									.get(world).spell7_generator3_id;
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_generator2 = LotwModVariables.MapVariables.get(world).spell7_generator3;
							LotwModVariables.MapVariables.get(world).syncData(world);
							LotwModVariables.MapVariables.get(world).spell7_generator2_pos = LotwModVariables.MapVariables
									.get(world).spell7_generator3_pos;
							LotwModVariables.MapVariables.get(world).syncData(world);
							if (true) {
								LotwModVariables.MapVariables.get(world).spell7_generator3_time = (-1);
								LotwModVariables.MapVariables.get(world).syncData(world);
								LotwModVariables.MapVariables.get(world).spell7_generator3_id = "";
								LotwModVariables.MapVariables.get(world).syncData(world);
								LotwModVariables.MapVariables.get(world).spell7_generator3 = "";
								LotwModVariables.MapVariables.get(world).syncData(world);
								LotwModVariables.MapVariables.get(world).spell7_generator3_pos = 0;
								LotwModVariables.MapVariables.get(world).syncData(world);
							}
						}
					} else {
						time_get = LotwModVariables.MapVariables.get(world).spell7_generator3_time;
						if (time_get > 0) {
							type = LotwModVariables.MapVariables.get(world).spell7_generator3_id;
							set_text = LotwModVariables.MapVariables.get(world).spell7_generator3;
							pos = LotwModVariables.MapVariables.get(world).spell7_generator3_pos;
						} else if (time_get == 0) {
							time_out = (true);
						}
					}
				}
				if (true) {
					hour = ((new java.text.DecimalFormat("##.#").format(Math.floor((time_get - 1) / 3600))).replace(".0", ""));
					if (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(hour) >= 10) {
						hour = hour;
					} else if (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(hour) >= 1 && new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(hour) < 10) {
						hour = ("0" + hour);
					} else {
						hour = "00";
					}
					minute = ((new java.text.DecimalFormat("##.#").format(Math.floor(new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new java.text.DecimalFormat("##.#")
							.format((Math.floor((time_get - 1) / 60) / 60 - Math.floor(Math.floor((time_get - 1) / 60) / 60)) * 60)))))
							.replace(".0", ""));
					if (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(minute) >= 10) {
						time_minute = minute;
					} else if (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(minute) >= 1 && new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(minute) < 10) {
						time_minute = ("0" + minute);
					} else {
						time_minute = "00";
					}
					second = ((new java.text.DecimalFormat("##.#").format(Math.floor(new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new java.text.DecimalFormat("##.#").format(((time_get - 1) / 60 - Math.floor((time_get - 1) / 60)) * 60)))))
							.replace(".0", ""));
					if (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(second) >= 10) {
						time_second = second;
					} else if (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(second) == -1) {
						time_second = "59";
					} else {
						time_second = ("0" + second);
					}
					time = (hour + "h " + time_minute + "m " + time_second + "s");
				}
				if (!(type).equals("")) {
					if ((type.substring((int) 0, (int) ("Generate Spell Book : ").length())).equals("Generate Spell Book : ")
							|| (type.substring((int) 0, (int) ("Generate Enchanted Book : ").length())).equals("Generate Enchanted Book : ")
							|| (type.substring((int) 0, (int) ("Separation Enchantment : ").length())).equals("Separation Enchantment : ")
							|| (type.substring((int) 0, (int) ("Demotion Enchantment : ").length())).equals("Demotion Enchantment : ")
							|| (type.substring((int) 0, (int) ("Disenchantment : ").length())).equals("Disenchantment : ")) {
						set_text = ("Pos" + (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "") + " - " + time);
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-enchant_book" + (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
											+ "] run particle minecraft:enchant ^ ^1.9 ^-0.1 0 0 0 0.5 1 force"));
						}
						if (!(type.substring((int) 0, (int) ("Generate Spell Book : ").length())).equals("Generate Spell Book : ")
								&& !(type.substring((int) 0, (int) ("Generate Enchanted Book : ").length())).equals("Generate Enchanted Book : ")) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-enchant_remove] run particle minecraft:enchant ^ ^2.5 ^-0.1 0 0 0 0.5 1 force");
							}
						}
					} else {
						set_text = ("Selected Item" + " - " + time);
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-enchant_remove] run particle minecraft:enchant ^ ^2.5 ^-0.1 0 0 0 0.5 1 force");
						}
					}
					time_get = (time_get - 1);
					if (repeat == 1) {
						LotwModVariables.MapVariables.get(world).spell7_generator1_id = type;
						LotwModVariables.MapVariables.get(world).syncData(world);
						LotwModVariables.MapVariables.get(world).spell7_generator1 = set_text;
						LotwModVariables.MapVariables.get(world).syncData(world);
						LotwModVariables.MapVariables.get(world).spell7_generator1_time = time_get;
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else if (repeat == 2) {
						LotwModVariables.MapVariables.get(world).spell7_generator2_id = type;
						LotwModVariables.MapVariables.get(world).syncData(world);
						LotwModVariables.MapVariables.get(world).spell7_generator2 = set_text;
						LotwModVariables.MapVariables.get(world).syncData(world);
						LotwModVariables.MapVariables.get(world).spell7_generator2_time = time_get;
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else if (repeat == 3) {
						LotwModVariables.MapVariables.get(world).spell7_generator3_id = type;
						LotwModVariables.MapVariables.get(world).syncData(world);
						LotwModVariables.MapVariables.get(world).spell7_generator3 = set_text;
						LotwModVariables.MapVariables.get(world).syncData(world);
						LotwModVariables.MapVariables.get(world).spell7_generator3_time = time_get;
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				repeat = (repeat + 1);
			}
			if (LotwModVariables.MapVariables.get(world).spell7_duration > 0) {
				LotwModVariables.MapVariables.get(world).spell7_duration = (LotwModVariables.MapVariables.get(world).spell7_duration - 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				if (LotwModVariables.MapVariables.get(world).spell7_duration == 0) {
					Spell7useCancelProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}
			if (time_out == true) {
				Spell7timeOutRunProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute if entity @e[tag=LOTW-enchant_book_choose] run title @p[tag=LOTW-user] actionbar [\"\",{\"text\":\"\",\"color\":\"gray\",\"extra\":[{\"selector\":\"@e[tag=LOTW-spell_book_show]\"}]}]");
			}
		}
	}
}
