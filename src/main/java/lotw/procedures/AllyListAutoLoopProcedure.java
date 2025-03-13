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

public class AllyListAutoLoopProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure AllyListAutoLoop!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure AllyListAutoLoop!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure AllyListAutoLoop!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure AllyListAutoLoop!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		String id = "";
		id = LotwModVariables.MapVariables.get(world).ally_list_auto1;
		for (int index0 = 0; index0 < (int) (5); index0++) {
			if (true) {
				if ((LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User")
						|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User and Chosen")
						|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User and Ally")
						|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User, Chosen and Ally")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute if entity " + ("@e[type=" + id + ",tag=!LOTW-ally]")
										+ " run tellraw @p[tag=LOTW-user] [\"\",{\"text\":\"Added \",\"color\":\"dark_green\"},{\"text\":\"\",\"color\":\"gray\",\"extra\":[{\"selector\":\""
										+ ("@e[type=" + id + ",tag=!LOTW-ally]")
										+ "\"}]},{\"text\":\" to lantern ally list\",\"color\":\"dark_green\"}]"));
					}
				}
				if ((LotwModVariables.MapVariables.get(world).ally_list_chat).equals("Ally")
						|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User and Ally")
						|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("Chosen and Ally")
						|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User, Chosen and Ally")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute if entity " + ("@e[type=" + id + ",tag=!LOTW-ally]") + " run tellraw " + "@a[tag=LOTW-ally,tag=!LOTW-user]"
										+ " [\"\",{\"text\":\"\",\"color\":\"dark_green\",\"extra\":[{\"selector\":\"@p[tag=LOTW-user]\"}]},{\"text\":\" added \",\"color\":\"dark_green\"},{\"text\":\"\",\"color\":\"gray\",\"extra\":[{\"selector\":\""
										+ ("@e[type=" + id + ",tag=!LOTW-ally]")
										+ "\"}]},{\"text\":\" to lantern ally list\",\"color\":\"dark_green\"}]"));
					}
				}
				if ((LotwModVariables.MapVariables.get(world).ally_list_chat).equals("Chosen")
						|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User and Chosen")
						|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("Chosen and Ally")
						|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User, Chosen and Ally")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute if entity " + ("@e[type=" + id + ",tag=!LOTW-ally]") + " run tellraw "
										+ ("@e[type=" + id + ",tag=!LOTW-ally]")
										+ " [\"\",{\"text\":\"\",\"color\":\"dark_green\",\"extra\":[{\"selector\":\"@p[tag=LOTW-user]\"}]},{\"text\":\" added you to lantern ally list\",\"color\":\"dark_green\"}]"));
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute if entity " + ("@e[type=" + id + ",tag=!LOTW-ally]") + " run effect give "
									+ ("@e[type=" + id + ",tag=!LOTW-ally]") + " glowing 5 1 true"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute if entity " + ("@e[type=" + id + ",tag=!LOTW-ally]") + " run tag " + ("@e[type=" + id + ",tag=!LOTW-ally]")
									+ " add LOTW-ally"));
				}
			}
			if ((id).equals(LotwModVariables.MapVariables.get(world).ally_list_auto1)) {
				id = LotwModVariables.MapVariables.get(world).ally_list_auto2;
			} else if ((id).equals(LotwModVariables.MapVariables.get(world).ally_list_auto2)) {
				id = LotwModVariables.MapVariables.get(world).ally_list_auto3;
			} else if ((id).equals(LotwModVariables.MapVariables.get(world).ally_list_auto3)) {
				id = LotwModVariables.MapVariables.get(world).ally_list_auto4;
			} else {
				id = LotwModVariables.MapVariables.get(world).ally_list_auto5;
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

					AllyListAutoLoopProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 1200);
		}
	}
}
