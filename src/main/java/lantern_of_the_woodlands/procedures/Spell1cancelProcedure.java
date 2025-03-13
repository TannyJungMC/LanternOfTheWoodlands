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

public class Spell1cancelProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell1cancel!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell1cancel!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell1cancel!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell1cancel!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency entity for procedure Spell1cancel!");
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
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @e[type=armor_stand,name=SupportStation] run fill ~1 ~1 ~1 ~-1 ~-1 ~-1 air replace lantern_of_the_woodlands:support_station");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @e[type=armor_stand,name=SupportStationMedium] run fill ~1 ~1 ~1 ~-1 ~-1 ~-1 air replace lantern_of_the_woodlands:support_station_medium");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @e[type=armor_stand,name=SupportStationLarge] run fill ~1 ~1 ~1 ~-1 ~-1 ~-1 air replace lantern_of_the_woodlands:support_station_large");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/kill @e[type=armor_stand,name=spell1lanternStation]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/kill @e[type=armor_stand,name=SupportStation]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/kill @e[type=armor_stand,name=SupportStationMedium]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/kill @e[type=armor_stand,name=SupportStationLarge]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/clear @a lantern_of_the_woodlands:support_station");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/clear @a lantern_of_the_woodlands:support_station_medium");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/clear @a lantern_of_the_woodlands:support_station_large");
		}
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_specify_position = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_invisible_station = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_speed_rotate = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_station_count = 0;
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).main_spell = 0;
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_lantern_station = (true);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_clear = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_healing = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_damage_boost = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_protection = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_golden_heart = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_miner = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_barrier = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_camouflage = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_ability = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_orientation = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_water = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_effect_night_vision = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"");
		}
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_clear = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_healing = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_protection = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_damage_boost = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_golden_heart = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_miner = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_barrier = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_camouflage = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_ability = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_orientation = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_water = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell1_start_effect_night_vision = (false);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
	}
}
