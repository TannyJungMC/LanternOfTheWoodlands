package tannyjung.tanscomplexmagic_core.game.screen;

import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_handcode.core.GUIs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GUIManager {

    public static void open (ServerPlayer player_server, String group, String name) {

        MenuProvider provider = new MenuProvider() {

            @Override
            public Component getDisplayName () {

                return Component.literal(Core.mod_name + " - GUI");

            }

            @Override
            public boolean shouldTriggerClientSideContainerClosingOnOpen () {

                return false;

            }

            @Override
            public AbstractContainerMenu createMenu (int id, Inventory inventory, Player player) {

                return new GUIContainer(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(player.blockPosition()));

            }

        };

        NBTManager.Mob.setText(player_server, "gui", "group", group);
        NBTManager.Mob.setText(player_server, "gui", "name", name);
        player_server.openMenu(provider, player_server.blockPosition());

    }

    public static void close (Player player) {

        player.closeContainer();

    }

    public static class Storage {

        private static final Map<String, LinkedHashMap<String, Integer>> map_number = new HashMap<>();
        private static final Map<String, LinkedHashMap<String, Runnable>> map_data = new HashMap<>();

        public static void refresh () {

            map_number.clear();
            map_data.clear();
            GUIs.add();

        }

        public static void draw (String group, String name) {

            Map<String, Runnable> data = map_data.get(group);

            if (data == null) {

                return;

            }

            Runnable runnable = data.get(name);

            if (runnable == null) {

                return;

            }

            runnable.run();

        }

        public static void add (String group, String name, Runnable runnable) {

            LinkedHashMap<String, Integer> get_number = map_number.get(group);

            if (get_number == null) {

                get_number = new LinkedHashMap<>();
                map_number.put(group, get_number);
                map_data.put(group, new LinkedHashMap<>());

            }

            get_number.put(name, get_number.size() + 1);
            map_data.get(group).put(name, runnable);

        }

        public static int getNumber (String group, String name) {

            LinkedHashMap<String, Integer> number = map_number.get(group);

            if (number == null) {

                return 0;

            }

            return number.get(name);

        }

        public static String getNamePrevious (String group, String name) {

            LinkedHashMap<String, Runnable> data = map_data.get(group);

            if (data == null) {

                return "";

            }

            String previous = "";

            for (Map.Entry<String, Runnable> entry : data.entrySet()) {

                if (entry.getKey().equals(name) == false) {

                    previous = entry.getKey();

                } else {

                    return previous;

                }

            }

            return "";

        }

        public static String getNameNext (String group, String name) {

            LinkedHashMap<String, Runnable> data = map_data.get(group);

            if (data == null) {

                return "";

            }

            boolean test = false;

            for (Map.Entry<String, Runnable> entry : data.entrySet()) {

                if (test == true) {

                    return entry.getKey();

                }

                if (entry.getKey().equals(name) == true) {

                    test = true;

                }

            }

            return "";

        }

    }

}
