package tannyjung.tanscomplexmagic_core.game;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.outside.NetworkManager;

import java.util.HashMap;
import java.util.Map;

public class KeyBindingMaker {

    public static Map<String, KeyMapping> keys = new HashMap<>();

    public static void add (String name, int glfw, boolean is_continuously, boolean is_network_server, String network_type, String network_work) {

        KeyMapping key = new KeyMapping(name, glfw, Core.mod_name) {

            private boolean pause = false;

            @Override
            public void setDown (boolean is_down) {

                super.setDown(is_down);

                if (is_down == true) {

                    if (pause == true) {

                        return;

                    }

                    if (is_continuously == false) {

                        pause = true;

                    }

                    if (is_network_server == true) {

                        NetworkManager.runServer(Minecraft.getInstance().player, network_type, network_work, new CompoundTag());

                    } else {

                        NetworkManager.runClient(Minecraft.getInstance().player, network_type, network_work, new CompoundTag());

                    }

                } else {

                    if (pause == true) {

                        pause = false;

                    }

                }

            }

        };

        keys.put(name, key);

    }

    public static void tick () {

        for (Map.Entry<String, KeyMapping> entry : keys.entrySet()) {

            entry.getValue().consumeClick();

        }

    }

}
