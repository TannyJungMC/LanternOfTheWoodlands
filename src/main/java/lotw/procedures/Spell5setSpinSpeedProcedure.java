package lotw.procedures;

import net.minecraft.world.IWorld;

import lotw.LotwModVariables;

import lotw.LotwMod;

import java.util.Map;

public class Spell5setSpinSpeedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LotwMod.LOGGER.warn("Failed to load dependency world for procedure Spell5setSpinSpeed!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LotwModVariables.MapVariables.get(world).spell5_radius) <= 25) {
			LotwModVariables.MapVariables.get(world).spell5_spin = "2";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LotwModVariables.MapVariables.get(world).spell5_radius) <= 50) {
			LotwModVariables.MapVariables.get(world).spell5_spin = "1";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LotwModVariables.MapVariables.get(world).spell5_radius) <= 100) {
			LotwModVariables.MapVariables.get(world).spell5_spin = "0.5";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LotwModVariables.MapVariables.get(world).spell5_radius) <= 150) {
			LotwModVariables.MapVariables.get(world).spell5_spin = "0.25";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LotwModVariables.MapVariables.get(world).spell5_radius) <= 200) {
			LotwModVariables.MapVariables.get(world).spell5_spin = "0.125";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LotwModVariables.MapVariables.get(world).spell5_radius) <= 250) {
			LotwModVariables.MapVariables.get(world).spell5_spin = "0.0625";
			LotwModVariables.MapVariables.get(world).syncData(world);
		} else if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LotwModVariables.MapVariables.get(world).spell5_radius) <= 300) {
			LotwModVariables.MapVariables.get(world).spell5_spin = "0.03125";
			LotwModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
