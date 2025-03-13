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

public class Spell4tpProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell4tp!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell4tp!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell4tp!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell4tp!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
				|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Sword"))
				&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type1 != 0) {
			for (int index0 = 0; index0 < (int) (4); index0++) {
				for (int index1 = 0; index1 < (int) (5); index1++) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot] at @s run tp @s ^ ^ ^0.1");
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit] at @s positioned ~ ~1.4 ~ unless block ^-0.4 ^-0.45 ^0.9 air run playsound minecraft:item.trident.hit_ground ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit] at @s positioned ~ ~1.4 ~ unless block ^-0.4 ^-0.45 ^0.9 air run particle minecraft:spit ^-0.4 ^ ^0.5 0.5 0.5 0.5 0.05 10 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit] at @s positioned ~ ~1.4 ~ unless block ^-0.35 ^-0.6 ^0.9 air run tag @s add LOTW-weapon_manipulation_hit");
				}
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type1,tag=!LOTW-weapon_manipulation_hit,tag=LOTW-weapon_manipulation_shoot] at @s if entity @e[name=LOTW-weapon_manipulation_target,distance=..1] run tp @s ^1 ^ ^3");
			}
		}
		if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
				|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Shield"))
				&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type2 != 0) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type2,tag=LOTW-weapon_manipulation_shoot] at @s unless entity @e[name=LOTW-weapon_manipulation_target,distance=..5] run tp @s ^ ^ ^0.5");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type2,tag=LOTW-weapon_manipulation_shoot] at @s if entity @e[name=LOTW-weapon_manipulation_target,distance=..5] run tp @s ^0.5 ^ ^-0.5");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type2] at @s unless block ~ ~0.75 ~ #minecraft:air_blocks run tp @s ~ ~0.5 ~");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type2] at @s unless block ~ ~2 ~ #minecraft:air_blocks run tp @s ~ ~-0.5 ~");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type2] at @s positioned ~ ~1.5 ~ unless block ^ ^ ^1 #minecraft:air_blocks run tp @s ^ ^ ^-0.5");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type2] at @s positioned ~ ~1.5 ~ unless block ^0.75 ^ ^ #minecraft:air_blocks run tp @s ^-0.5 ^ ^");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type2] at @s positioned ~ ~1.5 ~ unless block ^-0.75 ^ ^ #minecraft:air_blocks run tp @s ^0.5 ^ ^");
			}
		}
		if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
				|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Lantern"))
				&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type3 != 0) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type3,tag=LOTW-weapon_manipulation_shoot] at @s unless entity @e[name=LOTW-weapon_manipulation_target,distance=..3] run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type3,tag=LOTW-weapon_manipulation_shoot] at @s if entity @e[name=LOTW-weapon_manipulation_target,distance=..3] run tp @s ^0.25 ^ ^-0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type3] at @s unless block ~ ~0.75 ~ #minecraft:air_blocks run tp @s ~ ~0.25 ~");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type3] at @s unless block ~ ~2 ~ #minecraft:air_blocks run tp @s ~ ~-0.25 ~");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type3] at @s positioned ~ ~1.5 ~ unless block ^ ^ ^1 #minecraft:air_blocks run tp @s ^ ^ ^-0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type3] at @s positioned ~ ~1.5 ~ unless block ^0.75 ^ ^ #minecraft:air_blocks run tp @s ^-0.25 ^ ^");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type3] at @s positioned ~ ~1.5 ~ unless block ^-0.75 ^ ^ #minecraft:air_blocks run tp @s ^0.25 ^ ^");
			}
		}
		if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
				|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Bow"))
				&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type4 != 0) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type4,tag=LOTW-weapon_manipulation_shoot] at @s unless entity @e[name=LOTW-weapon_manipulation_target,distance=..10] run tp @s ^ ^ ^0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type4,tag=LOTW-weapon_manipulation_shoot] at @s if entity @e[name=LOTW-weapon_manipulation_target,distance=..10] run tp @s ^0.25 ^ ^-0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type4] at @s unless block ~ ~0.75 ~ #minecraft:air_blocks run tp @s ~ ~0.25 ~");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type4] at @s unless block ~ ~2 ~ #minecraft:air_blocks run tp @s ~ ~-0.25 ~");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type4] at @s positioned ~ ~1.5 ~ unless block ^ ^ ^1 #minecraft:air_blocks run tp @s ^ ^ ^-0.25");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type4] at @s positioned ~ ~1.5 ~ unless block ^0.75 ^ ^ #minecraft:air_blocks run tp @s ^-0.25 ^ ^");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type4] at @s positioned ~ ~1.5 ~ unless block ^-0.75 ^ ^ #minecraft:air_blocks run tp @s ^0.25 ^ ^");
			}
		}
		if (((LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("All")
				|| (LotwModVariables.MapVariables.get(world).spell4_weapon_type).equals("Beehive"))
				&& LotwModVariables.MapVariables.get(world).spell4_weapon_count_type5 != 0) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type5,tag=LOTW-weapon_manipulation_shoot] at @s unless entity @e[name=LOTW-weapon_manipulation_target,distance=..12] run tp @s ^ ^ ^0.1");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type5,tag=LOTW-weapon_manipulation_shoot] at @s if entity @e[name=LOTW-weapon_manipulation_target,distance=..12] run tp @s ^-0.1 ^ ^-0.1");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type5] at @s unless block ~ ~0.75 ~ #minecraft:air_blocks run tp @s ~ ~0.1 ~");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type5] at @s unless block ~ ~2 ~ #minecraft:air_blocks run tp @s ~ ~-0.1 ~");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type5] at @s positioned ~ ~1.5 ~ unless block ^ ^ ^1 #minecraft:air_blocks run tp @s ^ ^ ^-0.1");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type5] at @s positioned ~ ~1.5 ~ unless block ^0.75 ^ ^ #minecraft:air_blocks run tp @s ^-0.1 ^ ^");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[tag=LOTW-weapon_manipulation_type5] at @s positioned ~ ~1.5 ~ unless block ^-0.75 ^ ^ #minecraft:air_blocks run tp @s ^0.1 ^ ^");
			}
		}
	}
}
