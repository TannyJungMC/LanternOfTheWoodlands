
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.lanternofthewoodlands.init;

import tannyjung.lanternofthewoodlands.block.UserBookOpenBlockBlock;
import tannyjung.lanternofthewoodlands.block.TargetArrowBlock;
import tannyjung.lanternofthewoodlands.block.SwordKnightBlock;
import tannyjung.lanternofthewoodlands.block.SpellTeleportCircleBlock;
import tannyjung.lanternofthewoodlands.block.SpellHealingCircleBlock;
import tannyjung.lanternofthewoodlands.block.RejuvenatingMushroomBlock;
import tannyjung.lanternofthewoodlands.block.LanternBlock;
import tannyjung.lanternofthewoodlands.block.Lantern3Block;
import tannyjung.lanternofthewoodlands.block.Lantern2Block;
import tannyjung.lanternofthewoodlands.block.Lantern1Block;
import tannyjung.lanternofthewoodlands.LanternofthewoodlandsMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class LanternofthewoodlandsModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, LanternofthewoodlandsMod.MODID);
	public static final RegistryObject<Block> TARGET_ARROW = REGISTRY.register("target_arrow", () -> new TargetArrowBlock());
	public static final RegistryObject<Block> USER_BOOK_OPEN_BLOCK = REGISTRY.register("user_book_open_block", () -> new UserBookOpenBlockBlock());
	public static final RegistryObject<Block> SPELL_HEALING_CIRCLE = REGISTRY.register("spell_healing_circle", () -> new SpellHealingCircleBlock());
	public static final RegistryObject<Block> REJUVENATING_MUSHROOM = REGISTRY.register("rejuvenating_mushroom", () -> new RejuvenatingMushroomBlock());
	public static final RegistryObject<Block> SPELL_TELEPORT_CIRCLE = REGISTRY.register("spell_teleport_circle", () -> new SpellTeleportCircleBlock());
	public static final RegistryObject<Block> LANTERN = REGISTRY.register("lantern", () -> new LanternBlock());
	public static final RegistryObject<Block> LANTERN_1 = REGISTRY.register("lantern_1", () -> new Lantern1Block());
	public static final RegistryObject<Block> LANTERN_2 = REGISTRY.register("lantern_2", () -> new Lantern2Block());
	public static final RegistryObject<Block> LANTERN_3 = REGISTRY.register("lantern_3", () -> new Lantern3Block());
	public static final RegistryObject<Block> SWORD_KNIGHT = REGISTRY.register("sword_knight", () -> new SwordKnightBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
