package lantern_of_the_woodlands.procedures;

import net.minecraft.world.IWorld;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModVariables;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.Map;

public class Spell5setSAVEProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LanternOfTheWoodlandsMod.LOGGER.warn("Failed to load dependency world for procedure Spell5setSAVE!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius_save = new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_radius);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone_save = new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency_save = new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_safe_zone_360 = new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_circle_frequency);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_degree_frequency_save = 0;
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_trap_degree = Math.ceil(new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(LanternOfTheWoodlandsModVariables.MapVariables.get(world).spell5_degree_frequency) / 2);
		LanternOfTheWoodlandsModVariables.MapVariables.get(world).syncData(world);
	}
}
