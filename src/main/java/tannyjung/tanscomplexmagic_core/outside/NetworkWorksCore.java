package tannyjung.tanscomplexmagic_core.outside;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.GameUtils;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.ScreenDrawing;

public class NetworkWorksCore {

    public static void sorting (Player player, String type, String work, CompoundTag extra) {

        boolean is_client = player.level().isClientSide;

        if (type.equals("gui") == true) {

            {

                if (is_client == true) {

                    GUI.client((LocalPlayer) player, work, extra);

                } else {

                    GUI.server((ServerPlayer) player, work, extra);

                }

            }

        } else if (type.equals("nbt") == true) {

            {

                if (is_client == true) {

                    NBT.client((LocalPlayer) player, work, extra);

                } else {

                    NBT.server((ServerPlayer) player, work, extra);

                }

            }

        }

    }

    private static class GUI {

        private static void client (LocalPlayer player, String work, CompoundTag extra) {

            if (work.equals("refresh") == true) {

                {

                    ScreenDrawing.refresh();

                }

            }

        }

        private static void server (ServerPlayer player, String work, CompoundTag extra) {

            if (work.equals("switch") == true) {

                {

                    String nbt_type = extra.getString("nbt_type");
                    String nbt_name = extra.getString("nbt_name");
                    NBTManager.setEntityLogic(player, nbt_type, nbt_name, !NBTManager.getEntityLogic(player, nbt_type, nbt_name));

                }

            } else if (work.equals("slider") == true) {

                {

                    String nbt_type = extra.getString("nbt_type");
                    String nbt_name = extra.getString("nbt_name");
                    double nbt_value = extra.getDouble("nbt_value");
                    NBTManager.setEntityNumber(player, nbt_type, nbt_name, nbt_value);

                }

            } else if (work.equals("radio") == true) {

                {

                    String nbt_type = extra.getString("nbt_type");
                    String nbt_name = extra.getString("nbt_name");
                    String nbt_value = extra.getString("nbt_value");
                    NBTManager.setEntityText(player, nbt_type, nbt_name, nbt_value);

                }

            } else if (work.equals("text_box") == true) {

                {

                    String nbt_type = extra.getString("nbt_type");
                    String nbt_name = extra.getString("nbt_name");
                    String nbt_value = extra.getString("nbt_value");
                    NBTManager.setEntityText(player, nbt_type, nbt_name, nbt_value);

                }

            }

        }

    }

    private static class NBT {

        private static void client (LocalPlayer player, String work, CompoundTag extra) {

            if (work.equals("sync") == true) {

                {

                    player.getPersistentData().merge(extra);
                    ScreenDrawing.refresh();

                }

            }

        }

        private static void server (ServerPlayer player, String work, CompoundTag extra) {

            if (work.equals("sync_all") == true) {

                {

                    CompoundTag tag = new CompoundTag();
                    tag.put(Core.mod_id, player.getPersistentData().getCompound(Core.mod_id));
                    NetworkManager.runClientCore(player, "nbt", "sync", tag);

                }

            } else if (work.equals("sync_one") == true) {

                {

                    NetworkManager.runClientCore(player, "nbt", "sync", extra);

                }

            }

        }

    }

}