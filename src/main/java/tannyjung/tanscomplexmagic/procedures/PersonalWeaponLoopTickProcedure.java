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

public class PersonalWeaponLoopTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_place == true) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_flying_tick < 60) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("execute as @e[name=<ID>-user_book] at @s run tp @s ~ ~0.001 ~".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_flying_tick > 60) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("execute as @e[name=<ID>-user_book] at @s run tp @s ~ ~-0.001 ~".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
			}
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_flying_tick < 120) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.user_book_flying_tick = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_flying_tick + 1;
					_vars.markSyncDirty();
				}
			} else {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.user_book_flying_tick = 0;
					_vars.markSyncDirty();
				}
			}
		}
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_place == true) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_flying == true) {
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_flying_tick < 60) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[name=<ID>-personal_weapon] at @s run tp @s ~ ~0.001 ~".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_flying_tick > 60) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[name=<ID>-personal_weapon] at @s run tp @s ~ ~-0.001 ~".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				}
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_flying_tick < 120) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.personal_weapon_flying_tick = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_flying_tick + 1;
						_vars.markSyncDirty();
					}
				} else {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.personal_weapon_flying_tick = 0;
						_vars.markSyncDirty();
					}
				}
			}
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_rotation == true) {
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_rotation_reverse == true) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[name=<ID>-personal_weapon] at @s run tp @s ~ ~ ~ ~-1 ~".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[name=<ID>-personal_weapon_display] at @s run tp @s ~ ~ ~ ~-1 ~".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[name=<ID>-personal_weapon] at @s run tp @s ~ ~ ~ ~1 ~".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[name=<ID>-personal_weapon_display] at @s run tp @s ~ ~ ~ ~1 ~".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						(("execute at @e[name=<ID>-personal_weapon] run tp @e[name=<ID>-personal_weapon_display] ^" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pos_x + " ^"
								+ entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pos_y + " ^" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pos_z)
								.replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_show_center == true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("execute at @e[name=<ID>-personal_weapon] run particle minecraft:composter ~ ~1 ~ 0 0 0 0 1 force".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
			}
		}
	}
}