package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class Spell4StartProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user == true && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell == 0) {
			{
				TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
				_vars.spell = 4;
				_vars.markSyncDirty();
			}
			TanscomplexmagicMod.queueServerWork(20, () -> {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bell ambient @a[distance=..100] ~ ~ ~ 1 0.75 0.025");
					}
				}
				TanscomplexmagicMod.queueServerWork(5, () -> {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bell ambient @a[distance=..100] ~ ~ ~ 1 1 0.025");
						}
					}
				});
			});
			if (!("Main").isEmpty()) {
				if (true) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.spell4_shoot = false;
						_vars.spell4_reverse = false;
						_vars.spell4_lock_target = false;
						_vars.spell4_homing = true;
						_vars.spell4_constant = false;
						_vars.spell4_type = "Off";
						_vars.spell4_mode = "Multiple Shot";
						_vars.spell4_type_tag = "tag=<ID>-spell4_nothing".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS);
						_vars.spell4_distance = 10;
						_vars.spell4_tick_fly_updown = 0;
						_vars.spell4_tick_auto_shot = 0;
						_vars.spell4_ability_duration = 0;
						_vars.spell4_ability_cooldown = 0;
						_vars.markSyncDirty();
					}
				}
			}
			if (!("Settings").isEmpty()) {
				if (true) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.spell4_lock_shoot = false;
						_vars.spell4_lock_reverse = false;
						_vars.spell4_guard_pose = false;
						_vars.spell4_guard_pose_distance = 10;
						_vars.spell4_auto_shot_cooldown = 0.1;
						_vars.spell4_distancing_in = 0;
						_vars.spell4_distancing_out = 200;
						_vars.spell4_distancing_speed = 1;
						_vars.spell4_show_target_arrow = true;
						_vars.spell4_show_overlay = true;
						_vars.spell4_pause_at_mark = false;
						_vars.spell4_pause_balancing = false;
						_vars.spell4_pause_gravity = false;
						_vars.spell4_pause_boundary = 2;
						_vars.spell4_pause_rotation = 0;
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}