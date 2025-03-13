package lotw.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import lotw.item.BagItem;

import lotw.block.BagBlockBlock;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Random;
import java.util.Map;

public class BagPlaceProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure BagPlace!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure BagPlace!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure BagPlace!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure BagPlace!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure BagPlace!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == BagItem.block
				&& entity.isSneaking() == true && BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:air_blocks"))
						.contains((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock())) {
			world.setBlockState(new BlockPos(x, y + 1, z), BagBlockBlock.block.getDefaultState(), 3);
			if ((entity.getHorizontalFacing()) == Direction.NORTH) {
				try {
					BlockState _bs = world.getBlockState(new BlockPos(x, y + 1, z));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos(x, y + 1, z), _bs.with(_property, Direction.SOUTH), 3);
					} else {
						world.setBlockState(new BlockPos(x, y + 1, z), _bs.with(
								(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.SOUTH.getAxis()), 3);
					}
				} catch (Exception e) {
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon armor_stand ~0.5 ~1 ~0.5 {Tags:[\"LOTW-ally\",\"LOTW-custom_planting\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-custom_planting_bag\"}',Rotation:[180f]}");
				}
			} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
				try {
					BlockState _bs = world.getBlockState(new BlockPos(x, y + 1, z));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos(x, y + 1, z), _bs.with(_property, Direction.EAST), 3);
					} else {
						world.setBlockState(new BlockPos(x, y + 1, z), _bs.with(
								(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.EAST.getAxis()), 3);
					}
				} catch (Exception e) {
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon armor_stand ~0.5 ~1 ~0.5 {Tags:[\"LOTW-ally\",\"LOTW-custom_planting\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-custom_planting_bag\"}',Rotation:[90f]}");
				}
			} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
				try {
					BlockState _bs = world.getBlockState(new BlockPos(x, y + 1, z));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos(x, y + 1, z), _bs.with(_property, Direction.WEST), 3);
					} else {
						world.setBlockState(new BlockPos(x, y + 1, z), _bs.with(
								(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.WEST.getAxis()), 3);
					}
				} catch (Exception e) {
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon armor_stand ~0.5 ~1 ~0.5 {Tags:[\"LOTW-ally\",\"LOTW-custom_planting\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-custom_planting_bag\"}',Rotation:[-90f]}");
				}
			} else if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
				try {
					BlockState _bs = world.getBlockState(new BlockPos(x, y + 1, z));
					DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (_property != null) {
						world.setBlockState(new BlockPos(x, y + 1, z), _bs.with(_property, Direction.NORTH), 3);
					} else {
						world.setBlockState(new BlockPos(x, y + 1, z), _bs.with(
								(EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.NORTH.getAxis()), 3);
					}
				} catch (Exception e) {
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"summon armor_stand ~0.5 ~1 ~0.5 {Tags:[\"LOTW-ally\",\"LOTW-custom_planting\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-custom_planting_bag\"}',Rotation:[0f]}");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							("data modify block "
									+ ((new java.text.DecimalFormat("##.#").format(x)).replace(".0", "") + " "
											+ (new java.text.DecimalFormat("##.#").format(y + 1)).replace(".0", "") + " "
											+ (new java.text.DecimalFormat("##.#").format(z)).replace(".0", ""))
									+ " Items set from entity @s SelectedItem.ForgeCaps.Parent.Items"));
				}
			}
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(Blocks.AIR);
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			if (true) {
				if (true) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-custom_planting_bag] run summon armor_stand ^0.285 ^-0.655 ^-0.3 {Tags:[\"LOTW-ally\",\"LOTW-custom_planting\",\"LOTW-custom_planting_bag1\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-custom_planting_0\"}',Small:1b,ShowArms:1b,Pose:{LeftArm:[0.0f,90.0f,90.0f]},HandItems:[{},{id:\"\",Count:1b}],Rotation:["
										+ "" + MathHelper.nextDouble(new Random(), 0, 360) + "f]}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-custom_planting_bag] run summon armor_stand ^0.285 ^-0.655 ^-0.115 {Tags:[\"LOTW-ally\",\"LOTW-custom_planting\",\"LOTW-custom_planting_bag2\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-custom_planting_0\"}',Small:1b,ShowArms:1b,Pose:{LeftArm:[0.0f,90.0f,90.0f]},HandItems:[{},{id:\"\",Count:1b}],Rotation:["
										+ "" + MathHelper.nextDouble(new Random(), 0, 360) + "f]}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-custom_planting_bag] run summon armor_stand ^0.0975 ^-0.655 ^-0.115 {Tags:[\"LOTW-ally\",\"LOTW-custom_planting\",\"LOTW-custom_planting_bag3\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-custom_planting_0\"}',Small:1b,ShowArms:1b,Pose:{LeftArm:[0.0f,90.0f,90.0f]},HandItems:[{},{id:\"\",Count:1b}],Rotation:["
										+ "" + MathHelper.nextDouble(new Random(), 0, 360) + "f]}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-custom_planting_bag] run summon armor_stand ^-0.1025 ^-0.655 ^-0.115 {Tags:[\"LOTW-ally\",\"LOTW-custom_planting\",\"LOTW-custom_planting_bag4\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-custom_planting_0\"}',Small:1b,ShowArms:1b,Pose:{LeftArm:[0.0f,90.0f,90.0f]},HandItems:[{},{id:\"\",Count:1b}],Rotation:["
										+ "" + MathHelper.nextDouble(new Random(), 0, 360) + "f]}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-custom_planting_bag] run summon armor_stand ^-0.295 ^-0.655 ^-0.115 {Tags:[\"LOTW-ally\",\"LOTW-custom_planting\",\"LOTW-custom_planting_bag5\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-custom_planting_0\"}',Small:1b,ShowArms:1b,Pose:{LeftArm:[0.0f,90.0f,90.0f]},HandItems:[{},{id:\"\",Count:1b}],Rotation:["
										+ "" + MathHelper.nextDouble(new Random(), 0, 360) + "f]}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute at @e[name=LOTW-custom_planting_bag] run summon armor_stand ^-0.295 ^-0.655 ^-0.2975 {Tags:[\"LOTW-ally\",\"LOTW-custom_planting\",\"LOTW-custom_planting_bag6\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-custom_planting_0\"}',Small:1b,ShowArms:1b,Pose:{LeftArm:[0.0f,90.0f,90.0f]},HandItems:[{},{id:\"\",Count:1b}],Rotation:["
										+ "" + MathHelper.nextDouble(new Random(), 0, 360) + "f]}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-custom_planting_bag] positioned ~ ~-0.71 ~ as @e[tag=LOTW-custom_planting,distance=..1,limit=6,sort=nearest] at @s run tp @s ^0.125 ^ ^-0.025");
					}
				}
				LotwModVariables.MapVariables.get(world).bag_place = (true);
				LotwModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-custom_planting_bag] run summon armor_stand ^-0.3 ^-0.27 ^0.0425 {Tags:[\"LOTW-ally\",\"LOTW-custom_planting\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-custom_planting_bag_lantern\"}',Small:1b,ArmorItems:[{},{},{},{id:\"lotw:mini_lantern\",Count:1b}]}");
				}
				if ((LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble).equals("")) {
					LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble = "User";
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
				LotwModVariables.MapVariables.get(world).bag_lantern = "Off";
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
