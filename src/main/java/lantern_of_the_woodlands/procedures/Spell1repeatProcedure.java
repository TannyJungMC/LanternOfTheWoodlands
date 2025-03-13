package lantern_of_the_woodlands.procedures;

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

import java.util.Map;

public class Spell1repeatProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell1repeat!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell1repeat!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell1repeat!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell1repeat!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @e[type=armor_stand,name=SupportStation] run particle lantern_of_the_woodlands:small_fireball_particle ~ ~-0.25 ~ 0 0 0 0 1");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @e[type=armor_stand,name=SupportStationMedium] run particle lantern_of_the_woodlands:particle_fireball_blue ~ ~-0.25 ~ 0 0 0 0 1");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @e[type=armor_stand,name=SupportStationLarge] run particle lantern_of_the_woodlands:particle_fireball_red ~ ~-0.25 ~ 0 0 0 0 1");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell1lanternStation] run particle lantern_of_the_woodlands:particle_fireball_gold ~ ~1 ~ 0 0 0 0 1");
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_invisible_station == false) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute at @e[type=armor_stand,name=SupportStation] run playsound minecraft:block.beacon.ambient ambient @a ~ ~ ~ 2 2");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute at @e[type=armor_stand,name=SupportStationMedium] run playsound minecraft:block.beacon.ambient ambient @a ~ ~ ~ 2 1.5");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute at @e[type=armor_stand,name=SupportStationLarge] run playsound minecraft:block.beacon.ambient ambient @a ~ ~ ~ 2 1.25");
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=spell1lanternStation] run playsound minecraft:block.beacon.ambient ambient @a ~ ~ ~ 2 1.75");
				}
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_healing == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_healing == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect give @e[distance=..1] minecraft:instant_health 1 1 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect give @e[distance=..7] minecraft:instant_health 1 1 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect give @e[distance=..15] minecraft:instant_health 1 1 true");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell1lanternStation] run effect give @e[distance=..3] minecraft:instant_health 1 1 true");
					}
				}
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_damage_boost == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_damage_boost == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect give @e[tag=wsupport,distance=..1] minecraft:strength 60 4 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect give @e[tag=wsupport,distance=..7] minecraft:strength 60 4 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect give @e[tag=wsupport,distance=..15] minecraft:strength 60 4 true");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell1lanternStation] run effect give @e[tag=wsupport,distance=..3] minecraft:strength 60 4 true");
					}
				}
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_protection == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_protection == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect give @e[tag=wsupport,distance=..1] minecraft:resistance 60 4 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect give @e[tag=wsupport,distance=..7] minecraft:resistance 60 4 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect give @e[tag=wsupport,distance=..15] minecraft:resistance 60 4 true");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell1lanternStation] run effect give @e[tag=wsupport,distance=..3] minecraft:resistance 60 4 true");
					}
				}
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_golden_heart == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_golden_heart == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect give @e[tag=wsupport,distance=..1] minecraft:absorption 60 4 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect give @e[tag=wsupport,distance=..7] minecraft:absorption 60 4 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect give @e[tag=wsupport,distance=..15] minecraft:absorption 60 4 true");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell1lanternStation] run effect give @e[tag=wsupport,distance=..3] minecraft:absorption 60 4 true");
					}
				}
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_miner == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_miner == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect give @e[tag=wsupport,distance=..1] minecraft:haste 60 9 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect give @e[tag=wsupport,distance=..7] minecraft:haste 60 9 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect give @e[tag=wsupport,distance=..15] minecraft:haste 60 9 true");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=armor_stand,name=spell1lanternStation] run effect give @e[tag=wsupport,distance=..3] minecraft:haste 60 9 true");
					}
				}
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_barrier == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_barrier == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect give @e[tag=!wsupport,distance=..1] minecraft:slowness 3 100 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect give @e[tag=!wsupport,distance=..7] minecraft:slowness 3 100 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect give @e[tag=!wsupport,distance=..15] minecraft:slowness 3 100 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect give @e[tag=!wsupport,distance=..1] minecraft:speed 3 100 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect give @e[tag=!wsupport,distance=..7] minecraft:speed 3 100 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect give @e[tag=!wsupport,distance=..15] minecraft:speed 3 100 true");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=armor_stand,name=spell1lanternStation] run effect give @e[tag=!wsupport,distance=..3] minecraft:slowness 3 100 true");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=armor_stand,name=spell1lanternStation] run effect give @e[tag=!wsupport,distance=..3] minecraft:speed 3 100 true");
					}
				}
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_camouflage == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_camouflage == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect give @e[tag=wsupport,distance=..1] minecraft:invisibility 60 4 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect give @e[tag=wsupport,distance=..7] minecraft:invisibility 60 4 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect give @e[tag=wsupport,distance=..15] minecraft:invisibility 60 4 true");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=armor_stand,name=spell1lanternStation] run effect give @e[tag=wsupport,distance=..3] minecraft:invisibility 60 4 true");
					}
				}
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_ability == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_ability == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect give @e[tag=wsupport,distance=..1] minecraft:speed 60 2 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect give @e[tag=wsupport,distance=..7] minecraft:speed 60 2 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect give @e[tag=wsupport,distance=..15] minecraft:speed 60 2 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect give @e[tag=wsupport,distance=..1] minecraft:jump_boost 60 2 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect give @e[tag=wsupport,distance=..7] minecraft:jump_boost 60 2 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect give @e[tag=wsupport,distance=..15] minecraft:jump_boost 60 2 true");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=armor_stand,name=spell1lanternStation] run effect give @e[tag=wsupport,distance=..3] minecraft:speed 60 2 true");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=armor_stand,name=spell1lanternStation] run effect give @e[tag=wsupport,distance=..3] minecraft:jump_boost 60 2 true");
					}
				}
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_orientation == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_orientation == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect give @e[tag=wsupport,distance=..1] minecraft:fire_resistance 60 4 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect give @e[tag=wsupport,distance=..7] minecraft:fire_resistance 60 4 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect give @e[tag=wsupport,distance=..15] minecraft:fire_resistance 60 4 true");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=armor_stand,name=spell1lanternStation] run effect give @e[tag=wsupport,distance=..3] minecraft:fire_resistance 60 4 true");
					}
				}
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_water == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_water == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect give @e[tag=wsupport,distance=..1] minecraft:water_breathing 60 4 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect give @e[tag=wsupport,distance=..7] minecraft:water_breathing 60 4 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect give @e[tag=wsupport,distance=..15] minecraft:water_breathing 60 4 true");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=armor_stand,name=spell1lanternStation] run effect give @e[tag=wsupport,distance=..3] minecraft:water_breathing 60 4 true");
					}
				}
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_night_vision == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_night_vision == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect give @e[tag=wsupport,distance=..1] minecraft:night_vision 60 0 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect give @e[tag=wsupport,distance=..7] minecraft:night_vision 60 0 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect give @e[tag=wsupport,distance=..15] minecraft:night_vision 60 0 true");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[type=armor_stand,name=spell1lanternStation] run effect give @e[tag=wsupport,distance=..3] minecraft:night_vision 60 0 true");
					}
				}
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_clear == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_clear == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStation] run effect clear @e[distance=..1]");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationMedium] run effect clear @e[distance=..7]");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=SupportStationLarge] run effect clear @e[distance=..15]");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station == true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell1lanternStation] run effect clear @e[distance=..3]");
					}
				}
			}
		}
	}
}
