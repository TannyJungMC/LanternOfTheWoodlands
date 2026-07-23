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
public record AllyListGUI2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<AllyListGUI2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TanscomplexmagicMod.MODID, "ally_list_gui_2_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AllyListGUI2ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AllyListGUI2ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new AllyListGUI2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<AllyListGUI2ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final AllyListGUI2ButtonMessage message, final IPayloadContext context) {
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

			AllyListGUIbuttonManualSetProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			AllyListGUIbuttonManualAddProcedure.execute(entity);
		}
		if (buttonID == 2) {

			AllyListGUIbuttonAutoAdd1Procedure.execute(entity);
		}
		if (buttonID == 3) {

			AllyListGUIbuttonAutoAdd2Procedure.execute(entity);
		}
		if (buttonID == 4) {

			AllyListGUIbuttonAutoAdd3Procedure.execute(entity);
		}
		if (buttonID == 5) {

			MenuGUIOpenProcedure.execute(entity);
		}
		if (buttonID == 6) {

			GUICloseProcedure.execute(entity);
		}
		if (buttonID == 8) {

			AllyListGUIbuttonShowListProcedure.execute(entity);
		}
		if (buttonID == 9) {

			AllyListGUIbuttonManualRemoveProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			AllyListGUIbuttonRemoveAllProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			AllyListGUIbuttonManualClearProcedure.execute(entity);
		}
		if (buttonID == 12) {

			AllyListGUIbuttonAutoClear1Procedure.execute(entity);
		}
		if (buttonID == 13) {

			AllyListGUIbuttonAutoClear2Procedure.execute(entity);
		}
		if (buttonID == 14) {

			AllyListGUIbuttonAutoClear3Procedure.execute(entity);
		}
		if (buttonID == 15) {

			AllyListGUIbuttonChatSettingProcedure.execute(entity);
		}
		if (buttonID == 16) {

			GUInextProcedure.execute(entity);
		}
		if (buttonID == 17) {

			GUIpreviousProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TanscomplexmagicMod.addNetworkMessage(AllyListGUI2ButtonMessage.TYPE, AllyListGUI2ButtonMessage.STREAM_CODEC, AllyListGUI2ButtonMessage::handleData);
	}
}