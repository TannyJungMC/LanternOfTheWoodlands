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
import tannyjung.tanscomplexmagic_core.game.screen.ScreenDrawing;

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

                    String nbt_tag = extra.getString("nbt_tag");
                    String type = "gui";
                    String name = "board_entity_" + nbt_tag;

                    if (work.equals("board_entity_refresh") == true) {

                        {

                            ServerLevel level_server = player_server.serverLevel();

                            for (Entity scan : EntityManager.Population.getEverywhereUpdatable(level_server, "", "", new String[]{nbt_tag})) {

                                scan.removeTag(nbt_tag);

                            }

                            List<String> list = new ArrayList<>();
                            StringBuilder builder = new StringBuilder();
                            Entity entity = null;
                            int number = 1;

                            String[] split = new String[]{};
                            String split_uuid = null;
                            String split_name = "";

                            for (String scan : NBTManager.Mob.ListText.get(player_server, type, name)) {

                                // Split
                                {

                                    split = scan.split("///");

                                    try {

                                        split_uuid = split[0];
                                        split_name = split[2];

                                    } catch (Exception ignored) {

                                        continue;

                                    }

                                }

                                entity = EntityManager.getByUUID(level_server, split_uuid);

                                if (entity == null) {

                                    builder.append("§c");

                                } else {

                                    if (entity instanceof ServerPlayer == true) {

                                        builder.append("§a");

                                    } else if (entity.hasCustomName() == true) {

                                        builder.append("§d");

                                    } else {

                                        builder.append("§f");

                                    }

                                    entity.addTag(nbt_tag);



                                    EffectManager.giveBasic(level_server, entity, "glowing", 1, 60);




                                }

                                builder.append(split_name).append(" §8(").append(number).append(")");
                                list.add(builder.toString());
                                builder.setLength(0);
                                number = number + 1;

                            }

                            NBTManager.Mob.ListText.set(player_server, type, name + "_show", list);

                        }

                    } else {

                        if (work.equals("board_entity_clear") == true) {

                            {

                                NBTManager.Mob.ListText.set(player_server, type, name, new ArrayList<>());

                            }

                        } else if (work.equals("board_entity_remove") == true) {

                            {

                                String target_id = NBTManager.Mob.getText(player_server, type, name + "_id");
                                String target_name = NBTManager.Mob.getText(player_server, type, name + "_name");

                                List<String> list = new ArrayList<>();
                                String[] split = new String[]{};
                                String split_id = "";
                                String split_name = "";

                                for (String scan : NBTManager.Mob.ListText.get(player_server, type, name)) {

                                    try {

                                        split = scan.split("///");
                                        split_id = split[1];
                                        split_name = split[2];

                                    } catch (Exception ignored) {

                                        continue;

                                    }

                                    if (target_id.isEmpty() == false && split_id.equals(target_id) == false) {

                                        continue;

                                    }

                                    if (target_name.isEmpty() == false && split_name.equals(target_name) == false) {

                                        continue;

                                    }

                                    list.add(scan);

                                }

                                NBTManager.Mob.ListText.removeMultiple(player_server, type, name, list);

                            }

                        } else if (work.equals("board_entity_remove_select") == true) {

                            {

                                int page = (int) NBTManager.Mob.getNumber(player_server, type, name + "_show_page");
                                int select = (int) NBTManager.Mob.getNumber(player_server, type, name + "_show_select");

                                if (select == 0) {

                                    return;

                                }

                                int number = (page * 18) + select;
                                NBTManager.Mob.ListText.removeByNumber(player_server, type, name, number - 1);

                            }

                        } else if (work.equals("board_entity_add") == true) {

                            {

                                String target_id = NBTManager.Mob.getText(player_server, type, name + "_id");
                                String target_name = NBTManager.Mob.getText(player_server, type, name + "_name");
                                int radius = (int) NBTManager.Mob.getNumber(player_server, type, name + "_radius");
                                List<String> list = new ArrayList<>();

                                for (Entity entity : EntityManager.Population.sort(EntityManager.Population.getArea(player_server.serverLevel(), player_server.position(), radius, false, target_id, target_name, new String[]{}), player_server.position(), false, 0)) {

                                    list.add(entity.getStringUUID() + "///" + EntityManager.getID(entity) + "///" + entity.getDisplayName().getString());

                                }

                                NBTManager.Mob.ListText.addMultiple(player_server, type, name, list);

                            }

                        }

                        NetworkManager.runServerCore(player_server, "gui", "board_entity_refresh", extra);

                    }

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