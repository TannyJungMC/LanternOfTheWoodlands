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

import java.util.Map;

public class Spell5summonTrapProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell5summonTrap!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell5summonTrap!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell5summonTrap!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell5summonTrap!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		LotwModVariables.MapVariables.get(world).spell5_trap_degree = (LotwModVariables.MapVariables.get(world).spell5_trap_degree + new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LotwModVariables.MapVariables.get(world).spell5_degree_frequency));
		LotwModVariables.MapVariables.get(world).syncData(world);
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @e[type=armor_stand,name=Mazer1] run summon armor_stand ~ ~ ~ {Invisible:1b,CustomName:'{\"text\":\"MazerTrapSummon\"}'}");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @e[type=armor_stand,name=Mazer1] as @e[type=armor_stand,name=MazerTrapSummon,limit=1,sort=nearest] at @s run tp @s ~ ~ ~ facing entity @e[type=armor_stand,name=MazerMain,limit=1]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("/execute at @e[type=armor_stand,name=Mazer1] as @e[type=armor_stand,name=MazerTrapSummon,limit=1,sort=nearest] at @s run tp @s ~ ~"
							+ new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(LotwModVariables.MapVariables.get(world).spell5_height) + " ~ ~ 0"));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("/execute at @e[type=armor_stand,name=Mazer1] positioned ~ ~" + new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(LotwModVariables.MapVariables.get(world).spell5_height)
							+ " ~ as @e[type=armor_stand,name=MazerTrapSummon,limit=1,sort=nearest] at @s run tp @s ^ ^ ^" + ((new Object() {
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
							}.convert(LotwModVariables.MapVariables.get(world).spell5_circle_frequency)) / 2));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("execute at @e[type=armor_stand,name=Mazer1] run playsound minecraft:block.chest.locked ambient @a[distance=..100] ~ ~"
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
				if (LotwModVariables.MapVariables.get(world).spell5_remove == false) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[type=armor_stand,name=MazerTrapSummon,nbt={OnGround:1b}] run kill @e[type=armor_stand,name=MazerTrap,distance=..1]");
					}
					if (Math.random() <= (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(LotwModVariables.MapVariables.get(world).spell5_trap) / 100) / 6) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[type=armor_stand,name=MazerTrapSummon,nbt={OnGround:1b}] run summon armor_stand ~ ~1 ~ {Invisible:1b,Marker:1b,CustomName:'{\"text\":\"MazerTrap\"}',Tags:[\"extra\",\"MazerTrap-"
											+ "lightning" + "\"]}"));
						}
					} else if (Math.random() <= (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(LotwModVariables.MapVariables.get(world).spell5_trap) / 100) / 6) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[type=armor_stand,name=MazerTrapSummon,nbt={OnGround:1b}] run summon armor_stand ~ ~1 ~ {Invisible:1b,Marker:1b,CustomName:'{\"text\":\"MazerTrap\"}',Tags:[\"extra\",\"MazerTrap-"
											+ "fang" + "\"]}"));
						}
					} else if (Math.random() <= (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(LotwModVariables.MapVariables.get(world).spell5_trap) / 100) / 6) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[type=armor_stand,name=MazerTrapSummon,nbt={OnGround:1b}] run summon armor_stand ~ ~1 ~ {Invisible:1b,Marker:1b,CustomName:'{\"text\":\"MazerTrap\"}',Tags:[\"extra\",\"MazerTrap-"
											+ "arrow" + "\"]}"));
						}
					} else if (Math.random() <= (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(LotwModVariables.MapVariables.get(world).spell5_trap) / 100) / 6) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[type=armor_stand,name=MazerTrapSummon,nbt={OnGround:1b}] run summon armor_stand ~ ~1 ~ {Invisible:1b,Marker:1b,CustomName:'{\"text\":\"MazerTrap\"}',Tags:[\"extra\",\"MazerTrap-"
											+ "wither_effect" + "\"]}"));
						}
					} else if (Math.random() <= (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(LotwModVariables.MapVariables.get(world).spell5_trap) / 100) / 6) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[type=armor_stand,name=MazerTrapSummon,nbt={OnGround:1b}] run summon armor_stand ~ ~1 ~ {Invisible:1b,Marker:1b,CustomName:'{\"text\":\"MazerTrap\"}',Tags:[\"extra\",\"MazerTrap-"
											+ "spectral_arrow" + "\"]}"));
						}
					} else if (Math.random() <= (new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(LotwModVariables.MapVariables.get(world).spell5_trap) / 100) / 6) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[type=armor_stand,name=MazerTrapSummon,nbt={OnGround:1b}] run summon armor_stand ~ ~1 ~ {Invisible:1b,Marker:1b,CustomName:'{\"text\":\"MazerTrap\"}',Tags:[\"extra\",\"MazerTrap-"
											+ "trident" + "\"]}"));
						}
					}
				} else {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[type=armor_stand,name=MazerTrapSummon,nbt={OnGround:1b}] run kill @e[type=armor_stand,name=MazerTrap,distance=..1]");
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[type=armor_stand,name=MazerTrapSummon,nbt={OnGround:1b}] at @s run kill @s");
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 5);
	}
}
