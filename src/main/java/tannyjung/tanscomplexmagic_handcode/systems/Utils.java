package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.server.level.ServerPlayer;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.NBTManager;

public class Utils {

    public static boolean trySpendMana (ServerPlayer player_server, int amount) {

        int mana = (int) NBTManager.Mob.getNumber(player_server, "main", "mana");

        if (mana < amount) {

            return false;

        }

        NBTManager.Mob.setNumber(player_server, "main", "mana", mana - amount);
        return true;

    }

    public static class Tag {

        public static String[] convertSystemAll (ServerPlayer player_server) {

            String mod = Core.mod_id_big;
            String uuid = String.valueOf(player_server.getUUID());

            return new String[]{mod + "-user-" + uuid};

        }

        public static String[] convertSystemSpecific (ServerPlayer player_server, String[] tags) {

            String mod = Core.mod_id_big;
            String uuid = String.valueOf(player_server.getUUID());

            String[] convert = new String[tags.length + 1];
            convert[0] = Core.mod_id_big + "-user-" + uuid;

            for (int number = 0; number < tags.length; number++) {

                convert[number + 1] = mod + "-" + tags[number];

            }

            return convert;

        }

        public static String[] convertAlly (ServerPlayer player_server) {

            String mod = Core.mod_id_big;
            String uuid = String.valueOf(player_server.getUUID());

            return new String[]{mod + "-ally-" + uuid};

        }

        public static String[] convertEnemy (ServerPlayer player_server) {

            String mod = Core.mod_id_big;
            String uuid = String.valueOf(player_server.getUUID());

            return new String[]{"!" + mod, "!" + mod + "-user-" + uuid, "!" + mod + "-ally-" + uuid};

        }

    }

}
