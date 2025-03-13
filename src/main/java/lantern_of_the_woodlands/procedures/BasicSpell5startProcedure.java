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
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;

import lantern_of_the_woodlands.item.WandererItem;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;

public class BasicSpell5startProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure BasicSpell5start!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure BasicSpell5start!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure BasicSpell5start!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure BasicSpell5start!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency entity for procedure BasicSpell5start!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((world.getBlockState(new BlockPos(Math.floor(x) + 0.5, Math.floor(y) + 1, Math.floor(z) + 0.5))).getBlock() == Blocks.AIR
				|| (world.getBlockState(new BlockPos(Math.floor(x) + 0.5, Math.floor(y) + 1, Math.floor(z) + 0.5))).getBlock() == Blocks.VOID_AIR
				|| (world.getBlockState(new BlockPos(Math.floor(x) + 0.5, Math.floor(y) + 1, Math.floor(z) + 0.5))).getBlock() == Blocks.CAVE_AIR) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == WandererItem.block) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY,
									new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.25), (Math.floor(z) + 0.5)), Vector2f.ZERO,
									(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
									.withFeedbackDisabled(),
							"summon armor_stand ~ ~ ~ {CustomName:'{\"text\":\"basicspell5large\"}',NoGravity:1b,Marker:1b,Invisible:1b}");
				}
			} else {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY,
									new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.25), (Math.floor(z) + 0.5)), Vector2f.ZERO,
									(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
									.withFeedbackDisabled(),
							"summon armor_stand ~ ~ ~ {CustomName:'{\"text\":\"basicspell5\"}',NoGravity:1b,Marker:1b,Invisible:1b}");
				}
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY,
								new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)), Vector2f.ZERO, (ServerWorld) world,
								4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"setblock ~ ~ ~ lantern_of_the_woodlands:wanderer_block keep");
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
					if (!entity.isSneaking()) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY,
											new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(),
									"playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(new CommandSource(ICommandSource.DUMMY,
											new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(
													z) + 0.5)),
											Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(),
											"/execute at @e[type=armor_stand,name=placed_lantern] run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(new CommandSource(ICommandSource.DUMMY,
											new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "particle minecraft:portal ~ ~1 ~ 0 0 0 2 100");
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
											"/execute as @e[type=armor_stand,name=placed_lantern] at @s if block ~ ~-0.5 ~ minecraft:iron_bars run summon armor_stand ~ ~-0.5 ~-1 {CustomName:'{\"text\":\"basicspell5portal\"}',NoGravity:1b,Invisible:1b,Marker:1b}");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY,
													new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math
															.floor(z) + 0.5)),
													Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
													((World) world).getServer(), null).withFeedbackDisabled(),
													("/execute if entity @e[type=armor_stand,name=basicspell5,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
															+ x + " " + y + " " + z
															+ " at @e[type=!armor_stand,distance=..3,limit=1] run execute at @e[type=armor_stand,name=placed_lantern] run particle minecraft:flash ~ ~ ~ 0 0 0 0 1 force"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY,
													new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math
															.floor(z) + 0.5)),
													Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
													((World) world).getServer(), null).withFeedbackDisabled(),
													("/execute if entity @e[type=armor_stand,name=basicspell5large,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
															+ x + " " + y + " " + z
															+ " at @e[type=!armor_stand,distance=..10,limit=1] run execute at @e[type=armor_stand,name=placed_lantern] run particle minecraft:flash ~ ~ ~ 0 0 0 0 1 force"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY,
													new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math
															.floor(z) + 0.5)),
													Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
													((World) world).getServer(), null).withFeedbackDisabled(),
													("/execute if entity @e[type=armor_stand,name=basicspell5,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
															+ x + " " + y + " " + z
															+ " at @e[type=!armor_stand,distance=..3] run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..100] ~ ~ ~ 2 0.5 0.025"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY,
													new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math
															.floor(z) + 0.5)),
													Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
													((World) world).getServer(), null).withFeedbackDisabled(),
													("/execute if entity @e[type=armor_stand,name=basicspell5large,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
															+ x + " " + y + " " + z
															+ " at @e[type=!armor_stand,distance=..10] run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..100] ~ ~ ~ 2 0.5 0.025"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY,
													new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math
															.floor(z) + 0.5)),
													Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
													((World) world).getServer(), null).withFeedbackDisabled(),
													("/execute if entity @e[type=armor_stand,name=basicspell5,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
															+ x + " " + y + " " + z
															+ " at @e[type=!armor_stand,distance=..3] run particle minecraft:flash ~ ~0.5 ~ 0 0 0 0 1 force"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY,
													new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math
															.floor(z) + 0.5)),
													Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
													((World) world).getServer(), null).withFeedbackDisabled(),
													("/execute if entity @e[type=armor_stand,name=basicspell5large,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
															+ x + " " + y + " " + z
															+ " at @e[type=!armor_stand,distance=..10] run particle minecraft:flash ~ ~0.5 ~ 0 0 0 0 1 force"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY,
													new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math
															.floor(z) + 0.5)),
													Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
													((World) world).getServer(), null).withFeedbackDisabled(),
													("/execute if entity @e[type=armor_stand,name=basicspell5,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
															+ x + " " + y + " " + z
															+ " at @e[type=!armor_stand,distance=..3] run particle minecraft:campfire_signal_smoke ~ ~0.5 ~ 0.5 0.5 0.5 0.005 20 force"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY,
													new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math
															.floor(z) + 0.5)),
													Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
													((World) world).getServer(), null).withFeedbackDisabled(),
													("/execute if entity @e[type=armor_stand,name=basicspell5large,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
															+ x + " " + y + " " + z
															+ " at @e[type=!armor_stand,distance=..10] run particle minecraft:campfire_signal_smoke ~ ~0.5 ~ 0.5 0.5 0.5 0.005 20 force"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY,
													new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math
															.floor(z) + 0.5)),
													Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
													((World) world).getServer(), null).withFeedbackDisabled(),
													("/execute if entity @e[type=armor_stand,name=basicspell5,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
															+ x + " " + y + " " + z
															+ " run tp @e[type=!armor_stand,name=!basicspell5,name=!placed_lantern,name=!basicspell5large,distance=..3] @e[type=armor_stand,name=basicspell5portal,limit=1]"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager()
											.handleCommand(new CommandSource(ICommandSource.DUMMY,
													new Vector3d(Math.floor(x + 0.5), (Math.floor(y) + 1.5), (Math
															.floor(z) + 0.5)),
													Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
													((World) world).getServer(), null).withFeedbackDisabled(),
													("/execute if entity @e[type=armor_stand,name=basicspell5large,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
															+ x + " " + y + " " + z
															+ " run tp @e[type=!armor_stand,name=!basicspell5,name=!placed_lantern,name=!basicspell5large,distance=..10] @e[type=armor_stand,name=basicspell5portal,limit=1]"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/execute at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run particle minecraft:witch ~ ~0.25 ~ 0 0 0 0.1 20");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/execute at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run playsound minecraft:block.bell.use ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/execute at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run particle minecraft:reverse_portal ~ ~0.25 ~ 0 0 0 0.2 50");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY,
											new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "kill @e[type=armor_stand,name=basicspell5large,distance=..1,limit=1]");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY,
											new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "kill @e[type=armor_stand,name=basicspell5portal,limit=1]");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY,
											new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "kill @e[type=armor_stand,name=basicspell5,distance=..1,limit=1]");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY,
											new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "/fill ~ ~ ~ ~ ~ ~ air replace lantern_of_the_woodlands:wanderer_block");
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 50);
					} else {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY,
											new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(),
									"playsound minecraft:block.portal.ambient ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"/execute at @e[type=armor_stand,name=placed_lantern] run playsound minecraft:block.portal.ambient ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
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
													new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)), Vector2f.ZERO,
													(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
													.withFeedbackDisabled(),
											"playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/execute at @e[type=armor_stand,name=placed_lantern] run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY,
											new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)), Vector2f.ZERO,
											(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null)
											.withFeedbackDisabled(), "particle minecraft:portal ~ ~1 ~ 0 0 0 2 100");
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
													"/execute as @e[type=armor_stand,name=placed_lantern] at @s if block ~ ~-0.5 ~ minecraft:iron_bars run summon armor_stand ~ ~-0.5 ~-1 {CustomName:'{\"text\":\"basicspell5portal\"}',NoGravity:1b,Invisible:1b,Marker:1b}");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager()
													.handleCommand(new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z)
																	+ 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
															("/execute if entity @e[type=armor_stand,name=basicspell5,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
																	+ x + " " + y + " " + z
																	+ " at @e[type=!armor_stand,distance=..3,limit=1] run execute at @e[type=armor_stand,name=placed_lantern] run particle minecraft:flash ~ ~ ~ 0 0 0 0 1 force"));
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager()
													.handleCommand(new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z)
																	+ 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
															("/execute if entity @e[type=armor_stand,name=basicspell5large,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
																	+ x + " " + y + " " + z
																	+ " at @e[type=!armor_stand,distance=..10,limit=1] run execute at @e[type=armor_stand,name=placed_lantern] run particle minecraft:flash ~ ~ ~ 0 0 0 0 1 force"));
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager()
													.handleCommand(new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z)
																	+ 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
															("/execute if entity @e[type=armor_stand,name=basicspell5,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
																	+ x + " " + y + " " + z
																	+ " at @e[type=!armor_stand,distance=..3] run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..100] ~ ~ ~ 2 0.5 0.025"));
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager()
													.handleCommand(new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z)
																	+ 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
															("/execute if entity @e[type=armor_stand,name=basicspell5large,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
																	+ x + " " + y + " " + z
																	+ " at @e[type=!armor_stand,distance=..10] run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..100] ~ ~ ~ 2 0.5 0.025"));
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager()
													.handleCommand(new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z)
																	+ 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
															("/execute if entity @e[type=armor_stand,name=basicspell5,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
																	+ x + " " + y + " " + z
																	+ " at @e[type=!armor_stand,distance=..3] run particle minecraft:flash ~ ~0.5 ~ 0 0 0 0 1 force"));
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager()
													.handleCommand(new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z)
																	+ 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
															("/execute if entity @e[type=armor_stand,name=basicspell5large,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
																	+ x + " " + y + " " + z
																	+ " at @e[type=!armor_stand,distance=..10] run particle minecraft:flash ~ ~0.5 ~ 0 0 0 0 1 force"));
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager()
													.handleCommand(new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z)
																	+ 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
															("/execute if entity @e[type=armor_stand,name=basicspell5,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
																	+ x + " " + y + " " + z
																	+ " at @e[type=!armor_stand,distance=..3] run particle minecraft:campfire_signal_smoke ~ ~0.5 ~ 0.5 0.5 0.5 0.005 20 force"));
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager()
													.handleCommand(new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z)
																	+ 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
															("/execute if entity @e[type=armor_stand,name=basicspell5large,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
																	+ x + " " + y + " " + z
																	+ " at @e[type=!armor_stand,distance=..10] run particle minecraft:campfire_signal_smoke ~ ~0.5 ~ 0.5 0.5 0.5 0.005 20 force"));
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager()
													.handleCommand(new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z)
																	+ 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
															("/execute if entity @e[type=armor_stand,name=basicspell5,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
																	+ x + " " + y + " " + z
																	+ " run tp @e[type=!armor_stand,name=!basicspell5,name=!placed_lantern,name=!basicspell5large,distance=..3] @e[type=armor_stand,name=basicspell5portal,limit=1]"));
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager()
													.handleCommand(new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z)
																	+ 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
															("/execute if entity @e[type=armor_stand,name=basicspell5large,distance=..1] at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run execute positioned "
																	+ x + " " + y + " " + z
																	+ " run tp @e[type=!armor_stand,name=!basicspell5,name=!placed_lantern,name=!basicspell5large,distance=..10] @e[type=armor_stand,name=basicspell5portal,limit=1]"));
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"/execute at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run particle minecraft:witch ~ ~0.25 ~ 0 0 0 0.1 20");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"/execute at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run playsound minecraft:block.bell.use ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"/execute at @e[type=armor_stand,name=placed_lantern] if block ~ ~-0.5 ~ minecraft:iron_bars run particle minecraft:reverse_portal ~ ~0.25 ~ 0 0 0 0.2 50");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
													"kill @e[type=armor_stand,name=basicspell5large,distance=..1,limit=1]");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
													"kill @e[type=armor_stand,name=basicspell5portal,limit=1]");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
													"kill @e[type=armor_stand,name=basicspell5,distance=..1,limit=1]");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY,
															new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 1.5), (Math.floor(z) + 0.5)),
															Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
															((World) world).getServer(), null).withFeedbackDisabled(),
													"/fill ~ ~ ~ ~ ~ ~ air replace lantern_of_the_woodlands:wanderer_block");
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 50);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 150);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 5);
		}
	}
}
