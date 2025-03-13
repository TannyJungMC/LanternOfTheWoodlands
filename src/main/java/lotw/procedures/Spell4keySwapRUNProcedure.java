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

public class Spell4keySwapRUNProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4keySwapRUN!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell4keySwapRUN!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell4keySwapRUN!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell4keySwapRUN!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell4keySwapRUN!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");

		UserOnlyTestProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		if (LotwModVariables.MapVariables.get(world).user_only == true && LotwModVariables.MapVariables.get(world).spell4_start == true) {
			if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("")) {
				LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Off";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Off")) {
				Spell4keyResetRUNProcedure.executeProcedure(Stream
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
						LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Unselected";
						LotwModVariables.MapVariables.get(world).syncData(world);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 1);
			} else if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Unselected")) {
				LotwModVariables.MapVariables.get(world).spell4_weapon_type = "All";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")) {
				LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Sword";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Sword")) {
				LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Shield";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Shield")) {
				LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Lantern";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Lantern")) {
				LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Bow";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Bow")) {
				LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Beehive";
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Beehive")) {
				LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Unselected";
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if (true) {
				if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")) {
					if (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type1 != 0
							|| LotwModVariables.MapVariables.get(world).spell4_weapon_count_type2 != 0
							|| LotwModVariables.MapVariables.get(world).spell4_weapon_count_type3 != 0
							|| LotwModVariables.MapVariables.get(world).spell4_weapon_count_type4 != 0
							|| LotwModVariables.MapVariables.get(world).spell4_weapon_count_type5 != 0) {
						LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag = "name=LOTW-weapon_manipulation,";
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else {
						LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Sword";
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Sword")) {
					if (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type1 != 0) {
						LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag = "tag=LOTW-weapon_manipulation_type1,";
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else {
						LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Shield";
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Shield")) {
					if (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type2 != 0) {
						LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag = "tag=LOTW-weapon_manipulation_type2,";
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else {
						LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Lantern";
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Lantern")) {
					if (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type3 != 0) {
						LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag = "tag=LOTW-weapon_manipulation_type3,";
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else {
						LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Bow";
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Bow")) {
					if (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type4 != 0) {
						LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag = "tag=LOTW-weapon_manipulation_type4,";
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else {
						LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Beehive";
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Beehive")) {
					if (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type5 != 0) {
						LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag = "tag=LOTW-weapon_manipulation_type5,";
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else {
						LotwModVariables.MapVariables.get(world).spell4_weapon_type = "Unselected";
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
				if ((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Unselected")) {
					LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag = "tag=LOTW-weapon_manipulation_type0,";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
								+ "limit=3,sort=random,tag=!LOTW-weapon_manipulation_hit] run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~1 ~ 0.5 0.75 0.025"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
								+ "tag=!LOTW-weapon_manipulation_hit] positioned ~ ~1 ~ run particle portal ^ ^ ^ 0.5 0.5 0.5 2 10 force"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"effect clear @e[name=LOTW-weapon_manipulation] minecraft:glowing");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("effect give @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
								+ "tag=!LOTW-weapon_manipulation_hit] minecraft:glowing 3 1 true"));
			}
		}
	}
}
