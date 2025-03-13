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

public class Spell5entityRepeatFastProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell5entityRepeatFast!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell5entityRepeatFast!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell5entityRepeatFast!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell5entityRepeatFast!");
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
					"tag @e[type=armor_stand,name=lotw-mazer_entity] add lotw-mazer_entity_move");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute as @e[tag=lotw-mazer_entity_target] at @s positioned ^ ^ ^5 run tag @e[type=armor_stand,name=lotw-mazer_entity,distance=..4] remove lotw-mazer_entity_move");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute as @e[tag=lotw-mazer_entity_target] at @s positioned ^ ^ ^10 run tag @e[type=armor_stand,name=lotw-mazer_entity,distance=..10] remove lotw-mazer_entity_move");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute as @e[tag=lotw-mazer_entity_target] at @s positioned ^ ^ ^15 run tag @e[type=armor_stand,name=lotw-mazer_entity,distance=..15] remove lotw-mazer_entity_move");
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
					"/execute as @e[type=armor_stand,name=lotw-mazer_entity,tag=lotw-mazer_entity_move] at @s run tp @s ~ ~ ~ facing entity @e[tag=lotw-mazer_entity_target,limit=1,sort=nearest]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute as @e[type=armor_stand,name=lotw-mazer_entity,tag=lotw-mazer_entity_move] at @s facing entity @e[tag=lotw-mazer_entity_target,limit=1,sort=nearest] feet if block ^ ^1 ^1 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute as @e[tag=lotw-mazer_entity_target] at @s if entity @e[type=armor_stand,name=lotw-mazer_entity,distance=..2] run tp @s ~ ~ ~ facing entity @e[type=armor_stand,name=MazerTrap,limit=1,sort=nearest]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute as @e[tag=lotw-mazer_entity_target] at @s if entity @e[type=armor_stand,name=lotw-mazer_entity,distance=..2] run tp @s ^ ^ ^0.25");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute as @e[tag=lotw-mazer_entity_target] at @s if entity @e[type=armor_stand,name=lotw-mazer_entity,distance=..2] run effect give @s minecraft:blindness 1 1 true");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute as @e[tag=lotw-mazer_entity_target] at @s if entity @e[type=armor_stand,name=lotw-mazer_entity,distance=..2] run effect give @s minecraft:slowness 1 100 true");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute as @e[type=armor_stand,name=lotw-mazer_entity,tag=lotw-mazer_entity_move] at @s facing entity @e[tag=lotw-mazer_entity_target,limit=1,sort=nearest] feet if block ^ ^1 ^1 #minecraft:air_blocks run playsound minecraft:entity.armor_stand.place ambient @a[distance=..50] ~ ~ ~ 1 0 0.025");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @e[tag=lotw-mazer_entity_target] if entity @e[type=armor_stand,name=lotw-mazer_entity,distance=..2] run playsound minecraft:entity.enderman.death ambient @a[distance=..50] ~ ~ ~ 0.2 0 0.025");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @e[tag=lotw-mazer_entity_target] if entity @e[type=armor_stand,name=lotw-mazer_entity,distance=..2] run particle minecraft:large_smoke ~ ~1 ~ 0.5 0.5 0.5 0.01 5 force");
		}
	}
}
