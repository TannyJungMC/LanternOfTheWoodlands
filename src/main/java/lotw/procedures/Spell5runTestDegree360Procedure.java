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

public class Spell5runTestDegree360Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell5runTestDegree360!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell5runTestDegree360!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell5runTestDegree360!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell5runTestDegree360!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (LotwModVariables.MapVariables.get(world).spell5_safe_zone_360 > 0) {
			LotwModVariables.MapVariables.get(world).spell5_safe_zone_360 = (LotwModVariables.MapVariables.get(world).spell5_safe_zone_360 - 1);
			LotwModVariables.MapVariables.get(world).syncData(world);
			Spell5setSpinSpeedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			LotwModVariables.MapVariables.get(world).spell5_degree_frequency_save = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(LotwModVariables.MapVariables.get(world).spell5_degree_frequency);
			LotwModVariables.MapVariables.get(world).syncData(world);
			LotwModVariables.MapVariables.get(world).spell5_radius_save = (LotwModVariables.MapVariables.get(world).spell5_radius_save
					- (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(LotwModVariables.MapVariables.get(world).spell5_radius) - new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(LotwModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(LotwModVariables.MapVariables.get(world).spell5_circle_frequency));
			LotwModVariables.MapVariables.get(world).syncData(world);
			LotwModVariables.MapVariables.get(world).spell5_trap_degree = Math.ceil(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(LotwModVariables.MapVariables.get(world).spell5_degree_frequency) / 2);
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else {
			if (LotwModVariables.MapVariables.get(world).spell5_remove) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/kill @e[type=armor_stand,name=Mazer1]");
				}
			} else {
				if (LotwModVariables.MapVariables.get(world).spell5_always_gen) {
					Spell5setSAVEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"kill @e[type=armor_stand,name=MazerMain]");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"kill @e[type=armor_stand,name=Mazer1]");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"kill @e[type=armor_stand,name=Mazer1_wall]");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("/execute at @e[type=armor_stand,name=placed_lantern] run summon armor_stand ~ ~-"
										+ LotwModVariables.MapVariables.get(world).spell5_down
										+ " ~ {Invisible:1b,Marker:1b,NoGravity:1b,CustomName:'{\"text\":\"MazerMain\"}'}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[type=armor_stand,name=MazerMain] run summon armor_stand ~ ~ ~ {Invisible:1b,Marker:1b,NoGravity:1b,CustomName:'{\"text\":\"Mazer1\"}'}");
					}
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute as @e[type=armor_stand,name=MazerTrapFly] at @s run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=MazerTrapFly] run particle minecraft:reverse_portal ~ ~2.25 ~ 0.25 0.25 0.25 0.01 20 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run kill @e[type=armor_stand,name=MazerTrapFly]");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=MazerTrap,sort=random,limit=1] run summon armor_stand ~ ~1 ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"MazerTrapFly\"}',Pose:{Head:[0f,0f,0f]}}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute as @e[type=armor_stand,name=MazerTrapFly] at @s run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=MazerTrapFly] run particle minecraft:reverse_portal ~ ~2.25 ~ 0.25 0.25 0.25 0.01 20 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
											4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=lotw-mazer_entity] run particle minecraft:flash ~ ~1 ~ 0 0 0 0 1 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=lotw-mazer_entity] run playsound minecraft:entity.enderman.teleport ambient @a[distance=..50] ~ ~ ~ 1 0 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run kill @e[type=armor_stand,name=lotw-mazer_entity]");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=MazerTrap,limit="
											+ (new java.text.DecimalFormat("##.#").format(Math.ceil(new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert(LotwModVariables.MapVariables.get(world).spell5_circle_frequency) * 2))).replace(".0", "")
											+ ",sort=random] run summon armor_stand ~ ~-1 ~ {NoGravity:1b,Marker:1b,Invisible:0b,CustomName:'{\"text\":\"lotw-mazer_entity\"}',ShowArms:1b,NoBasePlate:1b}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=lotw-mazer_entity] run particle minecraft:flash ~ ~1 ~ 0 0 0 0 1 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=lotw-mazer_entity] run playsound minecraft:entity.enderman.teleport ambient @a[distance=..50] ~ ~ ~ 1 0 0.025");
						}
					}
				} else {
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute as @e[type=armor_stand,name=MazerTrapFly] at @s run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=MazerTrapFly] run particle minecraft:reverse_portal ~ ~2.25 ~ 0.25 0.25 0.25 0.01 20 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run kill @e[type=armor_stand,name=MazerTrapFly]");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=MazerTrap,sort=random,limit=1] run summon armor_stand ~ ~1 ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"MazerTrapFly\"}',Pose:{Head:[0f,0f,0f]}}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute as @e[type=armor_stand,name=MazerTrapFly] at @s run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=MazerTrapFly] run particle minecraft:reverse_portal ~ ~2.25 ~ 0.25 0.25 0.25 0.01 20 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
											4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=lotw-mazer_entity] run particle minecraft:flash ~ ~1 ~ 0 0 0 0 1 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=lotw-mazer_entity] run playsound minecraft:entity.enderman.teleport ambient @a[distance=..50] ~ ~ ~ 1 0 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run kill @e[type=armor_stand,name=lotw-mazer_entity]");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=MazerTrap,limit="
											+ (new java.text.DecimalFormat("##.#").format(Math.ceil(new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert(LotwModVariables.MapVariables.get(world).spell5_circle_frequency) * 2))).replace(".0", "")
											+ ",sort=random] run summon armor_stand ~ ~-1 ~ {NoGravity:1b,Marker:1b,Invisible:0b,CustomName:'{\"text\":\"lotw-mazer_entity\"}',ShowArms:1b,NoBasePlate:1b}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=lotw-mazer_entity] run particle minecraft:flash ~ ~1 ~ 0 0 0 0 1 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=Mazer1] run execute at @e[type=armor_stand,name=lotw-mazer_entity] run playsound minecraft:entity.enderman.teleport ambient @a[distance=..50] ~ ~ ~ 1 0 0.025");
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/kill @e[type=armor_stand,name=Mazer1]");
					}
				}
			}
		}
	}
}
