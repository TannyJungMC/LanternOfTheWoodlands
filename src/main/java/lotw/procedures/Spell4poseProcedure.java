package lotw.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell4poseProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4pose!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell4pose!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell4pose!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell4pose!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double degree = 0;
		double degree_distance = 0;
		degree = (-90);
		degree_distance = 10;
		for (int index0 = 0; index0 < (int) (180 / degree_distance); index0++) {
			if ((LotwModVariables.MapVariables.get(world).spell4_target_lock).equals("On")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[name=LOTW-weapon_manipulation_target1] at @s run data merge entity @s {Pose:{Head:[0f,0f,0f]}}");
				}
			} else if ((LotwModVariables.MapVariables.get(world).spell4_target_lock).equals("Off")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[name=LOTW-weapon_manipulation_target1] at @s if entity @p[tag=LOTW-user,distance=..0.5] run data merge entity @s {Pose:{Head:[0f,0f,0f]}}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute if entity @p[tag=LOTW-user,x_rotation=" + (degree + ".." + (degree + degree_distance))
									+ "] as @e[name=LOTW-weapon_manipulation_target1] at @s unless entity @p[tag=LOTW-user,distance=..0.5] run data merge entity @s {Pose:{Head:["
									+ degree * (-1) + "f,0f,0f]}}"));
				}
			}
			if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
					|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Sword"))
					&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type1 != 0) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[tag=LOTW-weapon_manipulation_type1,x_rotation=" + (degree + ".." + (degree + degree_distance))
									+ "] at @s run data merge entity @s {Pose:{RightArm:[" + (degree - 0) + "f,0f,0f]}}"));
				}
			}
			if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
					|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Shield"))
					&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type2 != 0) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[tag=LOTW-weapon_manipulation_type2,x_rotation=" + (degree + ".." + (degree + degree_distance))
									+ "] at @s run data merge entity @s {Pose:{RightArm:[0f," + (degree - 75) + "f,-90f]}}"));
				}
			}
			if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
					|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Bow"))
					&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type4 != 0) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[tag=LOTW-weapon_manipulation_type4,x_rotation=" + (degree + ".." + (degree + degree_distance))
									+ "] at @s run data merge entity @s {Pose:{LeftArm:[" + (degree - 0) + "f,0f,0f]}}"));
				}
			}
			degree = (degree + degree_distance);
		}
	}
}
