package tannyjung.tanscomplexmagic_handcode.core;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import tannyjung.tanscomplexmagic_core.game.GameUtils;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.GUIManager;
import tannyjung.tanscomplexmagic_handcode.systems.Book;
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

                        Book.pageTurn(player_server, false);

                    }

                } else if (work.equals("page_next") == true) {

                    {

                        Book.pageTurn(player_server, true);

                    }

                } else if (work.equals("custom_compass_set") == true) {

                    {

                        NBTManager.Mob.setNumber(player_server, "book", "compassX", player_server.getX(), true);
                        NBTManager.Mob.setNumber(player_server, "book", "compassZ", player_server.getZ(), true);

                    }

                } else if (work.equals("log") == true) {

                    {

                        Book.Log.setType(player_server);

                    }

                }

            }

        } else if (type.equals("spell1") == true) {

            {

                if (work.startsWith("get_duration_") == true) {

                    {

                        work = work.substring("get_duration_".length());
                        String positive_negative = "";

                        if (work.startsWith("positive") == true) {

                            positive_negative = "positive";

                        } else {

                            positive_negative = "negative";

                        }

                        int number = Integer.parseInt(work.substring(positive_negative.length()));

                        if (Utils.trySpendMana(player_server, 1) == true) {

                            int duration_per_mana = extra.getInt("duration_per_mana_" + positive_negative);
                            NBTManager.Mob.addNumber(player_server, "spell1", "card_duration_max_" + positive_negative + number, duration_per_mana, true);

                        }

                    }

                }

            }

        }

    }

}
