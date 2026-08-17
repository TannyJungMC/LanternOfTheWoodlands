package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import tannyjung.tanscomplexmagic_core.game.GameUtils;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.GUIManager;
import tannyjung.tanscomplexmagic_core.outside.OutsideUtils;

public class Book {

    public static void whenRightClick (Entity entity) {

        if (entity instanceof ServerPlayer player_server) {

            String group = NBTManager.Mob.getText(player_server, "gui", "group");
            String name = NBTManager.Mob.getText(player_server, "gui", "name");

            if (group.isEmpty() == true || name.isEmpty() == true) {

                group = "book";
                name = "ally_list";

            }

            GUIManager.open(player_server, group, name);

        }

    }

    public static void pageTurn (ServerPlayer player_server, boolean is_next) {

        String group = NBTManager.Mob.getText(player_server, "gui", "group");
        String name = NBTManager.Mob.getText(player_server, "gui", "name");

        if (is_next == true) {

            name = GUIManager.Storage.getNameNext(group, name);

        } else {

            name = GUIManager.Storage.getNamePrevious(group, name);

        }

        if (name.isEmpty() == true) {

            return;

        }

        GUIManager.open(player_server, group, name);
        GameUtils.playSound((ServerLevel) player_server.level(), player_server.blockPosition(), 1.0, 10, "minecraft:item.book.page_turn");

    }

    public static class Log {

        public static void setType (ServerPlayer player_server) {

            if (NBTManager.Mob.getText(player_server, "book", "log").isEmpty() == true) {

                NBTManager.Mob.setText(player_server, "book", "log", "mana");

            } else if (NBTManager.Mob.getText(player_server, "book", "log").equals("mana") == true) {

                NBTManager.Mob.setText(player_server, "book", "log", "action");

            } else if (NBTManager.Mob.getText(player_server, "book", "log").equals("action") == true) {

                NBTManager.Mob.setText(player_server, "book", "log", "warning");

            } else {

                NBTManager.Mob.setText(player_server, "book", "log", "");

            }

            update(player_server);

        }

        public static void update (ServerPlayer player_server) {

            String type = NBTManager.Mob.getText(player_server, "book", "log");
            String text = "";

            if (type.equals("mana") == true) {

                int mana = (int) NBTManager.Mob.getNumber(player_server, "main", "mana");
                int mana_charge = (int) NBTManager.Mob.getNumber(player_server, "main", "mana_charge");
                String time = "";

                if (mana != 150) {

                    time = " - Full in " + OutsideUtils.Calculation.convertSecondToTime(((150 - mana) * 60) + (60 - mana_charge));

                }

                text = "§eMana " + mana + "/150 Charge " + mana_charge + "/60" + time;

            } else if (type.equals("action") == true) {

                text = "§a23 - Set new custom compass location";

            } else if (type.equals("warning") == true) {

                text = "§c17 - Detected enemy in radius of buoy \"Beach 11\"";

            }

            NBTManager.Mob.setText(player_server, "book", "log_text", text);

        }

    }

}
