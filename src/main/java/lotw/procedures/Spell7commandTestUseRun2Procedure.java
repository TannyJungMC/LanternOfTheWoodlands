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
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Random;
import java.util.Map;

public class Spell7commandTestUseRun2Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7commandTestUseRun2!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell7commandTestUseRun2!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell7commandTestUseRun2!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell7commandTestUseRun2!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double repeat = 0;
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute as @e[tag=LOTW-enchant_book_choose] at @s run tp @s ~ ~ ~ ~180 0");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("execute at @e[tag=LOTW-enchant_book_choose,nbt={ArmorItems:[{id:\"lotw:spell_book\",Count:1b,tag:{display:{Lore:[\"{\\\"text\\\":\\\""
							+ "" + LotwModVariables.MapVariables.get(world).spell7_test_use
							+ "\\\"}\"]}}},{},{},{}]}] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_use\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
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
							"execute as @e[tag=LOTW-enchant_book_choose] at @s run tp @e[name=LOTW-spell_book_use] @s");
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
									"execute as @e[tag=LOTW-enchant_book_choose] at @s run data modify entity @e[name=LOTW-spell_book_use,limit=1] ArmorItems[3] set from entity @s ArmorItems[3]");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book_choose] at @s run data merge entity @s {ArmorItems:[{},{},{},{id:\"lotw:invisible_block\",Count:1b}]}");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"tag @e[tag=LOTW-enchant_book] remove LOTW-enchant_book_choose");
						}
						LotwModVariables.MapVariables.get(world).spell7_select = (false);
						LotwModVariables.MapVariables.get(world).syncData(world);
						LotwModVariables.MapVariables.get(world).spell7_move = 0;
						LotwModVariables.MapVariables.get(world).syncData(world);
						if (true) {
							if (!("Weather").equals("")) {
								if (("The Peaceful Day").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Heavy Rain").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Thunder Storm").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
									if (true) {
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
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
															"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.firework_rocket.large_blast_far ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
												}
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute at @e[name=LOTW-spell_book_use] run particle flash ~ ~1 ~ 0 0 0 0 1 force");
												}
												LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
														.get(world).spell7_test_use;
												LotwModVariables.MapVariables.get(world).syncData(world);
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 60);
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
														"execute as @e[name=LOTW-spell_book_use] at @s run data merge entity @s {Pose:{Head:[-90f,0f,0f]}}");
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
															if (("The Peaceful Day")
																	.equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
																if (world instanceof ServerWorld) {
																	((World) world).getServer().getCommandManager()
																			.handleCommand(new CommandSource(ICommandSource.DUMMY,
																					new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(), "weather clear");
																}
															} else if (("Heavy Rain")
																	.equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
																if (world instanceof ServerWorld) {
																	((World) world).getServer().getCommandManager()
																			.handleCommand(new CommandSource(ICommandSource.DUMMY,
																					new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(), "weather rain");
																}
															} else if (("Thunder Storm")
																	.equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
																if (world instanceof ServerWorld) {
																	((World) world).getServer().getCommandManager()
																			.handleCommand(new CommandSource(ICommandSource.DUMMY,
																					new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(), "weather thunder");
																}
															}
															LotwModVariables.MapVariables.get(world).spell7_duration = 2;
															LotwModVariables.MapVariables.get(world).syncData(world);
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 60);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 50);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
								}
								if (("Snowstorm").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Strong Wind").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Blizzard").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
									if (true) {
										if (("Blizzard").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @e[name=LOTW-enchant_bookshelf] positioned ^0.75 ^ ^4 run playsound minecraft:block.bell.resonate ambient @a[distance=..100] ~ ~ ~ 2 1 0.025");
											}
										} else {
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:block.bell.resonate ambient @a[distance=..100] ~ ~ ~ 2 1 0.025");
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
												if (("Blizzard").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_use2] run particle flash ~ ~1 ~ 0 0 0 0 1 force");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_use3] run particle flash ~ ~1 ~ 0 0 0 0 1 force");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_circle] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
													}
												} else {
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_use] run particle flash ~ ~1 ~ 0 0 0 0 1 force");
													}
												}
												LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
														.get(world).spell7_test_use;
												LotwModVariables.MapVariables.get(world).syncData(world);
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"execute as @e[name=LOTW-spell_book_use] at @s run data merge entity @s {Pose:{Head:[0f,0f,0f]}}");
										}
										if (("Snowstorm").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-circle_vl_f\"],CustomName:'{\"text\":\"LOTW-spell_book_circle\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
											}
										} else if (("Strong Wind").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-circle_vr_f\"],CustomName:'{\"text\":\"LOTW-spell_book_circle\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:0b}");
											}
										} else {
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @e[name=LOTW-enchant_bookshelf] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-circle_vl_f\"],CustomName:'{\"text\":\"LOTW-spell_book_circle\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @e[name=LOTW-enchant_bookshelf] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-circle_vr_f\"],CustomName:'{\"text\":\"LOTW-spell_book_circle2\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:0b}");
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
												if (("Blizzard").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute as @e[name=LOTW-enchant_bookshelf] at @s run tp @e[name=LOTW-spell_book_circle] ^0.75 ^ ^4 facing ^0.75 ^ ^10");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute as @e[name=LOTW-enchant_bookshelf] at @s run tp @e[name=LOTW-spell_book_circle2] ^0.75 ^-0.75 ^4.5 facing ^0.75 ^-0.75 ^10");
													}
												} else {
													if (("Strong Wind").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute as @e[name=LOTW-spell_book_use] at @s run tp @e[name=LOTW-spell_book_circle] ^ ^-0.75 ^1 facing ^ ^-0.75 ^10");
														}
													} else {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute as @e[name=LOTW-spell_book_use] at @s run tp @e[name=LOTW-spell_book_circle] ^ ^ ^1 facing ^ ^ ^10");
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
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute as @e[name=LOTW-spell_book_circle] at @s run data merge entity @s {ArmorItems:[{},{},{},{id:\"lotw:spell_book_weather_circle\",Count:1b}]}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute as @e[name=LOTW-spell_book_circle2] at @s run data merge entity @s {ArmorItems:[{},{},{},{id:\"lotw:spell_book_weather_circle\",Count:1b}]}");
														}
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 10);
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 30);
									}
								}
								if (("Cloud Manipulation").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
									if (true) {
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
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
															"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.firework_rocket.large_blast_far ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
												}
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute at @e[name=LOTW-spell_book_use] run particle flash ~ ~1 ~ 0 0 0 0 1 force");
												}
												LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
														.get(world).spell7_test_use;
												LotwModVariables.MapVariables.get(world).syncData(world);
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 60);
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
														"execute as @e[name=LOTW-spell_book_use] at @s run data merge entity @s {Pose:{Head:[-90f,0f,0f]}}");
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
																"summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_cloud_center\"}',NoGravity:1b,Marker:1b,Invisible:1b}");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book_cloud\"],CustomName:'{\"text\":\"LOTW-spell_book_cloud\"}',NoGravity:1b,Marker:1b,Invisible:1b}");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ~ ~-1 ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-circle_hl_s\"],CustomName:'{\"text\":\"LOTW-spell_book_circle\"}',ArmorItems:[{},{},{},{id:\"lotw:spell_book_weather_circle\",Count:1b}],NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
													}
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 50);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
								}
								if (("Lightning Bolt").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
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
														"execute at @p[tag=LOTW-user] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_target\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @p[tag=LOTW-user] run tp @e[name=LOTW-spell_book_target] ~ ~1.5 ~ ~ ~");
											}
											for (int index0 = 0; index0 < (int) (100); index0++) {
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_target] at @s if entity @p[tag=LOTW-user,distance=..100] if block ^ ^ ^1 #minecraft:air_blocks unless entity @e[tag=!LOTW-ally,distance=..2] run tp @s ^ ^ ^1");
												}
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute as @e[name=LOTW-spell_book_use] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
											}
											if (true) {
												LotwModVariables.MapVariables.get(world).spell7_book_degree = (-90);
												LotwModVariables.MapVariables.get(world).syncData(world);
												for (int index1 = 0; index1 < (int) (180 / 10); index1++) {
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use2,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use3,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													LotwModVariables.MapVariables.get(
															world).spell7_book_degree = (LotwModVariables.MapVariables.get(world).spell7_book_degree
																	+ 10);
													LotwModVariables.MapVariables.get(world).syncData(world);
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
													if (world.getWorldInfo().isRaining() || world.getWorldInfo().isThundering()) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_target] positioned ~ ~ ~ run summon minecraft:lightning_bolt ~ ~ ~");
														}
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 2 2 0.025");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle minecraft:soul_fire_flame ^ ^ ^0.25 0 0 0 0.1 20 force");
													}
													LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
															.get(world).spell7_test_use;
													LotwModVariables.MapVariables.get(world).syncData(world);
													LotwModVariables.MapVariables.get(world).spell7_duration = 5;
													LotwModVariables.MapVariables.get(world).syncData(world);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 10);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
								}
							}
							if (!("Fire").equals("")) {
								if (("Fireball").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Double Fireballs").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Multiple Fireballs").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
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
														"execute at @p[tag=LOTW-user] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_target\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @p[tag=LOTW-user] run tp @e[name=LOTW-spell_book_target] ~ ~1.5 ~ ~ ~");
											}
											for (int index2 = 0; index2 < (int) (100); index2++) {
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_target] at @s if entity @p[tag=LOTW-user,distance=..100] if block ^ ^ ^1 #minecraft:air_blocks unless entity @e[tag=!LOTW-ally,distance=..2] run tp @s ^ ^ ^1");
												}
											}
											if (("Multiple Fireballs").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
												if (LotwModVariables.MapVariables.get(world).spell7_mode == 1) {
													if (true) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^2 ^ ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^-2 ^ ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^4 ^ ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^-4 ^ ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^6 ^ ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^-6 ^ ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
													}
												} else if (LotwModVariables.MapVariables.get(world).spell7_mode == 2) {
													if (true) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^4 ^ ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^-4 ^ ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^2 ^1 ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^-2 ^1 ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^6 ^1 ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^-6 ^1 ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
													}
												} else if (LotwModVariables.MapVariables.get(world).spell7_mode == 3) {
													if (true) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^6 ^ ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^-6 ^ ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^6 ^3 ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^-6 ^3 ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^6 ^6 ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run summon armor_stand " + "^-6 ^6 ^"
																			+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book\"],CustomName:'{\"text\":\"LOTW-spell_book_multiple\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{id:\"minecraft:glowstone\",Count:1b},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[-45f,0f,0f]},Small:1b}"));
														}
													}
												}
											}
											if (true) {
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_use] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
												}
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_use2] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
												}
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_use3] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
												}
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute as @e[name=LOTW-spell_book_multiple] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
											}
											if (true) {
												LotwModVariables.MapVariables.get(world).spell7_book_degree = (-90);
												LotwModVariables.MapVariables.get(world).syncData(world);
												for (int index3 = 0; index3 < (int) (180 / 10); index3++) {
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use2,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use3,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_multiple,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													LotwModVariables.MapVariables.get(
															world).spell7_book_degree = (LotwModVariables.MapVariables.get(world).spell7_book_degree
																	+ 10);
													LotwModVariables.MapVariables.get(world).syncData(world);
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
													if (true) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_fireball\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b,ArmorItems:[{},{},{},{id:\"lotw:light\",Count:1b}]}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use2] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_fireball\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b,ArmorItems:[{},{},{},{id:\"lotw:light\",Count:1b}]}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use3] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_fireball\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b,ArmorItems:[{},{},{},{id:\"lotw:light\",Count:1b}]}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute as @e[name=LOTW-spell_book_multiple] at @s run data modify entity @s ArmorItems[3] set value {id:\"lotw:spell_book_fire\",Count:1b}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_multiple] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_fireball\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b,ArmorItems:[{},{},{},{id:\"lotw:light\",Count:1b}]}");
														}
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute as @e[name=LOTW-spell_book_fireball] at @s run tp @s ~ ~0.75 ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
													}
													if (true) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.blaze.shoot ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle flame ^ ^ ^0.25 0 0 0 0.025 20 force");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use2] run playsound minecraft:entity.blaze.shoot ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use2] positioned ~ ~0.75 ~ run particle flame ^ ^ ^0.25 0 0 0 0.025 20 force");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use3] run playsound minecraft:entity.blaze.shoot ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use3] positioned ~ ~0.75 ~ run particle flame ^ ^ ^0.25 0 0 0 0.025 20 force");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_multiple] positioned ~ ~0.75 ~ run particle flame ^ ^ ^0.25 0 0 0 0.025 20 force");
														}
													}
													LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
															.get(world).spell7_test_use;
													LotwModVariables.MapVariables.get(world).syncData(world);
													LotwModVariables.MapVariables.get(world).spell7_duration = 5;
													LotwModVariables.MapVariables.get(world).syncData(world);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 10);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
								}
							}
							if (!("Healing").equals("")) {
								if (("Heal").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Advance Heal").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Healing Area").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
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
														"execute as @e[name=LOTW-spell_book_use] at @s run data merge entity @s {Pose:{Head:[-45f,0f,0f]}}");
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute as @e[name=LOTW-spell_book_use2] at @s run data merge entity @s {Pose:{Head:[-45f,0f,0f]}}");
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute as @e[name=LOTW-spell_book_use3] at @s run data merge entity @s {Pose:{Head:[-45f,0f,0f]}}");
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
													if (("Advance Heal").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-enchant_bookshelf] run summon armor_stand ^0.75 ^-1.2 ^4 {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-circle_hr_f\"],CustomName:'{\"text\":\"LOTW-spell_book_circle\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-enchant_bookshelf] run summon armor_stand ^0.75 ^-1 ^4 {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-circle_hl_f\"],CustomName:'{\"text\":\"LOTW-spell_book_circle2\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute as @e[name=LOTW-spell_book_circle] at @s run data merge entity @s {ArmorItems:[{},{},{},{id:\"lotw:spell_book_healing_circle\",Count:1b}]}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute as @e[name=LOTW-spell_book_circle2] at @s run data merge entity @s {ArmorItems:[{},{},{},{id:\"lotw:spell_book_healing_circle\",Count:1b}]}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_circle] run playsound minecraft:entity.evoker.prepare_summon ambient @a[distance=..100] ~ ~0.75 ~ 1 1 0.025");
														}
													} else {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ~ ~-1.2 ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-circle_hr_f\"],CustomName:'{\"text\":\"LOTW-spell_book_circle\"}',ArmorItems:[{},{},{},{id:\"lotw:spell_book_healing_circle\",Count:1b}],NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.evoker.prepare_summon ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
														}
													}
													if (("Heal").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run effect give @e[distance=..4] minecraft:instant_health 1 4 true");
														}
														LotwModVariables.MapVariables.get(world).spell7_duration = 5;
														LotwModVariables.MapVariables.get(world).syncData(world);
													} else if (("Healing Area").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ~ ~-1.75 ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-circle_hl_s\"],CustomName:'{\"text\":\"LOTW-spell_book_circle\"}',ArmorItems:[{},{},{},{id:\"lotw:spell_book_healing_circle\",Count:1b}],NoGravity:1b,Marker:1b,Invisible:1b,Small:0b}");
														}
													} else {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_circle] positioned ~ ~0.75 ~ run effect give @e[distance=..4] minecraft:instant_health 1 9 true");
														}
														LotwModVariables.MapVariables.get(world).spell7_duration = 5;
														LotwModVariables.MapVariables.get(world).syncData(world);
													}
													LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
															.get(world).spell7_test_use;
													LotwModVariables.MapVariables.get(world).syncData(world);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 10);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
								}
							}
							if (!("Ice").equals("")) {
								if (("Cold Zone").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Frozen Zone").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
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
														"execute as @e[name=LOTW-spell_book_use] at @s run data merge entity @s {Pose:{Head:[-45f,0f,0f]}}");
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute as @e[name=LOTW-spell_book_use2] at @s run data merge entity @s {Pose:{Head:[-45f,0f,0f]}}");
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute as @e[name=LOTW-spell_book_use3] at @s run data merge entity @s {Pose:{Head:[-45f,0f,0f]}}");
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
													if (("Cold Zone").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.illusioner.prepare_mirror ambient @a[distance=..100] ~ ~ ~ 2 1.25 0.025");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run particle minecraft:flash ^ ^0.75 ^ 0 0 0 0 1 force");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run particle minecraft:cloud ^ ^0.75 ^ 10 10 10 0.05 200 force");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] at @e[tag=!LOTW-ally,distance=..20] run particle minecraft:cloud ^ ^0.75 ^ 1 1 1 0.05 20 force");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run effect give @e[tag=!LOTW-ally,distance=..20] minecraft:slowness 60 3 true");
														}
													} else {
														if (true) {
															if (world instanceof ServerWorld) {
																((World) world).getServer().getCommandManager()
																		.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																				Vector2f.ZERO, (ServerWorld) world, 4, "",
																				new StringTextComponent(""), ((World) world).getServer(), null)
																				.withFeedbackDisabled(),
																				"execute at @e[name=LOTW-spell_book_use2] run playsound minecraft:entity.illusioner.prepare_mirror ambient @a[distance=..100] ~ ~ ~ 2 1.25 0.025");
															}
															if (world instanceof ServerWorld) {
																((World) world).getServer().getCommandManager()
																		.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																				Vector2f.ZERO, (ServerWorld) world, 4, "",
																				new StringTextComponent(""), ((World) world).getServer(), null)
																				.withFeedbackDisabled(),
																				"execute at @e[name=LOTW-spell_book_use2] run particle minecraft:flash ^ ^0.75 ^ 0 0 0 0 1 force");
															}
															if (world instanceof ServerWorld) {
																((World) world).getServer().getCommandManager()
																		.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																				Vector2f.ZERO, (ServerWorld) world, 4, "",
																				new StringTextComponent(""), ((World) world).getServer(), null)
																				.withFeedbackDisabled(),
																				"execute at @e[name=LOTW-spell_book_use2] run particle minecraft:cloud ^ ^0.75 ^ 10 10 10 0.05 200 force");
															}
															if (world instanceof ServerWorld) {
																((World) world).getServer().getCommandManager()
																		.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																				Vector2f.ZERO, (ServerWorld) world, 4, "",
																				new StringTextComponent(""), ((World) world).getServer(), null)
																				.withFeedbackDisabled(),
																				"execute at @e[name=LOTW-spell_book_use2] at @e[tag=!LOTW-ally,distance=..20] run particle minecraft:cloud ^ ^0.75 ^ 1 1 1 0.05 20 force");
															}
															if (world instanceof ServerWorld) {
																((World) world).getServer().getCommandManager()
																		.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																				Vector2f.ZERO, (ServerWorld) world, 4, "",
																				new StringTextComponent(""), ((World) world).getServer(), null)
																				.withFeedbackDisabled(),
																				"execute at @e[name=LOTW-spell_book_use3] run playsound minecraft:entity.illusioner.prepare_mirror ambient @a[distance=..100] ~ ~ ~ 2 1.25 0.025");
															}
															if (world instanceof ServerWorld) {
																((World) world).getServer().getCommandManager()
																		.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																				Vector2f.ZERO, (ServerWorld) world, 4, "",
																				new StringTextComponent(""), ((World) world).getServer(), null)
																				.withFeedbackDisabled(),
																				"execute at @e[name=LOTW-spell_book_use3] run particle minecraft:flash ^ ^0.75 ^ 0 0 0 0 1 force");
															}
															if (world instanceof ServerWorld) {
																((World) world).getServer().getCommandManager()
																		.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																				Vector2f.ZERO, (ServerWorld) world, 4, "",
																				new StringTextComponent(""), ((World) world).getServer(), null)
																				.withFeedbackDisabled(),
																				"execute at @e[name=LOTW-spell_book_use3] run particle minecraft:cloud ^ ^0.75 ^ 10 10 10 0.05 200 force");
															}
															if (world instanceof ServerWorld) {
																((World) world).getServer().getCommandManager()
																		.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																				Vector2f.ZERO, (ServerWorld) world, 4, "",
																				new StringTextComponent(""), ((World) world).getServer(), null)
																				.withFeedbackDisabled(),
																				"execute at @e[name=LOTW-spell_book_use3] at @e[tag=!LOTW-ally,distance=..20] run particle minecraft:cloud ^ ^0.75 ^ 1 1 1 0.05 20 force");
															}
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use2] run effect give @e[tag=!LOTW-ally,distance=..20] minecraft:slowness 60 5 true");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use3] run effect give @e[tag=!LOTW-ally,distance=..20] minecraft:slowness 60 5 true");
														}
													}
													LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
															.get(world).spell7_test_use;
													LotwModVariables.MapVariables.get(world).syncData(world);
													LotwModVariables.MapVariables.get(world).spell7_duration = 5;
													LotwModVariables.MapVariables.get(world).syncData(world);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 10);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
								}
							}
							if (!("Dark").equals("")) {
								if (("Cursing").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Advance Cursing").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
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
														"execute at @p[tag=LOTW-user] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_target\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @p[tag=LOTW-user] run tp @e[name=LOTW-spell_book_target] ~ ~1.5 ~ ~ ~");
											}
											for (int index4 = 0; index4 < (int) (100); index4++) {
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_target] at @s if entity @p[tag=LOTW-user,distance=..100] if block ^ ^ ^1 #minecraft:air_blocks unless entity @e[tag=!LOTW-ally,distance=..2] run tp @s ^ ^ ^1");
												}
											}
											if (true) {
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_use] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
												}
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_use2] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
												}
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_use3] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
												}
											}
											if (true) {
												LotwModVariables.MapVariables.get(world).spell7_book_degree = (-90);
												LotwModVariables.MapVariables.get(world).syncData(world);
												for (int index5 = 0; index5 < (int) (180 / 10); index5++) {
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use2,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use3,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													LotwModVariables.MapVariables.get(
															world).spell7_book_degree = (LotwModVariables.MapVariables.get(world).spell7_book_degree
																	+ 10);
													LotwModVariables.MapVariables.get(world).syncData(world);
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
													if (true) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_cursing\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b,ArmorItems:[{},{},{},{id:\"lotw:light\",Count:1b}]}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use2] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_cursing\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b,ArmorItems:[{},{},{},{id:\"lotw:light\",Count:1b}]}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use3] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_cursing\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b,ArmorItems:[{},{},{},{id:\"lotw:light\",Count:1b}]}");
														}
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute as @e[name=LOTW-spell_book_cursing] at @s run tp @s ~ ~0.75 ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
													}
													if (true) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.wither.ambient ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle minecraft:dragon_breath ^ ^ ^0.25 0 0 0 0.025 20 force");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use2] run playsound minecraft:entity.wither.ambient ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use2] positioned ~ ~0.75 ~ run particle minecraft:dragon_breath ^ ^ ^0.25 0 0 0 0.025 20 force");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use3] run playsound minecraft:entity.wither.ambient ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use3] positioned ~ ~0.75 ~ run particle minecraft:dragon_breath ^ ^ ^0.25 0 0 0 0.025 20 force");
														}
													}
													for (int index6 = 0; index6 < (int) (100); index6++) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_cursing] run particle minecraft:reverse_portal ~ ~ ~ 0 0 0 0 1 force");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute as @e[name=LOTW-spell_book_cursing] at @s if block ^ ^ ^1 #minecraft:air_blocks unless entity @e[tag=!LOTW-ally,distance=..2] run tp @s ^ ^ ^1 facing entity @e[name=LOTW-spell_book_target,limit=1]");
														}
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_cursing] run particle minecraft:dragon_breath ^ ^0.75 ^ 0 0 0 0.1 50 force");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_cursing] run playsound minecraft:entity.wither.ambient ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025");
													}
													if (("Cursing").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_cursing] as @e[tag=!LOTW-ally,distance=..4] at @s run effect give @s wither 20 0 true");
														}
													} else {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_cursing] as @e[tag=!LOTW-ally,distance=..4] at @s run effect give @s wither 40 0 true");
														}
													}
													LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
															.get(world).spell7_test_use;
													LotwModVariables.MapVariables.get(world).syncData(world);
													LotwModVariables.MapVariables.get(world).spell7_duration = 5;
													LotwModVariables.MapVariables.get(world).syncData(world);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 10);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
								}
							}
							if (!("Holy").equals("")) {
								if (("Antidote").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Cleanse").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
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
														"execute as @e[name=LOTW-spell_book_use] at @s run data merge entity @s {Pose:{Head:[-45f,0f,0f]}}");
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
																"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.evoker.prepare_summon ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ~ ~-1.2 ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-circle_hr_f\"],CustomName:'{\"text\":\"LOTW-spell_book_circle\"}',ArmorItems:[{},{},{},{id:\"lotw:spell_book_holy_circle\",Count:1b}],NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
													}
													if (("Cleanse").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ~ ~-1 ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-circle_hl_f\"],CustomName:'{\"text\":\"LOTW-spell_book_circle\"}',ArmorItems:[{},{},{},{id:\"lotw:spell_book_holy_circle\",Count:1b}],NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
														}
													}
													if (("Antidote").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run effect clear @e[tag=LOTW-ally,distance=..4] minecraft:poison");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run effect clear @e[tag=LOTW-ally,distance=..4] minecraft:wither");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] as @e[tag=LOTW-ally,distance=..4] at @s run data remove entity @s Fire");
														}
													} else {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run effect clear @e[distance=..4]");
														}
													}
													LotwModVariables.MapVariables.get(world).spell7_duration = 5;
													LotwModVariables.MapVariables.get(world).syncData(world);
													LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
															.get(world).spell7_test_use;
													LotwModVariables.MapVariables.get(world).syncData(world);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 10);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
								}
							}
							if (!("Light").equals("")) {
								if (("Uncovering").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
									if (true) {
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~ ~ 2 0.75 0.025");
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
															"execute as @e[name=LOTW-spell_book_use] at @s run data merge entity @s {Pose:{Head:[-90f,0f,0f]}}");
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
																	"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~3.5 ~ 2 1.5 0.025");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run particle firework ~ ~0.75 ~ 0 0 0 0.25 20 force");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run particle flash ~ ~3.5 ~ 0 0 0 0 1 force");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ~ ~3.5 ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_circle\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
														}
														LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
																.get(world).spell7_test_use;
														LotwModVariables.MapVariables.get(world).syncData(world);
														LotwModVariables.MapVariables.get(world).spell7_duration = 5;
														LotwModVariables.MapVariables.get(world).syncData(world);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 50);
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
									}
								}
								if (("Midnight Friend").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Fireflies Dance").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
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
														"execute as @e[name=LOTW-spell_book_use] at @s run data merge entity @s {Pose:{Head:[-90f,0f,0f]}}");
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
																"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.illusioner.prepare_mirror ambient @a[distance=..100] ~ ~ ~ 1 2 0.025");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_use] positioned ~ ~1 ~ run particle dust 1 1 1 20 ~ ~ ~ 0.1 0.1 0.1 0.05 20 force");
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
															if (("Midnight Friend")
																	.equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
																if (world instanceof ServerWorld) {
																	((World) world).getServer().getCommandManager().handleCommand(
																			new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																					Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(),
																			"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run summon bat ^ ^ ^ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],Silent:1b,Invulnerable:1b,PersistenceRequired:1b,CustomName:'{\"text\":\"LOTW-spell_book_firefly\"}',ArmorItems:[{},{},{},{id:\"glowstone\",Count:1b}],DeathLootTable:\"minecraft:empty\",ArmorDropChances:[0f,0f,0f,0.f]}");
																}
															} else {
																for (int index7 = 0; index7 < (int) (20); index7++) {
																	if (world instanceof ServerWorld) {
																		((World) world).getServer().getCommandManager()
																				.handleCommand(new CommandSource(ICommandSource.DUMMY,
																						new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
																						"", new StringTextComponent(
																								""),
																						((World) world).getServer(), null).withFeedbackDisabled(),
																						"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run summon bat ^ ^ ^ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],Silent:1b,Invulnerable:1b,PersistenceRequired:1b,CustomName:'{\"text\":\"LOTW-spell_book_firefly\"}',ArmorItems:[{},{},{},{id:\"glowstone\",Count:1b}],DeathLootTable:\"minecraft:empty\",ArmorDropChances:[0f,0f,0f,0.f]}");
																	}
																}
															}
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 5);
													LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
															.get(world).spell7_test_use;
													LotwModVariables.MapVariables.get(world).syncData(world);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 10);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
								}
							}
							if (!("Adaptive").equals("")) {
								if (("Firework").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Multiple Fireworks").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
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
														"execute at @p[tag=LOTW-user] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_target\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @p[tag=LOTW-user] run tp @e[name=LOTW-spell_book_target] ~ ~1.5 ~ ~ ~");
											}
											for (int index8 = 0; index8 < (int) (100); index8++) {
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_target] at @s if entity @p[tag=LOTW-user,distance=..100] if block ^ ^ ^1 #minecraft:air_blocks unless entity @e[tag=!LOTW-ally,distance=..2] run tp @s ^ ^ ^1");
												}
											}
											if (true) {
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_use] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
												}
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_use2] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
												}
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_use3] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
												}
											}
											if (true) {
												LotwModVariables.MapVariables.get(world).spell7_book_degree = (-90);
												LotwModVariables.MapVariables.get(world).syncData(world);
												for (int index9 = 0; index9 < (int) (180 / 10); index9++) {
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use2,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use3,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_multiple,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													LotwModVariables.MapVariables.get(
															world).spell7_book_degree = (LotwModVariables.MapVariables.get(world).spell7_book_degree
																	+ 10);
													LotwModVariables.MapVariables.get(world).syncData(world);
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
													if (("Firework").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ~ ~0.75 ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_firework\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b,ArmorItems:[{},{},{},{id:\"lotw:light\",Count:1b}]}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] as @e[name=LOTW-spell_book_firework,distance=..3] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.firework_rocket.launch ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	("execute at @e[name=LOTW-spell_book_use] run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~ ~ 0.5 "
																			+ MathHelper.nextDouble(new Random(), 0, 2) + " 0.025"));
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle firework ^ ^ ^0.25 0 0 0 0.1 20 force");
														}
														LotwModVariables.MapVariables.get(world).spell7_duration = 5;
														LotwModVariables.MapVariables.get(world).syncData(world);
													} else {
														LotwModVariables.MapVariables.get(world).spell7_duration = 4;
														LotwModVariables.MapVariables.get(world).syncData(world);
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute as @e[name=LOTW-spell_book_use] at @s run data modify entity @s HandItems[0] set value {id:\"lotw:light\",Count:1b}");
													}
													LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
															.get(world).spell7_test_use;
													LotwModVariables.MapVariables.get(world).syncData(world);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 10);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
								}
							}
							if (!("Wind").equals("")) {
								if (("Wind Knockback").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
										|| ("Wind Cutter").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
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
														"execute at @p[tag=LOTW-user] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_target\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @p[tag=LOTW-user] run tp @e[name=LOTW-spell_book_target] ~ ~1.5 ~ ~ ~");
											}
											for (int index10 = 0; index10 < (int) (100); index10++) {
												if (world instanceof ServerWorld) {
													((World) world).getServer().getCommandManager().handleCommand(
															new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																	(ServerWorld) world, 4, "", new StringTextComponent(""),
																	((World) world).getServer(), null).withFeedbackDisabled(),
															"execute as @e[name=LOTW-spell_book_target] at @s if entity @p[tag=LOTW-user,distance=..100] if block ^ ^ ^1 #minecraft:air_blocks run tp @s ^ ^ ^1");
												}
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute as @e[name=LOTW-spell_book_use] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
											}
											if (true) {
												LotwModVariables.MapVariables.get(world).spell7_book_degree = (-90);
												LotwModVariables.MapVariables.get(world).syncData(world);
												for (int index11 = 0; index11 < (int) (180 / 10); index11++) {
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use2,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_use3,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager()
																.handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		("execute as @e[name=LOTW-spell_book_multiple,x_rotation="
																				+ (LotwModVariables.MapVariables.get(world).spell7_book_degree + ".."
																						+ (LotwModVariables.MapVariables.get(world).spell7_book_degree
																								+ 10))
																				+ "] at @s run data merge entity @s {Pose:{Head:["
																				+ LotwModVariables.MapVariables.get(world).spell7_book_degree
																				+ "f,0f,0f]}}"));
													}
													LotwModVariables.MapVariables.get(
															world).spell7_book_degree = (LotwModVariables.MapVariables.get(world).spell7_book_degree
																	+ 10);
													LotwModVariables.MapVariables.get(world).syncData(world);
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
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_wind\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b}");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute as @e[name=LOTW-spell_book_wind] at @s run tp @s ~ ~0.75 ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
													}
													if (("Wind Knockback").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:item.trident.riptide_3 ambient @a[distance=..100] ~ ~ ~ 1 0 0.025");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.firework_rocket.large_blast ambient @a[distance=..100] ~ ~ ~ 1 0.75 0.025");
														}
													} else {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:item.trident.riptide_3 ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:item.trident.throw ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
														}
													}
													LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
															.get(world).spell7_test_use;
													LotwModVariables.MapVariables.get(world).syncData(world);
													LotwModVariables.MapVariables.get(world).spell7_duration = 5;
													LotwModVariables.MapVariables.get(world).syncData(world);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 10);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
								}
							}
							if (!("Teleportation").equals("")) {
								if (("Return").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
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
														"execute as @e[name=LOTW-spell_book_use] at @s run data merge entity @s {Pose:{Head:[0f,0f,0f]}}");
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:block.bell.resonate ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @p[tag=LOTW-user] run playsound minecraft:block.bell.resonate ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
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
																"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle minecraft:portal ^ ^ ^1 0 0 0 3 50 force");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @p[tag=LOTW-user] run particle minecraft:portal ~ ~0.5 ~ 0 0 0 3 50 force");
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
															if (true) {
																if (world instanceof ServerWorld) {
																	((World) world).getServer().getCommandManager().handleCommand(
																			new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																					Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(),
																			"execute at @p[tag=LOTW-user] run particle flash ~ ~ ~ 0 0 0 0 1 force");
																}
																if (world instanceof ServerWorld) {
																	((World) world).getServer().getCommandManager().handleCommand(
																			new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																					Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(),
																			"execute at @p[tag=LOTW-user] run particle campfire_signal_smoke ~ ~ ~ 0.5 0.5 0.5 0.005 20 force");
																}
																if (world instanceof ServerWorld) {
																	((World) world).getServer().getCommandManager().handleCommand(
																			new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																					Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(),
																			("execute at @p[tag=LOTW-user] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 2 "
																					+ MathHelper.nextDouble(new Random(), 0.5, 2) + " 0.025"));
																}
																if (world instanceof ServerWorld) {
																	((World) world).getServer().getCommandManager().handleCommand(
																			new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																					Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(),
																			"execute at @p[tag=LOTW-user] run playsound minecraft:block.bell.use ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
																}
															}
															if (world instanceof ServerWorld) {
																((World) world).getServer().getCommandManager()
																		.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																				Vector2f.ZERO, (ServerWorld) world, 4, "",
																				new StringTextComponent(""), ((World) world).getServer(), null)
																				.withFeedbackDisabled(),
																				"execute unless entity @e[name=LOTW-placed_lantern] at @e[name=LOTW-spell_book_use] run tp @e[tag=LOTW-enchant] ^ ^ ^1");
															}
															if (world instanceof ServerWorld) {
																((World) world).getServer().getCommandManager()
																		.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																				Vector2f.ZERO, (ServerWorld) world, 4, "",
																				new StringTextComponent(""), ((World) world).getServer(), null)
																				.withFeedbackDisabled(),
																				"execute at @e[name=LOTW-spell_book_use] run tp @p[tag=LOTW-user] ^ ^ ^1");
															}
															if (true) {
																if (world instanceof ServerWorld) {
																	((World) world).getServer().getCommandManager().handleCommand(
																			new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																					Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(),
																			"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle flash ^ ^ ^1 0 0 0 0 1 force");
																}
																if (world instanceof ServerWorld) {
																	((World) world).getServer().getCommandManager().handleCommand(
																			new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																					Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(),
																			"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle campfire_signal_smoke ^ ^ ^1 0.5 0.5 0.5 0.005 20 force");
																}
																if (world instanceof ServerWorld) {
																	((World) world).getServer().getCommandManager().handleCommand(
																			new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																					Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(),
																			"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle minecraft:reverse_portal ^ ^ ^1 0 0 0 0.5 50 force");
																}
																if (world instanceof ServerWorld) {
																	((World) world).getServer().getCommandManager().handleCommand(
																			new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																					Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(),
																			("execute at @e[name=LOTW-spell_book_use] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 2 "
																					+ MathHelper.nextDouble(new Random(), 0.5, 2) + " 0.025"));
																}
																if (world instanceof ServerWorld) {
																	((World) world).getServer().getCommandManager().handleCommand(
																			new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
																					Vector2f.ZERO, (ServerWorld) world, 4, "",
																					new StringTextComponent(""), ((World) world).getServer(), null)
																					.withFeedbackDisabled(),
																			"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:block.bell.use ambient @a[distance=..100] ~ ~0.75 ~ 2 0 0.025");
																}
															}
															LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
																	.get(world).spell7_test_use;
															LotwModVariables.MapVariables.get(world).syncData(world);
															LotwModVariables.MapVariables.get(world).spell7_duration = 5;
															LotwModVariables.MapVariables.get(world).syncData(world);
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 50);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 30);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
								}
								if (("Time Travelling").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
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
														"execute as @e[name=LOTW-spell_book_use] at @s run data merge entity @s {Pose:{Head:[0f,0f,0f]}}");
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
																"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.illusioner.prepare_blindness ambient @a[distance=..100] ~ ~1.5 ~ 2 0 0.025");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @p[tag=LOTW-user] run playsound minecraft:entity.illusioner.prepare_blindness ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:block.ender_chest.open ambient @a[distance=..100] ~ ~1.5 ~ 2 0 0.025");
													}
													if (world instanceof ServerWorld) {
														((World) world).getServer().getCommandManager().handleCommand(
																new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																		(ServerWorld) world, 4, "", new StringTextComponent(""),
																		((World) world).getServer(), null).withFeedbackDisabled(),
																"execute at @p[tag=LOTW-user] run playsound minecraft:block.ender_chest.open ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
													}
													if (true) {
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ^ ^-1.95 ^5 {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book_circle\"],CustomName:'{\"text\":\"LOTW-spell_book_circle\"}',ArmorItems:[{},{},{},{id:\"lotw:spell_book_teleportation_circle\",Count:1b}],NoGravity:1b,Marker:1b,Invisible:1b,Small:0b,Rotation:[179.5f]}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ^ ^-1.9 ^5 {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book_circle2\"],CustomName:'{\"text\":\"LOTW-spell_book_circle2\"}',ArmorItems:[{},{},{},{id:\"lotw:spell_book_teleportation_circle_2\",Count:1b}],NoGravity:1b,Marker:1b,Invisible:1b,Small:0b,Rotation:[174f]}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @p[tag=LOTW-user] run summon armor_stand ~ ~-1.4 ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book_circle\"],CustomName:'{\"text\":\"LOTW-spell_book_circle3\"}',ArmorItems:[{},{},{},{id:\"lotw:spell_book_teleportation_circle\",Count:1b}],NoGravity:1b,Marker:1b,Invisible:1b,Small:0b,Rotation:[180.5f]}");
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	"execute at @p[tag=LOTW-user] run summon armor_stand ~ ~-1.35 ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book_circle2\"],CustomName:'{\"text\":\"LOTW-spell_book_circle4\"}',ArmorItems:[{},{},{},{id:\"lotw:spell_book_teleportation_circle_2\",Count:1b}],NoGravity:1b,Marker:1b,Invisible:1b,Small:0b,Rotation:[186f]}");
														}
													}
													LotwModVariables.MapVariables.get(world).spell7_use = LotwModVariables.MapVariables
															.get(world).spell7_test_use;
													LotwModVariables.MapVariables.get(world).syncData(world);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 10);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
								}
							}
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 2);
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 3);
	}
}
