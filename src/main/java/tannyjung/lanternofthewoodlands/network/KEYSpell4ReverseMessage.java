
package tannyjung.lanternofthewoodlands.network;

import tannyjung.lanternofthewoodlands.procedures.KEYSpell4ReverseRunProcedure;
import tannyjung.lanternofthewoodlands.procedures.KEYSpell4ReverseReleaseProcedure;
import tannyjung.lanternofthewoodlands.LanternofthewoodlandsMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KEYSpell4ReverseMessage {
	int type, pressedms;

	public KEYSpell4ReverseMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public KEYSpell4ReverseMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(KEYSpell4ReverseMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(KEYSpell4ReverseMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			KEYSpell4ReverseRunProcedure.execute(entity);
		}
		if (type == 1) {

			KEYSpell4ReverseReleaseProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LanternofthewoodlandsMod.addNetworkMessage(KEYSpell4ReverseMessage.class, KEYSpell4ReverseMessage::buffer, KEYSpell4ReverseMessage::new, KEYSpell4ReverseMessage::handler);
	}
}
