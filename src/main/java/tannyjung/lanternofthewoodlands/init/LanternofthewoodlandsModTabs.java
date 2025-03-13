
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.lanternofthewoodlands.init;

import tannyjung.lanternofthewoodlands.LanternofthewoodlandsMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class LanternofthewoodlandsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LanternofthewoodlandsMod.MODID);
	public static final RegistryObject<CreativeModeTab> LOTW_TAB = REGISTRY.register("lotw_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.lanternofthewoodlands.lotw_tab")).icon(() -> new ItemStack(LanternofthewoodlandsModItems.USER_BOOK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(LanternofthewoodlandsModItems.USER_BOOK.get());
				tabData.accept(LanternofthewoodlandsModItems.GET_MANA_CREATIVE.get());
			}).build());
}
