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

public class RootsBlockTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure RootsBlockTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure RootsBlockTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure RootsBlockTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure RootsBlockTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (LotwModVariables.MapVariables.get(world).lantern_on_ground == 1) {
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] if entity @e[name=LOTW-roots,y_rotation=0] run execute at @e[type=arrow,nbt={inGround:1b},distance=1.5..100] run summon item ~ ~ ~ {Item:{id:\"minecraft:arrow\",Count:1b}}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] if entity @e[name=LOTW-roots,y_rotation=0] run execute at @e[type=minecraft:arrow,nbt={inGround:1b},distance=1.5..100] run playsound minecraft:block.conduit.attack.target ambient @a[distance=..100] ~ ~ ~ 0.5 2 0.025");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] if entity @e[name=LOTW-roots,y_rotation=0] run execute at @e[type=minecraft:arrow,nbt={inGround:1b},distance=1.5..100] run particle minecraft:smoke ~ ~ ~ 0.2 0.2 0.2 0.01 10 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] if entity @e[name=LOTW-roots,y_rotation=0] run execute as @e[type=minecraft:arrow,nbt={inGround:1b},distance=1.5..100] at @s run kill @s");
				}
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-placed_lantern] run execute as @e[type=item,distance=2..100] at @s run data merge entity @s {NoGravity:1b,Motion:[0.0,0.0,0.0]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-placed_lantern] run execute as @e[type=experience_orb,distance=2..100] at @s run data merge entity @s {NoGravity:1b,Motion:[0.0,0.0,0.0]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute if entity @e[name=LOTW-placed_lantern] run execute at @e[name=LOTW-placed_lantern] run particle minecraft:enchant ~ ~1.5 ~ 0 0 0 1 1 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute if entity @e[name=LOTW-placed_lantern] run execute at @e[name=LOTW-roots_particle] run particle minecraft:crit ~ ~0.25 ~ 0 0 0 0.1 1 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute if entity @e[name=LOTW-placed_lantern] run execute at @e[name=LOTW-roots,y_rotation=0] run execute at @e[type=item,distance=2.5..100] run playsound minecraft:block.conduit.ambient.short ambient @a[distance=..100] ~ ~ ~ 1 2 0.025");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute if entity @e[name=LOTW-placed_lantern] run execute at @e[name=LOTW-roots,y_rotation=0] run execute at @e[type=experience_orb,distance=2.5..100] run playsound minecraft:block.conduit.ambient.short ambient @a[distance=..100] ~ ~ ~ 1 2 0.025");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute if entity @e[name=LOTW-placed_lantern] run execute at @e[name=LOTW-roots,y_rotation=0] run execute at @e[name=LOTW-placed_lantern] run playsound minecraft:block.conduit.attack.target ambient @a[distance=..100] ~ ~ ~ 1 0 0.025");
			}
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] if entity @e[name=LOTW-roots,y_rotation=0] run execute as @e[type=item,distance=1.5..100] at @s facing entity @e[name=LOTW-placed_lantern] feet run tp @s ^ ^ ^0.5");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] if entity @e[name=LOTW-roots,y_rotation=0] run execute as @e[type=item,distance=1.5..100] at @s facing entity @e[name=LOTW-placed_lantern] feet run tp @s ^ ^ ^0.5");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] if entity @e[name=LOTW-roots,y_rotation=0] run execute as @e[type=item,distance=1.5..100] at @s facing entity @e[name=LOTW-placed_lantern] feet run tp @s ^ ^ ^0.5");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] if entity @e[name=LOTW-roots,y_rotation=0] run execute as @e[type=item,distance=1.5..100] at @s facing entity @e[name=LOTW-placed_lantern] feet run tp @s ^ ^ ^0.5");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] if entity @e[name=LOTW-roots,y_rotation=0] run execute as @e[type=experience_orb,distance=1.5..100] at @s facing entity @e[name=LOTW-placed_lantern] feet run tp @s ^ ^ ^0.5");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] if entity @e[name=LOTW-roots,y_rotation=0] run execute as @e[type=experience_orb,distance=1.5..100] at @s facing entity @e[name=LOTW-placed_lantern] feet run tp @s ^ ^ ^0.5");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] if entity @e[name=LOTW-roots,y_rotation=0] run execute as @e[type=experience_orb,distance=1.5..100] at @s facing entity @e[name=LOTW-placed_lantern] feet run tp @s ^ ^ ^0.5");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] if entity @e[name=LOTW-roots,y_rotation=0] run execute as @e[type=experience_orb,distance=1.5..100] at @s facing entity @e[name=LOTW-placed_lantern] feet run tp @s ^ ^ ^0.5");
				}
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-placed_lantern] run execute as @e[name=LOTW-roots] at @s run tp @s ~ ~ ~ ~10 ~");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-placed_lantern] run execute if entity @e[name=LOTW-roots,y_rotation=0] run execute at @e[type=item,distance=2..100,sort=random,limit=10] run summon armor_stand ~ ~ ~ {CustomName:'{\"text\":\"LOTW-roots_particle\"}',NoGravity:1b,Invisible:1b,Marker:1b}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-placed_lantern] run execute if entity @e[name=LOTW-roots,y_rotation=0] run execute at @e[type=experience_orb,distance=2..100,sort=random,limit=10] run summon armor_stand ~ ~ ~ {CustomName:'{\"text\":\"LOTW-roots_particle\"}',NoGravity:1b,Invisible:1b,Marker:1b}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-placed_lantern] run execute as @e[name=LOTW-roots_particle,distance=1.5..] at @s facing entity @e[name=LOTW-placed_lantern] feet run tp @s ^ ^ ^0.5");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-placed_lantern] run kill @e[name=LOTW-roots_particle,distance=..1.5]");
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=item] at @s run data merge entity @s {NoGravity:0b}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=experience_orb] at @s run data merge entity @s {NoGravity:0b}");
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute at @e[name=LOTW-roots] run particle minecraft:ambient_entity_effect ~ ~-0.5 ~ 0 0 0 0 1 force");
		}
	}
}
