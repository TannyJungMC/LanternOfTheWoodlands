
package tannyjung.lanternofthewoodlands.item;

import tannyjung.lanternofthewoodlands.procedures.UserBookRightClickProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.List;

public class UserBookOpenItem extends Item {
	public UserBookOpenItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.lanternofthewoodlands.user_book_open.description_0"));
		list.add(Component.translatable("item.lanternofthewoodlands.user_book_open.description_1"));
		list.add(Component.translatable("item.lanternofthewoodlands.user_book_open.description_2"));
		list.add(Component.translatable("item.lanternofthewoodlands.user_book_open.description_3"));
		list.add(Component.translatable("item.lanternofthewoodlands.user_book_open.description_4"));
		list.add(Component.translatable("item.lanternofthewoodlands.user_book_open.description_5"));
		list.add(Component.translatable("item.lanternofthewoodlands.user_book_open.description_6"));
		list.add(Component.translatable("item.lanternofthewoodlands.user_book_open.description_7"));
		list.add(Component.translatable("item.lanternofthewoodlands.user_book_open.description_8"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		UserBookRightClickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		UserBookRightClickProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
