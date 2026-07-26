package tannyjung.tanscomplexmagic_handcode.systems;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import tannyjung.tanscomplexmagic_core.game.screen.GUIScreen;
import tannyjung.tanscomplexmagic_core.game.NBTManager;
import tannyjung.tanscomplexmagic_core.game.screen.ScreenDrawing;

public class GUIs {

    public static void render (GUIScreen screen, GuiGraphics graphic, int id, String type) {

        // Global
        {

            if (type.equals("text") == true) {

                ScreenDrawing.Overlay.drawText(graphic, "", 8 * -18, 8 * -11, 0.67, false, "Page " + (int) NBTManager.getEntityNumber(screen.player, "gui", "id"));

            } else if (type.equals("image") == true) {

                ScreenDrawing.Overlay.drawImageBasic(graphic, 8 * 25, 8 * 15, 400, 240, "tanscomplexmagic:textures/screens/gui_component_background.png");

                ScreenDrawing.Overlay.drawImageSplit(graphic, 8 * -2, 8 * -11, 56, 7, true, 8, (int) Math.floor(Math.random() * 8), "tanscomplexmagic:textures/screens/gui_component_compass.png");
                ScreenDrawing.Overlay.drawImageSplit(graphic, 8 * -3, 8 * -11, 168, 7, true, 24, (int) Math.floor(Math.random() * 24), "tanscomplexmagic:textures/screens/gui_component_clock.png");

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

                    String effect = "";
                    double scale = NBTManager.getEntityNumber(screen.player, "test", "slider");
                    if (NBTManager.getEntityLogic(screen.player, "test", "readable") == false) effect = effect + "§k";
                    if (NBTManager.getEntityLogic(screen.player, "test", "size") == true) scale = 0.67;
                    if (NBTManager.getEntityLogic(screen.player, "test", "bold") == true) effect = effect + "§l";
                    if (NBTManager.getEntityLogic(screen.player, "test", "show") == true) ScreenDrawing.Overlay.drawTextParagraph(graphic, 8 * -2, 8 * 12, scale, 160, effect + NBTManager.getEntityText(screen.player, "test", "box"));
                    if (NBTManager.getEntityLogic(screen.player, "test", "show") == true) ScreenDrawing.Overlay.drawTextParagraph(graphic, 8 * -2, 8 * 3, scale, 160, effect + NBTManager.getEntityText(screen.player, "test", "box"));

                } else if (type.equals("image") == true) {



                } else if (type.equals("widget") == true) {

                    ScreenDrawing.GUI.drawTextBox(screen, 8 * 22, 8 * 13, "test", "box");

                    ScreenDrawing.GUI.drawSwitch(screen, 8 * 22, 8 * 10, "test", "show", "Show");
                    ScreenDrawing.GUI.drawSwitch(screen, 8 * 22, 8 * 9, "test", "size", "Big Size");
                    ScreenDrawing.GUI.drawSwitch(screen, 8 * 22, 8 * 8, "test", "bold", "Bold");
                    ScreenDrawing.GUI.drawSwitch(screen, 8 * 22, 8 * 7, "test", "readable", "Readable");
                    ScreenDrawing.GUI.drawSwitch(screen, 8 * 22, 8 * 6, "test", "special", "Special");

                    ScreenDrawing.GUI.drawButtonBasic(screen, 8 * 22, 8 * 5, 8 * 20, "§fSend to Chat", "server_core", "gui", "button");
                    ScreenDrawing.GUI.drawButtonLockable(screen, 8 * 22, 8 * 3, 8 * 20, NBTManager.getEntityLogic(screen.player, "test", "special") == false, "§cTurn on special to unlock this option", "§fGet Small Support Station with 10 Mana", "server_core", "gui", "button");

                    ScreenDrawing.GUI.drawSlider(screen, 8 * -2, 8 * -8, 160, 8, 0.5, 1.0, 0.01, "test", "slider", "Font Scale " + NBTManager.getEntityNumber(screen.player, "test", "slider"));

                }

            }

        } else if (id == 2) {

            {

                if (type.equals("text") == true) {

                    ScreenDrawing.Overlay.drawText(graphic, "", 8 * -2, 8 * -5, 0.67, false, "Hello this is second page of this big book");

                } else if (type.equals("image") == true) {

                    ScreenDrawing.Overlay.drawImageOnline(graphic, 8 * 22, 8 * 12, 160, 160, "https://i1.sndcdn.com/artworks-gUQT4s0ygfyktcMf-yWJuPw-t1080x1080.jpg", "", "");

                }

            }

        }

    }

}
