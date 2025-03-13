
package tannyjung.lanternofthewoodlands.network;

import tannyjung.lanternofthewoodlands.world.inventory.AllyListGUI2Menu;
import tannyjung.lanternofthewoodlands.procedures.MenuGUIOpenProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIpreviousProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUInextProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUICloseProcedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIbuttonShowListProcedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIbuttonRemoveAllProcedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIbuttonManualSetProcedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIbuttonManualRemoveProcedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIbuttonManualClearProcedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIbuttonManualAddProcedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIbuttonChatSettingProcedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIbuttonAutoClear3Procedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIbuttonAutoClear2Procedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIbuttonAutoClear1Procedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIbuttonAutoAdd3Procedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIbuttonAutoAdd2Procedure;
import tannyjung.lanternofthewoodlands.procedures.AllyListGUIbuttonAutoAdd1Procedure;
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
public class AllyListGUI2ButtonMessage {
	private final int buttonID, x, y, z;
	private HashMap<String, String> textstate;

	public AllyListGUI2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.textstate = readTextState(buffer);
	}

	public AllyListGUI2ButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.textstate = textstate;

	}

	public static void buffer(AllyListGUI2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		writeTextState(message.textstate, buffer);
	}

	public static void handler(AllyListGUI2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = AllyListGUI2Menu.guistate;
		for (Map.Entry<String, String> entry : textstate.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			guistate.put(key, value);
		}
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

			MenuGUIOpenProcedure.execute(world, x, y, z, entity);
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

			GUInextProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 17) {

			GUIpreviousProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LanternofthewoodlandsMod.addNetworkMessage(AllyListGUI2ButtonMessage.class, AllyListGUI2ButtonMessage::buffer, AllyListGUI2ButtonMessage::new, AllyListGUI2ButtonMessage::handler);
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
