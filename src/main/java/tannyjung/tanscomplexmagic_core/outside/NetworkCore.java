package tannyjung.tanscomplexmagic_core.outside;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.EffectManager;
import tannyjung.tanscomplexmagic_core.game.EntityManager;
import tannyjung.tanscomplexmagic_core.game.ItemManager;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.GUIScreen;
import tannyjung.tanscomplexmagic_core.game.screen.ScreenDrawing;
import tannyjung.tanscomplexmagic_handcode.systems.Utils;

import java.util.ArrayList;
import java.util.List;

public class NetworkCore {

    public static class GUI {

        public static void client (LocalPlayer player, String work, CompoundTag extra) {



        }

        public static void server (ServerPlayer player_server, String work, CompoundTag extra) {

            if (work.equals("switch") == true) {

                {

                    boolean is_item = extra.getBoolean("is_item");
                    String nbt_type = extra.getString("nbt_type");
                    String nbt_name = extra.getString("nbt_name");

                    if (is_item == true) {

                        ItemStack item = ItemManager.getSlot(player_server, EquipmentSlot.MAINHAND);
                        NBTManager.Item.setLogic(item, nbt_type, nbt_name, NBTManager.Item.getLogic(item, nbt_type, nbt_name) == false);

                    } else {

                        NBTManager.Mob.setLogic(player_server, nbt_type, nbt_name, NBTManager.Mob.getLogic(player_server, nbt_type, nbt_name) == false);

                    }

                }

            } else if (work.equals("slider") == true) {

                {

                    boolean is_item = extra.getBoolean("is_item");
                    String nbt_type = extra.getString("nbt_type");
                    String nbt_name = extra.getString("nbt_name");
                    double nbt_value = extra.getDouble("nbt_value");

                    if (is_item == true) {

                        ItemStack item = ItemManager.getSlot(player_server, EquipmentSlot.MAINHAND);
                        NBTManager.Item.setNumber(item, nbt_type, nbt_name, nbt_value);

                    } else {

                        NBTManager.Mob.setNumber(player_server, nbt_type, nbt_name, nbt_value);

                    }

                }

            } else if (work.equals("radio") == true) {

                {

                    boolean is_item = extra.getBoolean("is_item");
                    String nbt_type = extra.getString("nbt_type");
                    String nbt_name = extra.getString("nbt_name");
                    String nbt_value = extra.getString("nbt_value");

                    if (is_item == true) {

                        ItemStack item = ItemManager.getSlot(player_server, EquipmentSlot.MAINHAND);
                        NBTManager.Item.setText(item, nbt_type, nbt_name, nbt_value);

                    } else {

                        NBTManager.Mob.setText(player_server, nbt_type, nbt_name, nbt_value);

                    }

                }

            } else if (work.equals("text_box") == true) {

                {

                    boolean is_item = extra.getBoolean("is_item");
                    String nbt_type = extra.getString("nbt_type");
                    String nbt_name = extra.getString("nbt_name");
                    String nbt_value = extra.getString("nbt_value");

                    if (is_item == true) {

                        ItemStack item = ItemManager.getSlot(player_server, EquipmentSlot.MAINHAND);
                        NBTManager.Item.setText(item, nbt_type, nbt_name, nbt_value);

                    } else {

                        NBTManager.Mob.setText(player_server, nbt_type, nbt_name, nbt_value);

                    }

                }

            } else if (work.startsWith("board_entity_") == true) {

                {

                    ServerLevel level_server = player_server.serverLevel();
                    String nbt_tag = extra.getString("nbt_tag");

                    if (work.equals("board_entity_add") == true) {

                        ScreenDrawing.ComponentAdvance.BoardEntity.runAdd(level_server, player_server, nbt_tag);

                    } else if (work.equals("board_entity_clear") == true) {

                        ScreenDrawing.ComponentAdvance.BoardEntity.runClear(player_server, nbt_tag);

                    } else if (work.equals("board_entity_remove") == true) {

                        ScreenDrawing.ComponentAdvance.BoardEntity.runRemove(level_server, player_server, nbt_tag);

                    }

                    ScreenDrawing.ComponentAdvance.BoardEntity.runRefresh(level_server, player_server, nbt_tag);

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