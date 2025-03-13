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

public class Spell7keyNextRunProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7keyNextRun!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell7keyNextRun!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell7keyNextRun!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell7keyNextRun!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell7keyNextRun!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");

		UserOnlyTestProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		if (LotwModVariables.MapVariables.get(world).user_only == true && LotwModVariables.MapVariables.get(world).spell7_start == true) {
			LotwModVariables.MapVariables.get(world).spell7_book_number = (LotwModVariables.MapVariables.get(world).spell7_book_number + 1);
			LotwModVariables.MapVariables.get(world).syncData(world);
			if (LotwModVariables.MapVariables.get(world).spell7_book_number > 40) {
				LotwModVariables.MapVariables.get(world).spell7_book_number = 1;
				LotwModVariables.MapVariables.get(world).syncData(world);
			}
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[name=LOTW-enchant_book"
									+ (new java.text.DecimalFormat("##.#").format(LotwModVariables.MapVariables.get(world).spell7_book_number))
											.replace(".0", "")
									+ "] at @s if data entity @s {ArmorItems:[{id:\"" + "lotw:spell_book"
									+ "\",Count:1b},{},{},{}]} run playsound minecraft:block.wool.break ambient @a ~ ~ ~ 0.1 0"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[name=LOTW-enchant_book"
									+ (new java.text.DecimalFormat("##.#").format(LotwModVariables.MapVariables.get(world).spell7_book_number))
											.replace(".0", "")
									+ "] at @s if data entity @s {ArmorItems:[{id:\"" + "minecraft:book"
									+ "\",Count:1b},{},{},{}]} run playsound minecraft:block.wool.break ambient @a ~ ~ ~ 0.1 0"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[name=LOTW-enchant_book"
									+ (new java.text.DecimalFormat("##.#").format(LotwModVariables.MapVariables.get(world).spell7_book_number))
											.replace(".0", "")
									+ "] at @s if data entity @s {ArmorItems:[{id:\"" + "minecraft:writable_book"
									+ "\",Count:1b},{},{},{}]} run playsound minecraft:block.wool.break ambient @a ~ ~ ~ 0.1 0"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[name=LOTW-enchant_book"
									+ (new java.text.DecimalFormat("##.#").format(LotwModVariables.MapVariables.get(world).spell7_book_number))
											.replace(".0", "")
									+ "] at @s if data entity @s {ArmorItems:[{id:\"" + "minecraft:written_book"
									+ "\",Count:1b},{},{},{}]} run playsound minecraft:block.wool.break ambient @a ~ ~ ~ 0.1 0"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[name=LOTW-enchant_book"
									+ (new java.text.DecimalFormat("##.#").format(LotwModVariables.MapVariables.get(world).spell7_book_number))
											.replace(".0", "")
									+ "] at @s if data entity @s {ArmorItems:[{id:\"" + "minecraft:enchanted_book"
									+ "\",Count:1b},{},{},{}]} run playsound minecraft:block.wool.break ambient @a ~ ~ ~ 0.1 0"));
				}
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute as @e[name=LOTW-enchant_book"
								+ (new java.text.DecimalFormat("##.#").format(LotwModVariables.MapVariables.get(world).spell7_book_number))
										.replace(".0", "")
								+ "] at @s "
								+ ("unless data entity @s {ArmorItems:[{id:\"lotw:spell_book\",Count:1b},{},{},{}]} " + ""
										+ "unless data entity @s {ArmorItems:[{id:\"minecraft:book\",Count:1b},{},{},{}]} "
										+ "unless data entity @s {ArmorItems:[{id:\"minecraft:writable_book\",Count:1b},{},{},{}]} "
										+ "unless data entity @s {ArmorItems:[{id:\"minecraft:written_book\",Count:1b},{},{},{}]} "
										+ "unless data entity @s {ArmorItems:[{id:\"minecraft:enchanted_book\",Count:1b},{},{},{}]} ")
								+ "run playsound minecraft:block.note_block.hat ambient @p[tag=LOTW-user] ~ ~ ~ 0.1 2"));
			}
		}
	}
}
