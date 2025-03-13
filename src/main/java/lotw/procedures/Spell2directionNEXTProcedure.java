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

public class Spell2directionNEXTProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell2directionNEXT!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell2directionNEXT!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell2directionNEXT!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell2directionNEXT!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double distance = 0;
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"kill @e[tag=LOTW-spell2direction]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("execute at @e[name=LOTW-spell2main] run summon armor_stand ~ ~0.05 ~-"
							+ (LotwModVariables.MapVariables.get(world).spell2_size + 0.5)
							+ " {CustomName:'{\"text\":\"N\",\"color\":\"red\"}}',Tags:[\"LOTW-ally\",\"LOTW-spell2direction\"],CustomNameVisible:1b,Marker:1b,Invisible:1b,Small:1b,NoGravity:1b}"));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("execute at @e[name=LOTW-spell2main] run summon armor_stand ~ ~0.05 ~"
							+ (LotwModVariables.MapVariables.get(world).spell2_size + 0.5)
							+ " {CustomName:'{\"text\":\"S\",\"color\":\"blue\"}}',Tags:[\"LOTW-ally\",\"LOTW-spell2direction\"],CustomNameVisible:1b,Marker:1b,Invisible:1b,Small:1b,NoGravity:1b}"));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("execute at @e[name=LOTW-spell2main] run summon armor_stand ~" + (LotwModVariables.MapVariables.get(world).spell2_size + 0.5)
							+ " ~0.05 ~ {CustomName:'{\"text\":\"E\",\"color\":\"yellow\"}}',Tags:[\"LOTW-ally\",\"LOTW-spell2direction\"],CustomNameVisible:1b,Marker:1b,Invisible:1b,Small:1b,NoGravity:1b}"));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("execute at @e[name=LOTW-spell2main] run summon armor_stand ~-" + (LotwModVariables.MapVariables.get(world).spell2_size + 0.5)
							+ " ~0.05 ~ {CustomName:'{\"text\":\"W\",\"color\":\"green\"}}',Tags:[\"LOTW-ally\",\"LOTW-spell2direction\"],CustomNameVisible:1b,Marker:1b,Invisible:1b,Small:1b,NoGravity:1b}"));
		}
	}
}
