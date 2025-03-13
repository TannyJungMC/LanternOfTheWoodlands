
package lantern_of_the_woodlands.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;

import lantern_of_the_woodlands.itemgroup.TabItemGroup;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModElements;

import java.util.List;

@LanternOfTheWoodlandsModElements.ModElement.Tag
public class ForestStaffItem extends LanternOfTheWoodlandsModElements.ModElement {
	@ObjectHolder("lantern_of_the_woodlands:forest_staff")
	public static final Item block = null;

	public ForestStaffItem(LanternOfTheWoodlandsModElements instance) {
		super(instance, 436);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 75;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return 13f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.25f, new Item.Properties().group(TabItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("--------------------"));
				list.add(new StringTextComponent("info"));
				list.add(new StringTextComponent("> for use in dark autumn spell"));
				list.add(new StringTextComponent("> instant healing ally in area"));
				list.add(new StringTextComponent("--------------------"));
			}
		}.setRegistryName("forest_staff"));
	}
}
