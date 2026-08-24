package tannyjung.tanscomplexmagic_handcode.core;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import tannyjung.tanscomplexmagic_core.game.EntityManager;
import tannyjung.tanscomplexmagic_core.game.GameUtils;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_handcode.systems.BasicSpells;
import tannyjung.tanscomplexmagic_handcode.systems.Book;
import tannyjung.tanscomplexmagic_handcode.systems.Spell1;
import tannyjung.tanscomplexmagic_handcode.systems.Utils;

public class Loops {

    public static void tick (ServerLevel level_server) {

        for (ServerPlayer player_server : EntityManager.Population.filterPlayerServer(EntityManager.Population.getEverywhereStatic(level_server, "minecraft:player", "", new String[]{}))) {

            // Placed User Book
            {

                for (Entity entity : EntityManager.Population.getEverywhereStatic(level_server, "", "", Utils.Tag.convertSystemSpecific(player_server, new String[]{"placed_book"}))) {

                    Book.Placing.tick(level_server, player_server, entity);

                }

            }

            BasicSpells.loopTick(level_server, player_server);
            Spell1.loopTick(level_server, player_server);

        }

    }

    public static void second (ServerLevel level_server) {

        for (ServerPlayer player_server : EntityManager.Population.filterPlayerServer(EntityManager.Population.getEverywhereStatic(level_server, "minecraft:player", "", new String[]{}))) {

            Book.Log.update(player_server);

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

                }

            }

            BasicSpells.loopSecond(level_server, player_server);
            Spell1.loopSecond(level_server, player_server);

        }

    }

}
