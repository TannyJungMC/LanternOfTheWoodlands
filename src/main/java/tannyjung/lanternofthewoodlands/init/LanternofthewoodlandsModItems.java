
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.lanternofthewoodlands.init;

import tannyjung.lanternofthewoodlands.item.UserBookOpenItem;
import tannyjung.lanternofthewoodlands.item.UserBookItem;
import tannyjung.lanternofthewoodlands.item.KnightSwordItem;
import tannyjung.lanternofthewoodlands.item.GetManaCreativeItem;
import tannyjung.lanternofthewoodlands.item.ForgottenSwordItem;
import tannyjung.lanternofthewoodlands.item.BowItem;
import tannyjung.lanternofthewoodlands.item.Bow3Item;
import tannyjung.lanternofthewoodlands.item.Bow2Item;
import tannyjung.lanternofthewoodlands.item.Bow1Item;
import tannyjung.lanternofthewoodlands.item.AnchorItem;
import tannyjung.lanternofthewoodlands.LanternofthewoodlandsMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class LanternofthewoodlandsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, LanternofthewoodlandsMod.MODID);
	public static final RegistryObject<Item> TARGET_ARROW = block(LanternofthewoodlandsModBlocks.TARGET_ARROW);
	public static final RegistryObject<Item> USER_BOOK = REGISTRY.register("user_book", () -> new UserBookItem());
	public static final RegistryObject<Item> USER_BOOK_OPEN = REGISTRY.register("user_book_open", () -> new UserBookOpenItem());
	public static final RegistryObject<Item> USER_BOOK_OPEN_BLOCK = block(LanternofthewoodlandsModBlocks.USER_BOOK_OPEN_BLOCK);
	public static final RegistryObject<Item> SPELL_HEALING_CIRCLE = block(LanternofthewoodlandsModBlocks.SPELL_HEALING_CIRCLE);
	public static final RegistryObject<Item> REJUVENATING_MUSHROOM = block(LanternofthewoodlandsModBlocks.REJUVENATING_MUSHROOM);
	public static final RegistryObject<Item> SPELL_TELEPORT_CIRCLE = block(LanternofthewoodlandsModBlocks.SPELL_TELEPORT_CIRCLE);
	public static final RegistryObject<Item> BOW = REGISTRY.register("bow", () -> new BowItem());
	public static final RegistryObject<Item> BOW_1 = REGISTRY.register("bow_1", () -> new Bow1Item());
	public static final RegistryObject<Item> BOW_2 = REGISTRY.register("bow_2", () -> new Bow2Item());
	public static final RegistryObject<Item> BOW_3 = REGISTRY.register("bow_3", () -> new Bow3Item());
	public static final RegistryObject<Item> BOW_ARROW_SPAWN_EGG = REGISTRY.register("bow_arrow_spawn_egg", () -> new ForgeSpawnEggItem(LanternofthewoodlandsModEntities.BOW_ARROW, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> GET_MANA_CREATIVE = REGISTRY.register("get_mana_creative", () -> new GetManaCreativeItem());
	public static final RegistryObject<Item> LANTERN = block(LanternofthewoodlandsModBlocks.LANTERN);
	public static final RegistryObject<Item> LANTERN_1 = block(LanternofthewoodlandsModBlocks.LANTERN_1);
	public static final RegistryObject<Item> LANTERN_2 = block(LanternofthewoodlandsModBlocks.LANTERN_2);
	public static final RegistryObject<Item> LANTERN_3 = block(LanternofthewoodlandsModBlocks.LANTERN_3);
	public static final RegistryObject<Item> ANCHOR = REGISTRY.register("anchor", () -> new AnchorItem());
	public static final RegistryObject<Item> KNIGHT_SWORD = REGISTRY.register("knight_sword", () -> new KnightSwordItem());
	public static final RegistryObject<Item> FORGOTTEN_SWORD = REGISTRY.register("forgotten_sword", () -> new ForgottenSwordItem());
	public static final RegistryObject<Item> SWORD_KNIGHT = block(LanternofthewoodlandsModBlocks.SWORD_KNIGHT);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
