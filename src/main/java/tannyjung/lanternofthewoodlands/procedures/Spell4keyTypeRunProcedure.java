package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

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
		if (!((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS).equals("")
				&& (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell == 4) {
			if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Unselected")) {
				{
					String _setval = "All";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spell4_type = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("All")) {
				{
					String _setval = "Sword";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spell4_type = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Sword")) {
				{
					String _setval = "Shield";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spell4_type = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Shield")) {
				{
					String _setval = "Lantern";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spell4_type = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Lantern")) {
				{
					String _setval = "Bow";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spell4_type = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Bow")) {
				{
					String _setval = "Anchor";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spell4_type = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Anchor")) {
				{
					String _setval = "Knight's Sword";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spell4_type = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Knight's Sword")) {
				{
					String _setval = "Unselected";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spell4_type = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					String _setval = "Off";
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spell4_type = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (true) {
				if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("All")) {
					if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_sword_count != 0
							|| (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_shield_count != 0
							|| (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_lantern_count != 0
							|| (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_bow_count != 0
							|| (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_anchor_count != 0) {
						{
							String _setval = "tag=LOTW-spell4,tag=<ID>".replace("<ID>",
									(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS);
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type_tag = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = false;
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_can_summon = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						{
							String _setval = "Sword";
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Sword")) {
					if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_sword_count != 0) {
						{
							String _setval = "tag=LOTW-spell4_sword,tag=<ID>".replace("<ID>",
									(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS);
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type_tag = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = false;
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_can_summon = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						{
							String _setval = "Shield";
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Shield")) {
					if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_shield_count != 0) {
						{
							String _setval = "tag=LOTW-spell4_shield,tag=<ID>".replace("<ID>",
									(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS);
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type_tag = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = false;
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_can_summon = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						{
							String _setval = "Lantern";
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Lantern")) {
					if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_lantern_count != 0) {
						{
							String _setval = "tag=LOTW-spell4_lantern,tag=<ID>".replace("<ID>",
									(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS);
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type_tag = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = false;
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_can_summon = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						{
							String _setval = "Bow";
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Bow")) {
					if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_bow_count != 0) {
						{
							String _setval = "tag=LOTW-spell4_bow,tag=<ID>".replace("<ID>",
									(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS);
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type_tag = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = false;
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_can_summon = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						{
							String _setval = "Anchor";
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Anchor")) {
					if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_anchor_count_max != 0) {
						{
							String _setval = "tag=LOTW-spell4_anchor,tag=<ID>".replace("<ID>",
									(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS);
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type_tag = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = true;
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_can_summon = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						{
							String _setval = "Knight's Sword";
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Knight's Sword")) {
					if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_knight_sword_count_max != 0) {
						{
							String _setval = "tag=LOTW-spell4_knight_sword,tag=<ID>".replace("<ID>",
									(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS);
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type_tag = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = true;
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_can_summon = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						{
							String _setval = "Unselected";
							entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.spell4_type = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Unselected")) {
					{
						String _setval = "tag=<ID>-spell4_nothing".replace("<ID>",
								(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS);
						entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.spell4_type_tag = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if (true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("execute at @e[" + (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type_tag
									+ ",limit=3,sort=random,tag=!<ID>-spell4_hit] run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~1 ~ 0.5 0.75 0.025")
									.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("execute at @e[" + (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type_tag
									+ ",tag=!<ID>-spell4_hit] positioned ~ ~1 ~ run particle portal ^ ^ ^ 0.5 0.5 0.5 2 10 force")
									.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("effect clear @e[name=<ID>-spell4] minecraft:glowing".replace("<ID>",
									(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("effect give @e[" + (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type_tag
									+ ",tag=!<ID>-spell4_hit] minecraft:glowing 3 1 true")
									.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
			}
		}
	}
}
