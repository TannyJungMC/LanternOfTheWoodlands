package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;
import tannyjung.tanscomplexmagic.init.TanscomplexmagicModItems;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class UserBookPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double direction_number = 0;
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user == true) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).main_key == true) {
				if ((entity.getDirection()) == Direction.NORTH) {
					direction_number = 0;
				} else if ((entity.getDirection()) == Direction.WEST) {
					direction_number = 270;
				} else if ((entity.getDirection()) == Direction.EAST) {
					direction_number = 90;
				} else if ((entity.getDirection()) == Direction.SOUTH) {
					direction_number = 180;
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TanscomplexmagicModItems.USER_BOOK.get()) {
					if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_place == false) {
						{
							TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
							_vars.user_book_place = true;
							_vars.user_book_item_open = false;
							_vars.markSyncDirty();
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack11 = ItemStack.EMPTY.copy();
							_setstack11.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack11);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (true) {
							{
								TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
								_vars.user_book_posX = x;
								_vars.user_book_posY = y;
								_vars.user_book_posZ = z;
								_vars.markSyncDirty();
							}
							if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_place == false) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											ReplaceIDProcedure.execute(entity, "execute positioned ~0.5 ~1 ~0.5 run " + SummonArmorStandProcedure.execute("", "mark")));
							}
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										ReplaceIDProcedure.execute(entity, "execute positioned ~0.5 ~1.5 ~0.5 run " + SummonArmorStandProcedure
												.execute("ArmorItems:[{},{},{},{id:\"" + "lanternofthewoodlands:user_book" + "\",Count:1b}],Pose:{Head:[" + "-45" + "f,0f,0f]},Small:1b,Rotation:[" + direction_number + "f]", "user_book")));
							TanscomplexmagicMod.queueServerWork(10, () -> {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands()
												.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
														_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														ReplaceIDProcedure.execute(entity, "execute as @e[tag=<USER>,tag=<ID>-user_book] at @s run tp @s ~ ~ ~ facing entity @p"));
									}
								}
								TanscomplexmagicMod.queueServerWork(10, () -> {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												ReplaceIDProcedure.execute(entity, "execute as @e[tag=<USER>,tag=<ID>-user_book] at @s run data modify entity @s ArmorItems[3].id set value \"lanternofthewoodlands:user_book_open_block\""));
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												ReplaceIDProcedure.execute(entity, "execute at @e[tag=<USER>,tag=<ID>-user_book] run playsound minecraft:item.book.page_turn ambient @a[distance=..100] ~ ~ ~ 1 0.75 0.025"));
								});
							});
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TanscomplexmagicModItems.USER_BOOK_OPEN.get()) {
					if ((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString())
							.equals(BuiltInRegistries.ITEM.getKey(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon.getItem()).toString())
							&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getDisplayName().getString())
									.equals(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon.getDisplayName().getString())) {
						if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_place == false) {
							{
								TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
								_vars.personal_weapon_place = true;
								_vars.markSyncDirty();
							}
							if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_place == false) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											(("summon armor_stand ~0.5 ~1 ~0.5 {Tags:[" + "\"LOTW\",\"<ID>\",\"<ID>-ally\"" + "],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"" + "<ID>-mark" + "\"}'}").replace("<ID>",
													entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
							}
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										(("summon armor_stand ~0.5 ~1 ~0.5 {Tags:[" + "\"LOTW\",\"<ID>\",\"<ID>-ally\"" + "],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"" + "<ID>-personal_weapon" + "\"}',Rotation:[" + direction_number
												+ "f]}").replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										(("execute at @e[name=<ID>-personal_weapon] run summon armor_stand ~ ~ ~ {Tags:[" + "\"LOTW\",\"<ID>\",\"<ID>-ally\"" + "],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\""
												+ "<ID>-personal_weapon_display" + "\"}',Rotation:[" + direction_number + "f]}").replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										(("execute at @e[name=<ID>-personal_weapon] run tp @e[name=<ID>-personal_weapon_display] ^" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pos_x + " ^"
												+ entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pos_y + " ^" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pos_z)
												.replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										(("data modify entity @e[name=<ID>-personal_weapon_display,limit=1] Pose.RightArm set value " + "[" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pose_x + "f,"
												+ entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pose_y + "f," + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pose_z + "f]")
												.replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute as @e[name=<ID>-personal_weapon] at @s run tp @s ~ ~ ~ facing entity @p".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
								}
							}
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute as @e[name=<ID>-personal_weapon_display] at @s run tp @s ~ ~ ~ facing entity @p".replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
								}
							}
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("data modify entity @e[name=<ID>-personal_weapon_display,limit=1] HandItems[0] set from entity @p Inventory[{Slot:-106b}]".replace("<ID>",
												entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack36 = ItemStack.EMPTY.copy();
								_setstack36.setCount(1);
								_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack36);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
			}
		}
	}
}