package lotw.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.Minecraft;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell7repeatFastProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7repeatFast!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell7repeatFast!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell7repeatFast!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell7repeatFast!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		String bookshelf_number_text = "";
		double choose = 0;
		double book_number = 0;
		double bookshelf_number = 0;
		double book_number_follow = 0;
		if (LotwModVariables.MapVariables.get(world).spell7_start == true) {
			if (!("").equals("Select")) {
				if (true) {
					bookshelf_number = 1;
					for (int index0 = 0; index0 < (int) (2); index0++) {
						if (bookshelf_number == 1) {
							bookshelf_number_text = "";
						} else {
							bookshelf_number_text = ((new java.text.DecimalFormat("##.#").format(bookshelf_number)).replace(".0", ""));
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute as @e[name=LOTW-enchant_book"
											+ (new java.text.DecimalFormat("##.#")
													.format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(".0", "")
											+ ",tag=!LOTW-enchant_book_choose] at @s if entity @e[name=LOTW-enchant_bookshelf" + bookshelf_number_text
											+ ",distance=..1] if data entity @s {ArmorItems:[{},{},{},{id:\"lotw:invisible_block\",Count:1b}]} run particle minecraft:dust 0.5 0.5 0.5 0.075 ~ ~0.7 ~ 0 0 0 0 1 force @p[tag=LOTW-user]"));
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#")
														.format(LotwModVariables.MapVariables.get(world).spell7_generator1_pos)).replace(".0", "")
												+ ",tag=!LOTW-enchant_book_choose] at @s if entity @e[name=LOTW-enchant_bookshelf"
												+ bookshelf_number_text
												+ ",distance=..1] if data entity @s {ArmorItems:[{},{},{},{id:\"lotw:invisible_block\",Count:1b}]} run particle minecraft:dust 0.75 0.25 0.25 0.075 ~ ~0.75 ~ 0 0 0 0 1 force @p[tag=LOTW-user]"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#")
														.format(LotwModVariables.MapVariables.get(world).spell7_generator2_pos)).replace(".0", "")
												+ ",tag=!LOTW-enchant_book_choose] at @s if entity @e[name=LOTW-enchant_bookshelf"
												+ bookshelf_number_text
												+ ",distance=..1] if data entity @s {ArmorItems:[{},{},{},{id:\"lotw:invisible_block\",Count:1b}]} run particle minecraft:dust 0.75 0.25 0.25 0.075 ~ ~0.75 ~ 0 0 0 0 1 force @p[tag=LOTW-user]"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#")
														.format(LotwModVariables.MapVariables.get(world).spell7_generator3_pos)).replace(".0", "")
												+ ",tag=!LOTW-enchant_book_choose] at @s if entity @e[name=LOTW-enchant_bookshelf"
												+ bookshelf_number_text
												+ ",distance=..1] if data entity @s {ArmorItems:[{},{},{},{id:\"lotw:invisible_block\",Count:1b}]} run particle minecraft:dust 0.75 0.25 0.25 0.075 ~ ~0.75 ~ 0 0 0 0 1 force @p[tag=LOTW-user]"));
							}
						}
						bookshelf_number = (bookshelf_number + 1);
					}
				}
			}
			if (!("").equals("Fly")) {
				if (true) {
					if (LotwModVariables.MapVariables.get(world).spell7_fly_updown < 60) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book,tag=LOTW-enchant_book_choose] at @s run tp @s ~ ~0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book,tag=!LOTW-enchant_book_choose] at @s run tp @s ~ ~-0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-enchant_remove] at @s run tp @s ~ ~0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-enchant_bookshelf] at @s run tp @s ~ ~-0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-enchant_bookshelf2] at @s run tp @s ~ ~-0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-enchant_bookshelf3] at @s run tp @s ~ ~-0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-enchant_bookshelf4] at @s run tp @s ~ ~-0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_use] at @s run tp @s ~ ~0.001 ~");
						}
					} else if (LotwModVariables.MapVariables.get(world).spell7_fly_updown > 60) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book,tag=LOTW-enchant_book_choose] at @s run tp @s ~ ~-0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[tag=LOTW-enchant_book,tag=!LOTW-enchant_book_choose] at @s run tp @s ~ ~0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-enchant_remove] at @s run tp @s ~ ~-0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-enchant_bookshelf] at @s run tp @s ~ ~0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-enchant_bookshelf2] at @s run tp @s ~ ~0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-enchant_bookshelf3] at @s run tp @s ~ ~0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-enchant_bookshelf4] at @s run tp @s ~ ~0.001 ~");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute as @e[name=LOTW-spell_book_use] at @s run tp @s ~ ~-0.001 ~");
						}
					}
					if (LotwModVariables.MapVariables.get(world).spell7_fly_updown < 120) {
						LotwModVariables.MapVariables.get(world).spell7_fly_updown = (LotwModVariables.MapVariables.get(world).spell7_fly_updown + 1);
						LotwModVariables.MapVariables.get(world).syncData(world);
					} else {
						LotwModVariables.MapVariables.get(world).spell7_fly_updown = 0;
						LotwModVariables.MapVariables.get(world).syncData(world);
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[name=LOTW-enchant_remove] at @s run tp @s ~ ~ ~ ~-1 ~");
					}
				}
			}
			if (!("").equals("Follow")) {
				if (LotwModVariables.MapVariables.get(world).spell7_book_number != 0) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute unless entity @e[name=LOTW-placed_lantern] at @e[name=LOTW-enchant_center] if entity @p[tag=LOTW-user,distance=0.01..] run tp @e[name=LOTW-enchant_remove] ^ ^0.5 ^-2.5");
					}
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute unless entity @e[name=LOTW-placed_lantern] at @e[name=LOTW-enchant_center] if entity @p[tag=LOTW-user,distance=0.01..] run tp @e[name=LOTW-enchant_bookshelf] ^-0.75 ^1.25 ^-1.5 facing ^ ^1.25 ^100");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute unless entity @e[name=LOTW-placed_lantern] at @e[name=LOTW-enchant_center] if entity @p[tag=LOTW-user,distance=0.01..] run tp @e[name=LOTW-enchant_bookshelf2] ^0.75 ^1.25 ^-1.5 facing ^ ^1.25 ^100");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute unless entity @e[name=LOTW-placed_lantern] at @e[name=LOTW-enchant_center] if entity @p[tag=LOTW-user,distance=0.01..] run tp @e[name=LOTW-enchant_bookshelf3] ^-0.75 ^0.5 ^-1.5 facing ^ ^0.5 ^100");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute unless entity @e[name=LOTW-placed_lantern] at @e[name=LOTW-enchant_center] if entity @p[tag=LOTW-user,distance=0.01..] run tp @e[name=LOTW-enchant_bookshelf4] ^0.75 ^0.5 ^-1.5 facing ^ ^0.5 ^100");
						}
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @p[tag=LOTW-user] run tp @e[name=LOTW-enchant_center] ~ ~ ~ ~ 0");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-enchant_center] run tp @e[tag=LOTW-spell_book_show_name] ^ ^ ^2");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[name=LOTW-enchant_center] run tp @e[tag=LOTW-spell_book_show_id] ^ ^ ^2");
				}
				book_number = 1;
				bookshelf_number = 1;
				for (int index1 = 0; index1 < (int) (4); index1++) {
					if (bookshelf_number == 1) {
						bookshelf_number_text = "";
					} else {
						bookshelf_number_text = ((new java.text.DecimalFormat("##.#").format(bookshelf_number)).replace(".0", ""));
					}
					for (int index2 = 0; index2 < (int) (10); index2++) {
						if (LotwModVariables.MapVariables.get(world).spell7_book_number == book_number
								|| LotwModVariables.MapVariables.get(world).spell7_use_double_number == book_number) {
							choose = 0.05;
						} else {
							choose = 0;
						}
						if (book_number / 10 - Math.floor(book_number / 10) > 0) {
							book_number_follow = ((book_number / 10 - Math.floor(book_number / 10)) * 10);
						} else {
							book_number_follow = 10;
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute at @e[name=LOTW-enchant_bookshelf" + bookshelf_number_text + "] run tp @e[name=LOTW-enchant_book"
											+ (new java.text.DecimalFormat("##.#").format(book_number)).replace(".0", "")
											+ ",tag=!LOTW-enchant_book_choose,tag=!LOTW-enchant_book_choose2] ^"
											+ (-0.315 + 0.07 * (book_number_follow - 1)) + " ^0.035 ^" + choose + " facing ^"
											+ (-0.315 + 0.07 * (book_number_follow - 1)) + " ^0.035 ^-100"));
						}
						book_number = (book_number + 1);
					}
					bookshelf_number = (bookshelf_number + 1);
				}
			}
			if (!(LotwModVariables.MapVariables.get(world).spell7_test_use).equals("")
					&& !(LotwModVariables.MapVariables.get(world).spell7_use).equals("None")) {
				Spell7useRepeatProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute unless entity @e[tag=LOTW-spell_book_show_name,nbt={CustomName:'{\"text\":\"\"}'}] run title @p[tag=LOTW-user] actionbar [\"\",{\"text\":\"\"}]");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute unless entity @e[tag=LOTW-spell_book_show_name,nbt={CustomName:'{\"text\":\"\"}'}] run data merge entity @e[tag=LOTW-spell_book_show_name,limit=1] {CustomName:'{\"text\":\"\"}'}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute unless entity @e[tag=LOTW-spell_book_show_id,nbt={CustomName:'{\"text\":\"\"}'}] run data merge entity @e[tag=LOTW-spell_book_show_id,limit=1] {CustomName:'{\"text\":\"\"}'}");
				}
				if (LotwModVariables.MapVariables.get(world).spell7_book_number != 0) {
					if (true) {
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute if entity @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#")
														.format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(".0", "")
												+ ",nbt={ArmorItems:[{id:\"" + "minecraft:book"
												+ "\",Count:1b},{},{},{}]}] run data modify entity @e[limit=1,tag=LOTW-spell_book_show_" + "name"
												+ "] CustomName set value " + "'{\"text\":\"Book\"}'"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#")
														.format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(".0", "")
												+ ",nbt={ArmorItems:[{id:\"" + "minecraft:book"
												+ "\",Count:1b},{},{},{}]}] at @s run data modify entity @e[tag=LOTW-spell_book_show_" + "id"
												+ ",limit=1] CustomName set from entity @s ArmorItems[0]." + "tag.display.Name"));
							}
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute if entity @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#")
														.format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(".0", "")
												+ ",nbt={ArmorItems:[{id:\"" + "minecraft:writable_book"
												+ "\",Count:1b},{},{},{}]}] run data modify entity @e[limit=1,tag=LOTW-spell_book_show_" + "name"
												+ "] CustomName set value " + "'{\"text\":\"Writable Book\"}'"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#")
														.format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(".0", "")
												+ ",nbt={ArmorItems:[{id:\"" + "minecraft:writable_book"
												+ "\",Count:1b},{},{},{}]}] at @s run data modify entity @e[tag=LOTW-spell_book_show_" + "id"
												+ ",limit=1] CustomName set from entity @s ArmorItems[0]." + "tag.display.Name"));
							}
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute if entity @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#")
														.format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(".0", "")
												+ ",nbt={ArmorItems:[{id:\"" + "minecraft:written_book"
												+ "\",Count:1b},{},{},{}]}] run data modify entity @e[limit=1,tag=LOTW-spell_book_show_" + "name"
												+ "] CustomName set value " + "'{\"text\":\"Written Book\"}'"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#")
														.format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(".0", "")
												+ ",nbt={ArmorItems:[{id:\"" + "minecraft:written_book"
												+ "\",Count:1b},{},{},{}]}] at @s run data modify entity @e[tag=LOTW-spell_book_show_" + "id"
												+ ",limit=1] CustomName set from entity @s ArmorItems[0]." + "tag.display.Name"));
							}
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute if entity @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#")
														.format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(".0", "")
												+ ",nbt={ArmorItems:[{id:\"" + "minecraft:enchanted_book"
												+ "\",Count:1b},{},{},{}]}] run data modify entity @e[limit=1,tag=LOTW-spell_book_show_" + "name"
												+ "] CustomName set value " + "'{\"text\":\"Enchanted Book\"}'"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#")
														.format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(".0", "")
												+ ",nbt={ArmorItems:[{id:\"" + "minecraft:enchanted_book"
												+ "\",Count:1b},{},{},{}]}] at @s run data modify entity @e[tag=LOTW-spell_book_show_" + "id"
												+ ",limit=1] CustomName set from entity @s ArmorItems[0]." + "tag.display.Name"));
							}
						}
						if (true) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute if entity @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#")
														.format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(".0", "")
												+ ",nbt={ArmorItems:[{id:\"" + "lotw:spell_book"
												+ "\",Count:1b},{},{},{}]}] run data modify entity @e[limit=1,tag=LOTW-spell_book_show_" + "name"
												+ "] CustomName set value " + "'{\"text\":\"Spell Book\"}'"));
							}
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										("execute as @e[name=LOTW-enchant_book"
												+ (new java.text.DecimalFormat("##.#")
														.format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(".0", "")
												+ ",nbt={ArmorItems:[{id:\"" + "lotw:spell_book"
												+ "\",Count:1b},{},{},{}]}] at @s run data modify entity @e[tag=LOTW-spell_book_show_" + "id"
												+ ",limit=1] CustomName set from entity @s ArmorItems[0]." + "tag.display.Lore[]"));
							}
						}
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute if entity @e[tag=LOTW-spell_book_show_id,nbt={CustomName:'{\"text\":\"\"}'}] run title @p[tag=LOTW-user] actionbar [\"\",{\"text\":\"\",\"color\":\"dark_purple\",\"extra\":[{\"selector\":\"@e[tag=LOTW-spell_book_show_name]\"}]}]");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute unless entity @e[tag=LOTW-spell_book_show_id,nbt={CustomName:'{\"text\":\"\"}'}] run title @p[tag=LOTW-user] actionbar [\"\",{\"text\":\"\",\"color\":\"dark_purple\",\"extra\":[{\"selector\":\"@e[tag=LOTW-spell_book_show_name]\"}]},{\"text\":\" : \",\"color\":\"gray\"},{\"text\":\"\",\"color\":\"light_purple\",\"extra\":[{\"selector\":\"@e[tag=LOTW-spell_book_show_id]\"}]}]");
					}
				}
			}
			if ((world.isRemote()
					? Minecraft.getInstance().getConnection().getPlayerInfoMap().size()
					: ServerLifecycleHooks.getCurrentServer().getCurrentPlayerCount()) > 0) {
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

						Spell7repeatFastProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 1);
			}
		}
	}
}
