package lantern_of_the_woodlands.procedures;

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

import java.util.Map;

public class Spell3summonProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell3summon!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell3summon!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell3summon!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell3summon!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"kill @e[type=minecraft:armor_stand,name=dome-main]");
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_speed >= 1) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[0f,90f]}");
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_speed >= 2) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[180f,90f]}");
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_speed >= 4) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[90f,90f]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[270f,90f]}");
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_speed >= 8) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[45f,90f]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[135f,90f]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[225f,90f]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[315f,90f]}");
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell3_speed >= 16) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[22.5f,90f]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[112.5f,90f]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[202.5f,90f]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[292.5f,90f]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[67.5f,90f]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[157.5f,90f]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[247.5f,90f]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=dome-position] run summon armor_stand ~ ~ ~ {Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"dome-main\"}',Rotation:[337.5f,90f]}");
			}
		}
	}
}
