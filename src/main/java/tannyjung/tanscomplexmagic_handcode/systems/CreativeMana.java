package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.server.level.ServerPlayer;
import tannyjung.tanscomplexmagic_core.game.NBTManager;

public class CreativeMana {

    private static int tick_second = 0;

    public static void tick (ServerPlayer player_server) {

        if (tick_second > 0) {

            tick_second = tick_second - 1;
            return;

        } else {

            tick_second = 20;

        }

        NBTManager.Mob.setNumber(player_server, "main", "mana", 150, true);
        NBTManager.Mob.setNumber(player_server, "main", "mana_charge", 0, true);

    }

}
