package lotw.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lotw.LotwMod;

import java.util.Map;

public class WeaponManipulationSetRightClickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure WeaponManipulationSetRightClick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure WeaponManipulationSetRightClick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure WeaponManipulationSetRightClick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure WeaponManipulationSetRightClick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		String sword = "";
		double sword_number = 0;
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"clear @p lotw:weapon_manipulation_set 1");
		}
		if (true) {
			if (true) {
				sword_number = 1;
				for (int index0 = 0; index0 < (int) (6); index0++) {
					if (true) {
						if (sword_number == 1) {
							sword = "minecraft:wooden_sword";
						}
						if (sword_number == 2) {
							sword = "minecraft:stone_sword";
						}
						if (sword_number == 3) {
							sword = "minecraft:iron_sword";
						}
						if (sword_number == 4) {
							sword = "minecraft:golden_sword";
						}
						if (sword_number == 5) {
							sword = "minecraft:diamond_sword";
						}
						if (sword_number == 6) {
							sword = "minecraft:netherite_sword";
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=item,nbt={Item:{id:\"" + "" + sword
										+ "\",Count:1b}},distance=..10] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-weapon_manipulation\",\"LOTW-weapon_manipulation_type1\"],Invisible:1b,Marker:1b,NoGravity:1b,ShowArms:1b,HandItems:[{id:\"\",Count:1b},{}],CustomName:'{\"text\":\"LOTW-weapon_manipulation\"}',Pose:{RightArm:[-100f,270f,0f]}}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[type=item,nbt={Item:{id:\"" + "" + sword
										+ "\",Count:1b}},distance=..10] run LOTW-spell4_count_sword"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[type=item,nbt={Item:{id:\"" + "" + sword
										+ "\",Count:1b}},distance=..10] at @s run data modify entity @e[name=LOTW-weapon_manipulation,limit=1,distance=..0.01] HandItems[0] merge from entity @s Item"));
					}
					sword_number = (sword_number + 1);
				}
			}
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=item,nbt={Item:{id:\"minecraft:shield\",Count:1b}},distance=..10] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-weapon_manipulation\",\"LOTW-weapon_manipulation_type2\"],Invisible:1b,Marker:1b,NoGravity:1b,ShowArms:1b,HandItems:[{id:\"\",Count:1b},{}],CustomName:'{\"text\":\"LOTW-weapon_manipulation\"}',Pose:{RightArm:[-90f,90f,180f]}}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[type=item,nbt={Item:{id:\"minecraft:shield\",Count:1b}},distance=..10] at @s run data modify entity @e[name=LOTW-weapon_manipulation,limit=1,distance=..0.01] HandItems[0] merge from entity @s Item");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=item,nbt={Item:{id:\"minecraft:shield\",Count:1b}},distance=..10] run LOTW-spell4_count_shield");
				}
			}
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=item,nbt={Item:{id:\"minecraft:lantern\",Count:1b}},distance=..10] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-weapon_manipulation_type3\"],Invisible:1b,Marker:1b,NoGravity:1b,ShowArms:1b,HandItems:[{id:\"\",Count:1b},{}],CustomName:'{\"text\":\"LOTW-weapon_manipulation\"}'}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[type=item,nbt={Item:{id:\"minecraft:lantern\",Count:1b}},distance=..10] at @s run data modify entity @e[name=LOTW-weapon_manipulation,limit=1,distance=..0.01] ArmorItems[0] merge from entity @s Item");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=item,nbt={Item:{id:\"minecraft:lantern\",Count:1b}},distance=..10] run data modify entity @e[name=LOTW-weapon_manipulation,limit=1,distance=..0.01] ArmorItems[3] set value {id:\"lotw:mini_lantern\",Count:1b}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=item,nbt={Item:{id:\"minecraft:lantern\",Count:1b}},distance=..10] run LOTW-spell4_count_lantern");
				}
			}
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=item,nbt={Item:{id:\"minecraft:bow\",Count:1b}},distance=..10] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-weapon_manipulation\",\"LOTW-weapon_manipulation_type4\"],Invisible:1b,Marker:1b,NoGravity:1b,ShowArms:1b,HandItems:[{id:\"\",Count:1b},{}],CustomName:'{\"text\":\"LOTW-weapon_manipulation\"}',Pose:{RightArm:[-100f,270f,0f]}}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[type=item,nbt={Item:{id:\"minecraft:bow\",Count:1b}},distance=..10] at @s run data modify entity @e[name=LOTW-weapon_manipulation,limit=1,distance=..0.01] ArmorItems[0] merge from entity @s Item");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=item,nbt={Item:{id:\"minecraft:bow\",Count:1b}},distance=..10] run data modify entity @e[name=LOTW-weapon_manipulation,limit=1,distance=..0.01] HandItems[1] set value {id:\"lotw:bow\",Count:1b}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=item,nbt={Item:{id:\"minecraft:bow\",Count:1b}},distance=..10] run LOTW-spell4_count_bow");
				}
			}
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=item,nbt={Item:{id:\"minecraft:beehive\",Count:1b}},distance=..10] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-weapon_manipulation_type5\"],Invisible:1b,Marker:1b,NoGravity:1b,ShowArms:1b,HandItems:[{id:\"\",Count:1b},{}],CustomName:'{\"text\":\"LOTW-weapon_manipulation\"}'}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[type=item,nbt={Item:{id:\"minecraft:beehive\",Count:1b}},distance=..10] at @s run data modify entity @e[name=LOTW-weapon_manipulation,limit=1,distance=..0.01] ArmorItems[3] merge from entity @s Item");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=item,nbt={Item:{id:\"minecraft:beehive\",Count:1b}},distance=..10] run LOTW-spell4_count_beehive");
				}
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute at @e[name=LOTW-weapon_manipulation,distance=..10] if entity @e[type=item,distance=..0.01] run playsound minecraft:entity.evoker.prepare_summon ambient @a[distance=..100] ~ ~ ~ 1 0.75 0.025");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute at @e[name=LOTW-weapon_manipulation,distance=..10] if entity @e[type=item,distance=..0.01] run particle minecraft:campfire_signal_smoke ~ ~ ~ 0.5 0.5 0.5 0.005 5 force");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute at @e[name=LOTW-weapon_manipulation,distance=..10] run kill @e[type=item,distance=..0.01]");
		}
	}
}
