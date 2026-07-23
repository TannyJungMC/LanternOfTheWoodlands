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
public record Spell4GUIweaponAnchorButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<Spell4GUIweaponAnchorButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TanscomplexmagicMod.MODID, "spell_4_gu_iweapon_anchor_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, Spell4GUIweaponAnchorButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, Spell4GUIweaponAnchorButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new Spell4GUIweaponAnchorButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<Spell4GUIweaponAnchorButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final Spell4GUIweaponAnchorButtonMessage message, final IPayloadContext context) {
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

			Spell4GUIbuttonAnchorActivateProcedure.execute(entity);
		}
		if (buttonID == 5) {

			Spell4GUIbuttonAnchorClearProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			Spell4GUIbuttonAnchorLevelUpgradeProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TanscomplexmagicMod.addNetworkMessage(Spell4GUIweaponAnchorButtonMessage.TYPE, Spell4GUIweaponAnchorButtonMessage.STREAM_CODEC, Spell4GUIweaponAnchorButtonMessage::handleData);
	}
}