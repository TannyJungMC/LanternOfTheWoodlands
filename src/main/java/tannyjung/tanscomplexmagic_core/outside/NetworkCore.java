package tannyjung.tanscomplexmagic_core.outside;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.ScreenDrawing;
import tannyjung.tanscomplexmagic_handcode.core.Networks;

public class NetworkCore {

    public static class GUI {

        public static void client (LocalPlayer player, String work, CompoundTag extra) {

            if (work.equals("refresh") == true) {

                {

                    ScreenDrawing.refresh();

                }

            }

        }

        public static void server (ServerPlayer player_server, String work, CompoundTag extra) {

            if (work.equals("switch") == true) {

                {

                    String nbt_type = extra.getString("nbt_type");
                    String nbt_name = extra.getString("nbt_name");
                    NBTManager.Mob.setLogic(player_server, nbt_type, nbt_name, !NBTManager.Mob.getLogic(player_server, nbt_type, nbt_name));

                }

            } else if (work.equals("slider") == true) {

                {

                    String nbt_type = extra.getString("nbt_type");
                    String nbt_name = extra.getString("nbt_name");
                    double nbt_value = extra.getDouble("nbt_value");
                    NBTManager.Mob.setNumber(player_server, nbt_type, nbt_name, nbt_value);

                }

            } else if (work.equals("radio") == true) {

                {

                    String nbt_type = extra.getString("nbt_type");
                    String nbt_name = extra.getString("nbt_name");
                    String nbt_value = extra.getString("nbt_value");
                    NBTManager.Mob.setText(player_server, nbt_type, nbt_name, nbt_value);

                }

            } else if (work.equals("text_box") == true) {

                {

                    String nbt_type = extra.getString("nbt_type");
                    String nbt_name = extra.getString("nbt_name");
                    String nbt_value = extra.getString("nbt_value");
                    NBTManager.Mob.setText(player_server, nbt_type, nbt_name, nbt_value);

                }

            }

        }

    }

    public static class NBT {

        public static void client (LocalPlayer player, String work, CompoundTag extra) {

            if (work.equals("sync") == true) {

                {

                    player.getPersistentData().merge(extra);
                    ScreenDrawing.refresh();

                }

            }

        }

        public static void server (ServerPlayer player_server, String work, CompoundTag extra) {

            if (work.equals("sync_all") == true) {

                {

                    CompoundTag tag = new CompoundTag();
                    tag.put(Core.mod_id, player_server.getPersistentData().getCompound(Core.mod_id));
                    NetworkManager.runClientCore(player_server, "nbt", "sync", tag);

                }

            } else if (work.equals("sync_one") == true) {

                {

                    NetworkManager.runClientCore(player_server, "nbt", "sync", extra);

                }

            }

        }

    }

}