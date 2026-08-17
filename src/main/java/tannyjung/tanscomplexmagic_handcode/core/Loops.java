package tannyjung.tanscomplexmagic_handcode.core;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import tannyjung.tanscomplexmagic_core.game.EffectManager;
import tannyjung.tanscomplexmagic_core.game.EntityManager;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_handcode.systems.Book;
import tannyjung.tanscomplexmagic_handcode.systems.Spell1;
import tannyjung.tanscomplexmagic_handcode.systems.Utils;

import java.util.ArrayList;
import java.util.List;

public class Loops {

    public static void tick (ServerLevel level_server) {

        for (Entity user : EntityManager.Population.getEverywhereStatic(level_server, "minecraft:player", "", new String[]{})) {

            Spell1.tick(level_server, (ServerPlayer) user);

        }

    }

    public static void second (ServerLevel level_server) {

        for (Entity user : EntityManager.Population.getEverywhereStatic(level_server, "minecraft:player", "", new String[]{})) {

            if (user instanceof ServerPlayer player_server) {

                // Mana Regeneration
                {

                    if (NBTManager.Mob.getNumber(player_server, "main", "mana") < 150) {

                        if (NBTManager.Mob.getNumber(player_server, "main", "mana_charge") < 60) {

                            NBTManager.Mob.addNumber(player_server, "main", "mana_charge", 1);

                        } else {

                            NBTManager.Mob.setNumber(player_server, "main", "mana_charge", 1);
                            NBTManager.Mob.addNumber(player_server, "main", "mana", 1);

                            if (NBTManager.Mob.getNumber(player_server, "main", "mana") == 150) {

                                NBTManager.Mob.setNumber(player_server, "main", "mana_charge", 0);

                            }

                        }

                        Book.Log.update(player_server);

                    }

                }

            }

        }

    }

    public static void minute (ServerLevel level_server) {



    }

}
