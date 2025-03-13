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

public class Spell7timeOutRunProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7timeOutRun!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell7timeOutRun!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell7timeOutRun!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell7timeOutRun!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		String time = "";
		String time_minute = "";
		String time_second = "";
		String second = "";
		String minute = "";
		String id = "";
		String id_test = "";
		double time_get = 0;
		double pos = 0;
		double repeat = 0;
		repeat = 1;
		for (int index0 = 0; index0 < (int) (3); index0++) {
			pos = 0;
			id_test = "";
			if (repeat == 1) {
				if (LotwModVariables.MapVariables.get(world).spell7_generator1_time == 0) {
					LotwModVariables.MapVariables.get(world).spell7_generator1_time = (-1);
					LotwModVariables.MapVariables.get(world).syncData(world);
					id_test = LotwModVariables.MapVariables.get(world).spell7_generator1_id;
					pos = LotwModVariables.MapVariables.get(world).spell7_generator1_pos;
				}
			} else if (repeat == 2) {
				if (LotwModVariables.MapVariables.get(world).spell7_generator2_time == 0) {
					LotwModVariables.MapVariables.get(world).spell7_generator2_time = (-1);
					LotwModVariables.MapVariables.get(world).syncData(world);
					id_test = LotwModVariables.MapVariables.get(world).spell7_generator2_id;
					pos = LotwModVariables.MapVariables.get(world).spell7_generator2_pos;
				}
			} else if (repeat == 3) {
				if (LotwModVariables.MapVariables.get(world).spell7_generator3_time == 0) {
					LotwModVariables.MapVariables.get(world).spell7_generator3_time = (-1);
					LotwModVariables.MapVariables.get(world).syncData(world);
					id_test = LotwModVariables.MapVariables.get(world).spell7_generator3_id;
					pos = LotwModVariables.MapVariables.get(world).spell7_generator3_pos;
				}
			}
			if (!(id_test).equals("")) {
				if ((id_test.substring((int) 0, (int) ("Generate Spell Book : ").length())).equals("Generate Spell Book : ")) {
					id = (id_test.substring((int) ("Generate Spell Book : ").length(), (int) (id_test).length()));
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[name=LOTW-enchant_book" + (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
										+ "] at @s run data merge entity @s {ArmorItems:[{id:\"lotw:spell_book\",Count:1b,tag:{display:{Lore:[\"{\\\"text\\\":\\\""
										+ id + "\\\"}\"]}}},{},{},{}]}"));
					}
				}
				if ((id_test.substring((int) 0, (int) ("Generate Enchanted Book : ").length())).equals("Generate Enchanted Book : ")) {
					id = (id_test.substring((int) ("Generate Enchanted Book : ").length(), (int) (id_test).length()));
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[name=LOTW-enchant_book" + (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
										+ "] at @s run data merge entity @s {ArmorItems:[{id:\"enchanted_book\",Count:1b,tag:{StoredEnchantments:[{lvl:1s,id:\""
										+ id + "\"}]}},{},{},{}]}"));
					}
				} else if ((id_test.substring((int) 0, (int) ("Separation Enchantment : ").length())).equals("Separation Enchantment : ")) {
					id = (id_test.substring((int) ("Separation Enchantment : ").length(), (int) (id_test).length()));
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-enchant_remove] at @s unless data entity @s {ArmorItems:[{},{},{},{id:\"lotw:invisible_block\"}]} if data entity @s ArmorItems[3].tag.StoredEnchantments[{id:\""
											+ "" + id + "\"}] as @e[name=LOTW-enchant_book"
											+ (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
											+ "] at @s run data merge entity @s {ArmorItems:[{id:\"minecraft:enchanted_book\",Count:1b,tag:{StoredEnchantments:[]}},{},{},{}]}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-enchant_remove] at @s unless data entity @s {ArmorItems:[{},{},{},{id:\"lotw:invisible_block\"}]} if data entity @s ArmorItems[3].tag.Enchantments[{id:\""
											+ "" + id + "\"}] as @e[name=LOTW-enchant_book"
											+ (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
											+ "] at @s run data merge entity @s {ArmorItems:[{id:\"minecraft:enchanted_book\",Count:1b,tag:{StoredEnchantments:[]}},{},{},{}]}"));
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + "Stored"
												+ "Enchantments as @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
												+ "] at @s run data modify entity @s ArmorItems[0].tag.StoredEnchantments[] set from entity @e[name=LOTW-enchant_remove,limit=1] ArmorItems[3].tag."
												+ "Stored" + "Enchantments[{id:\"" + id + "\"}]"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + ""
												+ "Enchantments as @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
												+ "] at @s run data modify entity @s ArmorItems[0].tag.StoredEnchantments[] set from entity @e[name=LOTW-enchant_remove,limit=1] ArmorItems[3].tag."
												+ "" + "Enchantments[{id:\"" + id + "\"}]"));
							}
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + "Stored"
												+ "Enchantments store result score LOTW-enchant LOTW-enchant run data get entity @s ArmorItems[3].tag."
												+ "Stored" + "Enchantments[{id:\"" + id + "\"}].lvl"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + ""
												+ "Enchantments store result score LOTW-enchant LOTW-enchant run data get entity @s ArmorItems[3].tag."
												+ "" + "Enchantments[{id:\"" + id + "\"}].lvl"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + "Stored"
												+ "Enchantments store result entity @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "") + ",limit=1] ArmorItems[0].tag."
												+ "Stored" + "Enchantments[{id:\"" + id
												+ "\"}].lvl short 1 run scoreboard players get LOTW-enchant LOTW-enchant"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + ""
												+ "Enchantments store result entity @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "") + ",limit=1] ArmorItems[0].tag."
												+ "Stored" + "Enchantments[{id:\"" + id
												+ "\"}].lvl short 1 run scoreboard players get LOTW-enchant LOTW-enchant"));
							}
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("data remove entity @e[name=LOTW-enchant_remove,limit=1] ArmorItems[3].tag.StoredEnchantments[{id:\"" + "" + id
											+ "\"}]"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("data remove entity @e[name=LOTW-enchant_remove,limit=1] ArmorItems[3].tag.Enchantments[{id:\"" + "" + id
											+ "\"}]"));
						}
					}
				} else if ((id_test.substring((int) 0, (int) ("Elevation Enchantment : ").length())).equals("Elevation Enchantment : ")) {
					id = (id_test.substring((int) ("Elevation Enchantment : ").length(), (int) (id_test).length()));
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + "Stored"
											+ "Enchantments store result score LOTW-enchant LOTW-enchant run data get entity @s ArmorItems[3].tag."
											+ "Stored" + "Enchantments[{id:\"" + id + "\"}].lvl"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + ""
											+ "Enchantments store result score LOTW-enchant LOTW-enchant run data get entity @s ArmorItems[3].tag."
											+ "" + "Enchantments[{id:\"" + id + "\"}].lvl"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"scoreboard players add LOTW-enchant LOTW-enchant 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + "Stored"
											+ "Enchantments store result entity @s ArmorItems[3].tag." + "Stored" + "Enchantments[{id:\"" + id
											+ "\"}].lvl short 1 run scoreboard players get LOTW-enchant LOTW-enchant"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + ""
											+ "Enchantments store result entity @s ArmorItems[3].tag." + "" + "Enchantments[{id:\"" + id
											+ "\"}].lvl short 1 run scoreboard players get LOTW-enchant LOTW-enchant"));
						}
					}
				} else if ((id_test.substring((int) 0, (int) ("Demotion Enchantment : ").length())).equals("Demotion Enchantment : ")) {
					id = (id_test.substring((int) ("Demotion Enchantment : ").length(), (int) (id_test).length()));
					if (true) {
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute unless entity @e[name=LOTW-enchant_remove,nbt={ArmorItems:[{},{},{},{id:\"lotw:invisible_block\"}]}] if score LOTW-enchant LOTW-enchant matches 1.. as @e[name=LOTW-enchant_book"
												+ "" + (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
												+ "] at @s run data merge entity @s {ArmorItems:[{id:\"minecraft:enchanted_book\",Count:1b,tag:{StoredEnchantments:[{lvl:1s,id:\"\"}]}},{},{},{}]}"));
							}
							if (true) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + "Stored"
													+ "Enchantments as @e[name=LOTW-enchant_book"
													+ (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
													+ "] at @s run data modify entity @s ArmorItems[0].tag.StoredEnchantments[].id set from entity @e[name=LOTW-enchant_remove,limit=1] ArmorItems[3].tag."
													+ "Stored" + "Enchantments[{id:\"" + id + "\"}].id"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + ""
													+ "Enchantments as @e[name=LOTW-enchant_book"
													+ (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
													+ "] at @s run data modify entity @s ArmorItems[0].tag.StoredEnchantments[].id set from entity @e[name=LOTW-enchant_remove,limit=1] ArmorItems[3].tag."
													+ "" + "Enchantments[{id:\"" + id + "\"}].id"));
								}
							}
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + "Stored"
												+ "Enchantments store result score LOTW-enchant LOTW-enchant run data get entity @s ArmorItems[3].tag."
												+ "Stored" + "Enchantments[{id:\"" + id + "\"}].lvl"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + ""
												+ "Enchantments store result score LOTW-enchant LOTW-enchant run data get entity @s ArmorItems[3].tag."
												+ "" + "Enchantments[{id:\"" + id + "\"}].lvl"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute if score LOTW-enchant LOTW-enchant matches 1.. run scoreboard players remove LOTW-enchant LOTW-enchant 1");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + "Stored"
												+ "Enchantments store result entity @s ArmorItems[3].tag." + "Stored" + "Enchantments[{id:\"" + id
												+ "\"}].lvl short 1 run scoreboard players get LOTW-enchant LOTW-enchant"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_remove] at @s if data entity @s ArmorItems[3].tag." + ""
												+ "Enchantments store result entity @s ArmorItems[3].tag." + "" + "Enchantments[{id:\"" + id
												+ "\"}].lvl short 1 run scoreboard players get LOTW-enchant LOTW-enchant"));
							}
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-enchant_remove] at @s run data remove entity @s ArmorItems[3].tag." + "Stored"
											+ "Enchantments[{lvl:0s}]"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-enchant_remove] at @s run data remove entity @s ArmorItems[3].tag." + ""
											+ "Enchantments[{lvl:0s}]"));
						}
					}
				} else if ((id_test.substring((int) 0, (int) ("Cheapening : ").length())).equals("Cheapening : ")) {
					id = (id_test.substring((int) ("Cheapening : ").length(), (int) (id_test).length()));
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-enchant_remove] at @s run data remove entity @s ArmorItems[3].tag.RepairCost");
					}
				} else if ((id_test.substring((int) 0, (int) ("Disenchantment : ").length())).equals("Disenchantment : ")) {
					id = (id_test.substring((int) ("Disenchantment : ").length(), (int) (id_test).length()));
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-enchant_remove] at @s unless data entity @s {ArmorItems:[{},{},{},{id:\"lotw:invisible_block\"}]} as @e[name=LOTW-enchant_book"
											+ "" + (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
											+ "] at @s run data merge entity @s {ArmorItems:[{id:\"minecraft:enchanted_book\",Count:1b,tag:{StoredEnchantments:[]}},{},{},{}]}"));
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_remove] at @s as @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
												+ "] at @s run data modify entity @s ArmorItems[0].tag.StoredEnchantments set from entity @e[name=LOTW-enchant_remove,limit=1] ArmorItems[3].tag."
												+ "Stored" + "Enchantments"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_remove] at @s as @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
												+ "] at @s run data modify entity @s ArmorItems[0].tag.StoredEnchantments set from entity @e[name=LOTW-enchant_remove,limit=1] ArmorItems[3].tag."
												+ "" + "Enchantments"));
							}
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("data remove entity @e[name=LOTW-enchant_remove,limit=1] ArmorItems[3].tag." + "Stored" + "Enchantments"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("data remove entity @e[name=LOTW-enchant_remove,limit=1] ArmorItems[3].tag." + "" + "Enchantments"));
						}
					}
				}
				if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Generate Spell Book")
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Generate Enchanted Book")
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Separation Enchantment")
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Demotion Enchantment")
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Disenchantment")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-enchant_book" + (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
										+ "] run playsound minecraft:block.enchantment_table.use ambient @a[distance=..100] ~ ~ ~ 0.25 0.75 0.025"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-enchant_book" + (new java.text.DecimalFormat("##.#").format(pos)).replace(".0", "")
										+ "] run particle minecraft:reverse_portal ^ ^0.75 ^-0.25 0.1 0.1 0.1 0.025 10 force"));
					}
				} else if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Separation Enchantment")
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Elevation Enchantment")
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Demotion Enchantment")
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Cheapening")
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Disenchantment")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-enchant_remove] run playsound minecraft:block.enchantment_table.use ambient @a[distance=..100] ~ ~ ~ 0.25 0.75 0.025");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-enchant_remove] run particle minecraft:reverse_portal ~ ~1 ~ 0.25 0.25 0.25 0.025 10 force");
					}
				}
			}
			if (repeat == 1) {
				if (LotwModVariables.MapVariables.get(world).spell7_generator1_time == -1) {
					LotwModVariables.MapVariables.get(world).spell7_generator1_id = "";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_generator1 = "";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_generator1_pos = 0;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			} else if (repeat == 2) {
				if (LotwModVariables.MapVariables.get(world).spell7_generator2_time == -1) {
					LotwModVariables.MapVariables.get(world).spell7_generator2_id = "";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_generator2 = "";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_generator2_pos = 0;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			} else if (repeat == 3) {
				if (LotwModVariables.MapVariables.get(world).spell7_generator3_time == -1) {
					LotwModVariables.MapVariables.get(world).spell7_generator3_id = "";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_generator3 = "";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_generator3_pos = 0;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			}
			repeat = (repeat + 1);
		}
		Spell7setBookTextureProcedure
				.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
	}
}
