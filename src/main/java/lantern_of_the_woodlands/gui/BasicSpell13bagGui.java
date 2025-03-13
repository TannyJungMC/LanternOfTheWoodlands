
package lantern_of_the_woodlands.gui;

import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.ScreenManager;

import lantern_of_the_woodlands.procedures.CloseGUIProcedure;
import lantern_of_the_woodlands.procedures.BasicSpell13whenCloseProcedure;
import lantern_of_the_woodlands.procedures.BasicSpell13whenClickProcedure;
import lantern_of_the_woodlands.procedures.BasicSpell13clickHelpProcedure;

import lantern_of_the_woodlands.LanternOfTheWoodlandsModElements;

import lantern_of_the_woodlands.LanternOfTheWoodlandsMod;

import java.util.stream.Stream;
import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@LanternOfTheWoodlandsModElements.ModElement.Tag
public class BasicSpell13bagGui extends LanternOfTheWoodlandsModElements.ModElement {
	public static HashMap guistate = new HashMap();
	private static ContainerType<GuiContainerMod> containerType = null;

	public BasicSpell13bagGui(LanternOfTheWoodlandsModElements instance) {
		super(instance, 578);
		elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
				ButtonPressedMessage::handler);
		elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
				GUISlotChangedMessage::handler);
		containerType = new ContainerType<>(new GuiContainerModFactory());
		FMLJavaModLoadingContext.get().getModEventBus().register(new ContainerRegisterHandler());
	}

	private static class ContainerRegisterHandler {
		@SubscribeEvent
		public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
			event.getRegistry().register(containerType.setRegistryName("basic_spell_13bag"));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, BasicSpell13bagGuiWindow::new));
	}

	public static class GuiContainerModFactory implements IContainerFactory {
		public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
			return new GuiContainerMod(id, inv, extraData);
		}
	}

	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		World world;
		PlayerEntity entity;
		int x, y, z;
		private IItemHandler internal;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		private boolean bound = false;

		public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
			super(containerType, id);
			this.entity = inv.player;
			this.world = inv.player.world;
			this.internal = new ItemStackHandler(159);
			BlockPos pos = null;
			if (extraData != null) {
				pos = extraData.readBlockPos();
				this.x = pos.getX();
				this.y = pos.getY();
				this.z = pos.getZ();
			}
			if (pos != null) {
				if (extraData.readableBytes() == 1) { // bound to item
					byte hand = extraData.readByte();
					ItemStack itemstack;
					if (hand == 0)
						itemstack = this.entity.getHeldItemMainhand();
					else
						itemstack = this.entity.getHeldItemOffhand();
					itemstack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
				} else if (extraData.readableBytes() > 1) {
					extraData.readByte(); // drop padding
					Entity entity = world.getEntityByID(extraData.readVarInt());
					if (entity != null)
						entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							this.internal = capability;
							this.bound = true;
						});
				} else { // might be bound to block
					TileEntity ent = inv.player != null ? inv.player.world.getTileEntity(pos) : null;
					if (ent != null) {
						ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							this.internal = capability;
							this.bound = true;
						});
					}
				}
			}
			this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 6, 6) {
			}));
			this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 24, 6) {
			}));
			this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 42, 6) {
			}));
			this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 60, 6) {
			}));
			this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 78, 6) {
			}));
			this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 96, 6) {
			}));
			this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 114, 6) {
			}));
			this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 132, 6) {
			}));
			this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 150, 6) {
			}));
			this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 168, 6) {
			}));
			this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 186, 6) {
			}));
			this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 204, 6) {
			}));
			this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 222, 6) {
			}));
			this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 240, 6) {
			}));
			this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 258, 6) {
			}));
			this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 6, 24) {
			}));
			this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 24, 24) {
			}));
			this.customSlots.put(17, this.addSlot(new SlotItemHandler(internal, 17, 42, 24) {
			}));
			this.customSlots.put(18, this.addSlot(new SlotItemHandler(internal, 18, 60, 24) {
			}));
			this.customSlots.put(19, this.addSlot(new SlotItemHandler(internal, 19, 78, 24) {
			}));
			this.customSlots.put(20, this.addSlot(new SlotItemHandler(internal, 20, 96, 24) {
			}));
			this.customSlots.put(21, this.addSlot(new SlotItemHandler(internal, 21, 114, 24) {
			}));
			this.customSlots.put(22, this.addSlot(new SlotItemHandler(internal, 22, 132, 24) {
			}));
			this.customSlots.put(23, this.addSlot(new SlotItemHandler(internal, 23, 150, 24) {
			}));
			this.customSlots.put(24, this.addSlot(new SlotItemHandler(internal, 24, 168, 24) {
			}));
			this.customSlots.put(25, this.addSlot(new SlotItemHandler(internal, 25, 186, 24) {
			}));
			this.customSlots.put(26, this.addSlot(new SlotItemHandler(internal, 26, 204, 24) {
			}));
			this.customSlots.put(27, this.addSlot(new SlotItemHandler(internal, 27, 222, 24) {
			}));
			this.customSlots.put(28, this.addSlot(new SlotItemHandler(internal, 28, 240, 24) {
			}));
			this.customSlots.put(29, this.addSlot(new SlotItemHandler(internal, 29, 258, 24) {
			}));
			this.customSlots.put(30, this.addSlot(new SlotItemHandler(internal, 30, 6, 42) {
			}));
			this.customSlots.put(31, this.addSlot(new SlotItemHandler(internal, 31, 24, 42) {
			}));
			this.customSlots.put(32, this.addSlot(new SlotItemHandler(internal, 32, 42, 42) {
			}));
			this.customSlots.put(33, this.addSlot(new SlotItemHandler(internal, 33, 60, 42) {
			}));
			this.customSlots.put(34, this.addSlot(new SlotItemHandler(internal, 34, 78, 42) {
			}));
			this.customSlots.put(35, this.addSlot(new SlotItemHandler(internal, 35, 96, 42) {
			}));
			this.customSlots.put(36, this.addSlot(new SlotItemHandler(internal, 36, 114, 42) {
			}));
			this.customSlots.put(37, this.addSlot(new SlotItemHandler(internal, 37, 132, 42) {
			}));
			this.customSlots.put(38, this.addSlot(new SlotItemHandler(internal, 38, 150, 42) {
			}));
			this.customSlots.put(39, this.addSlot(new SlotItemHandler(internal, 39, 168, 42) {
			}));
			this.customSlots.put(40, this.addSlot(new SlotItemHandler(internal, 40, 186, 42) {
			}));
			this.customSlots.put(41, this.addSlot(new SlotItemHandler(internal, 41, 204, 42) {
			}));
			this.customSlots.put(42, this.addSlot(new SlotItemHandler(internal, 42, 222, 42) {
			}));
			this.customSlots.put(43, this.addSlot(new SlotItemHandler(internal, 43, 240, 42) {
			}));
			this.customSlots.put(44, this.addSlot(new SlotItemHandler(internal, 44, 258, 42) {
			}));
			this.customSlots.put(45, this.addSlot(new SlotItemHandler(internal, 45, 6, 60) {
			}));
			this.customSlots.put(46, this.addSlot(new SlotItemHandler(internal, 46, 24, 60) {
			}));
			this.customSlots.put(47, this.addSlot(new SlotItemHandler(internal, 47, 42, 60) {
			}));
			this.customSlots.put(48, this.addSlot(new SlotItemHandler(internal, 48, 60, 60) {
			}));
			this.customSlots.put(49, this.addSlot(new SlotItemHandler(internal, 49, 78, 60) {
			}));
			this.customSlots.put(50, this.addSlot(new SlotItemHandler(internal, 50, 96, 60) {
			}));
			this.customSlots.put(51, this.addSlot(new SlotItemHandler(internal, 51, 114, 60) {
			}));
			this.customSlots.put(52, this.addSlot(new SlotItemHandler(internal, 52, 132, 60) {
			}));
			this.customSlots.put(53, this.addSlot(new SlotItemHandler(internal, 53, 150, 60) {
			}));
			this.customSlots.put(54, this.addSlot(new SlotItemHandler(internal, 54, 168, 60) {
			}));
			this.customSlots.put(55, this.addSlot(new SlotItemHandler(internal, 55, 186, 60) {
			}));
			this.customSlots.put(56, this.addSlot(new SlotItemHandler(internal, 56, 204, 60) {
			}));
			this.customSlots.put(57, this.addSlot(new SlotItemHandler(internal, 57, 222, 60) {
			}));
			this.customSlots.put(58, this.addSlot(new SlotItemHandler(internal, 58, 240, 60) {
			}));
			this.customSlots.put(59, this.addSlot(new SlotItemHandler(internal, 59, 258, 60) {
			}));
			this.customSlots.put(60, this.addSlot(new SlotItemHandler(internal, 60, 6, 78) {
			}));
			this.customSlots.put(61, this.addSlot(new SlotItemHandler(internal, 61, 24, 78) {
			}));
			this.customSlots.put(62, this.addSlot(new SlotItemHandler(internal, 62, 42, 78) {
			}));
			this.customSlots.put(63, this.addSlot(new SlotItemHandler(internal, 63, 60, 78) {
			}));
			this.customSlots.put(64, this.addSlot(new SlotItemHandler(internal, 64, 78, 78) {
			}));
			this.customSlots.put(65, this.addSlot(new SlotItemHandler(internal, 65, 96, 78) {
			}));
			this.customSlots.put(66, this.addSlot(new SlotItemHandler(internal, 66, 114, 78) {
			}));
			this.customSlots.put(67, this.addSlot(new SlotItemHandler(internal, 67, 132, 78) {
			}));
			this.customSlots.put(68, this.addSlot(new SlotItemHandler(internal, 68, 150, 78) {
			}));
			this.customSlots.put(69, this.addSlot(new SlotItemHandler(internal, 69, 168, 78) {
			}));
			this.customSlots.put(70, this.addSlot(new SlotItemHandler(internal, 70, 186, 78) {
			}));
			this.customSlots.put(71, this.addSlot(new SlotItemHandler(internal, 71, 204, 78) {
			}));
			this.customSlots.put(72, this.addSlot(new SlotItemHandler(internal, 72, 222, 78) {
			}));
			this.customSlots.put(73, this.addSlot(new SlotItemHandler(internal, 73, 240, 78) {
			}));
			this.customSlots.put(74, this.addSlot(new SlotItemHandler(internal, 74, 258, 78) {
			}));
			this.customSlots.put(75, this.addSlot(new SlotItemHandler(internal, 75, 294, 6) {
			}));
			this.customSlots.put(76, this.addSlot(new SlotItemHandler(internal, 76, 312, 6) {
			}));
			this.customSlots.put(77, this.addSlot(new SlotItemHandler(internal, 77, 330, 6) {
			}));
			this.customSlots.put(78, this.addSlot(new SlotItemHandler(internal, 78, 348, 6) {
			}));
			this.customSlots.put(79, this.addSlot(new SlotItemHandler(internal, 79, 366, 6) {
			}));
			this.customSlots.put(80, this.addSlot(new SlotItemHandler(internal, 80, 6, 159) {
			}));
			this.customSlots.put(81, this.addSlot(new SlotItemHandler(internal, 81, 24, 159) {
			}));
			this.customSlots.put(82, this.addSlot(new SlotItemHandler(internal, 82, 42, 159) {
			}));
			this.customSlots.put(83, this.addSlot(new SlotItemHandler(internal, 83, 60, 159) {
			}));
			this.customSlots.put(84, this.addSlot(new SlotItemHandler(internal, 84, 78, 159) {
			}));
			this.customSlots.put(85, this.addSlot(new SlotItemHandler(internal, 85, 6, 177) {
			}));
			this.customSlots.put(86, this.addSlot(new SlotItemHandler(internal, 86, 24, 177) {
			}));
			this.customSlots.put(87, this.addSlot(new SlotItemHandler(internal, 87, 42, 177) {
			}));
			this.customSlots.put(88, this.addSlot(new SlotItemHandler(internal, 88, 60, 177) {
			}));
			this.customSlots.put(89, this.addSlot(new SlotItemHandler(internal, 89, 78, 177) {
			}));
			this.customSlots.put(90, this.addSlot(new SlotItemHandler(internal, 90, 6, 101) {
			}));
			this.customSlots.put(91, this.addSlot(new SlotItemHandler(internal, 91, 24, 101) {
			}));
			this.customSlots.put(92, this.addSlot(new SlotItemHandler(internal, 92, 42, 101) {
			}));
			this.customSlots.put(93, this.addSlot(new SlotItemHandler(internal, 93, 60, 101) {
			}));
			this.customSlots.put(94, this.addSlot(new SlotItemHandler(internal, 94, 78, 101) {
			}));
			this.customSlots.put(95, this.addSlot(new SlotItemHandler(internal, 95, 6, 119) {
			}));
			this.customSlots.put(96, this.addSlot(new SlotItemHandler(internal, 96, 24, 119) {
			}));
			this.customSlots.put(97, this.addSlot(new SlotItemHandler(internal, 97, 42, 119) {
			}));
			this.customSlots.put(98, this.addSlot(new SlotItemHandler(internal, 98, 60, 119) {
			}));
			this.customSlots.put(99, this.addSlot(new SlotItemHandler(internal, 99, 78, 119) {
			}));
			this.customSlots.put(100, this.addSlot(new SlotItemHandler(internal, 100, 6, 137) {
			}));
			this.customSlots.put(101, this.addSlot(new SlotItemHandler(internal, 101, 24, 137) {
			}));
			this.customSlots.put(102, this.addSlot(new SlotItemHandler(internal, 102, 42, 137) {
			}));
			this.customSlots.put(103, this.addSlot(new SlotItemHandler(internal, 103, 60, 137) {
			}));
			this.customSlots.put(104, this.addSlot(new SlotItemHandler(internal, 104, 78, 137) {
			}));
			this.customSlots.put(105, this.addSlot(new SlotItemHandler(internal, 105, 294, 87) {
			}));
			this.customSlots.put(106, this.addSlot(new SlotItemHandler(internal, 106, 312, 87) {
			}));
			this.customSlots.put(107, this.addSlot(new SlotItemHandler(internal, 107, 330, 87) {
			}));
			this.customSlots.put(108, this.addSlot(new SlotItemHandler(internal, 108, 348, 87) {
			}));
			this.customSlots.put(109, this.addSlot(new SlotItemHandler(internal, 109, 366, 87) {
			}));
			this.customSlots.put(110, this.addSlot(new SlotItemHandler(internal, 110, 294, 105) {
			}));
			this.customSlots.put(111, this.addSlot(new SlotItemHandler(internal, 111, 312, 105) {
			}));
			this.customSlots.put(112, this.addSlot(new SlotItemHandler(internal, 112, 330, 105) {
			}));
			this.customSlots.put(113, this.addSlot(new SlotItemHandler(internal, 113, 348, 105) {
			}));
			this.customSlots.put(114, this.addSlot(new SlotItemHandler(internal, 114, 366, 105) {
			}));
			this.customSlots.put(115, this.addSlot(new SlotItemHandler(internal, 115, 294, 123) {
			}));
			this.customSlots.put(116, this.addSlot(new SlotItemHandler(internal, 116, 312, 123) {
			}));
			this.customSlots.put(117, this.addSlot(new SlotItemHandler(internal, 117, 330, 123) {
			}));
			this.customSlots.put(118, this.addSlot(new SlotItemHandler(internal, 118, 348, 123) {
			}));
			this.customSlots.put(119, this.addSlot(new SlotItemHandler(internal, 119, 366, 123) {
			}));
			this.customSlots.put(120, this.addSlot(new SlotItemHandler(internal, 120, 294, 141) {
			}));
			this.customSlots.put(121, this.addSlot(new SlotItemHandler(internal, 121, 294, 24) {
			}));
			this.customSlots.put(122, this.addSlot(new SlotItemHandler(internal, 122, 312, 24) {
			}));
			this.customSlots.put(123, this.addSlot(new SlotItemHandler(internal, 123, 330, 24) {
			}));
			this.customSlots.put(124, this.addSlot(new SlotItemHandler(internal, 124, 348, 24) {
			}));
			this.customSlots.put(125, this.addSlot(new SlotItemHandler(internal, 125, 366, 24) {
			}));
			this.customSlots.put(126, this.addSlot(new SlotItemHandler(internal, 126, 294, 42) {
			}));
			this.customSlots.put(127, this.addSlot(new SlotItemHandler(internal, 127, 312, 42) {
			}));
			this.customSlots.put(128, this.addSlot(new SlotItemHandler(internal, 128, 330, 42) {
			}));
			this.customSlots.put(129, this.addSlot(new SlotItemHandler(internal, 129, 348, 42) {
			}));
			this.customSlots.put(130, this.addSlot(new SlotItemHandler(internal, 130, 366, 42) {
			}));
			this.customSlots.put(131, this.addSlot(new SlotItemHandler(internal, 131, 294, 60) {
			}));
			this.customSlots.put(132, this.addSlot(new SlotItemHandler(internal, 132, 312, 60) {
			}));
			this.customSlots.put(133, this.addSlot(new SlotItemHandler(internal, 133, 330, 60) {
			}));
			this.customSlots.put(134, this.addSlot(new SlotItemHandler(internal, 134, 348, 60) {
			}));
			this.customSlots.put(135, this.addSlot(new SlotItemHandler(internal, 135, 366, 60) {
			}));
			this.customSlots.put(136, this.addSlot(new SlotItemHandler(internal, 136, 312, 141) {
			}));
			this.customSlots.put(137, this.addSlot(new SlotItemHandler(internal, 137, 330, 141) {
			}));
			this.customSlots.put(138, this.addSlot(new SlotItemHandler(internal, 138, 348, 141) {
			}));
			this.customSlots.put(139, this.addSlot(new SlotItemHandler(internal, 139, 366, 141) {
			}));
			this.customSlots.put(140, this.addSlot(new SlotItemHandler(internal, 140, 294, 159) {
			}));
			this.customSlots.put(141, this.addSlot(new SlotItemHandler(internal, 141, 312, 159) {
			}));
			this.customSlots.put(142, this.addSlot(new SlotItemHandler(internal, 142, 330, 159) {
			}));
			this.customSlots.put(143, this.addSlot(new SlotItemHandler(internal, 143, 348, 159) {
			}));
			this.customSlots.put(144, this.addSlot(new SlotItemHandler(internal, 144, 366, 159) {
			}));
			this.customSlots.put(145, this.addSlot(new SlotItemHandler(internal, 145, 294, 177) {
			}));
			this.customSlots.put(146, this.addSlot(new SlotItemHandler(internal, 146, 312, 177) {
			}));
			this.customSlots.put(147, this.addSlot(new SlotItemHandler(internal, 147, 330, 177) {
			}));
			this.customSlots.put(148, this.addSlot(new SlotItemHandler(internal, 148, 348, 177) {
			}));
			this.customSlots.put(149, this.addSlot(new SlotItemHandler(internal, 149, 366, 177) {
			}));
			this.customSlots.put(150, this.addSlot(new SlotItemHandler(internal, 150, 114, 177) {
			}));
			this.customSlots.put(151, this.addSlot(new SlotItemHandler(internal, 151, 132, 177) {
			}));
			this.customSlots.put(152, this.addSlot(new SlotItemHandler(internal, 152, 150, 177) {
			}));
			this.customSlots.put(153, this.addSlot(new SlotItemHandler(internal, 153, 168, 177) {
			}));
			this.customSlots.put(154, this.addSlot(new SlotItemHandler(internal, 154, 186, 177) {
			}));
			this.customSlots.put(155, this.addSlot(new SlotItemHandler(internal, 155, 204, 177) {
			}));
			this.customSlots.put(156, this.addSlot(new SlotItemHandler(internal, 156, 222, 177) {
			}));
			this.customSlots.put(157, this.addSlot(new SlotItemHandler(internal, 157, 240, 177) {
			}));
			this.customSlots.put(158, this.addSlot(new SlotItemHandler(internal, 158, 258, 177) {
			}));
			int si;
			int sj;
			for (si = 0; si < 3; ++si)
				for (sj = 0; sj < 9; ++sj)
					this.addSlot(new Slot(inv, sj + (si + 1) * 9, 106 + 8 + sj * 18, 17 + 84 + si * 18));
			for (si = 0; si < 9; ++si)
				this.addSlot(new Slot(inv, si, 106 + 8 + si * 18, 17 + 142));

			BasicSpell13whenClickProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(PlayerEntity player) {
			return true;
		}

		@Override
		public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
			ItemStack itemstack = ItemStack.EMPTY;
			Slot slot = (Slot) this.inventorySlots.get(index);
			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();
				if (index < 159) {
					if (!this.mergeItemStack(itemstack1, 159, this.inventorySlots.size(), true)) {
						return ItemStack.EMPTY;
					}
					slot.onSlotChange(itemstack1, itemstack);
				} else if (!this.mergeItemStack(itemstack1, 0, 159, false)) {
					if (index < 159 + 27) {
						if (!this.mergeItemStack(itemstack1, 159 + 27, this.inventorySlots.size(), true)) {
							return ItemStack.EMPTY;
						}
					} else {
						if (!this.mergeItemStack(itemstack1, 159, 159 + 27, false)) {
							return ItemStack.EMPTY;
						}
					}
					return ItemStack.EMPTY;
				}
				if (itemstack1.getCount() == 0) {
					slot.putStack(ItemStack.EMPTY);
				} else {
					slot.onSlotChanged();
				}
				if (itemstack1.getCount() == itemstack.getCount()) {
					return ItemStack.EMPTY;
				}
				slot.onTake(playerIn, itemstack1);
			}
			return itemstack;
		}

		@Override /** 
					* Merges provided ItemStack with the first avaliable one in the container/player inventor between minIndex (included) and maxIndex (excluded). Args : stack, minIndex, maxIndex, negativDirection. /!\ the Container implementation do not check if the item is valid for the slot
					*/
		protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
			boolean flag = false;
			int i = startIndex;
			if (reverseDirection) {
				i = endIndex - 1;
			}
			if (stack.isStackable()) {
				while (!stack.isEmpty()) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot = this.inventorySlots.get(i);
					ItemStack itemstack = slot.getStack();
					if (slot.isItemValid(itemstack) && !itemstack.isEmpty() && areItemsAndTagsEqual(stack, itemstack)) {
						int j = itemstack.getCount() + stack.getCount();
						int maxSize = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
						if (j <= maxSize) {
							stack.setCount(0);
							itemstack.setCount(j);
							slot.putStack(itemstack);
							flag = true;
						} else if (itemstack.getCount() < maxSize) {
							stack.shrink(maxSize - itemstack.getCount());
							itemstack.setCount(maxSize);
							slot.putStack(itemstack);
							flag = true;
						}
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			if (!stack.isEmpty()) {
				if (reverseDirection) {
					i = endIndex - 1;
				} else {
					i = startIndex;
				}
				while (true) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot1 = this.inventorySlots.get(i);
					ItemStack itemstack1 = slot1.getStack();
					if (itemstack1.isEmpty() && slot1.isItemValid(stack)) {
						if (stack.getCount() > slot1.getSlotStackLimit()) {
							slot1.putStack(stack.split(slot1.getSlotStackLimit()));
						} else {
							slot1.putStack(stack.split(stack.getCount()));
						}
						slot1.onSlotChanged();
						flag = true;
						break;
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			return flag;
		}

		@Override
		public void onContainerClosed(PlayerEntity playerIn) {
			super.onContainerClosed(playerIn);

			BasicSpell13whenCloseProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			if (!bound && (playerIn instanceof ServerPlayerEntity)) {
				if (!playerIn.isAlive() || playerIn instanceof ServerPlayerEntity && ((ServerPlayerEntity) playerIn).hasDisconnected()) {
					for (int j = 0; j < internal.getSlots(); ++j) {
						if (j == 0)
							continue;
						if (j == 1)
							continue;
						if (j == 2)
							continue;
						if (j == 3)
							continue;
						if (j == 4)
							continue;
						if (j == 5)
							continue;
						if (j == 6)
							continue;
						if (j == 7)
							continue;
						if (j == 8)
							continue;
						if (j == 9)
							continue;
						if (j == 10)
							continue;
						if (j == 11)
							continue;
						if (j == 12)
							continue;
						if (j == 13)
							continue;
						if (j == 14)
							continue;
						if (j == 15)
							continue;
						if (j == 16)
							continue;
						if (j == 17)
							continue;
						if (j == 18)
							continue;
						if (j == 19)
							continue;
						if (j == 20)
							continue;
						if (j == 21)
							continue;
						if (j == 22)
							continue;
						if (j == 23)
							continue;
						if (j == 24)
							continue;
						if (j == 25)
							continue;
						if (j == 26)
							continue;
						if (j == 27)
							continue;
						if (j == 28)
							continue;
						if (j == 29)
							continue;
						if (j == 30)
							continue;
						if (j == 31)
							continue;
						if (j == 32)
							continue;
						if (j == 33)
							continue;
						if (j == 34)
							continue;
						if (j == 35)
							continue;
						if (j == 36)
							continue;
						if (j == 37)
							continue;
						if (j == 38)
							continue;
						if (j == 39)
							continue;
						if (j == 40)
							continue;
						if (j == 41)
							continue;
						if (j == 42)
							continue;
						if (j == 43)
							continue;
						if (j == 44)
							continue;
						if (j == 45)
							continue;
						if (j == 46)
							continue;
						if (j == 47)
							continue;
						if (j == 48)
							continue;
						if (j == 49)
							continue;
						if (j == 50)
							continue;
						if (j == 51)
							continue;
						if (j == 52)
							continue;
						if (j == 53)
							continue;
						if (j == 54)
							continue;
						if (j == 55)
							continue;
						if (j == 56)
							continue;
						if (j == 57)
							continue;
						if (j == 58)
							continue;
						if (j == 59)
							continue;
						if (j == 60)
							continue;
						if (j == 61)
							continue;
						if (j == 62)
							continue;
						if (j == 63)
							continue;
						if (j == 64)
							continue;
						if (j == 65)
							continue;
						if (j == 66)
							continue;
						if (j == 67)
							continue;
						if (j == 68)
							continue;
						if (j == 69)
							continue;
						if (j == 70)
							continue;
						if (j == 71)
							continue;
						if (j == 72)
							continue;
						if (j == 73)
							continue;
						if (j == 74)
							continue;
						if (j == 75)
							continue;
						if (j == 76)
							continue;
						if (j == 77)
							continue;
						if (j == 78)
							continue;
						if (j == 79)
							continue;
						if (j == 80)
							continue;
						if (j == 81)
							continue;
						if (j == 82)
							continue;
						if (j == 83)
							continue;
						if (j == 84)
							continue;
						if (j == 85)
							continue;
						if (j == 86)
							continue;
						if (j == 87)
							continue;
						if (j == 88)
							continue;
						if (j == 89)
							continue;
						if (j == 90)
							continue;
						if (j == 91)
							continue;
						if (j == 92)
							continue;
						if (j == 93)
							continue;
						if (j == 94)
							continue;
						if (j == 95)
							continue;
						if (j == 96)
							continue;
						if (j == 97)
							continue;
						if (j == 98)
							continue;
						if (j == 99)
							continue;
						if (j == 100)
							continue;
						if (j == 101)
							continue;
						if (j == 102)
							continue;
						if (j == 103)
							continue;
						if (j == 104)
							continue;
						if (j == 105)
							continue;
						if (j == 106)
							continue;
						if (j == 107)
							continue;
						if (j == 108)
							continue;
						if (j == 109)
							continue;
						if (j == 110)
							continue;
						if (j == 111)
							continue;
						if (j == 112)
							continue;
						if (j == 113)
							continue;
						if (j == 114)
							continue;
						if (j == 115)
							continue;
						if (j == 116)
							continue;
						if (j == 117)
							continue;
						if (j == 118)
							continue;
						if (j == 119)
							continue;
						if (j == 120)
							continue;
						if (j == 121)
							continue;
						if (j == 122)
							continue;
						if (j == 123)
							continue;
						if (j == 124)
							continue;
						if (j == 125)
							continue;
						if (j == 126)
							continue;
						if (j == 127)
							continue;
						if (j == 128)
							continue;
						if (j == 129)
							continue;
						if (j == 130)
							continue;
						if (j == 131)
							continue;
						if (j == 132)
							continue;
						if (j == 133)
							continue;
						if (j == 134)
							continue;
						if (j == 135)
							continue;
						if (j == 136)
							continue;
						if (j == 137)
							continue;
						if (j == 138)
							continue;
						if (j == 139)
							continue;
						if (j == 140)
							continue;
						if (j == 141)
							continue;
						if (j == 142)
							continue;
						if (j == 143)
							continue;
						if (j == 144)
							continue;
						if (j == 145)
							continue;
						if (j == 146)
							continue;
						if (j == 147)
							continue;
						if (j == 148)
							continue;
						if (j == 149)
							continue;
						if (j == 150)
							continue;
						if (j == 151)
							continue;
						if (j == 152)
							continue;
						if (j == 153)
							continue;
						if (j == 154)
							continue;
						if (j == 155)
							continue;
						if (j == 156)
							continue;
						if (j == 157)
							continue;
						if (j == 158)
							continue;
						playerIn.dropItem(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
					}
				} else {
					for (int i = 0; i < internal.getSlots(); ++i) {
						if (i == 0)
							continue;
						if (i == 1)
							continue;
						if (i == 2)
							continue;
						if (i == 3)
							continue;
						if (i == 4)
							continue;
						if (i == 5)
							continue;
						if (i == 6)
							continue;
						if (i == 7)
							continue;
						if (i == 8)
							continue;
						if (i == 9)
							continue;
						if (i == 10)
							continue;
						if (i == 11)
							continue;
						if (i == 12)
							continue;
						if (i == 13)
							continue;
						if (i == 14)
							continue;
						if (i == 15)
							continue;
						if (i == 16)
							continue;
						if (i == 17)
							continue;
						if (i == 18)
							continue;
						if (i == 19)
							continue;
						if (i == 20)
							continue;
						if (i == 21)
							continue;
						if (i == 22)
							continue;
						if (i == 23)
							continue;
						if (i == 24)
							continue;
						if (i == 25)
							continue;
						if (i == 26)
							continue;
						if (i == 27)
							continue;
						if (i == 28)
							continue;
						if (i == 29)
							continue;
						if (i == 30)
							continue;
						if (i == 31)
							continue;
						if (i == 32)
							continue;
						if (i == 33)
							continue;
						if (i == 34)
							continue;
						if (i == 35)
							continue;
						if (i == 36)
							continue;
						if (i == 37)
							continue;
						if (i == 38)
							continue;
						if (i == 39)
							continue;
						if (i == 40)
							continue;
						if (i == 41)
							continue;
						if (i == 42)
							continue;
						if (i == 43)
							continue;
						if (i == 44)
							continue;
						if (i == 45)
							continue;
						if (i == 46)
							continue;
						if (i == 47)
							continue;
						if (i == 48)
							continue;
						if (i == 49)
							continue;
						if (i == 50)
							continue;
						if (i == 51)
							continue;
						if (i == 52)
							continue;
						if (i == 53)
							continue;
						if (i == 54)
							continue;
						if (i == 55)
							continue;
						if (i == 56)
							continue;
						if (i == 57)
							continue;
						if (i == 58)
							continue;
						if (i == 59)
							continue;
						if (i == 60)
							continue;
						if (i == 61)
							continue;
						if (i == 62)
							continue;
						if (i == 63)
							continue;
						if (i == 64)
							continue;
						if (i == 65)
							continue;
						if (i == 66)
							continue;
						if (i == 67)
							continue;
						if (i == 68)
							continue;
						if (i == 69)
							continue;
						if (i == 70)
							continue;
						if (i == 71)
							continue;
						if (i == 72)
							continue;
						if (i == 73)
							continue;
						if (i == 74)
							continue;
						if (i == 75)
							continue;
						if (i == 76)
							continue;
						if (i == 77)
							continue;
						if (i == 78)
							continue;
						if (i == 79)
							continue;
						if (i == 80)
							continue;
						if (i == 81)
							continue;
						if (i == 82)
							continue;
						if (i == 83)
							continue;
						if (i == 84)
							continue;
						if (i == 85)
							continue;
						if (i == 86)
							continue;
						if (i == 87)
							continue;
						if (i == 88)
							continue;
						if (i == 89)
							continue;
						if (i == 90)
							continue;
						if (i == 91)
							continue;
						if (i == 92)
							continue;
						if (i == 93)
							continue;
						if (i == 94)
							continue;
						if (i == 95)
							continue;
						if (i == 96)
							continue;
						if (i == 97)
							continue;
						if (i == 98)
							continue;
						if (i == 99)
							continue;
						if (i == 100)
							continue;
						if (i == 101)
							continue;
						if (i == 102)
							continue;
						if (i == 103)
							continue;
						if (i == 104)
							continue;
						if (i == 105)
							continue;
						if (i == 106)
							continue;
						if (i == 107)
							continue;
						if (i == 108)
							continue;
						if (i == 109)
							continue;
						if (i == 110)
							continue;
						if (i == 111)
							continue;
						if (i == 112)
							continue;
						if (i == 113)
							continue;
						if (i == 114)
							continue;
						if (i == 115)
							continue;
						if (i == 116)
							continue;
						if (i == 117)
							continue;
						if (i == 118)
							continue;
						if (i == 119)
							continue;
						if (i == 120)
							continue;
						if (i == 121)
							continue;
						if (i == 122)
							continue;
						if (i == 123)
							continue;
						if (i == 124)
							continue;
						if (i == 125)
							continue;
						if (i == 126)
							continue;
						if (i == 127)
							continue;
						if (i == 128)
							continue;
						if (i == 129)
							continue;
						if (i == 130)
							continue;
						if (i == 131)
							continue;
						if (i == 132)
							continue;
						if (i == 133)
							continue;
						if (i == 134)
							continue;
						if (i == 135)
							continue;
						if (i == 136)
							continue;
						if (i == 137)
							continue;
						if (i == 138)
							continue;
						if (i == 139)
							continue;
						if (i == 140)
							continue;
						if (i == 141)
							continue;
						if (i == 142)
							continue;
						if (i == 143)
							continue;
						if (i == 144)
							continue;
						if (i == 145)
							continue;
						if (i == 146)
							continue;
						if (i == 147)
							continue;
						if (i == 148)
							continue;
						if (i == 149)
							continue;
						if (i == 150)
							continue;
						if (i == 151)
							continue;
						if (i == 152)
							continue;
						if (i == 153)
							continue;
						if (i == 154)
							continue;
						if (i == 155)
							continue;
						if (i == 156)
							continue;
						if (i == 157)
							continue;
						if (i == 158)
							continue;
						playerIn.inventory.placeItemBackInInventory(playerIn.world,
								internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
					}
				}
			}
		}

		private void slotChanged(int slotid, int ctype, int meta) {
			if (this.world != null && this.world.isRemote()) {
				LanternOfTheWoodlandsMod.PACKET_HANDLER.sendToServer(new GUISlotChangedMessage(slotid, x, y, z, ctype, meta));
				handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			}
		}
	}

	public static class ButtonPressedMessage {
		int buttonID, x, y, z;

		public ButtonPressedMessage(PacketBuffer buffer) {
			this.buttonID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
		}

		public ButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.buttonID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
		}

		public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}

	public static class GUISlotChangedMessage {
		int slotID, x, y, z, changeType, meta;

		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		public GUISlotChangedMessage(PacketBuffer buffer) {
			this.slotID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
			this.changeType = buffer.readInt();
			this.meta = buffer.readInt();
		}

		public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.slotID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
			buffer.writeInt(message.changeType);
			buffer.writeInt(message.meta);
		}

		public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}

	static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CloseGUIProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
		if (buttonID == 1) {

			BasicSpell13clickHelpProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
