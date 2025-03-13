package lantern_of_the_woodlands.procedures;

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

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell5repeatSLOWProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell5repeatSLOW!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell5repeatSLOW!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell5repeatSLOW!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell5repeatSLOW!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		String target = "";
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_pause == false) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=placed_lantern] run playsound minecraft:block.conduit.ambient ambient @a[distance=..100] ~ ~ ~ 2 1 0.025");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute at @e[type=armor_stand,name=MazerTrapFly] run particle minecraft:soul ~ ~2.25 ~ 0.5 0.5 0.5 0.01 1 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute at @e[type=armor_stand,name=MazerTrapFly] run particle minecraft:portal ~ ~2.25 ~ 0 0 0 0.5 5 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute as @e[type=armor_stand,name=MazerTrapFly] at @s run playsound minecraft:block.bubble_column.whirlpool_ambient ambient @a[distance=..100] ~ ~ ~ 1 0 0.025");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"tag @e remove MazerTrapFlyTarget");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute as @e[type=!armor_stand,type=!silverfish,tag=!wsupport] at @s if block ~ ~-1 ~ infested_stone_bricks run tag @s add MazerTrapFlyTarget");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute as @e[type=!armor_stand,type=!silverfish,tag=!wsupport] at @s if block ~ ~-1 ~ infested_mossy_stone_bricks run tag @s add MazerTrapFlyTarget");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute as @e[type=!armor_stand,type=!silverfish,tag=!wsupport] at @s if block ~ ~-1 ~ infested_cracked_stone_bricks run tag @s add MazerTrapFlyTarget");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute as @e[type=!armor_stand,type=!silverfish,tag=!wsupport] at @s if block ~ ~2 ~ infested_stone_bricks run tag @s add MazerTrapFlyTarget");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute as @e[type=!armor_stand,type=!silverfish,tag=!wsupport] at @s if block ~ ~2 ~ infested_mossy_stone_bricks run tag @s add MazerTrapFlyTarget");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute as @e[type=!armor_stand,type=!silverfish,tag=!wsupport] at @s if block ~ ~2 ~ infested_cracked_stone_bricks run tag @s add MazerTrapFlyTarget");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"data merge entity @e[type=armor_stand,name=MazerTrapFly,sort=random,limit=1] {ArmorItems:[{},{},{},{id:\"ender_pearl\",Count:1b}]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute if entity @e[tag=MazerTrapFlyTarget] run data merge entity @e[type=armor_stand,name=MazerTrapFly,sort=random,limit=1] {ArmorItems:[{},{},{},{id:\"ender_eye\",Count:1b}]}");
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_show_trap) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=MazerTrap] run particle lantern_of_the_woodlands:particle_specify_circle_2 ~ ~ ~ 0 0 0 0 1 force @a[tag=wsupport]");
				}
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
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=MazerTrap] run particle lantern_of_the_woodlands:particle_specify_circle_2 ~ ~ ~ 0 0 0 0 1 force @a[tag=wsupport]");
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 20);
			}
			target = ("type=!armor_stand,type=!item,type=!silverfish,tag=!wsupport"
					+ (",type=!evoker_fangs" + ",type=!lightning_bolt" + ",type=!arrow" + ",type=!trident" + ",type=!spectral_arrow")
					+ ",distance=..");
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "fang] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run summon evoker_fangs ~ ~ ~"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "fang] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run particle minecraft:campfire_cosy_smoke ~ ~ ~ 0.5 0.25 0.5 0.01 10 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "fang] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run playsound minecraft:block.conduit.deactivate ambient @a[distance=..100] ~ ~ ~ 2 0 0.025"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager()
							.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "lightning] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run summon lightning_bolt ~ ~ ~"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager()
							.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "arrow] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run summon arrow ~ ~10 ~ {Motion:[0.0,-1.0,0.0]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "arrow] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run playsound minecraft:entity.illusioner.mirror_move ambient @a[distance=..100] ~ ~10 ~ 2 0.75 0.025"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "arrow] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run particle minecraft:instant_effect ~ ~10 ~ 0.25 0.25 0.25 0.5 10 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager()
							.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "wither_effect] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run effect give @e[type=!armor_stand,distance=..1] wither 5 2 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "wither_effect] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run playsound minecraft:entity.illusioner.prepare_mirror ambient @a[distance=..100] ~ ~10 ~ 2 0.75 0.025"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "wither_effect] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run particle minecraft:large_smoke ~ ~0.5 ~ 0.5 0.5 0.5 0.01 20 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager()
							.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "spectral_arrow] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run summon spectral_arrow ~ ~10 ~ {Motion:[0.0,-1.0,0.0]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "spectral_arrow] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run playsound minecraft:entity.illusioner.mirror_move ambient @a[distance=..100] ~ ~10 ~ 2 0.75 0.025"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "spectral_arrow] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run particle minecraft:instant_effect ~ ~10 ~ 0.25 0.25 0.25 0.5 10 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager()
							.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "trident] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run summon trident ~ ~10 ~ {Motion:[0.0,-1.0,0.0]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "trident] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run playsound minecraft:entity.illusioner.mirror_move ambient @a[distance=..100] ~ ~10 ~ 2 0.75 0.025"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,tag=MazerTrap-" + "trident] at @e[" + target + ((new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) - new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone)) / new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2
									+ "] run particle minecraft:instant_effect ~ ~10 ~ 0.25 0.25 0.25 0.5 10 force"));
				}
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"tag @e remove lotw-mazer_entity_target");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[type=armor_stand,name=placed_lantern] run tag @e[" + target
								+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius + "] add lotw-mazer_entity_target"));
			}
			Spell5entityRepeatSlowProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
