package tannyjung.tanscomplexmagic.network;

import tannyjung.tanscomplexmagic.procedures.MenuGUIOpenProcedure;
import tannyjung.tanscomplexmagic.procedures.GUIpreviousProcedure;
import tannyjung.tanscomplexmagic.procedures.GUInextProcedure;
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
import net.minecraft.core.BlockPos;

@EventBusSubscriber
public record Spell4GUIsettings2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<Spell4GUIsettings2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TanscomplexmagicMod.MODID, "spell_4_gu_isettings_2_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, Spell4GUIsettings2ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, Spell4GUIsettings2ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new Spell4GUIsettings2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<Spell4GUIsettings2ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final Spell4GUIsettings2ButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			GUInextProcedure.execute(entity);
		}
		if (buttonID == 1) {

			MenuGUIOpenProcedure.execute(entity);
		}
		if (buttonID == 2) {

			GUIpreviousProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TanscomplexmagicMod.addNetworkMessage(Spell4GUIsettings2ButtonMessage.TYPE, Spell4GUIsettings2ButtonMessage.STREAM_CODEC, Spell4GUIsettings2ButtonMessage::handleData);
	}
}