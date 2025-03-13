
package lotw.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import lotw.item.BagItem;

import lotw.LotwModElements;

@LotwModElements.ModElement.Tag
public class LotwTabItemGroup extends LotwModElements.ModElement {
	public LotwTabItemGroup(LotwModElements instance) {
		super(instance, 748);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablotw_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BagItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
