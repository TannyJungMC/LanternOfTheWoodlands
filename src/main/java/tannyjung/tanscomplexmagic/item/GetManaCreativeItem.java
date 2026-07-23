package tannyjung.tanscomplexmagic.item;

import tannyjung.tanscomplexmagic.procedures.GetManaCreativeLoopProcedure;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.List;

public class GetManaCreativeItem extends Item {
	public GetManaCreativeItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.tanscomplexmagic.get_mana_creative.description_0"));
		list.add(Component.translatable("item.tanscomplexmagic.get_mana_creative.description_1"));
		list.add(Component.translatable("item.tanscomplexmagic.get_mana_creative.description_2"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			GetManaCreativeLoopProcedure.execute(entity);
	}
}