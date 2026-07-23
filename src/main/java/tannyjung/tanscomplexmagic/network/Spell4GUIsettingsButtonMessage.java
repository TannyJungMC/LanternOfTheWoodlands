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
public record Spell4GUIsettingsButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<Spell4GUIsettingsButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TanscomplexmagicMod.MODID, "spell_4_gu_isettings_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, Spell4GUIsettingsButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, Spell4GUIsettingsButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new Spell4GUIsettingsButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<Spell4GUIsettingsButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final Spell4GUIsettingsButtonMessage message, final IPayloadContext context) {
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

			Spell4GUIbuttonShowOverlayProcedure.execute(entity);
		}
		if (buttonID == 1) {

			Spell4GUIbuttonShowTargetArrowProcedure.execute(entity);
		}
		if (buttonID == 2) {

			Spell4GUIbuttonPauseAtMarkProcedure.execute(entity);
		}
		if (buttonID == 3) {

			Spell4GUIbuttonPauseGravityProcedure.execute(entity);
		}
		if (buttonID == 4) {

			Spell4GUIbuttonLockShootProcedure.execute(entity);
		}
		if (buttonID == 5) {

			Spell4GUIbuttonLockReverseProcedure.execute(entity);
		}
		if (buttonID == 6) {

			Spell4GUIbuttonGuardPoseProcedure.execute(entity);
		}
		if (buttonID == 14) {

			GUICloseProcedure.execute(entity);
		}
		if (buttonID == 27) {

			MenuGUIOpenProcedure.execute(entity);
		}
		if (buttonID == 33) {

			GUIpreviousProcedure.execute(entity);
		}
		if (buttonID == 34) {

			GUInextProcedure.execute(entity);
		}
		if (buttonID == 35) {

			Spell4GUIbuttonBoundaryProcedure.execute(entity);
		}
		if (buttonID == 36) {

			Spell4GUIbuttonGuardPoseDistanceProcedure.execute(entity);
		}
		if (buttonID == 37) {

			Spell4GUIbuttonAutoShotCooldownProcedure.execute(entity);
		}
		if (buttonID == 38) {

			Spell4GUIbuttonDistancingInProcedure.execute(world, entity);
		}
		if (buttonID == 39) {

			Spell4GUIbuttonDistancingOutProcedure.execute(world, entity);
		}
		if (buttonID == 40) {

			Spell4GUIbuttonDistancingSpeedProcedure.execute(entity);
		}
		if (buttonID == 45) {

			Spell4GUIbuttonPauseRotationProcedure.execute(entity);
		}
		if (buttonID == 47) {

			Spell4GUIbuttonPauseBalancingProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TanscomplexmagicMod.addNetworkMessage(Spell4GUIsettingsButtonMessage.TYPE, Spell4GUIsettingsButtonMessage.STREAM_CODEC, Spell4GUIsettingsButtonMessage::handleData);
	}
}