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
import net.minecraft.client.gui.widget.TextFieldWidget;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;
import java.util.HashMap;

public class Spell3clickUSEProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell3clickUSE!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LotwMod.LOGGER.warn("Failed to load dependency x for procedure Spell3clickUSE!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LotwMod.LOGGER.warn("Failed to load dependency y for procedure Spell3clickUSE!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LotwMod.LOGGER.warn("Failed to load dependency z for procedure Spell3clickUSE!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				LotwMod.LOGGER.warn("Failed to load dependency guistate for procedure Spell3clickUSE!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell3_radius");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText()) / 2 - Math.round(new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell3_radius");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText()) / 2) != 0) {
			{
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell3_radius");
				if (_tf != null) {
					_tf.setText(((new java.text.DecimalFormat("##.#").format(new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell3_radius");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText()) + 1)).replace(".0", "")));
				}
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
				LotwModVariables.MapVariables.get(world).spell3_insert = (new Object() {
					public String getText() {
						TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:spell3_radius");
						if (_tf != null) {
							return _tf.getText();
						}
						return "";
					}
				}.getText());
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell3_up_dawn = (45 / new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(LotwModVariables.MapVariables.get(world).spell3_insert));
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell3_left_right = ((-45) / new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(LotwModVariables.MapVariables.get(world).spell3_insert));
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell3_time = (((new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(LotwModVariables.MapVariables.get(world).spell3_insert) * new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(LotwModVariables.MapVariables.get(world).spell3_insert)) / 10)
						* (16 / LotwModVariables.MapVariables.get(world).spell3_speed));
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell3_percent_full = LotwModVariables.MapVariables.get(world).spell3_time;
				LotwModVariables.MapVariables.get(world).syncData(world);
				LotwModVariables.MapVariables.get(world).spell3_start = (true);
				LotwModVariables.MapVariables.get(world).syncData(world);
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 20);
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"kill @e[name=LOTW-dome_position]");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"execute at @e[name=LOTW-placed_lantern] run summon armor_stand ~ ~ ~ {Tags:[\"LOTW-ally\"],Invisible:1b,NoGravity:1b,Marker:1b,CustomName:'{\"text\":\"LOTW-dome_position\"}'}");
		}
	}
}
