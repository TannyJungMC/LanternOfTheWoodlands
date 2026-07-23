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

public class Spell4keyTypeRunProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("") && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell == 4) {
			if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Unselected")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_type = "All";
					_vars.markSyncDirty();
				}
			} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("All")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_type = "Sword";
					_vars.markSyncDirty();
				}
			} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Sword")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_type = "Shield";
					_vars.markSyncDirty();
				}
			} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Shield")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_type = "Lantern";
					_vars.markSyncDirty();
				}
			} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Lantern")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_type = "Bow";
					_vars.markSyncDirty();
				}
			} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Bow")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_type = "Anchor";
					_vars.markSyncDirty();
				}
			} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Anchor")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_type = "Knight's Sword";
					_vars.markSyncDirty();
				}
			} else if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Knight's Sword")) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_type = "Unselected";
					_vars.markSyncDirty();
				}
			} else {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.spell4_type = "Off";
					_vars.markSyncDirty();
				}
			}
			if (true) {
				if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("All")) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_sword_count != 0 || entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_shield_count != 0
							|| entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_lantern_count != 0 || entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_bow_count != 0
							|| entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_anchor_count != 0) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type_tag = "tag=LOTW-spell4,tag=<ID>".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS);
							_vars.spell4_can_summon = false;
							_vars.markSyncDirty();
						}
					} else {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type = "Sword";
							_vars.markSyncDirty();
						}
					}
				}
				if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Sword")) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_sword_count != 0) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type_tag = "tag=LOTW-spell4_sword,tag=<ID>".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS);
							_vars.spell4_can_summon = false;
							_vars.markSyncDirty();
						}
					} else {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type = "Shield";
							_vars.markSyncDirty();
						}
					}
				}
				if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Shield")) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_shield_count != 0) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type_tag = "tag=LOTW-spell4_shield,tag=<ID>".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS);
							_vars.spell4_can_summon = false;
							_vars.markSyncDirty();
						}
					} else {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type = "Lantern";
							_vars.markSyncDirty();
						}
					}
				}
				if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Lantern")) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_lantern_count != 0) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type_tag = "tag=LOTW-spell4_lantern,tag=<ID>".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS);
							_vars.spell4_can_summon = false;
							_vars.markSyncDirty();
						}
					} else {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type = "Bow";
							_vars.markSyncDirty();
						}
					}
				}
				if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Bow")) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_bow_count != 0) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type_tag = "tag=LOTW-spell4_bow,tag=<ID>".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS);
							_vars.spell4_can_summon = false;
							_vars.markSyncDirty();
						}
					} else {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type = "Anchor";
							_vars.markSyncDirty();
						}
					}
				}
				if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Anchor")) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_anchor_count_max != 0) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type_tag = "tag=LOTW-spell4_anchor,tag=<ID>".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS);
							_vars.spell4_can_summon = true;
							_vars.markSyncDirty();
						}
					} else {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type = "Knight's Sword";
							_vars.markSyncDirty();
						}
					}
				}
				if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Knight's Sword")) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_weapon_knight_sword_count_max != 0) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type_tag = "tag=LOTW-spell4_knight_sword,tag=<ID>".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS);
							_vars.spell4_can_summon = true;
							_vars.markSyncDirty();
						}
					} else {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.spell4_type = "Unselected";
							_vars.markSyncDirty();
						}
					}
				}
				if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type).equals("Unselected")) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.spell4_type_tag = "tag=<ID>-spell4_nothing".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS);
						_vars.markSyncDirty();
					}
				}
			}
			if (true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("execute at @e[" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type_tag
									+ ",limit=3,sort=random,tag=!<ID>-spell4_hit] run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~1 ~ 0.5 0.75 0.025")
									.replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("execute at @e[" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type_tag + ",tag=!<ID>-spell4_hit] positioned ~ ~1 ~ run particle portal ^ ^ ^ 0.5 0.5 0.5 2 10 force").replace("<ID>",
									entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("effect clear @e[name=<ID>-spell4] minecraft:glowing".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("effect give @e[" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell4_type_tag + ",tag=!<ID>-spell4_hit] minecraft:glowing 3 1 true").replace("<ID>",
									entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
			}
		}
	}
}