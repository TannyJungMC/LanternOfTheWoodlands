package lantern_of_the_woodlands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.client.gui.widget.TextFieldWidget;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;
import java.util.HashMap;

public class AllySaveProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure AllySave!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency guistate for procedure AllySave!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).ally_list_start_save == true) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).ally_list_save = (new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:add_player_list");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText());
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).ally_list_save2 = (new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:add_player_list2");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText());
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).ally_list_save3 = (new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:add_player_list3");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText());
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).ally_list_save4 = (new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:add_player_list4");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText());
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
