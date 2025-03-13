
package tannyjung.lanternofthewoodlands.network;

import tannyjung.lanternofthewoodlands.world.inventory.PersonalWeaponGUI2Menu;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonShowCenterProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonSetProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonRotationProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonReverseRotationProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonResetProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPoseZreduceProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPoseZincreaseProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPoseYreduceProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPoseYincreaseProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPoseXreduceProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPoseXincreaseProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPoseResetProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPosZreduceProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPosZincreaseProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPosYreduceProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPosYincreaseProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPosXreduceProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPosXincreaseProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonPosResetProcedure;
import tannyjung.lanternofthewoodlands.procedures.PersonalWeaponGUIbuttonFlyingProcedure;
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
public class PersonalWeaponGUI2ButtonMessage {
	private final int buttonID, x, y, z;
	private HashMap<String, String> textstate;

	public PersonalWeaponGUI2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.textstate = readTextState(buffer);
	}

	public PersonalWeaponGUI2ButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.textstate = textstate;

	}

	public static void buffer(PersonalWeaponGUI2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		writeTextState(message.textstate, buffer);
	}

	public static void handler(PersonalWeaponGUI2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = PersonalWeaponGUI2Menu.guistate;
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
		LanternofthewoodlandsMod.addNetworkMessage(PersonalWeaponGUI2ButtonMessage.class, PersonalWeaponGUI2ButtonMessage::buffer, PersonalWeaponGUI2ButtonMessage::new, PersonalWeaponGUI2ButtonMessage::handler);
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
