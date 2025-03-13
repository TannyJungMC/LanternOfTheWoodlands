
package lotw.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import lotw.itemgroup.LotwTabItemGroup;

import lotw.LotwModElements;

@LotwModElements.ModElement.Tag
public class Bow3Item extends LotwModElements.ModElement {
	@ObjectHolder("lotw:bow_3")
	public static final Item block = null;

	public Bow3Item(LotwModElements instance) {
		super(instance, 858);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(LotwTabItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("bow_3");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
