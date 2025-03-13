
package lotw.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import lotw.itemgroup.LotwTabItemGroup;

import lotw.LotwModElements;

@LotwModElements.ModElement.Tag
public class CustomPlantStage2Item extends LotwModElements.ModElement {
	@ObjectHolder("lotw:custom_plant_stage_2")
	public static final Item block = null;

	public CustomPlantStage2Item(LotwModElements instance) {
		super(instance, 1002);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(LotwTabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("custom_plant_stage_2");
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
