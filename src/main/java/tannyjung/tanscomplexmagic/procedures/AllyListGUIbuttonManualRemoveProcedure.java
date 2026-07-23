package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class AllyListGUIbuttonManualRemoveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String chosen = "";
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("")) {
			chosen = ("@e[" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_manual + ",tag=<ID>-ally_custom]").replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS);
			if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("User") || (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("User and Chosen")
					|| (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("User and Ally")
					|| (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("User, Chosen and Ally")) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("execute if entity " + chosen + " run tellraw @p [\"\",{\"text\":\"Removed \",\"color\":\"gold\"},{\"text\":\"\",\"color\":\"gray\",\"extra\":[{\"selector\":\"" + chosen
										+ "\"}]},{\"text\":\" from ally list\",\"color\":\"gold\"}]"));
					}
				}
			}
			if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("Ally") || (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("User and Ally")
					|| (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("Chosen and Ally")
					|| (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("User, Chosen and Ally")) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("execute if entity " + chosen + " run tellraw @a[" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_manual.replace("type=", "type=!")
										+ ",tag=<ID>-ally_custom] [\"\",{\"text\":\"\",\"color\":\"gold\",\"extra\":[{\"selector\":\"@p\"}]},{\"text\":\" removed \",\"color\":\"gold\"},{\"text\":\"\",\"color\":\"gray\",\"extra\":[{\"selector\":\""
										+ chosen + "\"}]},{\"text\":\" from ally list\",\"color\":\"gold\"}]"));
					}
				}
			}
			if ((entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("Chosen") || (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("User and Chosen")
					|| (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("Chosen and Ally")
					|| (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).ally_list_chat_setting).equals("User, Chosen and Ally")) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("execute if entity " + chosen + " run tellraw " + chosen + " [\"\",{\"text\":\"\",\"color\":\"gold\",\"extra\":[{\"selector\":\"@p\"}]},{\"text\":\" removed you from ally list\",\"color\":\"gold\"}]"));
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute if entity " + chosen + " run effect give " + chosen + " glowing 5 1 true"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						(("execute if entity " + chosen + " run tag " + chosen + " remove <ID>-ally").replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						(("execute if entity " + chosen + " run tag " + chosen + " remove <ID>-ally_custom").replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
		}
	}
}