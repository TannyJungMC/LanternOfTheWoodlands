package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class Spell4SummonPickUpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean can_pick_up = false;
		String item_id = "";
		String name = "";
		name = "sword";
		if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_shoot == true
				&& (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_reverse == false) {
			if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_tick_summon > 0) {
				{
					double _setval = (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_tick_summon - 1;
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spell4_tick_summon = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					double _setval = 2;
					entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.spell4_tick_summon = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				name = "sword";
				item_id = "lanternofthewoodlands:sword_knight";
				if (true) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									ReplaceIDProcedure.execute(entity, ("execute positioned ^ ^ ^" + 2 + " run ") + ""
											+ SummonArmorStandProcedure.execute("ArmorItems:[{},{},{},{id:\"" + "" + item_id + "\",Count:1b}],Rotation:[" + entity.getYRot() + "f,0f]", "spell4 / spell4_" + name)));
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ReplaceIDProcedure.execute(entity, "execute positioned ^ ^ ^" + 2 + " run particle minecraft:flash ~ ~1.4 ~ 0 0 0 0 1 force"));
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											ReplaceIDProcedure.execute(entity, "execute positioned ^ ^ ^" + 2 + " run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..200] ~ ~1.4 ~ 2 0 0.025"));
						}
					}
				}
			}
		} else if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_shoot == false
				&& (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).spell4_reverse == true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						ReplaceIDProcedure.execute(entity, "execute at @e[tag=<USER>,tag=<ID>-spell4_" + name + ",limit=1,sort=nearest] positioned ~ ~1.5 ~ run particle minecraft:flash ~ ~ ~ 0 0 0 0 1 force"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						ReplaceIDProcedure.execute(entity, "execute at @e[tag=<USER>,tag=<ID>-spell4_" + name + ",tag=<ID>-spell4_hit,limit=1,sort=nearest] positioned ~ ~1.5 ~ run particle minecraft:campfire_cosy_smoke ~ ~ ~ 0 0 0 0.01 5 force"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						ReplaceIDProcedure.execute(entity,
								"execute at @e[tag=<USER>,tag=<ID>-spell4_" + name + ",limit=1,sort=nearest] positioned ~ ~1.5 ~ run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..200] ~ ~ ~ 2 0 0.025"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						ReplaceIDProcedure.execute(entity, "kill @e[tag=<USER>,tag=<ID>-spell4_" + name + ",limit=1,sort=nearest]"));
		}
	}
}
