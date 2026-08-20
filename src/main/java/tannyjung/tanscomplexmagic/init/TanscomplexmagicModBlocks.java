/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.tanscomplexmagic.init;

import tannyjung.tanscomplexmagic.block.*;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

public class TanscomplexmagicModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(TanscomplexmagicMod.MODID);
	public static final DeferredBlock<Block> TARGET_ARROW;
	public static final DeferredBlock<Block> SPELL_HEALING_CIRCLE;
	public static final DeferredBlock<Block> REJUVENATING_MUSHROOM;
	public static final DeferredBlock<Block> SPELL_TELEPORT_CIRCLE;
	public static final DeferredBlock<Block> LANTERN;
	public static final DeferredBlock<Block> LANTERN_1;
	public static final DeferredBlock<Block> LANTERN_2;
	public static final DeferredBlock<Block> LANTERN_3;
	public static final DeferredBlock<Block> SWORD_KNIGHT;
	static {
		TARGET_ARROW = REGISTRY.register("target_arrow", TargetArrowBlock::new);
		SPELL_HEALING_CIRCLE = REGISTRY.register("spell_healing_circle", SpellHealingCircleBlock::new);
		REJUVENATING_MUSHROOM = REGISTRY.register("rejuvenating_mushroom", RejuvenatingMushroomBlock::new);
		SPELL_TELEPORT_CIRCLE = REGISTRY.register("spell_teleport_circle", SpellTeleportCircleBlock::new);
		LANTERN = REGISTRY.register("lantern", LanternBlock::new);
		LANTERN_1 = REGISTRY.register("lantern_1", Lantern1Block::new);
		LANTERN_2 = REGISTRY.register("lantern_2", Lantern2Block::new);
		LANTERN_3 = REGISTRY.register("lantern_3", Lantern3Block::new);
		SWORD_KNIGHT = REGISTRY.register("sword_knight", SwordKnightBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}