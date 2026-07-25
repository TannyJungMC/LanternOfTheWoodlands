package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.client.gui.GuiGraphics;
import tannyjung.tanscomplexmagic_core.game.screen.GUIMisc;
import tannyjung.tanscomplexmagic_core.game.screen.GUIScreen;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.ScreenDrawing;

public class GUIs {

    public static void render (GUIScreen screen, GuiGraphics graphic, String gui, String type) {

        // Global
        {

            if (type.equals("widget") == true) {

                ScreenDrawing.GUI.drawButtonClientRunnable(screen, -202, -104, 10, 16, ">", () -> {

                    GUIMisc.close(screen.player);

                });

            }

        }

        if (gui.equals("test") == true) {

            {

                if (type.equals("text") == true) {

                    ScreenDrawing.Basic.drawText(graphic, "", 165, -50 - 3, 0.6, false, "Show");
                    ScreenDrawing.Basic.drawText(graphic, "", 165, -60 - 3, 0.6, false, "Big Size");
                    ScreenDrawing.Basic.drawText(graphic, "", 165, -70 - 3, 0.6, false, "Bold");
                    ScreenDrawing.Basic.drawText(graphic, "", 165, -80 - 3, 0.6, false, "Readable");

                    ScreenDrawing.Basic.drawText(graphic, "", 128, -35 - 3, 0.6, true, "§fSend Message to Chat");




                    ScreenDrawing.Basic.drawText(graphic, "", 180, 45, 0.6, false, "I'm not sure is this too hard to read, or not. Hope you");
                    ScreenDrawing.Basic.drawText(graphic, "", 180, 35, 0.6, false, "can read this without eyes attack. This is normal font");
                    ScreenDrawing.Basic.drawText(graphic, "", 180, 25, 0.6, false, "with scale 60%, not too small to unreadable and not too");
                    ScreenDrawing.Basic.drawText(graphic, "", 180, 15, 0.6, false, "big then not fit the book.");



                    String effect = "";
                    double size = 0.6;

                    if (NBTManager.getEntityLogic(screen.player, "gui", "readable") == false) effect = effect + "§k";
                    if (NBTManager.getEntityLogic(screen.player, "gui", "size") == true) size = 2.0;
                    if (NBTManager.getEntityLogic(screen.player, "gui", "bold") == true) effect = effect + "§l";
                    if (NBTManager.getEntityLogic(screen.player, "gui", "show") == true) ScreenDrawing.Basic.drawText(graphic, "", 180, 80, size, false, effect + NBTManager.getEntityText(screen.player, "gui", "box"));

                } else if (type.equals("image") == true) {

                    // ScreenDrawing.drawImage(graphic, true, "https://media.forgecdn.net/attachments/1628/396/2026-04-12_21.png", "tanscomplexmagic:textures/screens/background_book.png", "", 0, 0, 248, 288, 1, 1, 1);
                    ScreenDrawing.Basic.drawImage(graphic, false, "tanscomplexmagic:textures/screens/background_book.png", "tanscomplexmagic:textures/screens/background_book.png", "", -200, -120, 400, 240, 1, 1, 1);

                } else if (type.equals("widget") == true) {

                    ScreenDrawing.GUI.drawSwitch(screen, 180, -50, "show");
                    ScreenDrawing.GUI.drawSwitch(screen, 180, -60, "size");
                    ScreenDrawing.GUI.drawSwitch(screen, 180, -70, "bold");
                    ScreenDrawing.GUI.drawSwitch(screen, 180, -80, "readable");

                    ScreenDrawing.GUI.drawButtonNetwork(screen, 180, -35, 170, 10, "", "button");

                    ScreenDrawing.GUI.drawTextBox(screen, 180, -10, "box");

                }

            }

        }

    }

}
