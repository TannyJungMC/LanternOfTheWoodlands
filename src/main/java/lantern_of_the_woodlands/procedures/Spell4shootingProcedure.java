package lantern_of_the_woodlands.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell4shootingProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell4shooting!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell4shooting!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell4shooting!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell4shooting!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_start == true) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).main_spell == 4) {
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap != 0) {
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap == 1) {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number = "1";
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
						if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_1shoot == true) {
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
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_1shoot = (false);
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
									Spell4shootOFFProcedure.executeProcedure(Stream
											.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
													new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 5);
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
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_1shoot = (true);
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
									Spell4shootONProcedure.executeProcedure(Stream
											.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
													new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 5);
						}
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap == 2) {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number = "2";
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
						if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_2shoot == true) {
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
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_2shoot = (false);
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
									Spell4shootOFFProcedure.executeProcedure(Stream
											.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
													new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 5);
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
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_2shoot = (true);
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
									Spell4shootONProcedure.executeProcedure(Stream
											.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
													new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 5);
						}
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap == 3) {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number = "3";
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
						if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_3shoot == true) {
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
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_3shoot = (false);
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
									Spell4shootOFFProcedure.executeProcedure(Stream
											.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
													new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 5);
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
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_3shoot = (true);
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
									Spell4shootONProcedure.executeProcedure(Stream
											.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
													new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 5);
						}
					}
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap == 4) {
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number = "4";
						LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
						if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_4shoot == true) {
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
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_4shoot = (false);
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
									Spell4shootOFFProcedure.executeProcedure(Stream
											.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
													new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 5);
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
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_4shoot = (true);
									LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
									Spell4shootONProcedure.executeProcedure(Stream
											.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
													new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 5);
						}
					}
					Spell4shooting2Procedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}
		}
	}
}
