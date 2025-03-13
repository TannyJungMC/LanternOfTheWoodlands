package tannyjung.lanternofthewoodlands.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class GUIbuttonSocialLinksProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level().getServer(), _ent),
						("tellraw @p [\"\"," + ""
								+ ("{\"text\":\"LOTW : \",\"color\":\"gray\"}," + "" + "{\"text\":\"CurseForge\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://legacy.curseforge.com/members/tannyjung/projects\"}},"
										+ "{\"text\":\" | \",\"color\":\"gray\"}," + "{\"text\":\"Discord\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://discord.gg/SPPc2J7Unx\"}},"
										+ "{\"text\":\" | \",\"color\":\"gray\"}," + "{\"text\":\"Patreon\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://www.patreon.com/tannyjung\"}},"
										+ "{\"text\":\" | \",\"color\":\"gray\"}," + "{\"text\":\"Twitter\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://twitter.com/TannyJung\"}},"
										+ "{\"text\":\" | \",\"color\":\"gray\"}," + "{\"text\":\"Pinterest\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://www.pinterest.com/tannyjungmc/tannyjung-pins/\"}}]")));
			}
		}
	}
}
