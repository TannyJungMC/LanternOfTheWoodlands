package lantern_of_the_woodlands.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell3cancelProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell3cancel!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell3cancel!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell3cancel!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell3cancel!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency entity for procedure Spell3cancel!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");

		Spell3summonProcedure
				.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_start == true) {
			LanternOfTheWoodlandsModVariables.MapVariables
					.get(world).spell3_time = (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_percent_full
							- LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time
							+ (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_percent_full
									- LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time) * (5 / 100));
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_gen = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_pause = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_cancel = (true);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_start == false) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"kill @e[type=minecraft:armor_stand,name=dome-position]");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"kill @e[type=minecraft:armor_stand,name=dome-main]");
			}
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_gen = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_pause = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_start = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_cancel = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_particle = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_cancel_click_again = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_remove_click_again = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_invisible_dome = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_walk = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_no_block = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_dome_particle = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_block_arrow = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_block_damage = (false);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time = 0;
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_left_right = 0;
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_percent = 0;
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_speed = 1;
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_up_dawn = 0;
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time_minute = 0;
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_time_second = 0;
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_percent_full = 0;
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_insert = "6";
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			CancelSpellProcedure
					.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
