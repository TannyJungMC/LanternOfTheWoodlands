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

public class CustomPlantLoopProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure CustomPlantLoop!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure CustomPlantLoop!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure CustomPlantLoop!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure CustomPlantLoop!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		String who_bubble = "";
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

					CustomPlantLoopProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:iron_shovel\"}}] positioned ~ ~-1 ~ if entity @e[name=LOTW-custom_planting_31,distance=..1] run playsound minecraft:item.shovel.flatten ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:iron_shovel\"}}] positioned ~ ~-1 ~ if entity @e[name=LOTW-custom_planting_31,distance=..1] run particle block dirt ~ ~1.25 ~ 0.25 0.1 0.25 0.1 20 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:iron_shovel\"}}] positioned ~ ~-1 ~ at @e[name=LOTW-custom_planting_31,distance=..1] run summon item ~ ~1 ~ {Item:{id:\"minecraft:grass\",Count:1b}}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:iron_shovel\"}}] positioned ~ ~-1 ~ as @e[name=LOTW-custom_planting_31,distance=..1] at @s positioned ~ ~1 ~ run data modify entity @e[type=item,nbt={Item:{id:\"minecraft:grass\"}},distance=..1,limit=1] Item merge from entity @s HandItems[1]");
			}
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:potion\"}}] if entity @e[name=LOTW-custom_planting_bag,distance=..1] run LOTW-CustomPlantBagWater");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:bone_meal\"}}] if entity @e[name=LOTW-custom_planting_bag,distance=..1] run LOTW-CustomPlantBagFertilizer");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:iron_shovel\"}}] if entity @e[name=LOTW-custom_planting_bag,distance=..1] run LOTW-CustomPlantBagMature");
		}
		CustomPlantBagLinkProcedure
				.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		if ((LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble).equals("User and Ally")) {
			who_bubble = "@a[tag=LOTW-ally]";
		} else if ((LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble).equals("Ally")) {
			who_bubble = "@a[tag=!LOTW-user,tag=LOTW-ally]";
		} else if ((LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble).equals("All Player")) {
			who_bubble = "@a";
		} else if ((LotwModVariables.MapVariables.get(world).who_can_see_plant_chat_bubble).equals("No One")) {
			who_bubble = "noONEcantSEEme";
		} else {
			who_bubble = "@p[tag=LOTW-user]";
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[name=LOTW-custom_planting_" + "0"
								+ ",nbt={Small:0b}] run particle lotw:chat_bubble_water ^-0.125 ^2 ^ 0 0 0 0 1 force " + who_bubble));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[name=LOTW-custom_planting_" + "0"
								+ ",nbt={Small:1b}] run particle lotw:chat_bubble_water ^-0.125 ^1.3 ^ 0 0 0 0 1 force " + who_bubble));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[name=LOTW-custom_planting_" + "10"
								+ ",nbt={Small:0b}] run particle lotw:chat_bubble_water ^-0.125 ^2 ^ 0 0 0 0 1 force " + who_bubble));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[name=LOTW-custom_planting_" + "10"
								+ ",nbt={Small:1b}] run particle lotw:chat_bubble_water ^-0.125 ^1.3 ^ 0 0 0 0 1 force " + who_bubble));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[name=LOTW-custom_planting_" + "20"
								+ ",nbt={Small:0b}] run particle lotw:chat_bubble_fertilizer ^-0.125 ^2 ^ 0 0 0 0 1 force " + who_bubble));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[name=LOTW-custom_planting_" + "20"
								+ ",nbt={Small:1b}] run particle lotw:chat_bubble_fertilizer ^-0.125 ^1.3 ^ 0 0 0 0 1 force " + who_bubble));
			}
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:potion\"}}] positioned ~ ~-1 ~ as @e[name=LOTW-custom_planting_"
								+ "0" + ",distance=..1] at @s run data merge entity @s {CustomName:'{\"text\":\"LOTW-custom_planting_" + "1"
								+ "\"}'}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:potion\"}}] positioned ~ ~-1 ~ as @e[name=LOTW-custom_planting_"
								+ "10" + ",distance=..1] at @s run data merge entity @s {CustomName:'{\"text\":\"LOTW-custom_planting_" + "11"
								+ "\"}'}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:potion\"}}] positioned ~ ~-1 ~ if entity @e[tag=LOTW-custom_planting,distance=..1] run particle minecraft:rain ~ ~1.25 ~ 0.4 0.1 0.4 0 20 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:potion\"}}] positioned ~ ~-1 ~ if entity @e[tag=LOTW-custom_planting,distance=..1] run playsound minecraft:item.bottle.fill ambient @a[distance=..100] ~ ~ ~ 0.5 1.5 0.025");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:potion\"}}] positioned ~ ~-1 ~ if entity @e[tag=LOTW-custom_planting,distance=..1] run summon item ~ ~1 ~ {Item:{id:\"minecraft:glass_bottle\",Count:1b}}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:potion\"}}] at @s positioned ~ ~-1 ~ if entity @e[tag=LOTW-custom_planting,distance=..1] run kill @s");
			}
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:bone_meal\"}}] positioned ~ ~-1 ~ as @e[name=LOTW-custom_planting_"
								+ "20" + ",distance=..1] at @s run data merge entity @s {CustomName:'{\"text\":\"LOTW-custom_planting_" + "21"
								+ "\"}'}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:bone_meal\"}}] positioned ~ ~-1 ~ if entity @e[tag=LOTW-custom_planting,distance=..1] run particle minecraft:crit ~ ~1.4 ~ 0.4 0.1 0.4 0.1 10 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:bone_meal\"}}] positioned ~ ~-1 ~ if entity @e[tag=LOTW-custom_planting,distance=..1] run playsound minecraft:block.snow.break ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:bone_meal\"}}] at @s positioned ~ ~-1 ~ if entity @e[tag=LOTW-custom_planting,distance=..1] run kill @s");
			}
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:iron_shovel\"}}] positioned ~ ~-1 ~ if entity @e[name=LOTW-custom_planting_mature,distance=..1] run playsound minecraft:item.shovel.flatten ambient @a[distance=..100] ~ ~ ~ 0.5 0 0.025");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:iron_shovel\"}}] positioned ~ ~-1 ~ if entity @e[name=LOTW-custom_planting_mature,distance=..1] run particle block dirt ~ ~1.25 ~ 0.25 0.1 0.25 0.1 20 force");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:iron_shovel\"}}] positioned ~ ~-1 ~ at @e[name=LOTW-custom_planting_mature,distance=..1] run summon item ~ ~1 ~ {Item:{id:\"minecraft:grass\",Count:1b}}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:iron_shovel\"}}] positioned ~ ~-1 ~ as @e[name=LOTW-custom_planting_mature,distance=..1] at @s positioned ~ ~1 ~ run data modify entity @e[type=item,nbt={Item:{id:\"minecraft:grass\"}},distance=..1,limit=1] Item merge from entity @s HandItems[1]");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=item,nbt={OnGround:1b,Item:{id:\"minecraft:iron_shovel\"}}] positioned ~ ~-1 ~ as @e[name=LOTW-custom_planting_mature,distance=..1] at @s run kill @s");
			}
		}
		if (true) {
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("execute as @e[type=item,nbt={Item:{id:\"" + "lotw:sunflower" + "\"}}] at @s run data merge entity @s {Item:{id:\""
								+ "minecraft:sunflower" + "\"}}"));
			}
		}
	}
}
