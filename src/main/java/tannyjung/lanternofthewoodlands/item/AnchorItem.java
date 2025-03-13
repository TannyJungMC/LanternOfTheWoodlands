
package tannyjung.lanternofthewoodlands.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AnchorItem extends Item {
	public AnchorItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
