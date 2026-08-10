package tannyjung.tanscomplexmagic_handcode.core;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import tannyjung.tanscomplexmagic_core.game.EntityManager;
import tannyjung.tanscomplexmagic_core.game.GameUtils;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.GUIManager;
import tannyjung.tanscomplexmagic_handcode.systems.Book;
import tannyjung.tanscomplexmagic_handcode.systems.Spell1;
import tannyjung.tanscomplexmagic_handcode.systems.Utils;

public class Networks {

    public static void client (LocalPlayer player_local, String type, String work, CompoundTag extra) {



    }

    public static void server (ServerPlayer player_server, String type, String work, CompoundTag extra) {

        if (type.equals("book") == true) {

            {

                if (work.equals("close") == true) {

                    {

                        GameUtils.playSound((ServerLevel) player_server.level(), player_server.blockPosition(), 1.0, 10, "minecraft:item.book.page_turn");
                        GUIManager.close(player_server);

                    }

                } else if (work.equals("page_previous") == true) {

                    {

                        GameUtils.playSound((ServerLevel) player_server.level(), player_server.blockPosition(), 1.0, 10, "minecraft:item.book.page_turn");

                        int page = (int) NBTManager.Mob.getNumber(player_server, "gui", "id");
                        page = page - 2;

                        if (page < 1) {

                            page = 1;

                        }

                        NBTManager.Mob.setNumber(player_server, "gui", "id", page);

                    }

                } else if (work.equals("page_next") == true) {

                    {

                        GameUtils.playSound((ServerLevel) player_server.level(), player_server.blockPosition(), 1.0, 10, "minecraft:item.book.page_turn");
                        NBTManager.Mob.addNumber(player_server, "gui", "id", 2);

                    }

                } else if (work.equals("compass") == true) {

                    {

                        NBTManager.Mob.setNumber(player_server, "book", "compassX", player_server.getX());
                        NBTManager.Mob.setNumber(player_server, "book", "compassZ", player_server.getZ());

                    }

                } else if (work.equals("log") == true) {

                    {

                        if (NBTManager.Mob.getText(player_server, "book", "log").isEmpty() == true) {

                            NBTManager.Mob.setText(player_server, "book", "log", "mana");

                        } else if (NBTManager.Mob.getText(player_server, "book", "log").equals("mana") == true) {

                            NBTManager.Mob.setText(player_server, "book", "log", "action");

                        } else if (NBTManager.Mob.getText(player_server, "book", "log").equals("action") == true) {

                            NBTManager.Mob.setText(player_server, "book", "log", "warning");

                        } else {

                            NBTManager.Mob.setText(player_server, "book", "log", "");

                        }

                        Book.updateLog(player_server);

                    }

                }

            }

        } else if (type.equals("spell1") == true) {

            {

                if (work.equals("get_duration1") == true) {

                    if (Utils.trySpendMana(player_server, 1) == true) {

                        NBTManager.Mob.addNumber(player_server, "spell1", "card_duration_max1", 120);

                    }

                }

            }

        }

    }

    public static class Key {

        public static void client (ServerPlayer player_server, String work, CompoundTag extra) {



        }

        public static void server (ServerPlayer player_server, String work, CompoundTag extra) {

            if (work.equals("main_key") == true) {

                {

                    ServerLevel level_server = player_server.serverLevel();

                    if (NBTManager.Mob.getLogic(player_server, "main", "main_key") == true) {

                        NBTManager.Mob.setLogic(player_server, "main", "main_key", false);

                        Spell1.deactivate(level_server, player_server);

                        for (Entity entity : EntityManager.Get.fromEverywhere(level_server, "", Utils.Tag.convertSystemAll(player_server))) {

                            entity.discard();

                        }

                    } else {

                        NBTManager.Mob.setLogic(player_server, "main", "main_key", true);

                        Spell1.activate(level_server, player_server);

                    }

                }

            } else if (work.equals("test") == true) {

                {

                    NBTManager.Mob.setLogic(player_server, "spell1", "is_pause_all", NBTManager.Mob.getLogic(player_server, "spell1", "is_pause_all") == false);

                }

            }

        }

    }

}
