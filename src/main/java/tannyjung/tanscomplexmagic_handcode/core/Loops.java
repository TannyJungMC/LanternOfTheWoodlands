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

                    if (NBTManager.Mob.getNumber(user, "main", "mana") < 150) {

                        if (NBTManager.Mob.getNumber(user, "main", "mana_charge") < 60) {

                            NBTManager.Mob.addNumber(user, "main", "mana_charge", 1);

                        } else {

                            NBTManager.Mob.setNumber(user, "main", "mana_charge", 1);
                            NBTManager.Mob.addNumber(user, "main", "mana", 1);

                            if (NBTManager.Mob.getNumber(user, "main", "mana") == 150) {

                                NBTManager.Mob.setNumber(user, "main", "mana_charge", 0);

                            }

                        }

                        Book.updateLog(player_server);

                    }

                }














                String tag_ally = Utils.Tag.getAlly(player_server);

                for (Entity scan : EntityManager.Population.getEverywhereUpdatable(level_server, "", "", Utils.Tag.convertAlly(player_server))) {

                    scan.removeTag(tag_ally);

                }

                List<String> list_name = new ArrayList<>();
                Entity entity = null;
                StringBuilder builder = new StringBuilder();
                int number = 0;

                String[] split = new String[]{};
                String uuid = null;
                String id = "";
                String name = "";

                for (String scan : NBTManager.Mob.ListText.get(player_server, "main", "ally_list")) {

                    number = number + 1;

                    // Split
                    {

                        split = scan.split("///");

                        try {

                            uuid = split[0];
                            id = split[1];
                            name = split[2];

                        } catch (Exception ignored) {

                            continue;

                        }

                    }

                    entity = EntityManager.getByUUID(level_server, uuid);

                    if (entity == null) {

                        builder.append("§c").append(name);

                    } else {

                        if (entity instanceof ServerPlayer == true) {

                            builder.append("§a");

                        } else if (entity.hasCustomName() == true) {

                            builder.append("§d");

                        } else {

                            builder.append("§f");

                        }

                        builder.append(name);
                        entity.addTag(tag_ally);

                    }

                    builder.append(" §8(").append(number).append(")");
                    list_name.add(builder.toString());
                    builder.setLength(0);

                }

                NBTManager.Mob.ListText.set(player_server, "main", "ally_list_board", list_name);





                for (Entity scan : EntityManager.Population.getEverywhereUpdatable(level_server, "", "", Utils.Tag.convertAlly(player_server))) {

                    EffectManager.giveBasic(level_server, scan, "glowing", 1, 25);

                }

            }

        }

    }

    public static void minute (ServerLevel level_server) {



    }

}
