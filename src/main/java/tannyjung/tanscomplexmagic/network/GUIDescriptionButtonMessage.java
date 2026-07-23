package tannyjung.tanscomplexmagic.network;

import tannyjung.tanscomplexmagic.procedures.*;
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
public record GUIDescriptionButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<GUIDescriptionButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TanscomplexmagicMod.MODID, "gui_description_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, GUIDescriptionButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, GUIDescriptionButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new GUIDescriptionButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<GUIDescriptionButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final GUIDescriptionButtonMessage message, final IPayloadContext context) {
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

			GUICloseProcedure.execute(entity);
		}
		if (buttonID == 1) {

			GUIPagePreviousProcedure.execute(entity);
		}
		if (buttonID == 2) {

			GUIPageNextProcedure.execute(entity);
		}
		if (buttonID == 3) {

			GUIMenuOpenProcedure.execute(entity);
		}
		if (buttonID == 4) {

			GUIShortcutCustomProcedure.execute(entity);
		}
		if (buttonID == 5) {

			GUIShortcutCustomSetProcedure.execute(entity);
		}
		if (buttonID == 9) {

			GUILogTypeSetProcedure.execute(entity);
		}
		if (buttonID == 10) {

			GUICompassCustomSetProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TanscomplexmagicMod.addNetworkMessage(GUIDescriptionButtonMessage.TYPE, GUIDescriptionButtonMessage.STREAM_CODEC, GUIDescriptionButtonMessage::handleData);
	}
}