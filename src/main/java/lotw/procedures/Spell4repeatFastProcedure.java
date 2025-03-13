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

public class Spell4repeatFastProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4repeatFast!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell4repeatFast!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell4repeatFast!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell4repeatFast!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double follow_you = 0;
		if (!(LotwModVariables.MapVariables.get(world).spell4_follow_you).equals("")
				&& !(LotwModVariables.MapVariables.get(world).spell4_follow_you).equals("Off")) {
			follow_you = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(LotwModVariables.MapVariables.get(world).spell4_follow_you);
		} else {
			follow_you = 0;
		}
		if (LotwModVariables.MapVariables.get(world).spell4_start == true) {
			if (LotwModVariables.MapVariables.get(world).spell4_shoot == true) {
				if (!((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Off")
						&& (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Unselected"))) {
					Spell4tpProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

					Spell4shootProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot,limit=3,sort=random] run particle minecraft:reverse_portal ^ ^1 ^-1 0.25 0.25 0.25 0.005 1 force"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type
										+ ",limit=3,sort=random,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot] run playsound minecraft:entity.illusioner.prepare_mirror ambient @a[distance=..100] ~ ~ ~ 0.25 0 0.025"));
					}
				}
			} else {
				if (!(LotwModVariables.MapVariables.get(world).spell4_follow_you).equals("")
						&& !(LotwModVariables.MapVariables.get(world).spell4_follow_you).equals("Off")) {
					if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
							|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Sword"))
							&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type1 != 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @p[tag=LOTW-user] positioned ~ ~1.5 ~ run tp @e[tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit,distance=.."
											+ follow_you + ",limit=1,sort=nearest] ^-0.25 ^ ^1.25"));
						}
					}
					if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
							|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Shield"))
							&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type2 != 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @p[tag=LOTW-user] positioned ~ ~1.5 ~ run tp @e[tag=LOTW-weapon_manipulation_type2,tag=!LOTW-weapon_manipulation_hit,distance=.."
											+ follow_you + ",limit=1,sort=nearest] ^0.75 ^-1.5 ^2.25"));
						}
					}
					if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
							|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Lantern"))
							&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type3 != 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @p[tag=LOTW-user] positioned ~ ~1.5 ~ run tp @e[tag=LOTW-weapon_manipulation_type3,distance=.."
											+ follow_you + ",limit=1,sort=nearest] ^1 ^-1 ^1"));
						}
					}
					if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
							|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Bow"))
							&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type4 != 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @p[tag=LOTW-user] positioned ~ ~1.5 ~ run tp @e[tag=LOTW-weapon_manipulation_type4,distance=.."
											+ follow_you + ",limit=1,sort=nearest] ^-1.5 ^-0.75 ^1"));
						}
					}
					if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
							|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Beehive"))
							&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type5 != 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @p[tag=LOTW-user] positioned ~ ~1.5 ~ run tp @e[tag=LOTW-weapon_manipulation_type5,distance=.."
											+ follow_you + ",limit=1,sort=nearest] ^1 ^-1 ^-0.5"));
						}
					}
				}
			}
			if (!(LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Off")
					&& !(LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Unselected")) {
				if ((LotwModVariables.MapVariables.get(world).spell4_reverse).equals("Off")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit] at @s run tp @s ^ ^ ^ facing entity @e[name=LOTW-weapon_manipulation_target,limit=1]"));
					}
				} else if ((LotwModVariables.MapVariables.get(world).spell4_reverse).equals("On")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit] at @s facing entity @e[name=LOTW-weapon_manipulation_target,limit=1] feet run tp @s ^ ^ ^ facing ^ ^ ^-10"));
					}
				}
			}
			if ((LotwModVariables.MapVariables.get(world).spell4_pause_around_lantern).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] run tp @e[name=LOTW-weapon_manipulation_center] ~ ~ ~");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute unless entity @e[name=LOTW-placed_lantern] at @p[tag=LOTW-user] run tp @e[name=LOTW-weapon_manipulation_center] ~ ~ ~");
				}
			} else if ((LotwModVariables.MapVariables.get(world).spell4_pause_around_lantern).equals("Off")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @p[tag=LOTW-user] run tp @e[name=LOTW-weapon_manipulation_center] ~ ~ ~");
				}
			}
			if (LotwModVariables.MapVariables.get(world).spell4_tick_fly_up_down < 120) {
				if (LotwModVariables.MapVariables.get(world).spell4_tick_fly_up_down < 60) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-weapon_manipulation,tag=!LOTW-weapon_manipulation_hit,limit=1,sort=random] at @s if block ~ ~2 ~ #minecraft:air_blocks run tp @s ~ ~0.01 ~");
					}
				} else {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-weapon_manipulation,tag=!LOTW-weapon_manipulation_hit,limit=1,sort=random] at @s if block ~ ~-0.1 ~ #minecraft:air_blocks run tp @s ~ ~-0.01 ~");
					}
				}
				LotwModVariables.MapVariables.get(world).spell4_tick_fly_up_down = (LotwModVariables.MapVariables.get(world).spell4_tick_fly_up_down
						+ 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).spell4_tick_fly_up_down = 0;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if (!("Near Weapon").equals("")) {
				if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Off")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-weapon_manipulation,tag=!LOTW-weapon_manipulation_hit] at @s if entity @e[name=LOTW-weapon_manipulation,tag=!LOTW-weapon_manipulation_hit,distance=0.01..] facing entity @e[name=LOTW-weapon_manipulation,tag=!LOTW-weapon_manipulation_hit,distance=0.01..,limit=1,sort=nearest] feet run tp @s ^ ^ ^-0.02");
					}
				} else {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-weapon_manipulation,tag=!LOTW-weapon_manipulation_hit] at @s if entity @e[name=LOTW-weapon_manipulation,tag=!LOTW-weapon_manipulation_hit,distance=0.01..1] facing entity @e[name=LOTW-weapon_manipulation,tag=!LOTW-weapon_manipulation_hit,distance=0.01..,limit=1,sort=nearest] feet run tp @s ^ ^ ^-0.1");
					}
				}
			}
			if (!("Target").equals("")) {
				if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Off")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-weapon_manipulation_target1] at @s run data merge entity @s {ArmorItems:[{},{},{},{id:\"\",Count:1b}]}");
					}
				} else if (!(LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Off")) {
					if (LotwModVariables.MapVariables.get(world).spell4_distance_set != 0) {
						Spell4distanceProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
								(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
					if ((LotwModVariables.MapVariables.get(world).spell4_arrow).equals("On")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-weapon_manipulation_target1] at @s run data merge entity @s {ArmorItems:[{},{},{},{id:\"lotw:target\",Count:1b}]}");
						}
					} else if ((LotwModVariables.MapVariables.get(world).spell4_arrow).equals("Off")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-weapon_manipulation_target1] at @s run data merge entity @s {ArmorItems:[{},{},{},{id:\"\",Count:1b}]}");
						}
					}
					if ((LotwModVariables.MapVariables.get(world).spell4_target_lock).equals("Off")) {
						if ((LotwModVariables.MapVariables.get(world).spell4_arrow).equals("On")) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"/execute at @e[name=LOTW-weapon_manipulation_target] positioned ~ ~-1.625 ~ unless entity @p[tag=LOTW-user,distance=..0.5] positioned ~ ~0.115 ~ positioned ^ ^ ^-0.2 run tp @e[name=LOTW-weapon_manipulation_target1] ^ ^-0.05 ^ facing entity @p[tag=LOTW-user]");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] positioned ~ ~-1.625 ~ if entity @p[tag=LOTW-user,distance=..0.5] run tp @e[name=LOTW-weapon_manipulation_target1] ~ ~1.75 ~ ~ ~");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] positioned ~ ~-1.625 ~ if entity @p[tag=LOTW-user,distance=..0.5] as @e[name=LOTW-weapon_manipulation_target1] at @s run tp @s ~ ~ ~ ~-3 ~");
							}
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @p[tag=LOTW-user] positioned ~ ~1.625 ~ run tp @e[name=LOTW-weapon_manipulation_target] ^ ^ ^"
											+ LotwModVariables.MapVariables.get(world).spell4_distance));
						}
					} else if ((LotwModVariables.MapVariables.get(world).spell4_target_lock).equals("On")) {
						if ((LotwModVariables.MapVariables.get(world).spell4_arrow).equals("On")) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] unless entity @e[tag=LOTW-weapon_manipulation_target] run tp @e[name=LOTW-weapon_manipulation_target1] ~ ~-1.5 ~");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] if entity @e[tag=LOTW-weapon_manipulation_target] run tp @e[name=LOTW-weapon_manipulation_target1] ~ ~2.5 ~");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[name=LOTW-weapon_manipulation_target1] at @s run tp @s ~ ~ ~ ~-3 ~");
							}
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-weapon_manipulation_target] at @s run tp @e[name=LOTW-weapon_manipulation_target] @s");
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-weapon_manipulation_target] at @s run tp @s ~ ~ ~ facing entity @p[tag=LOTW-user]");
					}
				}
			}
			if (!("Fly Around").equals("")) {
				if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Off")) {
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-weapon_manipulation_center] as @e[tag=LOTW-weapon_manipulation_type1] at @s run data merge entity @s {Pose:{RightArm:[-100f,90f,0f]}}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-weapon_manipulation_center] as @e[tag=LOTW-weapon_manipulation_type2] at @s run data merge entity @s {Pose:{RightArm:[-90f,90f,180f]}}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-weapon_manipulation_center] as @e[tag=LOTW-weapon_manipulation_type4] at @s run data merge entity @s {Pose:{LeftArm:[-100f,90f,0f]}}");
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-weapon_manipulation] at @s unless block ~ ~0.3 ~ #minecraft:air_blocks run tp @s ^ ^0.1 ^");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-weapon_manipulation] at @s unless block ~ ~2 ~ #minecraft:air_blocks run tp @s ^ ^-0.1 ^");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-weapon_manipulation_center] as @e[name=LOTW-weapon_manipulation,distance="
										+ (LotwModVariables.MapVariables.get(world).spell4_pause_size - 1) + ".."
										+ (LotwModVariables.MapVariables.get(world).spell4_pause_size + 1) + "] at @s run tp @s ^0.05 ^ ^"));
					}
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-weapon_manipulation] at @s run tp @s ^ ^ ^1 facing entity @e[name=LOTW-weapon_manipulation_center,limit=1,distance="
											+ (LotwModVariables.MapVariables.get(world).spell4_pause_size + 1) + "..]"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-weapon_manipulation] at @s run tp @s ^ ^ ^0.02 facing entity @e[name=LOTW-weapon_manipulation_center,limit=1,distance="
											+ LotwModVariables.MapVariables.get(world).spell4_pause_size + ".."
											+ (LotwModVariables.MapVariables.get(world).spell4_pause_size + 1) + "]"));
						}
					}
					if ((LotwModVariables.MapVariables.get(world).spell4_pause_free_flying).equals("Off")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-weapon_manipulation] at @s run tp @s ^ ^ ^-1 facing entity @e[name=LOTW-weapon_manipulation_center,limit=1,distance=.."
											+ (LotwModVariables.MapVariables.get(world).spell4_pause_size - 1) + "]"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-weapon_manipulation] at @s run tp @s ^ ^ ^-0.02 facing entity @e[name=LOTW-weapon_manipulation_center,limit=1,distance="
											+ (LotwModVariables.MapVariables.get(world).spell4_pause_size - 1) + ".."
											+ LotwModVariables.MapVariables.get(world).spell4_pause_size + "]"));
						}
					}
					if ((LotwModVariables.MapVariables.get(world).spell4_pause_gravity).equals("On")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-weapon_manipulation] at @s if block ~ ~0.1 ~ #minecraft:air_blocks run tp @s ~ ~-0.05 ~");
						}
					}
				}
				if (!(LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Off")) {
					Spell4poseProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}
			Spell4effectProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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

						Spell4repeatFastProcedure.executeProcedure(Stream
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
