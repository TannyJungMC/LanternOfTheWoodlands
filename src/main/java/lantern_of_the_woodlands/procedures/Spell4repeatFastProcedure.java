package lantern_of_the_woodlands.procedures;

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

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Spell4repeatFastProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell4repeatFast!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency x for procedure Spell4repeatFast!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency y for procedure Spell4repeatFast!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency z for procedure Spell4repeatFast!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		String Tone = "";
		String Ttwo = "";
		String Jone = "";
		String Jtwo = "";
		String Tthree = "";
		String Jthree = "";
		if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).main_spell == 4) {
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_weapon_around_lantern == true) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @e[type=armor_stand,name=placed_lantern] run tp @e[type=armor_stand,name=spell4main] ~ ~-1.5 ~");
				}
				Tone = "0";
				Ttwo = "0.75";
				Tthree = ("-" + Ttwo);
				Jone = "0";
				Jtwo = "0.5";
				Jthree = ("-" + Jtwo);
			} else {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"execute at @p[tag=woodlands] run tp @e[type=armor_stand,name=spell4main] ~ ~-0.5 ~");
				}
				Tone = "0";
				Ttwo = "3";
				Tthree = ("-" + Ttwo);
				Jone = "0";
				Jtwo = "2";
				Jthree = ("-" + Jtwo);
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_1shoot == false) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[type=armor_stand,name=spell4main] at @s run tp @e[type=armor_stand,name=spell4weapon,tag=weapon1,tag=!choose,tag=!shoot] ^"
									+ Tone + " ^ ^" + Ttwo + " facing entity @s eyes"));
				}
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_2shoot == false) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[type=armor_stand,name=spell4main] at @s run tp @e[type=armor_stand,name=spell4weapon,tag=weapon2,tag=!choose,tag=!shoot] ^"
									+ Jtwo + " ^ ^" + Jtwo + " facing entity @s eyes"));
				}
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_3shoot == false) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[type=armor_stand,name=spell4main] at @s run tp @e[type=armor_stand,name=spell4weapon,tag=weapon3,tag=!choose,tag=!shoot] ^"
									+ Ttwo + " ^ ^" + Tone + " facing entity @s eyes"));
				}
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_4shoot == false) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[type=armor_stand,name=spell4main] at @s run tp @e[type=armor_stand,name=spell4weapon,tag=weapon4,tag=!choose,tag=!shoot] ^"
									+ Jtwo + " ^ ^" + Jthree + " facing entity @s eyes"));
				}
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_5shoot == false) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[type=armor_stand,name=spell4main] at @s run tp @e[type=armor_stand,name=spell4weapon,tag=weapon5,tag=!choose,tag=!shoot] ^"
									+ Tone + " ^ ^" + Tthree + " facing entity @s eyes"));
				}
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_6shoot == false) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[type=armor_stand,name=spell4main] at @s run tp @e[type=armor_stand,name=spell4weapon,tag=weapon6,tag=!choose,tag=!shoot] ^"
									+ Jthree + " ^ ^" + Jthree + " facing entity @s eyes"));
				}
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_7shoot == false) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[type=armor_stand,name=spell4main] at @s run tp @e[type=armor_stand,name=spell4weapon,tag=weapon7,tag=!choose,tag=!shoot] ^"
									+ Tthree + " ^ ^" + Tone + " facing entity @s eyes"));
				}
			}
			if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_8shoot == false) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("execute as @e[type=armor_stand,name=spell4main] at @s run tp @e[type=armor_stand,name=spell4weapon,tag=weapon8,tag=!choose,tag=!shoot] ^"
									+ Jthree + " ^ ^" + Jtwo + " facing entity @s eyes"));
				}
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4main] at @s run tp @s ~ ~ ~ ~0.5 ~");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @p[tag=woodlands] at @s run tp @e[type=armor_stand,name=spell4choose] @s");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute as @e[type=armor_stand,name=spell4choose] at @s positioned ~ ~1 ~ run tp @e[type=armor_stand,name=spell4weapon,tag=choose] ^ ^ ^1 facing entity @s eyes");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"/data merge entity @e[type=armor_stand,name=spell4weapon,tag=!choose,tag=!shoot,limit=1,sort=random] {Pose:{Head:[0f,0f,-45f]}}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=spell4choose,x_rotation=70..90] positioned ~ ~1 ~ run data merge entity @e[type=armor_stand,name=spell4weapon,tag=choose,limit=1] {Pose:{Head:[90f,315f,90f]}}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=spell4choose,x_rotation=50..70] positioned ~ ~1 ~ run data merge entity @e[type=armor_stand,name=spell4weapon,tag=choose,limit=1] {Pose:{Head:[90f,292.5f,90f]}}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=spell4choose,x_rotation=30..50] positioned ~ ~1 ~ run data merge entity @e[type=armor_stand,name=spell4weapon,tag=choose,limit=1] {Pose:{Head:[90f,270f,90f]}}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=spell4choose,x_rotation=10..30] positioned ~ ~1 ~ run data merge entity @e[type=armor_stand,name=spell4weapon,tag=choose,limit=1] {Pose:{Head:[90f,247.5f,90f]}}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=spell4choose,x_rotation=-10..10] positioned ~ ~1 ~ run data merge entity @e[type=armor_stand,name=spell4weapon,tag=choose,limit=1] {Pose:{Head:[90f,225f,90f]}}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=spell4choose,x_rotation=-30..-10] positioned ~ ~1 ~ run data merge entity @e[type=armor_stand,name=spell4weapon,tag=choose,limit=1] {Pose:{Head:[90f,202.5f,90f]}}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=spell4choose,x_rotation=-50..-30] positioned ~ ~1 ~ run data merge entity @e[type=armor_stand,name=spell4weapon,tag=choose,limit=1] {Pose:{Head:[90f,180f,90f]}}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=spell4choose,x_rotation=-70..-50] positioned ~ ~1 ~ run data merge entity @e[type=armor_stand,name=spell4weapon,tag=choose,limit=1] {Pose:{Head:[90f,157.5f,90f]}}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=spell4choose,x_rotation=-90..-70] positioned ~ ~1 ~ run data merge entity @e[type=armor_stand,name=spell4weapon,tag=choose,limit=1] {Pose:{Head:[90f,135f,90f]}}");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager()
						.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "");
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=spell4shoot,tag=shoot] positioned ^0.26 ^ ^ run tp @e[type=armor_stand,name=spell4weapon,tag=shoot,distance=..2,sort=nearest,limit=1] ~ ~ ~");
			}
			Spell4tpProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

			Spell4effectProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						"execute at @e[type=armor_stand,name=spell4weapon,tag=shoot] run particle smoke ~ ~1 ~ 0.5 0.5 0.5 0 1 force");
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
					if (LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell4_start == true) {
						Spell4repeatFastProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 1);
		}
	}
}
