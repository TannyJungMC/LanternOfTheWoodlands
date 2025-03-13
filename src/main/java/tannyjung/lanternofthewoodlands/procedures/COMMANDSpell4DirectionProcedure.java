package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class COMMANDSpell4DirectionProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		String variable_text = "";
		double variable_number = 0;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "entity")) {
				{
					Entity _ent = entityiterator;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("data merge entity @s {Pose:{Head:[" + entityiterator.getXRot() + "f,0f,0f]}}"));
					}
				}
				if (true) {
					if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_reverse == false) {
						variable_number = 1;
					} else {
						variable_number = -1;
					}
					if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_homing == false) {
						variable_text = "execute if entity @s[tag=!<ID>-spell4_shoot] ";
					} else {
						variable_text = "execute ";
					}
					if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_lock_target == false) {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										ReplaceIDProcedure.execute(entity, variable_text + "facing entity @e[tag=<USER>,tag=<ID>-spell4_target,limit=1] feet run tp @s ~ ~ ~ facing ^ ^ ^" + variable_number));
							}
						}
					} else {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										ReplaceIDProcedure.execute(entity,
												variable_text + "unless entity @e[tag=<USER>-spell4_lock_target] facing entity @e[tag=<USER>,tag=<ID>-spell4_target,limit=1] feet run tp @s ~ ~ ~ facing ^ ^ ^" + variable_number));
							}
						}
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										ReplaceIDProcedure.execute(entity, variable_text + "if entity @e[tag=<USER>-spell4_lock_target] facing entity @e[tag=<USER>-spell4_lock_target,limit=1] feet run tp @s ~ ~ ~ facing ^ ^ ^" + variable_number));
							}
						}
					}
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
