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

import java.util.Map;

public class Spell1doorUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell1doorUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell1doorUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell1doorUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell1doorUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double effect_count = 0;
		if ((LotwModVariables.MapVariables.get(world).spell1_door1).equals("")) {
			LotwModVariables.MapVariables.get(world).spell1_door1 = LotwModVariables.MapVariables.get(world).spell1_door2;
			LotwModVariables.MapVariables.get(world).syncData(world);
			LotwModVariables.MapVariables.get(world).spell1_door2 = "";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		if ((LotwModVariables.MapVariables.get(world).spell1_door2).equals("")) {
			LotwModVariables.MapVariables.get(world).spell1_door2 = LotwModVariables.MapVariables.get(world).spell1_door3;
			LotwModVariables.MapVariables.get(world).syncData(world);
			LotwModVariables.MapVariables.get(world).spell1_door3 = "";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		if ((LotwModVariables.MapVariables.get(world).spell1_door3).equals("")) {
			LotwModVariables.MapVariables.get(world).spell1_door3 = LotwModVariables.MapVariables.get(world).spell1_door4;
			LotwModVariables.MapVariables.get(world).syncData(world);
			LotwModVariables.MapVariables.get(world).spell1_door4 = "";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		effect_count = LotwModVariables.MapVariables.get(world).spell1_effect_count;
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute as @e[tag=LOTW-zodiac_door] at @s run data merge entity @s {HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}");
		}
		if (LotwModVariables.MapVariables.get(world).spell1_distance == 2) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute as @e[tag=LOTW-zodiac_door] at @s run data merge entity @s {Small:1b}");
			}
		}
		if (LotwModVariables.MapVariables.get(world).spell1_distance < 10) {
			if (effect_count == 1) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "0" + "] at @s run data merge entity @s {HandItems:[{},{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door1 + "\",Count:1b}]}"));
				}
			} else if (effect_count == 2) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "1" + "] at @s run data merge entity @s {HandItems:[{},{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door1 + "\",Count:1b}]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "2" + "] at @s run data merge entity @s {HandItems:[{},{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door2 + "\",Count:1b}]}"));
				}
			} else if (effect_count == 3) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "1" + "] at @s run data merge entity @s {HandItems:[{},{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door1 + "\",Count:1b}]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "5" + "] at @s run data merge entity @s {HandItems:[{},{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door2 + "\",Count:1b}]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "6" + "] at @s run data merge entity @s {HandItems:[{},{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door3 + "\",Count:1b}]}"));
				}
			} else if (effect_count == 4) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "1" + "] at @s run data merge entity @s {HandItems:[{},{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door1 + "\",Count:1b}]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "2" + "] at @s run data merge entity @s {HandItems:[{},{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door2 + "\",Count:1b}]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "3" + "] at @s run data merge entity @s {HandItems:[{},{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door3 + "\",Count:1b}]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "4" + "] at @s run data merge entity @s {HandItems:[{},{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door4 + "\",Count:1b}]}"));
				}
			}
		} else {
			if (effect_count == 1) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "0" + "] at @s run data merge entity @s {HandItems:[{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door1 + "\",Count:1b},{}]}"));
				}
			} else if (effect_count == 2) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "1" + "] at @s run data merge entity @s {HandItems:[{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door1 + "\",Count:1b},{}]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "2" + "] at @s run data merge entity @s {HandItems:[{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door2 + "\",Count:1b},{}]}"));
				}
			} else if (effect_count == 3) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "1" + "] at @s run data merge entity @s {HandItems:[{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door1 + "\",Count:1b},{}]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "5" + "] at @s run data merge entity @s {HandItems:[{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door2 + "\",Count:1b},{}]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "6" + "] at @s run data merge entity @s {HandItems:[{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door3 + "\",Count:1b},{}]}"));
				}
			} else if (effect_count == 4) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "1" + "] at @s run data merge entity @s {HandItems:[{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door1 + "\",Count:1b},{}]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "2" + "] at @s run data merge entity @s {HandItems:[{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door2 + "\",Count:1b},{}]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "3" + "] at @s run data merge entity @s {HandItems:[{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door3 + "\",Count:1b},{}]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute as @e[name=LOTW-zodiac_door" + "4" + "] at @s run data merge entity @s {HandItems:[{id:\"lotw:zodiac_"
									+ LotwModVariables.MapVariables.get(world).spell1_door4 + "\",Count:1b},{}]}"));
				}
			}
		}
	}
}
