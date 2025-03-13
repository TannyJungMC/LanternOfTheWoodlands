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

public class Spell4effectProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4effect!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell4effect!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell4effect!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell4effect!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (LotwModVariables.MapVariables.get(world).spell4_shoot == true) {
			if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
					|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Sword"))
					&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type1 != 0) {
				if (!("Effect").equals("")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-weapon_manipulation_target] at @e[tag=LOTW-weapon_manipulation_type1,limit=1,sort=nearest,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot,distance=..2] run particle minecraft:sweep_attack ~ ~1 ~ 0.5 0.5 0.5 2 1 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-weapon_manipulation_target] at @e[tag=LOTW-weapon_manipulation_type1,limit=1,sort=nearest,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot,distance=..2] run playsound minecraft:entity.player.attack.sweep ambient @a[distance=..100] ~ ~ ~ 0.5 1 0.025");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-weapon_manipulation_target] at @e[tag=LOTW-weapon_manipulation_type1,limit=1,sort=nearest,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot,distance=..2] run playsound minecraft:item.trident.throw ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[tag=LOTW-weapon_manipulation_type1,limit=1,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 if entity @e[tag=!LOTW-ally,distance=..2] run particle minecraft:sweep_attack ~ ~1 ~ 0.5 0.5 0.5 2 1 force");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[tag=LOTW-weapon_manipulation_type1,limit=1,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 if entity @e[tag=!LOTW-ally,distance=..2] run playsound minecraft:entity.player.attack.sweep ambient @a[distance=..100] ~ ~ ~ 0.5 1 0.025");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[tag=LOTW-weapon_manipulation_type1,limit=1,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 if entity @e[tag=!LOTW-ally,distance=..2] run playsound minecraft:item.trident.throw ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025");
					}
				}
				if (!("Damage").equals("")) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[nbt={HandItems:[{id:\"minecraft:wooden_sword\",Count:1b},{}]},tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 run effect give @e[tag=!LOTW-ally,distance=..2] minecraft:wither 1 255 true");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[nbt={HandItems:[{id:\"minecraft:stone_sword\",Count:1b},{}]},tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 run effect give @e[tag=!LOTW-ally,distance=..2] minecraft:wither 4 255 true");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[nbt={HandItems:[{id:\"minecraft:iron_sword\",Count:1b},{}]},tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 run effect give @e[tag=!LOTW-ally,distance=..2] minecraft:wither 7 255 true");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[nbt={HandItems:[{id:\"minecraft:golden_sword\",Count:1b},{}]},tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 run effect give @e[tag=!LOTW-ally,distance=..2] minecraft:wither 10 255 true");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[nbt={HandItems:[{id:\"minecraft:diamond_sword\",Count:1b},{}]},tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 run effect give @e[tag=!LOTW-ally,distance=..2] minecraft:wither 13 255 true");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @e[nbt={HandItems:[{id:\"minecraft:netherite_sword\",Count:1b},{}]},tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot] positioned ~ ~1.4 ~ positioned ^-0.4 ^-0.45 ^0.9 run effect give @e[tag=!LOTW-ally,distance=..2] minecraft:wither 16 255 true");
					}
				}
			}
		}
		if (!(LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Off")
				&& !(LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Unselected")) {
			if (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type3 != 0) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"effect give @e[name=LOTW-weapon_manipulation_type3_light] invisibility 1000000 1 true");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[name=LOTW-weapon_manipulation_type3_light,nbt={NoAI:1b}] at @s if entity @e[tag=LOTW-weapon_manipulation_type3,distance=..100] if block ^ ^ ^1 #minecraft:air_blocks run tp @s ^ ^ ^0.25");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-weapon_manipulation_type3_light] run particle minecraft:flame ~ ~0.4 ~ 0 0 0 0 1 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-weapon_manipulation_type3_light] if entity @e[tag=!LOTW-ally,distance=..1] run playsound minecraft:entity.ender_dragon.flap ambient @a[distance=..100] ~ ~ ~ 0.5 1.25 0.025");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-weapon_manipulation_type3_light] as @e[tag=!LOTW-ally,distance=..1] at @s run data merge entity @s {Fire:200}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[name=LOTW-weapon_manipulation_type3_light] at @s if entity @e[tag=!LOTW-ally,distance=..1] run kill @s");
				}
			}
		}
		if (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type2 != 0) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"kill @e[name=LOTW-weapon_manipulation_type2_blocker]");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type2] at @s run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-weapon_manipulation\"],NoGravity:1b,Invisible:1b,Silent:1b,CustomName:'{\"text\":\"LOTW-weapon_manipulation_type2_blocker\"}'}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-weapon_manipulation_type2_blocker] positioned ~ ~1 ~ if entity @e[tag=!LOTW-ally,tag=!LOTW-weapon_manipulation_type2_blocker_sound,distance=..2] run playsound minecraft:item.shield.block ambient @a[distance=..100] ~ ~ ~ 0.5 1 0.025");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-weapon_manipulation_type2_blocker] positioned ~ ~1 ~ as @e[tag=!LOTW-ally,tag=!LOTW-weapon_manipulation_type2_blocker_sound,distance=..2] at @s run effect give @s minecraft:slowness 5 255 true");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-weapon_manipulation_type2_blocker] positioned ~ ~1 ~ as @e[tag=!LOTW-ally,tag=!LOTW-weapon_manipulation_type2_blocker_sound,distance=..2] at @s run effect give @s minecraft:nausea 8 255 true");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[name=LOTW-weapon_manipulation_type2_blocker] positioned ~ ~1 ~ as @e[tag=!LOTW-ally,tag=!LOTW-weapon_manipulation_type2_blocker_sound,distance=..2] at @s run tag @s add LOTW-weapon_manipulation_type2_blocker_sound");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type2_blocker_sound] at @s unless entity @e[name=LOTW-weapon_manipulation_type2_blocker,distance=..3] run tag @s remove LOTW-weapon_manipulation_type2_blocker_sound");
			}
		}
		if (LotwModVariables.MapVariables.get(world).spell4_weapon_count_type5 != 0) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[tag=LOTW-weapon_manipulation_type5] positioned ~ ~1.75 ~ run particle lotw:animation_bee ^ ^ ^1 0.25 0.25 0.25 0.01 1 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=lotw:bee] at @s unless entity @e[tag=LOTW-weapon_manipulation_type5,distance=..30] facing entity @e[tag=LOTW-weapon_manipulation_type5,limit=1,sort=nearest] eyes run tp @s ^ ^ ^1");
			}
		}
	}
}
