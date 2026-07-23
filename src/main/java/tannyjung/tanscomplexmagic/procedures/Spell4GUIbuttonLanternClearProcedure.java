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

public class Spell4GUIbuttonLanternClearProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String variable_text = "";
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("") && entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).spell == 4) {
			variable_text = "lantern";
			{
				TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
				_vars.spell4_weapon_lantern_count = 0;
				_vars.markSyncDirty();
			}
			if (true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("execute at @e[tag=<ID>-spell4_" + variable_text + "] run summon item ~ ~ ~ {Item:{id:\"minecraft:lantern\",Count:1b}}").replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("execute at @e[tag=<ID>-spell4_" + variable_text + "] run playsound minecraft:item.trident.return ambient @a[distance=..100] ~ ~ ~ 1 0.75 0.025").replace("<ID>",
									entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("execute at @e[tag=<ID>-spell4_" + variable_text + "] run playsound minecraft:block.conduit.attack.target ambient @a[distance=..100] ~ ~ ~ 1 0.75 0.025").replace("<ID>",
									entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							(("kill @e[tag=<ID>-spell4_" + variable_text + "]").replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				if (true) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute at @e[name=<ID>-spell4_lantern_light] run playsound minecraft:entity.ender_dragon.flap ambient @a[distance=..100] ~ ~ ~ 0.5 1.25 0.025".replace("<ID>",
										entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("kill @e[tag=<ID>-spell4_lantern_light]".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
				}
			}
		}
	}
}