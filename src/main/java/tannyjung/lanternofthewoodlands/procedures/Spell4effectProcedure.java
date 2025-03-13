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

public class Spell4effectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double variable_number = 0;
		if (!("Sword").equals("")) {
			if (true) {
				if ((((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("All")
						|| ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Sword"))
						&& (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_sword_count != 0) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[tag=<ID>,tag=LOTW-spell4_sword,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 unless block ~ ~ ~ #lotw:passable_blocks run playsound minecraft:item.trident.hit_ground ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025"
										.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[tag=<ID>,tag=LOTW-spell4_sword,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 unless block ~ ~ ~ #lotw:passable_blocks run particle minecraft:campfire_signal_smoke ^-0.4 ^ ^0.5 0.25 0.25 0.25 0.005 5 force"
										.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[tag=<ID>,tag=LOTW-spell4_sword,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 unless block ~ ~ ~ #lotw:passable_blocks run tag @s add <ID>-spell4_hit".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[tag=<ID>,tag=LOTW-spell4_sword,tag=<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 if block ~ ~ ~ #lotw:passable_blocks run tag @s remove <ID>-spell4_hit".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_shoot == true
							|| (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_constant == true) {
						if (!("Effect").equals("")) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("execute at @e[tag=<ID>,tag=LOTW-spell4_sword,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 if entity @e[type=!#lotw:spell4_attack_blacklist,tag=!<ID>-ally,distance=..4] run particle minecraft:sweep_attack ~ ~0.5 ~ 0.5 0.5 0.5 2 1 force"
												.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("execute at @e[tag=<ID>,tag=LOTW-spell4_sword,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 if entity @e[type=!#lotw:spell4_attack_blacklist,tag=!<ID>-ally,distance=..4] run playsound minecraft:entity.player.attack.sweep ambient @a[distance=..100] ~ ~ ~ 0.5 1 0.025"
												.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("execute at @e[tag=<ID>,tag=LOTW-spell4_sword,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 if entity @e[type=!#lotw:spell4_attack_blacklist,tag=!<ID>-ally,distance=..4] run playsound minecraft:item.trident.throw ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025"
												.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
							if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_constant == false) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("execute at @e[name=<ID>,tag=LOTW-spell4_target] at @e[tag=<ID>-spell4_sword,limit=1,sort=nearest,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot,distance=..4] run particle minecraft:sweep_attack ~ ~0.5 ~ 0.5 0.5 0.5 2 1 force"
													.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("execute at @e[name=<ID>,tag=LOTW-spell4_target] at @e[tag=<ID>-spell4_sword,limit=1,sort=nearest,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot,distance=..4] run playsound minecraft:entity.player.attack.sweep ambient @a[distance=..100] ~ ~ ~ 0.5 1 0.025"
													.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("execute at @e[name=<ID>,tag=LOTW-spell4_target] at @e[tag=<ID>-spell4_sword,limit=1,sort=nearest,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot,distance=..4] run playsound minecraft:item.trident.throw ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025"
													.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
							}
						}
						if (!("Damage").equals("")) {
							if (true) {
								if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_constant == false) {
									variable_number = 1;
								} else {
									variable_number = 4;
								}
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											(("execute at @e[nbt={ArmorItems:[{id:\"" + "minecraft:wooden_sword"
													+ "\",Count:1b},{},{},{}]},tag=<ID>,tag=LOTW-spell4_sword,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 as @e[type=!#lotw:spell4_attack_blacklist,tag=!<ID>-ally,distance=..4] at @s run damage @s "
													+ variable_number * 1 + " minecraft:player_attack by @p[tag=<ID>-user]")
													.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											(("execute at @e[nbt={ArmorItems:[{id:\"" + "minecraft:stone_sword"
													+ "\",Count:1b},{},{},{}]},tag=<ID>-spell4_sword,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 as @e[type=!#lotw:spell4_attack_blacklist,tag=!<ID>-ally,distance=..4] at @s run damage @s "
													+ variable_number * 1 + " minecraft:player_attack by @p[tag=<ID>-user]")
													.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											(("execute at @e[nbt={ArmorItems:[{id:\"" + "minecraft:iron_sword"
													+ "\",Count:1b},{},{},{}]},tag=<ID>-spell4_sword,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 as @e[type=!#lotw:spell4_attack_blacklist,tag=!<ID>-ally,distance=..4] at @s run damage @s "
													+ variable_number * 2 + " minecraft:player_attack by @p[tag=<ID>-user]")
													.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											(("execute at @e[nbt={ArmorItems:[{id:\"" + "minecraft:golden_sword"
													+ "\",Count:1b},{},{},{}]},tag=<ID>-spell4_sword,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 as @e[type=!#lotw:spell4_attack_blacklist,tag=!<ID>-ally,distance=..4] at @s run damage @s "
													+ variable_number * 2 + " minecraft:player_attack by @p[tag=<ID>-user]")
													.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											(("execute at @e[nbt={ArmorItems:[{id:\"" + "minecraft:diamond_sword"
													+ "\",Count:1b},{},{},{}]},tag=<ID>-spell4_sword,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 as @e[type=!#lotw:spell4_attack_blacklist,tag=!<ID>-ally,distance=..4] at @s run damage @s "
													+ variable_number * 3 + " minecraft:player_attack by @p[tag=<ID>-user]")
													.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											(("execute at @e[nbt={ArmorItems:[{id:\"" + "minecraft:netherite_sword"
													+ "\",Count:1b},{},{},{}]},tag=<ID>-spell4_sword,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 as @e[type=!#lotw:spell4_attack_blacklist,tag=!<ID>-ally,distance=..4] at @s run damage @s "
													+ variable_number * 5 + " minecraft:player_attack by @p[tag=<ID>-user]")
													.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
							}
						}
					}
				}
			}
		}
		if (!("Shield").equals("")) {
			if (true) {
				if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_shield_count != 0) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("kill @e[name=<ID>-spell4_shield_blocker]".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								(("execute as @e[tag=<ID>-spell4_shield] at @s run summon armor_stand ~ ~ ~ {Tags:[" + "\"LOTW\",\"<ID>\",\"<ID>-ally\",\"<ID>-spell4\""
										+ "],NoGravity:1b,Invisible:1b,Silent:1b,CustomName:'{\"text\":\"<ID>-spell4_shield_blocker\"}'}")
										.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute at @e[name=<ID>-spell4_shield_blocker] positioned ~ ~1 ~ if entity @e[tag=!<ID>-ally,tag=!<ID>-spell4_shield_blocker_sound,distance=..2] run playsound minecraft:item.shield.block ambient @a[distance=..100] ~ ~ ~ 0.5 1 0.025"
										.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute at @e[name=<ID>-spell4_shield_blocker] positioned ~ ~1 ~ as @e[tag=!<ID>-ally,tag=!<ID>-spell4_shield_blocker_sound,distance=..2] at @s run effect give @s minecraft:slowness 5 255 true".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute at @e[name=<ID>-spell4_shield_blocker] positioned ~ ~1 ~ as @e[tag=!<ID>-ally,tag=!<ID>-spell4_shield_blocker_sound,distance=..2] at @s run effect give @s minecraft:nausea 8 255 true".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute at @e[name=<ID>-spell4_shield_blocker] positioned ~ ~1 ~ as @e[tag=!<ID>-ally,tag=!<ID>-spell4_shield_blocker_sound,distance=..2] at @s run tag @s add <ID>-spell4_shield_blocker_sound".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[tag=<ID>-spell4_shield_blocker_sound] at @s unless entity @e[name=<ID>-spell4_shield_blocker,distance=..3] run tag @s remove <ID>-spell4_shield_blocker_sound".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
				}
				if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_ability_duration >= 0
						&& ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_ability).equals("Shield")) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[tag=<ID>-spell4_shield] at @s run data merge entity @s {Pose:{RightArm:[0f,0f,-90f]}}".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute at @e[tag=<ID>-spell4_shield] positioned ~ ~1.1 ~ positioned ^0.06 ^ ^ run tp @e[name=<ID>-spell4_shield_ride,limit=1,sort=nearest] ~ ~ ~ facing ^ ^ ^10".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (true) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("execute at @e[tag=<ID>-spell4_shield] if block ^ ^2 ^2 #lotw:passable_blocks at @e[name=<ID>-spell4_shield_ride,limit=1,sort=nearest] unless entity @e[nbt={Passengers:[{}]},distance=..1] unless entity @e[nbt={RootVehicle:{Entity:{\"id\":\"minecraft:armor_stand\"}}},distance=..1] positioned ~ ~1.1 ~ as @e[type=player,nbt=!{RootVehicle:{Entity:{\"id\":\"minecraft:armor_stand\"}}},distance=..1,limit=1,sort=nearest] at @s run ride @s mount @e[name=<ID>-spell4_shield_ride,limit=1,sort=nearest]"
											.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("execute at @e[tag=<ID>-spell4_shield] if block ^ ^2 ^2 #lotw:passable_blocks at @e[name=<ID>-spell4_shield_ride,limit=1,sort=nearest] unless entity @e[nbt={Passengers:[{}]},distance=..1] unless entity @e[nbt={RootVehicle:{Entity:{\"id\":\"minecraft:armor_stand\"}}},distance=..1] positioned ~ ~-1 ~ as @e[type=!player,tag=!LOTW,nbt=!{Passengers:[{}]},distance=..1,limit=1,sort=nearest] at @s run ride @s mount @e[name=<ID>-spell4_shield_ride,limit=1,sort=nearest]"
											.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("execute at @e[tag=<ID>-spell4_shield] unless block ^ ^2 ^2 #lotw:passable_blocks at @e[name=<ID>-spell4_shield_ride,limit=1,sort=nearest] as @e[tag=!LOTW,distance=..1,limit=1,sort=nearest] at @s run ride @s dismount"
											.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					}
				}
			}
		}
		if (!("Lantern").equals("")) {
			if (true) {
				if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_lantern_count != 0) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("effect give @e[name=<ID>-spell4_lantern_light] invisibility 1000000 1 true".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute at @e[name=<ID>-spell4_lantern_light] run particle minecraft:flame ~ ~0.4 ~ 0 0 0 0 1 force".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[name=<ID>-spell4_lantern_light,nbt={NoAI:1b}] at @s if entity @e[tag=<ID>-spell4_lantern,distance=..100] if block ^ ^ ^1 #lotw:passable_blocks run tp @s ^ ^ ^0.25".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute at @e[name=<ID>-spell4_lantern_light] if entity @e[tag=!<ID>-ally,distance=..1] run playsound minecraft:entity.ender_dragon.flap ambient @a[distance=..100] ~ ~ ~ 0.5 1.25 0.025".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								(("execute at @e[name=<ID>-spell4_lantern_light] as @e[tag=!<ID>-ally,distance=..1] at @s run data merge entity @s {Fire:"
										+ 20 * (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_lantern_level + "}")
										.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[name=<ID>-spell4_lantern_light] at @s if entity @e[tag=!<ID>-ally,distance=..1] run kill @s".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
				}
			}
		}
		if (!("Anchor").equals("")) {
			if (true) {
				if ((((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("All")
						|| ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Anchor"))
						&& (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_anchor_count != 0) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[tag=<ID>-spell4_anchor,tag=<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^ ^ ^5.5 if block ~ ~ ~ #lotw:passable_blocks at @s positioned ~ ~1.4 ~ positioned ^ ^4 ^4 if block ~ ~ ~ #lotw:passable_blocks at @s positioned ~ ~1.4 ~ positioned ^ ^-4 ^4 if block ~ ~ ~ #lotw:passable_blocks run tag @s remove <ID>-spell4_hit"
										.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (true) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("execute as @e[tag=<ID>-spell4_anchor,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^ ^ ^5.5 unless block ~ ~ ~ #lotw:passable_blocks run playsound minecraft:block.grindstone.use ambient @a[distance=..100] ~ ~ ~ 2 0 0.025"
											.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("execute as @e[tag=<ID>-spell4_anchor,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^ ^ ^5.5 unless block ~ ~ ~ #lotw:passable_blocks run particle minecraft:campfire_signal_smoke ~ ~ ~ 2 2 2 0.005 20 force"
											.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("execute as @e[tag=<ID>-spell4_anchor,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^ ^ ^5.5 unless block ~ ~ ~ #lotw:passable_blocks run tag @s add <ID>-spell4_hit".replace("<ID>",
											(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					}
					if (true) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("execute as @e[tag=<ID>-spell4_anchor,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^ ^4 ^4 unless block ~ ~ ~ #lotw:passable_blocks run playsound minecraft:block.grindstone.use ambient @a[distance=..100] ~ ~ ~ 2 0 0.025"
											.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("execute as @e[tag=<ID>-spell4_anchor,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^ ^4 ^4 unless block ~ ~ ~ #lotw:passable_blocks run particle minecraft:campfire_signal_smoke ~ ~ ~ 2 2 2 0.005 20 force"
											.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("execute as @e[tag=<ID>-spell4_anchor,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^ ^4 ^4 unless block ~ ~ ~ #lotw:passable_blocks run tag @s add <ID>-spell4_hit".replace("<ID>",
											(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					}
					if (true) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("execute as @e[tag=<ID>-spell4_anchor,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^ ^-4 ^4 unless block ~ ~ ~ #lotw:passable_blocks run playsound minecraft:block.grindstone.use ambient @a[distance=..100] ~ ~ ~ 2 0 0.025"
											.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("execute as @e[tag=<ID>-spell4_anchor,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^ ^-4 ^4 unless block ~ ~ ~ #lotw:passable_blocks run particle minecraft:campfire_signal_smoke ~ ~ ~ 2 2 2 0.005 20 force"
											.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("execute as @e[tag=<ID>-spell4_anchor,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^ ^-4 ^4 unless block ~ ~ ~ #lotw:passable_blocks run tag @s add <ID>-spell4_hit".replace("<ID>",
											(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					}
				}
			}
		}
		if (!("Knight's Sword").equals("")) {
			if (true) {
				if ((((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("All")
						|| ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_type).equals("Knight's Sword"))
						&& (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_weapon_knight_sword_count != 0) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[tag=<ID>-spell4_knight_sword,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 unless block ~ ~ ~ #lotw:passable_blocks run playsound minecraft:item.trident.hit_ground ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025"
										.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[tag=<ID>-spell4_knight_sword,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 unless block ~ ~ ~ #lotw:passable_blocks run particle minecraft:campfire_signal_smoke ^-0.4 ^ ^0.5 0.25 0.25 0.25 0.005 5 force"
										.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[tag=<ID>-spell4_knight_sword,tag=!<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 unless block ~ ~ ~ #lotw:passable_blocks run tag @s add <ID>-spell4_hit".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[tag=<ID>-spell4_knight_sword,tag=<ID>-spell4_hit] at @s positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 if block ~ ~ ~ #lotw:passable_blocks run tag @s remove <ID>-spell4_hit".replace("<ID>",
										(entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
					if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_shoot == true
							|| (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_constant == true) {
						if (!("Effect").equals("")) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("execute at @e[tag=<ID>-spell4_knight_sword,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 if entity @e[type=!#lotw:spell4_attack_blacklist,tag=!<ID>-ally,distance=..4] run particle minecraft:sweep_attack ~ ~0.5 ~ 0.5 0.5 0.5 2 1 force"
												.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("execute at @e[tag=<ID>-spell4_knight_sword,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 if entity @e[type=!#lotw:spell4_attack_blacklist,tag=!<ID>-ally,distance=..4] run playsound minecraft:entity.player.attack.sweep ambient @a[distance=..100] ~ ~ ~ 0.5 1 0.025"
												.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("execute at @e[tag=<ID>-spell4_knight_sword,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 if entity @e[type=!#lotw:spell4_attack_blacklist,tag=!<ID>-ally,distance=..4] run playsound minecraft:item.trident.throw ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025"
												.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
							if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_constant == false) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("execute at @e[name=<ID>-spell4_target] at @e[tag=<ID>-spell4_knight_sword,limit=1,sort=nearest,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot,distance=..4] run particle minecraft:sweep_attack ~ ~0.5 ~ 0.5 0.5 0.5 2 1 force"
													.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("execute at @e[name=<ID>-spell4_target] at @e[tag=<ID>-spell4_knight_sword,limit=1,sort=nearest,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot,distance=..4] run playsound minecraft:entity.player.attack.sweep ambient @a[distance=..100] ~ ~ ~ 0.5 1 0.025"
													.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											("execute at @e[name=<ID>-spell4_target] at @e[tag=<ID>-spell4_knight_sword,limit=1,sort=nearest,tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot,distance=..4] run playsound minecraft:item.trident.throw ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025"
													.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
							}
						}
						if (!("Damage").equals("")) {
							if (true) {
								if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_constant == false) {
									variable_number = 1;
								} else {
									variable_number = 5;
								}
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											(("execute at @e[tag=<ID>-spell4_" + "knight_sword"
													+ ",tag=!<ID>-spell4_hit,tag=<ID>-spell4_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 as @e[type=!#lotw:spell4_attack_blacklist,tag=!<ID>-ally,distance=..4] at @s run damage @s "
													+ variable_number + " minecraft:player_attack by @p[tag=<ID>-user]")
													.replace("<ID>", (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS)));
							}
						}
					}
				}
			}
		}
	}
}
