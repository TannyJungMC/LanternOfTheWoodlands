package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.entity.Entity;

public class PersonalWeaponGUIreturnIDProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String variable_text = "";
		if ((ForgeRegistries.ITEMS.getKey(((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_weapon).getItem()).toString())
				.equals("minecraft:air")) {
			variable_text = "No Required";
		} else {
			variable_text = ForgeRegistries.ITEMS.getKey(((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_weapon).getItem())
					.toString();
		}
		return variable_text;
	}
}
