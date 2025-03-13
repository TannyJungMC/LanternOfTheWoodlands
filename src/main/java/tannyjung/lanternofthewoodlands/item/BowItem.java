
package tannyjung.lanternofthewoodlands.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BowItem extends Item {
	public BowItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
