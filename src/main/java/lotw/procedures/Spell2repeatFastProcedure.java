package lotw.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.Minecraft;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell2repeatFastProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell2repeatFast!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell2repeatFast!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell2repeatFast!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell2repeatFast!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double distance_particle = 0;
		double distance_test_1 = 0;
		double distance_test_2 = 0;
		double degree = 0;
		double loop = 0;
		double loop_set = 0;
		double speed = 0;
		if ((LotwModVariables.MapVariables.get(world).spell2_speed).equals("1s (Very Low)")) {
			speed = 200;
		} else if ((LotwModVariables.MapVariables.get(world).spell2_speed).equals("2s (Low)")) {
			speed = 400;
		} else if ((LotwModVariables.MapVariables.get(world).spell2_speed).equals("3s (Medium)")) {
			speed = 600;
		} else if ((LotwModVariables.MapVariables.get(world).spell2_speed).equals("5s (High)")) {
			speed = 1000;
		}
		distance_particle = (LotwModVariables.MapVariables.get(world).spell2_distance / (speed / LotwModVariables.MapVariables.get(world).spell2_size)
				+ 0.5);
		distance_test_1 = ((LotwModVariables.MapVariables.get(world).spell2_distance / speed) * LotwModVariables.MapVariables.get(world).spell2_zoom
				- LotwModVariables.MapVariables.get(world).spell2_zoom / (speed / 10));
		distance_test_2 = ((LotwModVariables.MapVariables.get(world).spell2_distance / speed) * LotwModVariables.MapVariables.get(world).spell2_zoom);
		if (LotwModVariables.MapVariables.get(world).spell2_start_repeat == true) {
			if ((LotwModVariables.MapVariables.get(world).spell2_show_info).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[name=LOTW-spell2main] at @s run tp @s ~ ~ ~ ~2 ~");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-spell2main] run particle lotw:dot_yellow_small ^ ^ ^" + "0.5" + " 0 0 0 0 1 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-spell2main] run particle lotw:dot_yellow_small ^ ^ ^-" + "0.5" + " 0 0 0 0 1 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-spell2main] run particle lotw:dot_yellow_small ^ ^ ^"
									+ (LotwModVariables.MapVariables.get(world).spell2_size * 0.1 + 0.5) + " 0 0 0 0 1 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-spell2main] run particle lotw:dot_yellow_small ^ ^ ^-"
									+ (LotwModVariables.MapVariables.get(world).spell2_size * 0.1 + 0.5) + " 0 0 0 0 1 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-spell2main] run particle lotw:dot_yellow_small ^ ^ ^"
									+ (LotwModVariables.MapVariables.get(world).spell2_size * 0.5 + 0.5) + " 0 0 0 0 1 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-spell2main] run particle lotw:dot_yellow_small ^ ^ ^-"
									+ (LotwModVariables.MapVariables.get(world).spell2_size * 0.5 + 0.5) + " 0 0 0 0 1 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-spell2main] run particle lotw:dot_yellow_small ^ ^ ^"
									+ (LotwModVariables.MapVariables.get(world).spell2_size + 0.5) + " 0 0 0 0 1 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-spell2main] run particle lotw:dot_yellow_small ^ ^ ^-"
									+ (LotwModVariables.MapVariables.get(world).spell2_size + 0.5) + " 0 0 0 0 1 force"));
				}
			}
			if (true) {
				if ((LotwModVariables.MapVariables.get(world).spell2_show_entity).equals("On")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-spell2main] facing entity @e[distance=" + (distance_test_1 + ".." + distance_test_2)
										+ ",tag=!LOTW-ally,tag=!LOTW-user,type=" + LotwModVariables.MapVariables.get(world).spell2_findkey_list
										+ "] eyes run particle lotw:dot_white ^ ^ ^" + distance_particle + " 0 0 0 0 1 force"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[distance=" + (distance_test_1 + ".." + distance_test_2) + ",tag=LOTW-ally,tag=!LOTW-user,type="
										+ LotwModVariables.MapVariables.get(world).spell2_findkey_list
										+ "] at @s if entity @s[type=!armor_stand] at @e[name=LOTW-spell2main] facing entity @s eyes run particle lotw:dot_blue ^ ^ ^"
										+ distance_particle + " 0 0 0 0 1 force"));
					}
					if ((LotwModVariables.MapVariables.get(world).spell2_footstep).equals("All")
							|| (LotwModVariables.MapVariables.get(world).spell2_footstep).equals("Entity")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-spell2main] facing entity @e[distance=" + (distance_test_1 + ".." + distance_test_2)
											+ ",tag=!LOTW-ally,tag=!LOTW-user,type=" + LotwModVariables.MapVariables.get(world).spell2_findkey_list
											+ "] eyes run particle lotw:animation_dot_footstep ^ ^ ^" + distance_particle + " 0 0 0 0 1 force"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[distance=" + (distance_test_1 + ".." + distance_test_2) + ",tag=LOTW-ally,tag=!LOTW-user,type="
											+ LotwModVariables.MapVariables.get(world).spell2_findkey_list
											+ "] at @s if entity @s[type=!armor_stand] at @e[name=LOTW-spell2main] facing entity @s eyes run particle lotw:animation_dot_footstep ^ ^ ^"
											+ distance_particle + " 0 0 0 0 1 force"));
						}
					}
				}
				if ((LotwModVariables.MapVariables.get(world).spell2_show_player).equals("On")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-spell2main] facing entity @e[distance=" + (distance_test_1 + ".." + distance_test_2)
										+ ",type=player,tag=LOTW-ally,tag=LOTW-user" + "] eyes run particle lotw:dot_green ^ ^ ^" + distance_particle
										+ " 0 0 0 0 1 force"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-spell2main] facing entity @e[distance=" + (distance_test_1 + ".." + distance_test_2)
										+ ",type=player,tag=!LOTW-ally,tag=!LOTW-user" + "] eyes run particle lotw:dot_red ^ ^ ^" + distance_particle
										+ " 0 0 0 0 1 force"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-spell2main] facing entity @e[distance=" + (distance_test_1 + ".." + distance_test_2)
										+ ",type=player,tag=LOTW-ally,tag=!LOTW-user" + "] eyes run particle lotw:dot_blue ^ ^ ^" + distance_particle
										+ " 0 0 0 0 1 force"));
					}
					if ((LotwModVariables.MapVariables.get(world).spell2_notification_other_team).equals("On")) {
						if (distance_test_2 <= 100) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[name=LOTW-spell2main] positioned ~ ~0.25 ~ facing entity @e[distance="
												+ (distance_test_1 + ".." + distance_test_2) + ",type=player,tag=!LOTW-ally,tag=!LOTW-user"
												+ "] eyes run particle lotw:warning ^ ^ ^" + distance_particle + " 0 0 0 0 1 force"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[name=LOTW-spell2main] positioned ~ ~0.25 ~ facing entity @e[distance="
												+ (distance_test_1 + ".." + distance_test_2) + ",type=player,tag=!LOTW-ally,tag=!LOTW-user"
												+ "] eyes run playsound minecraft:block.note_block.chime ambient @a ^ ^ ^" + distance_particle
												+ " 2 0"));
							}
						}
					}
					if ((LotwModVariables.MapVariables.get(world).spell2_notification_buoy).equals("On")) {
						if ((LotwModVariables.MapVariables.get(world).spell2_show_waypoint).equals("On")) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-spell2waypoint] at @s if entity @e["
												+ "type=player,tag=!LOTW-ally,tag=!LOTW-user,distance=..20,limit=1"
												+ "] run execute at @e[name=LOTW-spell2main] positioned ~ ~0.25 ~ facing entity @s[distance="
												+ (distance_test_1 + ".." + distance_test_2) + "] eyes run particle lotw:warning ^ ^ ^"
												+ distance_particle + " 0 0 0 0 1 force"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-spell2waypoint] at @s if entity @e["
												+ "type=player,tag=!LOTW-ally,tag=!LOTW-user,distance=..20,limit=1"
												+ "] run execute at @e[name=LOTW-spell2main] positioned ~ ~0.25 ~ facing entity @s[distance="
												+ (distance_test_1 + ".." + distance_test_2)
												+ "] eyes run playsound minecraft:block.note_block.chime ambient @a ^ ^ ^" + distance_particle
												+ " 2 0"));
							}
						}
					}
					if ((LotwModVariables.MapVariables.get(world).spell2_footstep).equals("All")
							|| (LotwModVariables.MapVariables.get(world).spell2_footstep).equals("Player")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-spell2main] facing entity @e[distance=" + (distance_test_1 + ".." + distance_test_2)
											+ ",type=player,tag=LOTW-ally,tag=LOTW-user" + "] eyes run particle lotw:animation_dot_footstep ^ ^ ^"
											+ distance_particle + " 0 0 0 0 1 force"));
						}
					}
				}
				if ((LotwModVariables.MapVariables.get(world).spell2_show_tracker).equals("On")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-spell2main] facing entity @e[distance=" + (distance_test_1 + ".." + distance_test_2)
										+ ",tag=LOTW-spelltracker,type=" + LotwModVariables.MapVariables.get(world).spell2_findkey_list
										+ "] eyes run particle lotw:ring_white ^ ^ ^" + distance_particle + " 0 0 0 0 1 force"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-spell2main] facing entity @e[distance=" + (distance_test_1 + ".." + distance_test_2)
										+ ",type=player,tag=!LOTW-ally,tag=!LOTW-user,tag=LOTW-spelltracker"
										+ "] eyes run particle lotw:dot_red ^ ^ ^" + distance_particle + " 0 0 0 0 1 force"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-spell2main] facing entity @e[distance=" + (distance_test_1 + ".." + distance_test_2)
										+ ",tag=!LOTW-ally,tag=!LOTW-user,tag=LOTW-spelltracker,type="
										+ LotwModVariables.MapVariables.get(world).spell2_findkey_list + "] eyes run particle lotw:dot_white ^ ^ ^"
										+ distance_particle + " 0 0 0 0 1 force"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-spell2main] facing entity @e[distance=" + (distance_test_1 + ".." + distance_test_2)
										+ ",tag=LOTW-ally,tag=!LOTW-user,tag=LOTW-spelltracker,type="
										+ LotwModVariables.MapVariables.get(world).spell2_findkey_list + "] eyes run particle lotw:dot_blue ^ ^ ^"
										+ distance_particle + " 0 0 0 0 1 force"));
					}
					if ((LotwModVariables.MapVariables.get(world).spell2_notification_tracker).equals("On")) {
						if (distance_test_2 <= 100) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[name=LOTW-spell2main] positioned ~ ~0.25 ~ facing entity @e[distance="
												+ (distance_test_1 + ".." + distance_test_2) + ",tag=LOTW-spelltracker,type="
												+ LotwModVariables.MapVariables.get(world).spell2_findkey_list
												+ "] eyes run particle lotw:warning ^ ^ ^" + distance_particle + " 0 0 0 0 1 force"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[name=LOTW-spell2main] positioned ~ ~0.25 ~ facing entity @e[distance="
												+ (distance_test_1 + ".." + distance_test_2) + ",tag=LOTW-spelltracker,type="
												+ LotwModVariables.MapVariables.get(world).spell2_findkey_list
												+ "] eyes run playsound minecraft:block.note_block.bell ambient @a ^ ^ ^" + distance_particle
												+ " 2 2"));
							}
						}
					}
					if ((LotwModVariables.MapVariables.get(world).spell2_notification_buoy).equals("On")) {
						if ((LotwModVariables.MapVariables.get(world).spell2_show_waypoint).equals("On")) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-spell2waypoint] at @s if entity @e["
												+ "tag=LOTW-spelltracker,distance=..20,limit=1,type="
												+ LotwModVariables.MapVariables.get(world).spell2_findkey_list
												+ "] run execute at @e[name=LOTW-spell2main] positioned ~ ~0.25 ~ facing entity @s[distance="
												+ (distance_test_1 + ".." + distance_test_2) + "] eyes run particle lotw:warning ^ ^ ^"
												+ distance_particle + " 0 0 0 0 1 force"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-spell2waypoint] at @s if entity @e["
												+ "tag=LOTW-spelltracker,distance=..20,limit=1,type="
												+ LotwModVariables.MapVariables.get(world).spell2_findkey_list
												+ "] run execute at @e[name=LOTW-spell2main] positioned ~ ~0.25 ~ facing entity @s[distance="
												+ (distance_test_1 + ".." + distance_test_2)
												+ "] eyes run playsound minecraft:block.note_block.bell ambient @a ^ ^ ^" + distance_particle
												+ " 2 0"));
							}
						}
					}
					if ((LotwModVariables.MapVariables.get(world).spell2_footstep).equals("All")
							|| (LotwModVariables.MapVariables.get(world).spell2_footstep).equals("Tracker")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-spell2main] facing entity @e[distance=" + (distance_test_1 + ".." + distance_test_2)
											+ ",tag=LOTW-spelltracker,type=" + LotwModVariables.MapVariables.get(world).spell2_findkey_list
											+ "] eyes run particle lotw:animation_dot_footstep ^ ^ ^" + distance_particle + " 0 0 0 0 1 force"));
						}
					}
				}
				if ((LotwModVariables.MapVariables.get(world).spell2_show_waypoint).equals("On")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-spell2main] facing entity @e[distance=" + (distance_test_1 + ".." + distance_test_2)
										+ ",name=LOTW-spell2waypoint" + "] eyes run particle lotw:dot_purple ^ ^ ^" + distance_particle
										+ " 0 0 0 0 1 force"));
					}
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell2_show_info).equals("On")) {
				if ((LotwModVariables.MapVariables.get(world).spell2_scanner_quarity).equals("Very Low")) {
					degree = 22.5;
					loop_set = 22.5;
				} else if ((LotwModVariables.MapVariables.get(world).spell2_scanner_quarity).equals("Low")) {
					degree = 43;
					loop_set = 45;
				} else if ((LotwModVariables.MapVariables.get(world).spell2_scanner_quarity).equals("Medium")) {
					degree = 86;
					loop_set = 90;
				} else if ((LotwModVariables.MapVariables.get(world).spell2_scanner_quarity).equals("High")) {
					degree = 172;
					loop_set = 180;
				}
				loop = 0;
				while (loop < loop_set) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-spell2main] run particle lotw:dot_orange_small_fast ~"
										+ Math.cos((((22 / 7) * 2) / degree) * loop) * distance_particle + " ~ ~"
										+ Math.sin((((22 / 7) * 2) / degree) * loop) * distance_particle + " 0 0 0 0 1 force"));
					}
					loop = (loop + 1);
				}
			}
			LotwModVariables.MapVariables.get(world).spell2_distance = (LotwModVariables.MapVariables.get(world).spell2_distance + 10);
			LotwModVariables.MapVariables.get(world).syncData(world);
			if (LotwModVariables.MapVariables.get(world).spell2_distance > speed) {
				LotwModVariables.MapVariables.get(world).spell2_distance = 0;
				LotwModVariables.MapVariables.get(world).syncData(world);
				if (!(LotwModVariables.MapVariables.get(world).spell2_scanner_quarity).equals("Off")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-placed_lantern] run playsound minecraft:block.beacon.deactivate ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025");
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] run playsound minecraft:block.beacon.ambient ambient @a[distance=..100] ~ ~ ~ 2 0.75 0.025");
				}
			}
			if ((world.isRemote()
					? Minecraft.getInstance().getConnection().getPlayerInfoMap().size()
					: ServerLifecycleHooks.getCurrentServer().getCurrentPlayerCount()) > 0) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {

						Spell2repeatFastProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 1);
			}
		}
	}
}
