package tannyjung.tanscomplexmagic_core.outside;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;
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

        sorting(player, is_core, is_client, type, work, extra);

    }

    public static void sorting (Player player, boolean is_core, boolean is_client, String type, String work, CompoundTag extra) {

        if (is_core == true) {

            if (type.equals("gui") == true) {

                {

                    if (is_client == true) {

                        NetworkCore.GUI.client((LocalPlayer) player, work, extra);

                    } else {

                        NetworkCore.GUI.server((ServerPlayer) player, work, extra);

                    }

                }

            } else if (type.equals("nbt") == true) {

                {

                    if (is_client == true) {

                        NetworkCore.NBT.client((LocalPlayer) player, work, extra);

                    } else {

                        NetworkCore.NBT.server((ServerPlayer) player, work, extra);

                    }

                }

            }

        } else {

            if (type.equals("key") == true) {

                {

                    if (is_client == true) {

                        Networks.Key.client((ServerPlayer) player, work, extra);

                    } else {

                        Networks.Key.server((ServerPlayer) player, work, extra);

                    }

                }

            } else {

                if (is_client == true) {

                    Networks.client((LocalPlayer) player, type, work, extra);

                } else {

                    Networks.server((ServerPlayer) player, type, work, extra);

                }

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

            sorting(player, false, true, type, work, extra);

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

            sorting(player, false, false, type, work, extra);

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

            sorting(player, true, true, type, work, extra);

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

            sorting(player, true, false, type, work, extra);

        }

    }

}