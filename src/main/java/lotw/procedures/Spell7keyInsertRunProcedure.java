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

public class Spell7keyInsertRunProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7keyInsertRun!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell7keyInsertRun!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell7keyInsertRun!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell7keyInsertRun!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell7keyInsertRun!");
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
			if (LotwModVariables.MapVariables.get(world).spell7_select == true
					&& LotwModVariables.MapVariables.get(world).spell7_generator1_pos != LotwModVariables.MapVariables.get(world).spell7_move
					&& LotwModVariables.MapVariables.get(world).spell7_generator2_pos != LotwModVariables.MapVariables.get(world).spell7_move
					&& LotwModVariables.MapVariables.get(world).spell7_generator3_pos != LotwModVariables.MapVariables.get(world).spell7_move) {
				if (true) {
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"" + "lotw:spell_book"
											+ "\",Count:1b},{},{},{}]} run summon item ~ ~0.5 ~ {Item:{id:\"" + "lotw:spell_book" + "\",Count:1b}}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"" + "minecraft:book"
											+ "\",Count:1b},{},{},{}]} run summon item ~ ~0.5 ~ {Item:{id:\"" + "minecraft:book" + "\",Count:1b}}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\""
											+ "minecraft:writable_book" + "\",Count:1b},{},{},{}]} run summon item ~ ~0.5 ~ {Item:{id:\""
											+ "minecraft:writable_book" + "\",Count:1b}}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\""
											+ "minecraft:written_book" + "\",Count:1b},{},{},{}]} run summon item ~ ~0.5 ~ {Item:{id:\""
											+ "minecraft:written_book" + "\",Count:1b}}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\""
											+ "minecraft:enchanted_book" + "\",Count:1b},{},{},{}]} run summon item ~ ~0.5 ~ {Item:{id:\""
											+ "minecraft:enchanted_book" + "\",Count:1b}}"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book_choose] at @s positioned ~ ~0.5 ~ run data modify entity @e[type=item,distance=..0.01,limit=1] Item set from entity @s ArmorItems[0]");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book_choose] at @s run data merge entity @s {ArmorItems:[{},{},{},{id:\"lotw:invisible_block\",Count:1b}]}");
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[tag=LOTW-enchant_book_choose] at @s "
										+ ("unless data entity @s {ArmorItems:[{id:\"" + "lotw:spell_book" + "\",Count:1b},{},{},{}]} ")
										+ ("unless data entity @s {ArmorItems:[{id:\"" + "minecraft:book" + "\",Count:1b},{},{},{}]} ")
										+ ("unless data entity @s {ArmorItems:[{id:\"" + "minecraft:writable_book" + "\",Count:1b},{},{},{}]} ")
										+ ("unless data entity @s {ArmorItems:[{id:\"" + "minecraft:written_book" + "\",Count:1b},{},{},{}]} ")
										+ ("unless data entity @s {ArmorItems:[{id:\"" + "minecraft:enchanted_book" + "\",Count:1b},{},{},{}]} ")
										+ "run data modify entity @s ArmorItems[0] set from entity @p[tag=LOTW-user] SelectedItem"));
					}
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @p[tag=LOTW-user] at @s if data entity @s {SelectedItem:{id:\"" + "lotw:spell_book"
											+ "\",Count:1b}} run replaceitem entity @s weapon.mainhand air"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @p[tag=LOTW-user] at @s if data entity @s {SelectedItem:{id:\"" + "minecraft:book"
											+ "\",Count:1b}} run replaceitem entity @s weapon.mainhand air"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @p[tag=LOTW-user] at @s if data entity @s {SelectedItem:{id:\"" + "minecraft:writable_book"
											+ "\",Count:1b}} run replaceitem entity @s weapon.mainhand air"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @p[tag=LOTW-user] at @s if data entity @s {SelectedItem:{id:\"" + "minecraft:written_book"
											+ "\",Count:1b}} run replaceitem entity @s weapon.mainhand air"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @p[tag=LOTW-user] at @s if data entity @s {SelectedItem:{id:\"" + "minecraft:enchanted_book"
											+ "\",Count:1b}} run replaceitem entity @s weapon.mainhand air"));
						}
					}
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @p[tag=LOTW-user] at @s if data entity @s {SelectedItem:{id:\"" + "lotw:spell_book"
											+ "\",Count:1b}} run item replace entity @s weapon.mainhand with air"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @p[tag=LOTW-user] at @s if data entity @s {SelectedItem:{id:\"" + "minecraft:book"
											+ "\",Count:1b}} run item replace entity @s weapon.mainhand with air"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @p[tag=LOTW-user] at @s if data entity @s {SelectedItem:{id:\"" + "minecraft:writable_book"
											+ "\",Count:1b}} run item replace entity @s weapon.mainhand with air"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @p[tag=LOTW-user] at @s if data entity @s {SelectedItem:{id:\"" + "minecraft:written_book"
											+ "\",Count:1b}} run item replace entity @s weapon.mainhand with air"));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @p[tag=LOTW-user] at @s if data entity @s {SelectedItem:{id:\"" + "minecraft:enchanted_book"
											+ "\",Count:1b}} run item replace entity @s weapon.mainhand with air"));
						}
					}
				}
				Spell7setBookTextureProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[tag=LOTW-enchant_book_choose] run playsound minecraft:entity.item_frame.break ambient @a ~ ~ ~ 0.1 0");
				}
			}
		}
	}
}
