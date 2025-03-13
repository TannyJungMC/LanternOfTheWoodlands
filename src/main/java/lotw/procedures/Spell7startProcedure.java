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
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell7startProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7start!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell7start!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell7start!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell7start!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double book_count = 0;

		Spell7clearProcedure
				.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager()
					.handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"kill @e[tag=LOTW-enchant]");
		}
		if (LotwModVariables.MapVariables.get(world).spell7_start == false) {
			LotwModVariables.MapVariables.get(world).spell7_start = (true);
			LotwModVariables.MapVariables.get(world).syncData(world);
			LotwModVariables.MapVariables.get(world).spell7_type = "Generate Spell Book";
			LotwModVariables.MapVariables.get(world).syncData(world);
			LotwModVariables.MapVariables.get(world).spell7_use = "None";
			LotwModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"scoreboard objectives add LOTW-enchant dummy");
			}
			Spell7repeatFastProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

			Spell7buttonBookIDresetProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
		if (LotwModVariables.MapVariables.get(world).spell7_start == true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute unless entity @e[name=LOTW-enchant_center] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-enchant_center\"}',NoGravity:1b,Marker:1b,Invisible:1b}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute unless entity @e[name=LOTW-enchant_remove] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-enchant_remove\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{},{},{},{id:\"lotw:invisible_block\",Count:1b}],Small:1b}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute unless entity @e[tag=LOTW-spell_book_show_name] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book_show_name\"],CustomName:'{\"text\":\"\"}',NoGravity:1b,Marker:1b,Invisible:1b}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute unless entity @e[tag=LOTW-spell_book_show_id] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-spell_book_show_id\"],CustomName:'{\"text\":\"\"}',NoGravity:1b,Marker:1b,Invisible:1b}");
			}
			if (true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute unless entity @e[name=LOTW-enchant_bookshelf] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-enchant_bookshelf\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{},{},{},{id:\"lotw:bookshelf_3\",Count:1b}],Small:1b}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute unless entity @e[name=LOTW-enchant_bookshelf2] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-enchant_bookshelf2\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{},{},{},{id:\"lotw:bookshelf_2\",Count:1b}],Small:1b}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute unless entity @e[name=LOTW-enchant_bookshelf3] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-enchant_bookshelf3\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{},{},{},{id:\"lotw:bookshelf\",Count:1b}],Small:1b}");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute unless entity @e[name=LOTW-enchant_bookshelf4] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\"],CustomName:'{\"text\":\"LOTW-enchant_bookshelf4\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{},{},{},{id:\"lotw:bookshelf\",Count:1b}],Small:1b}");
				}
			}
			book_count = 1;
			for (int index0 = 0; index0 < (int) (40); index0++) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute unless entity @e[name=LOTW-enchant_book"
									+ (new java.text.DecimalFormat("##.#").format(book_count)).replace(".0", "")
									+ "] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\",\"LOTW-enchant\",\"LOTW-enchant_book\"],CustomName:'{\"text\":\"LOTW-enchant_book"
									+ (new java.text.DecimalFormat("##.#").format(book_count)).replace(".0", "")
									+ "\"}',NoGravity:1b,Marker:1b,Invisible:1b,ArmorItems:[{},{},{},{id:\"lotw:invisible_block\",Count:1b}],Pose:{Head:[0f,0f,0f]},Small:1b}"));
				}
				book_count = (book_count + 1);
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
					if (true) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-enchant_center] run tp @e[name=LOTW-enchant_remove] ^ ^0.5 ^-2.5");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-enchant_center] run tp @e[name=LOTW-enchant_bookshelf] ^-0.75 ^1.25 ^-1.5 facing ^ ^1.25 ^100");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-enchant_center] run tp @e[name=LOTW-enchant_bookshelf2] ^0.75 ^1.25 ^-1.5 facing ^ ^1.25 ^100");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-enchant_center] run tp @e[name=LOTW-enchant_bookshelf3] ^-0.75 ^0.5 ^-1.5 facing ^ ^0.5 ^100");
						}
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									"execute at @e[name=LOTW-enchant_center] run tp @e[name=LOTW-enchant_bookshelf4] ^0.75 ^0.5 ^-1.5 facing ^ ^0.5 ^100");
						}
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 5);
		}
	}
}
