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

public class Spell5repeatFASTProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell5repeatFAST!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell5repeatFAST!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell5repeatFAST!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell5repeatFAST!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_start == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_pause == false) {
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_show_trap == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=MazerTrapFly] run particle minecraft:smoke ~ ~" + (new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_height) + 15) + " ~ 0 5 0 0 5 force"));
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[type=armor_stand,name=MazerMain] positioned ~ ~ ~ run tp @e[type=armor_stand,name=Mazer1] ^ ^ ^"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius_save));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,name=MazerMain,y_rotation="
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_trap_degree
									+ "] run lotw-spell5-summon_trap"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,name=MazerMain,y_rotation="
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_degree_frequency_save
									+ "] run lotw-spell5-test_degree"));
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_gen == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=Mazer1] run fill ^ ^" + (new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_height) - 1) + " ^" + (new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_thickness) - 1) + " ^ ^ ^-"
										+ (new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_thickness) - 1)
										+ " lantern_of_the_woodlands:random_infested_block replace #minecraft:air_blocks"));
					}
				} else {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=Mazer1] run fill ^ ^" + (new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_height) - 1) + " ^" + (new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_thickness) - 1) + " ^ ^ ^-"
										+ (new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_thickness) - 1)
										+ " lantern_of_the_woodlands:maze_no_gen replace #spell_5_maze_block_tag"));
					}
				}
				if (true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=armor_stand,name=placed_lantern] facing entity @e[type=armor_stand,name=Mazer1] eyes run particle minecraft:mycelium ^ ^0.5 ^0.5 0 0 0 0 1 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[type=armor_stand,name=MazerMain] at @s run tp @s ~ ~ ~ ~"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_spin + " ~"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=MazerMain,y_rotation=" + "360" + "] run lotw-spell5-test_degree360"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("/execute at @e[name=Mazer1] run particle minecraft:large_smoke ~ ~" + (new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_height) + 10) + " ~ 0 0 0 0.05 5 force"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute as @e[type=armor_stand,name=Mazer1] at @s run tp @s ~ ~ ~ facing entity @e[type=armor_stand,name=MazerMain,limit=1]");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"scoreboard players remove @e[type=armor_stand,name=Mazer1_wall] lotw-maze 1");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=armor_stand,name=MazerMain] as @e[type=armor_stand,name=Mazer1_wall] at @s run tp @s ^ ^ ^ facing entity @e[type=armor_stand,name=MazerMain,limit=1]");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=armor_stand,name=MazerMain] as @e[type=armor_stand,name=Mazer1_wall] at @s run tp @s ^ ^ ^1 facing entity @e[type=armor_stand,name=MazerMain,limit=1]");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("/execute as @e[type=armor_stand,name=Mazer1_wall,scores={lotw-maze=..-"
										+ (new java.text.DecimalFormat("##.#").format(Math.ceil((new Object() {
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
										}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency)))).replace(".0",
												"")
										+ "}] at @s run kill @s"));
					}
				}
				if (true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=Mazer1_wall,tag=gen] run fill ^" + (new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_thickness) - 1) + " ^" + (new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_height) - 1) + " ^ ^-" + (new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_thickness) - 1)
										+ " ^ ^ lantern_of_the_woodlands:random_infested_block replace #minecraft:air_blocks"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=Mazer1_wall,tag=nogen] run fill ^" + (new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_thickness) - 1) + " ^" + (new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_height) - 1) + " ^ ^-" + (new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_thickness) - 1)
										+ " ^ ^ lantern_of_the_woodlands:maze_no_gen replace #spell_5_maze_block_tag"));
					}
				}
				if (true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute if entity @e[tag=MazerTrapFlyTarget] as @e[type=armor_stand,name=MazerTrapFly] at @s run playsound minecraft:block.conduit.ambient.short ambient @a[distance=..100] ~ ~ ~ 2 1 0.025");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute if entity @e[tag=MazerTrapFlyTarget] as @e[type=armor_stand,name=MazerTrapFly] at @s run particle minecraft:reverse_portal ^ ^2.25 ^-2 0.25 0.25 0.25 0.025 3 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute if entity @e[tag=MazerTrapFlyTarget] as @e[type=armor_stand,name=MazerTrapFly] at @s run effect give @e[distance=..2] minecraft:blindness 5 1 true");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=!armor_stand,tag=MazerTrapFlyTarget] if entity @e[type=armor_stand,name=MazerTrapFly,distance=..2] run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=!armor_stand,tag=MazerTrapFlyTarget] if entity @e[type=armor_stand,name=MazerTrapFly,distance=..2] run particle minecraft:campfire_signal_smoke ~ ~ ~ 0.25 0.25 0.25 0.01 5 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=!armor_stand,tag=MazerTrapFlyTarget] if entity @e[type=armor_stand,name=MazerTrapFly,distance=..2] run particle minecraft:flash ~ ~ ~ 0 0 0 0 1 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute if entity @e[tag=MazerTrapFlyTarget] as @e[type=armor_stand,name=MazerTrapFly] at @s run tp @s ^ ^ ^0.5 facing entity @e[tag=MazerTrapFlyTarget,limit=1,sort=nearest]");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute if entity @e[tag=MazerTrapFlyTarget] as @e[type=armor_stand,name=MazerTrapFly] at @s run tp @e[type=!armor_stand,distance=..1] @e[type=armor_stand,name=MazerTrap,limit=1,sort=furthest]");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
										"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=!armor_stand,tag=MazerTrapFlyTarget] if entity @e[type=armor_stand,name=MazerTrap,distance=..1] run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=!armor_stand,tag=MazerTrapFlyTarget] if entity @e[type=armor_stand,name=MazerTrap,distance=..1] run particle minecraft:flash ~ ~ ~ 0 0 0 0 1 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=!armor_stand,tag=MazerTrapFlyTarget] if entity @e[type=armor_stand,name=MazerTrap,distance=..1] run particle minecraft:campfire_signal_smoke ~ ~ ~ 0.25 0.25 0.25 0.01 5 force");
					}
				}
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

					Spell5entityRepeatFastProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

					Spell5repeatFASTProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 1);
		}
	}
}
