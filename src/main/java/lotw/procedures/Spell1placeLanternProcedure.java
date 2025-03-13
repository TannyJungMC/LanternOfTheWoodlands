package lotw.procedures;

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

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell1placeLanternProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell1placeLantern!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell1placeLantern!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell1placeLantern!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell1placeLantern!");
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
					"kill @e[tag=LOTW-zodiac_circle]");
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
				if ((LotwModVariables.MapVariables.get(world).spell1_invisible_circle).equals("Off")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-placed_lantern] if block ~ ~-0.5 ~ lotw:lantern_stick run summon armor_stand ~ ~-2.4 ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-circle_hr_s\"],CustomName:'{\"text\":\"LOTW-zodiac_circle\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},ArmorItems:[{},{},{},{id:\"lotw:zodiac_circle\",Count:1b}]}");
					}
				} else if ((LotwModVariables.MapVariables.get(world).spell1_invisible_circle).equals("On")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-placed_lantern] if block ~ ~-0.5 ~ lotw:lantern_stick run summon armor_stand ~ ~-2.4 ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-circle_hr_s\"],CustomName:'{\"text\":\"LOTW-zodiac_circle\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b}");
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] if block ~ ~-0.5 ~ lotw:lantern_stick run summon armor_stand ~ ~-1 ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\"],CustomName:'{\"text\":\"LOTW-zodiac_door_spin\"}',NoGravity:1b,Marker:1b,Invisible:1b}");
				}
				if ((LotwModVariables.MapVariables.get(world).spell1_invisible_card).equals("Off")) {
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-zodiac_circle] run summon armor_stand ~ ~4 ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-zodiac_door\"],CustomName:'{\"text\":\"LOTW-zodiac_door1\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-zodiac_circle] run summon armor_stand ~ ~4 ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-zodiac_door\"],CustomName:'{\"text\":\"LOTW-zodiac_door2\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-zodiac_circle] run summon armor_stand ~ ~4 ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-zodiac_door\"],CustomName:'{\"text\":\"LOTW-zodiac_door3\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-zodiac_circle] run summon armor_stand ~ ~4 ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-zodiac_door\"],CustomName:'{\"text\":\"LOTW-zodiac_door4\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-zodiac_circle] run summon armor_stand ~ ~4 ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-zodiac_door\"],CustomName:'{\"text\":\"LOTW-zodiac_door5\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-zodiac_circle] run summon armor_stand ~ ~4 ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-zodiac_door\"],CustomName:'{\"text\":\"LOTW-zodiac_door6\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}");
						}
					}
					if (LotwModVariables.MapVariables.get(world).spell1_distance == 2) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-zodiac_circle] run summon armor_stand ~ ~" + "6"
											+ " ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-zodiac_door\"],CustomName:'{\"text\":\"LOTW-zodiac_door0\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}"));
						}
					} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 4) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-zodiac_circle] run summon armor_stand ~ ~" + "8"
											+ " ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-zodiac_door\"],CustomName:'{\"text\":\"LOTW-zodiac_door0\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}"));
						}
					} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 6) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-zodiac_circle] run summon armor_stand ~ ~" + "10"
											+ " ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-zodiac_door\"],CustomName:'{\"text\":\"LOTW-zodiac_door0\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}"));
						}
					} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 10) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-zodiac_circle] run summon armor_stand ~ ~" + "12.5"
											+ " ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-zodiac_door\"],CustomName:'{\"text\":\"LOTW-zodiac_door0\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}"));
						}
					} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 25) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-zodiac_circle] run summon armor_stand ~ ~" + "15"
											+ " ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-zodiac_door\"],CustomName:'{\"text\":\"LOTW-zodiac_door0\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}"));
						}
					} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 50) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-zodiac_circle] run summon armor_stand ~ ~" + "25"
											+ " ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-zodiac_door\"],CustomName:'{\"text\":\"LOTW-zodiac_door0\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}"));
						}
					} else if (LotwModVariables.MapVariables.get(world).spell1_distance == 100) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-zodiac_circle] run summon armor_stand ~ ~" + "40"
											+ " ~ {Tags:[\"LOTW-ally\",\"LOTW-zodiac_circle\",\"LOTW-zodiac_door\"],CustomName:'{\"text\":\"LOTW-zodiac_door0\"}',NoGravity:1b,Marker:1b,Invisible:1b,ShowArms:1b,Pose:{LeftArm:[0f,0f,0f],RightArm:[0f,0f,0f]},HandItems:[{id:\"lotw:zodiac_\",Count:1b},{}]}"));
						}
					}
				}
				Spell1doorUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 5);
	}
}
