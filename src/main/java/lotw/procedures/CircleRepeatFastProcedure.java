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

public class CircleRepeatFastProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure CircleRepeatFast!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure CircleRepeatFast!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure CircleRepeatFast!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure CircleRepeatFast!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
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

					CircleRepeatFastProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 1);
		}
		if (true) {
			if (LotwModVariables.MapVariables.get(world).circle_vl_s < 360) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[tag=LOTW-circle_vl_s] at @s run data merge entity @s {Pose:{Head:[90f,0f,"
									+ LotwModVariables.MapVariables.get(world).circle_vl_s + "f]}}"));
				}
				LotwModVariables.MapVariables.get(world).circle_vl_s = (LotwModVariables.MapVariables.get(world).circle_vl_s - 0.5);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).circle_vl_s = 0;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if (LotwModVariables.MapVariables.get(world).circle_vl_f < 360) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[tag=LOTW-circle_vl_f] at @s run data merge entity @s {Pose:{Head:[90f,0f,"
									+ LotwModVariables.MapVariables.get(world).circle_vl_f + "f]}}"));
				}
				LotwModVariables.MapVariables.get(world).circle_vl_f = (LotwModVariables.MapVariables.get(world).circle_vl_f - 2);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).circle_vl_f = 0;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if (LotwModVariables.MapVariables.get(world).circle_vr_s < 360) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[tag=LOTW-circle_vr_s] at @s run data merge entity @s {Pose:{Head:[90f,0f,"
									+ LotwModVariables.MapVariables.get(world).circle_vr_s + "f]}}"));
				}
				LotwModVariables.MapVariables.get(world).circle_vr_s = (LotwModVariables.MapVariables.get(world).circle_vr_s + 0.5);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).circle_vr_s = 0;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if (LotwModVariables.MapVariables.get(world).circle_vr_f < 360) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[tag=LOTW-circle_vr_f] at @s run data merge entity @s {Pose:{Head:[90f,0f,"
									+ LotwModVariables.MapVariables.get(world).circle_vr_f + "f]}}"));
				}
				LotwModVariables.MapVariables.get(world).circle_vr_f = (LotwModVariables.MapVariables.get(world).circle_vr_f + 2);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).circle_vr_f = 0;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		}
		if (true) {
			if (LotwModVariables.MapVariables.get(world).circle_hl_s < 360) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[tag=LOTW-circle_hl_s] at @s run data merge entity @s {Pose:{Head:[0f,"
									+ LotwModVariables.MapVariables.get(world).circle_hl_s + "f,0f]}}"));
				}
				LotwModVariables.MapVariables.get(world).circle_hl_s = (LotwModVariables.MapVariables.get(world).circle_hl_s - 0.5);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).circle_hl_s = 0;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if (LotwModVariables.MapVariables.get(world).circle_hl_f < 360) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[tag=LOTW-circle_hl_f] at @s run data merge entity @s {Pose:{Head:[0f,"
									+ LotwModVariables.MapVariables.get(world).circle_hl_f + "f,0f]}}"));
				}
				LotwModVariables.MapVariables.get(world).circle_hl_f = (LotwModVariables.MapVariables.get(world).circle_hl_f - 2);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).circle_hl_f = 0;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if (LotwModVariables.MapVariables.get(world).circle_hr_s < 360) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[tag=LOTW-circle_hr_s] at @s run data merge entity @s {Pose:{Head:[0f,"
									+ LotwModVariables.MapVariables.get(world).circle_hr_s + "f,0f]}}"));
				}
				LotwModVariables.MapVariables.get(world).circle_hr_s = (LotwModVariables.MapVariables.get(world).circle_hr_s + 0.5);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).circle_hr_s = 0;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if (LotwModVariables.MapVariables.get(world).circle_hr_f < 360) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[tag=LOTW-circle_hr_f] at @s run data merge entity @s {Pose:{Head:[0f,"
									+ LotwModVariables.MapVariables.get(world).circle_hr_f + "f,0f]}}"));
				}
				LotwModVariables.MapVariables.get(world).circle_hr_f = (LotwModVariables.MapVariables.get(world).circle_hr_f + 2);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).circle_hr_f = 0;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
