package lantern_of_the_woodlands.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;

public class Spell3removeINSProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell3removeINS!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_remove_click_again == true) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_start = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_gen = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time = 0;
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
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
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_remove_click_again = (false);
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 5);
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_remove_click_again == false) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_remove_click_again = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
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
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_remove_click_again = (false);
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 100);
		}
	}
}
