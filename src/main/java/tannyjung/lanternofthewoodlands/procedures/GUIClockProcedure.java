package tannyjung.lanternofthewoodlands.procedures;

import net.minecraft.world.level.LevelAccessor;

public class GUIClockProcedure {
	public static double execute(LevelAccessor world) {
		double game_time = 0;
		game_time = world.dayTime() + 24000;
		return Math.floor((game_time / 24000 - Math.floor(game_time / 24000)) * 24);
	}
}
