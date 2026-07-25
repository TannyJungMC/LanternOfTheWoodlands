package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.client.gui.GuiGraphics;
import tannyjung.tanscomplexmagic_core.game.screen.GUIScreen;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.ScreenDrawing;

public class GUIs {

    public static void render (GUIScreen screen, GuiGraphics graphic, int id, String type) {

        // Global
        {

            if (type.equals("text") == true) {

                ScreenDrawing.Overlay.drawText(graphic, "", 8 * -10, 8 * 8, 0.67, false, "Page -> " + (int) NBTManager.getEntityNumber(screen.player, "gui", "id"));

            } else if (type.equals("image") == true) {

                ScreenDrawing.Overlay.drawImageBasic(graphic, 8 * 25, 8 * 15, 400, 240, "tanscomplexmagic:textures/screens/gui_component_background.png");

                ScreenDrawing.Overlay.drawImageSplit(graphic, 8 * -2, 8 * -10, 56 * 2, 7 * 2, true, 8, (int) Math.floor(Math.random() * 8), "tanscomplexmagic:textures/screens/gui_component_compass.png");
                ScreenDrawing.Overlay.drawImageSplit(graphic, 8 * -4, 8 * -10, 168 * 2, 7 * 2, true, 24, (int) Math.floor(Math.random() * 24), "tanscomplexmagic:textures/screens/gui_component_clock.png");

            } else if (type.equals("widget") == true) {

                ScreenDrawing.GUI.drawImageButton(screen, (8 * 23) + 4, (8 * -11) - 4, 16, 32, "server", "book", "page_previous", "tanscomplexmagic:textures/screens/gui_component_page_previous.png");
                ScreenDrawing.GUI.drawImageButton(screen, (8 * -22) + 4, (8 * -11) - 4, 16, 32, "server", "book", "page_next", "tanscomplexmagic:textures/screens/gui_component_page_next.png");

                ScreenDrawing.GUI.drawImageButton(screen, 8 * 27, (8 * 12) - 0, 24, 16, "server", "book", "", "tanscomplexmagic:textures/screens/icon_home.png");
                ScreenDrawing.GUI.drawImageButton(screen, 8 * 27, (8 * 11) - 4, 24, 16, "server", "book", "", "tanscomplexmagic:textures/screens/gui_component_shortcut_ally_list.png");
                ScreenDrawing.GUI.drawImageButton(screen, 8 * 27, (8 * 10) - 8, 24, 16, "server", "book", "", "tanscomplexmagic:textures/screens/gui_component_shortcut_basic_spells.png");
                ScreenDrawing.GUI.drawImageButton(screen, 8 * 27, (8 * 9) - 12, 24, 16, "server", "book", "", "tanscomplexmagic:textures/screens/gui_component_shortcut_spell_control.png");
                ScreenDrawing.GUI.drawImageButton(screen, 8 * 27, (8 * 8) - 16, 24, 16, "server", "book", "", "tanscomplexmagic:textures/screens/gui_component_shortcut_custom.png");

            }

        }

        if (id == 1) {

            // Main
            {

                if (type.equals("text") == true) {

                    ScreenDrawing.Overlay.drawText(graphic, "", 8 * 22, 8 * 8, 0.67, false, "Oh yeah this is font with scale 67%, looks better");
                    ScreenDrawing.Overlay.drawText(graphic, "", 8 * 22, 8 * 7, 0.67, false, "than 60% one in previous screenshot. More");
                    ScreenDrawing.Overlay.drawText(graphic, "", 8 * 22, 8 * 6, 0.67, false, "readable, lower eyes attack. But it also reduces");
                    ScreenDrawing.Overlay.drawText(graphic, "", 8 * 22, 8 * 5, 0.67, false, "number of words I can write down in single line.");

                    String effect = "";
                    double scale = 0.67;
                    if (NBTManager.getEntityLogic(screen.player, "gui", "readable") == false) effect = effect + "§k";
                    if (NBTManager.getEntityLogic(screen.player, "gui", "size") == true) scale = 2.0;
                    if (NBTManager.getEntityLogic(screen.player, "gui", "bold") == true) effect = effect + "§l";
                    if (NBTManager.getEntityLogic(screen.player, "gui", "show") == true) ScreenDrawing.Overlay.drawText(graphic, "", 8 * 22, 8 * 12, scale, false, effect + NBTManager.getEntityText(screen.player, "gui", "box"));

                } else if (type.equals("image") == true) {



                } else if (type.equals("widget") == true) {

                    ScreenDrawing.GUI.drawTextBox(screen, 8 * 22, 8 * 2, "box");

                    ScreenDrawing.GUI.drawSwitch(screen, 8 * 22, 8 * -1, "show", "Show");
                    ScreenDrawing.GUI.drawSwitch(screen, 8 * 22, 8 * -2, "size", "Big Size");
                    ScreenDrawing.GUI.drawSwitch(screen, 8 * 22, 8 * -3, "bold", "Bold");
                    ScreenDrawing.GUI.drawSwitch(screen, 8 * 22, 8 * -4, "readable", "Readable");
                    ScreenDrawing.GUI.drawSwitch(screen, 8 * 22, 8 * -5, "special", "Special");

                    ScreenDrawing.GUI.drawButtonBasic(screen, 8 * 22, 8 * -6, 8 * 20, "§fSend to Chat", "server_core", "gui", "button");

                    if (NBTManager.getEntityLogic(screen.player, "gui", "special") == true) {

                        ScreenDrawing.GUI.drawButtonBasic(screen, 8 * 22, 8 * -8, 8 * 20, "§fGet Small Support Station with 10 Mana", "server_core", "gui", "button");

                    } else {

                        ScreenDrawing.GUI.drawButtonLocked(screen, 8 * 22, 8 * -8, 8 * 20, "§cTurn on special to unlock this option");

                    }

                }

            }

        } else if (id == 2) {

            {

                if (type.equals("text") == true) {

                    ScreenDrawing.Overlay.drawText(graphic, "", 8 * -2, 8 * -5, 0.67, false, "Hello this is second page of this big book");

                } else if (type.equals("image") == true) {

                    ScreenDrawing.Overlay.drawImageOnline(graphic, 8 * 22, 8 * 10, 160, 160, "https://i1.sndcdn.com/artworks-gUQT4s0ygfyktcMf-yWJuPw-t1080x1080.jpg", "", "");

                }

            }

        }

    }

}
