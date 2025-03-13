
package lantern_of_the_woodlands.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import lantern_of_the_woodlands.procedures.BasicSpell12whenClickProcedure;
import lantern_of_the_woodlands.procedures.BasicSpell12repeatSLOWProcedure;

import lantern_of_the_woodlands.itemgroup.TabItemGroup;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@LanternOfTheWoodlandsModElements.ModElement.Tag
public class BottleOfManaItem extends LanternOfTheWoodlandsModElements.ModElement {
	@ObjectHolder("lantern_of_the_woodlands:bottle_of_mana")
	public static final Item block = null;

	public BottleOfManaItem(LanternOfTheWoodlandsModElements instance) {
		super(instance, 550);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TabItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("bottle_of_mana");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("--------------------"));
			list.add(new StringTextComponent("info"));
			list.add(new StringTextComponent("> hold lantern in left hand and hold this in right hand to auto-trans mana to the bottle"));
			list.add(new StringTextComponent("> hold in left hand and click to get 1 mana"));
			list.add(new StringTextComponent("> hold in left hand and hold shift and click to fill all mana"));
			list.add(new StringTextComponent("> hold in left hand to see mana"));
			list.add(new StringTextComponent("> can store 60 mana"));
			list.add(new StringTextComponent("> cancel this spell will reset mana in bottle"));
			list.add(new StringTextComponent("--------------------"));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			BasicSpell12whenClickProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return ar;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			BasicSpell12repeatSLOWProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
