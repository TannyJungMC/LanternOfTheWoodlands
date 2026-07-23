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
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class UserBookPickUpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_book_place == true) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.user_book_place = false;
					_vars.markSyncDirty();
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							ReplaceIDProcedure.execute(entity, "data modify entity @e[tag=<USER>,tag=<ID>-user_book,limit=1] ArmorItems[3].id set value " + "\"lanternofthewoodlands:user_book\""));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							ReplaceIDProcedure.execute(entity, "execute at @e[tag=<USER>,tag=<ID>-user_book] run playsound minecraft:item.book.page_turn ambient @a[distance=..100] ~ ~ ~ 1 0.75 0.025"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							ReplaceIDProcedure.execute(entity, "execute at @e[tag=<USER>,tag=<ID>-user_book] run kill @e[tag=<USER>,tag=<ID>-mark,distance=..1]"));
				TanscomplexmagicMod.queueServerWork(20, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								ReplaceIDProcedure.execute(entity, "execute at @e[tag=<USER>,tag=<ID>-user_book] run playsound minecraft:entity.illusioner.cast_spell ambient @a[distance=..100] ~ ~ ~ 1 0 0.025"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								ReplaceIDProcedure.execute(entity, "execute at @e[tag=<USER>,tag=<ID>-user_book] run particle flash ~ ~1 ~ 0 0 0 0 1 force"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								ReplaceIDProcedure.execute(entity, "kill @e[tag=<USER>,tag=<ID>-user_book]"));
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack9 = new ItemStack(TanscomplexmagicModItems.USER_BOOK.get()).copy();
						_setstack9.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack9);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				});
			}
		}
	}
}