
package tannyjung.lanternofthewoodlands.network;

import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIweaponShieldMenu;
import tannyjung.lanternofthewoodlands.procedures.Spell4GUIbuttonShieldLevelUpgradeProcedure;
import tannyjung.lanternofthewoodlands.procedures.Spell4GUIbuttonShieldCountUpgradeProcedure;
import tannyjung.lanternofthewoodlands.procedures.Spell4GUIbuttonShieldClearProcedure;
import tannyjung.lanternofthewoodlands.procedures.Spell4GUIbuttonShieldActivateProcedure;
import tannyjung.lanternofthewoodlands.procedures.MenuGUIOpenProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUIpreviousProcedure;
import tannyjung.lanternofthewoodlands.procedures.GUInextProcedure;
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
public class Spell4GUIweaponShieldButtonMessage {
	private final int buttonID, x, y, z;
	private HashMap<String, String> textstate;

	public Spell4GUIweaponShieldButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.textstate = readTextState(buffer);
	}

	public Spell4GUIweaponShieldButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.textstate = textstate;

	}

	public static void buffer(Spell4GUIweaponShieldButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		writeTextState(message.textstate, buffer);
	}

	public static void handler(Spell4GUIweaponShieldButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = Spell4GUIweaponShieldMenu.guistate;
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

			MenuGUIOpenProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			GUIpreviousProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			GUInextProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			Spell4GUIbuttonShieldActivateProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			Spell4GUIbuttonShieldClearProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			Spell4GUIbuttonShieldCountUpgradeProcedure.execute(entity);
		}
		if (buttonID == 9) {

			Spell4GUIbuttonShieldLevelUpgradeProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LanternofthewoodlandsMod.addNetworkMessage(Spell4GUIweaponShieldButtonMessage.class, Spell4GUIweaponShieldButtonMessage::buffer, Spell4GUIweaponShieldButtonMessage::new, Spell4GUIweaponShieldButtonMessage::handler);
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
