package lantern_of_the_woodlands.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.client.gui.widget.TextFieldWidget;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell5saveGUIProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell5saveGUI!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency guistate for procedure Spell5saveGUI!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius = (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_radius");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText());
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone = (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_safe_zone");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText());
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency = (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_circle");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText());
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_degree_frequency = (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_degree");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText());
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_down = (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_down");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText());
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_height = (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_height");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText());
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_thickness = (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_thickness");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText());
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_room = (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_room");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText());
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_no_wall = (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_no_wall");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText());
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_trap = (new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_trap");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText());
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		Spell5setSpinSpeedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

		Spell5setSAVEProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
	}
}
