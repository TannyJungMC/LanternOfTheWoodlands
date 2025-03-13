
package tannyjung.lanternofthewoodlands.item;

import tannyjung.lanternofthewoodlands.procedures.GetManaCreativeLoopProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.List;

public class GetManaCreativeItem extends Item {
	public GetManaCreativeItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.lanternofthewoodlands.get_mana_creative.description_0"));
		list.add(Component.translatable("item.lanternofthewoodlands.get_mana_creative.description_1"));
		list.add(Component.translatable("item.lanternofthewoodlands.get_mana_creative.description_2"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			GetManaCreativeLoopProcedure.execute(entity);
	}
}
