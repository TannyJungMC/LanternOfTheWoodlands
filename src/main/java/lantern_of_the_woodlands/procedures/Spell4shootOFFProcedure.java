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

public class Spell4shootOFFProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell4shootOFF!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell4shootOFF!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell4shootOFF!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell4shootOFF!");
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
					("/execute at @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon"
							+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number
							+ "] run playsound minecraft:block.bell.use ambient @a ~ ~ ~ 0.5 0"));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("/execute at @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon"
							+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number
							+ "] run particle minecraft:portal ~ ~1 ~ 0.5 0.5 0.5 1 30 force"));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @p[tag=woodlands] run playsound minecraft:block.bell.use ambient @a ~ ~ ~ 0.05 0");
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
							("execute at @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number
									+ "] run particle minecraft:campfire_signal_smoke ~ ~1 ~ 0.5 0.5 0.5 0.003 20 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number
									+ "] run playsound minecraft:block.enchantment_table.use ambient @a ~ ~ ~ 0.5 0"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,name=spell4weapon,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number
									+ "] run kill @e[type=armor_stand,name=spell4shoot,tag=shoot,distance=..3,sort=nearest,limit=1]"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number + "] remove shoot"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/tag @e[type=armor_stand,name=spell4weapon,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number + "] add choose"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @p[tag=woodlands] run playsound minecraft:block.enchantment_table.use ambient @a ~ ~ ~ 2 0");
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
									"/execute at @p[tag=woodlands] positioned ~ ~-0.5 ~ run particle minecraft:reverse_portal ^-0.25 ^2.5 ^2 0.5 0.5 0.5 0.01 20 force");
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 5);
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 20);
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
							("/execute at @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=effect3,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number
									+ "] positioned ~ ~-0.5 ~ run summon minecraft:tnt ~ ~ ~"));
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
							("execute at @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number + ",tag=effect" + "1"
									+ "] positioned ~ ~-0.5 ~ run tp @e[tag=!woodlands,distance=.." + "3" + ",type=!armor_stand] @p[tag=woodlands]"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number + ",tag=effect" + "1"
									+ "] run particle minecraft:portal ~ ~1 ~ 0.5 0.5 0.5 2 50 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number + ",tag=effect" + "1"
									+ "] at @p[tag=woodlands] run particle minecraft:campfire_signal_smoke ~ ~1 ~ 0.5 0.5 0.5 0.003 20 force"));
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
							("execute at @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number + ",tag=effect" + "6"
									+ "] positioned ~ ~-0.5 ~ run effect give @e[distance=..3] minecraft:levitation 1 50 false"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number + ",tag=effect" + "6"
									+ "] positioned ~ ~-0.5 ~ run effect give @e[distance=..3] minecraft:slow_falling 15 1 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute at @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number + ",tag=effect" + "6"
									+ "] positioned ~ ~-0.5 ~ run particle minecraft:campfire_signal_smoke ~ ~25 ~ 1 15 1 0.005 100 force"));
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
							("/execute if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number + ",tag=effect" + "2"
									+ "] at @p[tag=woodlands] run particle minecraft:campfire_signal_smoke ~ ~1 ~ 0.5 0.5 0.5 0.003 20 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[type=armor_stand,name=spell4weapon,tag=weapon"
									+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number + ",tag=effect" + "2"
									+ ",limit=1] run tp @p[tag=woodlands] ~ ~1.5 ~"));
				}
				if (Math.random() < 0.2) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("/execute at @e[type=armor_stand,name=spell4weapon,tag=effect12,tag=weapon"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number
										+ ",tag=effect12] run summon lantern_of_the_woodlands:blue_bee ~ ~1 ~"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("/execute at @e[type=armor_stand,name=spell4weapon,tag=effect12,tag=weapon"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number
										+ ",tag=effect12] run summon lantern_of_the_woodlands:blue_bee ~ ~1 ~"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("/execute at @e[type=armor_stand,name=spell4weapon,tag=effect12,tag=weapon"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number
										+ ",tag=effect12] run summon lantern_of_the_woodlands:blue_bee ~ ~1 ~"));
					}
				} else if (Math.random() < 0.2) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("/execute at @e[type=armor_stand,name=spell4weapon,tag=effect12,tag=weapon"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number
										+ ",tag=effect12] run execute at @e[type=!armor_stand,tag=!wsupport,distance=..5] run summon minecraft:lightning_bolt ~ ~ ~"));
					}
				} else if (Math.random() < 0.2) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("/execute at @e[type=armor_stand,name=spell4weapon,tag=effect12,tag=weapon"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number
										+ ",tag=effect12] run execute at @e[type=!armor_stand,tag=!wsupport,distance=..10] run summon minecraft:arrow ~ ~5 ~"));
					}
				} else if (Math.random() < 0.2) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("/execute at @e[type=armor_stand,name=spell4weapon,tag=effect12,tag=weapon"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number
										+ ",tag=effect12] run summon minecraft:iron_golem ~ ~1 ~"));
					}
				} else {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("/execute at @e[type=armor_stand,name=spell4weapon,tag=effect12,tag=weapon"
										+ LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number
										+ ",tag=effect12] run execute at @e[type=!armor_stand,tag=!wsupport,distance=..10] run summon minecraft:evoker_fangs ~ ~ ~"));
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 10);
	}
}
