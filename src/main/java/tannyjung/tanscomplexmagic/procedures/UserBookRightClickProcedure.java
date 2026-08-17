package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic_handcode.systems.Book;

import tannyjung.tanscomplexmagic.TanscomplexmagicMod;

import net.minecraft.world.entity.Entity;

public class UserBookRightClickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (false) {
			TanscomplexmagicMod.LOGGER.info(entity);
		}
		Book.whenRightClick(entity);
	}
}