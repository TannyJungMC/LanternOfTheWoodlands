package tannyjung.tanscomplexmagic_core.game.screen;

import io.netty.buffer.Unpooled;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import tannyjung.tanscomplexmagic_core.game.ItemManager;
import tannyjung.tanscomplexmagic_core.outside.NetworkManager;

public class GUIManager {

    public static void open (Player player) {

        // TODO -> Delete this later
        if (player.level().isClientSide == true) return;

        MenuProvider provider = new MenuProvider() {

            @Override
            public Component getDisplayName() {

                return Component.literal("test");

            }

            @Override
            public boolean shouldTriggerClientSideContainerClosingOnOpen() {

                return false;

            }

            @Override
            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {

                return new GUIContainer(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(player.blockPosition()));

            }

        };

        player.openMenu(provider, player.blockPosition());
        NetworkManager.runServerCore(player, "nbt", "sync_all", new CompoundTag());
        GUIScreen.item = ItemStack.EMPTY;

    }

    public static void close (Player player) {

        player.closeContainer();

    }

}
