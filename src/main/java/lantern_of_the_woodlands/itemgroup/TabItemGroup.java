
package lantern_of_the_woodlands.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import lantern_of_the_woodlands.block.Lantern15Block;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModElements;

@LanternOfTheWoodlandsModElements.ModElement.Tag
public class TabItemGroup extends LanternOfTheWoodlandsModElements.ModElement {
	public TabItemGroup(LanternOfTheWoodlandsModElements instance) {
		super(instance, 420);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Lantern15Block.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
