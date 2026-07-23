package tannyjung.tanscomplexmagic.network;

import tannyjung.tanscomplexmagic.procedures.KEYSpell4ShootRunProcedure;
import tannyjung.tanscomplexmagic.procedures.KEYSpell4ShootReleaseProcedure;
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
public record KEYSpell4ShootMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<KEYSpell4ShootMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TanscomplexmagicMod.MODID, "key_key_spell_4_shoot"));
	public static final StreamCodec<RegistryFriendlyByteBuf, KEYSpell4ShootMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, KEYSpell4ShootMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new KEYSpell4ShootMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<KEYSpell4ShootMessage> type() {
		return TYPE;
	}

	public static void handleData(final KEYSpell4ShootMessage message, final IPayloadContext context) {
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

			KEYSpell4ShootRunProcedure.execute(world, x, y, z, entity);
		}
		if (type == 1) {

			KEYSpell4ShootReleaseProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TanscomplexmagicMod.addNetworkMessage(KEYSpell4ShootMessage.TYPE, KEYSpell4ShootMessage.STREAM_CODEC, KEYSpell4ShootMessage::handleData);
	}
}