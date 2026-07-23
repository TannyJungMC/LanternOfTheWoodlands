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

public class Spell4weaponSummonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean can_pick_up = false;
		String summon_at = "";
		String weapon = "";
		String weapon_id = "";
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_shoot == false && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_reverse == false) {
			{
				TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
				_vars.spell4_tick_summon = 0;
				_vars.markSyncDirty();
			}
		}
		if (true) {
			if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Anchor")) {
				can_pick_up = true;
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_shoot == true && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_reverse == false) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_tick_summon > 0) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_tick_summon = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_tick_summon - 1;
							_vars.markSyncDirty();
						}
					} else {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_tick_summon = 2;
							_vars.markSyncDirty();
						}
						if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_anchor_count < entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_anchor_count_max) {
							{
								TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
								_vars.spell4_weapon_anchor_count = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_anchor_count + 1;
								_vars.markSyncDirty();
							}
							weapon = "anchor";
							weapon = "lotw:anchor";
							summon_at = "^ ^ ^" + 10;
							if (true) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												(("summon armor_stand " + summon_at + " {Tags:[\"LOTW\",\"<ID>\",\"LOTW-spell4_" + weapon
														+ "\"],Invisible:1b,Marker:1b,NoGravity:1b,ShowArms:1b,CustomName:'{\"text\":\"LOTW-spell4\"}',HandItems:[{id:\"" + weapon_id + "\",Count:1b},{}],Pose:{RightArm:[0f,0f,0f]}}")
														.replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												(("execute positioned " + summon_at + " run particle minecraft:flash ~ ~1.4 ~ 0 0 0 0 1 force").replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												(("execute positioned " + summon_at + " run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..200] ~ ~1.4 ~ 2 0 0.025").replace("<ID>",
														entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
									}
								}
							}
						}
					}
				} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_shoot == false && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_reverse == true) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_anchor_count > 0) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_weapon_anchor_count = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_anchor_count - 1;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									(("execute at @e[" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type_tag
											+ ",tag=<ID>-spell4_hit,limit=1,sort=nearest] positioned ~ ~1.5 ~ run particle minecraft:campfire_signal_smoke ~ ~ ~ 2 2 2 0.005 20 force")
											.replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
					}
				}
			}
			if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Knight's Sword")) {
				can_pick_up = true;
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_shoot == true && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_reverse == false) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_tick_summon > 0) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_tick_summon = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_tick_summon - 1;
							_vars.markSyncDirty();
						}
					} else {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_tick_summon = 2;
							_vars.markSyncDirty();
						}
						if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_knight_sword_count < entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_knight_sword_count_max) {
							{
								TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
								_vars.spell4_weapon_knight_sword_count = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_knight_sword_count + 1;
								_vars.markSyncDirty();
							}
							weapon = "knight_sword";
							weapon = "lotw:knight_sword";
							summon_at = "^ ^ ^" + 5;
							if (true) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												(("summon armor_stand " + summon_at + " {Tags:[\"LOTW\",\"<ID>\",\"LOTW-spell4_" + weapon
														+ "\"],Invisible:1b,Marker:1b,NoGravity:1b,ShowArms:1b,CustomName:'{\"text\":\"LOTW-spell4\"}',HandItems:[{id:\"" + weapon_id + "\",Count:1b},{}],Pose:{RightArm:[0f,0f,0f]}}")
														.replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												(("execute positioned " + summon_at + " run particle minecraft:flash ~ ~1.4 ~ 0 0 0 0 1 force").replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												(("execute positioned " + summon_at + " run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..200] ~ ~1.4 ~ 2 0 0.025").replace("<ID>",
														entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
									}
								}
							}
						}
					}
				} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_shoot == false && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_reverse == true) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_knight_sword_count > 0) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_weapon_knight_sword_count = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_knight_sword_count - 1;
							_vars.markSyncDirty();
						}
					}
				}
			}
			if (can_pick_up == true && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_shoot == false && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_reverse == true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("execute at @e[" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type_tag + ",limit=1,sort=nearest] positioned ~ ~1.5 ~ run particle minecraft:flash ~ ~ ~ 0 0 0 0 1 force").replace("<ID>",
									entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("execute at @e[" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type_tag
									+ ",tag=<ID>-spell4_hit,limit=1,sort=nearest] positioned ~ ~1.5 ~ run particle minecraft:campfire_signal_smoke ~ ~ ~ 0.25 0.25 0.25 0.005 5 force")
									.replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("execute at @e[" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type_tag
									+ ",limit=1,sort=nearest] positioned ~ ~1.5 ~ run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..200] ~ ~ ~ 2 0 0.025")
									.replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("kill @e[" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type_tag + ",limit=1,sort=nearest]").replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
			}
		}
	}
}