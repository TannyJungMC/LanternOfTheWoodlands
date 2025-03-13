package lantern_of_the_woodlands.procedures;

import net.minecraft.world.IWorld;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;

public class Spell5setSpinSpeedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell5setSpinSpeed!");
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
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) <= 25) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_spin = "2";
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) <= 50) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_spin = "1";
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) <= 100) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_spin = "0.5";
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) <= 150) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_spin = "0.25";
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) <= 200) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_spin = "0.125";
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) <= 250) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_spin = "0.0625";
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		} else if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius) <= 300) {
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_spin = "0.03125";
			LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
