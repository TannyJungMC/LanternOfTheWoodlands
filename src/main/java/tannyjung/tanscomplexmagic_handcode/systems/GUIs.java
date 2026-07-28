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

                // ScreenDrawing.Overlay.drawText(graphic, "", 8 * 18, 8 * 11, ScreenDrawing.normal_font_scale, false, "Page " + (int) NBTManager.getEntityNumber(screen.player, "gui", "id"));

            } else if (type.equals("image") == true) {

                ScreenDrawing.Overlay.drawImageBasic(graphic, 8 * -25, 8 * -15, 400, 240, "tanscomplexmagic:textures/screens/gui_component_background.png");

                ScreenDrawing.Overlay.drawImageSplit(graphic, 8 * -22 - 5, 8 * 13 + 6, 56, 7, true, 8, (int) Math.floor(Math.random() * 8), "tanscomplexmagic:textures/screens/gui_component_compass.png");
                ScreenDrawing.Overlay.drawImageSplit(graphic, 8 * -23 - 5, 8 * 13 + 6, 168, 7, true, 24, (int) Math.floor(Math.random() * 24), "tanscomplexmagic:textures/screens/gui_component_clock.png");

            } else if (type.equals("widget") == true) {

                ScreenDrawing.GUI.drawImageButton(screen, (8 * -23) - 4, (8 * 11) + 4, 16, 32, true, false, "server", "book", "page_previous", "tanscomplexmagic:textures/screens/gui_component_page_previous.png");
                ScreenDrawing.GUI.drawImageButton(screen, (8 * 22) - 4, (8 * 11) + 4, 16, 32, true, false, "server", "book", "page_next", "tanscomplexmagic:textures/screens/gui_component_page_next.png");

                ScreenDrawing.GUI.drawImageButton(screen, 8 * -27, (8 * -12) + 0 , 24, 16, true, false, "server", "book", "", "tanscomplexmagic:textures/screens/icon_home.png");
                ScreenDrawing.GUI.drawImageButton(screen, 8 * -27, (8 * -11) + 4, 24, 16, true, false, "server", "book", "", "tanscomplexmagic:textures/screens/gui_component_shortcut_ally_list.png");
                ScreenDrawing.GUI.drawImageButton(screen, 8 * -27, (8 * -10) + 8, 24, 16, true, false, "server", "book", "", "tanscomplexmagic:textures/screens/gui_component_shortcut_basic_spells.png");
                ScreenDrawing.GUI.drawImageButton(screen, 8 * -27, (8 * -9) + 12, 24, 16, true, false, "server", "book", "", "tanscomplexmagic:textures/screens/gui_component_shortcut_spell_control.png");
                ScreenDrawing.GUI.drawImageButton(screen, 8 * -27, (8 * -8) + 16, 24, 16, true, false, "server", "book", "", "tanscomplexmagic:textures/screens/gui_component_shortcut_custom.png");

            }

        }

        if (id == 1) {

            // Main
            {

                boolean is_active = NBTManager.getEntityLogic(screen.player, "test", "active") == true;
                boolean is_lock = NBTManager.getEntityLogic(screen.player, "test", "lock") == true;

                if (type.equals("text") == true) {

                    ScreenDrawing.AutoLine.start(8 * -12);
                    ScreenDrawing.Overlay.drawTextParagraph(graphic, 8 * 2, 0, 160, "§" + (int) NBTManager.getEntityNumber(screen.player, "test", "color") + "   I have changed, I have changed. Just like you, just like you. For how long? For how long must I wait? I know there's something wrong. Your concrete heart isn't beating. And I've tried to make it come alive. No shadows, just red lights. Now I'm here to rescue you.");
                    ScreenDrawing.Overlay.drawTextParagraph(graphic, 8 * 2, 0, 160, "§" + (int) NBTManager.getEntityNumber(screen.player, "test", "color") + "   So silent, no violence. But inside my head, so loud and clear. You're screamin', you're screamin'. Covered up with a smile I've learned to fear. Just sunshine and blue skies. Is this all we get (Is this all we get?) for living here?. Come fire, come fire!. Let it burn and love come racing through.");
                    ScreenDrawing.Overlay.drawTextParagraph(graphic, 8 * 2, 0, 160, "§" + (int) NBTManager.getEntityNumber(screen.player, "test", "color") + "   I've learned to lose, I've learned to win. I turned my face against the wind. I will move fast, I will move slow. Take me where I have to go.");
                    ScreenDrawing.Overlay.drawTextParagraph(graphic, 8 * 2, 0, 160, "§" + (int) NBTManager.getEntityNumber(screen.player, "test", "color") + "   I'm still alive, I'm still alive. I cannot apologize, no. I'm still alive, I'm still alive. I cannot apologize, no.");
                    ScreenDrawing.AutoLine.stop();

                } else if (type.equals("widget") == true) {

                    ScreenDrawing.AutoLine.start(8 * -12);
                    ScreenDrawing.GUI.drawButtonBasic(screen, 8 * -22, 0, 160,"§fBasic Button", "server_core", "gui", "button");
                    ScreenDrawing.GUI.drawButtonLockable(screen, 8 * -22, 0, 160, is_active, is_lock, "§cLockable Button", "§fLockable Button", "server_core", "gui", "button");
                    ScreenDrawing.GUI.drawTextBoxLockable(screen, 8 * -22, 0, is_active, false, "§cTurn off lock to use this text box", "Text Box", "test", "box");
                    ScreenDrawing.GUI.drawSlider(screen, 8 * -22, 0, 1, 10, 1, is_active, false, "test", "boundary", "Attacking Radius");
                    ScreenDrawing.GUI.drawSlider(screen, 8 * -22, 0, 10, 200, 10, is_active, false, "test", "volume", "Spell Distance");
                    ScreenDrawing.GUI.drawRadio(screen, 8 * -22, 0, is_active, false, "Radio Option Style", "server_core", "radio", "Fire / Water / Earth / Nature / Wind / Light");
                    ScreenDrawing.GUI.drawSwitch(screen, 8 * -22, 0, true, false, "test", "active", "Active");
                    ScreenDrawing.GUI.drawSwitch(screen, 8 * -22, 0, true, false, "test", "lock", "Lock");
                    ScreenDrawing.GUI.drawSlider(screen, 8 * -22, 0, 60, 80, 1, true, false, "test", "size", "Font Size");
                    ScreenDrawing.AutoLine.stop();

                }

            }

        } else if (id == 2) {

            {

                if (type.equals("text") == true) {

                    ScreenDrawing.AutoLine.start(8 * -12);
                    ScreenDrawing.Overlay.drawTextParagraph(graphic, 8 * 2, 8 * -12, 160, "§" + (int) NBTManager.getEntityNumber(screen.player, "test", "color") + "   I have changed, I have changed. Just like you, just like you. For how long? For how long must I wait? I know there's something wrong. Your concrete heart isn't beating. And I've tried to make it come alive. No shadows, just red lights. Now I'm here to rescue you.");
                    ScreenDrawing.Overlay.drawTextParagraph(graphic, 8 * 2, 8 * 0, 160, "§" + (int) NBTManager.getEntityNumber(screen.player, "test", "color") + "   I'm still alive, I'm still alive. I cannot apologize, no. I'm still alive, I'm still alive. I cannot apologize, no. So silent, no violence. But inside my head, so loud and clear. You're screamin', you're screamin'. Covered up with a smile I've learned to fear. Just sunshine and blue skies. Is this all we get (Is this all we get?) for living here?. Come fire, come fire!. Let it burn and love come racing through. You might also like.");
                    ScreenDrawing.Overlay.drawTextParagraph(graphic, 8 * 2, 8 * 12, 160, "§" + (int) NBTManager.getEntityNumber(screen.player, "test", "color") + "   I have changed, I have changed. Just like you, just like you. For how long? For how long must I wait? I know there's something wrong.");
                    ScreenDrawing.AutoLine.stop();

                } else if (type.equals("image") == true) {

                    ScreenDrawing.Overlay.drawImageOnline(graphic, 8 * -22, 8 * -12, 160, 160, "https://i1.sndcdn.com/artworks-gUQT4s0ygfyktcMf-yWJuPw-t1080x1080.jpg", "", "");

                }

            }

        }

    }

}
