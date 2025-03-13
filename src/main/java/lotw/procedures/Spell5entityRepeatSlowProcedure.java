package lotw.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lotw.LotwMod;

import java.util.Map;

public class Spell5entityRepeatSlowProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell5entityRepeatSlow!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell5entityRepeatSlow!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell5entityRepeatSlow!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell5entityRepeatSlow!");
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
					"execute at @e[name=LOTW-mazer_entity] if entity @e[name=LOTW-mazer_trap,distance=..2] if entity @e[tag=LOTW-mazer_entity_target,distance=..2] run execute at @e[name=LOTW-mazer_trap,limit=1,sort=random] run summon armor_stand ~ ~-1 ~ {Tags:[\"LOTW-ally\"],NoGravity:1b,Marker:1b,Invisible:0b,CustomName:'{\"text\":\"LOTW-mazer_entity\"}',ShowArms:1b,NoBasePlate:1b}");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute at @e[name=LOTW-mazer_entity] if entity @e[name=LOTW-mazer_trap,distance=..2] if entity @e[tag=LOTW-mazer_entity_target,distance=..2] run particle minecraft:flash ~ ~ ~ 0 0 0 0 1 force");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute at @e[name=LOTW-mazer_entity] if entity @e[name=LOTW-mazer_trap,distance=..2] if entity @e[tag=LOTW-mazer_entity_target,distance=..2] run playsound minecraft:entity.zombie.attack_wooden_door ambient @a[distance=..100] ~ ~ ~ 1 0 0.025");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute as @e[name=LOTW-mazer_entity] at @s if entity @e[name=LOTW-mazer_trap,distance=..2] if entity @e[tag=LOTW-mazer_entity_target,distance=..2] run kill @s");
		}
	}
}
