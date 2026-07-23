package tannyjung.tanscomplexmagic.procedures;

import tannyjung.tanscomplexmagic.network.TanscomplexmagicModVariables;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class PersonalWeaponGUIbuttonPoseXreduceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS).equals("")) {
			{
				TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
				_vars.personal_weapon_pose_x = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pose_x - 5;
				_vars.markSyncDirty();
			}
			if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pose_x < 0) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.personal_weapon_pose_x = 355;
					_vars.markSyncDirty();
				}
			} else if (entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pose_x > 355) {
				{
					TanscomplexmagicModVariables.PlayerVariables _vars = entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES);
					_vars.personal_weapon_pose_x = 0;
					_vars.markSyncDirty();
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						(("data modify entity @e[name=<ID>-personal_weapon_display,limit=1] Pose.RightArm set value " + "[" + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pose_x + "f,"
								+ entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pose_y + "f," + entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).personal_weapon_pose_z + "f]")
								.replace("<ID>", entity.getData(TanscomplexmagicModVariables.PLAYER_VARIABLES).user_DELETE_THIS)));
		}
	}
}