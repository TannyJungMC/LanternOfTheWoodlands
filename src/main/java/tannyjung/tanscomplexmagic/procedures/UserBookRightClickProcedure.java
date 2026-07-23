package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;
import tannyjung.tanscomplexmagic.init.TanscomplexmagicModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class UserBookRightClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TanscomplexmagicModItems.USER_BOOK.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TanscomplexmagicModItems.USER_BOOK_OPEN.get()) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).main_key == true) {
				if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_item_open == false) {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.user_book_item_open = true;
						_vars.markSyncDirty();
					}
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack4 = new ItemStack(TanscomplexmagicModItems.USER_BOOK_OPEN.get()).copy();
						_setstack4.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack4);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:item.book.page_turn ambient @a[distance=..100] ~ ~ ~ 1 0.75 0.025");
						}
					}
				} else {
					{
						TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
						_vars.user_book_item_open = false;
						_vars.markSyncDirty();
					}
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack6 = new ItemStack(TanscomplexmagicModItems.USER_BOOK.get()).copy();
						_setstack6.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack6);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:item.book.page_turn ambient @a[distance=..100] ~ ~ ~ 1 0.75 0.025");
						}
					}
				}
			} else {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TanscomplexmagicModItems.USER_BOOK_OPEN.get()) {
					GUIOpenProcedure.execute(entity);
				}
			}
		}
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user == true) {
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).main_key == false) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TanscomplexmagicModItems.USER_BOOK_OPEN.get()) {
					if ((BuiltInRegistries.ITEM.getKey(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon.getItem()).toString())
							.equals(BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString())
							&& (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon.getDisplayName().getString())
									.equals((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDisplayName().getString())) {
						PersonalSkillClickProcedure.execute(world, x, y, z, entity);
					}
				}
			}
		}
	}
}