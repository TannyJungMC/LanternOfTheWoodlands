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
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.GUIMaker;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_handcode.systems.NetworkWorks;

public record NetworkManager(CompoundTag tag) implements CustomPacketPayload {

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

    public static void runClient (ServerPlayer player, String type, String work, CompoundTag extra) {

        CompoundTag data = new CompoundTag();
        data.putBoolean("is_core", false);
        data.putString("type", type);
        data.putString("work", work);
        data.put("extra", extra);
        PacketDistributor.sendToPlayer(player, new NetworkManager(data));

    }

    public static void runServer (LocalPlayer player, String type, String work, CompoundTag extra) {

        CompoundTag data = new CompoundTag();
        data.putBoolean("is_core", false);
        data.putString("type", type);
        data.putString("work", work);
        data.put("extra", extra);
        PacketDistributor.sendToServer(new NetworkManager(data));

    }

    public static void runClientCore (ServerPlayer player, String type, String work, CompoundTag extra) {

        CompoundTag data = new CompoundTag();
        data.putBoolean("is_core", true);
        data.putString("type", type);
        data.putString("work", work);
        data.put("extra", extra);
        PacketDistributor.sendToPlayer(player, new NetworkManager(data));

    }

    public static void runServerCore (LocalPlayer player, String type, String work, CompoundTag extra) {

        CompoundTag data = new CompoundTag();
        data.putBoolean("is_core", true);
        data.putString("type", type);
        data.putString("work", work);
        data.put("extra", extra);
        PacketDistributor.sendToServer(new NetworkManager(data));

    }

    private static void receive (NetworkManager data, IPayloadContext context) {

        Player player = context.player();
        boolean is_client = player.level().isClientSide;
        boolean is_core = data.tag.getBoolean("is_core");
        String type = data.tag.getString("type");
        String work = data.tag.getString("work");
        CompoundTag extra = data.tag.getCompound("extra");

        if (is_core == true) {

            Works.sorting(player, type, work, extra);

        } else {

            if (is_client == true) {

                NetworkWorks.client(player, work);

            } else {

                NetworkWorks.server(player, work);

            }

        }

    }

    private static class Works {

        private static void sorting (Player player, String type, String work, CompoundTag extra) {

            boolean is_client = player.level().isClientSide;

            switch (type) {

                case "gui" -> {

                    if (is_client == true) {

                        Works.GUI.client((LocalPlayer) player, work, extra);

                    } else {

                        Works.GUI.server((ServerPlayer) player, work, extra);

                    }

                }

                case "nbt" -> {

                    if (is_client == true) {

                        Works.NBT.client((LocalPlayer) player, work, extra);

                    } else {

                        Works.NBT.server((ServerPlayer) player, work, extra);

                    }

                }

            }

        }

        private static class GUI {

            private static void client (LocalPlayer player, String work, CompoundTag extra) {



            }

            private static void server (ServerPlayer player, String work, CompoundTag extra) {

                switch (work) {

                    case "switch" -> {

                        String name = extra.getString("name");
                        NBTManager.setEntityLogic(player, name, !NBTManager.getEntityLogic(player, name));

                    }

                }

            }

        }

        private static class NBT {

            private static void client (LocalPlayer player, String work, CompoundTag extra) {

                switch (work) {

                    case "sync_all" -> {

                        CompoundTag tag = new CompoundTag();
                        tag.put(Core.mod_id, new CompoundTag());
                        tag.getCompound(Core.mod_id).merge(extra);
                        player.getPersistentData().merge(tag);
                        GUIMaker.Components.refresh();

                    }

                }

            }

            private static void server (ServerPlayer player, String work, CompoundTag extra) {



            }

        }

    }

}