package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class COMMANDSpell4TravelProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "entity")) {
				if (CommandResultProcedure.execute(entityiterator, ReplaceIDProcedure.execute(entity, "execute positioned ^ ^ ^32 if loaded ~ ~ ~"))) {
					if (!("When Near Target Arrow").isEmpty()) {
						if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_homing == true) {
							if (CommandResultProcedure.execute(entityiterator, ReplaceIDProcedure.execute(entity, "execute if entity @e[tag=<USER>,tag=<ID>-spell4_target,distance=..2.5]"))) {
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands()
												.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
														_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														ReplaceIDProcedure.execute(entity, "execute positioned ~ ~1.5 ~ run particle minecraft:sweep_attack ~ ~ ~ 0 0 0 3 1 force"));
									}
								}
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												ReplaceIDProcedure.execute(entity, "execute positioned ~ ~1.5 ~ run playsound minecraft:entity.player.attack.sweep ambient @a[distance=..100] ~ ~ ~ 1 1 0.025"));
									}
								}
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												ReplaceIDProcedure.execute(entity,
														"tp @s ~ ~ ~ facing ^" + Mth.nextDouble(RandomSource.create(), -1, 1) + " ^" + Mth.nextDouble(RandomSource.create(), -1, 1) + " ^" + Mth.nextDouble(RandomSource.create(), 0, 1)));
									}
								}
							}
						}
					}
					for (int index0 = 0; index0 < 8; index0++) {
						if (!("Tp Forward & Hit Block").isEmpty()) {
							if (CommandResultProcedure.execute(entityiterator, ReplaceIDProcedure.execute(entity, "execute positioned ~ ~1.5 ~ positioned ^ ^ ^0.75 " + "if block ~ ~ ~ #lanternofthewoodlands:passable_blocks"))) {
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands()
												.performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														("execute positioned ~ ~1.5 ~ positioned ^ ^ ^0.5 " + "if block ~ ~ ~ #lanternofthewoodlands:passable_blocks at @s run tp @s ^ ^ ^0.5"));
									}
								}
							} else {
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands()
												.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
														_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														("execute positioned ~ ~1.5 ~ positioned ^ ^ ^0.5 " + "run particle minecraft:campfire_cosy_smoke ~ ~ ~ 0 0 0 0.01 5 force"));
									}
								}
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												("execute positioned ~ ~1.5 ~ positioned ^ ^ ^0.5 " + "run playsound minecraft:item.trident.hit_ground ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025"));
									}
								}
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												ReplaceIDProcedure.execute(entity, "tag @s add <ID>-spell4_hit"));
									}
								}
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												ReplaceIDProcedure.execute(entity, "tag @s remove <ID>-spell4_shoot"));
									}
								}
							}
						}
						if (!("Hit Entity").isEmpty()) {
							if (CommandResultProcedure.execute(entityiterator, ReplaceIDProcedure.execute(entity, "execute if entity @e[type=!#lanternofthewoodlands:spell4_atack_blacklist,tag=!<USER>-ally,distance=.." + 1.5 + "]"))) {
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												ReplaceIDProcedure.execute(entity, "execute as @e[type=!#lanternofthewoodlands:spell4_atack_blacklist,tag=!<USER>-ally,distance=.." + 1.5 + "] at @s run tag @s add <USER>-spell4_hit_entity"));
									}
								}
							}
						}
					}
					if (!("Hit Entity Effect").isEmpty()) {
						if (CommandResultProcedure.execute(entity, ReplaceIDProcedure.execute(entity, "execute if entity @e[tag=<USER>-spell4_hit_entity]"))) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										ReplaceIDProcedure.execute(entity,
												"execute as @e[tag=<USER>-spell4_hit_entity] at @s anchored eyes positioned ^ ^ ^ positioned ~ ~-1 ~ run playsound minecraft:item.trident.throw ambient @a[distance=..100] ~ ~ ~ 1 0.75 0.025"));
							if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_constant == false) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											ReplaceIDProcedure.execute(entity, "execute as @e[tag=<USER>-spell4_hit_entity] at @s anchored eyes positioned ^ ^ ^ positioned ~ ~-1 ~ run particle minecraft:sweep_attack ~ ~ ~ 0 0 0 3 1 force"));
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											ReplaceIDProcedure.execute(entity, "execute as @e[tag=<USER>-spell4_hit_entity] at @s run damage @s " + 5 + " minecraft:player_attack by @p[tag=<USER>]"));
							} else {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											ReplaceIDProcedure.execute(entity, "execute as @e[tag=<USER>-spell4_hit_entity] at @s anchored eyes positioned ^ ^ ^ positioned ~ ~-1 ~ run particle minecraft:explosion ~ ~ ~ 0 0 0 1 1 force"));
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											ReplaceIDProcedure.execute(entity, "execute as @e[tag=<USER>-spell4_hit_entity] at @s run damage @s " + 25 + " minecraft:player_attack by @p[tag=<USER>]"));
							}
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										ReplaceIDProcedure.execute(entity, "tag @e[tag=<USER>-spell4_hit_entity] remove <USER>-spell4_hit_entity"));
						}
					}
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
