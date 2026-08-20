/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.tanscomplexmagic.init;

import tannyjung.tanscomplexmagic.TanscomplexmagicMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class TanscomplexmagicModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TanscomplexmagicMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = REGISTRY.register("tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tanscomplexmagic.tab")).icon(() -> new ItemStack(TanscomplexmagicModItems.USER_BOOK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TanscomplexmagicModItems.USER_BOOK.get());
				tabData.accept(TanscomplexmagicModItems.CREATIVE_MANA.get());
			}).build());
}