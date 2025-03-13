package tannyjung.lanternofthewoodlands.procedures;

import net.minecraft.world.entity.Entity;

public class ReplaceIDProcedure {
	public static String execute(Entity entity, String text) {
		if (entity == null || text == null)
			return "";
		String variable_text = "";
		variable_text = text;
		variable_text = variable_text.replace("<ID>", "lanternofthewoodlands");
		variable_text = variable_text.replace("<USER>", entity.getStringUUID() + "-lanternofthewoodlands");
		return variable_text;
	}
}
