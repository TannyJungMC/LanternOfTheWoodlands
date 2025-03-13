package lotw.procedures;

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

import java.util.Map;

public class LanternRightStateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure LanternRightState!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure LanternRightState!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure LanternRightState!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure LanternRightState!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		String id_number = "";
		id_number = "0";
		for (int index0 = 0; index0 < (int) (16); index0++) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/execute as @p[tag=LOTW-user,nbt={SelectedItem:{id:\"lotw:lantern_" + "" + id_number + "\",Count:1b}}] run "
								+ ("replaceitem entity @p[tag=LOTW-user] weapon.mainhand lotw:lantern_"
										+ (new java.text.DecimalFormat("##.#").format(Math.floor(LotwModVariables.MapVariables.get(world).mana / 2)))
												.replace(".0", ""))));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/execute as @p[tag=LOTW-user,nbt={SelectedItem:{id:\"lotw:lantern_" + "" + id_number + "\",Count:1b}}] run "
								+ ("item replace entity @p[tag=LOTW-user] weapon.mainhand with lotw:lantern_"
										+ (new java.text.DecimalFormat("##.#").format(Math.floor(LotwModVariables.MapVariables.get(world).mana / 2)))
												.replace(".0", ""))));
			}
			id_number = ((new java.text.DecimalFormat("##.#").format(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(id_number) + 1)).replace(".0", ""));
		}
	}
}
