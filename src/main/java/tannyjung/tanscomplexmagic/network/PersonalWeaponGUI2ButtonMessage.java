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
public record PersonalWeaponGUI2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<PersonalWeaponGUI2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TanscomplexmagicMod.MODID, "personal_weapon_gui_2_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PersonalWeaponGUI2ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PersonalWeaponGUI2ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new PersonalWeaponGUI2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<PersonalWeaponGUI2ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final PersonalWeaponGUI2ButtonMessage message, final IPayloadContext context) {
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

			MenuGUIOpenProcedure.execute(entity);
		}
		if (buttonID == 2) {

			GUIpreviousProcedure.execute(entity);
		}
		if (buttonID == 3) {

			GUInextProcedure.execute(entity);
		}
		if (buttonID == 4) {

			PersonalWeaponGUIbuttonSetProcedure.execute(entity);
		}
		if (buttonID == 5) {

			PersonalWeaponGUIbuttonResetProcedure.execute(entity);
		}
		if (buttonID == 6) {

			PersonalWeaponGUIbuttonShowCenterProcedure.execute(entity);
		}
		if (buttonID == 7) {

			PersonalWeaponGUIbuttonRotationProcedure.execute(entity);
		}
		if (buttonID == 8) {

			PersonalWeaponGUIbuttonReverseRotationProcedure.execute(entity);
		}
		if (buttonID == 9) {

			PersonalWeaponGUIbuttonPosResetProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			PersonalWeaponGUIbuttonPoseResetProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			PersonalWeaponGUIbuttonPosXincreaseProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			PersonalWeaponGUIbuttonPosYincreaseProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			PersonalWeaponGUIbuttonPosZincreaseProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			PersonalWeaponGUIbuttonPoseXincreaseProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 15) {

			PersonalWeaponGUIbuttonPoseYincreaseProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 16) {

			PersonalWeaponGUIbuttonPoseZincreaseProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 17) {

			PersonalWeaponGUIbuttonPosXreduceProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 18) {

			PersonalWeaponGUIbuttonPosYreduceProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 19) {

			PersonalWeaponGUIbuttonPosZreduceProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 20) {

			PersonalWeaponGUIbuttonPoseXreduceProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 21) {

			PersonalWeaponGUIbuttonPoseYreduceProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 22) {

			PersonalWeaponGUIbuttonPoseZreduceProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 26) {

			PersonalWeaponGUIbuttonFlyingProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TanscomplexmagicMod.addNetworkMessage(PersonalWeaponGUI2ButtonMessage.TYPE, PersonalWeaponGUI2ButtonMessage.STREAM_CODEC, PersonalWeaponGUI2ButtonMessage::handleData);
	}
}