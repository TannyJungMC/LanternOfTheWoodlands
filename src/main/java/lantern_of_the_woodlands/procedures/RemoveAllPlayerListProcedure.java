package lantern_of_the_woodlands.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.gui.widget.TextFieldWidget;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;
import java.util.HashMap;

public class RemoveAllPlayerListProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure RemoveAllPlayerList!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure RemoveAllPlayerList!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure RemoveAllPlayerList!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure RemoveAllPlayerList!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency guistate for procedure RemoveAllPlayerList!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("tellraw @p[tag=woodlands] [\"\",{\"text\":\"Removed \",\"color\":\"gold\"},{\"text\":\"\",\"color\":\"gray\",\"extra\":[{\"selector\":\""
							+ "@e[tag=!woodlands,tag=wsupport]" + "\"}]},{\"text\":\" from affiliate list\",\"color\":\"gold\"}]"));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("/tag " + "@e[tag=!woodlands]" + " remove wsupport"));
		}
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:add_player_list");
			if (_tf != null) {
				_tf.setText("");
			}
		}
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:add_player_list2");
			if (_tf != null) {
				_tf.setText("");
			}
		}
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:add_player_list3");
			if (_tf != null) {
				_tf.setText("");
			}
		}
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:add_player_list4");
			if (_tf != null) {
				_tf.setText("");
			}
		}
	}
}
