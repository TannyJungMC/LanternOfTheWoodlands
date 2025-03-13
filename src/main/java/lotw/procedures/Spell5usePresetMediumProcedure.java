package lotw.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.client.gui.widget.TextFieldWidget;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell5usePresetMediumProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell5usePresetMedium!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				LotwMod.LOGGER.warn("Failed to load dependency guistate for procedure Spell5usePresetMedium!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_radius");
			if (_tf != null) {
				_tf.setText("100");
			}
		}
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_safe_zone");
			if (_tf != null) {
				_tf.setText("20");
			}
		}
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_circle");
			if (_tf != null) {
				_tf.setText("3");
			}
		}
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_degree");
			if (_tf != null) {
				_tf.setText("15");
			}
		}
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_down");
			if (_tf != null) {
				_tf.setText("20");
			}
		}
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_height");
			if (_tf != null) {
				_tf.setText("70");
			}
		}
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_thickness");
			if (_tf != null) {
				_tf.setText("2");
			}
		}
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_room");
			if (_tf != null) {
				_tf.setText("25");
			}
		}
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_no_wall");
			if (_tf != null) {
				_tf.setText("25");
			}
		}
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell5_trap");
			if (_tf != null) {
				_tf.setText("25");
			}
		}
		Spell5saveGUIProcedure
				.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("guistate", guistate))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
	}
}
