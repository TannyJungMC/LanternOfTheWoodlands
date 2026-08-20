package tannyjung.tanscomplexmagic_handcode.core;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import org.lwjgl.glfw.GLFW;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.EntityManager;
import tannyjung.tanscomplexmagic_core.game.GameUtils;
import tannyjung.tanscomplexmagic_core.game.KeyBindingMaker;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_handcode.systems.Spell1;
import tannyjung.tanscomplexmagic_handcode.systems.Utils;

public class KeyBindings {

    public static void add () {

        // Main
        {

            KeyBindingMaker.Create.keyPushRelease("Main Key", GLFW.GLFW_KEY_LEFT_ALT, () -> {

                {

                    ServerPlayer player_server = KeyBindingMaker.Create.player_server;
                    NBTManager.Mob.setLogic(player_server, "main", "is_main_key_active", true, false);

                }

            }, () -> {

                {

                    ServerPlayer player_server = KeyBindingMaker.Create.player_server;
                    NBTManager.Mob.setLogic(player_server, "main", "is_main_key_active", false, false);

                }

            });

        }

        // Spell 1
        {

            KeyBindingMaker.Create.keyBasic("Spell 1 : Activate", GLFW.GLFW_KEY_1, () -> {

                {

                    ServerLevel level_server = KeyBindingMaker.Create.level_server;
                    ServerPlayer player_server = KeyBindingMaker.Create.player_server;

                    if (NBTManager.Mob.getLogic(player_server, "spell1", "is_active") == true) {

                        NBTManager.Mob.setLogic(player_server, "spell1", "is_active", false, false);
                        Spell1.activate(level_server, player_server);

                        GameUtils.playSound(level_server, player_server.blockPosition(), 1.5, 10, "minecraft:block.note_block.chime");

                        Core.DelayedWork.create(false, 3, () -> {

                            GameUtils.playSound(level_server, player_server.blockPosition(), 2, 10, "minecraft:block.note_block.chime");

                        });

                    } else {

                        NBTManager.Mob.setLogic(player_server, "spell1", "is_active", true, false);

                        System.out.println(NBTManager.Mob.getLogic(player_server, "spell1", "is_active"));


                        Spell1.deactivate(level_server, player_server);

                        for (Entity entity : EntityManager.Population.getEverywhereStatic(level_server, "", "", Utils.Tag.convertSystemAll(player_server))) {

                            entity.discard();

                        }

                        GameUtils.playSound(level_server, player_server.blockPosition(), 1, 20, "minecraft:block.note_block.chime");

                        Core.DelayedWork.create(false, 3, () -> {

                            GameUtils.playSound(level_server, player_server.blockPosition(), 0.5, 20, "minecraft:block.note_block.chime");

                        });

                    }

                }

            });

            KeyBindingMaker.Create.keyBasic("Spell 1 : Pause All Cards", GLFW.GLFW_KEY_2, () -> {

                {

                    ServerLevel level_server = KeyBindingMaker.Create.level_server;
                    ServerPlayer player_server = KeyBindingMaker.Create.player_server;

                    boolean value = NBTManager.Mob.getLogic(player_server, "spell1", "is_pause_all") == false;
                    NBTManager.Mob.setLogic(player_server, "spell1", "is_pause_all", value, true);
                    double pitch = 0.0;

                    if (value == true) {

                        pitch = 1.75;

                    } else {

                        pitch = 1.25;

                    }

                    GameUtils.playSound(level_server, player_server.blockPosition(), pitch, 10, "minecraft:block.note_block.bell");

                }

            });

        }

    }

}
