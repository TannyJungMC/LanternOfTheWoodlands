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

public class Spell4keyShootRUNProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4keyShootRUN!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell4keyShootRUN!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell4keyShootRUN!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell4keyShootRUN!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell4keyShootRUN!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");

		UserOnlyTestProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		if (LotwModVariables.MapVariables.get(world).user_only == true && LotwModVariables.MapVariables.get(world).spell4_start == true) {
			if (!(LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Off")) {
				if ((LotwModVariables.MapVariables.get(world).spell4_switch_shoot).equals("On")) {
					if (LotwModVariables.MapVariables.get(world).spell4_shoot == false) {
						LotwModVariables.MapVariables.get(world).spell4_shoot = (true);
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else if (LotwModVariables.MapVariables.get(world).spell4_shoot == true) {
						LotwModVariables.MapVariables.get(world).spell4_shoot = (false);
						LotwModVariables.MapVariables.get(world).syncData(world);
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-weapon_manipulation,tag=!LOTW-weapon_manipulation_hit] at @s run tp @s ^ ^ ^-1 facing entity @e[name=LOTW-weapon_manipulation_target,limit=1,distance=..3]");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"tag @e[tag=LOTW-weapon_manipulation_shoot] remove LOTW-weapon_manipulation_shoot");
						}
					}
				} else if ((LotwModVariables.MapVariables.get(world).spell4_switch_shoot).equals("Off")) {
					LotwModVariables.MapVariables.get(world).spell4_shoot = (true);
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				if (LotwModVariables.MapVariables.get(world).spell4_shoot == true) {
					if ((LotwModVariables.MapVariables.get(world).spell4_mode).equals("Multiple Shot")) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
											+ "tag=!LOTW-weapon_manipulation_hit,tag=!LOTW-weapon_manipulation_shoot] run particle minecraft:flash ~ ~1 ~ 0.25 0.25 0.25 0.01 1 force"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
											+ "limit=3,sort=random,tag=!LOTW-weapon_manipulation_hit,tag=!LOTW-weapon_manipulation_shoot] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("tag @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
											+ "tag=!LOTW-weapon_manipulation_hit] add LOTW-weapon_manipulation_shoot"));
						}
					}
				}
			}
		}
	}
}
