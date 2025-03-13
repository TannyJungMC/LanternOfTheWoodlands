package lantern_of_the_woodlands.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;

public class TreeIllusionWhenPlaceProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure TreeIllusionWhenPlace!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure TreeIllusionWhenPlace!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure TreeIllusionWhenPlace!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure TreeIllusionWhenPlace!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (Math.random() <= 0.5) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"summon armor_stand ~0.5 ~ ~0.5 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-pre_tree_illusion\"}'}");
			}
		} else if (Math.random() <= 0.5) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"summon armor_stand ~0.5 ~-1 ~0.5 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-pre_tree_illusion\"}'}");
			}
		} else {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"summon armor_stand ~0.5 ~-2 ~0.5 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-pre_tree_illusion\"}'}");
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute at @e[type=armor_stand,name=lotw-pre_tree_illusion,tag=!lotw-tree_illusion_placed] run summon armor_stand ~ ~ ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-tree_illusion\"}'}");
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~ ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_log\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~1 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_log\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~2 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_log\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~3 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_log\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~4 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_log\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~5 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_log\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~6 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~6 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~6 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~6 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~6 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~4 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~4 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~4 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~4 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~4 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~4 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~4 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~4 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~2 ~4 ~2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~2 ~4 ~-2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-2 ~4 ~2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-2 ~4 ~-2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~2 ~4 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~2 ~4 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-2 ~4 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-2 ~4 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~4 ~2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~4 ~-2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~4 ~2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~4 ~-2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~2 ~4 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-2 ~4 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~4 ~2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~4 ~-2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~3 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~3 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~3 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~3 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~3 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~3 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~3 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~3 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~2 ~3 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~2 ~3 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-2 ~3 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-2 ~3 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~3 ~2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~3 ~-2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~3 ~2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~3 ~-2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~2 ~3 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-2 ~3 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~3 ~2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~3 ~-2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~5 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~5 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~ ~5 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~5 ~ {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
			}
		}
		if (true) {
			if (Math.random() <= 0.75) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-2 ~3 ~-2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
				}
			}
			if (Math.random() <= 0.75) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-2 ~3 ~2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
				}
			}
			if (Math.random() <= 0.75) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~2 ~3 ~-2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
				}
			}
			if (Math.random() <= 0.75) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~2 ~3 ~2 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
				}
			}
		}
		if (true) {
			if (Math.random() <= 0.75) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~5 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
				}
			}
			if (Math.random() <= 0.75) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~1 ~5 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
				}
			}
			if (Math.random() <= 0.75) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~5 ~1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
				}
			}
			if (Math.random() <= 0.75) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-tree_illusion] run summon armor_stand ~-1 ~5 ~-1 {NoGravity:1b,Marker:1b,Invisible:1b,CustomName:'{\"text\":\"lotw-illusion_block\"}',Tags:[\"extra\",\"lotw-illusion_block_leaves\"]}");
				}
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z),
					Vector2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"setblock ~ ~ ~ air");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute as @e[type=armor_stand,name=lotw-pre_tree_illusion] at @s run tag @s add lotw-tree_illusion_placed");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"kill @e[type=armor_stand,name=lotw-tree_illusion]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/playsound minecraft:entity.evoker.prepare_summon ambient @a[distance=..100] ~ ~ ~ 2 0.75 0.025");
		}
	}
}
