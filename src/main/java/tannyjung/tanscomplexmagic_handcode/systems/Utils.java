package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.server.level.ServerPlayer;
import tannyjung.tanscomplexmagic_core.Core;

import java.util.UUID;

public class Utils {

    public static class Tag {

        public static String[] convertSystem (ServerPlayer player_server, String[] tags) {

            String[] convert = new String[tags.length + 2];
            convert[0] = Core.mod_id_big + "-user-" + player_server.getUUID();
            convert[1] = Core.mod_id_big + "-ally-" + player_server.getUUID();

            for (int number = 0; number < tags.length; number++) {

                convert[number + 2] = Core.mod_id_big + "-" + tags[number];

            }

            return convert;

        }

        public static String[] convertSystemAll (ServerPlayer player_server) {

            String user = Core.mod_id_big + "-user-" + player_server.getUUID();
            String ally = Core.mod_id_big + "-ally-" + player_server.getUUID();
            return new String[]{user, ally};

        }

        public static String[] convertAlly (ServerPlayer player_server) {

            String ally = Core.mod_id_big + "-ally-" + player_server.getUUID();
            return new String[]{ally};

        }

        public static String[] convertEnemy (ServerPlayer player_server) {

            String ally = "!" + Core.mod_id_big + "-ally-" + player_server.getUUID();
            return new String[]{ally};

        }

    }

}
