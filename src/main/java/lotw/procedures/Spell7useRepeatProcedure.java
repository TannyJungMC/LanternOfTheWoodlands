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

public class Spell7useRepeatProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7useRepeat!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell7useRepeat!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell7useRepeat!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell7useRepeat!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double temporary_number = 0;
		if (true) {
			if (!("Weather").equals("")) {
				if (("The Peaceful Day").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
						|| ("Heavy Rain").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
						|| ("Thunder Storm").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
					if (!("").equals("Particle")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] run particle minecraft:soul_fire_flame ^ ^0.75 ^ 0 0 0 0.025 1 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] run particle minecraft:soul_fire_flame ^ ^1 ^ 0 1 0 5 0 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] run particle minecraft:soul_fire_flame ^ ^1 ^ 0 1 0 3 0 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] run particle minecraft:soul_fire_flame ^ ^1 ^ 0 1 0 1 0 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] run particle minecraft:soul_fire_flame ^ ^1 ^ 0 1 0 0.5 0 force");
						}
					}
					if (!("").equals("Sound")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:block.beacon.deactivate ambient @a[distance=..100] ~ ~ ~ 0.25 1.75 0.025");
						}
					}
				}
				if (("Snowstorm").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
						|| ("Blizzard").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
						|| ("Strong Wind").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
					if (!("").equals("Summon")) {
						if (LotwModVariables.MapVariables.get(world).spell7_mode == 1) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_circle] unless entity @e[name=LOTW-spell_book_wind,distance=..8] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_wind\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:0b}");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_circle] run tp @e[name=LOTW-spell_book_wind,distance=..0.01] ~ ~ ~ ~ ~");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[name=LOTW-spell_book_circle] run tp @e[name=LOTW-spell_book_wind,distance=..0.01] ^"
												+ MathHelper.nextDouble(new Random(), -4, 4) + " ^" + MathHelper.nextDouble(new Random(), -4, 4)
												+ " ^" + MathHelper.nextDouble(new Random(), 1, 10)));
							}
						} else if (LotwModVariables.MapVariables.get(world).spell7_mode == 2) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[name=LOTW-spell_book_circle] unless entity @e[name=LOTW-spell_book_wind,distance=..8] run summon armor_stand ^"
												+ MathHelper.nextDouble(new Random(), -4, 4) + " ^" + MathHelper.nextDouble(new Random(), -4, 4)
												+ " ^" + MathHelper.nextDouble(new Random(), 1, 10)
												+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_wind\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:0b}"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[name=LOTW-spell_book_wind] at @s facing entity @e[name=LOTW-spell_book_circle,limit=1] feet run tp @s ~ ~ ~ facing ^ ^ ^-100");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[name=LOTW-spell_book_wind] at @s run tp @s ~ ~ ~ ~ 0");
							}
						} else if (LotwModVariables.MapVariables.get(world).spell7_mode == 3) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[name=LOTW-spell_book_circle] unless entity @e[name=LOTW-spell_book_wind,distance=..8] run summon armor_stand ^"
												+ MathHelper.nextDouble(new Random(), -4, 4) + " ^" + MathHelper.nextDouble(new Random(), -4, 4)
												+ " ^" + MathHelper.nextDouble(new Random(), 1, 10)
												+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_wind\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:0b}"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[name=LOTW-spell_book_wind] at @s facing entity @e[name=LOTW-spell_book_circle,limit=1] feet run tp @s ~ ~ ~ facing ^ ^ ^-100");
							}
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-spell_book_wind] at @s unless entity @e[name=LOTW-spell_book_circle,distance=..200] run kill @s");
					}
					for (int index0 = 0; index0 < (int) (5); index0++) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_wind] at @s unless block ~ ~ ~ #minecraft:air_blocks run kill @s");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_wind] at @s run tp @s ^ ^ ^1");
						}
						if (!("").equals("Particle")) {
							if (("Blizzard").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[name=LOTW-spell_book_wind] run particle minecraft:white_ash ~ ~ ~ 1 1 1 0 1 force");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[name=LOTW-spell_book_wind] run particle cloud ~ ~ ~ 0.5 0.5 0.5 0.01 1 force");
								}
							} else if (("Strong Wind").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[name=LOTW-spell_book_wind] run particle sweep_attack ~ ~ ~ 0.5 0.5 0.5 1 1 force");
								}
							} else if (("Snowstorm").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[name=LOTW-spell_book_wind] run particle minecraft:white_ash ~ ~ ~ 1 1 1 0 1 force");
								}
							}
						}
						if (!("").equals("Effect")) {
							if (("Strong Wind").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
									|| ("Blizzard").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											("execute at @e[name=LOTW-spell_book_wind] if block ~ ~ ~ #minecraft:air_blocks positioned ^ ^ ^-1 as "
													+ "@e[type=!armor_stand,nbt=!{NoGravity:1b},distance=..2]"
													+ " at @s facing entity @e[name=LOTW-spell_book_wind,limit=1,sort=nearest] feet run tp @s ^ ^ ^1"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[name=LOTW-spell_book_wind] run effect give @e[tag=!LOTW-enchant,distance=..2] minecraft:slow_falling 1 0 true");
								}
							}
							if (("Snowstorm").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
									|| ("Blizzard").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[name=LOTW-spell_book_wind] run effect give @e[tag=!LOTW-ally,distance=..2] slowness 10 3 true");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[name=LOTW-spell_book_wind,limit=5,sort=random] unless block ~ ~-1 ~ #minecraft:air_blocks unless block ~ ~-1 ~ snow unless block ~ ~ ~ snow run setblock ~ ~ ~ snow keep");
								}
								if (("Blizzard").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
									if (world instanceof ServerWorld) {
										((World) world).getServer().getCommandManager().handleCommand(
												new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
														"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
												"execute at @e[name=LOTW-spell_book_wind,limit=5,sort=random] if block ~ ~-1 ~ water[level=0] if block ~ ~ ~ #minecraft:air_blocks unless block ~ ~ ~ water[level=0] run setblock ~ ~-1 ~ ice");
									}
									if (world instanceof ServerWorld) {
										((World) world).getServer().getCommandManager().handleCommand(
												new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
														"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
												"execute at @e[name=LOTW-spell_book_wind,limit=5,sort=random] run fill ~1 ~1 ~1 ~-1 ~-1 ~-1 air replace fire");
									}
									if (true) {
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"execute at @e[name=LOTW-spell_book_wind,limit=3,sort=random] unless block ^1 ^ ^ #minecraft:air_blocks unless block ^1 ^ ^ ice run setblock ~ ~ ~ ice keep");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"execute at @e[name=LOTW-spell_book_wind,limit=3,sort=random] unless block ^-1 ^ ^ #minecraft:air_blocks unless block ^-1 ^ ^ ice run setblock ~ ~ ~ ice keep");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"execute at @e[name=LOTW-spell_book_wind,limit=3,sort=random] unless block ^ ^ ^1 #minecraft:air_blocks unless block ^ ^ ^1 ice run setblock ~ ~ ~ ice keep");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"execute at @e[name=LOTW-spell_book_wind,limit=3,sort=random] unless block ^ ^ ^-1 #minecraft:air_blocks unless block ^ ^ ^-1 ice run setblock ~ ~ ~ ice keep");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"execute as @e[name=LOTW-spell_book_wind] at @s if block ~ ~ ~ ice run tp @s ^ ^ ^1");
										}
										for (int index1 = 0; index1 < (int) (MathHelper.nextInt(new Random(), 0, 5)); index1++) {
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute at @e[name=LOTW-spell_book_wind] if block ^ ^ ^-1 ice run setblock ~ ~ ~ ice keep");
											}
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"execute as @e[name=LOTW-spell_book_wind] at @s if block ~ ~ ~ ice run tp @s ^ ^ ^1");
											}
										}
									}
								}
							}
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle minecraft:firework ^ ^ ^0.25 0 0 0 0.1 1 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-spell_book_use2] positioned ~ ~0.75 ~ run particle minecraft:firework ^ ^ ^0.25 0 0 0 0.1 1 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-spell_book_use3] positioned ~ ~0.75 ~ run particle minecraft:firework ^ ^ ^0.25 0 0 0 0.1 1 force");
					}
					if (!("").equals("Sound")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.skeleton_horse.death ambient @a[distance=..100] ~ ~ ~ 0.05 1 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use2] run playsound minecraft:entity.skeleton_horse.death ambient @a[distance=..100] ~ ~ ~ 0.05 1 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use3] run playsound minecraft:entity.skeleton_horse.death ambient @a[distance=..100] ~ ~ ~ 0.05 1 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_wind,limit=1,sort=random] run playsound minecraft:entity.skeleton_horse.ambient ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025");
						}
						if (!("Snowstorm").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_wind,limit=1,sort=random] run playsound minecraft:entity.vex.charge ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025");
							}
						}
					}
				}
				if (("Cloud Manipulation").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-spell_book_cloud_center] at @s run tp @s ~ ~ ~ ~0.1 ~");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-spell_book_cloud_center] run tp @e[name=LOTW-spell_book_cloud] ~ ~20 ~");
					}
					if (LotwModVariables.MapVariables.get(world).spell7_mode != 3) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_cloud_center] at @s run tp @s ^ ^ ^0.1 facing entity @p[tag=LOTW-user]");
						}
					}
					if (!("").equals("Summon")) {
						if (LotwModVariables.MapVariables.get(world).spell7_mode != 1) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[tag=LOTW-spell_book_cloud] unless entity @e[name=LOTW-spell_book_cloud_rain,distance=..5] run summon armor_stand ~"
												+ MathHelper.nextDouble(new Random(), -3, 3) + " ~ ~" + MathHelper.nextDouble(new Random(), -3, 3)
												+ " {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_cloud_rain\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b,ArmorItems:[{},{},{},{id:\"lotw:light\",Count:1b}]}"));
							}
						}
					}
					if (!("").equals("Particle")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] run particle minecraft:soul_fire_flame ~ ~0.85 ~ 0 1 0 0.1 0 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] run particle minecraft:instant_effect ~ ~ ~ 1.5 0 1.5 0 1 force");
						}
						if (LotwModVariables.MapVariables.get(world).spell7_mode == 1) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_cloud] run particle minecraft:dust 1 1 1 20 ~ ~ ~ 2 0.5 2 0 50 force");
							}
						} else {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_cloud] run particle minecraft:dust 0.425 0.45 0.5 20 ~ ~ ~ 2 0.5 2 0 50 force");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_cloud] run particle minecraft:falling_water ~ ~ ~ 1.5 0.5 1.5 0 10 force");
							}
						}
					}
					if (!("").equals("Sound")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:block.beacon.ambient ambient @a[distance=..100] ~ ~ ~ 0.25 2 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_cloud_rain] unless block ~ ~ ~ #minecraft:air_blocks run playsound minecraft:weather.rain ambient @a[distance=..100] ~ ~ ~ 0.25 1 0.025");
						}
					}
					if (!("").equals("Effect")) {
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_cloud_rain] at @e[type=!armor_stand,distance=..1] run setblock ~ ~ ~ water[level=1] keep");
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
												"execute at @e[name=LOTW-spell_book_cloud_rain] at @e[type=!armor_stand,distance=..1] run fill ~ ~ ~ ~ ~ ~ air replace water[level=1]");
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 1);
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_cloud_rain] if block ~ ~ ~ lava run playsound minecraft:block.fire.extinguish ambient @a[distance=..100] ~ ~ ~ 0.5 1 0.025");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_cloud_rain] if block ~ ~ ~ lava run particle smoke ~ ~1 ~ 0.1 0.1 0.1 0 5 force");
							}
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_cloud_rain] run fill ~ ~ ~ ~ ~ ~ cauldron[level=3] replace cauldron[level=2]");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_cloud_rain] run fill ~ ~ ~ ~ ~ ~ cauldron[level=2] replace cauldron[level=1]");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_cloud_rain] run fill ~ ~ ~ ~ ~ ~ cauldron[level=1] replace cauldron[level=0]");
							}
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_cloud_rain] if block ~ ~ ~ fire run playsound minecraft:block.fire.extinguish ambient @a[distance=..100] ~ ~ ~ 0.5 1 0.025");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_cloud_rain] if block ~ ~ ~ lava run particle large_smoke ~ ~ ~ 0.1 0.1 0.1 0 5 force");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_cloud_rain] run fill ~ ~ ~ ~ ~ ~ air replace fire");
							}
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-spell_book_cloud_rain] at @s unless block ~ ~ ~ #minecraft:air_blocks run kill @s");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-spell_book_cloud_rain] at @s if block ~ ~ ~ #minecraft:air_blocks run tp @s ~ ~-1 ~");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-spell_book_cloud_rain] at @s unless entity @e[tag=LOTW-spell_book_cloud,distance=..100] run kill @s");
					}
				}
			}
			if (!("Fire").equals("")) {
				if (("Fireball").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
						|| ("Multiple Fireballs").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
						|| ("Double Fireballs").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
					if (!("").equals("Summon")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_fireball] at @s if block ^ ^ ^1 #minecraft:air_blocks unless entity @e[tag=!LOTW-ally,distance=..2] run tp @s ^ ^ ^1 facing entity @e[name=LOTW-spell_book_target,limit=1]");
						}
					}
					if (!("").equals("Particle")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_fireball] run particle minecraft:flame ^ ^ ^ 0.05 0.05 0.05 0.01 3 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_fireball] if entity @e[name=LOTW-spell_book_target,distance=..1] run particle flame ~ ~ ~ 1 1 1 0.01 10 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_fireball] if entity @e[tag=!LOTW-ally,distance=..4] run particle flame ~ ~ ~ 1 1 1 0.01 10 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_fireball] unless block ^ ^ ^1 #air_blocks run particle flame ~ ~ ~ 1 1 1 0.01 10 force");
						}
					}
					if (!("").equals("Sound")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_fireball,limit=1,sort=random] run playsound minecraft:block.fire.ambient ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_fireball] if entity @e[name=LOTW-spell_book_target,distance=..1] run playsound minecraft:entity.blaze.shoot ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_fireball] if entity @e[tag=!LOTW-ally,distance=..4] run playsound minecraft:entity.blaze.shoot ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_fireball] unless block ^ ^ ^1 #air_blocks run playsound minecraft:entity.blaze.shoot ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
						}
					}
					if (!("").equals("Effect")) {
						if (("Double Fireballs").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_fireball] as @e[tag=!LOTW-ally,distance=..4] at @s run data merge entity @s {Fire:400s}");
							}
						} else {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_fireball] as @e[tag=!LOTW-ally,distance=..4] at @s run data merge entity @s {Fire:200s}");
							}
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-spell_book_fireball] at @s if entity @e[name=LOTW-spell_book_target,distance=..1] run kill @s");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-spell_book_fireball] at @s if entity @e[tag=!LOTW-ally,distance=..4] run kill @s");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-spell_book_fireball] at @s unless block ^ ^ ^1 #air_blocks run kill @s");
					}
				}
			}
			if (!("Healing").equals("")) {
				if (("Heal").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
						|| ("Advance Heal").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
						|| ("Healing Area").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
					if (!("").equals("Particle")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle minecraft:instant_effect ^ ^ ^0.25 0 0 0 1 1 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use2] positioned ~ ~0.75 ~ run particle minecraft:instant_effect ^ ^ ^0.25 0 0 0 1 1 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use3] positioned ~ ~0.75 ~ run particle minecraft:instant_effect ^ ^ ^0.25 0 0 0 1 1 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_circle] run particle minecraft:composter ~ ~0.75 ~ 2 0 2 0 1 force");
						}
					}
					if (!("").equals("Sound")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_circle] run playsound minecraft:block.beacon.ambient ambient @a[distance=..100] ~ ~0.75 ~ 0.1 2 0.025");
						}
					}
					if (("Healing Area").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
						if (!("").equals("Effect")) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_use] as @e[tag=LOTW-ally,distance=..4] at @s unless data entity @s ActiveEffects[{Id:10b}] run effect give @s minecraft:regeneration 1 2 true");
							}
						}
					}
				}
			}
			if (!("Holy").equals("")) {
				if (("Antidote").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
						|| ("Cleanse").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
					if (!("").equals("Particle")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle minecraft:instant_effect ^ ^ ^0.25 0 0 0 1 1 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_circle] run particle minecraft:effect ~ ~0.75 ~ 2 0 2 0 1 force");
						}
					}
					if (!("").equals("Sound")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_circle] run playsound minecraft:block.beacon.ambient ambient @a[distance=..100] ~ ~0.75 ~ 0.1 1.75 0.025");
						}
					}
				}
			}
			if (!("Light").equals("")) {
				if (("Uncovering").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_circle] at @s run tp @s ~ ~ ~ ~ 90");
						}
						for (int index2 = 0; index2 < (int) (8); index2++) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-spell_book_circle] at @s run tp @s ~ ~ ~ ~ ~" + (-22.5)));
							}
							for (int index3 = 0; index3 < (int) (8); index3++) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											("execute as @e[name=LOTW-spell_book_circle] at @s run tp @s ~ ~ ~ ~" + 45 + " ~"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											("execute at @e[name=LOTW-spell_book_circle] run particle end_rod ^ ^ ^"
													+ LotwModVariables.MapVariables.get(world).spell7_temporary_number + " 0 0 0 0 1 force"));
								}
							}
						}
					}
					if (!("").equals("Effect")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run effect give @e[type=!armor_stand,distance="
											+ LotwModVariables.MapVariables.get(world).spell7_temporary_number + ".."
											+ (LotwModVariables.MapVariables.get(world).spell7_temporary_number + 1)
											+ "] minecraft:glowing 3 1 true"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ as @e[type=!armor_stand,distance="
											+ LotwModVariables.MapVariables.get(world).spell7_temporary_number + ".."
											+ (LotwModVariables.MapVariables.get(world).spell7_temporary_number + 1)
											+ ",nbt={ActiveEffects:[{Id:14b}]}] at @s run effect give @s minecraft:glowing 60 1 true"));
						}
					}
					if (!("").equals("Particle")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] run particle minecraft:instant_effect ~ ~0.75 ~ 0 0 0 1 1 force");
						}
					}
					LotwModVariables.MapVariables
							.get(world).spell7_temporary_number = (LotwModVariables.MapVariables.get(world).spell7_temporary_number + 1);
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (("Midnight Friend").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
						|| ("Fireflies Dance").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
					if (!("").equals("Effect")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"effect give @e[name=LOTW-spell_book_firefly] minecraft:invisibility 1000000 1 true");
						}
						if (LotwModVariables.MapVariables.get(world).spell7_mode == 3) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[name=LOTW-spell_book_firefly] at @s run data modify entity @s NoAI set value 1");
							}
						} else {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[name=LOTW-spell_book_firefly] at @s run data modify entity @s NoAI set value 0");
							}
							if (LotwModVariables.MapVariables.get(world).spell7_mode == 1) {
								temporary_number = 5;
							} else if (LotwModVariables.MapVariables.get(world).spell7_mode == 2) {
								temporary_number = 100;
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-spell_book_firefly] at @s unless entity @p[tag=LOTW-user,distance=.."
												+ temporary_number + "] facing entity @p[tag=LOTW-user] feet run tp @s ^ ^ ^0.5"));
							}
						}
					}
					if (!("").equals("Particle")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle dust 1 1 1 1 ^ ^ ^ 0 0 0 0 1 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_firefly] run particle dust 1 1 1 1 ~ ~ ~ 0 0 0 0 1 force");
						}
					}
					if (!("").equals("Sound")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.player.breath ambient @a[distance=..100] ~ ~0.75 ~ 0.05 0 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_firefly,limit=3,sort=random] run playsound minecraft:entity.vex.hurt ambient @a[distance=..100] ~ ~0.75 ~ 0.05 0 0.025");
						}
					}
				}
			}
			if (!("Adaptive").equals("")) {
				if (("Firework").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
						|| ("Multiple Fireworks").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
					if (("Multiple Fireworks").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
						if (LotwModVariables.MapVariables.get(world).spell7_duration == 1) {
							LotwModVariables.MapVariables.get(world).spell7_duration = (MathHelper.nextInt(new Random(), 2, 4));
							LotwModVariables.MapVariables.get(world).syncData(world);
							for (int index4 = 0; index4 < (int) (MathHelper.nextInt(new Random(), 1, 3)); index4++) {
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
													"execute at @e[name=LOTW-spell_book_use] run summon armor_stand ~ ~0.75 ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-spell_book_firework\"}',NoGravity:1b,Marker:1b,Invisible:1b,Small:1b,ArmorItems:[{},{},{},{id:\"lotw:light\",Count:1b}]}");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"execute at @e[name=LOTW-spell_book_use] as @e[name=LOTW-spell_book_firework,distance=..3] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-spell_book_target,limit=1]");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"execute at @e[name=LOTW-spell_book_use] run playsound minecraft:entity.firework_rocket.launch ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													("execute at @e[name=LOTW-spell_book_use] run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~ ~ 0.5 "
															+ MathHelper.nextDouble(new Random(), 0, 2) + " 0.025"));
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle firework ^ ^ ^0.25 0 0 0 0.1 20 force");
										}
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world,
															4, "", new StringTextComponent(""), ((World) world).getServer(), null)
															.withFeedbackDisabled(),
													("execute at @e[name=LOTW-spell_book_use] as @e[name=LOTW-spell_book_firework,limit=1,sort=random,distance=..3] at @s run tp @s ~ ~ ~ ~"
															+ MathHelper.nextDouble(new Random(), -15, 15) + " ~"
															+ MathHelper.nextDouble(new Random(), -15, 15)));
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) (MathHelper.nextInt(new Random(), 5, 20)));
							}
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-spell_book_use] as @e[name=LOTW-spell_book_firework,limit=1,sort=random,distance=3..] at @s run tp @s ~ ~ ~ ~"
											+ MathHelper.nextDouble(new Random(), -15, 15) + " ~" + MathHelper.nextDouble(new Random(), -15, 15)));
						}
					}
					if (!("").equals("Summon")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_firework] at @s if block ^ ^ ^1 #minecraft:air_blocks unless entity @e[tag=!LOTW-ally,distance=..2] run tp @s ^ ^ ^1");
						}
					}
					if (!("").equals("Particle")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_firework] run particle firework ~ ~ ~ 0 0 0 0 1 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle minecraft:smoke ^ ^ ^0.1 0 0 0 0 1 force");
						}
					}
					if (!("").equals("Sound")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_firework,limit=1,sort=random] run playsound minecraft:block.fire.ambient ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025");
						}
					}
					if (!("").equals("Effect")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-spell_book_firework] if entity @e[name=LOTW-spell_book_target,distance=..1] run "
											+ ("summon firework_rocket ~ ~ ~ {FireworksItem:{id:\"minecraft:firework_rocket\",Count:1b,tag:{Fireworks:{Flight:3,Explosions:[{Type:"
													+ "" + MathHelper.nextInt(new Random(), 1, 4) + ",Flicker:1,Trail:1,Colors:[I;"
													+ (MathHelper.nextInt(new Random(), 0, 999) + "" + MathHelper.nextInt(new Random(), 0, 999)
															+ MathHelper.nextInt(new Random(), 0, 999))
													+ "],FadeColors:[I;" + (MathHelper.nextInt(new Random(), 0, 999) + ""
															+ MathHelper.nextInt(new Random(), 0, 999) + MathHelper.nextInt(new Random(), 0, 999))
													+ "]}]}}}}")));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_firework] at @s if entity @e[name=LOTW-spell_book_target,distance=..1] run kill @s");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-spell_book_firework] if entity @e[tag=!LOTW-ally,distance=..4] run "
											+ ("summon firework_rocket ~ ~ ~ {FireworksItem:{id:\"minecraft:firework_rocket\",Count:1b,tag:{Fireworks:{Flight:3,Explosions:[{Type:"
													+ "" + MathHelper.nextInt(new Random(), 1, 4) + ",Flicker:1,Trail:1,Colors:[I;"
													+ (MathHelper.nextInt(new Random(), 0, 999) + "" + MathHelper.nextInt(new Random(), 0, 999)
															+ MathHelper.nextInt(new Random(), 0, 999))
													+ "],FadeColors:[I;" + (MathHelper.nextInt(new Random(), 0, 999) + ""
															+ MathHelper.nextInt(new Random(), 0, 999) + MathHelper.nextInt(new Random(), 0, 999))
													+ "]}]}}}}")));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_firework] at @s if entity @e[tag=!LOTW-ally,distance=..4] run kill @s");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-spell_book_firework] unless block ^ ^ ^1 #air_blocks run "
											+ ("summon firework_rocket ~ ~ ~ {FireworksItem:{id:\"minecraft:firework_rocket\",Count:1b,tag:{Fireworks:{Flight:3,Explosions:[{Type:"
													+ "" + MathHelper.nextInt(new Random(), 1, 4) + ",Flicker:1,Trail:1,Colors:[I;"
													+ (MathHelper.nextInt(new Random(), 0, 999) + "" + MathHelper.nextInt(new Random(), 0, 999)
															+ MathHelper.nextInt(new Random(), 0, 999))
													+ "],FadeColors:[I;" + (MathHelper.nextInt(new Random(), 0, 999) + ""
															+ MathHelper.nextInt(new Random(), 0, 999) + MathHelper.nextInt(new Random(), 0, 999))
													+ "]}]}}}}")));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_firework] at @s unless block ^ ^ ^1 #air_blocks run kill @s");
						}
						if (LotwModVariables.MapVariables.get(world).spell7_mode == 1) {
							temporary_number = 100;
						} else if (LotwModVariables.MapVariables.get(world).spell7_mode == 2) {
							temporary_number = 50;
						} else if (LotwModVariables.MapVariables.get(world).spell7_mode == 3) {
							temporary_number = 25;
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-spell_book_firework] unless entity @e[name=LOTW-spell_book_use,distance=.."
											+ temporary_number + "] run "
											+ ("summon firework_rocket ~ ~ ~ {FireworksItem:{id:\"minecraft:firework_rocket\",Count:1b,tag:{Fireworks:{Flight:3,Explosions:[{Type:"
													+ "" + MathHelper.nextInt(new Random(), 1, 4) + ",Flicker:1,Trail:1,Colors:[I;"
													+ (MathHelper.nextInt(new Random(), 0, 999) + "" + MathHelper.nextInt(new Random(), 0, 999)
															+ MathHelper.nextInt(new Random(), 0, 999))
													+ "],FadeColors:[I;" + (MathHelper.nextInt(new Random(), 0, 999) + ""
															+ MathHelper.nextInt(new Random(), 0, 999) + MathHelper.nextInt(new Random(), 0, 999))
													+ "]}]}}}}")));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-spell_book_firework] at @s unless entity @e[name=LOTW-spell_book_use,distance=.."
											+ temporary_number + "] run kill @s"));
						}
					}
				}
			}
			if (!("Wind").equals("")) {
				if (("Wind Knockback").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)
						|| ("Wind Cutter").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
					for (int index5 = 0; index5 < (int) (5); index5++) {
						if (!("").equals("Summon")) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[name=LOTW-spell_book_wind] at @s if block ^ ^ ^1 #minecraft:air_blocks run tp @s ^ ^ ^1 facing entity @e[name=LOTW-spell_book_target,limit=1]");
							}
						}
						if (!("").equals("Particle")) {
							if (("Wind Knockback").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[name=LOTW-spell_book_wind] run particle minecraft:explosion ^ ^ ^ 0 0 0 0 1 force");
								}
							} else {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[name=LOTW-spell_book_wind] run particle sweep_attack ~ ~ ~ 0 0 0 0 1 force");
								}
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_wind] if entity @e[name=LOTW-spell_book_target,distance=..1] run particle minecraft:explosion_emitter ^ ^ ^ 0 0 0 0 1 force");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_wind] unless block ^ ^ ^1 #air_blocks run particle minecraft:explosion_emitter ^ ^ ^ 0 0 0 0 1 force");
							}
						}
						if (!("").equals("Sound")) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_wind] run playsound minecraft:entity.skeleton_horse.ambient ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_wind] if entity @e[name=LOTW-spell_book_target,distance=..1] run playsound minecraft:entity.vex.charge ambient @a[distance=..100] ~ ~ ~ 1 0 0.025");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_wind] unless block ^ ^ ^1 #air_blocks run playsound minecraft:entity.vex.charge ambient @a[distance=..100] ~ ~ ~ 1 0 0.025");
							}
						}
						if (!("").equals("Effect")) {
							if (("Wind Knockback").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											("execute at @e[name=LOTW-spell_book_wind] if block ~ ~ ~ #minecraft:air_blocks positioned ^ ^ ^-1 as "
													+ "@e[type=!armor_stand,nbt=!{NoGravity:1b},distance=..2]"
													+ " at @s facing entity @e[name=LOTW-spell_book_wind,limit=1,sort=nearest] feet run tp @s ^ ^ ^1"));
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[name=LOTW-spell_book_wind] run effect give @e[tag=!LOTW-enchant,distance=..2] minecraft:slow_falling 1 0 true");
								}
							} else {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[name=LOTW-spell_book_wind] as @e[tag=!LOTW-ally,distance=..4] at @s run effect give @s wither 5 2 true");
								}
							}
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_wind] at @s if entity @e[name=LOTW-spell_book_target,distance=..1] run kill @s");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_wind] at @s unless block ^ ^ ^1 #air_blocks run kill @s");
						}
					}
				}
			}
			if (!("Teleportation").equals("")) {
				if (("Time Travelling").equals(LotwModVariables.MapVariables.get(world).spell7_test_use)) {
					if (!("").equals("Summon")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_circle] at @s if entity @e[tag=LOTW-spell_book_circle,distance=2..] run tp @s ~ ~ ~ ~-0.5 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_circle2] at @s if entity @e[tag=LOTW-spell_book_circle,distance=2..] run tp @s ~ ~ ~ ~-6 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_circle3] at @s if entity @e[tag=LOTW-spell_book_circle,distance=2..] run tp @s ~ ~ ~ ~0.5 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_circle4] at @s if entity @e[tag=LOTW-spell_book_circle,distance=2..] run tp @s ~ ~ ~ ~6 ~");
						}
					}
					if (!("").equals("Particle")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-spell_book_use] positioned ~ ~0.75 ~ run particle minecraft:reverse_portal ^ ^ ^0.1 0 0 0 0.025 1 force");
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_circle] unless entity @e[type=!armor_stand,distance=..4] at @e[name=LOTW-spell_book_circle3] unless entity @e[type=!armor_stand,distance=..4] run particle portal ~ ~1.5 ~ 1.75 0 1.75 0 1 force");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_circle3] unless entity @e[type=!armor_stand,distance=..4] at @e[name=LOTW-spell_book_circle] unless entity @e[type=!armor_stand,distance=..4] run particle portal ~ ~1.5 ~ 1.75 0 1.75 0 1 force");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_circle] if entity @e[type=!armor_stand,distance=..4] run particle minecraft:portal ~ ~1.5 ~ 0 0 0 1.5 5 force");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_circle] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle,distance=1..] run particle minecraft:reverse_portal ~ ~1.5 ~ 0 0 0 0.1 5 force");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_circle] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle,distance=1..] run particle minecraft:reverse_portal ~ ~1.5 ~ 0 1 0 0.1 0 force");
							}
							if (true) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[tag=LOTW-spell_book_circle2] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle witch ^4 ^1.5 ^ 0 1 0 1 0 force");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[tag=LOTW-spell_book_circle2] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle witch ^-4 ^1.5 ^ 0 1 0 1 0 force");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[tag=LOTW-spell_book_circle2] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle witch ^ ^1.5 ^4 0 1 0 1 0 force");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[tag=LOTW-spell_book_circle2] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle witch ^ ^1.5 ^-4 0 1 0 1 0 force");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[tag=LOTW-spell_book_circle2] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle witch ^2.5 ^1.5 ^2.5 0 1 0 1 0 force");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[tag=LOTW-spell_book_circle2] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle witch ^2.5 ^1.5 ^-2.5 0 1 0 1 0 force");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[tag=LOTW-spell_book_circle2] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle witch ^-2.5 ^1.5 ^2.5 0 1 0 1 0 force");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[tag=LOTW-spell_book_circle2] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle witch ^-2.5 ^1.5 ^-2.5 0 1 0 1 0 force");
								}
							}
							if (true) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[tag=LOTW-spell_book_circle2] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle dragon_breath ^2.5 ^1.5 ^2.5 0 1 0 0.025 0 force");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[tag=LOTW-spell_book_circle2] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle dragon_breath ^2.5 ^1.5 ^-2.5 0 1 0 0.025 0 force");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[tag=LOTW-spell_book_circle2] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle dragon_breath ^-2.5 ^1.5 ^2.5 0 1 0 0.025 0 force");
								}
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"execute at @e[tag=LOTW-spell_book_circle2] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle dragon_breath ^-2.5 ^1.5 ^-2.5 0 1 0 0.025 0 force");
								}
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_circle,y_rotation=180..210] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle dragon_breath ~ ~1.5 ~ 1.5 0 1.5 0 20 force");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_circle3,y_rotation=150..180] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle2] run particle dragon_breath ~ ~1.5 ~ 1.5 0 1.5 0 20 force");
							}
						}
					}
					if (!("").equals("Sound")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[tag=LOTW-spell_book_circle2,y_rotation=180] at @e[name=LOTW-spell_book_use] run playsound minecraft:ambient.cave ambient @a[distance=..100] ~ ~1.5 ~ 0.1 0 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[tag=LOTW-spell_book_circle2,y_rotation=180] run playsound minecraft:block.portal.ambient ambient @a[distance=..100] ~ ~1.5 ~ 1 1 0.025");
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_circle2,y_rotation=180] if entity @e[type=!armor_stand,distance=..4] run playsound minecraft:block.bell.use ambient @a[distance=..100] ~ ~1.5 ~ 2 0 0.025");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[tag=LOTW-spell_book_circle2,y_rotation=180] at @s at @e[tag=LOTW-spell_book_circle2,distance=2..] if entity @e[type=!armor_stand,distance=..4] at @s run playsound minecraft:block.bell.use ambient @a[distance=..100] ~ ~1.5 ~ 2 0 0.025");
							}
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_circle,y_rotation=210] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle] run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-spell_book_circle3,y_rotation=150] if entity @e[type=!armor_stand,distance=..4] at @e[tag=LOTW-spell_book_circle] run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
							}
						}
					}
					if (!("").equals("Effect")) {
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[tag=LOTW-spell_book_circle,y_rotation=180] if entity @e[type=!armor_stand,distance=..4] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 2 "
												+ MathHelper.nextDouble(new Random(), 0.5, 2) + " 0.025"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_circle,y_rotation=180] at @e[type=!armor_stand,distance=..4] run particle flash ~ ~ ~ 0 0 0 0 1 force");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_circle,y_rotation=180] at @e[type=!armor_stand,distance=..4] run particle minecraft:campfire_signal_smoke ~ ~ ~ 0.5 0 0.5 0.01 20 force");
							}
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[tag=LOTW-spell_book_circle,y_rotation=180] as @e[type=!armor_stand,tag=!LOTW-spell_book_tp,distance=..4] at @s at @e[tag=LOTW-spell_book_circle,distance=5..] run tp @s ~ ~2 ~");
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[tag=LOTW-spell_book_circle,y_rotation=180] if entity @e[type=!armor_stand,distance=..4] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 2 "
												+ MathHelper.nextDouble(new Random(), 0.5, 2) + " 0.025"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_circle,y_rotation=180] at @e[type=!armor_stand,distance=..4] run particle flash ~ ~ ~ 0 0 0 0 1 force");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_circle,y_rotation=180] at @e[type=!armor_stand,distance=..4] run particle minecraft:campfire_signal_smoke ~ ~ ~ 0.5 0 0.5 0.01 20 force");
							}
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[tag=LOTW-spell_book_circle,y_rotation=180] at @e[tag=LOTW-spell_book_circle,distance=5..] as @e[type=!armor_stand,distance=..4] at @s run tag @s add LOTW-spell_book_tp");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[tag=LOTW-spell_book_circle,y_rotation=190..170] run tag @e remove LOTW-spell_book_tp");
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[tag=LOTW-spell_book_circle,y_rotation=180.5] if entity @e[type=!armor_stand,distance=..4] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 2 "
												+ MathHelper.nextDouble(new Random(), 0.5, 2) + " 0.025"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_circle,y_rotation=180.5] at @e[type=!armor_stand,distance=..4] run particle flash ~ ~ ~ 0 0 0 0 1 force");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_circle,y_rotation=180.5] at @e[type=!armor_stand,distance=..4] run particle minecraft:campfire_signal_smoke ~ ~ ~ 0.5 0 0.5 0.01 20 force");
							}
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[tag=LOTW-spell_book_circle,y_rotation=179.5] if entity @e[type=!armor_stand,distance=..4] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 2 "
												+ MathHelper.nextDouble(new Random(), 0.5, 2) + " 0.025"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_circle,y_rotation=179.5] at @e[type=!armor_stand,distance=..4] run particle flash ~ ~ ~ 0 0 0 0 1 force");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[tag=LOTW-spell_book_circle,y_rotation=179.5] at @e[type=!armor_stand,distance=..4] run particle minecraft:campfire_signal_smoke ~ ~ ~ 0.5 0 0.5 0.01 20 force");
							}
						}
					}
				}
			}
		}
	}
}
