package lotw.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell7buttonGenerateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7buttonGenerate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell7buttonGenerate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell7buttonGenerate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell7buttonGenerate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell7buttonGenerate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		String type = "";
		type = (LotwModVariables.MapVariables.get(world).spell7_type + " : " + LotwModVariables.MapVariables.get(world).spell7_book_id);
		LotwModVariables.MapVariables.get(world).spell7_can_generate = (false);
		LotwModVariables.MapVariables.get(world).syncData(world);
		if ((LotwModVariables.MapVariables.get(world).spell7_type).equals("Generate Spell Book")
				|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Generate Enchanted Book")
				|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Separation Enchantment")
				|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Demotion Enchantment")
				|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Disenchantment")) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute as @e[name=LOTW-enchant_book"
								+ (new java.text.DecimalFormat("##.#").format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(
										".0", "")
								+ "] at @s " + "unless data entity @s {ArmorItems:[{id:\"lotw:spell_book\",Count:1b},{},{},{}]} "
								+ "unless data entity @s {ArmorItems:[{id:\"minecraft:book\",Count:1b},{},{},{}]} "
								+ "unless data entity @s {ArmorItems:[{id:\"minecraft:writable_book\",Count:1b},{},{},{}]} "
								+ "unless data entity @s {ArmorItems:[{id:\"minecraft:written_book\",Count:1b},{},{},{}]} "
								+ "unless data entity @s {ArmorItems:[{id:\"minecraft:enchanted_book\",Count:1b},{},{},{}]} "
								+ "run LOTW-spell7_cancel_book_pos"));
			}
		} else {
			LotwModVariables.MapVariables.get(world).spell7_can_generate = (true);
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
		if (LotwModVariables.MapVariables.get(world).spell7_can_generate == true && LotwModVariables.MapVariables.get(world).spell7_book_number != 0
				&& (((LotwModVariables.MapVariables.get(world).spell7_type).equals("Generate Spell Book")
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Generate Enchanted Book")
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Separation Enchantment")
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Demotion Enchantment")
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Disenchantment"))
						&& LotwModVariables.MapVariables.get(world).spell7_book_number != LotwModVariables.MapVariables
								.get(world).spell7_generator1_pos
						&& LotwModVariables.MapVariables.get(world).spell7_book_number != LotwModVariables.MapVariables
								.get(world).spell7_generator2_pos
						&& LotwModVariables.MapVariables.get(world).spell7_book_number != LotwModVariables.MapVariables
								.get(world).spell7_generator3_pos
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Elevation Enchantment")
						|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Cheapening"))
				&& ((LotwModVariables.MapVariables.get(world).spell7_generator1_id).equals("")
						|| (LotwModVariables.MapVariables.get(world).spell7_generator2_id).equals("")
						|| (LotwModVariables.MapVariables.get(world).spell7_generator3_id).equals(""))) {
			if (LotwModVariables.MapVariables.get(world).mana >= LotwModVariables.MapVariables.get(world).spell7_book_cost) {
				LotwModVariables.MapVariables.get(world).mana = (LotwModVariables.MapVariables.get(world).mana
						- LotwModVariables.MapVariables.get(world).spell7_book_cost);
				LotwModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"playsound minecraft:block.enchantment_table.use player @a[distance=..100] ~ ~ ~ 2 0 0.025");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-placed_lantern] run particle minecraft:firework ~ ~ ~ 1 1 1 0 5 force");
				}
				LanternGroundStateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if ((LotwModVariables.MapVariables.get(world).spell7_generator1_id).equals("")) {
					LotwModVariables.MapVariables.get(world).spell7_generator1_id = type;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_generator1_time = LotwModVariables.MapVariables.get(world).spell7_book_time;
					LotwModVariables.MapVariables.get(world).syncData(world);
					if (!((LotwModVariables.MapVariables.get(world).spell7_type).equals("Elevation Enchantment")
							|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Cheapening"))) {
						LotwModVariables.MapVariables.get(world).spell7_generator1_pos = LotwModVariables.MapVariables.get(world).spell7_book_number;
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				} else if ((LotwModVariables.MapVariables.get(world).spell7_generator2_id).equals("")) {
					LotwModVariables.MapVariables.get(world).spell7_generator2_id = type;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_generator2_time = LotwModVariables.MapVariables.get(world).spell7_book_time;
					LotwModVariables.MapVariables.get(world).syncData(world);
					if (!((LotwModVariables.MapVariables.get(world).spell7_type).equals("Elevation Enchantment")
							|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Cheapening"))) {
						LotwModVariables.MapVariables.get(world).spell7_generator2_pos = LotwModVariables.MapVariables.get(world).spell7_book_number;
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				} else if ((LotwModVariables.MapVariables.get(world).spell7_generator3_id).equals("")) {
					LotwModVariables.MapVariables.get(world).spell7_generator3_id = type;
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).spell7_generator3_time = LotwModVariables.MapVariables.get(world).spell7_book_time;
					LotwModVariables.MapVariables.get(world).syncData(world);
					if (!((LotwModVariables.MapVariables.get(world).spell7_type).equals("Elevation Enchantment")
							|| (LotwModVariables.MapVariables.get(world).spell7_type).equals("Cheapening"))) {
						LotwModVariables.MapVariables.get(world).spell7_generator3_pos = LotwModVariables.MapVariables.get(world).spell7_book_number;
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
				}
			}
		} else {
			if ((LotwModVariables.MapVariables.get(world).spell7_generator1_id).equals("")
					|| (LotwModVariables.MapVariables.get(world).spell7_generator2_id).equals("")
					|| (LotwModVariables.MapVariables.get(world).spell7_generator3_id).equals("")) {
				Spell7keyNextRunProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
								new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}
}
