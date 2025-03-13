package lotw.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

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

public class Spell7keySelectRunProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7keySelectRun!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell7keySelectRun!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell7keySelectRun!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell7keySelectRun!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell7keySelectRun!");
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
			if (LotwModVariables.MapVariables.get(world).spell7_book_number != 0) {
				if (LotwModVariables.MapVariables.get(world).spell7_select == false) {
					LotwModVariables.MapVariables.get(world).spell7_select = (true);
					LotwModVariables.MapVariables.get(world).syncData(world);
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("tag @e[name=LOTW-enchant_book"
										+ (new java.text.DecimalFormat("##.#").format(LotwModVariables.MapVariables.get(world).spell7_book_number))
												.replace(".0", "")
										+ "] add LOTW-enchant_book_choose"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-enchant_center] run tp @e[tag=LOTW-enchant_book_choose] ^ ^0.5 ^0.5 facing entity @p[tag=LOTW-user]");
					}
					LotwModVariables.MapVariables.get(world).spell7_move = LotwModVariables.MapVariables.get(world).spell7_book_number;
					LotwModVariables.MapVariables.get(world).syncData(world);
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-enchant_bookshelf] run playsound minecraft:block.wood.place ambient @a ^0.75 ^ ^ 0.1 0");
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;

						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {

							Spell7setBookTextureProcedure.executeProcedure(Stream
									.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
											new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"lotw:spell_book\",Count:1b},{},{},{}]} run playsound minecraft:item.book.page_turn ambient @a ~ ~ ~ 0.1 0");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"minecraft:book\",Count:1b},{},{},{}]} run playsound minecraft:item.book.page_turn ambient @a ~ ~ ~ 0.1 0");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"minecraft:writable_book\",Count:1b},{},{},{}]} run playsound minecraft:iteexecute at @e[tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"minecraft:writable_book\",Count:1b},{},{},{}]} run playsound minecraft:item.book.page_turn ambient @a ~ ~ ~ 0.1 0m.boage_turn ambient @a ~ ~ ~ 0.1 0");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"minecraft:written_book\",Count:1b},{},{},{}]} run playsound minecraft:item.book.page_turn ambient @a ~ ~ ~ 0.1 0");
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"execute as @e[tag=LOTW-enchant_book_choose] at @s if data entity @s {ArmorItems:[{id:\"minecraft:enchanted_book\",Count:1b},{},{},{}]} run playsound minecraft:item.book.page_turn ambient @a ~ ~ ~ 0.1 0");
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
				} else {
					LotwModVariables.MapVariables.get(world).spell7_select = (false);
					LotwModVariables.MapVariables.get(world).syncData(world);
					if (LotwModVariables.MapVariables.get(world).spell7_generator1_pos == LotwModVariables.MapVariables
							.get(world).spell7_book_number) {
						LotwModVariables.MapVariables.get(world).spell7_generator1_pos = LotwModVariables.MapVariables.get(world).spell7_move;
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else if (LotwModVariables.MapVariables.get(world).spell7_generator1_pos == LotwModVariables.MapVariables
							.get(world).spell7_move) {
						LotwModVariables.MapVariables.get(world).spell7_generator1_pos = LotwModVariables.MapVariables.get(world).spell7_book_number;
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
					if (LotwModVariables.MapVariables.get(world).spell7_generator2_pos == LotwModVariables.MapVariables
							.get(world).spell7_book_number) {
						LotwModVariables.MapVariables.get(world).spell7_generator2_pos = LotwModVariables.MapVariables.get(world).spell7_move;
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else if (LotwModVariables.MapVariables.get(world).spell7_generator2_pos == LotwModVariables.MapVariables
							.get(world).spell7_move) {
						LotwModVariables.MapVariables.get(world).spell7_generator2_pos = LotwModVariables.MapVariables.get(world).spell7_book_number;
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
					if (LotwModVariables.MapVariables.get(world).spell7_generator3_pos == LotwModVariables.MapVariables
							.get(world).spell7_book_number) {
						LotwModVariables.MapVariables.get(world).spell7_generator3_pos = LotwModVariables.MapVariables.get(world).spell7_move;
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else if (LotwModVariables.MapVariables.get(world).spell7_generator3_pos == LotwModVariables.MapVariables
							.get(world).spell7_move) {
						LotwModVariables.MapVariables.get(world).spell7_generator3_pos = LotwModVariables.MapVariables.get(world).spell7_book_number;
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[tag=LOTW-enchant_book_choose] run playsound minecraft:item.book.put ambient @a ~ ~ ~ 1 0.75");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @e[name=LOTW-enchant_bookshelf] run playsound minecraft:block.wood.place ambient @a ^0.75 ^ ^ 0.1 0");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[name=LOTW-enchant_book"
										+ (new java.text.DecimalFormat("##.#").format(LotwModVariables.MapVariables.get(world).spell7_book_number))
												.replace(".0", "")
										+ "] at @s run data merge entity @s {CustomName:'{\"text\":\"LOTW-enchant_book"
										+ (new java.text.DecimalFormat("##.#").format(LotwModVariables.MapVariables.get(world).spell7_move))
												.replace(".0", "")
										+ "\"}'}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[tag=LOTW-enchant_book_choose] at @s run data merge entity @s {CustomName:'{\"text\":\"LOTW-enchant_book"
										+ ""
										+ (new java.text.DecimalFormat("##.#").format(LotwModVariables.MapVariables.get(world).spell7_book_number))
												.replace(".0", "")
										+ "\"}'}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"tag @e[tag=LOTW-enchant_book] remove LOTW-enchant_book_choose");
					}
					LotwModVariables.MapVariables.get(world).spell7_move = 0;
					LotwModVariables.MapVariables.get(world).syncData(world);
					Spell7setBookTextureProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}
		}
	}
}
