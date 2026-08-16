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

        public static String getUser (ServerPlayer player_server) {

            String mod = Core.mod_id_big;
            String uuid = player_server.getUUID().toString();

            return mod + "-user-" + uuid;

        }

        public static String getAlly (ServerPlayer player_server) {

            String mod = Core.mod_id_big;
            String uuid = player_server.getUUID().toString();

            return mod + "-ally-" + uuid;

        }

        public static String[] convertSystemAll (ServerPlayer player_server) {

            return new String[]{Core.mod_id_big, getUser(player_server)};

        }

        public static String[] convertSystemSpecific (ServerPlayer player_server, String[] tags) {

            String[] convert = new String[tags.length + 1];
            convert[0] = getUser(player_server);

            for (int number = 0; number < tags.length; number++) {

                convert[number + 1] = Core.mod_id_big + "-" + tags[number];

            }

            return convert;

        }

        public static String[] convertAlly (ServerPlayer player_server) {

            return new String[]{getAlly(player_server)};

        }

        public static String[] convertEnemy (ServerPlayer player_server) {

            return new String[]{"!" + Core.mod_id_big, "!" + getUser(player_server), "!" + getAlly(player_server)};

        }

    }

}
