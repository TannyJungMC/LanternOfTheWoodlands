package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class AgreementGUIbuttonAcceptProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_place == false) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).agreement_accept == false) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.agreement_accept = true;
					_vars.markSyncDirty();
				}
				if (true) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.user_DELETE_THIS = "LOTW-" + entity.getUUID().toString();
						_vars.markSyncDirty();
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("tag @s add " + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS + "-user"));
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("tag @s add " + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS + "-ally"));
						}
					}
					if (true) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.mana_max = 300;
							_vars.markSyncDirty();
						}
					}
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana == 0 && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).mana_charge == 0) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.mana = 0;
							_vars.mana_charge = 0;
							_vars.alternative_keyboard_save = "type=player,distance=..3";
							_vars.alternative_keyboard_save2 = "type=villager";
							_vars.alternative_keyboard_save3 = "type=iron_golem";
							_vars.alternative_keyboard_save4 = "distance=..3";
							_vars.alternative_keyboard_save5 = "";
							_vars.alternative_keyboard_save6 = "";
							_vars.ally_list_manual = "type=player,distance=..3";
							_vars.ally_list_chat_setting = "User, Chosen and Ally";
							_vars.markSyncDirty();
						}
						PersonalWeaponGUIbuttonPosResetProcedure.execute(world, x, y, z, entity);
						PersonalWeaponGUIbuttonPoseResetProcedure.execute(world, x, y, z, entity);
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.personal_skill = "Nothing";
							_vars.personal_skill_level = 0;
							_vars.markSyncDirty();
						}
					}
				}
			} else {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.agreement_accept = false;
					_vars.markSyncDirty();
				}
				if (true) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("tag @s remove " + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS + "-user"));
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("tag @s remove " + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS + "-ally"));
						}
					}
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.user_DELETE_THIS = "";
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}