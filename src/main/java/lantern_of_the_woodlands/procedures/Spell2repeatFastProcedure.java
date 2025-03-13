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

public class Spell2repeatFastProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell2repeatFast!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell2repeatFast!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell2repeatFast!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell2repeatFast!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_start_repeat == true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute at @e[type=armor_stand,name=spell2waypoint] run particle lantern_of_the_woodlands:particle_fireball_purple ~ ~ ~ 0 0 0 0 1 force");
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_all == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] run particle lantern_of_the_woodlands:particle_fireball_gold ~ ~ ~ 0 0 0 0 1");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] run particle minecraft:totem_of_undying ~ ~75 ~ 0 20 0 0 5 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute as @e[type=armor_stand,name=lighthouse] at @s run tp @s ~ ~ ~ ~2 0");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle lantern_of_the_woodlands:particle_yellow_dot ^0.5 ^-99.75 ^ 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle lantern_of_the_woodlands:particle_yellow_dot ^-0.5 ^-99.75 ^ 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle lantern_of_the_woodlands:particle_yellow_dot ^ ^-99.75 ^0.5 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle lantern_of_the_woodlands:particle_yellow_dot ^ ^-99.75 ^-0.5 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle lantern_of_the_woodlands:particle_yellow_dot ^ ^-99.75 ^-2.5 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle lantern_of_the_woodlands:particle_yellow_dot ^ ^-99.75 ^2.5 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle lantern_of_the_woodlands:particle_yellow_dot ^2.5 ^-99.75 ^ 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle lantern_of_the_woodlands:particle_yellow_dot ^-2.5 ^-99.75 ^ 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle lantern_of_the_woodlands:particle_yellow_dot ^-1.5 ^-99.75 ^ 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle lantern_of_the_woodlands:particle_yellow_dot ^1.5 ^-99.75 ^ 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle lantern_of_the_woodlands:particle_yellow_dot ^ ^-99.75 ^1.5 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle lantern_of_the_woodlands:particle_yellow_dot ^ ^-99.75 ^-1.5 0 0 0 0 1 force");
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
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^ ^ ^10 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^ ^ ^-10 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^10 ^ ^ 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^-10 ^ ^ 0 0 0 0 1 force");
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
							"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] run particle lantern_of_the_woodlands:particle_yellow_dot ~ ~ ~ 1 0 0 0 3");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] run particle lantern_of_the_woodlands:particle_yellow_dot ~ ~ ~ 0 0 1 0 3");
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
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^ ^ ^ 250 0 0 0 30 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^ ^ ^ 0 0 250 0 30 force");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 0) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^ ^ ^100 0 0 0 0 1 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^ ^ ^-100 0 0 0 0 1 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^100 ^ ^ 0 0 0 0 1 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^-100 ^ ^ 0 0 0 0 1 force");
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 1) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^ ^ ^500 0 0 0 0 1 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^ ^ ^-500 0 0 0 0 1 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^500 ^ ^ 0 0 0 0 1 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=lighthouse] run particle minecraft:end_rod ^-500 ^ ^ 0 0 0 0 1 force");
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_entity == true) {
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=!armor_stand,type=!item,type=!player,tag=!wsupport,tag=!woodlands,tag=spell2findkey,distance=10..100] eyes run particle lantern_of_the_woodlands:small_fireball_particle ^ ^ ^0.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=!armor_stand,type=!item,type=!player,tag=wsupport,tag=!woodlands,tag=spell2findkey,distance=10..100] eyes run particle lantern_of_the_woodlands:particle_fireball_blue ^ ^ ^0.5 0 0 0 0 1");
						}
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 1) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=!armor_stand,type=!item,type=!player,tag=!wsupport,tag=!woodlands,tag=spell2findkey,distance=101..500] eyes run particle lantern_of_the_woodlands:small_fireball_particle ^ ^ ^1.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=!armor_stand,type=!item,type=!player,tag=wsupport,tag=!woodlands,tag=spell2findkey,distance=101..500] eyes run particle lantern_of_the_woodlands:particle_fireball_blue ^ ^ ^1.5 0 0 0 0 1");
						}
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 2) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=!armor_stand,type=!item,type=!player,tag=!wsupport,tag=!woodlands,tag=spell2findkey,distance=501..1000] eyes run particle lantern_of_the_woodlands:small_fireball_particle ^ ^ ^2.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=!armor_stand,type=!item,type=!player,tag=wsupport,tag=!woodlands,tag=spell2findkey,distance=501..1000] eyes run particle lantern_of_the_woodlands:particle_fireball_blue ^ ^ ^2.5 0 0 0 0 1");
						}
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_player == true) {
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=player,tag=!wsupport,tag=!woodlands,distance=10..100] eyes run particle lantern_of_the_woodlands:particle_fireball_red ^ ^ ^0.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=player,tag=wsupport,tag=!woodlands,distance=10..100] eyes run particle lantern_of_the_woodlands:particle_fireball_blue ^ ^ ^0.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=player,tag=wsupport,tag=woodlands,distance=10..100] eyes run particle lantern_of_the_woodlands:particle_fireball_green ^ ^ ^0.5 0 0 0 0 1");
						}
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 1) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=player,tag=!wsupport,tag=!woodlands,distance=101..500] eyes run particle lantern_of_the_woodlands:particle_fireball_red ^ ^ ^1.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=player,tag=wsupport,tag=!woodlands,distance=101..500] eyes run particle lantern_of_the_woodlands:particle_fireball_blue ^ ^ ^1.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=player,tag=wsupport,tag=woodlands,distance=101..500] eyes run particle lantern_of_the_woodlands:particle_fireball_green ^ ^ ^1.5 0 0 0 0 1");
						}
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 2) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=player,tag=!wsupport,tag=!woodlands,distance=501..1000] eyes run particle lantern_of_the_woodlands:particle_fireball_red ^ ^ ^2.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=player,tag=wsupport,tag=!woodlands,distance=501..1000] eyes run particle lantern_of_the_woodlands:particle_fireball_blue ^ ^ ^2.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=player,tag=wsupport,tag=woodlands,distance=501..1000] eyes run particle lantern_of_the_woodlands:particle_fireball_green ^ ^ ^2.5 0 0 0 0 1");
						}
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_tracker == true) {
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=player,tag=!wsupport,tag=spelltracker,distance=10..100] eyes run particle lantern_of_the_woodlands:particle_fireball_red ^ ^ ^0.5 0 0 0 0 1");
						}
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 1) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=player,tag=!wsupport,tag=spelltracker,distance=101..500] eyes run particle lantern_of_the_woodlands:particle_fireball_red ^ ^ ^1.5 0 0 0 0 1");
						}
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 2) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=player,tag=!wsupport,tag=spelltracker,distance=501..1000] eyes run particle lantern_of_the_woodlands:particle_fireball_red ^ ^ ^2.5 0 0 0 0 1");
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
										"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[tag=spelltracker,distance=10..100] eyes run particle lantern_of_the_woodlands:particle_specify_circle ^ ^ ^0.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[tag=wsupport,tag=spelltracker,distance=10..100] eyes run particle lantern_of_the_woodlands:particle_fireball_blue ^ ^ ^0.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=!player,type=!item,tag=!wsupport,tag=spelltracker,distance=10..100] eyes run particle lantern_of_the_woodlands:small_fireball_particle ^ ^ ^0.5 0 0 0 0 1");
						}
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 1) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[tag=spelltracker,distance=101..500] eyes run particle lantern_of_the_woodlands:particle_specify_circle ^ ^ ^1.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[tag=wsupport,tag=spelltracker,distance=101..500] eyes run particle lantern_of_the_woodlands:particle_fireball_blue ^ ^ ^1.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=!player,type=!item,tag=!wsupport,tag=spelltracker,distance=101..500] eyes run particle lantern_of_the_woodlands:small_fireball_particle ^ ^ ^1.5 0 0 0 0 1");
						}
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level > 2) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[tag=spelltracker,distance=501..1000] eyes run particle lantern_of_the_woodlands:particle_specify_circle ^ ^ ^2.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[tag=wsupport,tag=spelltracker,distance=501..1000] eyes run particle lantern_of_the_woodlands:particle_fireball_blue ^ ^ ^2.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=!player,type=!item,tag=!wsupport,tag=spelltracker,distance=501..1000] eyes run particle lantern_of_the_woodlands:small_fireball_particle ^ ^ ^2.5 0 0 0 0 1");
						}
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_waypoint == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=armor_stand,name=spell2waypoint,distance=10..100] eyes run particle lantern_of_the_woodlands:particle_fireball_purple ^ ^ ^0.5 0 0 0 0 1");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=armor_stand,name=spell2waypoint,distance=101..500] eyes run particle lantern_of_the_woodlands:particle_fireball_purple ^ ^ ^1.5 0 0 0 0 1");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=armor_stand,name=spell2waypoint,distance=501..1000] eyes run particle lantern_of_the_woodlands:particle_fireball_purple ^ ^ ^2.5 0 0 0 0 1");
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

					Spell2repeatFastProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 3);
		}
	}
}
