package tannyjung.tanscomplexmagic_handcode.core;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.EntityManager;
import tannyjung.tanscomplexmagic_core.game.GameUtils;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.GUIManager;
import tannyjung.tanscomplexmagic_handcode.systems.Book;
import tannyjung.tanscomplexmagic_handcode.systems.Spell1;

public class Networks {

    public static void client (LocalPlayer player_local, String type, String work, CompoundTag extra) {



    }

    public static void server (ServerPlayer player_server, String type, String work, CompoundTag extra) {

        if (type.equals("book") == true) {

            {

                if (work.equals("close") == true) {

                    {

                        GameUtils.Misc.playSound((ServerLevel) player_server.level(), player_server.blockPosition(), 1.0, 0.75, "minecraft:item.book.page_turn");
                        GUIManager.close(player_server);

                    }

                } else if (work.equals("page_previous") == true) {

                    {

                        GameUtils.Misc.playSound((ServerLevel) player_server.level(), player_server.blockPosition(), 1.0, 0.75, "minecraft:item.book.page_turn");
                        NBTManager.Mob.addNumber(player_server, "gui", "id", -2);

                    }

                } else if (work.equals("page_next") == true) {

                    {

                        GameUtils.Misc.playSound((ServerLevel) player_server.level(), player_server.blockPosition(), 1.0, 0.75, "minecraft:item.book.page_turn");
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

        }

    }

    public static class Key {

        public static void client (ServerPlayer player_server, String work, CompoundTag extra) {



        }

        public static void server (ServerPlayer player_server, String work, CompoundTag extra) {

            if (work.equals("main_key") == true) {

                {

                    ServerLevel level_server = player_server.serverLevel();

                    if (NBTManager.Mob.getLogic(player_server, "status", "main_key") == true) {

                        NBTManager.Mob.setLogic(player_server, "status", "main_key", false);

                        Spell1.cancel(level_server);

                    } else {

                        NBTManager.Mob.setLogic(player_server, "status", "main_key", true);

                        Spell1.start(level_server, player_server);

                    }

                }

            } else if (work.equals("test") == true) {

                {

                    NBTManager.Mob.setLogic(player_server, "spell1", "is_enable_all", NBTManager.Mob.getLogic(player_server, "spell1", "is_enable_all") == false);

                }

            }

        }

    }

}
