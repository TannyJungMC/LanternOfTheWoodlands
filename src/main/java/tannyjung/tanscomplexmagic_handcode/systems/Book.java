package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import tannyjung.tanscomplexmagic.init.TanscomplexmagicModItems;
import tannyjung.tanscomplexmagic.item.UserBookItem;
import tannyjung.tanscomplexmagic.item.UserBookOpenItem;
import tannyjung.tanscomplexmagic_core.game.GameUtils;
import tannyjung.tanscomplexmagic_core.game.ItemManager;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.GUIManager;
import tannyjung.tanscomplexmagic_core.outside.OutsideUtils;

public class Book {

    public static void whenRightClick (ServerPlayer player_server) {

        ItemStack item = ItemManager.getSlot(player_server, EquipmentSlot.MAINHAND);
        boolean is_main_key_active = NBTManager.Mob.getLogic(player_server, "main", "is_main_key_active");

        if (item.getItem() == TanscomplexmagicModItems.USER_BOOK.asItem()) {

            if (is_main_key_active == true) {

                player_server.setItemSlot(EquipmentSlot.MAINHAND, TanscomplexmagicModItems.USER_BOOK_OPEN.toStack());

            }

            return;

        } else if (item.getItem() == TanscomplexmagicModItems.USER_BOOK_OPEN.asItem()) {

            if (is_main_key_active == true) {

                player_server.setItemSlot(EquipmentSlot.MAINHAND, TanscomplexmagicModItems.USER_BOOK.toStack());
                return;

            }

        }

        String page = NBTManager.Item.getText(item, "main", "page");

        if (page.isEmpty() == true) {

            page = "ally_list";
            NBTManager.Item.setText(item, "main", "page", page);

        }

        GUIManager.open(player_server, "book", page);

    }

    public static void pageTurn (ServerPlayer player_server, boolean is_next) {

        ItemStack item = ItemManager.getSlot(player_server, EquipmentSlot.MAINHAND);
        String page = NBTManager.Item.getText(item, "main", "page");

        if (is_next == true) {

            page = GUIManager.Storage.getNameNext("book", page);

        } else {

            page = GUIManager.Storage.getNamePrevious("book", page);

        }

        if (page.isEmpty() == true) {

            return;

        }

        NBTManager.Item.setText(item, "main", "page", page);
        GUIManager.open(player_server, "book", page);
        GameUtils.playSound((ServerLevel) player_server.level(), player_server.blockPosition(), 1.0, 10, "minecraft:item.book.page_turn");

    }

    public static class Log {

        public static void setType (ServerPlayer player_server) {

            if (NBTManager.Mob.getText(player_server, "book", "log").isEmpty() == true) {

                NBTManager.Mob.setText(player_server, "book", "log", "mana", true);

            } else if (NBTManager.Mob.getText(player_server, "book", "log").equals("mana") == true) {

                NBTManager.Mob.setText(player_server, "book", "log", "action", true);

            } else if (NBTManager.Mob.getText(player_server, "book", "log").equals("action") == true) {

                NBTManager.Mob.setText(player_server, "book", "log", "warning", true);

            } else {

                NBTManager.Mob.setText(player_server, "book", "log", "", true);

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

            NBTManager.Mob.setText(player_server, "book", "log_text", text, true);

        }

    }

}
