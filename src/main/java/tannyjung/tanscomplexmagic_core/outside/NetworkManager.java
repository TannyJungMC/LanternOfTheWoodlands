package tannyjung.tanscomplexmagic_core.outside;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.ItemManager;
import tannyjung.tanscomplexmagic_core.game.KeyBindingMaker;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.ScreenDrawing;
import tannyjung.tanscomplexmagic_handcode.core.Networks;

public record NetworkManager (CompoundTag tag) implements CustomPacketPayload {

    public static final Type<NetworkManager> type = new Type<>(ResourceLocation.fromNamespaceAndPath(TanscomplexmagicMod.MODID, "network"));
    public static final StreamCodec<RegistryFriendlyByteBuf, NetworkManager> stream = StreamCodec.of((RegistryFriendlyByteBuf buffer, NetworkManager data) -> buffer.writeNbt(data.tag), (RegistryFriendlyByteBuf buffer) -> new NetworkManager(buffer.readNbt()));

    @Override
    public Type<NetworkManager> type () {

        return type;

    }

    public static void receive (NetworkManager data, IPayloadContext context) {

        Player player = context.player();
        boolean is_core = data.tag.getBoolean("is_core");
        boolean is_client = player.level().isClientSide;
        String type = data.tag.getString("type");
        String work = data.tag.getString("work");
        CompoundTag extra = data.tag.getCompound("extra");

        sort(player, is_core, is_client, type, work, extra);

    }

    public static void sort (Player player, boolean is_core, boolean is_client, String type, String work, CompoundTag extra) {

        if (is_core == true) {

            if (is_client == true) {

                BuiltIn.client((LocalPlayer) player, type, work, extra);

            } else {

                BuiltIn.server((ServerPlayer) player, type, work, extra);

            }

        } else {

            if (is_client == true) {

                Networks.client((LocalPlayer) player, type, work, extra);

            } else {

                Networks.server((ServerPlayer) player, type, work, extra);

            }

        }

    }

    public static void runClient (Player player, String type, String work, CompoundTag extra) {

        CompoundTag data = new CompoundTag();
        data.putBoolean("is_core", false);
        data.putString("type", type);
        data.putString("work", work);
        data.put("extra", extra);

        if (player instanceof ServerPlayer player_server) {

            PacketDistributor.sendToPlayer(player_server, new NetworkManager(data));

        } else {

            sort(player, false, true, type, work, extra);

        }

    }

    public static void runServer (Player player, String type, String work, CompoundTag extra) {

        CompoundTag data = new CompoundTag();
        data.putBoolean("is_core", false);
        data.putString("type", type);
        data.putString("work", work);
        data.put("extra", extra);

        if (player instanceof LocalPlayer) {

            PacketDistributor.sendToServer(new NetworkManager(data));

        } else {

            sort(player, false, false, type, work, extra);

        }

    }

    public static void runClientCore (Player player, String type, String work, CompoundTag extra) {

        CompoundTag data = new CompoundTag();
        data.putBoolean("is_core", true);
        data.putString("type", type);
        data.putString("work", work);
        data.put("extra", extra);

        if (player instanceof ServerPlayer player_server) {

            PacketDistributor.sendToPlayer(player_server, new NetworkManager(data));

        } else {

            sort(player, true, true, type, work, extra);

        }

    }

    public static void runServerCore (Player player, String type, String work, CompoundTag extra) {

        CompoundTag data = new CompoundTag();
        data.putBoolean("is_core", true);
        data.putString("type", type);
        data.putString("work", work);
        data.put("extra", extra);

        if (player instanceof LocalPlayer) {

            PacketDistributor.sendToServer(new NetworkManager(data));

        } else {

            sort(player, true, false, type, work, extra);

        }

    }

    private static class BuiltIn {

        private static void client (LocalPlayer player_local, String type, String work, CompoundTag extra) {

            if (type.equals("nbt") == true) {

                {

                    if (work.equals("sync") == true) {

                        NBTManager.Mob.merge(player_local, extra, false);

                    } else if (work.equals("sync_list_add") == true) {

                        {

                            String nbt_type = extra.getString("nbt_type");
                            String nbt_name = extra.getString("nbt_name");
                            ListTag nbt_value = extra.getList("nbt_value", ListTag.TAG_STRING);
                            NBTManager.Mob.addList(player_local, nbt_type, nbt_name, nbt_value, false);

                        }

                    }

                    ScreenDrawing.refresh();

                }

            }

        }

        private static void server (ServerPlayer player_server, String type, String work, CompoundTag extra) {

            if (type.equals("gui") == true) {

                {

                    if (work.equals("switch") == true) {

                        {

                            boolean is_item = extra.getBoolean("is_item");
                            String nbt_type = extra.getString("nbt_type");
                            String nbt_name = extra.getString("nbt_name");

                            if (is_item == true) {

                                ItemStack item = ItemManager.getSlot(player_server, EquipmentSlot.MAINHAND);
                                NBTManager.Item.setLogic(item, nbt_type, nbt_name, NBTManager.Item.getLogic(item, nbt_type, nbt_name) == false);

                            } else {

                                NBTManager.Mob.setLogic(player_server, nbt_type, nbt_name, NBTManager.Mob.getLogic(player_server, nbt_type, nbt_name) == false, true);

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

                                NBTManager.Mob.setNumber(player_server, nbt_type, nbt_name, nbt_value, true);

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

                                NBTManager.Mob.setText(player_server, nbt_type, nbt_name, nbt_value, true);

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

                                NBTManager.Mob.setText(player_server, nbt_type, nbt_name, nbt_value, true);

                            }

                        }

                    } else if (work.startsWith("board_entity_") == true) {

                        {

                            ServerLevel level_server = player_server.serverLevel();
                            String nbt_tag = extra.getString("nbt_tag");

                            if (work.equals("board_entity_add") == true) {

                                ScreenDrawing.ComponentAdvance.Board.ListEntity.runAdd(player_server, nbt_tag);

                            } else if (work.equals("board_entity_clear") == true) {

                                ScreenDrawing.ComponentAdvance.Board.ListEntity.runClear(player_server, nbt_tag);

                            } else if (work.equals("board_entity_remove") == true) {

                                ScreenDrawing.ComponentAdvance.Board.ListEntity.runRemove(level_server, player_server, nbt_tag);

                            }

                            ScreenDrawing.ComponentAdvance.Board.ListEntity.runRefresh(level_server, player_server, nbt_tag);

                        }

                    }

                }

            } else if (type.equals("nbt") == true) {

                {

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

            } else if (type.equals("key") == true) {

                {

                    String name = extra.getString("name");
                    KeyBindingMaker.Storage.run(player_server, work, name);

                }

            }

        }

    }

}