package tannyjung.tanscomplexmagic_handcode.core;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import tannyjung.tanscomplexmagic_core.game.EntityManager;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_handcode.systems.Book;
import tannyjung.tanscomplexmagic_handcode.systems.Spell1;

public class Loops {

    public static void tick (ServerLevel level_server) {

        for (ServerPlayer player_server : EntityManager.Population.filterPlayerServer(EntityManager.Population.getEverywhereStatic(level_server, "minecraft:player", "", new String[]{}))) {

            Spell1.loopTick(level_server, player_server);

        }

    }

    public static void second (ServerLevel level_server) {

        for (ServerPlayer player_server : EntityManager.Population.filterPlayerServer(EntityManager.Population.getEverywhereStatic(level_server, "minecraft:player", "", new String[]{}))) {

            // Mana Regeneration
            {

                if (NBTManager.Mob.getNumber(player_server, "main", "mana") < 150) {

                    if (NBTManager.Mob.getNumber(player_server, "main", "mana_charge") < 60) {

                        NBTManager.Mob.addNumber(player_server, "main", "mana_charge", 1, true);

                    } else {

                        NBTManager.Mob.setNumber(player_server, "main", "mana_charge", 1, true);
                        NBTManager.Mob.addNumber(player_server, "main", "mana", 1, true);

                        if (NBTManager.Mob.getNumber(player_server, "main", "mana") == 150) {

                            NBTManager.Mob.setNumber(player_server, "main", "mana_charge", 0, true);

                        }

                    }

                    Book.Log.update(player_server);

                }

            }

            Spell1.loopSecond(level_server, player_server);

        }

    }

    public static void minute (ServerLevel level_server) {



    }

}
