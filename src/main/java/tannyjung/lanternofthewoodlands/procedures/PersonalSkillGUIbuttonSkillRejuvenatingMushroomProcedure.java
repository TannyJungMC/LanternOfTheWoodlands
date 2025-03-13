package tannyjung.lanternofthewoodlands.procedures;

import tannyjung.lanternofthewoodlands.network.LanternofthewoodlandsModVariables;

import net.minecraft.world.entity.Entity;

public class PersonalSkillGUIbuttonSkillRejuvenatingMushroomProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).user_DELETE_THIS).equals("")) {
			if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_skill_skill_rejuvenating_mushroom == false) {
				if ((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).mana >= 60) {
					{
						double _setval = (entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).mana - 60;
						entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.mana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = true;
						entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.personal_skill_skill_rejuvenating_mushroom = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else {
				if (!((entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LanternofthewoodlandsModVariables.PlayerVariables())).personal_skill).equals("Rejuvenating Mushroom")) {
					{
						double _setval = 1;
						entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.personal_skill_level = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "Rejuvenating Mushroom";
						entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.personal_skill = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 5;
						entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.personal_skill_cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 2;
						entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.personal_skill_duration = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 1.5;
						entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.personal_skill_radius = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "Health Recovery";
						entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.personal_skill_custom = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "20";
						entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.personal_skill_custom_value = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "Duration";
						entity.getCapability(LanternofthewoodlandsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.personal_skill_upgrade = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
