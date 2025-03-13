package lantern_of_the_woodlands.procedures;

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

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class BasicSpell6tickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure BasicSpell6tick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure BasicSpell6tick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure BasicSpell6tick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure BasicSpell6tick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_start == false) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_second = 60;
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_tick = 20;
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_start = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_start == true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute if entity @e[tag=basicspell6tag] as @e[type=armor_stand,name=basicspell6] at @s facing entity @e[tag=basicspell6tag,limit=1,sort=nearest] eyes run tp @s ^ ^ ^1");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute if entity @e[tag=basicspell6tag] at @e[type=armor_stand,name=basicspell6] run particle minecraft:reverse_portal ~ ~2 ~ 0 0 0 0.01 3 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute if entity @e[tag=basicspell6tag] at @e[type=armor_stand,name=basicspell6] if entity @p[tag=basicspell6tag,distance=..2] run give @p[tag=basicspell6tag,distance=..2,limit=1] lantern_of_the_woodlands:letter_from_the_other_side");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute if entity @e[tag=basicspell6tag] at @e[type=armor_stand,name=basicspell6] if @p[tag=basicspell6tag,distance=..2] run playsound minecraft:entity.villager.work_librarian ambient @a ~ ~ ~ 1 1");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute if entity @e[tag=basicspell6tag] at @e[type=armor_stand,name=basicspell6] run tag @e[distance=..2] remove basicspell6tag");
			}
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_time_left = ((new java.text.DecimalFormat("##.#")
					.format(LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_second)).replace(".0", ""));
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables
					.get(world).basicspell6_tick = (LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_tick - 1);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_tick < 0) {
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_tick = 20;
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables
						.get(world).basicspell6_second = (LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_second - 1);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_second < 0) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=placed_lantern] run playsound minecraft:entity.villager.work_librarian ambient @a ~ ~ ~ 1 1");
				}
				BasicSpell6cancelProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_second = 60;
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_tick = 20;
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_start = (false);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell6_start == true) {
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

						BasicSpell6tickProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 1);
			}
		}
	}
}
