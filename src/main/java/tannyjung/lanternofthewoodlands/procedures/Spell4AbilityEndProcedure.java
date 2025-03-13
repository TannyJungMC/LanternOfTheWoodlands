package tannyjung.lanternofthewoodlands.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class Spell4AbilityEndProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (true) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							ReplaceIDProcedure.execute(entity, "execute as @e[tag=<USER>,tag=<ID>-spell4_sword] at @s if data entity @s ArmorItems[0].id run " + "particle minecraft:flash ~ ~1.5 ~ 0 0 0 0 1 force"));
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							ReplaceIDProcedure.execute(entity,
									"execute as @e[tag=<USER>,tag=<ID>-spell4_sword] at @s if data entity @s ArmorItems[0].id run " + "playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..100] ~ ~ ~ 2 0 0.025"));
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							ReplaceIDProcedure.execute(entity, "execute as @e[tag=<USER>,tag=<ID>-spell4_sword] at @s if data entity @s ArmorItems[0].id run " + "data modify entity @s ArmorItems[3] set from entity @s ArmorItems[0]"));
				}
			}
		}
	}
}
