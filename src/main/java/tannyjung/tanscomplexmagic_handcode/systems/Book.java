package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.server.level.ServerPlayer;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.outside.OutsideUtils;

public class Book {

    public static void updateLog (ServerPlayer player_server) {

        String type = NBTManager.Mob.getText(player_server, "book", "log");
        String text = "";

        if (type.equals("mana") == true) {

            int mana = (int) NBTManager.Mob.getNumber(player_server, "status", "mana");
            int mana_charge = (int) NBTManager.Mob.getNumber(player_server, "status", "mana_charge");
            String time = "";

            if (mana != 150) {

                time = " - Full in " + OutsideUtils.Calculation.convertSecondToTime(((150 - mana) * 60) + (60 - mana_charge));

            }

            text = "§eMana " + mana + "/150 Charge " + mana_charge + "/60" + time;

        } else if (type.equals("action") == true) {

            text = "§a23 - Set new custom compass location";

        } else if (type.equals("warning") == true) {

            text = "§c17 - Detected enemy in radius of buoy \"Beach 11\"";

        }

        NBTManager.Mob.setText(player_server, "book", "log_text", text);

    }

}
