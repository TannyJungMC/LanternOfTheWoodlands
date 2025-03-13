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

public class Spell1repeatProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell1repeat!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell1repeat!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell1repeat!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell1repeat!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		String target_good = "";
		String target_bad = "";
		String duration = "";
		if (true) {
			if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("No Target")) {
				target_good = "";
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("You")) {
				target_good = "tag=LOTW-user";
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("Ally")) {
				target_good = "tag=!LOTW-user,tag=LOTW-ally";
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("Enemy")) {
				target_good = "tag=!LOTW-ally";
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("You, Ally")) {
				target_good = "tag=LOTW-ally";
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("Ally, Enemy")) {
				target_good = "tag=!LOTW-user";
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_target_good).equals("All")) {
				target_good = "tag=!LOTW-";
			}
		}
		if (true) {
			if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("No Target")) {
				target_bad = "";
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("You")) {
				target_bad = "tag=LOTW-user";
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("Ally")) {
				target_bad = "tag=!LOTW-user,tag=LOTW-ally";
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("Enemy")) {
				target_bad = "tag=!LOTW-ally";
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("You, Ally")) {
				target_bad = "tag=LOTW-ally";
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("Ally, Enemy")) {
				target_bad = "tag=!LOTW-user";
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_target_bad).equals("All")) {
				target_bad = "tag=!LOTW-";
			}
		}
		if (LotwModVariables.MapVariables.get(world).spell1_distance == 2) {
			duration = "600";
		} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 4) {
			duration = "540";
		} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 6) {
			duration = "480";
		} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 10) {
			duration = "300";
		} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 25) {
			duration = "180";
		} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 50) {
			duration = "120";
		} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 100) {
			duration = "60";
		}
		if (true) {
			if ((LotwModVariables.MapVariables.get(world).spell1_effect3).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect clear @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "]"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect @e[" + target_bad + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] hunger " + "1" + " 20 true"));
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_effect1).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] invisibility " + duration + " 0 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_bad + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + ",type=!armor_stand] glowing " + duration
									+ " 0 true"));
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_effect2).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] strength " + duration + " 1 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_bad + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] weakness " + duration + " 2 true"));
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_effect4).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] jump_boost " + duration + " 4 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_bad + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] levitation " + "1" + " 20 true"));
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_effect5).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] slow_falling " + duration + " 0 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_bad + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] nausea " + duration + " 0 true"));
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_effect6).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] instant_health " + "1" + " 0 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_bad + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] instant_damage " + "1" + " 0 true"));
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_effect7).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] luck " + duration + " 255 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_bad + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] unluck " + duration + " 255 true"));
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_effect8).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] fire_resistance " + duration + " 0 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_bad + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] wither " + "1" + " 1 true"));
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_effect9).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] speed " + duration + " 2 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_bad + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] slowness " + duration + " 3 true"));
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_effect10).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] haste " + duration + " 9 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_bad + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] mining_fatigue " + duration + " 0 true"));
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_effect11).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] conduit_power " + duration + " 0 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] dolphins_grace " + duration + " 0 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_bad + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] nausea " + duration + " 0 true"));
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_effect12).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] night_vision " + duration + " 0 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_bad + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] blindness " + duration + " 0 true"));
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell1_effect13).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_good + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] resistance " + duration + " 3 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[name=LOTW-zodiac_circle] run effect give @e[" + target_bad + ",distance=.."
									+ LotwModVariables.MapVariables.get(world).spell1_distance + "] weakness " + duration + " 1 true"));
				}
			}
		}
	}
}
