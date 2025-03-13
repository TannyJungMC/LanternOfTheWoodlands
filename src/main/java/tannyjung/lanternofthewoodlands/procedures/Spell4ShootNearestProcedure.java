package tannyjung.lanternofthewoodlands.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class Spell4ShootNearestProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					ReplaceIDProcedure.execute(entity, "execute at @e[tag=<USER>,tag=<ID>-spell4_target] at @e[tag=<USER>,tag=<ID>-spell4_sword,tag=!<ID>-spell4_shoot,tag=!<ID>-spell4_hit,limit=1,sort=nearest] positioned ~ ~1.5 ~ run "
							+ "particle minecraft:flash ~ ~ ~ 0.25 0.25 0.25 0.01 1 force"));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					ReplaceIDProcedure.execute(entity, "execute at @e[tag=<USER>,tag=<ID>-spell4_target] at @e[tag=<USER>,tag=<ID>-spell4_sword,tag=!<ID>-spell4_shoot,tag=!<ID>-spell4_hit,limit=1,sort=nearest] positioned ~ ~1.5 ~ run "
							+ "playsound minecraft:entity.firework_rocket.large_blast ambient @a[distance=..100] ~ ~ ~ 2 0 0.025"));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					ReplaceIDProcedure.execute(entity, "execute at @e[tag=<USER>,tag=<ID>-spell4_target] at @e[tag=<USER>,tag=<ID>-spell4_sword,tag=!<ID>-spell4_shoot,tag=!<ID>-spell4_hit,limit=1,sort=nearest] positioned ~ ~1.5 ~ run "
							+ ("playsound minecraft:item.trident.thunder ambient @a[distance=..100] ~ ~ ~ 1 " + Mth.nextDouble(RandomSource.create(), 0.5, 2) + " 0.025")));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					ReplaceIDProcedure.execute(entity, "execute at @e[tag=<USER>,tag=<ID>-spell4_target] run tag @e[tag=<USER>,tag=<ID>-spell4_sword,tag=!<ID>-spell4_shoot,tag=!<ID>-spell4_hit,limit=1,sort=nearest] add <ID>-spell4_shoot"));
	}
}
