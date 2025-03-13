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

public class Spell4chooseProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell4choose!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell4choose!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell4choose!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell4choose!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).main_spell == 4) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_start == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @p[tag=woodlands] run playsound minecraft:block.enchantment_table.use ambient @a ~ ~ ~ 0.5 0");
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap == 0) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"tag @e[type=armor_stand,name=spell4weapon] remove choose");
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot1 == true) {
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
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 1;
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/tag @e[type=armor_stand,name=spell4weapon,tag=!shoot,tag=weapon1] add choose");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/title @p[tag=woodlands] actionbar [{\"text\":\"1\",\"color\":\"red\"},{\"text\":\"/8\",\"color\":\"gray\"}]");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/effect give @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon1] minecraft:glowing 3 1 true");
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
					} else {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 1;
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap == 1) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"tag @e[type=armor_stand,name=spell4weapon] remove choose");
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot2 == true) {
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
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 2;
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/tag @e[type=armor_stand,name=spell4weapon,tag=!shoot,tag=weapon2] add choose");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/title @p[tag=woodlands] actionbar [{\"text\":\"2\",\"color\":\"red\"},{\"text\":\"/8\",\"color\":\"gray\"}]");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/effect give @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon2] minecraft:glowing 3 1 true");
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
					} else {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 2;
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap == 2) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"tag @e[type=armor_stand,name=spell4weapon] remove choose");
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot3 == true) {
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
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 3;
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/tag @e[type=armor_stand,name=spell4weapon,tag=!shoot,tag=weapon3] add choose");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/title @p[tag=woodlands] actionbar [{\"text\":\"3\",\"color\":\"red\"},{\"text\":\"/8\",\"color\":\"gray\"}]");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/effect give @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon3] minecraft:glowing 3 1 true");
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
					} else {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 3;
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap == 3) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"tag @e[type=armor_stand,name=spell4weapon] remove choose");
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot4 == true) {
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
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 4;
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/tag @e[type=armor_stand,name=spell4weapon,tag=!shoot,tag=weapon4] add choose");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/title @p[tag=woodlands] actionbar [{\"text\":\"4\",\"color\":\"red\"},{\"text\":\"/8\",\"color\":\"gray\"}]");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/effect give @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon4] minecraft:glowing 3 1 true");
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
					} else {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 4;
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap == 4) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"tag @e[type=armor_stand,name=spell4weapon] remove choose");
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot5 == true) {
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
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 5;
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/tag @e[type=armor_stand,name=spell4weapon,tag=!shoot,tag=weapon5] add choose");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/title @p[tag=woodlands] actionbar [{\"text\":\"5\",\"color\":\"red\"},{\"text\":\"/8\",\"color\":\"gray\"}]");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/effect give @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon5] minecraft:glowing 3 1 true");
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
					} else {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 5;
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap == 5) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"tag @e[type=armor_stand,name=spell4weapon] remove choose");
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot6 == true) {
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
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 6;
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/tag @e[type=armor_stand,name=spell4weapon,tag=!shoot,tag=weapon6] add choose");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/title @p[tag=woodlands] actionbar [{\"text\":\"6\",\"color\":\"red\"},{\"text\":\"/8\",\"color\":\"gray\"}]");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/effect give @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon6] minecraft:glowing 3 1 true");
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
					} else {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 6;
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap == 6) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"tag @e[type=armor_stand,name=spell4weapon] remove choose");
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot7 == true) {
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
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 7;
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/tag @e[type=armor_stand,name=spell4weapon,tag=!shoot,tag=weapon7] add choose");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/title @p[tag=woodlands] actionbar [{\"text\":\"7\",\"color\":\"red\"},{\"text\":\"/8\",\"color\":\"gray\"}]");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/effect give @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon7] minecraft:glowing 3 1 true");
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
					} else {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 7;
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap == 7) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"tag @e[type=armor_stand,name=spell4weapon] remove choose");
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot8 == true) {
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
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 8;
								LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/tag @e[type=armor_stand,name=spell4weapon,tag=!shoot,tag=weapon8] add choose");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/title @p[tag=woodlands] actionbar [{\"text\":\"8\",\"color\":\"red\"},{\"text\":\"/8\",\"color\":\"gray\"}]");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/effect give @e[type=armor_stand,name=spell4weapon,tag=shoot,tag=weapon8] minecraft:glowing 3 1 true");
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
					} else {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 8;
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/title @p[tag=woodlands] actionbar [{\"text\":\"Nothing\",\"color\":\"red\"}]");
						}
					}
				}
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap == 8) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"tag @e[type=armor_stand,name=spell4weapon] remove choose");
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
							LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 0;
							LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"/title @p[tag=woodlands] actionbar [{\"text\":\"Nothing\",\"color\":\"red\"}]");
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 5);
				}
			}
		}
	}
}
