package tannyjung.tanscomplexmagic_handcode.core;

import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.ScreenDrawing;

public class Overlays {
    
    public static void eventMenu () {



    }

    public static void eventInGame () {

        {

            if (NBTManager.Mob.getLogic(ScreenDrawing.player_local, "spell1", "is_overlay_enable") == true) {

                ScreenDrawing.Position.set(ScreenDrawing.Anchor.Type.CENTER_LEFT, 20, -50);
                ScreenDrawing.ComponentOverlay.drawTextBasic(0.5, "Hello World");

            }

        }

    }

}
