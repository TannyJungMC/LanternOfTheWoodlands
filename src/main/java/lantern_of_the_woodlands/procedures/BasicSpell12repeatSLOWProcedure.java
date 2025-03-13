package lantern_of_the_woodlands.procedures;

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

import lantern_of_the_woodlands.item.BottleOfManaItem;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;

public class BasicSpell12repeatSLOWProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure BasicSpell12repeatSLOW!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure BasicSpell12repeatSLOW!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure BasicSpell12repeatSLOW!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure BasicSpell12repeatSLOW!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency entity for procedure BasicSpell12repeatSLOW!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).lantern_in_left_hand == 1
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == BottleOfManaItem.block) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).mana > 0) {
				if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell12_mana < 60) {
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).mana = (LanternOfTheWoodlandsModVariables.MapVariables.get(world).mana
							- 1);
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
					LanternOfTheWoodlandsModVariables.MapVariables
							.get(world).basicspell12_mana = (LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell12_mana + 1);
					LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @p[tag=woodlands] run playsound minecraft:block.conduit.ambient ambient @a ~ ~ ~ 0.4 2");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute at @p[tag=woodlands] run playsound minecraft:block.conduit.ambient.short ambient @a ~ ~ ~ 0.2 0");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"/execute at @p[tag=woodlands] run particle minecraft:firework ~ ~1 ~ 1 1 1 0 5 force");
					}
				}
			}
		}
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == BottleOfManaItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/title @p[tag=woodlands] actionbar [{\"text\":\"Bottle of Mana : [\",\"color\":\"gray\"},{\"text\":\"" + ""
								+ (new java.text.DecimalFormat("##.#")
										.format(LanternOfTheWoodlandsModVariables.MapVariables.get(world).basicspell12_mana)).replace(".0", "")
								+ "\",\"color\":\"aqua\"},{\"text\":\"/60]\",\"color\":\"gray\"}]"));
			}
		}
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).lantern_in_left_hand == 1
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == BottleOfManaItem.block
				|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == BottleOfManaItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @p[tag=woodlands] run playsound minecraft:block.conduit.ambient.short ambient @a ~ ~ ~ 0.05 0");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute at @p[tag=woodlands] run particle lantern_of_the_woodlands:particle_yellow_dot ~ ~1 ~ 0.5 0.5 0.5 0 1 force");
			}
		}
	}
}
