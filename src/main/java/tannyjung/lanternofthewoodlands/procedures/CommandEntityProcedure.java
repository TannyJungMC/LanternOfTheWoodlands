package tannyjung.lanternofthewoodlands.procedures;

public class CommandEntityProcedure {
	public static String execute(String command, String entity) {
		if (command == null || entity == null)
			return "";
		return "execute if entity " + entity + " run lanternofthewoodlands " + command + " " + entity;
	}
}
