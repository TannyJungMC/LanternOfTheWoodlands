package tannyjung.lanternofthewoodlands.procedures;

public class SummonArmorStandProcedure {
	public static String execute(String custom, String tag) {
		if (custom == null || tag == null)
			return "";
		String variable_text = "";
		if ((custom).equals("")) {
			variable_text = "summon marker ~ ~ ~ {";
		} else {
			variable_text = "summon armor_stand ~ ~ ~ {";
		}
		variable_text = variable_text + "" + "Tags:[\"<ID>\",\"<USER>\",\"<USER>-ally\"," + ("\"<ID>-" + "" + tag.replace(" / ", "\",\"<ID>-") + "\"") + "],CustomName:'{\"text\":\"<ID>\"}'";
		if (!(custom).equals("")) {
			variable_text = variable_text + ",NoGravity:1b,Invisible:1b,Marker:1b," + custom;
		}
		return variable_text + "}";
	}
}
