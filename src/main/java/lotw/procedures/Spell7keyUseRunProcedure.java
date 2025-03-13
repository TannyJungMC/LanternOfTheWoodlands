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

public class Spell7keyUseRunProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell7keyUseRun!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell7keyUseRun!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell7keyUseRun!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell7keyUseRun!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure Spell7keyUseRun!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		String enchant_id = "";
		double repeat = 0;
		double test = 0;

		UserOnlyTestProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		if (LotwModVariables.MapVariables.get(world).user_only == true && LotwModVariables.MapVariables.get(world).spell7_start == true) {
			if ((LotwModVariables.MapVariables.get(world).spell7_use).equals("")
					|| (LotwModVariables.MapVariables.get(world).spell7_use).equals("None")) {
				repeat = 1;
				while (true) {
					test = 1;
					if (!("Weather").equals("")) {
						if (true) {
							if (repeat == test) {
								enchant_id = "The Peaceful Day";
							}
							test = (test + 1);
						}
						if (true) {
							if (repeat == test) {
								enchant_id = "Heavy Rain";
							}
							test = (test + 1);
						}
						if (repeat == test) {
							enchant_id = "Thunder Storm";
						}
						test = (test + 1);
						if (true) {
							if (repeat == test) {
								enchant_id = "Snowstorm";
							}
							test = (test + 1);
						}
						if (true) {
							if (repeat == test) {
								enchant_id = "Strong Wind";
							}
							test = (test + 1);
						}
						if (true) {
							if (repeat == test) {
								enchant_id = "Cloud Manipulation";
							}
							test = (test + 1);
						}
						if (true) {
							if (repeat == test) {
								enchant_id = "Lightning Bolt";
							}
							test = (test + 1);
						}
					}
					if (!("Fire").equals("")) {
						if (true) {
							if (repeat == test) {
								enchant_id = "Fireball";
							}
							test = (test + 1);
						}
						if (true) {
							if (repeat == test) {
								enchant_id = "Multiple Fireballs";
							}
							test = (test + 1);
						}
					}
					if (!("Healing").equals("")) {
						if (true) {
							if (repeat == test) {
								enchant_id = "Heal";
							}
							test = (test + 1);
						}
						if (true) {
							if (repeat == test) {
								enchant_id = "Healing Area";
							}
							test = (test + 1);
						}
					}
					if (!("Ice").equals("")) {
						if (true) {
							if (repeat == test) {
								enchant_id = "Cold Zone";
							}
							test = (test + 1);
						}
					}
					if (!("Dark").equals("")) {
						if (true) {
							if (repeat == test) {
								enchant_id = "Cursing";
							}
							test = (test + 1);
						}
					}
					if (!("Holy").equals("")) {
						if (true) {
							if (repeat == test) {
								enchant_id = "Antidote";
							}
							test = (test + 1);
						}
						if (true) {
							if (repeat == test) {
								enchant_id = "Cleanse";
							}
							test = (test + 1);
						}
					}
					if (!("Light").equals("")) {
						if (true) {
							if (repeat == test) {
								enchant_id = "Uncovering";
							}
							test = (test + 1);
						}
						if (true) {
							if (repeat == test) {
								enchant_id = "Midnight Friend";
							}
							test = (test + 1);
						}
						if (true) {
							if (repeat == test) {
								enchant_id = "Fireflies Dance";
							}
							test = (test + 1);
						}
					}
					if (!("Adaptive").equals("")) {
						if (true) {
							if (repeat == test) {
								enchant_id = "Firework";
							}
							test = (test + 1);
						}
						if (true) {
							if (repeat == test) {
								enchant_id = "Multiple Fireworks";
							}
							test = (test + 1);
						}
					}
					if (!("Wind").equals("")) {
						if (true) {
							if (repeat == test) {
								enchant_id = "Wind Knockback";
							}
							test = (test + 1);
						}
						if (true) {
							if (repeat == test) {
								enchant_id = "Wind Cutter";
							}
							test = (test + 1);
						}
					}
					if (!("Teleportation").equals("")) {
						if (true) {
							if (repeat == test) {
								enchant_id = "Return";
							}
							test = (test + 1);
						}
						if (true) {
							if (repeat == test) {
								enchant_id = "Time Travelling";
							}
							test = (test + 1);
						}
					}
					if (repeat == test) {
						break;
					} else {
						repeat = (repeat + 1);
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
									("execute if entity @e[name=LOTW-enchant_book"
											+ (new java.text.DecimalFormat("##.#")
													.format(LotwModVariables.MapVariables.get(world).spell7_book_number)).replace(".0", "")
											+ ",nbt={ArmorItems:[{id:\"lotw:spell_book\",Count:1b,tag:{display:{Lore:[\"{\\\"text\\\":\\\""
											+ enchant_id + "\\\"}\"]}}},{},{},{}]}] run LOTW-spell7_test_use " + enchant_id));
						}
					}
				}
			} else {
				Spell7useCancelProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}
}
