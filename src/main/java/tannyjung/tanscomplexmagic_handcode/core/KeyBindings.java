package tannyjung.tanscomplexmagic_handcode.core;

import net.minecraft.client.KeyMapping;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.lwjgl.glfw.GLFW;
import tannyjung.tanscomplexmagic_core.Core;
import tannyjung.tanscomplexmagic_core.game.*;
import tannyjung.tanscomplexmagic_core.outside.NetworkManager;
import tannyjung.tanscomplexmagic_handcode.systems.Book;
import tannyjung.tanscomplexmagic_handcode.systems.Spell1;
import tannyjung.tanscomplexmagic_handcode.systems.Utils;

public class KeyBindings {

    public static void add () {

        // Main
        {

            KeyBindingMaker.Create.keyPushRelease("Main Key", GLFW.GLFW_KEY_LEFT_ALT, () -> {

                NetworkManager.runServer("key", "main_push", new CompoundTag());

            }, () -> {

                NetworkManager.runServer("key", "main_release", new CompoundTag());

            });

        }

        // Spell 1
        {

            KeyBindingMaker.Create.keyBasic("Spell 1 : Activate", GLFW.GLFW_KEY_1, () -> {

                NetworkManager.runServer("key", "spell1_activate", new CompoundTag());

            });

            KeyBindingMaker.Create.keyBasic("Spell 1 : Pause All Cards", GLFW.GLFW_KEY_2, () -> {

                NetworkManager.runServer("key", "spell1_pause_all", new CompoundTag());

            });

        }

    }

}
