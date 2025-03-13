
package tannyjung.lanternofthewoodlands.network;

import tannyjung.lanternofthewoodlands.world.inventory.GUISpell4Menu;
import tannyjung.lanternofthewoodlands.procedures.Spell4StartProcedure;
import tannyjung.lanternofthewoodlands.procedures.Spell4CancelProcedure;
import tannyjung.lanternofthewoodlands.procedures.MenuGUIOpenProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIShortcutCustomSetProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIShortcutCustomProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIPagePreviousProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIPageNextProcedure;
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
public class GUISpell4ButtonMessage {
	private final int buttonID, x, y, z;
	private HashMap<String, String> textstate;

	public GUISpell4ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.textstate = readTextState(buffer);
	}

	public GUISpell4ButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.textstate = textstate;

	}

	public static void buffer(GUISpell4ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		writeTextState(message.textstate, buffer);
	}

	public static void handler(GUISpell4ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = GUISpell4Menu.guistate;
		for (Map.Entry<String, String> entry : textstate.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			guistate.put(key, value);
		}
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Spell4StartProcedure.execute(world, entity);
		}
		if (buttonID == 1) {

			Spell4CancelProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			GUICloseProcedure.execute(entity);
		}
		if (buttonID == 3) {

			GUIPagePreviousProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			GUIPageNextProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			MenuGUIOpenProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			GUIShortcutCustomProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			GUIShortcutCustomSetProcedure.execute(entity);
		}
		if (buttonID == 11) {

			GUILogTypeSetProcedure.execute(entity);
		}
		if (buttonID == 12) {

			GUICompassCustomSetProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LanternofthewoodlandsMod.addNetworkMessage(GUISpell4ButtonMessage.class, GUISpell4ButtonMessage::buffer, GUISpell4ButtonMessage::new, GUISpell4ButtonMessage::handler);
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
