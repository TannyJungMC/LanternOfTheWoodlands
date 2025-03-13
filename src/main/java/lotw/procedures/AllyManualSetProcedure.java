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

public class AllyManualSetProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure AllyManualSet!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure AllyManualSet!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure AllyManualSet!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure AllyManualSet!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User")
				|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User and Chosen")
				|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User and Ally")
				|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User, Chosen and Ally")) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute if entity " + ("@e[type=" + LotwModVariables.MapVariables.get(world).player_list_manual + ",tag=!LOTW-ally]")
								+ " run tellraw @p[tag=LOTW-user] [\"\",{\"text\":\"Added \",\"color\":\"dark_green\"},{\"text\":\"\",\"color\":\"gray\",\"extra\":[{\"selector\":\""
								+ ("@e[type=" + LotwModVariables.MapVariables.get(world).player_list_manual + ",tag=!LOTW-ally]")
								+ "\"}]},{\"text\":\" to lantern ally list\",\"color\":\"dark_green\"}]"));
			}
		}
		if ((LotwModVariables.MapVariables.get(world).ally_list_chat).equals("Ally")
				|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User and Ally")
				|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("Chosen and Ally")
				|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User, Chosen and Ally")) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute if entity " + ("@e[type=" + LotwModVariables.MapVariables.get(world).player_list_manual + ",tag=!LOTW-ally]")
								+ " run tellraw " + "@a[tag=LOTW-ally,tag=!LOTW-user]"
								+ " [\"\",{\"text\":\"\",\"color\":\"dark_green\",\"extra\":[{\"selector\":\"@p[tag=LOTW-user]\"}]},{\"text\":\" added \",\"color\":\"dark_green\"},{\"text\":\"\",\"color\":\"gray\",\"extra\":[{\"selector\":\""
								+ ("@e[type=" + LotwModVariables.MapVariables.get(world).player_list_manual + ",tag=!LOTW-ally]")
								+ "\"}]},{\"text\":\" to lantern ally list\",\"color\":\"dark_green\"}]"));
			}
		}
		if ((LotwModVariables.MapVariables.get(world).ally_list_chat).equals("Chosen")
				|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User and Chosen")
				|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("Chosen and Ally")
				|| (LotwModVariables.MapVariables.get(world).ally_list_chat).equals("User, Chosen and Ally")) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute if entity " + ("@e[type=" + LotwModVariables.MapVariables.get(world).player_list_manual + ",tag=!LOTW-ally]")
								+ " run tellraw " + ("@e[type=" + LotwModVariables.MapVariables.get(world).player_list_manual + ",tag=!LOTW-ally]")
								+ " [\"\",{\"text\":\"\",\"color\":\"dark_green\",\"extra\":[{\"selector\":\"@p[tag=LOTW-user]\"}]},{\"text\":\" added you to lantern ally list\",\"color\":\"dark_green\"}]"));
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("execute if entity " + ("@e[type=" + LotwModVariables.MapVariables.get(world).player_list_manual + ",tag=!LOTW-ally]")
							+ " run effect give " + ("@e[type=" + LotwModVariables.MapVariables.get(world).player_list_manual + ",tag=!LOTW-ally]")
							+ " glowing 5 1 true"));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("execute if entity " + ("@e[type=" + LotwModVariables.MapVariables.get(world).player_list_manual + ",tag=!LOTW-ally]")
							+ " run tag " + ("@e[type=" + LotwModVariables.MapVariables.get(world).player_list_manual + ",tag=!LOTW-ally]")
							+ " add LOTW-ally"));
		}
	}
}
