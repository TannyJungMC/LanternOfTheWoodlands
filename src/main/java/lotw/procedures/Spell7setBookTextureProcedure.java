package lotw.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lotw.LotwMod;

import java.util.Map;

public class Spell7setBookTextureProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7setBookTexture!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell7setBookTexture!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell7setBookTexture!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell7setBookTexture!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		String spell = "";
		String spell_type = "";
		double repeat = 0;
		double test = 0;
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute as @e[tag=LOTW-enchant_book,tag=!LOTW-enchant_book_choose] at @s run data merge entity @s {Pose:{Head:[0f,0f,0f]}}");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute as @e[tag=LOTW-enchant_book,tag=LOTW-enchant_book_choose] at @s run data merge entity @s {Pose:{Head:[-45f,0f,0f]}}");
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-enchant_book,tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"minecraft:book\",Count:1b},{},{},{}]} run data modify entity @s ArmorItems[3] set value {id:\"lotw:book\",Count:1b}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-enchant_book,tag=!LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"minecraft:book\",Count:1b},{},{},{}]} run data modify entity @s ArmorItems[3] set value {id:\"lotw:book_close\",Count:1b}");
			}
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-enchant_book,tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"minecraft:writable_book\",Count:1b},{},{},{}]} run data modify entity @s ArmorItems[3] set value {id:\"lotw:book_writing\",Count:1b}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-enchant_book,tag=!LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"minecraft:writable_book\",Count:1b},{},{},{}]} run data modify entity @s ArmorItems[3] set value {id:\"lotw:book_writing_close\",Count:1b}");
			}
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-enchant_book,tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"minecraft:written_book\",Count:1b},{},{},{}]} run data modify entity @s ArmorItems[3] set value {id:\"lotw:book_written\",Count:1b}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-enchant_book,tag=!LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"minecraft:written_book\",Count:1b},{},{},{}]} run data modify entity @s ArmorItems[3] set value {id:\"lotw:book_written_close\",Count:1b}");
			}
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-enchant_book,tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"minecraft:enchanted_book\",Count:1b},{},{},{}]} run data modify entity @s ArmorItems[3] set value {id:\"lotw:book_enchanted\",Count:1b}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-enchant_book,tag=!LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"minecraft:enchanted_book\",Count:1b},{},{},{}]} run data modify entity @s ArmorItems[3] set value {id:\"lotw:book_enchanted_close\",Count:1b}");
			}
		}
		repeat = 1;
		while (true) {
			test = 1;
			if (true) {
				if (!("").equals("adaptive")) {
					if (true) {
						if (repeat == test) {
							spell_type = "weather";
							spell = "The Peaceful Day";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "weather";
							spell = "Heavy Rain";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "weather";
							spell = "Thunder Storm";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "weather";
							spell = "Snowstorm";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "weather";
							spell = "Strong Wind";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "weather";
							spell = "Cloud Manipulation";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "weather";
							spell = "Lightning Bolt";
						}
						test = (test + 1);
					}
				}
				if (!("").equals("fire")) {
					if (true) {
						if (repeat == test) {
							spell_type = "fire";
							spell = "Fireball";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "fire";
							spell = "Multiple Fireballs";
						}
						test = (test + 1);
					}
				}
				if (!("").equals("healing")) {
					if (true) {
						if (repeat == test) {
							spell_type = "healing";
							spell = "Heal";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "healing";
							spell = "Healing Area";
						}
						test = (test + 1);
					}
				}
				if (!("").equals("ice")) {
					if (true) {
						if (repeat == test) {
							spell_type = "ice";
							spell = "Cold Zone";
						}
						test = (test + 1);
					}
				}
				if (!("").equals("dark")) {
					if (true) {
						if (repeat == test) {
							spell_type = "dark";
							spell = "Cursing";
						}
						test = (test + 1);
					}
				}
				if (!("").equals("holy")) {
					if (true) {
						if (repeat == test) {
							spell_type = "holy";
							spell = "Antidote";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "holy";
							spell = "Cleanse";
						}
						test = (test + 1);
					}
				}
				if (!("").equals("light")) {
					if (true) {
						if (repeat == test) {
							spell_type = "light";
							spell = "Uncovering";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "light";
							spell = "Midnight Friend";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "light";
							spell = "Fireflies Dance";
						}
						test = (test + 1);
					}
				}
				if (!("").equals("adaptive")) {
					if (true) {
						if (repeat == test) {
							spell_type = "adaptive";
							spell = "Firework";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "adaptive";
							spell = "Multiple Fireworks";
						}
						test = (test + 1);
					}
				}
				if (!("").equals("wind")) {
					if (true) {
						if (repeat == test) {
							spell_type = "wind";
							spell = "Wind Knockback";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "wind";
							spell = "Wind Cutter";
						}
						test = (test + 1);
					}
				}
				if (!("").equals("teleportation")) {
					if (true) {
						if (repeat == test) {
							spell_type = "teleportation";
							spell = "Return";
						}
						test = (test + 1);
					}
					if (true) {
						if (repeat == test) {
							spell_type = "teleportation";
							spell = "Time Travelling";
						}
						test = (test + 1);
					}
				}
			}
			if (repeat == test) {
				break;
			} else {
				repeat = (repeat + 1);
				if (true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[tag=LOTW-enchant_book,tag=!LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"lotw:spell_book\",Count:1b,tag:{display:{Lore:[\"{\\\"text\\\":\\\""
										+ "" + spell
										+ "\\\"}\"]}}},{},{},{}]} run data modify entity @s ArmorItems[3] set value {id:\"lotw:spell_book_"
										+ spell_type + "_close\",Count:1b}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[tag=LOTW-enchant_book,tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"lotw:spell_book\",Count:1b,tag:{display:{Lore:[\"{\\\"text\\\":\\\""
										+ "" + spell
										+ "\\\"}\"]}}},{},{},{}]} run data modify entity @s ArmorItems[3] set value {id:\"lotw:spell_book_"
										+ spell_type + "\",Count:1b}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[tag=LOTW-enchant_book,tag=LOTW-enchant_book_choose2] at @s if data entity @s {ArmorItems:[{id:\"lotw:spell_book\",Count:1b,tag:{display:{Lore:[\"{\\\"text\\\":\\\""
										+ "" + spell
										+ "\\\"}\"]}}},{},{},{}]} run data modify entity @s ArmorItems[3] set value {id:\"lotw:spell_book_"
										+ spell_type + "\",Count:1b}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[tag=LOTW-enchant_book,tag=LOTW-enchant_book_choose3] at @s if data entity @s {ArmorItems:[{id:\"lotw:spell_book\",Count:1b,tag:{display:{Lore:[\"{\\\"text\\\":\\\""
										+ "" + spell
										+ "\\\"}\"]}}},{},{},{}]} run data modify entity @s ArmorItems[3] set value {id:\"lotw:spell_book_"
										+ spell_type + "\",Count:1b}"));
					}
				}
			}
		}
	}
}
