package tannyjung.tanscomplexmagic_handcode.systems;

import tannyjung.tanscomplexmagic_core.game.GUIManager;

public class GUIs {

    public static void createText (String gui) {

        if (gui.equals("test") == true) {

            GUIManager.Components.addText(160, 0, 0.75, "§cText Static -> " + Math.random());

        }

    }

    public static void createTextDynamic (String gui) {

        if (gui.equals("test") == true) {

            GUIManager.Components.addTextDynamic(160, 16, 0.75, "§6Text Dynamic -> " + Math.random());

        }

    }

    public static String test1 = "OFF";

    public static void createButton (String gui) {

        if (gui.equals("test") == true) {

            if (GUIs.test1.equals("ON") == true) {
                GUIs.test1 = "OFF";
            } else {
                GUIs.test1 = "ON";
            }

            GUIManager.Components.addButton(128, -48, 32, 16, 1, test1);
            GUIManager.Components.addButton(32, -68, 64, 16, 5, "Done");
            GUIManager.Components.addButton(-32, -68, 64, 16, 6, "Cancel");

        }

    }

}
