package tannyjung.tanscomplexmagic.network;

import tannyjung.tanscomplexmagic.procedures.KEYSPell4LockTargetRunProcedure;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

@EventBusSubscriber
public record KEYSPell4LockTargetMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<KEYSPell4LockTargetMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TanscomplexmagicMod.MODID, "key_keys_pell_4_lock_target"));
	public static final StreamCodec<RegistryFriendlyByteBuf, KEYSPell4LockTargetMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, KEYSPell4LockTargetMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new KEYSPell4LockTargetMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<KEYSPell4LockTargetMessage> type() {
		return TYPE;
	}

	public static void handleData(final KEYSPell4LockTargetMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			KEYSPell4LockTargetRunProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TanscomplexmagicMod.addNetworkMessage(KEYSPell4LockTargetMessage.TYPE, KEYSPell4LockTargetMessage.STREAM_CODEC, KEYSPell4LockTargetMessage::handleData);
	}
}