package tannyjung.tanscomplexmagic_handcode.core;

import org.lwjgl.glfw.GLFW;
import tannyjung.tanscomplexmagic_core.game.KeyBindingMaker;

public class KeyBindings {

    public static void add () {

        KeyBindingMaker.add("Main Key", GLFW.GLFW_KEY_LEFT_ALT, false, true, "key", "main_key");
        KeyBindingMaker.add("Test", GLFW.GLFW_KEY_1, false, true, "key", "test");

        KeyBindingMaker.add("GLFW_MOUSE_BUTTON_LEFT", GLFW.GLFW_MOUSE_BUTTON_LEFT, false, true, "key", "test");

    }

}
