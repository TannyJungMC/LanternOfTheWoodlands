package tannyjung.tanscomplexmagic_core.outside;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;
import tannyjung.tanscomplexmagic_handcode.systems.NetworkWorks;

public record NetworkManager (CompoundTag tag) implements CustomPacketPayload {

    private static final Type<NetworkManager> type = new Type<>(ResourceLocation.fromNamespaceAndPath(TanscomplexmagicMod.MODID, "network"));
    private static final StreamCodec<RegistryFriendlyByteBuf, NetworkManager> stream = StreamCodec.of((RegistryFriendlyByteBuf buffer, NetworkManager data) -> buffer.writeNbt(data.tag), (RegistryFriendlyByteBuf buffer) -> new NetworkManager(buffer.readNbt()));

    @EventBusSubscriber
    public static class Event {

        @SubscribeEvent
        public static void register (FMLCommonSetupEvent event) {

            TanscomplexmagicMod.addNetworkMessage(NetworkManager.type, NetworkManager.stream, NetworkManager::receive);

        }

    }

    @Override
    public Type<NetworkManager> type () {

        return type;

    }

    private static void receive (NetworkManager data, IPayloadContext context) {

        Player player = context.player();
        boolean is_client = player.level().isClientSide;
        boolean is_core = data.tag.getBoolean("is_core");
        String type = data.tag.getString("type");
        String work = data.tag.getString("work");
        CompoundTag extra = data.tag.getCompound("extra");

        if (is_core == true) {

            NetworkWorksCore.sorting(player, type, work, extra);

        } else {

            if (is_client == true) {

                NetworkWorks.client(player, type, work, extra);

            } else {

                NetworkWorks.server(player, type, work, extra);

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

            // NetworkWorks.sorting(player, type, work, extra);

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

            // NetworkWorks.sorting(player, type, work, extra);

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

            NetworkWorksCore.sorting(player, type, work, extra);

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

            NetworkWorksCore.sorting(player, type, work, extra);

        }

    }

}