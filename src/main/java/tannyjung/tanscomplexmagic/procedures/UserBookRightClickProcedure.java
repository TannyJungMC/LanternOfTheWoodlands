package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic_handcode.systems.Book;

import tannyjung.tanscomplexmagic.TanscomplexmagicMod;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;

public class UserBookRightClickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (false) {
			TanscomplexmagicMod.LOGGER.info(entity);
		}
		if (entity instanceof ServerPlayer == false)
			return;
		ServerPlayer player_server = (ServerPlayer) entity;
		ServerLevel level_server = player_server.serverLevel();
		Book.whenRightClick(player_server);
	}
}