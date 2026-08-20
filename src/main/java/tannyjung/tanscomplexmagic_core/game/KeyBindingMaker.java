package tannyjung.tanscomplexmagic_core.game;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.outside.NetworkManager;

import java.util.HashMap;
import java.util.Map;

public class KeyBindingMaker {

    public static class Create {

        public static ServerLevel level_server = null;
        public static ServerPlayer player_server = null;

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

        private static final Map<String, Runnable> work_push = new HashMap<>();
        private static final Map<String, Runnable> work_release = new HashMap<>();
        private static final Map<String, Runnable> work_continuously = new HashMap<>();
        public static Map<String, KeyMapping> keys = new HashMap<>();
        public static boolean is_client_side = false;

        public static void tick () {

            for (Map.Entry<String, KeyMapping> entry : keys.entrySet()) {

                entry.getValue().consumeClick();

            }

        }

        private static void add (String name, int glfw, Runnable runnable_push, Runnable runnable_release, Runnable runnable_continuously) {

            if (is_client_side == true) {

                {

                    KeyMapping key = new KeyMapping(name, glfw, Core.mod_name) {

                        private boolean pause = false;
                        private final CompoundTag tag = getTag();

                        private CompoundTag getTag () {

                            CompoundTag tag = new CompoundTag();
                            tag.putString("name", name);
                            return tag;

                        }

                        @Override
                        public void setDown (boolean is_down) {

                            String work = "";

                            if (is_down == true) {

                                if (pause == false) {

                                    pause = true;

                                    if (runnable_push != null) {

                                        work = "push";

                                    }

                                } else {

                                    if (runnable_continuously != null) {

                                        work = "continuously";

                                    }

                                }

                            } else {

                                if (pause == true) {

                                    pause = false;

                                    if (runnable_release != null) {

                                        work = "release";

                                    }

                                }

                            }

                            if (work.isEmpty() == false) {

                                NetworkManager.runServerCore(Minecraft.getInstance().player, "key", work, tag);

                            }

                            super.setDown(is_down);

                        }

                    };

                    keys.put(name, key);

                }

            } else {

                {

                    if (runnable_push != null) {

                        work_push.put(name, runnable_push);

                    }

                    if (runnable_release != null) {

                        work_release.put(name, runnable_release);

                    }

                    if (runnable_continuously != null) {

                        work_continuously.put(name, runnable_continuously);

                    }

                }

            }

        }

        public static void run (ServerPlayer player_server, String type, String name) {

            Runnable runnable = null;

            if (type.equals("push") == true) {

                runnable = work_push.get(name);

            } else if (type.equals("release") == true) {

                runnable = work_release.get(name);

            } else if (type.equals("continuously") == true) {

                runnable = work_continuously.get(name);

            }

            if (runnable == null) {

                return;

            }

            Create.level_server = player_server.serverLevel();
            Create.player_server = player_server;
            runnable.run();
            Create.level_server = null;
            Create.player_server = null;

        }

    }

}
