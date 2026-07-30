package tannyjung.tanscomplexmagic_handcode.core;

import org.lwjgl.glfw.GLFW;
import tannyjung.tanscomplexmagic_core.game.KeyBindingMaker;

public class KeyBindings {

    public static void add () {

        KeyBindingMaker.add("Main Key", GLFW.GLFW_KEY_LEFT_ALT, false, true, "key", "test");
        KeyBindingMaker.add("Test", GLFW.GLFW_MOUSE_BUTTON_LEFT, false, true, "key", "test");
        KeyBindingMaker.add("Test 2", GLFW.GLFW_MOUSE_BUTTON_MIDDLE, false, true, "key", "test");
        KeyBindingMaker.add("Test 3", GLFW.GLFW_MOUSE_BUTTON_RIGHT, false, true, "key", "test");

    }

}
