package tannyjung.tanscomplexmagic_core.game.screen;

import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import tannyjung.tanscomplexmagic_core.game.NBTManager;

public class GUIMisc {

    public static void open (Player player) {

        // TODO -> Delete this later
        if (player.level().isClientSide == true) return;

        NBTManager.Network.syncAll((ServerPlayer) player);

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

                // GUIManagerContainer
                // GUIIndexMenu
                return new GUIContainer(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(player.blockPosition()));

            }

        };

        player.openMenu(provider, player.blockPosition());

    }

    public static void close (Player player) {

        player.closeContainer();

    }

}
