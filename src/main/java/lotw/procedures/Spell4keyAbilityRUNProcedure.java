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
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell4keyAbilityRUNProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4keyAbilityRUN!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell4keyAbilityRUN!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell4keyAbilityRUN!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell4keyAbilityRUN!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell4keyAbilityRUN!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		String mode = "";

		UserOnlyTestProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		if (LotwModVariables.MapVariables.get(world).user_only == true && LotwModVariables.MapVariables.get(world).spell4_start == true) {
			if ((LotwModVariables.MapVariables.get(world).spell4_mode).equals("Multiple Shot")) {
				mode = "";
			} else if ((LotwModVariables.MapVariables.get(world).spell4_mode).equals("Single Shot")) {
				mode = "limit=1,sort=nearest,";
			} else if ((LotwModVariables.MapVariables.get(world).spell4_mode).equals("Auto Shot")) {
				mode = "tag=LOTW-weapon_manipulation_shoot,";
			}
			if (!(LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Off")
					&& !(LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Unselected")) {
				if ((LotwModVariables.MapVariables.get(world).spell4_ability).equals("")
						|| (LotwModVariables.MapVariables.get(world).spell4_ability).equals("Ready")) {
					LotwModVariables.MapVariables.get(world).spell4_ability = "10s";
					LotwModVariables.MapVariables.get(world).syncData(world);
					if (true) {
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
								LotwModVariables.MapVariables.get(world).spell4_ability = "9s";
								LotwModVariables.MapVariables.get(world).syncData(world);
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
								LotwModVariables.MapVariables.get(world).spell4_ability = "8s";
								LotwModVariables.MapVariables.get(world).syncData(world);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 40);
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
								LotwModVariables.MapVariables.get(world).spell4_ability = "7s";
								LotwModVariables.MapVariables.get(world).syncData(world);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 60);
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
								LotwModVariables.MapVariables.get(world).spell4_ability = "6s";
								LotwModVariables.MapVariables.get(world).syncData(world);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 80);
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
								LotwModVariables.MapVariables.get(world).spell4_ability = "5s";
								LotwModVariables.MapVariables.get(world).syncData(world);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 100);
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
								LotwModVariables.MapVariables.get(world).spell4_ability = "4s";
								LotwModVariables.MapVariables.get(world).syncData(world);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 120);
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
								LotwModVariables.MapVariables.get(world).spell4_ability = "3s";
								LotwModVariables.MapVariables.get(world).syncData(world);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 140);
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
								LotwModVariables.MapVariables.get(world).spell4_ability = "2s";
								LotwModVariables.MapVariables.get(world).syncData(world);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 160);
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
								LotwModVariables.MapVariables.get(world).spell4_ability = "1s";
								LotwModVariables.MapVariables.get(world).syncData(world);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 180);
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
								LotwModVariables.MapVariables.get(world).spell4_ability = "0s";
								LotwModVariables.MapVariables.get(world).syncData(world);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 200);
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
								LotwModVariables.MapVariables.get(world).spell4_ability = "Ready";
								LotwModVariables.MapVariables.get(world).syncData(world);
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"/execute at @e[tag=LOTW-user] run playsound minecraft:block.note_block.chime ambient @a[distance=..100] ~ ~ ~ 0.25 0 0.025");
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 220);
					}
					if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
							|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Sword"))
							&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type1 != 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit] run particle minecraft:flash ~ ~1 ~ 0.25 0.25 0.25 0.01 1 force"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025"));
						}
						for (int index0 = 0; index0 < (int) (20); index0++) {
							for (int index1 = 0; index1 < (int) (5); index1++) {
								if (world instanceof ServerWorld) {
									((World) world).getServer().getCommandManager().handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											("execute at @e[name=LOTW-weapon_manipulation_target] as @e[" + mode
													+ "tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit] at @s run tp @s ^ ^ ^0.1"));
								}
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
												+ "tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit] at @s positioned ~ ~1.4 ~ unless block ^-0.4 ^-0.45 ^0.9 air run playsound minecraft:item.trident.hit_ground ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
												+ "tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit] at @s positioned ~ ~1.4 ~ unless block ^-0.4 ^-0.45 ^0.9 air run particle minecraft:spit ^-0.4 ^ ^0.5 0.5 0.5 0.5 0.05 10 force"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[name=LOTW-weapon_manipulation_target] as @e[" + mode
												+ "tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit] at @s positioned ~ ~1.4 ~ unless block ^-0.35 ^-0.6 ^0.9 air run tag @s add LOTW-weapon_manipulation_hit"));
							}
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit] run particle minecraft:flash ~ ~1 ~ 0.25 0.25 0.25 0.01 1 force"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025"));
						}
					}
					if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
							|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Shield"))
							&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type2 != 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] as @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type2,distance=..10] at @s run tp @s ^ ^ ^-8 facing ^ ^ ^-5"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] as @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type2,limit=13,sort=nearest] run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type2,limit=13,sort=nearest] run particle minecraft:flash ~ ~ ~ 0 0 0 0 1 force"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type2,limit=13,sort=nearest] run particle minecraft:campfire_cosy_smoke ~ ~ ~ 0.5 0.5 0.5 0.01 3 force"));
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] run tp @e[tag=LOTW-weapon_manipulation_type2,sort=nearest,distance=8..,limit=1] ^ ^ ^5");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] run tp @e[tag=LOTW-weapon_manipulation_type2,sort=nearest,distance=8..,limit=1] ^1.25 ^ ^5");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] run tp @e[tag=LOTW-weapon_manipulation_type2,sort=nearest,distance=8..,limit=1] ^-1.25 ^ ^5");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] run tp @e[tag=LOTW-weapon_manipulation_type2,sort=nearest,distance=8..,limit=1] ^2.5 ^ ^5");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] run tp @e[tag=LOTW-weapon_manipulation_type2,sort=nearest,distance=8..,limit=1] ^-2.5 ^ ^5");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] run tp @e[tag=LOTW-weapon_manipulation_type2,sort=nearest,distance=8..,limit=1] ^ ^1.75 ^5");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] run tp @e[tag=LOTW-weapon_manipulation_type2,sort=nearest,distance=8..,limit=1] ^1.25 ^1.75 ^5");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] run tp @e[tag=LOTW-weapon_manipulation_type2,sort=nearest,distance=8..,limit=1] ^-1.25 ^1.75 ^5");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] run tp @e[tag=LOTW-weapon_manipulation_type2,sort=nearest,distance=8..,limit=1] ^ ^-1.75 ^5");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] run tp @e[tag=LOTW-weapon_manipulation_type2,sort=nearest,distance=8..,limit=1] ^1.25 ^-1.75 ^5");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] run tp @e[tag=LOTW-weapon_manipulation_type2,sort=nearest,distance=8..,limit=1] ^-1.25 ^-1.75 ^5");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] run tp @e[tag=LOTW-weapon_manipulation_type2,sort=nearest,distance=8..,limit=1] ^ ^3.5 ^5");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute at @e[name=LOTW-weapon_manipulation_target] run tp @e[tag=LOTW-weapon_manipulation_type2,sort=nearest,distance=8..,limit=1] ^ ^-3.5 ^5");
							}
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-weapon_manipulation_target] positioned ^ ^ ^5 run playsound minecraft:entity.evoker.prepare_attack ambient @a[distance=..100] ~ ~ ~ 2 0 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-weapon_manipulation_target] at @e[tag=LOTW-weapon_manipulation_type2,distance=..8] run particle minecraft:flash ~ ~1.5 ~ 0 0 0 0 1 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-weapon_manipulation_target] positioned ^ ^ ^5 run particle minecraft:campfire_cosy_smoke ~ ~ ~ 2 2 2 0.01 20 force");
						}
					}
					if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
							|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Lantern"))
							&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type3 != 0) {
						if ((LotwModVariables.MapVariables.get(world).spell4_target_lock).equals("On")
								&& (LotwModVariables.MapVariables.get(world).spell4_reverse).equals("On")) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
												+ "tag=LOTW-weapon_manipulation_type3,nbt={ArmorItems:[{},{},{},{id:\"lotw:mini_lantern_3\",Count:1b}]}] run summon bat ^ ^1 ^-0.3 {Tags:[\"LOTW-ally\",\"LOTW-weapon_manipulation\"],Silent:1b,CustomName:'{\"text\":\"LOTW-weapon_manipulation_type3_light\"}',ArmorItems:[{},{},{},{id:\"glowstone\",Count:1b}],DeathLootTable:\"minecraft:empty\",ArmorDropChances:[0f,0f,0f,0.f],NoAI:0b}"));
							}
						} else {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
												+ "tag=LOTW-weapon_manipulation_type3,nbt={ArmorItems:[{},{},{},{id:\"lotw:mini_lantern_3\",Count:1b}]}] run summon bat ^ ^1 ^-0.3 {Tags:[\"LOTW-ally\",\"LOTW_weapon_manipulation\"],Silent:1b,CustomName:'{\"text\":\"LOTW-weapon_manipulation_type3_light\"}',ArmorItems:[{},{},{},{id:\"glowstone\",Count:1b}],DeathLootTable:\"minecraft:empty\",ArmorDropChances:[0f,0f,0f,0.f],NoAI:1b}"));
							}
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type3,nbt={ArmorItems:[{},{},{},{id:\"lotw:mini_lantern_3\",Count:1b}]}] run playsound minecraft:entity.blaze.shoot ambient @a[distance=..100] ^ ^1.5 ^-0.3 0.5 0.75 0.025"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type3,nbt={ArmorItems:[{},{},{},{id:\"lotw:mini_lantern_3\",Count:1b}]}] run particle minecraft:flame ^ ^1.5 ^-0.3 0.2 0.2 0.2 0.01 10 force"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type3,nbt={ArmorItems:[{},{},{},{id:\"lotw:mini_lantern_3\",Count:1b}]}] run particle minecraft:large_smoke ^ ^1.5 ^-0.3 0.25 0.25 0.25 0 20 force"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type3,nbt={ArmorItems:[{},{},{},{id:\"lotw:mini_lantern_3\",Count:1b}]}] positioned ^ ^1 ^-0.3 as @e[name=LOTW-weapon_manipulation_type3_light,distance=..1,limit=1,sort=nearest] at @s run tp @s ~ ~ ~ facing entity @e[name=LOTW-weapon_manipulation_target,limit=1]"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] as @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type3,nbt={ArmorItems:[{},{},{},{id:\"lotw:mini_lantern_3\",Count:1b}]}] at @s run data merge entity @s {ArmorItems:[{},{},{},{id:\"lotw:mini_lantern\",Count:1b}]}"));
						}
					}
					if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
							|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Bow"))
							&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type4 != 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type4,nbt={HandItems:[{},{id:\"lotw:bow_3\",Count:1b}]}] positioned ~ ~0.625 ~ run playsound minecraft:entity.arrow.shoot ambient @a[distance=..100] ^-0.4 ^ ^0.75 0.5 0 0.025"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type4,nbt={HandItems:[{},{id:\"lotw:bow_3\",Count:1b}]}] positioned ~ ~0.625 ~ run playsound minecraft:entity.illusioner.mirror_move ambient @a[distance=..100] ^-0.4 ^ ^0.75 0.5 0 0.025"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type4,nbt={HandItems:[{},{id:\"lotw:bow_3\",Count:1b}]}] positioned ~ ~0.625 ~ run particle minecraft:enchanted_hit ^-0.4 ^ ^0.75 0 0 0 0.25 5 force"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type4,nbt={HandItems:[{},{id:\"lotw:bow_3\",Count:1b}]}] positioned ~ ~0.625 ~ run summon lotw:summon_arrow ^-0.4 ^ ^0.75"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] as @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type4,nbt={HandItems:[{},{id:\"lotw:bow_3\",Count:1b}]}] at @s run data merge entity @s {HandItems:[{},{id:\"lotw:bow\",Count:1b}]}"));
						}
					}
					if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
							|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Beehive"))
							&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type5 != 0) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=lotw:bee] run particle flash ~ ~ ~ 0 0 0 0 1 force");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[type=lotw:bee] run playsound minecraft:entity.evoker.prepare_summon ambient @a[distance=..100] ~ ~ ~ 0.5 2 0.025");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[type=lotw:bee] at @s at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type5,limit=1,sort=random] run tp @s ~ ~1.75 ~"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type5] run playsound minecraft:entity.evoker.prepare_attack ambient @a[distance=..100] ~ ~ ~ 1 2 0.025"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-weapon_manipulation_target] at @e[" + mode
											+ "tag=LOTW-weapon_manipulation_type5] run particle minecraft:reverse_portal ~ ~1.75 ~ 0.5 0.5 0.5 0.05 20 force"));
						}
					}
				}
			}
		}
	}
}
