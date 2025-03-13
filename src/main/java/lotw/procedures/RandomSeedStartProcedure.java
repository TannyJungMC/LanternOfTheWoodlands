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
import net.minecraft.util.math.MathHelper;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import lotw.LotwMod;

import java.util.Random;
import java.util.Map;

public class RandomSeedStartProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure RandomSeedStart!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure RandomSeedStart!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure RandomSeedStart!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure RandomSeedStart!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
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
				if (MathHelper.nextInt(new Random(), 1, 2) == 1) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}] at @s if block ~ ~-0.1 ~ #lotw:random_seed_ground_block at @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}] run summon armor_stand ~ ~-0.7 ~ {Tags:[\"LOTW-ally\",\"LOTW-custom_planting\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-custom_planting_0\"}',Small:1b,ShowArms:1b,Pose:{LeftArm:[0.0f,90.0f,90.0f]},HandItems:[{},{id:\"\",Count:1b}],Rotation:["
										+ "" + MathHelper.nextDouble(new Random(), 1, 360) + "f]}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}] at @s if block ~ ~-0.1 ~ #lotw:random_seed_ground_block at @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}] positioned ~ ~-0.71 ~ as @e[tag=LOTW-custom_planting,distance=..0.01,limit=1,sort=nearest] at @s run tp @s ^0.125 ^ ^-0.025");
					}
				} else {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								("execute as @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}] at @s if block ~ ~-0.1 ~ #lotw:random_seed_ground_block at @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}] run summon armor_stand ~ ~-1.41 ~ {Tags:[\"LOTW-ally\",\"LOTW-custom_planting\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-custom_planting_0\"}',Small:0b,ShowArms:1b,Pose:{LeftArm:[0.0f,90.0f,90.0f]},HandItems:[{},{id:\"\",Count:1b}],Rotation:["
										+ "" + MathHelper.nextDouble(new Random(), 1, 360) + "f]}"));
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"execute as @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}] at @s if block ~ ~-0.1 ~ #lotw:random_seed_ground_block at @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}] positioned ~ ~-1.41 ~ as @e[tag=LOTW-custom_planting,distance=..0.01,limit=1,sort=nearest] at @s run tp @s ^0.25 ^ ^-0.025");
					}
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}] at @s if block ~ ~-0.1 ~ #lotw:random_seed_ground_block at @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}] run playsound minecraft:entity.chicken.egg ambient @a[distance=..100] ~ ~ ~ 0.5 "
									+ "" + MathHelper.nextDouble(new Random(), 0.5, 2) + " 0.025"));
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}] at @s if block ~ ~-0.1 ~ #lotw:random_seed_ground_block at @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}] run particle minecraft:block dirt ~ ~ ~ 0 0 0 0 5 force");
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute as @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}] at @s if block ~ ~-0.1 ~ #lotw:random_seed_ground_block run kill @e[type=item,nbt={OnGround:1b,Item:{id:\"lotw:random_seed\"}}]");
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 20);
	}
}
