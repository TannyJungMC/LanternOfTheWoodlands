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

import lotw.LotwMod;

import java.util.Map;

public class SummonProtectorBulletHitsBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure SummonProtectorBulletHitsBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure SummonProtectorBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure SummonProtectorBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure SummonProtectorBulletHitsBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure SummonProtectorBulletHitsBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		String summon = "";
		String particle = "";
		if (entity.isSneaking()) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 5.5), (z + 0.5)), Vector2f.ZERO,
								(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/summon lotw:protector ~ ~ ~ {Tags:[\"LOTW-ally\"],NoGravity:1b}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 5.5), (z + 0.5)), Vector2f.ZERO,
								(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"particle firework ~ ~ ~ 0 0 0 0.02 5 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 5.5), (z + 0.5)), Vector2f.ZERO,
								(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"playsound minecraft:block.wool.place ambient @a[distance=..100] ~ ~ ~ 1 0 0.025");
			}
		} else {
			summon = "summon lotw:protector ~ ~ ~ {Tags:[\"LOTW-ally\"],NoGravity:1b}";
			particle = "particle firework ~ ~ ~ 0 0 0 0.02 5 force";
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
									4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute positioned " + "~1 ~ ~ " + "if block ~ ~ ~ #minecraft:air_blocks run " + summon));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
									4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute positioned " + "~-1 ~ ~ " + "if block ~ ~ ~ #minecraft:air_blocks run " + summon));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
									4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute positioned " + "~ ~ ~1 " + "if block ~ ~ ~ #minecraft:air_blocks run " + summon));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
									4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute positioned " + "~ ~ ~-1 " + "if block ~ ~ ~ #minecraft:air_blocks run " + summon));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
									4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute positioned " + "~ ~1 ~ " + "if block ~ ~ ~ #minecraft:air_blocks run " + summon));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
									4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute positioned " + "~ ~-1 ~ " + "if block ~ ~ ~ #minecraft:air_blocks run " + summon));
				}
			}
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
									4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute positioned " + "~1 ~ ~ " + "if block ~ ~ ~ #minecraft:air_blocks run " + particle));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
									4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute positioned " + "~-1 ~ ~ " + "if block ~ ~ ~ #minecraft:air_blocks run " + particle));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
									4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute positioned " + "~ ~ ~1 " + "if block ~ ~ ~ #minecraft:air_blocks run " + particle));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
									4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute positioned " + "~ ~ ~-1 " + "if block ~ ~ ~ #minecraft:air_blocks run " + particle));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
									4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute positioned " + "~ ~1 ~ " + "if block ~ ~ ~ #minecraft:air_blocks run " + particle));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO, (ServerWorld) world,
									4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/execute positioned " + "~ ~-1 ~ " + "if block ~ ~ ~ #minecraft:air_blocks run " + particle));
				}
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d((x + 0.5), (y + 0.5), (z + 0.5)), Vector2f.ZERO,
								(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"playsound minecraft:block.wool.place ambient @a[distance=..100] ~ ~ ~ 1 0 0.025");
			}
		}
	}
}
