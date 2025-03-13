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

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;

public class SummonProtectorBulletHitsBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure SummonProtectorBulletHitsBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure SummonProtectorBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure SummonProtectorBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure SummonProtectorBulletHitsBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency entity for procedure SummonProtectorBulletHitsBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.isSneaking()) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY,
								new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 5.5), (Math.floor(z) + 0.5)), Vector2f.ZERO, (ServerWorld) world,
								4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/summon lantern_of_the_woodlands:protector ~ ~ ~ {NoGravity:1b}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY,
								new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 5.5), (Math.floor(z) + 0.5)), Vector2f.ZERO, (ServerWorld) world,
								4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"particle firework ~ ~ ~ 0 0 0 0.02 5 force");
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY,
								new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 0.5), (Math.floor(z) + 0.5)), Vector2f.ZERO, (ServerWorld) world,
								4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/summon lantern_of_the_woodlands:protector ~ ~ ~ {NoGravity:1b}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY,
								new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 0.75), (Math.floor(z) + 0.5)), Vector2f.ZERO,
								(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"particle firework ~ ~ ~ 0 0 0 0.02 5 force");
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager()
					.handleCommand(new CommandSource(ICommandSource.DUMMY,
							new Vector3d((Math.floor(x) + 0.5), (Math.floor(y) + 0.75), (Math.floor(z) + 0.5)), Vector2f.ZERO, (ServerWorld) world, 4,
							"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"fill ~ ~ ~ ~ ~ ~ air replace lantern_of_the_woodlands:protector_block");
		}
	}
}
