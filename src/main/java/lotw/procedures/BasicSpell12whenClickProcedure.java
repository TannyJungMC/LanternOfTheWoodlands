package lotw.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lotw.item.BottleOfManaItem;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class BasicSpell12whenClickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure BasicSpell12whenClick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure BasicSpell12whenClick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure BasicSpell12whenClick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure BasicSpell12whenClick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure BasicSpell12whenClick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double repeat = 0;
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == BottleOfManaItem.block) {
			if (entity.isSneaking()) {
				repeat = 30;
			} else {
				repeat = 1;
			}
			if (LotwModVariables.MapVariables.get(world).mana < 30 && LotwModVariables.MapVariables.get(world).basicspell12_mana > 0) {
				if (repeat == 1) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @p[tag=LOTW-user] run playsound minecraft:block.conduit.attack.target ambient @a[distance=..100] ~ ~ ~ 0.5 1 0.025");
					}
				} else {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @p[tag=LOTW-user] run playsound minecraft:block.conduit.activate ambient @a[distance=..100] ~ ~ ~ 1 0 0.025");
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @p[tag=LOTW-user] run particle minecraft:firework ~ ~1 ~ 1 1 1 0 5 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @e[name=LOTW-placed_lantern] run particle minecraft:firework ~ ~1 ~ 1 1 1 0 5 force");
				}
			}
			for (int index0 = 0; index0 < (int) (repeat); index0++) {
				if (LotwModVariables.MapVariables.get(world).mana < 30 && LotwModVariables.MapVariables.get(world).basicspell12_mana > 0) {
					LotwModVariables.MapVariables.get(world).basicspell12_mana = (LotwModVariables.MapVariables.get(world).basicspell12_mana - 1);
					LotwModVariables.MapVariables.get(world).syncData(world);
					LotwModVariables.MapVariables.get(world).mana = (LotwModVariables.MapVariables.get(world).mana + 1);
					LotwModVariables.MapVariables.get(world).syncData(world);
				} else {
					LotwModVariables.MapVariables.get(world).mana_charge = 0;
					LotwModVariables.MapVariables.get(world).syncData(world);
				}
			}
			LanternRightStateProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

			LanternGroundStateProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
