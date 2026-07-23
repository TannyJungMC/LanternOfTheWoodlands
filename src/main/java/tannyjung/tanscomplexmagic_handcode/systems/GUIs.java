package tannyjung.tanscomplexmagic_handcode.systems;

import tannyjung.tanscomplexmagic_core.game.GUIMaker;
import tannyjung.tanscomplexmagic_core.game.NBTManager;

public class GUIs {

    public static void create (GUIMaker manager, String gui, String component) {

        if (gui.equals("test") == true) {

            {

                if (component.equals("Text") == true) {

                    // GUIManager.Components.Text.add(160, 32, 1.0, "§6Test Number -> " + GameUtils.Data.getEntityNumber(manager.player, "number"));
                    GUIMaker.Components.Text.add(128, -36, 1.0, "§fShow");
                    GUIMaker.Components.Text.add(128, -52, 1.0, "§fBig Size");
                    GUIMaker.Components.Text.add(128, -68, 1.0, "§fReadable");

                    String effect = "§a§l";
                    double size = 1.0;

                    if (NBTManager.getEntityLogic(manager.player, "readable") == false) effect = "§6§k§l";
                    if (NBTManager.getEntityLogic(manager.player, "size") == true) size = 2.0;
                    if (NBTManager.getEntityLogic(manager.player, "show") == true) GUIMaker.Components.Text.add(160, 60, size, effect + "❤ You can now read this ❤");

                } else if (component.equals("ButtonExecute") == true) {

                    // GUIManager.Components.ButtonExecute.add(manager, 32, -68, 64, 16, 1, "Done");

                } else if (component.equals("Switch") == true) {

                    GUIMaker.Components.Switch.add(manager, 64, -32, "show");
                    GUIMaker.Components.Switch.add(manager, 64, -48, "size");
                    GUIMaker.Components.Switch.add(manager, 64, -64, "readable");

                }

            }

        }

    }

}
