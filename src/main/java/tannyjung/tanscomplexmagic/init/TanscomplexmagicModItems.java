/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.tanscomplexmagic.init;

import tannyjung.tanscomplexmagic.item.*;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class TanscomplexmagicModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TanscomplexmagicMod.MODID);
	public static final DeferredItem<Item> TARGET_ARROW;
	public static final DeferredItem<Item> USER_BOOK;
	public static final DeferredItem<Item> USER_BOOK_OPEN;
	public static final DeferredItem<Item> USER_BOOK_OPEN_BLOCK;
	public static final DeferredItem<Item> SPELL_HEALING_CIRCLE;
	public static final DeferredItem<Item> REJUVENATING_MUSHROOM;
	public static final DeferredItem<Item> SPELL_TELEPORT_CIRCLE;
	public static final DeferredItem<Item> BOW;
	public static final DeferredItem<Item> BOW_1;
	public static final DeferredItem<Item> BOW_2;
	public static final DeferredItem<Item> BOW_3;
	public static final DeferredItem<Item> BOW_ARROW_SPAWN_EGG;
	public static final DeferredItem<Item> GET_MANA_CREATIVE;
	public static final DeferredItem<Item> LANTERN;
	public static final DeferredItem<Item> LANTERN_1;
	public static final DeferredItem<Item> LANTERN_2;
	public static final DeferredItem<Item> LANTERN_3;
	public static final DeferredItem<Item> ANCHOR;
	public static final DeferredItem<Item> KNIGHT_SWORD;
	public static final DeferredItem<Item> FORGOTTEN_SWORD;
	public static final DeferredItem<Item> SWORD_KNIGHT;
	static {
		TARGET_ARROW = block(TanscomplexmagicModBlocks.TARGET_ARROW);
		USER_BOOK = REGISTRY.register("user_book", UserBookItem::new);
		USER_BOOK_OPEN = REGISTRY.register("user_book_open", UserBookOpenItem::new);
		USER_BOOK_OPEN_BLOCK = block(TanscomplexmagicModBlocks.USER_BOOK_OPEN_BLOCK);
		SPELL_HEALING_CIRCLE = block(TanscomplexmagicModBlocks.SPELL_HEALING_CIRCLE);
		REJUVENATING_MUSHROOM = block(TanscomplexmagicModBlocks.REJUVENATING_MUSHROOM);
		SPELL_TELEPORT_CIRCLE = block(TanscomplexmagicModBlocks.SPELL_TELEPORT_CIRCLE);
		BOW = REGISTRY.register("bow", BowItem::new);
		BOW_1 = REGISTRY.register("bow_1", Bow1Item::new);
		BOW_2 = REGISTRY.register("bow_2", Bow2Item::new);
		BOW_3 = REGISTRY.register("bow_3", Bow3Item::new);
		BOW_ARROW_SPAWN_EGG = REGISTRY.register("bow_arrow_spawn_egg", () -> new DeferredSpawnEggItem(TanscomplexmagicModEntities.BOW_ARROW, -1, -1, new Item.Properties()));
		GET_MANA_CREATIVE = REGISTRY.register("get_mana_creative", GetManaCreativeItem::new);
		LANTERN = block(TanscomplexmagicModBlocks.LANTERN);
		LANTERN_1 = block(TanscomplexmagicModBlocks.LANTERN_1);
		LANTERN_2 = block(TanscomplexmagicModBlocks.LANTERN_2);
		LANTERN_3 = block(TanscomplexmagicModBlocks.LANTERN_3);
		ANCHOR = REGISTRY.register("anchor", AnchorItem::new);
		KNIGHT_SWORD = REGISTRY.register("knight_sword", KnightSwordItem::new);
		FORGOTTEN_SWORD = REGISTRY.register("forgotten_sword", ForgottenSwordItem::new);
		SWORD_KNIGHT = block(TanscomplexmagicModBlocks.SWORD_KNIGHT);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}