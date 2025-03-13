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

public class Spell5runTestDegreeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell5runTestDegree!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell5runTestDegree!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell5runTestDegree!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell5runTestDegree!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		LotwModVariables.MapVariables.get(world).spell5_degree_frequency_save = (LotwModVariables.MapVariables.get(world).spell5_degree_frequency_save
				+ new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(LotwModVariables.MapVariables.get(world).spell5_degree_frequency));
		LotwModVariables.MapVariables.get(world).syncData(world);
		if (LotwModVariables.MapVariables.get(world).spell5_remove == false) {
			if (LotwModVariables.MapVariables.get(world).spell5_safe_zone_360 > 0) {
				if (Math.random() <= new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(LotwModVariables.MapVariables.get(world).spell5_room) / 100) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[type=armor_stand,name=Mazer1,sort=random] run summon armor_stand ~ ~ ~ {Invisible:1b,Marker:1b,NoGravity:1b,CustomName:'{\"text\":\"Mazer1_wall\"}',Tags:[\"extra\",\"gen\"]}");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=Mazer1] run playsound minecraft:block.ender_chest.close ambient @a[distance=..100] ~ ~"
										+ new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(LotwModVariables.MapVariables.get(world).spell5_height) / 2 + " ~ 2 0 0.025"));
					}
				} else {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[type=armor_stand,name=Mazer1,sort=random] run summon armor_stand ~ ~ ~ {Invisible:1b,Marker:1b,NoGravity:1b,CustomName:'{\"text\":\"Mazer1_wall\"}',Tags:[\"extra\",\"nogen\"]}");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=Mazer1] run playsound minecraft:block.ender_chest.open ambient @a[distance=..100] ~ ~"
										+ new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(LotwModVariables.MapVariables.get(world).spell5_height) / 2 + " ~ 2 0 0.025"));
					}
				}
			}
			if (Math.random() <= new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(LotwModVariables.MapVariables.get(world).spell5_no_wall) / 100) {
				if (LotwModVariables.MapVariables.get(world).spell5_gen == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=Mazer1] run playsound minecraft:block.ender_chest.open ambient @a[distance=..100] ~ ~"
										+ new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(LotwModVariables.MapVariables.get(world).spell5_height) / 2 + " ~ 2 0 0.025"));
					}
				}
				LotwModVariables.MapVariables.get(world).spell5_gen = (false);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				if (LotwModVariables.MapVariables.get(world).spell5_gen == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=Mazer1] run playsound minecraft:block.ender_chest.close ambient @a[distance=..100] ~ ~"
										+ new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(LotwModVariables.MapVariables.get(world).spell5_height) / 2 + " ~ 2 00.025"));
					}
				}
				LotwModVariables.MapVariables.get(world).spell5_gen = (true);
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=Mazer1,sort=random] run summon armor_stand ~ ~ ~ {Invisible:1b,Marker:1b,NoGravity:1b,CustomName:'{\"text\":\"Mazer1_wall\"}',Tags:[\"extra\",\"nogen\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[type=armor_stand,name=Mazer1] run playsound minecraft:block.ender_chest.open ambient @a[distance=..100] ~ ~"
								+ new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(LotwModVariables.MapVariables.get(world).spell5_height) / 2 + " ~ 2 0 0.025"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[type=armor_stand,name=Mazer1] run scoreboard players set @e[type=armor_stand,name=Mazer1_wall,distance=..1,limit=1] lotw-maze "
								+ Math.ceil((new Object() {
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
								}.convert(LotwModVariables.MapVariables.get(world).spell5_circle_frequency))));
			}
		}
	}
}
