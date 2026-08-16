package tannyjung.tanscomplexmagic_handcode;

import net.minecraft.server.level.ServerLevel;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.*;
import tannyjung.tanscomplexmagic_core.outside.*;
import tannyjung.tanscomplexmagic_core.outside.config.ConfigClassic;
import tannyjung.tanscomplexmagic_core.outside.config.ConfigDynamic;
import tannyjung.tanscomplexmagic_core.outside.config.CustomPackOrganizing;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Handcode {

    public static void start () {

        Core.syncModData(

                "Tan's Complex Magic",
                "tanscomplexmagic",
                "M",
                "",
                "",

                1,
                "",
                "",
                "",

                false,
                false

        );

    }

    public static void repairData (ServerLevel level_server) {



    }

    public static class Config {

        public static void repair (String start, String end) {



        }

        public static void apply (Map<String, String> data) {



        }

    }

    public static class DataMigration {

        public static void runConfig (String version) {



        }

        public static void runWorld (String version) {



        }

    }

}
