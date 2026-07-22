package tannyjung.tanscomplexmagic_core.outside;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;
import tannyjung.tanscomplexmagic_handcode.systems.NetworkReceiver;

public record NetworkSender(int room) implements CustomPacketPayload {

    @EventBusSubscriber
    public static class Register {

        @SubscribeEvent
        public static void register (FMLCommonSetupEvent event) {

            TanscomplexmagicMod.addNetworkMessage(NetworkSender.type, NetworkSender.stream, NetworkSender::handle);

        }

    }

    private static final Type<NetworkSender> type = new Type<>(ResourceLocation.fromNamespaceAndPath(TanscomplexmagicMod.MODID, "network"));
    private static final StreamCodec<RegistryFriendlyByteBuf, NetworkSender> stream = StreamCodec.of((RegistryFriendlyByteBuf buffer, NetworkSender data) -> buffer.writeInt(data.room), (RegistryFriendlyByteBuf buffer) -> new NetworkSender(buffer.readInt()));

    @Override
    public Type<NetworkSender> type () {

        return type;

    }

    private static void handle (NetworkSender data, IPayloadContext context) {

        context.enqueueWork(() -> send(context.player(), data.room));

    }

    public static void send (Player player, int room) {

        if (player.level().isClientSide == true) {

            PacketDistributor.sendToServer(new NetworkSender(room));

        }

        NetworkReceiver.get(player, room);

    }

}