package tannyjung.tanscomplexmagic_handcode.core;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import tannyjung.tanscomplexmagic_core.game.EntityManager;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_handcode.systems.Book;
import tannyjung.tanscomplexmagic_handcode.systems.Spell1;

public class Loops {

    public static void tick (ServerLevel level_server) {

        for (Entity user : EntityManager.Get.fromEverywhere(level_server, "minecraft:player", new String[]{})) {

            Spell1.loopTick(level_server, (ServerPlayer) user);

        }

    }

    public static void second (ServerLevel level_server) {

        for (Entity user : EntityManager.Get.fromEverywhere(level_server, "minecraft:player", new String[]{})) {

            // Mana Regeneration
            {

                if (NBTManager.Mob.getNumber(user, "status", "mana") < 150) {

                    if (NBTManager.Mob.getNumber(user, "status", "mana_charge") < 60) {

                        NBTManager.Mob.addNumber(user, "status", "mana_charge", 1);

                    } else {

                        NBTManager.Mob.setNumber(user, "status", "mana_charge", 1);
                        NBTManager.Mob.addNumber(user, "status", "mana", 1);

                        if (NBTManager.Mob.getNumber(user, "status", "mana") == 150) {

                            NBTManager.Mob.setNumber(user, "status", "mana_charge", 0);

                        }

                    }

                    Book.updateLog((ServerPlayer) user);

                } else {

                    NBTManager.Mob.setNumber(user, "status", "mana", 0);

                }

            }

            Spell1.loopSecond(level_server, (ServerPlayer) user);

        }

    }

    public static void minute (ServerLevel level_server) {



    }

}
