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
public record PersonalSkillGUI2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<PersonalSkillGUI2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TanscomplexmagicMod.MODID, "personal_skill_gui_2_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PersonalSkillGUI2ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PersonalSkillGUI2ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new PersonalSkillGUI2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<PersonalSkillGUI2ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final PersonalSkillGUI2ButtonMessage message, final IPayloadContext context) {
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

			PersonalSkillGUIbuttonUpgradeProcedure.execute(entity);
		}
		if (buttonID == 6) {

			PersonalSkillGUIbuttonSkillTheMissingPersonProcedure.execute(entity);
		}
		if (buttonID == 9) {

			PersonalSkillGUIbuttonSkillNothingProcedure.execute(entity);
		}
		if (buttonID == 11) {

			PersonalSkillGUIbuttonSkillCircleOfHealingProcedure.execute(entity);
		}
		if (buttonID == 14) {

			PersonalSkillGUIbuttonSkillRejuvenatingMushroomProcedure.execute(entity);
		}
		if (buttonID == 17) {

			PersonalSkillGUIbuttonSkillBlinkProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TanscomplexmagicMod.addNetworkMessage(PersonalSkillGUI2ButtonMessage.TYPE, PersonalSkillGUI2ButtonMessage.STREAM_CODEC, PersonalSkillGUI2ButtonMessage::handleData);
	}
}