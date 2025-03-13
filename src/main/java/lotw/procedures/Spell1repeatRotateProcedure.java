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

public class Spell1repeatRotateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell1repeatRotate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell1repeatRotate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell1repeatRotate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell1repeatRotate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double door_height = 0;
		if (LotwModVariables.MapVariables.get(world).spell1_speed_rotate == true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-zodiac_door,name=!LOTW-zodiac_door0] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-zodiac_circle,limit=1]");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-zodiac_circle] run particle lotw:aura_white ~ ~ ~ 6 1 6 0 1 force");
			}
			if (LotwModVariables.MapVariables.get(world).spell1_distance < 10) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[name=LOTW-zodiac_door_spin] at @s run tp @s ~ ~ ~ ~-0.5 ~");
				}
			} else if (LotwModVariables.MapVariables.get(world).spell1_distance >= 10
					&& LotwModVariables.MapVariables.get(world).spell1_distance < 50) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[name=LOTW-zodiac_door_spin] at @s run tp @s ~ ~ ~ ~-0.2 ~");
				}
			} else if (LotwModVariables.MapVariables.get(world).spell1_distance >= 50) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[name=LOTW-zodiac_door_spin] at @s run tp @s ~ ~ ~ ~-0.1 ~");
				}
			}
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[name=LOTW-zodiac_door0] at @s run tp @s ~ ~ ~ ~2 ~");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[name=LOTW-zodiac_door0,y_rotation=0..180] at @s run tp @s ~ ~-0.01 ~");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[name=LOTW-zodiac_door0,y_rotation=180..360] at @s run tp @s ~ ~0.01 ~");
				}
			}
			if (LotwModVariables.MapVariables.get(world).spell1_distance == 2) {
				door_height = 1.5;
			} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 4) {
				door_height = 2.5;
			} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 6) {
				door_height = 2.5;
			} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 10) {
				door_height = 10;
			} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 25) {
				door_height = 20;
			} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 50) {
				door_height = 40;
			} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 100) {
				door_height = 80;
			}
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-zodiac_door_spin] run tp @e[name=LOTW-zodiac_door1] ^" + "" + " ^" + door_height + " ^"
									+ (LotwModVariables.MapVariables.get(world).spell1_distance - 0)));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-zodiac_door_spin] run tp @e[name=LOTW-zodiac_door2] ^" + "" + " ^" + door_height + " ^-"
									+ (LotwModVariables.MapVariables.get(world).spell1_distance - 0)));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-zodiac_door_spin] run tp @e[name=LOTW-zodiac_door3] ^"
									+ (LotwModVariables.MapVariables.get(world).spell1_distance - 0) + " ^" + door_height + " ^" + ""));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-zodiac_door_spin] run tp @e[name=LOTW-zodiac_door4] ^-"
									+ (LotwModVariables.MapVariables.get(world).spell1_distance - 0) + " ^" + door_height + " ^" + ""));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-zodiac_door_spin] run tp @e[name=LOTW-zodiac_door5] ^-"
									+ (LotwModVariables.MapVariables.get(world).spell1_distance
											- (LotwModVariables.MapVariables.get(world).spell1_distance / 2) * 0.25)
									+ " ^" + door_height + " ^-" + (LotwModVariables.MapVariables.get(world).spell1_distance
											- LotwModVariables.MapVariables.get(world).spell1_distance / 2)));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-zodiac_door_spin] run tp @e[name=LOTW-zodiac_door6] ^"
									+ (LotwModVariables.MapVariables.get(world).spell1_distance
											- (LotwModVariables.MapVariables.get(world).spell1_distance / 2) * 0.25)
									+ " ^" + door_height + " ^-" + (LotwModVariables.MapVariables.get(world).spell1_distance
											- LotwModVariables.MapVariables.get(world).spell1_distance / 2)));
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

						Spell1repeatRotateProcedure.executeProcedure(Stream
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
