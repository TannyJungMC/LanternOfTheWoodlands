package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import tannyjung.tanscomplexmagic_core.game.GameUtils;
import tannyjung.tanscomplexmagic_core.game.NBTManager;

public class NetworkWorks {

    public static void client (Player player, String type, String work, CompoundTag extra) {



    }

    public static void server (Player player, String type, String work, CompoundTag extra) {

        if (type.equals("book") == true) {

            if (work.equals("page_previous") == true) {

                {

                    NBTManager.addEntityNumber(player, "gui", "id", -1);
                    GameUtils.Misc.playSound((ServerLevel) player.level(), player.blockPosition(), 1.0, 0.75, "minecraft:item.book.page_turn");

                }

            } else if (work.equals("page_next") == true) {

                {

                    NBTManager.addEntityNumber(player, "gui", "id", 1);
                    GameUtils.Misc.playSound((ServerLevel) player.level(), player.blockPosition(), 1.0, 0.75, "minecraft:item.book.page_turn");

                }

            }

        }

    }

}
