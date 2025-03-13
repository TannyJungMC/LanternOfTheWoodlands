package lotw.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
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
import net.minecraft.client.Minecraft;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class CustomPlantTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure CustomPlantTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure CustomPlantTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure CustomPlantTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure CustomPlantTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		String plant_id = "";
		double stage = 0;
		double random_plant = 0;
		if ((world.isRemote()
				? Minecraft.getInstance().getConnection().getPlayerInfoMap().size()
				: ServerLifecycleHooks.getCurrentServer().getCurrentPlayerCount()) > 0) {
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

					CustomPlantTickProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) ((180 * 60 * 20) / 30));
		}
		random_plant = (MathHelper.nextInt(new Random(), 1, 31));
		if (true) {
			if (random_plant == 1) {
				plant_id = "grass";
			}
			if (random_plant == 2) {
				plant_id = "fern";
			}
			if (random_plant == 3) {
				plant_id = "dead_bush";
			}
			if (random_plant == 4) {
				plant_id = "dandelion";
			}
			if (random_plant == 5) {
				plant_id = "poppy";
			}
			if (random_plant == 6) {
				plant_id = "blue_orchid";
			}
			if (random_plant == 7) {
				plant_id = "allium";
			}
			if (random_plant == 8) {
				plant_id = "azure_bluet";
			}
			if (random_plant == 9) {
				plant_id = "red_tulip";
			}
			if (random_plant == 10) {
				plant_id = "orange_tulip";
			}
			if (random_plant == 11) {
				plant_id = "white_tulip";
			}
			if (random_plant == 12) {
				plant_id = "pink_tulip";
			}
			if (random_plant == 13) {
				plant_id = "oxeye_daisy";
			}
			if (random_plant == 14) {
				plant_id = "cornflower";
			}
			if (random_plant == 15) {
				plant_id = "lily_of_the_valley";
			}
			if (random_plant == 16) {
				plant_id = "wither_rose";
			}
			if (random_plant == 17) {
				plant_id = "brown_mushroom";
			}
			if (random_plant == 18) {
				plant_id = "red_mushroom";
			}
			if (random_plant == 19) {
				plant_id = "crimson_fungus";
			}
			if (random_plant == 20) {
				plant_id = "warped_fungus";
			}
			if (random_plant == 21) {
				plant_id = "vine";
			}
			if (random_plant == 22) {
				plant_id = "oak_sapling";
			}
			if (random_plant == 22) {
				plant_id = "spruce_sapling";
			}
			if (random_plant == 22) {
				plant_id = "birch_sapling";
			}
			if (random_plant == 23) {
				plant_id = "jungle_sapling";
			}
			if (random_plant == 24) {
				plant_id = "acacia_sapling";
			}
			if (random_plant == 25) {
				plant_id = "dark_oak_sapling";
			}
			if (random_plant == 26) {
				plant_id = "lotw:sunflower";
			}
			if (random_plant == 27) {
				plant_id = "lilac";
			}
			if (random_plant == 28) {
				plant_id = "rose_bush";
			}
			if (random_plant == 29) {
				plant_id = "peony";
			}
			if (random_plant == 30) {
				plant_id = "tall_grass";
			}
			if (random_plant == 31) {
				plant_id = "large_fern";
			}
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[name=LOTW-custom_planting_" + "9"
								+ "] run playsound minecraft:block.crop.break ambient @a[distance=..100] ~ ~ ~ 0.1 2 0.025"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute as @e[name=LOTW-custom_planting_" + "9" + "] at @s run data merge entity @s {HandItems:[{},{id:\""
								+ "lotw:custom_plant_stage_1" + "\",Count:1b}]}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[name=LOTW-custom_planting_" + "19"
								+ "] run playsound minecraft:block.crop.break ambient @a[distance=..100] ~ ~ ~ 0.1 2 0.025"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute as @e[name=LOTW-custom_planting_" + "19" + "] at @s run data merge entity @s {HandItems:[{},{id:\""
								+ "lotw:custom_plant_stage_2" + "\",Count:1b}]}"));
			}
			if (LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage != 30
					&& LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage != 30
					&& LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage != 30
					&& LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage != 30
					&& LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage != 30
					&& LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage != 30) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute at @e[name=LOTW-custom_planting_" + "30"
									+ ",limit=1] run playsound minecraft:block.crop.break ambient @a[distance=..100] ~ ~ ~ 0.1 2 0.025"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[name=LOTW-custom_planting_" + "30" + ",limit=1] at @s run data merge entity @s {HandItems:[{},{id:\""
									+ plant_id + "\",Count:1b}]}"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[name=LOTW-custom_planting_" + "30"
									+ ",limit=1] at @s run data merge entity @s {CustomName:'{\"text\":\"LOTW-custom_planting_" + "mature"
									+ "\"}'}"));
				}
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[name=LOTW-custom_planting_bag] at @e[name=LOTW-custom_planting_" + "30"
								+ ",distance=..1] run playsound minecraft:block.crop.break ambient @a[distance=..100] ~ ~ ~ 0.1 2 0.025"));
			}
		}
		stage = 30;
		for (int index0 = 0; index0 < (int) (30); index0++) {
			if (stage != 0 && stage != 10 && stage != 20 && stage != 30) {
				if (MathHelper.nextInt(new Random(), 1, 10) >= 5) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[name=LOTW-custom_planting_" + (new java.text.DecimalFormat("##.#").format(stage)).replace(".0", "")
										+ "] at @s run data merge entity @s {CustomName:'{\"text\":\"LOTW-custom_planting_"
										+ (new java.text.DecimalFormat("##.#").format(stage + 1)).replace(".0", "") + "\"}'}"));
					}
				}
			}
			stage = (stage - 1);
		}
		if (true) {
			if (true) {
				if (LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage != 0
						&& LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage != 10
						&& LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage != 20
						&& !(LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage >= 30)) {
					if (MathHelper.nextInt(new Random(), 1, 10) >= 3) {
						LotwModVariables.MapVariables
								.get(world).custom_planting_bag_1_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage + 1);
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage != 0
						&& LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage != 10
						&& LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage != 20
						&& !(LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage >= 30)) {
					if (MathHelper.nextInt(new Random(), 1, 10) >= 3) {
						LotwModVariables.MapVariables
								.get(world).custom_planting_bag_2_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage + 1);
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage != 0
						&& LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage != 10
						&& LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage != 20
						&& !(LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage >= 30)) {
					if (MathHelper.nextInt(new Random(), 1, 10) >= 3) {
						LotwModVariables.MapVariables
								.get(world).custom_planting_bag_3_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage + 1);
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage != 0
						&& LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage != 10
						&& LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage != 20
						&& !(LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage >= 30)) {
					if (MathHelper.nextInt(new Random(), 1, 10) >= 3) {
						LotwModVariables.MapVariables
								.get(world).custom_planting_bag_4_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage + 1);
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage != 0
						&& LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage != 10
						&& LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage != 20
						&& !(LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage >= 30)) {
					if (MathHelper.nextInt(new Random(), 1, 10) >= 3) {
						LotwModVariables.MapVariables
								.get(world).custom_planting_bag_5_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage + 1);
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if (LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage != 0
						&& LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage != 10
						&& LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage != 20
						&& !(LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage >= 30)) {
					if (MathHelper.nextInt(new Random(), 1, 10) >= 3) {
						LotwModVariables.MapVariables
								.get(world).custom_planting_bag_6_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage + 1);
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
			}
			if (true) {
				if (LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage == 10) {
					LotwModVariables.MapVariables.get(world).custom_planting_bag_1_plant = "lotw:custom_plant_stage_1";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else if (LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage == 20) {
					LotwModVariables.MapVariables.get(world).custom_planting_bag_1_plant = "lotw:custom_plant_stage_2";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage == 10) {
					LotwModVariables.MapVariables.get(world).custom_planting_bag_2_plant = "lotw:custom_plant_stage_1";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else if (LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage == 20) {
					LotwModVariables.MapVariables.get(world).custom_planting_bag_2_plant = "lotw:custom_plant_stage_2";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage == 10) {
					LotwModVariables.MapVariables.get(world).custom_planting_bag_3_plant = "lotw:custom_plant_stage_1";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else if (LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage == 20) {
					LotwModVariables.MapVariables.get(world).custom_planting_bag_3_plant = "lotw:custom_plant_stage_2";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage == 10) {
					LotwModVariables.MapVariables.get(world).custom_planting_bag_4_plant = "lotw:custom_plant_stage_1";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else if (LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage == 20) {
					LotwModVariables.MapVariables.get(world).custom_planting_bag_4_plant = "lotw:custom_plant_stage_2";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage == 10) {
					LotwModVariables.MapVariables.get(world).custom_planting_bag_5_plant = "lotw:custom_plant_stage_1";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else if (LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage == 20) {
					LotwModVariables.MapVariables.get(world).custom_planting_bag_5_plant = "lotw:custom_plant_stage_2";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage == 10) {
					LotwModVariables.MapVariables.get(world).custom_planting_bag_6_plant = "lotw:custom_plant_stage_1";
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else if (LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage == 20) {
					LotwModVariables.MapVariables.get(world).custom_planting_bag_6_plant = "lotw:custom_plant_stage_2";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage == 30) {
				LotwModVariables.MapVariables.get(world).custom_planting_bag_1_plant = plant_id;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables
						.get(world).custom_planting_bag_1_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_1_stage + 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if (LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage == 30) {
				LotwModVariables.MapVariables.get(world).custom_planting_bag_2_plant = plant_id;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables
						.get(world).custom_planting_bag_2_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_2_stage + 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if (LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage == 30) {
				LotwModVariables.MapVariables.get(world).custom_planting_bag_3_plant = plant_id;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables
						.get(world).custom_planting_bag_3_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_3_stage + 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if (LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage == 30) {
				LotwModVariables.MapVariables.get(world).custom_planting_bag_4_plant = plant_id;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables
						.get(world).custom_planting_bag_4_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_4_stage + 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if (LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage == 30) {
				LotwModVariables.MapVariables.get(world).custom_planting_bag_5_plant = plant_id;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables
						.get(world).custom_planting_bag_5_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_5_stage + 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if (LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage == 30) {
				LotwModVariables.MapVariables.get(world).custom_planting_bag_6_plant = plant_id;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables
						.get(world).custom_planting_bag_6_stage = (LotwModVariables.MapVariables.get(world).custom_planting_bag_6_stage + 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
