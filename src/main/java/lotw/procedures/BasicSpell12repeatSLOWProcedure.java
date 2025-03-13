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

import java.util.Map;

public class BasicSpell12repeatSLOWProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure BasicSpell12repeatSLOW!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure BasicSpell12repeatSLOW!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure BasicSpell12repeatSLOW!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure BasicSpell12repeatSLOW!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LotwMod.LOGGER.warn("Failed to load dependency entity for procedure BasicSpell12repeatSLOW!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (LotwModVariables.MapVariables.get(world).lantern_in_left_hand == 1
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == BottleOfManaItem.block) {
			if (LotwModVariables.MapVariables.get(world).mana > 0 && LotwModVariables.MapVariables.get(world).basicspell12_mana < 150) {
				LotwModVariables.MapVariables.get(world).mana = (LotwModVariables.MapVariables.get(world).mana - 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).basicspell12_mana = (LotwModVariables.MapVariables.get(world).basicspell12_mana + 1);
				LotwModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @p[tag=LOTW-user] run playsound minecraft:block.conduit.ambient ambient @a[distance=..100] ~ ~ ~ 0.4 2 0.025");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @p[tag=LOTW-user] run playsound minecraft:block.conduit.ambient.short ambient @a[distance=..100] ~ ~ ~ 0.2 0 0.025");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"/execute at @p[tag=LOTW-user] run particle minecraft:firework ~ ~1 ~ 1 1 1 0 5 force");
				}
			}
		}
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == BottleOfManaItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/title @p[tag=LOTW-user] actionbar [{\"text\":\"Bottle of Mana : [\",\"color\":\"gray\"},{\"text\":\"" + ""
								+ (new java.text.DecimalFormat("##.#").format(LotwModVariables.MapVariables.get(world).basicspell12_mana))
										.replace(".0", "")
								+ "\",\"color\":\"aqua\"},{\"text\":\"/150]\",\"color\":\"gray\"}]"));
			}
		}
		if (LotwModVariables.MapVariables.get(world).lantern_in_left_hand == 1
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == BottleOfManaItem.block
				|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == BottleOfManaItem.block) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @p[tag=LOTW-user] run playsound minecraft:block.conduit.ambient.short @a[distance=..100] ~ ~ ~ 0.05 0 0.025");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute at @p[tag=LOTW-user] run particle lotw:dot_yellow_small ~ ~1 ~ 0.5 0.5 0.5 0 1 force");
			}
		}
	}
}
