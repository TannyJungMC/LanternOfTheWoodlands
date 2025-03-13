
package tannyjung.lanternofthewoodlands.network;

import tannyjung.lanternofthewoodlands.world.inventory.GUIDescriptionMenu;
import tannyjung.lanternofthewoodlands.procedures.GUIShortcutCustomSetProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIShortcutCustomProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIPagePreviousProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIPageNextProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIMenuOpenProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUILogTypeSetProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUICompassCustomSetProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUICloseProcedure;
import tannyjung.lanternofthewoodlands.LanternofthewoodlandsMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GUIDescriptionButtonMessage {
	private final int buttonID, x, y, z;
	private HashMap<String, String> textstate;

	public GUIDescriptionButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.textstate = readTextState(buffer);
	}

	public GUIDescriptionButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.textstate = textstate;

	}

	public static void buffer(GUIDescriptionButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		writeTextState(message.textstate, buffer);
	}

	public static void handler(GUIDescriptionButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			HashMap<String, String> textstate = message.textstate;
			handleButtonAction(entity, buttonID, x, y, z, textstate);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
		Level world = entity.level();
		HashMap guistate = GUIDescriptionMenu.guistate;
		for (Map.Entry<String, String> entry : textstate.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			guistate.put(key, value);
		}
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			GUICloseProcedure.execute(entity);
		}
		if (buttonID == 1) {

			GUIPagePreviousProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			GUIPageNextProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			GUIMenuOpenProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			GUIShortcutCustomProcedure.execute(world, x, y, z, entity);
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
		LanternofthewoodlandsMod.addNetworkMessage(GUIDescriptionButtonMessage.class, GUIDescriptionButtonMessage::buffer, GUIDescriptionButtonMessage::new, GUIDescriptionButtonMessage::handler);
	}

	public static void writeTextState(HashMap<String, String> map, FriendlyByteBuf buffer) {
		buffer.writeInt(map.size());
		for (Map.Entry<String, String> entry : map.entrySet()) {
			buffer.writeComponent(Component.literal(entry.getKey()));
			buffer.writeComponent(Component.literal(entry.getValue()));
		}
	}

	public static HashMap<String, String> readTextState(FriendlyByteBuf buffer) {
		int size = buffer.readInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < size; i++) {
			String key = buffer.readComponent().getString();
			String value = buffer.readComponent().getString();
			map.put(key, value);
		}
		return map;
	}
}
