package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.TanscomplexmagicMod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import tannyjung.tanscomplexmagic_core.game.screen.GUIManager;

public class GUIOpenProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double variable_number = 0;
		if (false) {
			TanscomplexmagicMod.LOGGER.info(entity);
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:item.book.page_turn ambient @a[distance=..100] ~ ~ ~ 1 0.75 0.025");
			}
		}
		GUIManager.open((Player) entity);
	}
}