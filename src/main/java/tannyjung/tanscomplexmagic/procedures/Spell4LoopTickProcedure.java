package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class Spell4LoopTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String variable_text = "";
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Off")) {
			if (!("Target Arrow").isEmpty()) {
				if (true) {
					if (!("Distance Changing").isEmpty()) {
						if (true) {
							if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distance_set == 1) {
								if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distance > 0) {
									{
										TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
										_vars.spell4_distance = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distance - 1;
										_vars.markSyncDirty();
									}
								}
							} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distance_set == 2) {
								if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distance < 100) {
									{
										TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
										_vars.spell4_distance = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distance + 1;
										_vars.markSyncDirty();
									}
								}
							}
						}
					}
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_lock_target == false) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										ReplaceIDProcedure.execute(entity, "execute anchored eyes positioned ^ ^ ^" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_distance
												+ " positioned ~ ~-1.5 ~ run tp @e[tag=<USER>,tag=<ID>-spell4_target] ~ ~ ~ facing entity @s eyes"));
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									ReplaceIDProcedure.execute(entity, "data merge entity @e[tag=<USER>,tag=<ID>-spell4_target,limit=1] {Pose:{Head:[" + entity.getXRot() * (-1) + "f,0f,0f]}}"));
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									ReplaceIDProcedure.execute(entity, "execute as @e[tag=<USER>,tag=<ID>-spell4_target] at @s run tp @s ~ ~ ~ ~5 ~"));
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									ReplaceIDProcedure.execute(entity, "execute at @e[tag=<USER>-spell4_lock_target] anchored eyes run tp @e[tag=<USER>,tag=<ID>-spell4_target] ~ ~2 ~"));
					}
				}
			}
			if (!("Summon Weapon").isEmpty()) {
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).main_key == true) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_shoot == true || entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_reverse == true) {
						Spell4SummonPickUpProcedure.execute(world, x, y, z, entity);
					}
				}
			}
			if (!("Weapon System").isEmpty()) {
				if (CommandResultProcedure.execute(entity, ReplaceIDProcedure.execute(entity, "execute if entity @e[tag=<USER>,tag=<ID>-spell4_sword]"))) {
					if (!("Direction & Pose").isEmpty()) {
						if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).main_key == true && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_shoot == false
								&& entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_reverse == true)) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											ReplaceIDProcedure.execute(entity, CommandEntityProcedure.execute("spell4 direction", "@e[tag=<USER>,tag=<ID>-spell4_sword,tag=!<ID>-spell4_hit]")));
								}
							}
						}
					}
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).main_key == false) {
						if (!("Shoot").isEmpty()) {
							if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_shoot == true) {
								if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_mode).equals("Auto Shot")) {
									if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_tick_auto_shot > 0) {
										{
											TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
											_vars.spell4_tick_auto_shot = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_tick_auto_shot - 1;
											_vars.markSyncDirty();
										}
									} else {
										{
											TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
											_vars.spell4_tick_auto_shot = 2;
											_vars.markSyncDirty();
										}
										Spell4ShootNearestProcedure.execute(world, x, y, z, entity);
									}
								} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_mode).equals("Auto Single Shot")) {
									if (CommandResultProcedure.execute(entity, ReplaceIDProcedure.execute(entity, "execute unless entity @e[tag=<USER>,tag=<ID>-spell4_shoot]"))) {
										Spell4ShootNearestProcedure.execute(world, x, y, z, entity);
									}
								}
							}
						}
						if (!("Travel").isEmpty()) {
							if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_shoot == true || entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_constant == true) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												ReplaceIDProcedure.execute(entity, CommandEntityProcedure.execute("spell4 travel", "@e[tag=<USER>,tag=<ID>-spell4_shoot,tag=!<ID>-spell4_hit]")));
									}
								}
							}
						}
					}
				}
			}
			if (!("Ability").isEmpty()) {
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_duration >= 0) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.spell4_ability_duration = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_duration - 1;
						_vars.markSyncDirty();
					}
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_duration == -1) {
						Spell4AbilityEndProcedure.execute(entity);
					}
				} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_cooldown >= 0) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.spell4_ability_cooldown = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_cooldown - 1;
						_vars.markSyncDirty();
					}
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_ability_cooldown == -1) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bell ambient @s ~ ~ ~ 1 0");
							}
						}
					}
				}
			}
		}
	}
}