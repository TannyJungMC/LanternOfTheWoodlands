package lotw.procedures;

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

public class Spell3cancelResetAllProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell3cancelResetAll!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell3cancelResetAll!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell3cancelResetAll!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell3cancelResetAll!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell3cancelResetAll!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (LotwModVariables.MapVariables.get(world).main_spell == 3) {
			CancelSpellProcedure
					.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager()
					.handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"kill @e[name=LOTW-dome_main]");
		}
		LotwModVariables.MapVariables.get(world).spell3_gen = (false);
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_pause = (false);
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_start = (false);
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_cancel = (false);
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_particle = (false);
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_no_block = (false);
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_dome_particle = (false);
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_block_arrow = (false);
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_block_damage = (false);
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_time = 0;
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_left_right = 0;
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_percent = 0;
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_speed = 1;
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_up_dawn = 0;
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_time_minute = 0;
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_time_second = 0;
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_percent_full = 0;
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_insert = "5";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_show_time = "0:0";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_show_percent_status = "Generating";
		LotwModVariables.MapVariables.get(world).syncData(world);
		LotwModVariables.MapVariables.get(world).spell3_show_percent = "100";
		LotwModVariables.MapVariables.get(world).syncData(world);
	}
}
