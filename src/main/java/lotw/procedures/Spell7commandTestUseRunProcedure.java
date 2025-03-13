package lotw.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.arguments.MessageArgument;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class Spell7commandTestUseRunProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7commandTestUseRun!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell7commandTestUseRun!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell7commandTestUseRun!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell7commandTestUseRun!");
			return;
		}
		if (dependencies.get("arguments") == null) {
			if (!dependencies.containsKey("arguments"))
				LotwMod.LOGGER.warn("Failed to load dependency arguments for procedure Spell7commandTestUseRun!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		CommandContext<CommandSource> arguments = (CommandContext<CommandSource>) dependencies.get("arguments");
		double repeat = 0;
		if (LotwModVariables.MapVariables.get(world).spell7_select == false) {
			if ((LotwModVariables.MapVariables.get(world).spell7_use_double).equals("")) {
				LotwModVariables.MapVariables.get(world).spell7_use_double = (new Object() {
					public String getMessage() {
						try {
							return MessageArgument.getMessage(arguments, "spell_name").getString();
						} catch (CommandSyntaxException ignored) {
							return "";
						}
					}
				}).getMessage();
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_use_double_number = LotwModVariables.MapVariables.get(world).spell7_book_number;
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if (!(LotwModVariables.MapVariables.get(world).spell7_use_double).equals("") && LotwModVariables.MapVariables
					.get(world).spell7_use_double_number != LotwModVariables.MapVariables.get(world).spell7_book_number) {
				if (true) {
					if ((LotwModVariables.MapVariables.get(world).spell7_use_double).equals("Fireball") && ((new Object() {
						public String getMessage() {
							try {
								return MessageArgument.getMessage(arguments, "spell_name").getString();
							} catch (CommandSyntaxException ignored) {
								return "";
							}
						}
					}).getMessage()).equals("Fireball")) {
						LotwModVariables.MapVariables.get(world).spell7_test_use = "Double Fireballs";
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
					if ((LotwModVariables.MapVariables.get(world).spell7_use_double).equals("Strong Wind") && ((new Object() {
						public String getMessage() {
							try {
								return MessageArgument.getMessage(arguments, "spell_name").getString();
							} catch (CommandSyntaxException ignored) {
								return "";
							}
						}
					}).getMessage()).equals("Snowstorm")
							|| (LotwModVariables.MapVariables.get(world).spell7_use_double).equals("Snowstorm") && ((new Object() {
								public String getMessage() {
									try {
										return MessageArgument.getMessage(arguments, "spell_name").getString();
									} catch (CommandSyntaxException ignored) {
										return "";
									}
								}
							}).getMessage()).equals("Strong Wind")) {
						LotwModVariables.MapVariables.get(world).spell7_test_use = "Blizzard";
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
					if ((LotwModVariables.MapVariables.get(world).spell7_use_double).equals("Cold Zone") && ((new Object() {
						public String getMessage() {
							try {
								return MessageArgument.getMessage(arguments, "spell_name").getString();
							} catch (CommandSyntaxException ignored) {
								return "";
							}
						}
					}).getMessage()).equals("Cold Zone")) {
						LotwModVariables.MapVariables.get(world).spell7_test_use = "Frozen Zone";
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
					if ((LotwModVariables.MapVariables.get(world).spell7_use_double).equals("Cursing") && ((new Object() {
						public String getMessage() {
							try {
								return MessageArgument.getMessage(arguments, "spell_name").getString();
							} catch (CommandSyntaxException ignored) {
								return "";
							}
						}
					}).getMessage()).equals("Cursing")) {
						LotwModVariables.MapVariables.get(world).spell7_test_use = "Advance Cursing";
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
					if ((LotwModVariables.MapVariables.get(world).spell7_use_double).equals("Heal") && ((new Object() {
						public String getMessage() {
							try {
								return MessageArgument.getMessage(arguments, "spell_name").getString();
							} catch (CommandSyntaxException ignored) {
								return "";
							}
						}
					}).getMessage()).equals("Heal")) {
						LotwModVariables.MapVariables.get(world).spell7_test_use = "Advance Heal";
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (!(LotwModVariables.MapVariables.get(world).spell7_test_use).equals("")) {
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute unless entity @e[tag=LOTW-enchant_book_choose] run tag @e[name=LOTW-enchant_book"
											+ (new java.text.DecimalFormat("##.#")
													.format(LotwModVariables.MapVariables.get(world).spell7_use_double_number)).replace(".0", "")
											+ ",nbt={ArmorItems:[{id:\"lotw:spell_book\",Count:1b,tag:{display:{Lore:[\"{\\\"text\\\":\\\""
											+ LotwModVariables.MapVariables.get(world).spell7_use_double + "\\\"}\"]}}},{},{},{}]}] "
											+ "add LOTW-enchant_book_choose2"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute unless entity @e[tag=LOTW-enchant_book_choose] run tag @e[name=LOTW-enchant_book"
											+ (new java.text.DecimalFormat("##.#")
													.format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(".0", "")
											+ ",nbt={ArmorItems:[{id:\"lotw:spell_book\",Count:1b,tag:{display:{Lore:[\"{\\\"text\\\":\\\""
											+ (new Object() {
												public String getMessage() {
													try {
														return MessageArgument.getMessage(arguments, "spell_name").getString();
													} catch (CommandSyntaxException ignored) {
														return "";
													}
												}
											}).getMessage() + "\\\"}\"]}}},{},{},{}]}] " + "add LOTW-enchant_book_choose3"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book_choose2] at @s run tp @s ^ ^ ^-3 facing ^ ^ ^-100");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[tag=LOTW-enchant_book_choose2] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_use2\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[0f,0f,0f]},Small:1b}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book_choose2] at @s run tp @e[name=LOTW-spell_book_use2] @s");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book_choose3] at @s run tp @s ^ ^ ^-3 facing ^ ^ ^-100");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[tag=LOTW-enchant_book_choose3] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_use3\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[0f,0f,0f]},Small:1b}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book_choose3] at @s run tp @e[name=LOTW-spell_book_use3] @s");
						}
						Spell7setBookTextureProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book_choose2] at @s if data entity @s {ArmorItems:[{id:\"lotw:spell_book\",Count:1b},{},{},{}]} run playsound minecraft:item.book.page_turn ambient @a ~ ~ ~ 0.1 0");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book_choose3] at @s if data entity @s {ArmorItems:[{id:\"lotw:spell_book\",Count:1b},{},{},{}]} run playsound minecraft:item.book.page_turn ambient @a ~ ~ ~ 0.1 0");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book_choose2] at @s run data modify entity @e[name=LOTW-spell_book_use2,limit=1] ArmorItems[3] set from entity @s ArmorItems[3]");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book_choose2] at @s run data merge entity @s {ArmorItems:[{},{},{},{id:\"lotw:invisible_block\",Count:1b}]}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book_choose3] at @s run data modify entity @e[name=LOTW-spell_book_use3,limit=1] ArmorItems[3] set from entity @s ArmorItems[3]");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book_choose3] at @s run data merge entity @s {ArmorItems:[{},{},{},{id:\"lotw:invisible_block\",Count:1b}]}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"tag @e[tag=LOTW-enchant_book] remove LOTW-enchant_book_choose2");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"tag @e[tag=LOTW-enchant_book] remove LOTW-enchant_book_choose3");
						}
					}
					if (true) {
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[name=LOTW-spell_book_use2] at @s if entity @e[name=LOTW-spell_book_use3,distance=..1] at @e[name=LOTW-enchant_bookshelf] run tp @s ^ ^-0.25 ^3");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[name=LOTW-spell_book_use3] at @s if entity @e[name=LOTW-spell_book_use2,distance=..10] at @e[name=LOTW-enchant_bookshelf] run tp @s ^1.5 ^-0.25 ^3");
							}
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[name=LOTW-spell_book_use3] at @s if entity @e[name=LOTW-spell_book_use2,distance=..10] at @e[name=LOTW-enchant_bookshelf] run tp @s ^1.5 ^-0.25 ^3");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[name=LOTW-spell_book_use2] at @s if entity @e[name=LOTW-spell_book_use3,distance=..1] at @e[name=LOTW-enchant_bookshelf] run tp @s ^ ^-0.25 ^3");
							}
						}
					}
					Spell7commandTestUseRun2Procedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					LotwModVariables.MapVariables.get(world).spell7_use_double = "";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_use_double_number = 0;
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else {
					LotwModVariables.MapVariables.get(world).spell7_use_double = "";
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_use_double_number = 0;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			} else {
				if (true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute unless entity @e[tag=LOTW-enchant_book_choose] run tag @e[name=LOTW-enchant_book"
										+ (new java.text.DecimalFormat("##.#")
												.format(LotwModVariables.MapVariables.get(world).spell7_use_double_number)).replace(".0", "")
										+ ",nbt={ArmorItems:[{id:\"lotw:spell_book\",Count:1b,tag:{display:{Lore:[\"{\\\"text\\\":\\\""
										+ LotwModVariables.MapVariables.get(world).spell7_use_double + "\\\"}\"]}}},{},{},{}]}] "
										+ "add LOTW-enchant_book_choose2"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[tag=LOTW-enchant_book_choose2] at @s run tp @s ^ ^ ^-3 facing ^ ^ ^-100");
					}
					Spell7setBookTextureProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[tag=LOTW-enchant_book_choose2] at @s if data entity @s {ArmorItems:[{id:\"lotw:spell_book\",Count:1b},{},{},{}]} run playsound minecraft:item.book.page_turn ambient @a ~ ~ ~ 0.1 0");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[tag=LOTW-enchant_book_choose2] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_use\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[0f,0f,0f]},Small:1b}");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[tag=LOTW-enchant_book_choose2] at @s run tp @e[name=LOTW-spell_book_use] @s");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[tag=LOTW-enchant_book_choose2] at @s run data modify entity @e[name=LOTW-spell_book_use,limit=1] ArmorItems[3] set from entity @s ArmorItems[3]");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[tag=LOTW-enchant_book_choose2] at @s run data merge entity @s {ArmorItems:[{},{},{},{id:\"lotw:invisible_block\",Count:1b}]}");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"tag @e[tag=LOTW-enchant_book] remove LOTW-enchant_book_choose2");
					}
				}
				LotwModVariables.MapVariables.get(world).spell7_test_use = (new Object() {
					public String getMessage() {
						try {
							return MessageArgument.getMessage(arguments, "spell_name").getString();
						} catch (CommandSyntaxException ignored) {
							return "";
						}
					}
				}).getMessage();
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_use_double = "";
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell7_use_double_number = 0;
				LotwModVariables.MapVariables.get(world).syncData(world);
				Spell7commandTestUseRun2Procedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		} else {
			LotwModVariables.MapVariables.get(world).spell7_test_use = (new Object() {
				public String getMessage() {
					try {
						return MessageArgument.getMessage(arguments, "spell_name").getString();
					} catch (CommandSyntaxException ignored) {
						return "";
					}
				}
			}).getMessage();
			LotwModVariables.MapVariables.get(world).syncData(world);
			Spell7commandTestUseRun2Procedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
