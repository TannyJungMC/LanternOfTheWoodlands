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

public class Spell6repeatFASTProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell6repeatFAST!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell6repeatFAST!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell6repeatFAST!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell6repeatFAST!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (LotwModVariables.MapVariables.get(world).spell6_pause == false) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=LOTW-placed_lantern] as @e[type=armor_stand,name=lotw-illusion_block,limit=1,sort=nearest,tag=!lotw-illusion_block_placed] at @s run tag @s add lotw-illusion_block_select");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-illusion_block,tag=lotw-illusion_block_select] if block ~ ~ ~ #minecraft:air_blocks run particle minecraft:firework ~ ~ ~ 0.25 0.25 0.25 0.1 2 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-illusion_block,tag=lotw-illusion_block_select] if block ~ ~ ~ #minecraft:illusion_block run particle minecraft:firework ~ ~ ~ 0.25 0.25 0.25 0.1 2 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-illusion_block,tag=lotw-illusion_block_select] if block ~ ~ ~ #minecraft:air_blocks run playsound minecraft:block.enchantment_table.use ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=lotw-illusion_block,tag=lotw-illusion_block_select] if block ~ ~ ~ #minecraft:illusion_block run playsound minecraft:block.beacon.power_select ambient @a[distance=..100] ~ ~ ~ 0.5 0.75 0.025");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/execute as @e[tag=wsupport] at @s if block ~ ~1 ~ #minecraft:illusion_block run effect give @s invisibility 1 1 true");
			}
			if (LotwModVariables.MapVariables.get(world).spell6_create == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-illusion_block,tag=!lotw-illusion_block_placed,tag=lotw-illusion_block_log,tag=lotw-illusion_block_select] if block ~ ~ ~ #minecraft:air_blocks run setblock ~ ~ ~ lantern_of_the_woodlands:illusion_log");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-illusion_block,tag=!lotw-illusion_block_placed,tag=lotw-illusion_block_leaves,tag=lotw-illusion_block_select] if block ~ ~ ~ #minecraft:air_blocks run setblock ~ ~ ~ lantern_of_the_woodlands:illusion_leaves");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-illusion_block,tag=!lotw-illusion_block_placed,tag=lotw-illusion_block_grass,tag=lotw-illusion_block_select] if block ~ ~ ~ #minecraft:air_blocks run setblock ~ ~ ~ lantern_of_the_woodlands:illusion_grass");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-illusion_block,tag=!lotw-illusion_block_placed,tag=lotw-illusion_block_dirt,tag=lotw-illusion_block_select] if block ~ ~ ~ #minecraft:air_blocks run setblock ~ ~ ~ lantern_of_the_woodlands:illusion_dirt");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-illusion_block,tag=!lotw-illusion_block_placed,tag=lotw-illusion_block_stone,tag=lotw-illusion_block_select] if block ~ ~ ~ #minecraft:air_blocks run setblock ~ ~ ~ lantern_of_the_woodlands:illusion_stone");
				}
			} else {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=lotw-illusion_block,tag=lotw-illusion_block_select] run fill ~ ~ ~ ~ ~ ~ air replace #minecraft:illusion_block");
				}
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=lotw-illusion_block,tag=!lotw-illusion_block_placed,tag=lotw-illusion_block_select] at @s run tag @s add lotw-illusion_block_placed");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=lotw-illusion_block,tag=lotw-illusion_block_placed,tag=lotw-illusion_block_select] at @s run tag @s remove lotw-illusion_block_select");
			}
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

				Spell6repeatFASTProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 1);
	}
}
