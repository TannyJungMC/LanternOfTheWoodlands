package lantern_of_the_woodlands.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;

public class Spell4resetProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell4reset!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell4reset!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell4reset!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell4reset!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).main_spell == 4) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_start == true) {
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_swap = 0;
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_1shoot = (false);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_2shoot = (false);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_3shoot = (false);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_4shoot = (false);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_5shoot = (false);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_6shoot = (false);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_7shoot = (false);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_8shoot = (false);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_number = "";
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_shoot_weapon_number = "";
				LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=spell4weapon,tag=shoot] run particle minecraft:campfire_signal_smoke ~ ~1 ~ 0.5 0.5 0.5 0.003 20 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[type=armor_stand,name=spell4weapon,tag=shoot] run playsound minecraft:block.enchantment_table.use ambient @a ~ ~ ~ 0.5 0");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @p[tag=woodlands] run playsound minecraft:block.enchantment_table.use ambient @a ~ ~ ~ 0.5 0");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"tag @e[type=armor_stand,name=spell4weapon] remove shoot");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"tag @e[type=armor_stand,name=spell4weapon] remove choose");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"tag @e[type=armor_stand,name=spell4shoot] remove shoot");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"kill @e[type=armor_stand,name=spell4shoot]");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/title @p[tag=woodlands] actionbar [{\"text\":\"Nothing\",\"color\":\"red\"}]");
				}
			}
		}
	}
}
