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

public class Spell4shootProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4shoot!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell4shoot!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell4shoot!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell4shoot!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((LotwModVariables.MapVariables.get(world).spell4_mode).equals("Single Shot")) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute unless entity @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
								+ "tag=LOTW-weapon_manipulation_shoot,tag=!LOTW-weapon_manipulation_hit] at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 run tp @e["
								+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
								+ "tag=!LOTW-weapon_manipulation_hit,distance=..3,limit=1,sort=nearest] ~ ~ ~"));
			}
			if (!("Effect").equals("")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute unless entity @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=LOTW-weapon_manipulation_shoot,tag=!LOTW-weapon_manipulation_hit] at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 unless entity @e["
									+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=!LOTW-weapon_manipulation_shoot,tag=!LOTW-weapon_manipulation_hit,distance=..1] at @e[name=LOTW-weapon_manipulation_target] as @e["
									+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=!LOTW-weapon_manipulation_shoot,tag=!LOTW-weapon_manipulation_hit,limit=1,sort=nearest] at @s run particle minecraft:flash ~ ~1 ~ 0.25 0.25 0.25 0.01 1 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute unless entity @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=LOTW-weapon_manipulation_shoot,tag=!LOTW-weapon_manipulation_hit] at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 at @e["
									+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=!LOTW-weapon_manipulation_hit,distance=..1,limit=1] run particle minecraft:flash ~ ~1 ~ 0.25 0.25 0.25 0.01 1 force"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute unless entity @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=LOTW-weapon_manipulation_shoot,tag=!LOTW-weapon_manipulation_hit] at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 unless entity @e["
									+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=!LOTW-weapon_manipulation_shoot,tag=!LOTW-weapon_manipulation_hit,distance=..1] at @e[name=LOTW-weapon_manipulation_target] as @e["
									+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=!LOTW-weapon_manipulation_shoot,tag=!LOTW-weapon_manipulation_hit,limit=1,sort=nearest] at @s run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute unless entity @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=LOTW-weapon_manipulation_shoot,tag=!LOTW-weapon_manipulation_hit] at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 at @e["
									+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=!LOTW-weapon_manipulation_hit,distance=..1,limit=1] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025"));
				}
			}
			if (!("Shoot").equals("")) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute unless entity @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=LOTW-weapon_manipulation_shoot,tag=!LOTW-weapon_manipulation_hit] at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 as @e["
									+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=!LOTW-weapon_manipulation_hit,sort=nearest,distance=..1,limit=1] at @s run tag @s add LOTW-weapon_manipulation_shoot"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute unless entity @e[" + LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=LOTW-weapon_manipulation_shoot,tag=!LOTW-weapon_manipulation_hit] at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 unless entity @e["
									+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=!LOTW-weapon_manipulation_hit,distance=..1] at @e[name=LOTW-weapon_manipulation_target] as @e["
									+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
									+ "tag=!LOTW-weapon_manipulation_shoot,tag=!LOTW-weapon_manipulation_hit,limit=1,sort=nearest] at @s run tag @s add LOTW-weapon_manipulation_shoot"));
				}
			}
		}
		if ((LotwModVariables.MapVariables.get(world).spell4_mode).equals("Auto Shot")) {
			if (LotwModVariables.MapVariables.get(world).spell4_tick_auto_shot <= 20) {
				if (LotwModVariables.MapVariables.get(world).spell4_tick_auto_shot == 10) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 run tp @e["
										+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit,tag=!LOTW-weapon_manipulation_shoot,distance=..6,limit=1,sort=nearest] ~ ~ ~"));
					}
				} else if (LotwModVariables.MapVariables.get(world).spell4_tick_auto_shot == 20) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 unless entity @e["
										+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit,distance=..1] at @e[name=LOTW-weapon_manipulation_target] as @e["
										+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit,tag=!LOTW-weapon_manipulation_shoot,limit=1,sort=nearest] at @s unless entity @e[name=LOTW-weapon_manipulation_target,distance=..3] run particle minecraft:flash ~ ~1 ~ 0.25 0.25 0.25 0.01 1 force"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 at @e["
										+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit,distance=..1,limit=1] run particle minecraft:flash ~ ~1 ~ 0.25 0.25 0.25 0.01 1 force"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 unless entity @e["
										+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit,distance=..1] at @e[name=LOTW-weapon_manipulation_target] as @e["
										+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit,tag=!LOTW-weapon_manipulation_shoot,limit=1,sort=nearest] at @s unless entity @e[name=LOTW-weapon_manipulation_target,distance=..3] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 at @e["
										+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit,distance=..1,limit=1] run playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 if entity @e["
										+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit,distance=..1,limit=1] run tag @e["
										+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit,distance=..1,limit=1] add LOTW-weapon_manipulation_shoot"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @p[tag=LOTW-user] positioned ~ ~1.5 ~ positioned ^-0.5 ^ ^1 unless entity @e["
										+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit,distance=..1] at @e[name=LOTW-weapon_manipulation_target] as @e["
										+ LotwModVariables.MapVariables.get(world).spell4_weapon_type_tag
										+ "tag=!LOTW-weapon_manipulation_hit,tag=!LOTW-weapon_manipulation_shoot,limit=1,sort=nearest] at @s unless entity @e[name=LOTW-weapon_manipulation_target,distance=..3] run tag @s add LOTW-weapon_manipulation_shoot"));
					}
				}
				LotwModVariables.MapVariables.get(world).spell4_tick_auto_shot = (LotwModVariables.MapVariables.get(world).spell4_tick_auto_shot + 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
			} else {
				LotwModVariables.MapVariables.get(world).spell4_tick_auto_shot = 1;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
