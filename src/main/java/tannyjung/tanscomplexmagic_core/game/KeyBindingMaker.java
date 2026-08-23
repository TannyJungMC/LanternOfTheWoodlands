package tannyjung.tanscomplexmagic_core.game;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.lwjgl.glfw.GLFW;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.outside.NetworkManager;

import java.util.HashMap;
import java.util.Map;

public class KeyBindingMaker {

    public static ServerLevel level_server = null;
    public static ServerPlayer player_server = null;

    public static class Create {

        public static void keyBasic (String name, int glfw, Runnable runnable) {

            Storage.add(name, glfw, runnable, null, null);

        }

        public static void keyPushRelease (String name, int glfw, Runnable runnable_push, Runnable runnable_release) {

            Storage.add(name, glfw, runnable_push, runnable_release, null);

        }

        public static void keyPushReleaseContinuously (String name, int glfw, Runnable runnable_push, Runnable runnable_release, Runnable runnable_continuously) {

            Storage.add(name, glfw, runnable_push, runnable_release, runnable_continuously);

        }

        public static void keyContinuously (String name, int glfw, Runnable runnable) {

            Storage.add(name, glfw, null, null, runnable);

        }

    }

    public static class Storage {

        public static Map<String, KeyMapping> keys = new HashMap<>();

        public static void tick () {

            for (Map.Entry<String, KeyMapping> entry : keys.entrySet()) {

                entry.getValue().consumeClick();

            }

        }

        private static void add (String name, int glfw, Runnable runnable_push, Runnable runnable_release, Runnable runnable_continuously) {

            InputConstants.Type type = null;

            if (glfw <= 8) {

                type = InputConstants.Type.MOUSE;

            } else {

                type = InputConstants.Type.KEYSYM;

            }

            KeyMapping key = new KeyMapping(name, type, glfw, Core.mod_name) {

                private boolean pause = false;

                @Override
                public void setDown (boolean is_down) {

                    if (is_down == true) {

                        if (pause == false) {

                            pause = true;

                            if (runnable_push != null) {

                                runnable_push.run();

                            }

                        } else {

                            if (runnable_continuously != null) {

                                runnable_continuously.run();

                            }

                        }

                    } else {

                        if (pause == true) {

                            pause = false;

                            if (runnable_release != null) {

                                runnable_release.run();

                            }

                        }

                    }

                    super.setDown(is_down);

                }

            };

            keys.put(name, key);

        }

    }

}
