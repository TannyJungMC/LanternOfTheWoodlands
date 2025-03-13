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

public class Spell4clickRESETProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell4clickRESET!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell4clickRESET!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell4clickRESET!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell4clickRESET!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency entity for procedure Spell4clickRESET!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @p[tag=woodlands] run playsound minecraft:music_disc.mellohi ambient @a ~ ~ ~ 0.1 2");
		}
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_start = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_gui_test = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_1shoot = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_2shoot = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_3shoot = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_4shoot = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_5shoot = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_6shoot = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_7shoot = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_8shoot = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot1 = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot2 = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot3 = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot4 = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot5 = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot6 = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot7 = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_slot8 = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"kill @e[type=armor_stand,name=spell4main]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"kill @e[type=armor_stand,name=spell4weapon]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"kill @e[type=armor_stand,name=spell4choose]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"kill @e[type=armor_stand,name=spell4shoot]");
		}
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 0;
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number = "";
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number = "";
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
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
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_start = (true);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon armor_stand ~ ~ ~ {NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"spell4main\"}'}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon armor_stand ~ ~ ~ {NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"spell4choose\"}'}");
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
							"summon armor_stand ~ ~ ~ {NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"spell4weapon\"}',Pose:{Head:[0f,0f,-45f]},Tags:[\"extra\",\"weapon1\"]}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon armor_stand ~ ~ ~ {NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"spell4weapon\"}',Pose:{Head:[0f,0f,-45f]},Tags:[\"extra\",\"weapon2\"]}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon armor_stand ~ ~ ~ {NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"spell4weapon\"}',Pose:{Head:[0f,0f,-45f]},Tags:[\"extra\",\"weapon3\"]}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon armor_stand ~ ~ ~ {NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"spell4weapon\"}',Pose:{Head:[0f,0f,-45f]},Tags:[\"extra\",\"weapon4\"]}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon armor_stand ~ ~ ~ {NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"spell4weapon\"}',Pose:{Head:[0f,0f,-45f]},Tags:[\"extra\",\"weapon5\"]}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon armor_stand ~ ~ ~ {NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"spell4weapon\"}',Pose:{Head:[0f,0f,-45f]},Tags:[\"extra\",\"weapon6\"]}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon armor_stand ~ ~ ~ {NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"spell4weapon\"}',Pose:{Head:[0f,0f,-45f]},Tags:[\"extra\",\"weapon7\"]}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon armor_stand ~ ~ ~ {NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"spell4weapon\"}',Pose:{Head:[0f,0f,-45f]},Tags:[\"extra\",\"weapon8\"]}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"tag @e[type=armor_stand,name=spell4weapon] add wsupport");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"tag @e[type=armor_stand,name=spell4shoot] add wsupport");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"tag @e[type=armor_stand,name=spell4main] add wsupport");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"tag @e[type=armor_stand,name=spell4choose] add wsupport");
				}
				Spell4repeatFastProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

				Spell4repeatSlowProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_gui_test = (true);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
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

						Spell4GUItestProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
										new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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

								Spell4GUItest2Procedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
												new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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

										Spell4GUItest3Procedure.executeProcedure(Stream
												.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
														new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
														new AbstractMap.SimpleEntry<>("entity", entity))
												.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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

												Spell4GUItest4Procedure.executeProcedure(Stream
														.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
																new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
																new AbstractMap.SimpleEntry<>("entity", entity))
														.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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

														Spell4GUItest5Procedure.executeProcedure(Stream.of(
																new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
																new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
																new AbstractMap.SimpleEntry<>("entity", entity))
																.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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

																Spell4GUItest6Procedure
																		.executeProcedure(Stream
																				.of(new AbstractMap.SimpleEntry<>("world", world),
																						new AbstractMap.SimpleEntry<>("x", x),
																						new AbstractMap.SimpleEntry<>("y", y),
																						new AbstractMap.SimpleEntry<>("z", z),
																						new AbstractMap.SimpleEntry<>("entity", entity))
																				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()),
																						Map::putAll));
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

																		Spell4GUItest7Procedure.executeProcedure(Stream
																				.of(new AbstractMap.SimpleEntry<>("world", world),
																						new AbstractMap.SimpleEntry<>("x", x),
																						new AbstractMap.SimpleEntry<>("y", y),
																						new AbstractMap.SimpleEntry<>("z", z),
																						new AbstractMap.SimpleEntry<>("entity", entity))
																				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()),
																						Map::putAll));
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

																				Spell4GUItest8Procedure.executeProcedure(Stream
																						.of(new AbstractMap.SimpleEntry<>("world", world),
																								new AbstractMap.SimpleEntry<>("x", x),
																								new AbstractMap.SimpleEntry<>("y", y),
																								new AbstractMap.SimpleEntry<>("z", z),
																								new AbstractMap.SimpleEntry<>("entity", entity))
																						.collect(HashMap::new,
																								(_m, _e) -> _m.put(_e.getKey(), _e.getValue()),
																								Map::putAll));
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
																							((World) world).getServer().getCommandManager()
																									.handleCommand(
																											new CommandSource(ICommandSource.DUMMY,
																													new Vector3d(x, y, z),
																													Vector2f.ZERO,
																													(ServerWorld) world, 4, "",
																													new StringTextComponent(""),
																													((World) world).getServer(), null)
																													.withFeedbackDisabled(),
																											"/execute at @p[tag=woodlands] run playsound minecraft:entity.player.levelup ambient @a ~ ~ ~ 0.15 0");
																						}
																						if (world instanceof ServerWorld) {
																							((World) world).getServer().getCommandManager()
																									.handleCommand(
																											new CommandSource(ICommandSource.DUMMY,
																													new Vector3d(x, y, z),
																													Vector2f.ZERO,
																													(ServerWorld) world, 4, "",
																													new StringTextComponent(""),
																													((World) world).getServer(), null)
																													.withFeedbackDisabled(),
																											"/stopsound @a ambient minecraft:music_disc.mellohi");
																						}
																						MinecraftForge.EVENT_BUS.unregister(this);
																					}
																				}.start(world, (int) 20);
																				MinecraftForge.EVENT_BUS.unregister(this);
																			}
																		}.start(world, (int) 20);
																		MinecraftForge.EVENT_BUS.unregister(this);
																	}
																}.start(world, (int) 20);
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 20);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 20);
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 20);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 20);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 20);
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 100);
	}
}
