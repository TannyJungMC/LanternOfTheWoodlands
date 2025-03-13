package lantern_of_the_woodlands.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell2cancelProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell2cancel!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell2cancel!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell2cancel!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell2cancel!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency entity for procedure Spell2cancel!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");

		CancelSpellProcedure
				.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_all = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_player = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_entity = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_tracker = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_show_waypoint = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_start_repeat = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification_tracker = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification_other_team = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_notification_buoy = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_findkey_status = 0;
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_level = 0;
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell2_findkey_list = "";
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager()
					.handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/tag @e remove spelltracker");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager()
					.handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/tag @e remove spell2findkey");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/clear @a lantern_of_the_woodlands:tracker");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/clear @a lantern_of_the_woodlands:spell_2waypoint_block");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/kill @e[type=armor_stand,name=spell2main]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @e[type=armor_stand,name=spell2waypoint] run setblock ~ ~ ~ air");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/kill @e[type=armor_stand,name=spell2waypoint]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/kill @e[type=armor_stand,name=lighthouse]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/kill @e[type=armor_stand,tag=spell2direction]");
		}
	}
}
