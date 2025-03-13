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

import java.util.Map;

public class Spell2repeatProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell2repeat!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell2repeat!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell2repeat!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell2repeat!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_all == true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] run playsound minecraft:block.beacon.activate ambient @a ~ ~ ~ 2 0");
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_all == true) {
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_player == true) {
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification_other_team == true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] if entity @e[type=player,tag=!wsupport,distance=10..100,limit=1] run playsound minecraft:block.note_block.chime ambient @a ~ ~ ~ 2 0");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[type=player,tag=!wsupport,tag=!woodlands,distance=10..100] eyes positioned ~ ~0.25 ~ run particle lantern_of_the_woodlands:particle_specify_circle_2 ^ ^ ^0.5 0 0 0 0 1");
						}
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification_buoy == true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute if entity @e[type=armor_stand,name=placed_lantern] at @e[type=armor_stand,name=spell2waypoint] as @e[type=player,tag=!wsupport,tag=!woodlands,distance=..20,limit=1] run execute at @e[type=armor_stand,name=spell2main] positioned ~ ~0.25 ~ run playsound minecraft:block.note_block.chime ambient @a ~ ~ ~ 2 0");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute if entity @e[type=armor_stand,name=placed_lantern] at @e[type=armor_stand,name=spell2waypoint,distance=10..100] as @e[type=player,tag=!wsupport,tag=!woodlands,distance=..20] run execute at @e[type=armor_stand,name=spell2main] facing entity @s eyes positioned ~ ~0.25 ~ run particle lantern_of_the_woodlands:particle_specify_circle_2 ^ ^ ^0.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute if entity @e[type=armor_stand,name=placed_lantern] at @e[type=armor_stand,name=spell2waypoint,distance=101..500] as @e[type=player,tag=!wsupport,tag=!woodlands,distance=..20] run execute at @e[type=armor_stand,name=spell2main] facing entity @s eyes positioned ~ ~0.25 ~ run particle lantern_of_the_woodlands:particle_specify_circle_2 ^ ^ ^1.5 0 0 0 0 1");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute if entity @e[type=armor_stand,name=placed_lantern] at @e[type=armor_stand,name=spell2waypoint,distance=501..1000] as @e[type=player,tag=!wsupport,tag=!woodlands,distance=..20] run execute at @e[type=armor_stand,name=spell2main] facing entity @s eyes positioned ~ ~0.25 ~ run particle lantern_of_the_woodlands:particle_specify_circle_2 ^ ^ ^2.5 0 0 0 0 1");
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
						if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_tracker == true) {
							if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification_tracker == true) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] if entity @e[tag=spelltracker,distance=10..100,limit=1] run playsound minecraft:block.note_block.bell ambient @a ~ ~ ~ 2 2");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute if entity @e[type=armor_stand,name=placed_lantern] run execute at @e[type=armor_stand,name=spell2main] facing entity @e[tag=spelltracker,distance=10..100] eyes positioned ~ ~0.25 ~ run particle lantern_of_the_woodlands:particle_specify_circle_2 ^ ^ ^0.5 0 0 0 0 1");
								}
							}
							if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification_buoy == true) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute if entity @e[type=armor_stand,name=placed_lantern] at @e[type=armor_stand,name=spell2waypoint] as @e[tag=spelltracker,distance=..20,limit=1] run execute at @e[type=armor_stand,name=spell2main] positioned ~ ~0.25 ~ run playsound minecraft:block.note_block.bell ambient @a ~ ~ ~ 2 2");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute if entity @e[type=armor_stand,name=placed_lantern] at @e[type=armor_stand,name=spell2waypoint,distance=10..100] as @e[tag=spelltracker,distance=..20] run execute at @e[type=armor_stand,name=spell2main] facing entity @s eyes positioned ~ ~0.25 ~ run particle lantern_of_the_woodlands:particle_specify_circle_2 ^ ^ ^0.5 0 0 0 0 1");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute if entity @e[type=armor_stand,name=placed_lantern] at @e[type=armor_stand,name=spell2waypoint,distance=101..500] as @e[tag=spelltracker,distance=..20] run execute at @e[type=armor_stand,name=spell2main] facing entity @s eyes positioned ~ ~0.25 ~ run particle lantern_of_the_woodlands:particle_specify_circle_2 ^ ^ ^1.5 0 0 0 0 1");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute if entity @e[type=armor_stand,name=placed_lantern] at @e[type=armor_stand,name=spell2waypoint,distance=501..1000] as @e[tag=spelltracker,distance=..20] run execute at @e[type=armor_stand,name=spell2main] facing entity @s eyes positioned ~ ~0.25 ~ run particle lantern_of_the_woodlands:particle_specify_circle_2 ^ ^ ^2.5 0 0 0 0 1");
								}
							}
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 20);
			}
		}
	}
}
