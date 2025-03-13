package lotw.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell3clickUPGRADEProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell3clickUPGRADE!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell3clickUPGRADE!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell3clickUPGRADE!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell3clickUPGRADE!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (LotwModVariables.MapVariables.get(world).mana >= 15) {
			if (LotwModVariables.MapVariables.get(world).spell3_speed == 8) {
				LotwModVariables.MapVariables.get(world).mana = (LotwModVariables.MapVariables.get(world).mana - 15);
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell3_speed = 16;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if (LotwModVariables.MapVariables.get(world).spell3_speed == 4) {
				LotwModVariables.MapVariables.get(world).mana = (LotwModVariables.MapVariables.get(world).mana - 15);
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell3_speed = 8;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if (LotwModVariables.MapVariables.get(world).spell3_speed == 2) {
				LotwModVariables.MapVariables.get(world).mana = (LotwModVariables.MapVariables.get(world).mana - 15);
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell3_speed = 4;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if (LotwModVariables.MapVariables.get(world).spell3_speed == 1) {
				LotwModVariables.MapVariables.get(world).mana = (LotwModVariables.MapVariables.get(world).mana - 15);
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell3_speed = 2;
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

				LanternGroundStateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 5);
	}
}
