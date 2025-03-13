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
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell3buildingSTARTProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell3buildingSTART!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell3buildingSTART!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell3buildingSTART!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell3buildingSTART!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency entity for procedure Spell3buildingSTART!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_start == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_pause == false) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[type=armor_stand,name=dome-main,x_rotation=-90] at @s run tp @s ~ ~ ~ ~"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_up_dawn + " 90"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[type=armor_stand,name=dome-main] at @s run tp @s ~ ~ ~ ~ ~"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_left_right));
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time > 0) {
					LanternOfTheWoodlandsModVariables.MapVariables
							.get(world).spell3_time = (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time - 0.05);
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_particle == true) {
					if (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert) >= 10) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=dome-main] positioned ~ ~3.25 ~ run particle minecraft:end_rod ^ ^ ^3 0 0 0 0 1 force");
						}
					} else {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=dome-main] positioned ~ ~ ~ run particle minecraft:end_rod ^ ^ ^3 0 0 0 0 1 force");
						}
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_dome_particle == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=dome-main] positioned ~ ~ ~ run particle minecraft:soul_fire_flame ^ ^ ^"
										+ (new java.text.DecimalFormat("##.#").format(new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert) - 1.5)).replace(".0", "")
										+ " 0 0 0 0 1 force"));
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_block_arrow == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=dome-main,limit=1] run execute at @e[type=arrow,distance=.."
										+ (new java.text.DecimalFormat("##.#").format(new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert))).replace(".0", "")
										+ "] run particle minecraft:firework ~ ~ ~ 0 0 0 0.1 5 force"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=dome-main,limit=1] run execute at @e[type=arrow,distance=.."
										+ (new java.text.DecimalFormat("##.#").format(new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert))).replace(".0", "")
										+ "] run playsound minecraft:entity.illusioner.mirror_move ambient @a ~ ~ ~ 0.5 1"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=dome-main,limit=1] run kill @e[type=arrow,distance=.."
										+ (new java.text.DecimalFormat("##.#").format(new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert))).replace(".0", "")
										+ "]"));
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_block_damage == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=dome-main,limit=1] run effect give @e[tag=!wsupport,distance=.."
										+ (new java.text.DecimalFormat("##.#").format(new Object() {
											double convert(String s) {
												try {
													return Double.parseDouble(s.trim());
												} catch (Exception e) {
												}
												return 0;
											}
										}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert))).replace(".0", "")
										+ "] minecraft:weakness 1 100 true"));
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_gen == true) {
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_no_block == true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[type=armor_stand,name=dome-main] run fill ^ ^ ^"
											+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert + " ^ ^ ^"
											+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert
											+ " minecraft:air replace minecraft:barrier"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[type=armor_stand,name=dome-main] run fill ^ ^ ^"
											+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert + " ^ ^ ^"
											+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert
											+ " minecraft:air replace minecraft:white_stained_glass"));
						}
					} else {
						if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_invisible_dome == true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[type=armor_stand,name=dome-main] run fill ^ ^ ^"
												+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert + " ^ ^ ^"
												+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert
												+ " minecraft:barrier keep"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[type=armor_stand,name=dome-main] run fill ^ ^ ^"
												+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert + " ^ ^ ^"
												+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert
												+ " minecraft:barrier replace minecraft:white_stained_glass"));
							}
						} else {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[type=armor_stand,name=dome-main] run fill ^ ^ ^"
												+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert + " ^ ^ ^"
												+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert
												+ " minecraft:white_stained_glass replace minecraft:barrier"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[type=armor_stand,name=dome-main] run fill ^ ^ ^"
												+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert + " ^ ^ ^"
												+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert
												+ " minecraft:white_stained_glass keep"));
							}
						}
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time > 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=dome-main,limit=1] positioned ~ ~0.75 ~ run particle lantern_of_the_woodlands:particle_fireball_gold ^ ^ ^ 0 0 0 0 1 force");
						}
					} else {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=armor_stand,name=dome-main,limit=1] positioned ~ ~0.75 ~ run particle lantern_of_the_woodlands:particle_fireball_green ^ ^ ^ 0 0 0 0 1 force");
						}
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_gen == false) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=dome-main] run fill ^ ^ ^"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert + " ^ ^ ^"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert
										+ " air replace lantern_of_the_woodlands:invisible_block"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=dome-main] run fill ^ ^ ^"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert + " ^ ^ ^"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert
										+ " air replace minecraft:barrier"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=armor_stand,name=dome-main] run fill ^ ^ ^"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert + " ^ ^ ^"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert
										+ " air replace minecraft:white_stained_glass"));
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time <= 0) {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time = 0;
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_start = (false);
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
						if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_cancel == true) {
							Spell3cancelProcedure.executeProcedure(Stream
									.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
											new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
											new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[type=armor_stand,name=dome-main,limit=1] positioned ~ ~0.75 ~ run particle lantern_of_the_woodlands:particle_fireball_red ^ ^ ^ 0 0 0 0 1 force");
					}
				}
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_walk == true) {
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_invisible_dome == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[tag=wsupport] run fill ~5 ~6 ~5 ~-5 ~-5 ~-5 minecraft:barrier replace lantern_of_the_woodlands:invisible_block");
					}
				} else {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[tag=wsupport] run fill ~5 ~6 ~5 ~-5 ~-5 ~-5 minecraft:white_stained_glass replace lantern_of_the_woodlands:invisible_block");
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[tag=wsupport] run fill ~1 ~2 ~1 ~-1 ~-1 ~-1 lantern_of_the_woodlands:invisible_block replace minecraft:white_stained_glass");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[tag=wsupport] run fill ~1 ~2 ~1 ~-1 ~-1 ~-1 lantern_of_the_woodlands:invisible_block replace minecraft:barrier");
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
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_start == true) {
						Spell3buildingSTARTProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
										new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 1);
		}
	}
}
