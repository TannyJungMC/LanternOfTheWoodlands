package lantern_of_the_woodlands.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;

public class Spell4tpProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell4tp!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell4tp!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell4tp!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell4tp!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"1 UP");
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,135f,90f]}}] if block ^ ^-0.5 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,135f,90f]}}] if block ^ ^-0.5 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,135f,90f]}}] if block ^ ^-0.5 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,135f,90f]}}] if block ^ ^-0.5 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,135f,90f]}}] if block ^ ^-0.5 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,135f,90f]}}] if block ^ ^-0.5 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,135f,90f]}}] if block ^ ^-0.5 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,135f,90f]}}] if block ^ ^-0.5 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"2");
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,157.5f,90f]}}] if block ^ ^0.1 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,157.5f,90f]}}] if block ^ ^0.1 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,157.5f,90f]}}] if block ^ ^0.1 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,157.5f,90f]}}] if block ^ ^0.1 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,157.5f,90f]}}] if block ^ ^0.1 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,157.5f,90f]}}] if block ^ ^0.1 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,157.5f,90f]}}] if block ^ ^0.1 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,157.5f,90f]}}] if block ^ ^0.1 ^2 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"3");
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,180f,90f]}}] if block ^ ^0.35 ^1.25 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,180f,90f]}}] if block ^ ^0.35 ^1.25 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,180f,90f]}}] if block ^ ^0.35 ^1.25 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,180f,90f]}}] if block ^ ^0.35 ^1.25 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,180f,90f]}}] if block ^ ^0.35 ^1.25 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,180f,90f]}}] if block ^ ^0.35 ^1.25 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,180f,90f]}}] if block ^ ^0.35 ^1.25 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,180f,90f]}}] if block ^ ^0.35 ^1.25 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"4");
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,202.5f,90f]}}] if block ^ ^0.75 ^1.15 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,202.5f,90f]}}] if block ^ ^0.75 ^1.15 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,202.5f,90f]}}] if block ^ ^0.75 ^1.15 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,202.5f,90f]}}] if block ^ ^0.75 ^1.15 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,202.5f,90f]}}] if block ^ ^0.75 ^1.15 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,202.5f,90f]}}] if block ^ ^0.75 ^1.15 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,202.5f,90f]}}] if block ^ ^0.75 ^1.15 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,202.5f,90f]}}] if block ^ ^0.75 ^1.15 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"5 MID");
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,225f,90f]}}] if block ^ ^1 ^0.6 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,225f,90f]}}] if block ^ ^1 ^0.6 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,225f,90f]}}] if block ^ ^1 ^0.6 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,225f,90f]}}] if block ^ ^1 ^0.6 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,225f,90f]}}] if block ^ ^1 ^0.6 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,225f,90f]}}] if block ^ ^1 ^0.6 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,225f,90f]}}] if block ^ ^1 ^0.6 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,225f,90f]}}] if block ^ ^1 ^0.6 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"6");
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,247.5f,90f]}}] if block ^ ^0.9 ^0.1 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,247.5f,90f]}}] if block ^ ^0.9 ^0.1 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,247.5f,90f]}}] if block ^ ^0.9 ^0.1 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,247.5f,90f]}}] if block ^ ^0.9 ^0.1 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,247.5f,90f]}}] if block ^ ^0.9 ^0.1 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,247.5f,90f]}}] if block ^ ^0.9 ^0.1 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,247.5f,90f]}}] if block ^ ^0.9 ^0.1 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,247.5f,90f]}}] if block ^ ^0.9 ^0.1 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"7");
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,270f,90f]}}] if block ^ ^0.5 ^-0.4 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,270f,90f]}}] if block ^ ^0.5 ^-0.4 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,270f,90f]}}] if block ^ ^0.5 ^-0.4 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,270f,90f]}}] if block ^ ^0.5 ^-0.4 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,270f,90f]}}] if block ^ ^0.5 ^-0.4 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,270f,90f]}}] if block ^ ^0.5 ^-0.4 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,270f,90f]}}] if block ^ ^0.5 ^-0.4 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,270f,90f]}}] if block ^ ^0.5 ^-0.4 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"8");
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,292.5f,90f]}}] if block ^ ^0.05 ^-0.75 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,292.5f,90f]}}] if block ^ ^0.05 ^-0.75 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,292.5f,90f]}}] if block ^ ^0.05 ^-0.75 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,292.5f,90f]}}] if block ^ ^0.05 ^-0.75 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,292.5f,90f]}}] if block ^ ^0.05 ^-0.75 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,292.5f,90f]}}] if block ^ ^0.05 ^-0.75 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,292.5f,90f]}}] if block ^ ^0.05 ^-0.75 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,292.5f,90f]}}] if block ^ ^0.05 ^-0.75 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"9");
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,315f,90f]}}] if block ^ ^ ^-0.9 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,315f,90f]}}] if block ^ ^ ^-0.9 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,315f,90f]}}] if block ^ ^ ^-0.9 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,315f,90f]}}] if block ^ ^ ^-0.9 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,315f,90f]}}] if block ^ ^ ^-0.9 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,315f,90f]}}] if block ^ ^ ^-0.9 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,315f,90f]}}] if block ^ ^ ^-0.9 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4shoot,tag=shoot] at @s if entity @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,nbt={Pose:{Head:[90f,315f,90f]}}] if block ^ ^ ^-0.9 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
			}
		}
	}
}
