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
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.Minecraft;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell4repeatSlowProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4repeatSlow!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell4repeatSlow!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell4repeatSlow!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell4repeatSlow!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (LotwModVariables.MapVariables.get(world).spell4_start == true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-weapon_manipulation,limit=5,sort=random] run playsound minecraft:block.conduit.ambient.short ambient @a[distance=..100] ~ ~ ~ 1 0 0.025");
			}
			if (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type3 != 0) {
				if (true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[tag=LOTW-weapon_manipulation_type3,nbt={ArmorItems:[{},{},{},{id:\"" + "lotw:mini_lantern_2"
										+ "\",Count:1b}]}] run playsound minecraft:entity.ender_eye.death ambient @a[distance=..100] ^ ^1.5 ^-0.3 0.5 2 0.025"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[tag=LOTW-weapon_manipulation_type3,nbt={ArmorItems:[{},{},{},{id:\"" + "lotw:mini_lantern_2"
										+ "\",Count:1b}]}] run particle minecraft:flame ^ ^1.5 ^-0.3 0.1 0.1 0.1 0 5 force"));
					}
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[tag=LOTW-weapon_manipulation_type3,nbt={ArmorItems:[{},{},{},{id:\"" + "lotw:mini_lantern_2"
											+ "\",Count:1b}]}] at @s run data modify entity @s ArmorItems[3] set value {id:\"lotw:mini_lantern_3\",Count:1b}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[tag=LOTW-weapon_manipulation_type3,nbt={ArmorItems:[{},{},{},{id:\"" + "lotw:mini_lantern_1"
											+ "\",Count:1b}]}] at @s run data modify entity @s ArmorItems[3] set value {id:\"lotw:mini_lantern_2\",Count:1b}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[tag=LOTW-weapon_manipulation_type3,nbt={ArmorItems:[{},{},{},{id:\"" + "lotw:mini_lantern"
											+ "\",Count:1b}]}] at @s run data modify entity @s ArmorItems[3] set value {id:\"lotw:mini_lantern_1\",Count:1b}"));
						}
					}
				}
			}
			if (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type4 != 0) {
				if (true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[tag=LOTW-weapon_manipulation_type4,nbt={HandItems:[{},{id:\"" + "lotw:bow_2"
										+ "\",Count:1b}]}] run playsound minecraft:item.crossbow.loading_start ambient @a[distance=..100] ~ ~0.625 ~ 0.5 0.75 0.025"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[tag=LOTW-weapon_manipulation_type4,nbt={HandItems:[{},{id:\"" + "lotw:bow_2"
										+ "\",Count:1b}]}] run particle crit ~ ~0.625 ~ 1 1 1 0.25 5 force"));
					}
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[tag=LOTW-weapon_manipulation_type4,nbt={HandItems:[{},{id:\"" + "lotw:bow_2"
											+ "\",Count:1b}]}] at @s run data modify entity @s HandItems[1] set value {id:\"lotw:bow_3\",Count:1b}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[tag=LOTW-weapon_manipulation_type4,nbt={HandItems:[{},{id:\"" + "lotw:bow_1"
											+ "\",Count:1b}]}] at @s run data modify entity @s HandItems[1] set value {id:\"lotw:bow_2\",Count:1b}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[tag=LOTW-weapon_manipulation_type4,nbt={HandItems:[{},{id:\"" + "lotw:bow"
											+ "\",Count:1b}]}] at @s run data modify entity @s HandItems[1] set value {id:\"lotw:bow_1\",Count:1b}"));
						}
					}
				}
			}
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

						Spell4repeatSlowProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			}
		}
	}
}
