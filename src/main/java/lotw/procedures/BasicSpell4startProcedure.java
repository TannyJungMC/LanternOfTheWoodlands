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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.BlockState;

import lotw.block.WallOfVinesBlockBlock;
import lotw.block.WallOfVinesBlock;

import lotw.LotwMod;

import java.util.Random;
import java.util.Map;

public class BasicSpell4startProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure BasicSpell4start!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure BasicSpell4start!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure BasicSpell4start!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure BasicSpell4start!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure BasicSpell4start!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.isSneaking()) {
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
								"give @p[tag=LOTW-user] lotw:wall_of_vines 1");
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 5);
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == WallOfVinesBlock.block.asItem()) {
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
									("execute at @e[name=LOTW-basicspell4" + "" + "] run setblock ~ ~" + "" + " ~ lotw:wall_of_vines_block keep"));
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
											("execute at @e[name=LOTW-basicspell4" + "" + "] run setblock ~ ~" + "1"
													+ " ~ lotw:wall_of_vines_block keep"));
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
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													("execute at @e[name=LOTW-basicspell4" + "" + "] run setblock ~ ~" + "2"
															+ " ~ lotw:wall_of_vines_block keep"));
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
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															("execute at @e[name=LOTW-basicspell4" + "" + "] run setblock ~ ~" + "3"
																	+ " ~ lotw:wall_of_vines_block keep"));
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
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-basicspell4" + "" + "] run setblock ~ ~" + "4"
																			+ " ~ lotw:wall_of_vines_block keep"));
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
																			new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																					Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(),
																			("execute at @e[name=LOTW-basicspell4" + "" + "] run setblock ~ ~" + "5"
																					+ " ~ lotw:wall_of_vines_block keep"));
																}
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 5);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 5);
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 5);
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 5);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 5);
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
									("execute at @e[name=LOTW-basicspell4" + "" + "] at @e[name=LOTW-basicspell4,sort=random,limit=1" + ""
											+ "] run setblock ~ ~" + "6" + " ~ lotw:wall_of_vines_block keep"));
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
											("execute at @e[name=LOTW-basicspell4" + "" + "] at @e[name=LOTW-basicspell4,sort=random,limit=1" + ""
													+ "] run fill ~ ~6 ~ ~ ~ ~" + "7" + " ~ lotw:wall_of_vines_block keep"));
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 35);
			} else {
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
									"execute at @e[name=LOTW-basicspell4] run fill ~ ~7 ~ ~ ~7 ~ air replace lotw:wall_of_vines_block");
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
											"execute at @e[name=LOTW-basicspell4] run fill ~ ~6 ~ ~ ~6 ~ air replace lotw:wall_of_vines_block");
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
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"execute at @e[name=LOTW-basicspell4] run fill ~ ~5 ~ ~ ~5 ~ air replace lotw:wall_of_vines_block");
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
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute at @e[name=LOTW-basicspell4] run fill ~ ~4 ~ ~ ~4 ~ air replace lotw:wall_of_vines_block");
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
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-basicspell4] run fill ~ ~3 ~ ~ ~3 ~ air replace lotw:wall_of_vines_block");
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
																			new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																					Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(),
																			"execute at @e[name=LOTW-basicspell4] run fill ~ ~2 ~ ~ ~2 ~ air replace lotw:wall_of_vines_block");
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
																			((World) world).getServer().getCommandManager()
																					.handleCommand(new CommandSource(ICommandSource.DUMMY,
																							new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
																							4, "", new StringTextComponent(
																									""),
																							((World) world).getServer(), null).withFeedbackDisabled(),
																							"execute at @e[name=LOTW-basicspell4] run fill ~ ~1 ~ ~ ~1 ~ air replace lotw:wall_of_vines_block");
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
																					((World) world).getServer().getCommandManager()
																							.handleCommand(new CommandSource(ICommandSource.DUMMY,
																									new Vector3d(x, y, z), Vector2f.ZERO,
																									(ServerWorld) world, 4, "",
																									new StringTextComponent(""),
																									((World) world).getServer(), null)
																									.withFeedbackDisabled(),
																									"execute at @e[name=LOTW-basicspell4] run fill ~ ~ ~ ~ ~ ~ air replace lotw:wall_of_vines_block");
																				}
																				MinecraftForge.EVENT_BUS.unregister(this);
																			}
																		}.start(world, (int) 5);
																		MinecraftForge.EVENT_BUS.unregister(this);
																	}
																}.start(world, (int) 5);
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 5);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 5);
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 5);
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 5);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 5);
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-basicspell4] run particle minecraft:totem_of_undying ~ ~3 ~ 1 2 1 0 5 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"fill ~ ~ ~ ~ ~ ~ air replace lotw:wall_of_vines");
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO, (ServerWorld) world, 4,
								"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\"],CustomName:'{\"text\":\"LOTW-basicspell4\"}',Invisible:1b,Marker:1b,NoGravity:1b}");
			}
			if (((world.getBlockState(new BlockPos(x + 1.5, y, z + 0.5))).getBlock() == WallOfVinesBlockBlock.block
					|| (world.getBlockState(new BlockPos(x - 0.5, y, z + 0.5))).getBlock() == WallOfVinesBlockBlock.block
					|| (world.getBlockState(new BlockPos(x + 0.5, y, z + 1.5))).getBlock() == WallOfVinesBlockBlock.block
					|| (world.getBlockState(new BlockPos(x + 0.5, y, z - 0.5))).getBlock() == WallOfVinesBlockBlock.block)
					&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == WallOfVinesBlock.block.asItem()) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), y, (z + 0.5)), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-basicspell4,limit=2,sort=nearest] run particle minecraft:totem_of_undying ~ ~3 ~ 1 2 1 0 5 force");
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
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), y, (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
											4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"give @p[tag=LOTW-user] lotw:wall_of_vines 1");
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 5);
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
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), y, (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
											4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-basicspell4,limit=2,sort=nearest] run fill ~ ~7 ~ ~ ~7 ~ air replace lotw:wall_of_vines_block");
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
											new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), y, (z + 0.5)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
													.withFeedbackDisabled(),
											"execute at @e[name=LOTW-basicspell4,limit=2,sort=nearest] run fill ~ ~6 ~ ~ ~6 ~ air replace lotw:wall_of_vines_block");
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
													new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), y, (z + 0.5)), Vector2f.ZERO,
															(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
															null).withFeedbackDisabled(),
													"execute at @e[name=LOTW-basicspell4,limit=2,sort=nearest] run fill ~ ~5 ~ ~ ~5 ~ air replace lotw:wall_of_vines_block");
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
															new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), y, (z + 0.5)),
																	Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute at @e[name=LOTW-basicspell4,limit=2,sort=nearest] run fill ~ ~4 ~ ~ ~4 ~ air replace lotw:wall_of_vines_block");
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
																	new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), y, (z + 0.5)),
																			Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-basicspell4,limit=2,sort=nearest] run fill ~ ~3 ~ ~ ~3 ~ air replace lotw:wall_of_vines_block");
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
																			new CommandSource(ICommandSource.DUMMY,
																					new Vector3d((x + 0.5), y, (z + 0.5)), Vector2f.ZERO,
																					(ServerWorld) world, 4, "", new StringTextComponent(
																							""),
																					((World) world).getServer(), null).withFeedbackDisabled(),
																			"execute at @e[name=LOTW-basicspell4,limit=2,sort=nearest] run fill ~ ~2 ~ ~ ~2 ~ air replace lotw:wall_of_vines_block");
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
																					new CommandSource(ICommandSource.DUMMY,
																							new Vector3d((x + 0.5), y, (z + 0.5)), Vector2f.ZERO,
																							(ServerWorld) world, 4, "", new StringTextComponent(
																									""),
																							((World) world).getServer(), null).withFeedbackDisabled(),
																					"execute at @e[name=LOTW-basicspell4,limit=2,sort=nearest] run fill ~ ~1 ~ ~ ~1 ~ air replace lotw:wall_of_vines_block");
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
																					((World) world).getServer().getCommandManager()
																							.handleCommand(new CommandSource(ICommandSource.DUMMY,
																									new Vector3d((x + 0.5), y, (z + 0.5)),
																									Vector2f.ZERO, (ServerWorld) world, 4, "",
																									new StringTextComponent(""),
																									((World) world).getServer(), null)
																									.withFeedbackDisabled(),
																									"execute at @e[name=LOTW-basicspell4,limit=2,sort=nearest] run fill ~ ~ ~ ~ ~ ~ air replace lotw:wall_of_vines_block");
																				}
																				MinecraftForge.EVENT_BUS.unregister(this);
																			}
																		}.start(world, (int) 5);
																		MinecraftForge.EVENT_BUS.unregister(this);
																	}
																}.start(world, (int) 5);
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 5);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 5);
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 5);
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 5);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 5);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 5);
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
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), y, (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
											4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"kill @e[name=LOTW-basicspell4,limit=2,sort=nearest]");
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 45);
			} else {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == WallOfVinesBlock.block.asItem()
						&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)).getCount() >= 9) {
					if ((new Object() {
						public Direction getDirection(BlockPos pos) {
							try {
								BlockState _bs = world.getBlockState(pos);
								DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
								if (property != null)
									return _bs.get(property);
								return Direction.getFacingFromAxisDirection(
										_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
										Direction.AxisDirection.POSITIVE);
							} catch (Exception e) {
								return Direction.NORTH;
							}
						}
					}.getDirection(new BlockPos(x, y, z))) == Direction.NORTH || (new Object() {
						public Direction getDirection(BlockPos pos) {
							try {
								BlockState _bs = world.getBlockState(pos);
								DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
								if (property != null)
									return _bs.get(property);
								return Direction.getFacingFromAxisDirection(
										_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
										Direction.AxisDirection.POSITIVE);
							} catch (Exception e) {
								return Direction.NORTH;
							}
						}
					}.getDirection(new BlockPos(x, y, z))) == Direction.SOUTH) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-basicspell4,sort=nearest,limit=1] at @s run tp @s ~ ~ ~ 0 ~");
						}
					} else if ((new Object() {
						public Direction getDirection(BlockPos pos) {
							try {
								BlockState _bs = world.getBlockState(pos);
								DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
								if (property != null)
									return _bs.get(property);
								return Direction.getFacingFromAxisDirection(
										_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
										Direction.AxisDirection.POSITIVE);
							} catch (Exception e) {
								return Direction.NORTH;
							}
						}
					}.getDirection(new BlockPos(x, y, z))) == Direction.WEST || (new Object() {
						public Direction getDirection(BlockPos pos) {
							try {
								BlockState _bs = world.getBlockState(pos);
								DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
								if (property != null)
									return _bs.get(property);
								return Direction.getFacingFromAxisDirection(
										_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
										Direction.AxisDirection.POSITIVE);
							} catch (Exception e) {
								return Direction.NORTH;
							}
						}
					}.getDirection(new BlockPos(x, y, z))) == Direction.EAST) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-basicspell4,sort=nearest,limit=1] at @s run tp @s ~ ~ ~ 90 ~");
						}
					}
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(),
									("execute at @e[name=LOTW-basicspell4,distance=..1,limit=1] run summon armor_stand " + "^1 ^ ^"
											+ " {Tags:[\"LOTW-ally\"],CustomName:'{\"text\":\"LOTW-basicspell4\"}',Invisible:1b,Marker:1b,NoGravity:1b}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(),
									("execute at @e[name=LOTW-basicspell4,distance=..1,limit=1] run summon armor_stand " + "^-1 ^ ^"
											+ " {Tags:[\"LOTW-ally\"],CustomName:'{\"text\":\"LOTW-basicspell4\"}',Invisible:1b,Marker:1b,NoGravity:1b}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(),
									("execute at @e[name=LOTW-basicspell4,distance=..1,limit=1] run summon armor_stand " + "^2 ^ ^"
											+ " {Tags:[\"LOTW-ally\"],CustomName:'{\"text\":\"LOTW-basicspell4\"}',Invisible:1b,Marker:1b,NoGravity:1b}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(),
									("execute at @e[name=LOTW-basicspell4,distance=..1,limit=1] run summon armor_stand " + "^-2 ^ ^"
											+ " {Tags:[\"LOTW-ally\"],CustomName:'{\"text\":\"LOTW-basicspell4\"}',Invisible:1b,Marker:1b,NoGravity:1b}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(),
									("execute at @e[name=LOTW-basicspell4,distance=..1,limit=1] run summon armor_stand " + "^3 ^ ^"
											+ " {Tags:[\"LOTW-ally\"],CustomName:'{\"text\":\"LOTW-basicspell4\"}',Invisible:1b,Marker:1b,NoGravity:1b}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(),
									("execute at @e[name=LOTW-basicspell4,distance=..1,limit=1] run summon armor_stand " + "^-3 ^ ^"
											+ " {Tags:[\"LOTW-ally\"],CustomName:'{\"text\":\"LOTW-basicspell4\"}',Invisible:1b,Marker:1b,NoGravity:1b}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(),
									("execute at @e[name=LOTW-basicspell4,distance=..1,limit=1] run summon armor_stand " + "^4 ^ ^"
											+ " {Tags:[\"LOTW-ally\"],CustomName:'{\"text\":\"LOTW-basicspell4\"}',Invisible:1b,Marker:1b,NoGravity:1b}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(),
									("execute at @e[name=LOTW-basicspell4,distance=..1,limit=1] run summon armor_stand " + "^-4 ^ ^"
											+ " {Tags:[\"LOTW-ally\"],CustomName:'{\"text\":\"LOTW-basicspell4\"}',Invisible:1b,Marker:1b,NoGravity:1b}"));
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-basicspell4,distance=..5] run particle minecraft:totem_of_undying ~ ~3 ~ 1 2 1 0 5 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"clear @p lotw:wall_of_vines 8");
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
										("execute at @e[name=LOTW-basicspell4" + ",distance=..5" + "] run setblock ~ ~" + ""
												+ " ~ lotw:wall_of_vines_block keep"));
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
												new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
														"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
												("execute at @e[name=LOTW-basicspell4" + ",distance=..5" + "] run setblock ~ ~" + "1"
														+ " ~ lotw:wall_of_vines_block keep"));
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
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														("execute at @e[name=LOTW-basicspell4" + ",distance=..5" + "] run setblock ~ ~" + "2"
																+ " ~ lotw:wall_of_vines_block keep"));
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
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																("execute at @e[name=LOTW-basicspell4" + ",distance=..5" + "] run setblock ~ ~" + "3"
																		+ " ~ lotw:wall_of_vines_block keep"));
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
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute at @e[name=LOTW-basicspell4" + ",distance=..5"
																				+ "] run setblock ~ ~" + "4" + " ~ lotw:wall_of_vines_block keep"));
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
																				new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																						Vector2f.ZERO, (ServerWorld) world, 4, "",
																						new StringTextComponent(""), ((World) world).getServer(),
																						null).withFeedbackDisabled(),
																				("execute at @e[name=LOTW-basicspell4" + ",distance=..5"
																						+ "] run setblock ~ ~" + "5"
																						+ " ~ lotw:wall_of_vines_block keep"));
																	}
																	MinecraftForge.EVENT_BUS.unregister(this);
																}
															}.start(world, (int) 5);
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 5);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 5);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 5);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 5);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 5);
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
										("execute at @e[name=LOTW-basicspell4" + ",distance=..5" + "] at @e[name=LOTW-basicspell4,sort=random,limit=1"
												+ ",distance=..5" + "] run setblock ~ ~" + 6 + " ~ lotw:wall_of_vines_block keep"));
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
												new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
														"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
												("execute at @e[name=LOTW-basicspell4" + ",distance=..5"
														+ "] at @e[name=LOTW-basicspell4,sort=random,limit=1" + ",distance=..5"
														+ "] if block ~ ~6 ~ lotw:wall_of_vines_block run setblock ~ ~"
														+ MathHelper.nextInt(new Random(), 6, 7) + " ~ lotw:wall_of_vines_block keep"));
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 5);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 35);
				} else {
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
										("execute at @e[name=LOTW-basicspell4" + ",distance=..1" + "] run setblock ~ ~" + ""
												+ " ~ lotw:wall_of_vines_block keep"));
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
												new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
														"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
												("execute at @e[name=LOTW-basicspell4" + ",distance=..1" + "] run setblock ~ ~" + "1"
														+ " ~ lotw:wall_of_vines_block keep"));
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
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														("execute at @e[name=LOTW-basicspell4" + ",distance=..1" + "] run setblock ~ ~" + "2"
																+ " ~ lotw:wall_of_vines_block keep"));
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
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																("execute at @e[name=LOTW-basicspell4" + ",distance=..1" + "] run setblock ~ ~" + "3"
																		+ " ~ lotw:wall_of_vines_block keep"));
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
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute at @e[name=LOTW-basicspell4" + ",distance=..1"
																				+ "] run setblock ~ ~" + "4" + " ~ lotw:wall_of_vines_block keep"));
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
																				new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																						Vector2f.ZERO, (ServerWorld) world, 4, "",
																						new StringTextComponent(""), ((World) world).getServer(),
																						null).withFeedbackDisabled(),
																				("execute at @e[name=LOTW-basicspell4" + ",distance=..1"
																						+ "] run setblock ~ ~" + "5"
																						+ " ~ lotw:wall_of_vines_block keep"));
																	}
																	MinecraftForge.EVENT_BUS.unregister(this);
																}
															}.start(world, (int) 5);
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 5);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 5);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 5);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 5);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 5);
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-basicspell4,distance=..1] run particle minecraft:totem_of_undying ~ ~3 ~ 1 2 1 0 5 force");
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
										("execute at @e[name=LOTW-basicspell4" + ",distance=..1" + "] at @e[name=LOTW-basicspell4,sort=random,limit=1"
												+ ",distance=..1" + "] run setblock ~ ~" + 6 + " ~ lotw:wall_of_vines_block keep"));
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
												new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
														"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
												("execute at @e[name=LOTW-basicspell4" + ",distance=..1"
														+ "] at @e[name=LOTW-basicspell4,sort=random,limit=1" + ",distance=..1"
														+ "] if block ~ ~6 ~ lotw:wall_of_vines_block run setblock ~ ~"
														+ MathHelper.nextInt(new Random(), 6, 7) + " ~ lotw:wall_of_vines_block keep"));
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 5);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 35);
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-basicspell4] if block ~ ~ ~ air run particle minecraft:totem_of_undying ~ ~3 ~ 1 2 1 0 5 force");
				}
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-basicspell4] run fill ~ ~ ~ ~ ~ ~ air replace lotw:wall_of_vines");
			}
		}
	}
}
